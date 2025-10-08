package py.edu.ucom.taller.models.results;

public class RespuestaGenerica<T> {
    private String codigo;
    private String mensaje;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
