package pe.com.essalud.tramitedoc.beans;

public class InteresadoMpv {

    private long idInteresado=new Long(0);
    private String nombre;
    private String direccion;
    private String numeroDocumento;
    private String tipoDocumento;
    private String correoElectronico;
    private String numeroTelefono;
    private String codigoUbigeo;
    private String referencia;
    private String usuarioActualiza;
    private String cargo;
    private String idUsuarioRegistra;

    public long getIdInteresado() {
        return idInteresado;
    }

    public void setIdInteresado(long idInteresado) {
        this.idInteresado = idInteresado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getCodigoUbigeo() {
        return codigoUbigeo;
    }

    public void setCodigoUbigeo(String codigoUbigeo) {
        this.codigoUbigeo = codigoUbigeo;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUsuarioActualiza() {
        return usuarioActualiza;
    }

    public void setUsuarioActualiza(String usuarioActualiza) {
        this.usuarioActualiza = usuarioActualiza;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getIdUsuarioRegistra() {
        return idUsuarioRegistra;
    }

    public void setIdUsuarioRegistra(String idUsuarioRegistra) {
        this.idUsuarioRegistra = idUsuarioRegistra;
    }
}
