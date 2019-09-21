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
 * @author JORDI RODRIGUEZ
 */
@Entity
@Table(name = "ADP_TB_Seguimientos", schema="UNA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findBySegId", query = "SELECT s FROM Seguimiento s WHERE s.segId = :segId")
    , @NamedQuery(name = "Seguimiento.findBySEGFecha", query = "SELECT s FROM Seguimiento s WHERE s.sEGFecha = :sEGFecha")
    , @NamedQuery(name = "Seguimiento.findBySEGAvance", query = "SELECT s FROM Seguimiento s WHERE s.sEGAvance = :sEGAvance")
    , @NamedQuery(name = "Seguimiento.findBySEGVersion", query = "SELECT s FROM Seguimiento s WHERE s.sEGVersion = :sEGVersion")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name = "ADMPROYECTOS_SEG_ID_GENERATOR", sequenceName = "UNA.SEQ_SEGUIMIENTOS", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADMPROYECTOS_SEG_ID_GENERATOR")
    @Basic(optional = false)
    @Column(name = "SEG_ID")
    private Long segId;
    @Basic(optional = false)
    @Column(name = "SEG_Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sEGFecha;
    @Basic(optional = false)
    @Column(name = "SEG_Avance")
    private double sEGAvance;
    @Basic(optional = false)
    @Column(name = "SEG_Version")
    private Long sEGVersion;
    @JoinColumn(name = "PRY_ID", referencedColumnName = "PRY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto pryId;

    public Seguimiento() {
    }
    public Seguimiento(Long Id){
        this.segId = Id;
    }
   public Seguimiento(SeguimientoDto SeguimientoDto){
       this.segId = SeguimientoDto.getSegId();
       actualizarSeguimiento(SeguimientoDto);
       
   }
   public void actualizarSeguimiento(SeguimientoDto seguimientoDto){
       this.sEGFecha = Date.from(seguimientoDto.getsEGFecha().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.sEGAvance = seguimientoDto.getsEGAvance();
        this.sEGVersion =seguimientoDto.getSegVersion();
   }
    public Seguimiento(Long segId, Date sEGFecha, double sEGAvance, Long sEGVersion) {
        this.segId = segId;
        this.sEGFecha = sEGFecha;
        this.sEGAvance = sEGAvance;
        this.sEGVersion = sEGVersion;
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
        this.segId = segId;
    }

    public Date getSEGFecha() {
        return sEGFecha;
    }

    public void setSEGFecha(Date sEGFecha) {
        this.sEGFecha = sEGFecha;
    }

    public double getSEGAvance() {
        return sEGAvance;
    }

    public void setSEGAvance(double sEGAvance) {
        this.sEGAvance = sEGAvance;
    }

    public Long getSEGVersion() {
        return sEGVersion;
    }

    public void setSEGVersion(Long sEGVersion) {
        this.sEGVersion = sEGVersion;
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
        hash += (segId != null ? segId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.segId == null && other.segId != null) || (this.segId != null && !this.segId.equals(other.segId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cr.ac.una.admproyectos.model.Seguimiento[ segId=" + segId + " ]";
    }
    
}
