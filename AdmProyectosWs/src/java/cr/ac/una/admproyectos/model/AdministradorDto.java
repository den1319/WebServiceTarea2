/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gera1
 */

@XmlRootElement(name="AdministradorDto")
@XmlAccessorType(XmlAccessType.FIELD)

public class AdministradorDto {
    private Long admId;
    private String AdmNombre;
    private String AdmPApellido;
    private String AdmSApellido;
    private String AdmCedula;
    private String AdmCorreo;
    private String AdmUsuario;
    private String AdmContrasena;
    private String AdmEstado;
    private Long AdmVersion;
    public AdministradorDto(){
    }
    
    public AdministradorDto(Administrador administrador){
        this.admId=administrador.getAdmId();
        this.AdmNombre= administrador.getAdmNombre();
        this.AdmPApellido= administrador.getAdmPapellido();
        this.AdmSApellido=administrador.getAdmSapellido();
        this.AdmCedula = administrador.getAdmCedula();
        this.AdmCorreo = administrador.getAdmCorreo();
        this.AdmContrasena = administrador.getAdmContrasena();
        this.AdmEstado = administrador.getAdmEstado();
        this.AdmUsuario = administrador.getAdmUsuario();
        this.AdmVersion = administrador.getAdmVersion();
    }

    public Long getAdmVersion() {
        return AdmVersion;
    }

    public void setAdmVersion(Long AdmVersion) {
        this.AdmVersion = AdmVersion;
    }

    public Long getAdmId() {
        return admId;
    }

    public void setAdmId(Long admId) {
        this.admId = admId;
    }

    public String getAdmNombre() {
        return AdmNombre;
    }

    public void setAdmNombre(String AdmNombre) {
        this.AdmNombre = AdmNombre;
    }

    public String getAdmPApellido() {
        return AdmPApellido;
    }

    public void setAdmPApellido(String AdmPApellido) {
        this.AdmPApellido = AdmPApellido;
    }

    public String getAdmSApellido() {
        return AdmSApellido;
    }

    public void setAdmSApellido(String AdmSApellido) {
        this.AdmSApellido = AdmSApellido;
    }

    public String getAdmCedula() {
        return AdmCedula;
    }

    public void setAdmCedula(String AdmCedula) {
        this.AdmCedula = AdmCedula;
    }

    public String getAdmCorreo() {
        return AdmCorreo;
    }

    public void setAdmCorreo(String AdmCorreo) {
        this.AdmCorreo = AdmCorreo;
    }

    public String getAdmUsuario() {
        return AdmUsuario;
    }

    public void setAdmUsuario(String AdmUsuario) {
        this.AdmUsuario = AdmUsuario;
    }

    public String getAdmContrasena() {
        return AdmContrasena;
    }

    public void setAdmContrasena(String AdmContrasena) {
        this.AdmContrasena = AdmContrasena;
    }

    public String getAdmEstado() {
        return AdmEstado;
    }

    public void setAdmEstado(String AdmEstado) {
        this.AdmEstado = AdmEstado;
    }

    @Override
    public String toString() {
        return "AdministradorDto{" + "admId=" + admId + ", AdmNombre=" + AdmNombre + ", AdmPApellido=" + AdmPApellido + ", AdmSApellido=" + AdmSApellido + ", AdmCedula=" + AdmCedula + ", AdmCorreo=" + AdmCorreo + ", AdmUsuario=" + AdmUsuario + ", AdmContrasena=" + AdmContrasena + ", AdmEstado=" + AdmEstado + '}';
    }
    
    
}
