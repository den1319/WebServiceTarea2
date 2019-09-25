/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.QueryHint;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JORDI RODRIGUEZ
 */
@Entity
@Table(name = "ADP_TB_ACTIVIDADES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByActId", query = "SELECT a FROM Actividad a WHERE a.actId = :actId")
    , @NamedQuery(name = "Actividad.findByActDescripcion", query = "SELECT a FROM Actividad a WHERE a.actDescripcion = :actDescripcion")
    , @NamedQuery(name = "Actividad.findByActNomencargado", query = "SELECT a FROM Actividad a WHERE a.actNomencargado = :actNomencargado")
    , @NamedQuery(name = "Actividad.findByActEstado", query = "SELECT a FROM Actividad a WHERE a.actEstado = :actEstado")
    , @NamedQuery(name = "Actividad.findByActFechainiplan", query = "SELECT a FROM Actividad a WHERE a.actFechainiplan = :actFechainiplan")
    , @NamedQuery(name = "Actividad.findByActFechafinplan", query = "SELECT a FROM Actividad a WHERE a.actFechafinplan = :actFechafinplan")
    , @NamedQuery(name = "Actividad.findByActFechainireal", query = "SELECT a FROM Actividad a WHERE a.actFechainireal = :actFechainireal")
    , @NamedQuery(name = "Actividad.findByActFechafinreal", query = "SELECT a FROM Actividad a WHERE a.actFechafinreal = :actFechafinreal")
    , @NamedQuery(name = "Actividad.findByActVersion", query = "SELECT a FROM Actividad a WHERE a.actVersion = :actVersion")
    , @NamedQuery(name = "Actividad.findByActCorreoencargado", query = "SELECT a FROM Actividad a WHERE a.actCorreoencargado = :actCorreoencargado")
    , @NamedQuery(name = "Actividad.findByActOrden", query = "SELECT a FROM Actividad a WHERE a.actOrden = :actOrden")
    , @NamedQuery(name = "Actividad.findByEncargadoDescripcion", query = "SELECT a FROM Actividad a WHERE UPPER(a.actNomencargado) like :actNomencargado and UPPER(a.actDescripcion) like :actDescripcion", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))
})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADMPROYECTOS_ACT_ID_GENERATOR", sequenceName = "UNA.SEQ_ACTIVIDADES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMPROYECTOS_ACT_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "ACT_ID")
    private Long actId;
    @Basic(optional = false)
    @Column(name = "ACT_DESCRIPCION")
    private String actDescripcion;
    @Basic(optional = false)
    @Column(name = "ACT_NOMENCARGADO")
    private String actNomencargado;
    @Basic(optional = false)
    @Column(name = "ACT_ESTADO")
    private String actEstado;
    @Basic(optional = false)
    @Column(name = "ACT_FECHAINIPLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechainiplan;
    @Basic(optional = false)
    @Column(name = "ACT_FECHAFINPLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechafinplan;
    @Column(name = "ACT_FECHAINIREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechainireal;
    @Column(name = "ACT_FECHAFINREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actFechafinreal;
    @Basic(optional = false)
    @Column(name = "ACT_VERSION")
    private Long actVersion;
    @Basic(optional = false)
    @Column(name = "ACT_CORREOENCARGADO")
    private String actCorreoencargado;
    @Basic(optional = false)
    @Column(name = "ACT_ORDEN")
    private Long actOrden;
    @JoinColumn(name = "PRY_ID", referencedColumnName = "PRY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto pryId;

    public Actividad() {
    }

    public Actividad(Long actId) {
        this.actId = actId;
    }

    public Actividad(Long actId, String actDescripcion, String actNomencargado, String actEstado, Date actFechainiplan, Date actFechafinplan, Long actVersion, String actCorreoencargado, Long actOrden) {
        this.actId = actId;
        this.actDescripcion = actDescripcion;
        this.actNomencargado = actNomencargado;
        this.actEstado = actEstado;
        this.actFechainiplan = actFechainiplan;
        this.actFechafinplan = actFechafinplan;
        this.actVersion = actVersion;
        this.actCorreoencargado = actCorreoencargado;
        this.actOrden = actOrden;
    }
    public Actividad(ActividadDto ActividadDto) {
        this.actId = ActividadDto.getActId();
        actualizarActividad(ActividadDto);
    }

    public void actualizarActividad(ActividadDto ActividadDto) {
        this.actDescripcion = ActividadDto.getaCTDescripcion();
        this.actNomencargado = ActividadDto.getaCTNomEncargado();
        this.actEstado = ActividadDto.getaCTEstado();
        LocalDate FechaIniPlan = LocalDate.parse(ActividadDto.getaCTFechaIniPlan(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate FechaIniReal = LocalDate.parse(ActividadDto.getaCTFechaIniReal(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate FechaFinPlan = LocalDate.parse(ActividadDto.getaCTFechaFinPlan(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate FechaFinReal = LocalDate.parse(ActividadDto.getaCTFechaFinReal(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.actFechainiplan = Date.from(FechaIniPlan.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.actFechafinplan = Date.from(FechaFinPlan.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());;
        this.actFechainireal = Date.from(FechaIniReal.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.actFechafinreal = Date.from(FechaFinReal.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.actVersion = ActividadDto.getActVersion();
        this.actCorreoencargado = ActividadDto.getaCTCorreoEncargado();
        this.actOrden = ActividadDto.getaCTOrden();
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getActDescripcion() {
        return actDescripcion;
    }

    public void setActDescripcion(String actDescripcion) {
        this.actDescripcion = actDescripcion;
    }

    public String getActNomencargado() {
        return actNomencargado;
    }

    public void setActNomencargado(String actNomencargado) {
        this.actNomencargado = actNomencargado;
    }

    public String getActEstado() {
        return actEstado;
    }

    public void setActEstado(String actEstado) {
        this.actEstado = actEstado;
    }

    public Date getActFechainiplan() {
        return actFechainiplan;
    }

    public void setActFechainiplan(Date actFechainiplan) {
        this.actFechainiplan = actFechainiplan;
    }

    public Date getActFechafinplan() {
        return actFechafinplan;
    }

    public void setActFechafinplan(Date actFechafinplan) {
        this.actFechafinplan = actFechafinplan;
    }

    public Date getActFechainireal() {
        return actFechainireal;
    }

    public void setActFechainireal(Date actFechainireal) {
        this.actFechainireal = actFechainireal;
    }

    public Date getActFechafinreal() {
        return actFechafinreal;
    }

    public void setActFechafinreal(Date actFechafinreal) {
        this.actFechafinreal = actFechafinreal;
    }

    public Long getActVersion() {
        return actVersion;
    }

    public void setActVersion(Long actVersion) {
        this.actVersion = actVersion;
    }

    public String getActCorreoencargado() {
        return actCorreoencargado;
    }

    public void setActCorreoencargado(String actCorreoencargado) {
        this.actCorreoencargado = actCorreoencargado;
    }

    public Long getActOrden() {
        return actOrden;
    }

    public void setActOrden(Long actOrden) {
        this.actOrden = actOrden;
    }

    public Proyecto getPryId() {
        return pryId;
    }

    public void setPryId(Proyecto pryId) {
        this.pryId = pryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (actId != null ? actId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Actividad)) {
            return false;
        }
        Actividad other = (Actividad) object;
        if ((this.actId == null && other.actId != null) || (this.actId != null && !this.actId.equals(other.actId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.admproyectos.model.Actividad[ actId=" + actId + " ]";
    }
    
}
