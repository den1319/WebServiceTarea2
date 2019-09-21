/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JORDI RODRIGUEZ
 */
@Entity
@Table(name = "ADP_TB_Proyectos", schema="UNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByPryId", query = "SELECT p FROM Proyecto p WHERE p.pryId = :pryId")
    , @NamedQuery(name = "Proyecto.findByPRYNombreProyecto", query = "SELECT p FROM Proyecto p WHERE p.pRYNombreProyecto = :pRYNombreProyecto")
    , @NamedQuery(name = "Proyecto.findByPRYNomPat", query = "SELECT p FROM Proyecto p WHERE p.pRYNomPat = :pRYNomPat")
    , @NamedQuery(name = "Proyecto.findByPRYNomLiderUs", query = "SELECT p FROM Proyecto p WHERE p.pRYNomLiderUs = :pRYNomLiderUs")
    , @NamedQuery(name = "Proyecto.findByPRYNomLiderTec", query = "SELECT p FROM Proyecto p WHERE p.pRYNomLiderTec = :pRYNomLiderTec")
    , @NamedQuery(name = "Proyecto.findByPRYCorreoPat", query = "SELECT p FROM Proyecto p WHERE p.pRYCorreoPat = :pRYCorreoPat")
    , @NamedQuery(name = "Proyecto.findByPRYCorreoLU", query = "SELECT p FROM Proyecto p WHERE p.pRYCorreoLU = :pRYCorreoLU")
    , @NamedQuery(name = "Proyecto.findByPRYCorreoLT", query = "SELECT p FROM Proyecto p WHERE p.pRYCorreoLT = :pRYCorreoLT")
    , @NamedQuery(name = "Proyecto.findByPRYFechaIniPlan", query = "SELECT p FROM Proyecto p WHERE p.pRYFechaIniPlan = :pRYFechaIniPlan")
    , @NamedQuery(name = "Proyecto.findByPRYFechaFinPlan", query = "SELECT p FROM Proyecto p WHERE p.pRYFechaFinPlan = :pRYFechaFinPlan")
    , @NamedQuery(name = "Proyecto.findByPRYFechaIniReal", query = "SELECT p FROM Proyecto p WHERE p.pRYFechaIniReal = :pRYFechaIniReal")
    , @NamedQuery(name = "Proyecto.findByPRYFechaFinReal", query = "SELECT p FROM Proyecto p WHERE p.pRYFechaFinReal = :pRYFechaFinReal")
    , @NamedQuery(name = "Proyecto.findByPRYEstado", query = "SELECT p FROM Proyecto p WHERE p.pRYEstado = :pRYEstado")
    , @NamedQuery(name = "Proyecto.findByPRYVersion", query = "SELECT p FROM Proyecto p WHERE p.pRYVersion = :pRYVersion")})
