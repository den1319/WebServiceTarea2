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
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate pRYFechaIniPlan;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate pRYFechaFinPlan;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate pRYFechaIniReal;
    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate pRYFechaFinReal;
    private String pRYEstado;
    private Long PryVersion;
    
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
        this.pRYFechaIniPlan = proyecto.getPRYFechaIniPlan().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.pRYFechaFinPlan = proyecto.getPRYFechaFinPlan().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.pRYFechaIniReal = proyecto.getPRYFechaIniReal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.pRYFechaFinReal = proyecto.getPRYFechaFinReal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        this.pRYEstado = proyecto.getPRYEstado();
        this.PryVersion = proyecto.getPRYVersion();
    }

    public Long getPryVersion() {
        return PryVersion;
    }

    public void setPryVersion(Long PryVersion) {
        this.PryVersion = PryVersion;
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

    public LocalDate getpRYFechaIniPlan() {
        return pRYFechaIniPlan;
    }

    public void setpRYFechaIniPlan(LocalDate pRYFechaIniPlan) {
        this.pRYFechaIniPlan = pRYFechaIniPlan;
    }

    public LocalDate getpRYFechaFinPlan() {
        return pRYFechaFinPlan;
    }

    public void setpRYFechaFinPlan(LocalDate pRYFechaFinPlan) {
        this.pRYFechaFinPlan = pRYFechaFinPlan;
    }

    public LocalDate getpRYFechaIniReal() {
        return pRYFechaIniReal;
    }

    public void setpRYFechaIniReal(LocalDate pRYFechaIniReal) {
        this.pRYFechaIniReal = pRYFechaIniReal;
    }

    public LocalDate getpRYFechaFinReal() {
        return pRYFechaFinReal;
    }

    public void setpRYFechaFinReal(LocalDate pRYFechaFinReal) {
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
