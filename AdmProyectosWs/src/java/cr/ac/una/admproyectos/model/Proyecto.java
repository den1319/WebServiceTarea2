/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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
import javax.persistence.OneToMany;
import javax.persistence.QueryHint;
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
@Table(name = "ADP_TB_PROYECTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proyecto.findAll", query = "SELECT p FROM Proyecto p")
    , @NamedQuery(name = "Proyecto.findByPryId", query = "SELECT p FROM Proyecto p WHERE p.pryId = :pryId")
    , @NamedQuery(name = "Proyecto.findByPryNombreproyecto", query = "SELECT p FROM Proyecto p WHERE p.pryNombreproyecto = :pryNombreproyecto")
    , @NamedQuery(name = "Proyecto.findByPryNompat", query = "SELECT p FROM Proyecto p WHERE p.pryNompat = :pryNompat")
    , @NamedQuery(name = "Proyecto.findByPryNomliderus", query = "SELECT p FROM Proyecto p WHERE p.pryNomliderus = :pryNomliderus")
    , @NamedQuery(name = "Proyecto.findByPryNomlidertec", query = "SELECT p FROM Proyecto p WHERE p.pryNomlidertec = :pryNomlidertec")
    , @NamedQuery(name = "Proyecto.findByPryCorreopat", query = "SELECT p FROM Proyecto p WHERE p.pryCorreopat = :pryCorreopat")
    , @NamedQuery(name = "Proyecto.findByPryCorreolu", query = "SELECT p FROM Proyecto p WHERE p.pryCorreolu = :pryCorreolu")
    , @NamedQuery(name = "Proyecto.findByPryCorreolt", query = "SELECT p FROM Proyecto p WHERE p.pryCorreolt = :pryCorreolt")
    , @NamedQuery(name = "Proyecto.findByPryFechainiplan", query = "SELECT p FROM Proyecto p WHERE p.pryFechainiplan = :pryFechainiplan")
    , @NamedQuery(name = "Proyecto.findByPryFechafinplan", query = "SELECT p FROM Proyecto p WHERE p.pryFechafinplan = :pryFechafinplan")
    , @NamedQuery(name = "Proyecto.findByPryFechainireal", query = "SELECT p FROM Proyecto p WHERE p.pryFechainireal = :pryFechainireal")
    , @NamedQuery(name = "Proyecto.findByPryFechafinreal", query = "SELECT p FROM Proyecto p WHERE p.pryFechafinreal = :pryFechafinreal")
    , @NamedQuery(name = "Proyecto.findByPryEstado", query = "SELECT p FROM Proyecto p WHERE p.pryEstado = :pryEstado")
    , @NamedQuery(name = "Proyecto.findByPryVersion", query = "SELECT p FROM Proyecto p WHERE p.pryVersion = :pryVersion")
    , @NamedQuery(name = "Proyecto.findByPryPorcentaje", query = "SELECT p FROM Proyecto p WHERE p.pryPorcentaje = :pryPorcentaje")
    , @NamedQuery(name = "Proyecto.findByNombrePatrocinador", query = "SELECT p FROM Proyecto p WHERE UPPER(p.pryNombreproyecto) like :nombre and UPPER(p.pryNompat) like :patrocinador", hints = @QueryHint(name = "eclipselink.refresh", value = "true"))
})
public class Proyecto implements Serializable {

