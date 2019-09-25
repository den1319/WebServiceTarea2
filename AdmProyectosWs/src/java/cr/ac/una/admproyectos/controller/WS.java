/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.controller;

import cr.ac.una.admproyectos.model.ActividadDto;
import cr.ac.una.admproyectos.model.Administrador;
import cr.ac.una.admproyectos.model.AdministradorDto;
import cr.ac.una.admproyectos.model.ProyectoDto;
import cr.ac.una.admproyectos.model.SeguimientoDto;
import cr.ac.una.admproyectos.service.ActividadService;
import cr.ac.una.admproyectos.service.AdministradorService;
import cr.ac.una.admproyectos.service.ProyectoService;
import cr.ac.una.admproyectos.service.SeguimientoService;
import cr.ac.una.admproyectos.util.CodigoRespuesta;
import cr.ac.una.admproyectos.util.Respuesta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author gera1
 */
@WebService(serviceName = "WS")
public class WS {

    @EJB
    AdministradorService AdminService;
    @EJB
    ProyectoService ProyectoService;
    @EJB
    SeguimientoService SeguimientoService;
    @EJB
    ActividadService ActividadService;

    /**
     * Web service operation
     * @param AdministradorDto
     * @return 
     */
    @WebMethod(operationName = "GuardarAministrador")
    public Respuesta GuardarAministrador(@WebParam(name = "AdministradorDto") AdministradorDto AdministradorDto) {
      try{
        Respuesta respuesta = AdminService.guardarAdministrador(AdministradorDto);
        return respuesta;
      }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Guardando el Administrador", "GuardarAdministrador" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param ID
     * @return 
     */
    @WebMethod(operationName = "EliminarAdministrador")
    public Respuesta EliminarAdministrador(@WebParam(name = "ID") long ID) {
      try{
        Respuesta respuesta = AdminService.eliminarAdministrador(ID);
        return respuesta;
         }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Eliminando el Administrador", "EliminarAdministrador" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param ProyectoDto
     * @return 
     */
    @WebMethod(operationName = "GuardarProyecto")
    public Respuesta GuardarProyecto(@WebParam(name = "ProyectoDto") ProyectoDto ProyectoDto) {
        try{
        Respuesta respuesta = ProyectoService.guardarProyecto(ProyectoDto);
        return respuesta;
      }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Guardando el Proyecto", "GuardarProyecto" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param ID
     * @return 
     */
    @WebMethod(operationName = "EliminarProyecto")
    public Respuesta EliminarProyecto(@WebParam(name = "ID") long ID) {
        try{
        Respuesta respuesta = ProyectoService.eliminarProyecto(ID);
        return respuesta;
         }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Eliminando el Proyecto", "EliminarProyecto" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param SeguimientoDto
     * @return 
     */
    @WebMethod(operationName = "GuardarSeguimiento")
    public Respuesta GuardarSeguimiento(@WebParam(name = "SeguimientoDto") SeguimientoDto SeguimientoDto) {
        try{
        Respuesta respuesta = SeguimientoService.guardarSeguimiento(SeguimientoDto);
        return respuesta;
      }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Guardando el Seguimiento", "GuardarSeguimiento" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param ID
     * @return 
     */
    @WebMethod(operationName = "EliminarSeguimiento")
    public Respuesta EliminarSeguimiento(@WebParam(name = "ID") long ID) {
         try{
        Respuesta respuesta = SeguimientoService.eliminarSeguimiento(ID);
        return respuesta;
         }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Eliminando el Seguimiento", "EliminarSeguimiento" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param ActividadDto
     * @return 
     */
    @WebMethod(operationName = "GuardarActividad")
    public Respuesta GuardarActividad(@WebParam(name = "ActividadDto") ActividadDto ActividadDto) {
        try{
        Respuesta respuesta = ActividadService.guardarActividad(ActividadDto);
        return respuesta;
      }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Guardando la Actividad", "GuardarActividad" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param ID
     * @return 
     */
    @WebMethod(operationName = "EliminarActividad")
    public Respuesta EliminarActividad(@WebParam(name = "ID") long ID) {
         try{
        Respuesta respuesta = ActividadService.eliminarActividad(ID);
        return respuesta;
         }catch(Exception ex){
            return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error Eliminando la Actividad", "EliminarActividad" + ex.getMessage());
      }
    }

    /**
     * Web service operation
     * @param usuario
     * @param contrasena
     * @return 
     */
    @WebMethod(operationName = "getAdmin")
    public Respuesta getAdmin(@WebParam(name = "usuario") String usuario, @WebParam(name = "contrasena") String contrasena) {
        try{
            Respuesta respuesta = AdminService.validarAdministrador(usuario, contrasena);
            return respuesta;
        }catch(Exception ex){
          return new Respuesta(false, CodigoRespuesta.ERROR_INTERNO, "Error validando el Administrador", "getAdmin" + ex.getMessage());
        }
    }

    /**
     * Web service operation
     * @param cedula
     * @param nombre
     * @param pApellido
     * @return 
     */
    @WebMethod(operationName = "GetAdministradoresFiltro")
    public List<AdministradorDto> GetAdministradoresFiltro(@WebParam(name = "cedula") String cedula, @WebParam(name = "nombre") String nombre, @WebParam(name = "pApellido") String pApellido) {
        try{
            return AdminService.getAdministradoresFiltro(cedula, nombre, pApellido);
        }catch(Exception ex){
            return null;
        }
    }

    /**
     * Web service operation
     * @return 
     */
    @WebMethod(operationName = "getAdmins")
    public List<AdministradorDto> getAdmins() {
        try{
            return AdminService.getAdministradores();
        }catch(Exception ex){
            return null;
        }
    }

    /**
     * Web service operation
     * @param nombre
     * @param patrocinador
     * @return 
     */
    @WebMethod(operationName = "GetProyectosFiltro")
    public List<ProyectoDto> GetProyectosFiltro(@WebParam(name = "nombre") String nombre, @WebParam(name = "patrocinador") String patrocinador) {
        try{
            return ProyectoService.getProyectosFiltro(nombre, patrocinador);//
        }catch(Exception ex){
            return null;
        }
    }

    /**
     * Web service operation
     * @param encargado
     * @param descripcion
     * @return 
     */
    @WebMethod(operationName = "GetActividadesFiltro")
    public List<ActividadDto> GetActividadesFiltro(@WebParam(name = "encargado") String encargado, @WebParam(name = "descripcion") String descripcion) {
        try{
            return ActividadService.getActividadesFiltro(encargado, descripcion);//
        }catch(Exception ex){
            return null;
        }
    }

    /**
     * Web service operation
     * @param descripcion
     * @return 
     */
    @WebMethod(operationName = "GetSeguimientosFiltro")
    public List<SeguimientoDto> GetSeguimientosFiltro(@WebParam(name = "descripcion") String descripcion) {
        try{
            return SeguimientoService.getSeguimientosFiltro(descripcion);//
        }catch(Exception ex){
            return null;
        }
    }
    
    
    
    

}
