/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.service;

import cr.ac.una.admproyectos.model.Administrador;
import cr.ac.una.admproyectos.model.AdministradorDto;
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
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JORDI RODRIGUEZ
 */
@Stateless
@LocalBean
public class AdministradorService {
    
    private static final Logger LOG = Logger.getLogger(AdministradorService.class.getName());//imprime el error en payara
    @PersistenceContext(unitName = "AdmProyectosWsPU")
    private EntityManager em;
    private EntityTransaction et;
    
    public Respuesta validarAdministrador(String usuario, String contrasena) { 
        try {
            Query qryActividad = em.createNamedQuery("Administrador.findByUsuClave", Administrador.class);
            qryActividad.setParameter("admUsuario", usuario);
            qryActividad.setParameter("admContrasena", contrasena);

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Administrador", new AdministradorDto((Administrador) qryActividad.getSingleResult()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existe un usuario con las credenciales ingresadas.", "validarUsuario NoResultException");
        } catch (NonUniqueResultException ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario NonUniqueResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el usuario.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el usuario.", "validarUsuario " + ex.getMessage());
        }
    }
    
    public Respuesta getAdministradoresFiltro(String cedula, String nombre, String pApellido) {
        try {
            Query qryEmpleado = em.createNamedQuery("Administrador.findByCedulaNombrePapellido", Administrador.class);
            qryEmpleado.setParameter("admCedula", "%"+cedula+"%");
            qryEmpleado.setParameter("admNombre", "%"+nombre+"%");
            qryEmpleado.setParameter("admPapellido", "%"+pApellido+"%");
            List<Administrador> administradores = qryEmpleado.getResultList();
            List<AdministradorDto> administradoresDto = new ArrayList<>();
            for (Administrador administrador : administradores) {
                administradoresDto.add(new AdministradorDto(administrador));
            }

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Administrador", administradoresDto);

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen administradores con los criterios ingresados.", "getAdministradores NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el administrador.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el administrador.", "getAdministrador " + ex.getMessage());
        }
    }
    
    public Respuesta getAdministradores() {
        try {
            Query qryAdministradores = em.createNamedQuery("Administrador.findAll", Administrador.class);
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Administrador", this.convertirLista((List<Administrador>)qryAdministradores.getResultList()));

        } catch (NoResultException ex) {
            return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No existen Administradors con los criterios ingresados.", "getAdministradores NoResultException");
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al consultar el Administrador.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al consultar el Administrador.", "getAdministradores " + ex.getMessage());
        }
    }
    
    public Respuesta guardarAdministrador(AdministradorDto AdministradorDto) {
        try {
            Administrador Administrador;
            if (AdministradorDto.getAdmId() != null && AdministradorDto.getAdmId() > 0) {
                Administrador = em.find(Administrador.class, AdministradorDto.getAdmId());

                if (Administrador == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO, "No se encrontró el Administrador a modificar.", "guardarAdministrador NoResultException");
                }

                Administrador.actualizarAdministrador(AdministradorDto);
                Administrador = em.merge(Administrador);

            } else {
                Administrador = new Administrador(AdministradorDto);
                em.persist(Administrador);
            }
            
            
            em.flush();

            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "", "Administrador", new AdministradorDto(Administrador));
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Ocurrio un error al guardar el Administrador.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Ocurrio un error al guardar el Administrador.", "guardarAdministrador " + ex.getMessage());
        }
    }

    public Respuesta eliminarAdministrador(Long id) {
        try {
            Administrador Administrador;
            if (id != null && id > 0) {
                Administrador = em.find(Administrador.class, id);
                if (Administrador == null) {
                    return new Respuesta(false, CodigoRespuesta.ERROR_NOENCONTRADO,"No se encontró el Administrador a eliminar.", "EliminarAdministrador NoResultException");
                }
                em.remove(Administrador);
            } else {
                return new Respuesta(false, CodigoRespuesta.ERROR_CLIENTE, "Debe cargar el Administrador a eliminar.", "EliminarAdministrador NoResultException");
            }
            return new Respuesta(true, CodigoRespuesta.CORRECTO, "", "");
        } catch (Exception ex) {
            if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
                return new Respuesta(false, CodigoRespuesta.ERROR_PERMISOS,"No se puede eliminar el Administrador porque tiene relaciones con otros registros.", "EliminarAdministrador " + ex.getMessage());
            }
            Logger.getLogger(AdministradorService.class.getName()).log(Level.SEVERE, "Ocurrio un error al guardar el Administrador.", ex);
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO,"Ocurrio un error al eliminar el Administrador.", "EliminarAdministrador " + ex.getMessage());
        }
    }
    
    public List<AdministradorDto> convertirLista(List<Administrador> administradores){
        if(!administradores.isEmpty()){
            List<AdministradorDto> admins = new ArrayList<AdministradorDto>();
            for(Administrador admin : administradores){
                    //admproyectos.model.AdministradorDto administradorDto = new admproyectos.model.AdministradorDto(admin);
                    admins.add(new AdministradorDto(admin));
            }
            return admins;
        }else{
            return null;
        }
    }
}
