/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.admproyectos.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gera1
 */

@XmlRootElement(name="SeguimientoDto")
@XmlAccessorType(XmlAccessType.FIELD)

public class SeguimientoDto {
    private Long segId;
    private Date sEGFecha;
    private double sEGAvance;

    
    public SeguimientoDto(){
        
    }
    
    public SeguimientoDto(Seguimiento seguimiento){
        this.segId= seguimiento.getSegId();
        this.sEGFecha = seguimiento.getSEGFecha();
        this.sEGAvance = seguimiento.getSEGAvance();
    }

    public Long getSegId() {
        return segId;
    }

    public void setSegId(Long segId) {
        this.segId = segId;
    }

    public Date getsEGFecha() {
        return sEGFecha;
    }

    public void setsEGFecha(Date sEGFecha) {
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
