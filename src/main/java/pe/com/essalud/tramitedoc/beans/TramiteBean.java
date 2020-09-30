package pe.com.essalud.tramitedoc.beans;

import java.util.Date;
import java.util.List;

public class TramiteBean {

    private long  idAreaProceso;
    private long  idInteresado;
    private long  pTipoOrigen;
    private long  pIdUsuarioRegistra;
    private long  pTipoTramite;
    private long  idPersona;
    private long  idDependOrigen;
    private Integer  idTipoDocSaliente;
    private long  pidPersonaAseg;
    private long  pidTipoProducto;
    private long  pidTipoProceso;
    private long  pidClaseTramite;
    private String pasunto;
    private String tipoIdDocEntrante;
    private String pidDocEntrante;
    private String pObservacion;
    private String pAccion;
    private String cadenaReferencias;
    private String cadenaPrioridad;
    private String cadenaPara;
    private String cadenaSumilla;
    private String cadenaPlazo;
    private String cadenaFolios;
    private String cadenaAtencion;
    private String cadenaConcluye;
    private String cadenaDirigido;
    private String cadenaConCopia;
    private String cadenaAcompanamiento;
    private String cadenaPeriodo;
    private String fechaRecepFisica;
    private String  mensajetraza;
    private Documento  docuPrincipal;
    private List<Documento> listDocuAnexos;
    private InteresadoMpv interesadoMpv;


    public Documento getDocuPrincipal() {
        return docuPrincipal;
    }

    public void setDocuPrincipal(Documento docuPrincipal) {
        this.docuPrincipal = docuPrincipal;
    }

    public List<Documento> getListDocuAnexos() {
        return listDocuAnexos;
    }

    public void setListDocuAnexos(List<Documento> listDocuAnexos) {
        this.listDocuAnexos = listDocuAnexos;
    }

    public InteresadoMpv getInteresadoMpv() {
        return interesadoMpv;
    }

    public void setInteresadoMpv(InteresadoMpv interesadoMpv) {
        this.interesadoMpv = interesadoMpv;
    }

    public long getIdAreaProceso() {
        return idAreaProceso;
    }

    public void setIdAreaProceso(long idAreaProceso) {
        this.idAreaProceso = idAreaProceso;
    }

    public long getIdInteresado() {
        return idInteresado;
    }

    public void setIdInteresado(long idInteresado) {
        this.idInteresado = idInteresado;
    }

    public long getpTipoOrigen() {
        return pTipoOrigen;
    }

    public void setpTipoOrigen(long pTipoOrigen) {
        this.pTipoOrigen = pTipoOrigen;
    }

    public long getpIdUsuarioRegistra() {
        return pIdUsuarioRegistra;
    }

    public void setpIdUsuarioRegistra(long pIdUsuarioRegistra) {
        this.pIdUsuarioRegistra = pIdUsuarioRegistra;
    }

    public long getpTipoTramite() {
        return pTipoTramite;
    }

