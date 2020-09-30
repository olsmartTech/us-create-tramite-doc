package pe.com.essalud.tramitedoc.beans;

public class DocumentBean {
    private String numNit;
    private long identificador;
    private String tipo;
    private String item;
    private String clasep;
    private long idClaseTramite;

    public String getNumNit() {
        return numNit;
    }

    public void setNumNit(String numNit) {
        this.numNit = numNit;
    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getClasep() {
        return clasep;
    }

    public void setClasep(String clasep) {
        this.clasep = clasep;
    }

    public long getIdClaseTramite() {
        return idClaseTramite;
    }

    public void setIdClaseTramite(long idClaseTramite) {
        this.idClaseTramite = idClaseTramite;
    }
}
