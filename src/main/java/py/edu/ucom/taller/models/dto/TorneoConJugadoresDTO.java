package py.edu.ucom.taller.models.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import py.edu.ucom.taller.models.entities.Arbitro;
import py.edu.ucom.taller.models.entities.RitmoTorneo;
import py.edu.ucom.taller.models.entities.TipoTorneo;

public class TorneoConJugadoresDTO {

    // Datos del torneo
    private String nombre;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String lugar;
    private Integer rondas;
    private String directorTorneo;
    private Integer idArbitro;
    private String ritmoCodigo;
    private String tipoCodigo;

    // Datos de los jugadores a inscribir
    private List<Integer> idsJugadores;
    private Map<String, Object> datosAdicionalesJugadores;

    // Datos de jugadores nuevos a crear e inscribir
    private List<JugadorNuevoDTO> jugadoresNuevos;

    public TorneoConJugadoresDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getRondas() {
        return rondas;
    }

    public void setRondas(Integer rondas) {
        this.rondas = rondas;
    }

    public String getDirectorTorneo() {
        return directorTorneo;
    }

    public void setDirectorTorneo(String directorTorneo) {
        this.directorTorneo = directorTorneo;
    }

    public Integer getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
    }

    public String getRitmoCodigo() {
        return ritmoCodigo;
    }

    public void setRitmoCodigo(String ritmoCodigo) {
        this.ritmoCodigo = ritmoCodigo;
    }

    public String getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(String tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public List<Integer> getIdsJugadores() {
        return idsJugadores;
    }

    public void setIdsJugadores(List<Integer> idsJugadores) {
        this.idsJugadores = idsJugadores;
    }

    public Map<String, Object> getDatosAdicionalesJugadores() {
        return datosAdicionalesJugadores;
    }

    public void setDatosAdicionalesJugadores(Map<String, Object> datosAdicionalesJugadores) {
        this.datosAdicionalesJugadores = datosAdicionalesJugadores;
    }

    public List<JugadorNuevoDTO> getJugadoresNuevos() {
        return jugadoresNuevos;
    }

    public void setJugadoresNuevos(List<JugadorNuevoDTO> jugadoresNuevos) {
        this.jugadoresNuevos = jugadoresNuevos;
    }
}
