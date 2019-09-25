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
@Table(name = "ADP_TB_SEGUIMIENTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s")
    , @NamedQuery(name = "Seguimiento.findBySegId", query = "SELECT s FROM Seguimiento s WHERE s.segId = :segId")
    , @NamedQuery(name = "Seguimiento.findBySegFecha", query = "SELECT s FROM Seguimiento s WHERE s.segFecha = :segFecha")
    , @NamedQuery(name = "Seguimiento.findBySegAvance", query = "SELECT s FROM Seguimiento s WHERE s.segAvance = :segAvance")
    , @NamedQuery(name = "Seguimiento.findBySegVersion", query = "SELECT s FROM Seguimiento s WHERE s.segVersion = :segVersion")
    , @NamedQuery(name = "Seguimiento.findBySegDescripcion", query = "SELECT s FROM Seguimiento s WHERE UPPER(s.segDescripcion) = :segDescripcion")})
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
    @Column(name = "SEG_FECHA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date segFecha;
    @Basic(optional = false)
    @Column(name = "SEG_AVANCE")
    private double segAvance;
    @Basic(optional = false)
    @Column(name = "SEG_VERSION")
    private Long segVersion;
    @Basic(optional = false)
    @Column(name = "SEG_DESCRIPCION")
    private String segDescripcion;
    @JoinColumn(name = "PRY_ID", referencedColumnName = "PRY_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Proyecto pryId;

    public Seguimiento() {
    }

    public Seguimiento(Long segId) {
        this.segId = segId;
    }

    public Seguimiento(SeguimientoDto SeguimientoDto) {
        this.segId = SeguimientoDto.getSegId();
        actualizarSeguimiento(SeguimientoDto);

    }

    public void actualizarSeguimiento(SeguimientoDto seguimientoDto) {
        LocalDate SegFecha = LocalDate.parse(seguimientoDto.getsEGFecha(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.segFecha = Date.from(SegFecha.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        this.segAvance = seguimientoDto.getsEGAvance();
        this.segVersion = seguimientoDto.getSegVersion();
        this.segDescripcion = seguimientoDto.getSegDescripcion();
    }

    public Seguimiento(Long segId, Date segFecha, double segAvance, Long segVersion, String segDescripcion) {
        this.segId = segId;
        this.segFecha = segFecha;
        this.segAvance = segAvance;
        this.segVersion = segVersion;
        this.segDescripcion = segDescripcion;
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
        this.segId = segId;
    }

    public Date getSegFecha() {
        return segFecha;
    }

    public void setSegFecha(Date segFecha) {
        this.segFecha = segFecha;
    }

    public double getSegAvance() {
        return segAvance;
    }

    public void setSegAvance(double segAvance) {
        this.segAvance = segAvance;
    }

    public Long getSegVersion() {
        return segVersion;
    }

    public void setSegVersion(Long segVersion) {
        this.segVersion = segVersion;
    }

    public String getSegDescripcion() {
        return segDescripcion;
    }

    public void setSegDescripcion(String segDescripcion) {
        this.segDescripcion = segDescripcion;
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