    @Basic(optional = false)
    @Column(name = "PRY_VERSION")
    private Long pryVersion;
    @JoinColumn(name = "ADM_ID", referencedColumnName = "ADM_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Administrador admId;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADMPROYECTOS_PRY_ID_GENERATOR", sequenceName = "UNA.SEQ_PROYECTOS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMPROYECTOS_PRY_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "PRY_ID")
    private Long pryId;
    @Basic(optional = false)
    @Column(name = "PRY_NOMBREPROYECTO")
    private String pryNombreproyecto;
    @Basic(optional = false)
    @Column(name = "PRY_NOMPAT")
    private String pryNompat;
    @Basic(optional = false)
    @Column(name = "PRY_NOMLIDERUS")
    private String pryNomliderus;
    @Basic(optional = false)
    @Column(name = "PRY_NOMLIDERTEC")
    private String pryNomlidertec;
    @Basic(optional = false)
    @Column(name = "PRY_CORREOPAT")
    private String pryCorreopat;
    @Basic(optional = false)
    @Column(name = "PRY_CORREOLU")
    private String pryCorreolu;
    @Basic(optional = false)
    @Column(name = "PRY_CORREOLT")
    private String pryCorreolt;
    @Basic(optional = false)
    @Column(name = "PRY_FECHAINIPLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryFechainiplan;
    @Basic(optional = false)
    @Column(name = "PRY_FECHAFINPLAN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryFechafinplan;
    @Column(name = "PRY_FECHAINIREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryFechainireal;
    @Column(name = "PRY_FECHAFINREAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pryFechafinreal;
    @Basic(optional = false)
    @Column(name = "PRY_ESTADO")
    private String pryEstado;
    @Basic(optional = false)
    @Column(name = "PRY_PORCENTAJE")
    private double pryPorcentaje;
    @OneToMany(mappedBy = "pryId", fetch = FetchType.LAZY)
    private List<Seguimiento> seguimientoList;
    @OneToMany(mappedBy = "pryId", fetch = FetchType.LAZY)
    private List<Actividad> actividadList;

    public Proyecto() {
    }

    public Proyecto(Long pryId) {
        this.pryId = pryId;
    }

    public Proyecto(ProyectoDto ProyectoDto) {
        this.pryId = ProyectoDto.getPryId();
        actualizarProyecto(ProyectoDto);
    }

    public void actualizarProyecto(ProyectoDto ProyectoDto) {
        this.pryNombreproyecto = ProyectoDto.getpRYNombreProyecto();
        this.pryNompat = ProyectoDto.getpRYNomPat();
        this.pryNomliderus = ProyectoDto.getpRYNomLiderUs();
        this.pryNomlidertec = ProyectoDto.getpRYNomLiderTec();
        this.pryCorreopat = ProyectoDto.getpRYCorreoPat();
        this.pryCorreolu = ProyectoDto.getpRYCorreoLU();
        this.pryCorreolt = ProyectoDto.getpRYCorreoLT();
        LocalDate fechaIniPlan = LocalDate.parse(ProyectoDto.getpRYFechaIniPlan(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate fechaFinPlan = LocalDate.parse(ProyectoDto.getpRYFechaFinPlan(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        if (ProyectoDto.getpRYFechaIniReal() != null) {
            LocalDate fechaIniReal = LocalDate.parse(ProyectoDto.getpRYFechaIniReal(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.pryFechainireal = Date.from(fechaIniReal.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        } else {
            this.pryFechainireal = null;
        }
        if (ProyectoDto.getpRYFechaFinReal() != null) {
            LocalDate fechaFinReal = LocalDate.parse(ProyectoDto.getpRYFechaFinReal(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            this.pryFechafinreal = Date.from(fechaFinReal.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        } else {
            this.pryFechafinreal = null;
        }
        this.pryFechainiplan = Date.from(fechaIniPlan.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.pryFechafinplan = Date.from(fechaFinPlan.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.pryEstado = ProyectoDto.getpRYEstado();
        this.pryVersion = ProyectoDto.getPryVersion();
        this.pryPorcentaje = ProyectoDto.getPryPorcentaje();
        this.admId = new Administrador(ProyectoDto.getAdmId());
    }

    public Proyecto(Long pryVersion, Administrador admId, Long pryId, String pryNombreproyecto, String pryNompat, String pryNomliderus, String pryNomlidertec, String pryCorreopat, String pryCorreolu, String pryCorreolt, Date pryFechainiplan, Date pryFechafinplan, Date pryFechainireal, Date pryFechafinreal, String pryEstado, double pryPorcentaje, List<Seguimiento> seguimientoList, List<Actividad> actividadList) {
        this.pryVersion = pryVersion;
        this.admId = admId;
        this.pryId = pryId;
        this.pryNombreproyecto = pryNombreproyecto;
        this.pryNompat = pryNompat;
        this.pryNomliderus = pryNomliderus;
        this.pryNomlidertec = pryNomlidertec;
        this.pryCorreopat = pryCorreopat;
        this.pryCorreolu = pryCorreolu;
        this.pryCorreolt = pryCorreolt;
        this.pryFechainiplan = pryFechainiplan;
        this.pryFechafinplan = pryFechafinplan;
        this.pryFechainireal = pryFechainireal;
        this.pryFechafinreal = pryFechafinreal;
        this.pryEstado = pryEstado;
        this.pryPorcentaje = pryPorcentaje;
        this.seguimientoList = seguimientoList;
        this.actividadList = actividadList;
    }

    public Long getPryId() {
        return pryId;
    }

    public void setPryId(Long pryId) {
        this.pryId = pryId;
    }

    public String getPryNombreproyecto() {
        return pryNombreproyecto;
    }

    public void setPryNombreproyecto(String pryNombreproyecto) {
        this.pryNombreproyecto = pryNombreproyecto;
    }

    public String getPryNompat() {
        return pryNompat;
    }

    public void setPryNompat(String pryNompat) {
        this.pryNompat = pryNompat;
    }

    public String getPryNomliderus() {
        return pryNomliderus;
    }

    public void setPryNomliderus(String pryNomliderus) {
        this.pryNomliderus = pryNomliderus;
    }

    public String getPryNomlidertec() {
        return pryNomlidertec;
    }

    public void setPryNomlidertec(String pryNomlidertec) {
        this.pryNomlidertec = pryNomlidertec;
    }

    public String getPryCorreopat() {
        return pryCorreopat;
    }

    public void setPryCorreopat(String pryCorreopat) {
        this.pryCorreopat = pryCorreopat;
    }

    public String getPryCorreolu() {
        return pryCorreolu;
    }

    public void setPryCorreolu(String pryCorreolu) {
        this.pryCorreolu = pryCorreolu;
    }

    public String getPryCorreolt() {
        return pryCorreolt;
    }

    public void setPryCorreolt(String pryCorreolt) {
        this.pryCorreolt = pryCorreolt;
    }

    public Date getPryFechainiplan() {
        return pryFechainiplan;
    }

    public void setPryFechainiplan(Date pryFechainiplan) {
        this.pryFechainiplan = pryFechainiplan;
    }

    public Date getPryFechafinplan() {
        return pryFechafinplan;
    }

    public void setPryFechafinplan(Date pryFechafinplan) {
        this.pryFechafinplan = pryFechafinplan;
    }

    public Date getPryFechainireal() {
        return pryFechainireal;
    }

    public void setPryFechainireal(Date pryFechainireal) {
        this.pryFechainireal = pryFechainireal;
    }

    public Date getPryFechafinreal() {
        return pryFechafinreal;
    }

    public void setPryFechafinreal(Date pryFechafinreal) {
        this.pryFechafinreal = pryFechafinreal;
    }

    public String getPryEstado() {
        return pryEstado;
    }

    public void setPryEstado(String pryEstado) {
        this.pryEstado = pryEstado;
    }

    public Long getPryVersion() {
        return pryVersion;
    }

    public void setPryVersion(Long pryVersion) {
        this.pryVersion = pryVersion;
    }

    public double getPryPorcentaje() {
        return pryPorcentaje;
    }

    public void setPryPorcentaje(double pryPorcentaje) {
        this.pryPorcentaje = pryPorcentaje;
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

    public Administrador getAdmId() {
        return admId;
    }

    public void setAdmId(Administrador admId) {
        this.admId = admId;
    }

}
