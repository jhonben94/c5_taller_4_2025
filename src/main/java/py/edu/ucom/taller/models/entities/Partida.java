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
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "partida", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Partida.findAll", query = "SELECT p FROM Partida p"),
        @NamedQuery(name = "Partida.findByIdPartida", query = "SELECT p FROM Partida p WHERE p.idPartida = :idPartida"),
        @NamedQuery(name = "Partida.findByResultado", query = "SELECT p FROM Partida p WHERE p.resultado = :resultado"),
        @NamedQuery(name = "Partida.findByMesa", query = "SELECT p FROM Partida p WHERE p.mesa = :mesa"),
        @NamedQuery(name = "Partida.findByMovimientos", query = "SELECT p FROM Partida p WHERE p.movimientos = :movimientos"),
        @NamedQuery(name = "Partida.findByEloBlancas", query = "SELECT p FROM Partida p WHERE p.eloBlancas = :eloBlancas"),
        @NamedQuery(name = "Partida.findByEloNegras", query = "SELECT p FROM Partida p WHERE p.eloNegras = :eloNegras"),
        @NamedQuery(name = "Partida.findByEloVariacionBlancas", query = "SELECT p FROM Partida p WHERE p.eloVariacionBlancas = :eloVariacionBlancas"),
        @NamedQuery(name = "Partida.findByEloVariacionNegras", query = "SELECT p FROM Partida p WHERE p.eloVariacionNegras = :eloVariacionNegras"),
        @NamedQuery(name = "Partida.findByObservaciones", query = "SELECT p FROM Partida p WHERE p.observaciones = :observaciones") })
public class Partida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_partida", nullable = false)
    private Integer idPartida;
    @Column(name = "resultado", length = 3)
    private String resultado;
    @Column(name = "mesa")
    private Integer mesa;
    @Column(name = "duracion")
    private Integer duracion; // minutes duration
    @Column(name = "movimientos", length = 2147483647)
    private String movimientos;
    @Column(name = "elo_blancas")
    private Integer eloBlancas;
    @Column(name = "elo_negras")
    private Integer eloNegras;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Column(name = "elo_variacion_blancas", precision = 5, scale = 2)
    private BigDecimal eloVariacionBlancas;
    @Column(name = "elo_variacion_negras", precision = 5, scale = 2)
    private BigDecimal eloVariacionNegras;
    @Column(name = "observaciones", length = 2147483647)
    private String observaciones;
    @JoinColumn(name = "id_blancas", referencedColumnName = "id_jugador", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("jugador-partida-blancas")
    private Jugador idBlancas;
    @JoinColumn(name = "id_negras", referencedColumnName = "id_jugador", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("jugador-partida-negras")
    private Jugador idNegras;
    @JoinColumn(name = "id_ronda", referencedColumnName = "id_ronda", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("ronda-partida")
    private Ronda idRonda;

    public Partida() {
    }

    public Partida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public Integer getMesa() {
        return mesa;
    }

    public void setMesa(Integer mesa) {
        this.mesa = mesa;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(String movimientos) {
        this.movimientos = movimientos;
    }

    public Integer getEloBlancas() {
        return eloBlancas;
    }

    public void setEloBlancas(Integer eloBlancas) {
        this.eloBlancas = eloBlancas;
    }

    public Integer getEloNegras() {
        return eloNegras;
    }

    public void setEloNegras(Integer eloNegras) {
        this.eloNegras = eloNegras;
    }

    public BigDecimal getEloVariacionBlancas() {
        return eloVariacionBlancas;
    }

    public void setEloVariacionBlancas(BigDecimal eloVariacionBlancas) {
        this.eloVariacionBlancas = eloVariacionBlancas;
    }

    public BigDecimal getEloVariacionNegras() {
        return eloVariacionNegras;
    }

    public void setEloVariacionNegras(BigDecimal eloVariacionNegras) {
        this.eloVariacionNegras = eloVariacionNegras;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Jugador getIdBlancas() {
        return idBlancas;
    }

    public void setIdBlancas(Jugador idBlancas) {
        this.idBlancas = idBlancas;
    }

    public Jugador getIdNegras() {
        return idNegras;
    }

    public void setIdNegras(Jugador idNegras) {
        this.idNegras = idNegras;
    }

    public Ronda getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(Ronda idRonda) {
        this.idRonda = idRonda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartida != null ? idPartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partida)) {
            return false;
        }
        Partida other = (Partida) object;
        if ((this.idPartida == null && other.idPartida != null)
                || (this.idPartida != null && !this.idPartida.equals(other.idPartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Partida[ idPartida=" + idPartida + " ]";
    }

}
