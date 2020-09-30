package pe.com.essalud.tramitedoc.beans;

public class Documento {
    private String documbase64;
    private String documNobre;
    private String documContentType;
    private Integer documTamanio;
    private String flagjerarquia;  //P=Principal,A=Anexos

    public String getDocumbase64() {
        return documbase64;
    }

    public void setDocumbase64(String documbase64) {
        this.documbase64 = documbase64;
    }

    public String getDocumNobre() {
        return documNobre;
    }

    public void setDocumNobre(String documNobre) {
        this.documNobre = documNobre;
    }

    public String getDocumContentType() {
        return documContentType;
    }

    public void setDocumContentType(String documContentType) {
        this.documContentType = documContentType;
    }

    public Integer getDocumTamanio() {
        return documTamanio;
    }

    public void setDocumTamanio(Integer documTamanio) {
        this.documTamanio = documTamanio;
    }

    public String getFlagjerarquia() {
        return flagjerarquia;
    }

    public void setFlagjerarquia(String flagjerarquia) {
        this.flagjerarquia = flagjerarquia;
    }
}
