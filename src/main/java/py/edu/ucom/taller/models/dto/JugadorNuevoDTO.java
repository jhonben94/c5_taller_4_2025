package py.edu.ucom.taller.models.dto;

import java.time.LocalDate;

public class JugadorNuevoDTO {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaNacimiento;
    private Integer elo;
    private String fideId;
    private String federacion;
    private String clubNombre;
    private Integer fideK;

    // Datos adicionales para la participación en el torneo
    private String federacionTorneo;
    private String clubNombreTorneo;
    private Integer fideKTorneo;

    public JugadorNuevoDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getElo() {
        return elo;
    }

    public void setElo(Integer elo) {
        this.elo = elo;
    }

    public String getFideId() {
        return fideId;
    }

    public void setFideId(String fideId) {
        this.fideId = fideId;
    }

    public String getFederacion() {
        return federacion;
    }

    public void setFederacion(String federacion) {
        this.federacion = federacion;
    }

    public String getClubNombre() {
        return clubNombre;
    }

    public void setClubNombre(String clubNombre) {
        this.clubNombre = clubNombre;
    }

    public Integer getFideK() {
        return fideK;
    }

    public void setFideK(Integer fideK) {
        this.fideK = fideK;
    }

    public String getFederacionTorneo() {
        return federacionTorneo;
    }

    public void setFederacionTorneo(String federacionTorneo) {
        this.federacionTorneo = federacionTorneo;
    }

    public String getClubNombreTorneo() {
        return clubNombreTorneo;
    }

    public void setClubNombreTorneo(String clubNombreTorneo) {
        this.clubNombreTorneo = clubNombreTorneo;
    }

    public Integer getFideKTorneo() {
        return fideKTorneo;
    }

    public void setFideKTorneo(Integer fideKTorneo) {
        this.fideKTorneo = fideKTorneo;
    }
}


