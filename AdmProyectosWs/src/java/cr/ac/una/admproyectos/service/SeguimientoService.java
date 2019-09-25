/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.service;

import cr.ac.una.admproyectos.model.Seguimiento;
import cr.ac.una.admproyectos.model.SeguimientoDto;
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
public class SeguimientoService {
    private static final Logger LOG = Logger.getLogger(SeguimientoService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "AdmProyectosWsPU")
    private EntityManager em;
    private EntityTransaction et;
    
    public Respuesta getSeguimientos() {
        try {
            Query qrySeguimientos = em.createNamedQuery("Seguimiento.findAll", Seguimiento.class);
            List<Seguimiento> Seguimientos = qrySeguimientos.getResultList();
            List<SeguimientoDto> SeguimientosDto = new ArrayList<>();
            for (Seguimiento Seguimientos1 : Seguimientos) {
                SeguimientosDto.add(new SeguimientoDto(Seguimientos1));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Seguimiento", SeguimientosDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Seguimientos con los criterios ingresados.", "getSeguimientos NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Seguimiento.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Seguimiento.", "getSeguimientos " + ex.getMessage());
        }
    }
    
    public List<SeguimientoDto> getSeguimientosFiltro(String descripcion){
        try {
            Query qrySeguimientos = em.createNamedQuery("Seguimiento.findBySegDescripcion", Seguimiento.class);
            qrySeguimientos.setParameter("segDescripcion", "%"+descripcion+"%");
            List<SeguimientoDto> seguimientos = new ArrayList<>();
            for(Object seguimiento :qrySeguimientos.getResultList()){
                seguimientos.add(new SeguimientoDto((Seguimiento)seguimiento));
            }
            
            return seguimientos;
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el seguimiento.", ex);
            return null;
        }
    }
    
    public Respuesta guardarSeguimiento(SeguimientoDto SeguimientoDto) {
        try {
            Seguimiento Seguimiento;
            if (SeguimientoDto.getSegId() != null && SeguimientoDto.getSegId() > 0) {
                Seguimiento = em.find(Seguimiento.class, SeguimientoDto.getSegId());

                if (Seguimiento == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Seguimiento a modificar.", "guardarSeguimiento NoResultException");
                }

                Seguimiento.actualizarSeguimiento(SeguimientoDto);
                Seguimiento = em.merge(Seguimiento);

            } else {
                Seguimiento = new Seguimiento(SeguimientoDto);
                em.persist(Seguimiento);
            }
            
            
            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Seguimiento", new SeguimientoDto(Seguimiento));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Seguimiento.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Seguimiento.", "guardarSeguimiento " + ex.getMessage());
        }
    }

    public Respuesta eliminarSeguimiento(Long id) {
        try {
            Seguimiento Seguimiento;
            if (id != null && id > 0) {
                Seguimiento = em.find(Seguimiento.class, id);
                if (Seguimiento == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el Seguimiento a eliminar.", "EliminarSeguimiento NoResultException");
                }
                em.remove(Seguimiento);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Seguimiento a eliminar.", "EliminarSeguimiento NoResultException");
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el Seguimiento porque tiene relaciones con otros registros.", "EliminarSeguimiento " + ex.getMessage());
            }
            Logger.getLogger(SeguimientoService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Seguimiento.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar la Seguimiento.", "EliminarSeguimiento " + ex.getMessage());
        }
    }
}