    public void setpTipoTramite(long pTipoTramite) {
        this.pTipoTramite = pTipoTramite;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public long getIdDependOrigen() {
        return idDependOrigen;
    }

    public void setIdDependOrigen(long idDependOrigen) {
        this.idDependOrigen = idDependOrigen;
    }

    public Integer getIdTipoDocSaliente() {
        return idTipoDocSaliente;
    }

    public void setIdTipoDocSaliente(Integer idTipoDocSaliente) {
        this.idTipoDocSaliente = idTipoDocSaliente;
    }

    public long getPidPersonaAseg() {
        return pidPersonaAseg;
    }

    public void setPidPersonaAseg(long pidPersonaAseg) {
        this.pidPersonaAseg = pidPersonaAseg;
    }

    public long getPidTipoProducto() {
        return pidTipoProducto;
    }

    public void setPidTipoProducto(long pidTipoProducto) {
        this.pidTipoProducto = pidTipoProducto;
    }

    public long getPidTipoProceso() {
        return pidTipoProceso;
    }

    public void setPidTipoProceso(long pidTipoProceso) {
        this.pidTipoProceso = pidTipoProceso;
    }

    public long getPidClaseTramite() {
        return pidClaseTramite;
    }

    public void setPidClaseTramite(long pidClaseTramite) {
        this.pidClaseTramite = pidClaseTramite;
    }

    public String getPasunto() {
        return pasunto;
    }

    public void setPasunto(String pasunto) {
        this.pasunto = pasunto;
    }

    public String getTipoIdDocEntrante() {
        return tipoIdDocEntrante;
    }

    public void setTipoIdDocEntrante(String tipoIdDocEntrante) {
        this.tipoIdDocEntrante = tipoIdDocEntrante;
    }

    public String getPidDocEntrante() {
        return pidDocEntrante;
    }

    public void setPidDocEntrante(String pidDocEntrante) {
        this.pidDocEntrante = pidDocEntrante;
    }

    public String getpObservacion() {
        return pObservacion;
    }

    public void setpObservacion(String pObservacion) {
        this.pObservacion = pObservacion;
    }

    public String getpAccion() {
        return pAccion;
    }

    public void setpAccion(String pAccion) {
        this.pAccion = pAccion;
    }

    public String getCadenaReferencias() {
        return cadenaReferencias;
    }

    public void setCadenaReferencias(String cadenaReferencias) {
        this.cadenaReferencias = cadenaReferencias;
    }

    public String getCadenaPrioridad() {
        return cadenaPrioridad;
    }

    public void setCadenaPrioridad(String cadenaPrioridad) {
        this.cadenaPrioridad = cadenaPrioridad;
    }

    public String getCadenaPara() {
        return cadenaPara;
    }

    public void setCadenaPara(String cadenaPara) {
        this.cadenaPara = cadenaPara;
    }

    public String getCadenaSumilla() {
        return cadenaSumilla;
    }

    public void setCadenaSumilla(String cadenaSumilla) {
        this.cadenaSumilla = cadenaSumilla;
    }

    public String getCadenaPlazo() {
        return cadenaPlazo;
    }

    public void setCadenaPlazo(String cadenaPlazo) {
        this.cadenaPlazo = cadenaPlazo;
    }

    public String getCadenaFolios() {
        return cadenaFolios;
    }

    public void setCadenaFolios(String cadenaFolios) {
        this.cadenaFolios = cadenaFolios;
    }

    public String getCadenaAtencion() {
        return cadenaAtencion;
    }

    public void setCadenaAtencion(String cadenaAtencion) {
        this.cadenaAtencion = cadenaAtencion;
    }

    public String getCadenaConcluye() {
        return cadenaConcluye;
    }

    public void setCadenaConcluye(String cadenaConcluye) {
        this.cadenaConcluye = cadenaConcluye;
    }

    public String getCadenaDirigido() {
        return cadenaDirigido;
    }

    public void setCadenaDirigido(String cadenaDirigido) {
        this.cadenaDirigido = cadenaDirigido;
    }

    public String getCadenaConCopia() {
        return cadenaConCopia;
    }

    public void setCadenaConCopia(String cadenaConCopia) {
        this.cadenaConCopia = cadenaConCopia;
    }

    public String getCadenaAcompanamiento() {
        return cadenaAcompanamiento;
    }

    public void setCadenaAcompanamiento(String cadenaAcompanamiento) {
        this.cadenaAcompanamiento = cadenaAcompanamiento;
    }

    public String getCadenaPeriodo() {
        return cadenaPeriodo;
    }

    public void setCadenaPeriodo(String cadenaPeriodo) {
        this.cadenaPeriodo = cadenaPeriodo;
    }

    public String getFechaRecepFisica() {
        return fechaRecepFisica;
    }

    public void setFechaRecepFisica(String fechaRecepFisica) {
        this.fechaRecepFisica = fechaRecepFisica;
    }

    public String getMensajetraza() {
        return mensajetraza;
    }

    public void setMensajetraza(String mensajetraza) {
        this.mensajetraza = mensajetraza;
    }
}
