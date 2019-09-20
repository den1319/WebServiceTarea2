/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
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
    private BigDecimal admId;
    private String aDMNombre;
    private String aDMPApellido;
    private String aDMSApellido;
    private String aDMCedula;
    private String aDMCorreo;
    private String aDMUsuario;
    private String aDMContrasena;
    private String aDMEstado;
    
    public AdministradorDto(){
    }
    
    public AdministradorDto(Administrador administrador){
        this.admId=administrador.getAdmId();
        this.aDMNombre= administrador.getADMNombre();
        this.aDMPApellido= administrador.getADMPApellido();
        this.aDMSApellido=administrador.getADMSApellido();
        this.aDMCedula = administrador.getADMCedula();
        this.aDMCorreo = administrador.getADMCorreo();
        this.aDMContrasena = administrador.getADMContrasena();
        this.aDMEstado = administrador.getADMEstado();
        this.aDMUsuario = administrador.getADMUsuario();
    }

    public BigDecimal getAdmId() {
        return admId;
    }

    public void setAdmId(BigDecimal admId) {
        this.admId = admId;
    }

    public String getaDMNombre() {
        return aDMNombre;
    }

    public void setaDMNombre(String aDMNombre) {
        this.aDMNombre = aDMNombre;
    }

    public String getaDMPApellido() {
        return aDMPApellido;
    }

    public void setaDMPApellido(String aDMPApellido) {
        this.aDMPApellido = aDMPApellido;
    }

    public String getaDMSApellido() {
        return aDMSApellido;
    }

    public void setaDMSApellido(String aDMSApellido) {
        this.aDMSApellido = aDMSApellido;
    }

    public String getaDMCedula() {
        return aDMCedula;
    }

    public void setaDMCedula(String aDMCedula) {
        this.aDMCedula = aDMCedula;
    }

    public String getaDMCorreo() {
        return aDMCorreo;
    }

    public void setaDMCorreo(String aDMCorreo) {
        this.aDMCorreo = aDMCorreo;
    }

    public String getaDMUsuario() {
        return aDMUsuario;
    }

    public void setaDMUsuario(String aDMUsuario) {
        this.aDMUsuario = aDMUsuario;
    }

    public String getaDMContrasena() {
        return aDMContrasena;
    }

    public void setaDMContrasena(String aDMContrasena) {
        this.aDMContrasena = aDMContrasena;
    }

    public String getaDMEstado() {
        return aDMEstado;
    }

    public void setaDMEstado(String aDMEstado) {
        this.aDMEstado = aDMEstado;
    }

    @Override
    public String toString() {
        return "AdministradorDto{" + "admId=" + admId + ", aDMNombre=" + aDMNombre + ", aDMPApellido=" + aDMPApellido + ", aDMSApellido=" + aDMSApellido + ", aDMCedula=" + aDMCedula + ", aDMCorreo=" + aDMCorreo + ", aDMUsuario=" + aDMUsuario + ", aDMContrasena=" + aDMContrasena + ", aDMEstado=" + aDMEstado + '}';
    }
    
    
}
