package pe.com.essalud.tramitedoc.beans;

import java.io.Serializable;

public class ResponseBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String codRespuesta;
    private String msgRespuesta;
    private String idenfificador;
    private String numeroNit;
    private long idInteresado;

    public long getIdInteresado() {
        return idInteresado;
    }

    public void setIdInteresado(long idInteresado) {
        this.idInteresado = idInteresado;
    }

    public String getIdenfificador() {
        return idenfificador;
    }

    public void setIdenfificador(String idenfificador) {
        this.idenfificador = idenfificador;
    }

    public String getNumeroNit() {
        return numeroNit;
    }

    public void setNumeroNit(String numeroNit) {
        this.numeroNit = numeroNit;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCodRespuesta() {
        return codRespuesta;
    }

    public void setCodRespuesta(String codRespuesta) {
        this.codRespuesta = codRespuesta;
    }

    public String getMsgRespuesta() {
        return msgRespuesta;
    }

    public void setMsgRespuesta(String msgRespuesta) {
        this.msgRespuesta = msgRespuesta;
    }
}
