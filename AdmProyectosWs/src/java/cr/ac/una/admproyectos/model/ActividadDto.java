package cr.ac.una.admproyectos.model;


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
@XmlRootElement(name="ActividadDto")
@XmlAccessorType(XmlAccessType.FIELD)

public class ActividadDto {
    private Long actId;
    private String aCTDescripcion;
    private String aCTNomEncargado;
    private String aCTEstado;
    private String aCTFechaIniPlan;
    private String aCTFechaFinPlan;
    private String aCTFechaIniReal;
    private String aCTFechaFinReal;
    private String aCTCorreoEncargado;
    private Long aCTOrden;
    private Long ActVersion;
    
    public ActividadDto(){
    }
    
    public ActividadDto(Actividad actividad){
        this.actId = actividad.getActId();
        this.aCTDescripcion = actividad.getActDescripcion();
        this.aCTNomEncargado = actividad.getActNomencargado();
        this.aCTEstado = actividad.getActEstado();
        this.aCTFechaIniPlan = actividad.getActFechainiplan().toInstant().atZone(ZoneId.systemDefault()).toString();
        this.aCTFechaFinPlan = actividad.getActFechafinplan().toInstant().atZone(ZoneId.systemDefault()).toString();
        this.aCTFechaIniReal = actividad.getActFechainireal().toInstant().atZone(ZoneId.systemDefault()).toString();
        this.aCTFechaFinReal = actividad.getActFechafinreal().toInstant().atZone(ZoneId.systemDefault()).toString();
        this.aCTCorreoEncargado = actividad.getActCorreoencargado();
        this.aCTOrden = actividad.getActOrden();
        this.ActVersion = actividad.getActVersion();
    }

    public Long getActVersion() {
        return ActVersion;
    }

    public void setActVersion(Long ActVersion) {
        this.ActVersion = ActVersion;
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

    public String getaCTFechaIniPlan() {
        return aCTFechaIniPlan;
    }

    public void setaCTFechaIniPlan(String aCTFechaIniPlan) {
        this.aCTFechaIniPlan = aCTFechaIniPlan;
    }

    public String getaCTFechaFinPlan() {
        return aCTFechaFinPlan;
    }

    public void setaCTFechaFinPlan(String aCTFechaFinPlan) {
        this.aCTFechaFinPlan = aCTFechaFinPlan;
    }

    public String getaCTFechaIniReal() {
        return aCTFechaIniReal;
    }

    public void setaCTFechaIniReal(String aCTFechaIniReal) {
        this.aCTFechaIniReal = aCTFechaIniReal;
    }

    public String getaCTFechaFinReal() {
        return aCTFechaFinReal;
    }

    public void setaCTFechaFinReal(String aCTFechaFinReal) {
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
