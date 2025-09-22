package py.edu.ucom.taller.models.results;


public class RespuestaGenerica {
    String codigo;
    String mensaje;

    public RespuestaGenerica() {
    }

    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
}
