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
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JORDI RODRIGUEZ
 */
@Entity
@Table(name = "ADP_TB_ADMINISTRADORES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Administrador.findAll", query = "SELECT a FROM Administrador a")
    , @NamedQuery(name = "Administrador.findByAdmId", query = "SELECT a FROM Administrador a WHERE a.admId = :admId")
    , @NamedQuery(name = "Administrador.findByAdmNombre", query = "SELECT a FROM Administrador a WHERE a.admNombre = :admNombre")
    , @NamedQuery(name = "Administrador.findByAdmPapellido", query = "SELECT a FROM Administrador a WHERE a.admPapellido = :admPapellido")
    , @NamedQuery(name = "Administrador.findByAdmSapellido", query = "SELECT a FROM Administrador a WHERE a.admSapellido = :admSapellido")
    , @NamedQuery(name = "Administrador.findByAdmCedula", query = "SELECT a FROM Administrador a WHERE a.admCedula = :admCedula")
    , @NamedQuery(name = "Administrador.findByAdmCorreo", query = "SELECT a FROM Administrador a WHERE a.admCorreo = :admCorreo")
    , @NamedQuery(name = "Administrador.findByAdmUsuario", query = "SELECT a FROM Administrador a WHERE a.admUsuario = :admUsuario")
    , @NamedQuery(name = "Administrador.findByAdmContrasena", query = "SELECT a FROM Administrador a WHERE a.admContrasena = :admContrasena")
    , @NamedQuery(name = "Administrador.findByAdmEstado", query = "SELECT a FROM Administrador a WHERE a.admEstado = :admEstado")
    , @NamedQuery(name = "Administrador.findByAdmVersion", query = "SELECT a FROM Administrador a WHERE a.admVersion = :admVersion")
    , @NamedQuery(name = "Administrador.findByUsuClave", query = "SELECT a FROM Administrador a WHERE a.admUsuario = :admUsuario and a.admContrasena = :admContrasena", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))
    , @NamedQuery(name = "Administrador.findByCedulaNombrePapellido", query = "SELECT a FROM Administrador a WHERE UPPER(a.admNombre) like :admNombre and UPPER(a.admCedula) like :admCedula and UPPER(a.admPapellido) like :admPapellido", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))
})
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
    @Column(name = "ADM_NOMBRE")
    private String admNombre;
    @Basic(optional = false)
    @Column(name = "ADM_PAPELLIDO")
    private String admPapellido;
    @Basic(optional = false)
    @Column(name = "ADM_SAPELLIDO")
    private String admSapellido;
    @Basic(optional = false)
    @Column(name = "ADM_CEDULA")
    private String admCedula;
    @Basic(optional = false)
    @Column(name = "ADM_CORREO")
    private String admCorreo;
    @Basic(optional = false)
    @Column(name = "ADM_USUARIO")
    private String admUsuario;
    @Basic(optional = false)
    @Column(name = "ADM_CONTRASENA")
    private String admContrasena;
    @Basic(optional = false)
    @Column(name = "ADM_ESTADO")
    private String admEstado;
    @Basic(optional = false)
    @Column(name = "ADM_VERSION")
    private Long admVersion;

    public Administrador() {
    }

    public Administrador(Long admId) {
        this.admId = admId;
    }
    public Administrador(AdministradorDto AdministradorDto) {
        this.admId = AdministradorDto.getAdmId();
        actualizarAdministrador(AdministradorDto);
    }
    
    public void actualizarAdministrador(AdministradorDto administrador){
        this.admNombre = administrador.getAdmNombre();
        this.admPapellido = administrador.getAdmPApellido();
        this.admSapellido = administrador.getAdmSApellido();
        this.admCedula = administrador.getAdmCedula();
        this.admCorreo = administrador.getAdmCorreo();
        this.admUsuario = administrador.getAdmUsuario();
        this.admContrasena = administrador.getAdmContrasena();
        this.admEstado = administrador.getAdmEstado();
        this.admVersion = administrador.getAdmVersion();
    }
    public Administrador(Long admId, String admNombre, String admPapellido, String admSapellido, String admCedula, String admCorreo, String admUsuario, String admContrasena, String admEstado, Long admVersion) {
        this.admId = admId;
        this.admNombre = admNombre;
        this.admPapellido = admPapellido;
        this.admSapellido = admSapellido;
        this.admCedula = admCedula;
        this.admCorreo = admCorreo;
        this.admUsuario = admUsuario;
        this.admContrasena = admContrasena;
        this.admEstado = admEstado;
        this.admVersion = admVersion;
    }

    public Long getAdmId() {
        return admId;
    }

    public void setAdmId(Long admId) {
        this.admId = admId;
    }

    public String getAdmNombre() {
        return admNombre;
    }

    public void setAdmNombre(String admNombre) {
        this.admNombre = admNombre;
    }

    public String getAdmPapellido() {
        return admPapellido;
    }

    public void setAdmPapellido(String admPapellido) {
        this.admPapellido = admPapellido;
    }

    public String getAdmSapellido() {
        return admSapellido;
    }

    public void setAdmSapellido(String admSapellido) {
        this.admSapellido = admSapellido;
    }

    public String getAdmCedula() {
        return admCedula;
    }

    public void setAdmCedula(String admCedula) {
        this.admCedula = admCedula;
    }

    public String getAdmCorreo() {
        return admCorreo;
    }

    public void setAdmCorreo(String admCorreo) {
        this.admCorreo = admCorreo;
    }

    public String getAdmUsuario() {
        return admUsuario;
    }

    public void setAdmUsuario(String admUsuario) {
        this.admUsuario = admUsuario;
    }

    public String getAdmContrasena() {
        return admContrasena;
    }

    public void setAdmContrasena(String admContrasena) {
        this.admContrasena = admContrasena;
    }

    public String getAdmEstado() {
        return admEstado;
    }

    public void setAdmEstado(String admEstado) {
        this.admEstado = admEstado;
    }

    public Long getAdmVersion() {
        return admVersion;
    }

    public void setAdmVersion(Long admVersion) {
        this.admVersion = admVersion;
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