public class Proyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADMPROYECTOS_PRY_ID_GENERATOR", sequenceName = "UNA.SEQ_PROYECTOS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMPROYECTOS_PRY_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "PRY_ID")
    private Long pryId;
    @Basic(optional = false)
    @Column(name = "PRY_NombreProyecto")
    private String pRYNombreProyecto;
    @Basic(optional = false)
    @Column(name = "PRY_NomPat")
    private String pRYNomPat;
    @Basic(optional = false)
    @Column(name = "PRY_NomLiderUs")
    private String pRYNomLiderUs;
    @Basic(optional = false)
    @Column(name = "PRY_NomLiderTec")
    private String pRYNomLiderTec;
    @Basic(optional = false)
    @Column(name = "PRY_CorreoPat")
    private String pRYCorreoPat;
    @Basic(optional = false)
    @Column(name = "PRY_CorreoLU")
    private String pRYCorreoLU;
    @Basic(optional = false)
    @Column(name = "PRY_CorreoLT")
    private String pRYCorreoLT;
    @Basic(optional = false)
    @Column(name = "PRY_FechaIniPlan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pRYFechaIniPlan;
    @Basic(optional = false)
    @Column(name = "PRY_FechaFinPlan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pRYFechaFinPlan;
    @Column(name = "PRY_FechaIniReal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pRYFechaIniReal;
    @Column(name = "PRY_FechaFinReal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pRYFechaFinReal;
    @Basic(optional = false)
    @Column(name = "PRY_Estado")
    private String pRYEstado;
    @Basic(optional = false)
    @Column(name = "PRY_Version")
    private Long pRYVersion;
    @OneToMany(mappedBy = "pryId", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList;
    @OneToMany(mappedBy = "pryId", fetch = FetchType.LAZY)
    private List<Actividad> actividadList;

    public Proyecto() {
    }

    public Proyecto(ProyectoDto ProyectoDto) {
        this.pryId = ProyectoDto.getPryId();
        actualizarProyecto(ProyectoDto);
    }

    public void actualizarProyecto(ProyectoDto ProyectoDto) {
        this.pRYNombreProyecto = ProyectoDto.getpRYNombreProyecto();
        this.pRYNomPat = ProyectoDto.getpRYNomPat();
        this.pRYNomLiderUs = ProyectoDto.getpRYNomLiderUs();
        this.pRYNomLiderTec = ProyectoDto.getpRYNomLiderTec();
        this.pRYCorreoPat = ProyectoDto.getpRYCorreoPat();
        this.pRYCorreoLU = ProyectoDto.getpRYCorreoLU();
        this.pRYCorreoLT = ProyectoDto.getpRYCorreoLT();
        this.pRYFechaIniPlan = Date.from(ProyectoDto.getpRYFechaIniPlan().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.pRYFechaFinPlan = Date.from(ProyectoDto.getpRYFechaFinPlan().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.pRYEstado = ProyectoDto.getpRYEstado();
        this.pRYVersion = ProyectoDto.getPryVersion();
        this.pRYFechaIniReal = Date.from(ProyectoDto.getpRYFechaIniReal().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.pRYFechaFinReal = Date.from(ProyectoDto.getpRYFechaFinReal().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
    }

    public Proyecto(Long pryId) {
        this.pryId = pryId;
    }

    public Proyecto(Long pryId, String pRYNombreProyecto, String pRYNomPat, String pRYNomLiderUs, String pRYNomLiderTec, String pRYCorreoPat, String pRYCorreoLU, String pRYCorreoLT, Date pRYFechaIniPlan, Date pRYFechaFinPlan, String pRYEstado, Long pRYVersion) {
        this.pryId = pryId;
        this.pRYNombreProyecto = pRYNombreProyecto;
        this.pRYNomPat = pRYNomPat;
        this.pRYNomLiderUs = pRYNomLiderUs;
        this.pRYNomLiderTec = pRYNomLiderTec;
        this.pRYCorreoPat = pRYCorreoPat;
        this.pRYCorreoLU = pRYCorreoLU;
        this.pRYCorreoLT = pRYCorreoLT;
        this.pRYFechaIniPlan = pRYFechaIniPlan;
        this.pRYFechaFinPlan = pRYFechaFinPlan;
        this.pRYEstado = pRYEstado;
        this.pRYVersion = pRYVersion;
    }

    public Long getPryId() {
        return pryId;
    }

    public void setPryId(Long pryId) {
        this.pryId = pryId;
    }

    public String getPRYNombreProyecto() {
        return pRYNombreProyecto;
    }

    public void setPRYNombreProyecto(String pRYNombreProyecto) {
        this.pRYNombreProyecto = pRYNombreProyecto;
    }

    public String getPRYNomPat() {
        return pRYNomPat;
    }

    public void setPRYNomPat(String pRYNomPat) {
        this.pRYNomPat = pRYNomPat;
    }

    public String getPRYNomLiderUs() {
        return pRYNomLiderUs;
    }

    public void setPRYNomLiderUs(String pRYNomLiderUs) {
        this.pRYNomLiderUs = pRYNomLiderUs;
    }

    public String getPRYNomLiderTec() {
        return pRYNomLiderTec;
    }

    public void setPRYNomLiderTec(String pRYNomLiderTec) {
        this.pRYNomLiderTec = pRYNomLiderTec;
    }

    public String getPRYCorreoPat() {
        return pRYCorreoPat;
    }

    public void setPRYCorreoPat(String pRYCorreoPat) {
        this.pRYCorreoPat = pRYCorreoPat;
    }

    public String getPRYCorreoLU() {
        return pRYCorreoLU;
    }

    public void setPRYCorreoLU(String pRYCorreoLU) {
        this.pRYCorreoLU = pRYCorreoLU;
    }

    public String getPRYCorreoLT() {
        return pRYCorreoLT;
    }

    public void setPRYCorreoLT(String pRYCorreoLT) {
        this.pRYCorreoLT = pRYCorreoLT;
    }

    public Date getPRYFechaIniPlan() {
        return pRYFechaIniPlan;
    }

    public void setPRYFechaIniPlan(Date pRYFechaIniPlan) {
        this.pRYFechaIniPlan = pRYFechaIniPlan;
    }

    public Date getPRYFechaFinPlan() {
        return pRYFechaFinPlan;
    }

    public void setPRYFechaFinPlan(Date pRYFechaFinPlan) {
        this.pRYFechaFinPlan = pRYFechaFinPlan;
    }

    public Date getPRYFechaIniReal() {
        return pRYFechaIniReal;
    }

    public void setPRYFechaIniReal(Date pRYFechaIniReal) {
        this.pRYFechaIniReal = pRYFechaIniReal;
    }

    public Date getPRYFechaFinReal() {
        return pRYFechaFinReal;
    }

    public void setPRYFechaFinReal(Date pRYFechaFinReal) {
        this.pRYFechaFinReal = pRYFechaFinReal;
    }

    public String getPRYEstado() {
        return pRYEstado;
    }

    public void setPRYEstado(String pRYEstado) {
        this.pRYEstado = pRYEstado;
    }

    public Long getPRYVersion() {
        return pRYVersion;
    }

    public void setPRYVersion(Long pRYVersion) {
        this.pRYVersion = pRYVersion;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @XmlTransient
    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pryId != null ? pryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proyecto)) {
            return false;
        }
        Proyecto other = (Proyecto) object;
        if ((this.pryId == null && other.pryId != null) || (this.pryId != null && !this.pryId.equals(other.pryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.admproyectos.model.Proyecto[ pryId=" + pryId + " ]";
    }

}
