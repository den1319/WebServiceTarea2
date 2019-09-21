/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.service;

import cr.ac.una.admproyectos.model.Proyecto;
import cr.ac.una.admproyectos.model.ProyectoDto;
import cr.ac.una.admproyectos.util.CodigoRespuesta;
import cr.ac.una.admproyectos.util.Respuesta;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JORDI RODRIGUEZ
 */
@Stateless
@LocalBean
public class ProyectoService {
     private static final Logger LOG = Logger.getLogger(ProyectoService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "AdmProyectosWsPU")
    private EntityManager em;
    private EntityTransaction et;
    
    public Respuesta getProyectos() {
        try {
            Query qryProyectos = em.createNamedQuery("Proyecto.findAll", Proyecto.class);
            List<Proyecto> Proyectos = qryProyectos.getResultList();
            List<ProyectoDto> ProyectosDto = new ArrayList<>();
            for (Proyecto Proyectos1 : Proyectos) {
                ProyectosDto.add(new ProyectoDto(Proyectos1));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Proyectos", ProyectosDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Proyectos con los criterios ingresados.", "getProyectos NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Proyecto.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Proyecto.", "getProyectos " + ex.getMessage());
        }
    }
    
    public Respuesta guardarProyecto(ProyectoDto ProyectoDto) {
        try {
            Proyecto Proyecto;
            if (ProyectoDto.getPryId() != null && ProyectoDto.getPryId() > 0) {
                Proyecto = em.find(Proyecto.class, ProyectoDto.getPryId() );

                if (Proyecto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Proyecto a modificar.", "guardarProyecto NoResultException");
                }

                Proyecto.actualizarProyecto(ProyectoDto);
                Proyecto = em.merge(Proyecto);

            } else {
                Proyecto = new Proyecto(ProyectoDto);
                em.persist(Proyecto);
            }
            
            
            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Proyecto", new ProyectoDto(Proyecto));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Proyecto.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Proyecto.", "guardarProyecto " + ex.getMessage());
        }
    }

    public Respuesta eliminarProyecto(Long id) {
        try {
            Proyecto Proyecto;
            if (id != null && id > 0) {
                Proyecto = em.find(Proyecto.class, id);
                if (Proyecto == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el Proyecto a eliminar.", "EliminarProyecto NoResultException");
                }
                em.remove(Proyecto);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Proyecto a eliminar.", "EliminarProyecto NoResultException");
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el Proyecto porque tiene relaciones con otros registros.", "EliminarProyecto " + ex.getMessage());
            }
            Logger.getLogger(ProyectoService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Proyecto.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar la Proyecto.", "EliminarProyecto " + ex.getMessage());
        }
    }
}
