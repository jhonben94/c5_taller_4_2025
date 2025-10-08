/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.taller.models.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "jugador", catalog = "proyectosdb", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "fide_id" }) })
@NamedQueries({
        @NamedQuery(name = "Jugador.findAll", query = "SELECT j FROM Jugador j"),
        @NamedQuery(name = "Jugador.findByIdJugador", query = "SELECT j FROM Jugador j WHERE j.idJugador = :idJugador"),
        @NamedQuery(name = "Jugador.findByNombre", query = "SELECT j FROM Jugador j WHERE j.nombre = :nombre"),
        @NamedQuery(name = "Jugador.findByApellido", query = "SELECT j FROM Jugador j WHERE j.apellido = :apellido"),
        @NamedQuery(name = "Jugador.findByFechaNacimiento", query = "SELECT j FROM Jugador j WHERE j.fechaNacimiento = :fechaNacimiento"),
        @NamedQuery(name = "Jugador.findByFideId", query = "SELECT j FROM Jugador j WHERE j.fideId = :fideId"),
        @NamedQuery(name = "Jugador.findByNacionalidad", query = "SELECT j FROM Jugador j WHERE j.nacionalidad = :nacionalidad"),
        @NamedQuery(name = "Jugador.findByEloActual", query = "SELECT j FROM Jugador j WHERE j.eloActual = :eloActual"),
        @NamedQuery(name = "Jugador.findByEloNacional", query = "SELECT j FROM Jugador j WHERE j.eloNacional = :eloNacional"),
        @NamedQuery(name = "Jugador.findByEloInternacional", query = "SELECT j FROM Jugador j WHERE j.eloInternacional = :eloInternacional"),
        @NamedQuery(name = "Jugador.findByCorreo", query = "SELECT j FROM Jugador j WHERE j.correo = :correo"),
        @NamedQuery(name = "Jugador.findByTelefono", query = "SELECT j FROM Jugador j WHERE j.telefono = :telefono") })
public class Jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_jugador", nullable = false)
    private Integer idJugador;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    @Column(name = "fide_id", length = 20)
    private String fideId;
    @Column(name = "nacionalidad", length = 3)
    private String nacionalidad;
    @Column(name = "elo_actual")
    private Integer eloActual;
    @Column(name = "elo_nacional")
    private Integer eloNacional;
    @Column(name = "elo_internacional")
    private Integer eloInternacional;
    @Column(name = "correo", length = 120)
    private String correo;
    @Column(name = "telefono", length = 50)
    private String telefono;
    @JoinColumn(name = "club_id", referencedColumnName = "id_club")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("jugador-club")
    private Club clubId;
    @JoinColumn(name = "titulo_codigo", referencedColumnName = "codigo")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("jugador-titulo")
    private TituloFide tituloCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJugador", fetch = FetchType.LAZY)
    @JsonManagedReference("jugador-participacion")
    private List<Participacion> participacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBlancas", fetch = FetchType.LAZY)
    @JsonManagedReference("jugador-partida-blancas")
    private List<Partida> partidaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idNegras", fetch = FetchType.LAZY)
    @JsonManagedReference("jugador-partida-negras")
    private List<Partida> partidaList1;

    public Jugador() {
    }

    public Jugador(Integer idJugador) {
        this.idJugador = idJugador;
    }

    public Jugador(Integer idJugador, String nombre, String apellido) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Integer idJugador) {
        this.idJugador = idJugador;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getFideId() {
        return fideId;
    }

    public void setFideId(String fideId) {
        this.fideId = fideId;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Integer getEloActual() {
        return eloActual;
    }

    public void setEloActual(Integer eloActual) {
        this.eloActual = eloActual;
    }

    public Integer getEloNacional() {
        return eloNacional;
    }

    public void setEloNacional(Integer eloNacional) {
        this.eloNacional = eloNacional;
    }

    public Integer getEloInternacional() {
        return eloInternacional;
    }

    public void setEloInternacional(Integer eloInternacional) {
        this.eloInternacional = eloInternacional;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Club getClubId() {
        return clubId;
    }

    public void setClubId(Club clubId) {
        this.clubId = clubId;
    }

    public TituloFide getTituloCodigo() {
        return tituloCodigo;
    }

    public void setTituloCodigo(TituloFide tituloCodigo) {
        this.tituloCodigo = tituloCodigo;
    }

    public List<Participacion> getParticipacionList() {
        return participacionList;
    }

    public void setParticipacionList(List<Participacion> participacionList) {
        this.participacionList = participacionList;
    }

    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    public List<Partida> getPartidaList1() {
        return partidaList1;
    }

    public void setPartidaList1(List<Partida> partidaList1) {
        this.partidaList1 = partidaList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJugador != null ? idJugador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jugador)) {
            return false;
        }
        Jugador other = (Jugador) object;
        if ((this.idJugador == null && other.idJugador != null)
                || (this.idJugador != null && !this.idJugador.equals(other.idJugador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Jugador[ idJugador=" + idJugador + " ]";
    }

}
