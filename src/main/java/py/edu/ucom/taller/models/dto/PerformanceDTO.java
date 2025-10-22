package py.edu.ucom.taller.models.dto;

import java.math.BigDecimal;
import java.util.List;

public class PerformanceDTO {

    private Integer idJugador;
    private String nombreJugador;
    private String apellidoJugador;
    private Integer eloInicial;
    private Integer performanceCalculado;
    private BigDecimal puntosObtenidos;
    private Integer partidasJugadas;
    private BigDecimal promedioEloOponentes;
    private List<PartidaPerformanceDTO> partidas;
    private String categoriaPerformance;
    private BigDecimal variacionElo;

    public PerformanceDTO() {
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getApellidoJugador() {
        return apellidoJugador;
    }

    public void setApellidoJugador(String apellidoJugador) {
        this.apellidoJugador = apellidoJugador;
    }

    public Integer getEloInicial() {
        return eloInicial;
    }

    public void setEloInicial(Integer eloInicial) {
        this.eloInicial = eloInicial;
    }

    public Integer getPerformanceCalculado() {
        return performanceCalculado;
    }

    public void setPerformanceCalculado(Integer performanceCalculado) {
        this.performanceCalculado = performanceCalculado;
    }

    public BigDecimal getPuntosObtenidos() {
        return puntosObtenidos;
    }

    public void setPuntosObtenidos(BigDecimal puntosObtenidos) {
        this.puntosObtenidos = puntosObtenidos;
    }

    public Integer getPartidasJugadas() {
        return partidasJugadas;
    }

    public void setPartidasJugadas(Integer partidasJugadas) {
        this.partidasJugadas = partidasJugadas;
    }

    public BigDecimal getPromedioEloOponentes() {
        return promedioEloOponentes;
    }

    public void setPromedioEloOponentes(BigDecimal promedioEloOponentes) {
        this.promedioEloOponentes = promedioEloOponentes;
    }

    public List<PartidaPerformanceDTO> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<PartidaPerformanceDTO> partidas) {
        this.partidas = partidas;
    }

    public String getCategoriaPerformance() {
        return categoriaPerformance;
    }

    public void setCategoriaPerformance(String categoriaPerformance) {
        this.categoriaPerformance = categoriaPerformance;
    }

    public BigDecimal getVariacionElo() {
        return variacionElo;
    }

    public void setVariacionElo(BigDecimal variacionElo) {
        this.variacionElo = variacionElo;
    }
}


