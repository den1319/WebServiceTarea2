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

@XmlRootElement(name="ProyectoDto")
@XmlAccessorType(XmlAccessType.FIELD)

public class ProyectoDto {
    private Long pryId;
    private String pRYNombreProyecto;
    private String pRYNomPat;
    private String pRYNomLiderUs;
    private String pRYNomLiderTec;
    private String pRYCorreoPat;
    private String pRYCorreoLU;
    private String pRYCorreoLT;
    private Date pRYFechaIniPlan;
    private Date pRYFechaFinPlan;
    private Date pRYFechaIniReal;
    private Date pRYFechaFinReal;
    private String pRYEstado;
    
    public ProyectoDto(){
    }
    
    public ProyectoDto(Proyecto proyecto){
        this.pryId = proyecto.getPryId();
        this.pRYNombreProyecto = proyecto.getPRYNombreProyecto();
        this.pRYNomPat = proyecto.getPRYNomPat();
        this.pRYNomLiderUs = proyecto.getPRYNomLiderUs();
        this.pRYNomLiderTec = proyecto.getPRYNomLiderTec();
        this.pRYCorreoPat = proyecto.getPRYCorreoPat();
        this.pRYCorreoLU = proyecto.getPRYCorreoLU();
        this.pRYCorreoLT = proyecto.getPRYCorreoLT();
        this.pRYFechaIniPlan = proyecto.getPRYFechaIniPlan();
        this.pRYFechaFinPlan = proyecto.getPRYFechaFinPlan();
        this.pRYFechaIniReal = proyecto.getPRYFechaIniReal();
        this.pRYFechaFinReal = proyecto.getPRYFechaFinReal();
        this.pRYEstado = proyecto.getPRYEstado();
    }

    public Long getPryId() {
        return pryId;
    }

    public void setPryId(Long pryId) {
        this.pryId = pryId;
    }

    public String getpRYNombreProyecto() {
        return pRYNombreProyecto;
    }

    public void setpRYNombreProyecto(String pRYNombreProyecto) {
        this.pRYNombreProyecto = pRYNombreProyecto;
    }

    public String getpRYNomPat() {
        return pRYNomPat;
    }

    public void setpRYNomPat(String pRYNomPat) {
        this.pRYNomPat = pRYNomPat;
    }

    public String getpRYNomLiderUs() {
        return pRYNomLiderUs;
    }

    public void setpRYNomLiderUs(String pRYNomLiderUs) {
        this.pRYNomLiderUs = pRYNomLiderUs;
    }

    public String getpRYNomLiderTec() {
        return pRYNomLiderTec;
    }

    public void setpRYNomLiderTec(String pRYNomLiderTec) {
        this.pRYNomLiderTec = pRYNomLiderTec;
    }

    public String getpRYCorreoPat() {
        return pRYCorreoPat;
    }

    public void setpRYCorreoPat(String pRYCorreoPat) {
        this.pRYCorreoPat = pRYCorreoPat;
    }

    public String getpRYCorreoLU() {
        return pRYCorreoLU;
    }

    public void setpRYCorreoLU(String pRYCorreoLU) {
        this.pRYCorreoLU = pRYCorreoLU;
    }

    public String getpRYCorreoLT() {
        return pRYCorreoLT;
    }

    public void setpRYCorreoLT(String pRYCorreoLT) {
        this.pRYCorreoLT = pRYCorreoLT;
    }

    public Date getpRYFechaIniPlan() {
        return pRYFechaIniPlan;
    }

    public void setpRYFechaIniPlan(Date pRYFechaIniPlan) {
        this.pRYFechaIniPlan = pRYFechaIniPlan;
    }

    public Date getpRYFechaFinPlan() {
        return pRYFechaFinPlan;
    }

    public void setpRYFechaFinPlan(Date pRYFechaFinPlan) {
        this.pRYFechaFinPlan = pRYFechaFinPlan;
    }

    public Date getpRYFechaIniReal() {
        return pRYFechaIniReal;
    }

    public void setpRYFechaIniReal(Date pRYFechaIniReal) {
        this.pRYFechaIniReal = pRYFechaIniReal;
    }

    public Date getpRYFechaFinReal() {
        return pRYFechaFinReal;
    }

    public void setpRYFechaFinReal(Date pRYFechaFinReal) {
        this.pRYFechaFinReal = pRYFechaFinReal;
    }

    public String getpRYEstado() {
        return pRYEstado;
    }

    public void setpRYEstado(String pRYEstado) {
        this.pRYEstado = pRYEstado;
    }

    @Override
    public String toString() {
        return "ProyectoDto{" + "pryId=" + pryId + ", pRYNombreProyecto=" + pRYNombreProyecto + ", pRYNomPat=" + pRYNomPat + ", pRYNomLiderUs=" + pRYNomLiderUs + ", pRYNomLiderTec=" + pRYNomLiderTec + ", pRYCorreoPat=" + pRYCorreoPat + ", pRYCorreoLU=" + pRYCorreoLU + ", pRYCorreoLT=" + pRYCorreoLT + ", pRYFechaIniPlan=" + pRYFechaIniPlan + ", pRYFechaFinPlan=" + pRYFechaFinPlan + ", pRYFechaIniReal=" + pRYFechaIniReal + ", pRYFechaFinReal=" + pRYFechaFinReal + ", pRYEstado=" + pRYEstado + '}';
    }
    
    
}
