/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.service;

import cr.ac.una.admproyectos.model.Actividad;
import cr.ac.una.admproyectos.model.ActividadDto;
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
public class ActividadService {
    
    private static final Logger LOG = Logger.getLogger(ActividadService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "AdmProyectosWsPU")
    private EntityManager em;
    private EntityTransaction et;
    
    public Respuesta getActividads() {
        try {
            Query qryActividads = em.createNamedQuery("Actividad.findAll", Actividad.class);
            List<Actividad> Actividads = qryActividads.getResultList();
            List<ActividadDto> ActividadsDto = new ArrayList<>();
            for (Actividad Actividads1 : Actividads) {
                ActividadsDto.add(new ActividadDto(Actividads1));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Actividads", ActividadsDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Actividades con los criterios ingresados.", "getActividads NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Actividad.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Actividad.", "getActividads " + ex.getMessage());
        }
    }
    
    public Respuesta guardarActividad(ActividadDto ActividadDto) {
        try {
            Actividad Actividad;
            if (ActividadDto.getActId() != null && ActividadDto.getActId() > 0) {
                Actividad = em.find(Actividad.class, ActividadDto.getActId());

                if (Actividad == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Actividad a modificar.", "guardarActividad NoResultException");
                }

                Actividad.actualizarActividad(ActividadDto);
                Actividad = em.merge(Actividad);

            } else {
                Actividad = new Actividad(ActividadDto);
                em.persist(Actividad);
            }
            
            
            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Actividad", new ActividadDto(Actividad));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Actividad.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Actividad.", "guardarActividad " + ex.getMessage());
        }
    }

    public Respuesta eliminarActividad(Long id) {
        try {
            Actividad Actividad;
            if (id != null && id > 0) {
                Actividad = em.find(Actividad.class, id);
                if (Actividad == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el Actividad a eliminar.", "EliminarActividad NoResultException");
                }
                em.remove(Actividad);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Actividad a eliminar.", "EliminarActividad NoResultException");
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el Actividad porque tiene relaciones con otros registros.", "EliminarActividad " + ex.getMessage());
            }
            Logger.getLogger(ActividadService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Actividad.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar la Actividad.", "EliminarActividad " + ex.getMessage());
        }
    }
}
