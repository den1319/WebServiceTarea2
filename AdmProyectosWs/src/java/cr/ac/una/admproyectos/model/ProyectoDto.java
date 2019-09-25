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
import java.util.List;
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
    private String pRYFechaIniPlan;
    private String pRYFechaFinPlan;
    private String pRYFechaIniReal;
    private String pRYFechaFinReal;
    private String pRYEstado;
    private Long PryVersion;
    private double PryPorcentaje;
    private AdministradorDto AdmId;
    private List<Actividad> actividadList;
    private List<Seguimiento> seguimientoList;
    public ProyectoDto(){
    }

    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    public AdministradorDto getAdmId() {
        return AdmId;
    }

    public void setAdmId(AdministradorDto AdmId) {
        this.AdmId = AdmId;
    }
    
    public ProyectoDto(Proyecto proyecto){
        this.pryId = proyecto.getPryId();
        this.pRYNombreProyecto = proyecto.getPryNombreproyecto();
        this.pRYNomPat = proyecto.getPryNompat();
        this.pRYNomLiderUs = proyecto.getPryNomliderus();
        this.pRYNomLiderTec = proyecto.getPryNomlidertec();
        this.pRYCorreoPat = proyecto.getPryCorreopat();
        this.pRYCorreoLU = proyecto.getPryCorreolu();
        this.pRYCorreoLT = proyecto.getPryCorreolt();
        this.pRYFechaIniPlan = proyecto.getPryFechainiplan().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.pRYFechaFinPlan = proyecto.getPryFechafinplan().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.pRYFechaIniReal = proyecto.getPryFechainireal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.pRYFechaFinReal = proyecto.getPryFechafinreal().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
        this.pRYEstado = proyecto.getPryEstado();
        this.PryVersion = proyecto.getPryVersion();
        this.PryPorcentaje = proyecto.getPryPorcentaje();
        this.AdmId = new AdministradorDto(proyecto.getAdmId());
        this.actividadList = proyecto.getActividadList();
        this.seguimientoList = proyecto.getSeguimientoList();
    }

    public double getPryPorcentaje() {
        return PryPorcentaje;
    }

    public void setPryPorcentaje(double PryPorcentaje) {
        this.PryPorcentaje = PryPorcentaje;
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

    public String getpRYFechaIniPlan() {
        return pRYFechaIniPlan;
    }

    public void setpRYFechaIniPlan(String pRYFechaIniPlan) {
        this.pRYFechaIniPlan = pRYFechaIniPlan;
    }

    public String getpRYFechaFinPlan() {
        return pRYFechaFinPlan;
    }

    public void setpRYFechaFinPlan(String pRYFechaFinPlan) {
        this.pRYFechaFinPlan = pRYFechaFinPlan;
    }

    public String getpRYFechaIniReal() {
        return pRYFechaIniReal;
    }

    public void setpRYFechaIniReal(String pRYFechaIniReal) {
        this.pRYFechaIniReal = pRYFechaIniReal;
    }

    public String getpRYFechaFinReal() {
        return pRYFechaFinReal;
    }

    public void setpRYFechaFinReal(String pRYFechaFinReal) {
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
