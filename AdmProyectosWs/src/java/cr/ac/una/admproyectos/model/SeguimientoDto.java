/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import cr.ac.una.admproyectos.util.LocalDateAdapter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author gera1
 */

@XmlRootElement(name="SeguimientoDto")
@XmlAccessorType(XmlAccessType.FIELD)

public class SeguimientoDto {
    private Long segId;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate sEGFecha;
    private double sEGAvance;
    private Long SegVersion;
    private String SegDescripcion;
    public SeguimientoDto(){
        
    }
    
    public SeguimientoDto(Seguimiento seguimiento){
        this.segId= seguimiento.getSegId();
        this.sEGFecha = seguimiento.getSegFecha().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        this.sEGAvance = seguimiento.getSegAvance();
        this.SegVersion = seguimiento.getSegVersion();
        this.SegDescripcion = seguimiento.getSegDescripcion();
    }

    public String getSegDescripcion() {
        return SegDescripcion;
    }

    public void setSegDescripcion(String SegDescripcion) {
        this.SegDescripcion = SegDescripcion;
    }

    public Long getSegVersion() {
        return SegVersion;
    }

    public void setSegVersion(Long SegVersion) {
        this.SegVersion = SegVersion;
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
        this.segId = segId;
    }

    public LocalDate getsEGFecha() {
        return sEGFecha;
    }

    public void setsEGFecha(LocalDate sEGFecha) {
        this.sEGFecha = sEGFecha;
    }

    public double getsEGAvance() {
        return sEGAvance;
    }

    public void setsEGAvance(double sEGAvance) {
        this.sEGAvance = sEGAvance;
    }


    @Override
    public String toString() {
        return "SeguimientoDto{" + "segId=" + segId + ", sEGFecha=" + sEGFecha + ", sEGAvance=" + sEGAvance + '}';
    }
    
    
}
