/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gera1
 */
@Entity
@Table(name = "ADP_TB_Administradores", schema = "UNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByAdmId", query = "SELECT a FROM Administrador a WHERE a.admId = :admId")
    , @NamedQuery(name = "Administrador.findByADMNombre", query = "SELECT a FROM Administrador a WHERE a.aDMNombre = :aDMNombre")
    , @NamedQuery(name = "Administrador.findByADMPApellido", query = "SELECT a FROM Administrador a WHERE a.aDMPApellido = :aDMPApellido")
    , @NamedQuery(name = "Administrador.findByADMSApellido", query = "SELECT a FROM Administrador a WHERE a.aDMSApellido = :aDMSApellido")
    , @NamedQuery(name = "Administrador.findByADMCedula", query = "SELECT a FROM Administrador a WHERE a.aDMCedula = :aDMCedula")
    , @NamedQuery(name = "Administrador.findByADMCorreo", query = "SELECT a FROM Administrador a WHERE a.aDMCorreo = :aDMCorreo")
    , @NamedQuery(name = "Administrador.findByADMUsuario", query = "SELECT a FROM Administrador a WHERE a.aDMUsuario = :aDMUsuario")
    , @NamedQuery(name = "Administrador.findByADMContrasena", query = "SELECT a FROM Administrador a WHERE a.aDMContrasena = :aDMContrasena")
    , @NamedQuery(name = "Administrador.findByADMEstado", query = "SELECT a FROM Administrador a WHERE a.aDMEstado = :aDMEstado")
    , @NamedQuery(name = "Administrador.findByADMVersion", query = "SELECT a FROM Administrador a WHERE a.aDMVersion = :aDMVersion")})
public class Administrador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADMPROYECTOS_ADM_ID_GENERATOR", sequenceName = "UNA.SEQ_ADMINISTRADORES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMPROYECTOS_ADM_ID_GENERATOR")
    
    @Basic(optional = false)
    @Column(name = "ADM_ID")
    private Long admId;
    @Basic(optional = false)
    @Column(name = "ADM_Nombre")
    private String aDMNombre;
    @Basic(optional = false)
    @Column(name = "ADM_PApellido")
    private String aDMPApellido;
    @Basic(optional = false)
    @Column(name = "ADM_SApellido")
    private String aDMSApellido;
    @Basic(optional = false)
    @Column(name = "ADM_Cedula")
    private String aDMCedula;
    @Basic(optional = false)
    @Column(name = "ADM_Correo")
    private String aDMCorreo;
    @Basic(optional = false)
    @Column(name = "ADM_Usuario")
    private String aDMUsuario;
    @Basic(optional = false)
    @Column(name = "ADM_Contrasena")
    private String aDMContrasena;
    @Basic(optional = false)
    @Column(name = "ADM_Estado")
    private String aDMEstado;
    @Basic(optional = false)
    @Column(name = "ADM_Version")
    private Long aDMVersion;

    public Administrador() {
    }

    public Administrador(Long admId) {
        this.admId = admId;
    }

    public Administrador(Long admId, String aDMNombre, String aDMPApellido, String aDMSApellido, String aDMCedula, String aDMCorreo, String aDMUsuario, String aDMContrasena, String aDMEstado) {
        this.admId = admId;
        this.aDMNombre = aDMNombre;
        this.aDMPApellido = aDMPApellido;
        this.aDMSApellido = aDMSApellido;
        this.aDMCedula = aDMCedula;
        this.aDMCorreo = aDMCorreo;
        this.aDMUsuario = aDMUsuario;
        this.aDMContrasena = aDMContrasena;
        this.aDMEstado = aDMEstado;
    }
    
    public Administrador(AdministradorDto administrador){
        this.admId = administrador.getAdmId();
        actualizarAdministrador(administrador);
    }
    
    public void actualizarAdministrador(AdministradorDto administrador){
        this.aDMNombre = administrador.getaDMNombre();
        this.aDMPApellido = administrador.getaDMPApellido();
        this.aDMSApellido = administrador.getaDMSApellido();
        this.aDMCedula = administrador.getaDMCedula();
        this.aDMCorreo = administrador.getaDMCorreo();
        this.aDMUsuario = administrador.getaDMUsuario();
        this.aDMContrasena = administrador.getaDMContrasena();
        this.aDMEstado = administrador.getaDMEstado();
    }

    public Long getAdmId() {
        return admId;
    }

    public void setAdmId(Long admId) {
        this.admId = admId;
    }

    public String getADMNombre() {
        return aDMNombre;
    }

    public void setADMNombre(String aDMNombre) {
        this.aDMNombre = aDMNombre;
    }

    public String getADMPApellido() {
        return aDMPApellido;
    }

    public void setADMPApellido(String aDMPApellido) {
        this.aDMPApellido = aDMPApellido;
    }

    public String getADMSApellido() {
        return aDMSApellido;
    }

    public void setADMSApellido(String aDMSApellido) {
        this.aDMSApellido = aDMSApellido;
    }

    public String getADMCedula() {
        return aDMCedula;
    }

    public void setADMCedula(String aDMCedula) {
        this.aDMCedula = aDMCedula;
    }

    public String getADMCorreo() {
        return aDMCorreo;
    }

    public void setADMCorreo(String aDMCorreo) {
        this.aDMCorreo = aDMCorreo;
    }

    public String getADMUsuario() {
        return aDMUsuario;
    }

    public void setADMUsuario(String aDMUsuario) {
        this.aDMUsuario = aDMUsuario;
    }

    public String getADMContrasena() {
        return aDMContrasena;
    }

    public void setADMContrasena(String aDMContrasena) {
        this.aDMContrasena = aDMContrasena;
    }

    public String getADMEstado() {
        return aDMEstado;
    }

    public void setADMEstado(String aDMEstado) {
        this.aDMEstado = aDMEstado;
    }

    public Long getADMVersion() {
        return aDMVersion;
    }

    public void setADMVersion(Long aDMVersion) {
        this.aDMVersion = aDMVersion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (admId != null ? admId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Administrador)) {
            return false;
        }
        Administrador other = (Administrador) object;
        if ((this.admId == null && other.admId != null) || (this.admId != null && !this.admId.equals(other.admId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.admproyectos.model.Administrador[ admId=" + admId + " ]";
    }
    
}
