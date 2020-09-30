package pe.com.essalud.tramitedoc.beans;

import java.io.ByteArrayInputStream;
import java.util.Date;

public class ArchivoAnexo {
    private long idArchivo;
    private long identificador;
    private long secuenciaSeguimiento;
    private long tipoArchivo;
    private String nombreArchivo;
    private byte[] file;
    private String textoOcr;
    private long tamanoArchivo;
    private String contenType;
    private String descripcion;
    private long  idUsuario;
    private long tipoDocumento;
    private long idDependencia;
    private Date fechaDocumento;
    private long correlativo;
    private String firmaDigital;
    private String flagjerarquia;
    private String estado_archivo;
    private byte[] fileFirmado;
    private Date fechaDocumentoFirmado;
    private String estadoDocumento;
    private long idUsuarioCreacion;
    private Date fechaDocumentoOriginal;
    private String ipUsuarioDocOrigen;
    private String sesionUsuarioCreacion;
    private long usuarioModificacion;
    private Date fechaDocumentoModificacion;
    private String ipUsuarioDocModificacion;
    private String sesionUsuarioModificacion;

    public byte[] getFileFirmado() {
        return fileFirmado;
    }

    public void setFileFirmado(byte[] fileFirmado) {
        this.fileFirmado = fileFirmado;
    }

    public long getIdArchivo() {
        return idArchivo;
    }

    public void setIdArchivo(long idArchivo) {
        this.idArchivo = idArchivo;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public long getSecuenciaSeguimiento() {
        return secuenciaSeguimiento;
    }

    public void setSecuenciaSeguimiento(long secuenciaSeguimiento) {
        this.secuenciaSeguimiento = secuenciaSeguimiento;
    }

    public long getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(long tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getTextoOcr() {
        return textoOcr;
    }

    public void setTextoOcr(String textoOcr) {
        this.textoOcr = textoOcr;
    }

    public long getTamanoArchivo() {
        return tamanoArchivo;
    }

    public void setTamanoArchivo(long tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }

    public String getContenType() {
        return contenType;
    }

    public void setContenType(String contenType) {
        this.contenType = contenType;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(long idDependencia) {
        this.idDependencia = idDependencia;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public long getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(long correlativo) {
        this.correlativo = correlativo;
    }

    public String getFirmaDigital() {
        return firmaDigital;
    }

    public void setFirmaDigital(String firmaDigital) {
        this.firmaDigital = firmaDigital;
    }

    public String getFlagjerarquia() {
        return flagjerarquia;
    }

    public void setFlagjerarquia(String flagjerarquia) {
        this.flagjerarquia = flagjerarquia;
    }

    public String getEstado_archivo() {
        return estado_archivo;
    }

    public void setEstado_archivo(String estado_archivo) {
        this.estado_archivo = estado_archivo;
    }

    public Date getFechaDocumentoFirmado() {
        return fechaDocumentoFirmado;
    }

    public void setFechaDocumentoFirmado(Date fechaDocumentoFirmado) {
        this.fechaDocumentoFirmado = fechaDocumentoFirmado;
    }

    public String getEstadoDocumento() {
        return estadoDocumento;
    }

    public void setEstadoDocumento(String estadoDocumento) {
        this.estadoDocumento = estadoDocumento;
    }

    public long getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(long idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    public Date getFechaDocumentoOriginal() {
        return fechaDocumentoOriginal;
    }

    public void setFechaDocumentoOriginal(Date fechaDocumentoOriginal) {
        this.fechaDocumentoOriginal = fechaDocumentoOriginal;
    }

    public String getIpUsuarioDocOrigen() {
        return ipUsuarioDocOrigen;
    }

    public void setIpUsuarioDocOrigen(String ipUsuarioDocOrigen) {
        this.ipUsuarioDocOrigen = ipUsuarioDocOrigen;
    }

    public String getSesionUsuarioCreacion() {
        return sesionUsuarioCreacion;
    }

    public void setSesionUsuarioCreacion(String sesionUsuarioCreacion) {
        this.sesionUsuarioCreacion = sesionUsuarioCreacion;
    }

    public long getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(long usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaDocumentoModificacion() {
        return fechaDocumentoModificacion;
    }

    public void setFechaDocumentoModificacion(Date fechaDocumentoModificacion) {
        this.fechaDocumentoModificacion = fechaDocumentoModificacion;
    }

    public String getIpUsuarioDocModificacion() {
        return ipUsuarioDocModificacion;
    }

    public void setIpUsuarioDocModificacion(String ipUsuarioDocModificacion) {
        this.ipUsuarioDocModificacion = ipUsuarioDocModificacion;
    }

    public String getSesionUsuarioModificacion() {
        return sesionUsuarioModificacion;
    }

    public void setSesionUsuarioModificacion(String sesionUsuarioModificacion) {
        this.sesionUsuarioModificacion = sesionUsuarioModificacion;
    }
}
