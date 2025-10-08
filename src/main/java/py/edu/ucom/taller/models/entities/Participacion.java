/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.taller.models.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.Basic;
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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "participacion", catalog = "proyectosdb", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "id_jugador", "id_torneo" }) })
@NamedQueries({
        @NamedQuery(name = "Participacion.findAll", query = "SELECT p FROM Participacion p"),
        @NamedQuery(name = "Participacion.findByIdParticipacion", query = "SELECT p FROM Participacion p WHERE p.idParticipacion = :idParticipacion"),
        @NamedQuery(name = "Participacion.findByRankingInicial", query = "SELECT p FROM Participacion p WHERE p.rankingInicial = :rankingInicial"),
        @NamedQuery(name = "Participacion.findByEloInicial", query = "SELECT p FROM Participacion p WHERE p.eloInicial = :eloInicial"),
        @NamedQuery(name = "Participacion.findByPerformance", query = "SELECT p FROM Participacion p WHERE p.performance = :performance"),
        @NamedQuery(name = "Participacion.findByPuntos", query = "SELECT p FROM Participacion p WHERE p.puntos = :puntos"),
        @NamedQuery(name = "Participacion.findByPuesto", query = "SELECT p FROM Participacion p WHERE p.puesto = :puesto"),
        @NamedQuery(name = "Participacion.findByFideK", query = "SELECT p FROM Participacion p WHERE p.fideK = :fideK"),
        @NamedQuery(name = "Participacion.findByFidePerformance", query = "SELECT p FROM Participacion p WHERE p.fidePerformance = :fidePerformance"),
        @NamedQuery(name = "Participacion.findByFideEloChange", query = "SELECT p FROM Participacion p WHERE p.fideEloChange = :fideEloChange"),
        @NamedQuery(name = "Participacion.findByFederacion", query = "SELECT p FROM Participacion p WHERE p.federacion = :federacion"),
        @NamedQuery(name = "Participacion.findByClubNombre", query = "SELECT p FROM Participacion p WHERE p.clubNombre = :clubNombre") })
public class Participacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_participacion", nullable = false)
    private Integer idParticipacion;
    @Column(name = "ranking_inicial")
    private Integer rankingInicial;
    @Column(name = "elo_inicial")
    private Integer eloInicial;
    @Column(name = "performance")
    private Integer performance;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "puntos", precision = 4, scale = 2)
    private BigDecimal puntos;
    @Column(name = "puesto")
    private Integer puesto;
    @Column(name = "fide_k")
    private Integer fideK;
    @Column(name = "fide_performance")
    private Integer fidePerformance;
    @Column(name = "fide_elo_change", precision = 5, scale = 2)
    private BigDecimal fideEloChange;
    @Column(name = "federacion", length = 3)
    private String federacion;
    @Column(name = "club_nombre", length = 100)
    private String clubNombre;
    @JoinColumn(name = "id_jugador", referencedColumnName = "id_jugador", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("jugador-participacion")
    private Jugador idJugador;
    @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("torneo-participacion")
    private Torneo idTorneo;

    public Participacion() {
    }

    public Participacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Integer getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Integer getRankingInicial() {
        return rankingInicial;
    }

    public void setRankingInicial(Integer rankingInicial) {
        this.rankingInicial = rankingInicial;
    }

    public Integer getEloInicial() {
        return eloInicial;
    }

    public void setEloInicial(Integer eloInicial) {
        this.eloInicial = eloInicial;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    public BigDecimal getPuntos() {
        return puntos;
    }

    public void setPuntos(BigDecimal puntos) {
        this.puntos = puntos;
    }

    public Integer getPuesto() {
        return puesto;
    }

    public void setPuesto(Integer puesto) {
        this.puesto = puesto;
    }

    public Integer getFideK() {
        return fideK;
    }

    public void setFideK(Integer fideK) {
        this.fideK = fideK;
    }

    public Integer getFidePerformance() {
        return fidePerformance;
    }

    public void setFidePerformance(Integer fidePerformance) {
        this.fidePerformance = fidePerformance;
    }

    public BigDecimal getFideEloChange() {
        return fideEloChange;
    }

    public void setFideEloChange(BigDecimal fideEloChange) {
        this.fideEloChange = fideEloChange;
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

    public Jugador getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugador idJugador) {
        this.idJugador = idJugador;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipacion != null ? idParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participacion)) {
            return false;
        }
        Participacion other = (Participacion) object;
        if ((this.idParticipacion == null && other.idParticipacion != null)
                || (this.idParticipacion != null && !this.idParticipacion.equals(other.idParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Participacion[ idParticipacion=" + idParticipacion + " ]";
    }

}
