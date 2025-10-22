package py.edu.ucom.taller.models.dto;

import java.math.BigDecimal;

public class PartidaPerformanceDTO {

    private Integer idPartida;
    private Integer numeroRonda;
    private Integer eloOponente;
    private String resultado;
    private BigDecimal puntosObtenidos;
    private String color; // "blancas" o "negras"
    private String nombreOponente;
    private String apellidoOponente;

    public PartidaPerformanceDTO() {
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(Integer numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public Integer getEloOponente() {
        return eloOponente;
    }

    public void setEloOponente(Integer eloOponente) {
        this.eloOponente = eloOponente;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public BigDecimal getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(BigDecimal puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNombreOponente() {
        return nombreOponente;
    }

    public void setNombreOponente(String nombreOponente) {
        this.nombreOponente = nombreOponente;
    }

    public String getApellidoOponente() {
        return apellidoOponente;
    }

    public void setApellidoOponente(String apellidoOponente) {
        this.apellidoOponente = apellidoOponente;
    }
}


