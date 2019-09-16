/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gera1
 */
@Entity
@Table(name = "ADP_TB_Actividades", schema = "UNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Actividad.findAll", query = "SELECT a FROM Actividad a")
    , @NamedQuery(name = "Actividad.findByActId", query = "SELECT a FROM Actividad a WHERE a.actId = :actId")
    , @NamedQuery(name = "Actividad.findByACTDescripcion", query = "SELECT a FROM Actividad a WHERE a.aCTDescripcion = :aCTDescripcion")
    , @NamedQuery(name = "Actividad.findByACTNomEncargado", query = "SELECT a FROM Actividad a WHERE a.aCTNomEncargado = :aCTNomEncargado")
    , @NamedQuery(name = "Actividad.findByACTEstado", query = "SELECT a FROM Actividad a WHERE a.aCTEstado = :aCTEstado")
    , @NamedQuery(name = "Actividad.findByACTFechaIniPlan", query = "SELECT a FROM Actividad a WHERE a.aCTFechaIniPlan = :aCTFechaIniPlan")
    , @NamedQuery(name = "Actividad.findByACTFechaFinPlan", query = "SELECT a FROM Actividad a WHERE a.aCTFechaFinPlan = :aCTFechaFinPlan")
    , @NamedQuery(name = "Actividad.findByACTFechaIniReal", query = "SELECT a FROM Actividad a WHERE a.aCTFechaIniReal = :aCTFechaIniReal")
    , @NamedQuery(name = "Actividad.findByACTFechaFinReal", query = "SELECT a FROM Actividad a WHERE a.aCTFechaFinReal = :aCTFechaFinReal")
    , @NamedQuery(name = "Actividad.findByACTVersion", query = "SELECT a FROM Actividad a WHERE a.aCTVersion = :aCTVersion")
    , @NamedQuery(name = "Actividad.findByACTCorreoEncargado", query = "SELECT a FROM Actividad a WHERE a.aCTCorreoEncargado = :aCTCorreoEncargado")
    , @NamedQuery(name = "Actividad.findByACTOrden", query = "SELECT a FROM Actividad a WHERE a.aCTOrden = :aCTOrden")})
public class Actividad implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADMPROYECTOS_ACT_ID_GENERATOR", sequenceName = "UNA.SEQ_ACTIVIDADES", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMPROYECTOS_ACT_ID_GENERATOR")
    
    @Basic(optional = false)
    @Column(name = "ACT_ID")
    private BigDecimal actId;
    @Basic(optional = false)
    @Column(name = "ACT_Descripcion")
    private String aCTDescripcion;
    @Basic(optional = false)
    @Column(name = "ACT_NomEncargado")
    private String aCTNomEncargado;
    @Basic(optional = false)
    @Column(name = "ACT_Estado")
    private String aCTEstado;
    @Basic(optional = false)
    @Column(name = "ACT_FechaIniPlan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aCTFechaIniPlan;
    @Basic(optional = false)
    @Column(name = "ACT_FechaFinPlan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aCTFechaFinPlan;
    @Column(name = "ACT_FechaIniReal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aCTFechaIniReal;
    @Column(name = "ACT_FechaFinReal")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aCTFechaFinReal;
    @Basic(optional = false)
    @Column(name = "ACT_Version")
    private BigInteger aCTVersion;
    @Basic(optional = false)
    @Column(name = "ACT_CorreoEncargado")
    private String aCTCorreoEncargado;
    @Basic(optional = false)
    @Column(name = "ACT_Orden")
    private BigInteger aCTOrden;
    @JoinColumn(name = "PRY_ID", referencedColumnName = "PRY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto pryId;

    public Actividad() {
    }

    public Actividad(BigDecimal actId) {
        this.actId = actId;
    }

    public Actividad(BigDecimal actId, String aCTDescripcion, String aCTNomEncargado, String aCTEstado, Date aCTFechaIniPlan, Date aCTFechaFinPlan, BigInteger aCTVersion, String aCTCorreoEncargado, BigInteger aCTOrden) {
        this.actId = actId;
        this.aCTDescripcion = aCTDescripcion;
        this.aCTNomEncargado = aCTNomEncargado;
        this.aCTEstado = aCTEstado;
        this.aCTFechaIniPlan = aCTFechaIniPlan;
        this.aCTFechaFinPlan = aCTFechaFinPlan;
        this.aCTVersion = aCTVersion;
        this.aCTCorreoEncargado = aCTCorreoEncargado;
        this.aCTOrden = aCTOrden;
    }

    public BigDecimal getActId() {
        return actId;
    }

    public void setActId(BigDecimal actId) {
        this.actId = actId;
    }

    public String getACTDescripcion() {
        return aCTDescripcion;
    }

    public void setACTDescripcion(String aCTDescripcion) {
        this.aCTDescripcion = aCTDescripcion;
    }

    public String getACTNomEncargado() {
        return aCTNomEncargado;
    }

    public void setACTNomEncargado(String aCTNomEncargado) {
        this.aCTNomEncargado = aCTNomEncargado;
    }

    public String getACTEstado() {
        return aCTEstado;
    }

    public void setACTEstado(String aCTEstado) {
        this.aCTEstado = aCTEstado;
    }

    public Date getACTFechaIniPlan() {
        return aCTFechaIniPlan;
    }

    public void setACTFechaIniPlan(Date aCTFechaIniPlan) {
        this.aCTFechaIniPlan = aCTFechaIniPlan;
    }

    public Date getACTFechaFinPlan() {
        return aCTFechaFinPlan;
    }

    public void setACTFechaFinPlan(Date aCTFechaFinPlan) {
        this.aCTFechaFinPlan = aCTFechaFinPlan;
    }

    public Date getACTFechaIniReal() {
        return aCTFechaIniReal;
    }

    public void setACTFechaIniReal(Date aCTFechaIniReal) {
        this.aCTFechaIniReal = aCTFechaIniReal;
    }

    public Date getACTFechaFinReal() {
        return aCTFechaFinReal;
    }

    public void setACTFechaFinReal(Date aCTFechaFinReal) {
        this.aCTFechaFinReal = aCTFechaFinReal;
    }

    public BigInteger getACTVersion() {
        return aCTVersion;
    }

    public void setACTVersion(BigInteger aCTVersion) {
        this.aCTVersion = aCTVersion;
    }

    public String getACTCorreoEncargado() {
        return aCTCorreoEncargado;
    }

    public void setACTCorreoEncargado(String aCTCorreoEncargado) {
        this.aCTCorreoEncargado = aCTCorreoEncargado;
    }

    public BigInteger getACTOrden() {
        return aCTOrden;
    }

    public void setACTOrden(BigInteger aCTOrden) {
        this.aCTOrden = aCTOrden;
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
