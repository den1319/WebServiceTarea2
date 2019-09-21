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

@XmlRootElement(name="ActividadDto")
@XmlAccessorType(XmlAccessType.FIELD)

public class ActividadDto {
    private Long actId;
    private String aCTDescripcion;
    private String aCTNomEncargado;
    private String aCTEstado;
    private Date aCTFechaIniPlan;
    private Date aCTFechaFinPlan;
    private Date aCTFechaIniReal;
    private Date aCTFechaFinReal;
    private String aCTCorreoEncargado;
    private Long aCTOrden;
    
    public ActividadDto(){
    }
    
    public ActividadDto(Actividad actividad){
        this.actId = actividad.getActId();
        this.aCTDescripcion = actividad.getACTDescripcion();
        this.aCTNomEncargado = actividad.getACTNomEncargado();
        this.aCTEstado = actividad.getACTEstado();
        this.aCTFechaIniPlan = actividad.getACTFechaIniPlan();
        this.aCTFechaFinPlan = actividad.getACTFechaFinPlan();
        this.aCTFechaIniReal = actividad.getACTFechaIniReal();
        this.aCTFechaFinReal = actividad.getACTFechaFinReal();
        this.aCTCorreoEncargado = actividad.getACTCorreoEncargado();
        this.aCTOrden = actividad.getACTOrden();
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public String getaCTDescripcion() {
        return aCTDescripcion;
    }

    public void setaCTDescripcion(String aCTDescripcion) {
        this.aCTDescripcion = aCTDescripcion;
    }

    public String getaCTNomEncargado() {
        return aCTNomEncargado;
    }

    public void setaCTNomEncargado(String aCTNomEncargado) {
        this.aCTNomEncargado = aCTNomEncargado;
    }

    public String getaCTEstado() {
        return aCTEstado;
    }

    public void setaCTEstado(String aCTEstado) {
        this.aCTEstado = aCTEstado;
    }

    public Date getaCTFechaIniPlan() {
        return aCTFechaIniPlan;
    }

    public void setaCTFechaIniPlan(Date aCTFechaIniPlan) {
        this.aCTFechaIniPlan = aCTFechaIniPlan;
    }

    public Date getaCTFechaFinPlan() {
        return aCTFechaFinPlan;
    }

    public void setaCTFechaFinPlan(Date aCTFechaFinPlan) {
        this.aCTFechaFinPlan = aCTFechaFinPlan;
    }

    public Date getaCTFechaIniReal() {
        return aCTFechaIniReal;
    }

    public void setaCTFechaIniReal(Date aCTFechaIniReal) {
        this.aCTFechaIniReal = aCTFechaIniReal;
    }

    public Date getaCTFechaFinReal() {
        return aCTFechaFinReal;
    }

    public void setaCTFechaFinReal(Date aCTFechaFinReal) {
        this.aCTFechaFinReal = aCTFechaFinReal;
    }

    public String getaCTCorreoEncargado() {
        return aCTCorreoEncargado;
    }

    public void setaCTCorreoEncargado(String aCTCorreoEncargado) {
        this.aCTCorreoEncargado = aCTCorreoEncargado;
    }

    public Long getaCTOrden() {
        return aCTOrden;
    }

    public void setaCTOrden(Long aCTOrden) {
        this.aCTOrden = aCTOrden;
    }

    @Override
    public String toString() {
        return "ActividadDto{" + "actId=" + actId + ", aCTDescripcion=" + aCTDescripcion + ", aCTNomEncargado=" + aCTNomEncargado + ", aCTEstado=" + aCTEstado + ", aCTFechaIniPlan=" + aCTFechaIniPlan + ", aCTFechaFinPlan=" + aCTFechaFinPlan + ", aCTFechaIniReal=" + aCTFechaIniReal + ", aCTFechaFinReal=" + aCTFechaFinReal + ", aCTCorreoEncargado=" + aCTCorreoEncargado + ", aCTOrden=" + aCTOrden + '}';
    }
    
    
    
}
