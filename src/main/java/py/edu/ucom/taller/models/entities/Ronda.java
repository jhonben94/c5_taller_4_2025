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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "ronda", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Ronda.findAll", query = "SELECT r FROM Ronda r"),
        @NamedQuery(name = "Ronda.findByIdRonda", query = "SELECT r FROM Ronda r WHERE r.idRonda = :idRonda"),
        @NamedQuery(name = "Ronda.findByNumeroRonda", query = "SELECT r FROM Ronda r WHERE r.numeroRonda = :numeroRonda"),
        @NamedQuery(name = "Ronda.findByFecha", query = "SELECT r FROM Ronda r WHERE r.fecha = :fecha"),
        @NamedQuery(name = "Ronda.findByEstado", query = "SELECT r FROM Ronda r WHERE r.estado = :estado") })
public class Ronda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ronda", nullable = false)
    private Integer idRonda;
    @Basic(optional = false)
    @Column(name = "numero_ronda", nullable = false)
    private int numeroRonda;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "id_torneo", referencedColumnName = "id_torneo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("torneo-ronda")
    private Torneo idTorneo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idRonda", fetch = FetchType.LAZY)
    @JsonManagedReference("ronda-partida")
    private List<Partida> partidaList;

    public Ronda() {
    }

    public Ronda(Integer idRonda) {
        this.idRonda = idRonda;
    }

    public Ronda(Integer idRonda, int numeroRonda) {
        this.idRonda = idRonda;
        this.numeroRonda = numeroRonda;
    }

    public Integer getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(Integer idRonda) {
        this.idRonda = idRonda;
    }

    public int getNumeroRonda() {
        return numeroRonda;
    }

    public void setNumeroRonda(int numeroRonda) {
        this.numeroRonda = numeroRonda;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Torneo getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Torneo idTorneo) {
        this.idTorneo = idTorneo;
    }

    public List<Partida> getPartidaList() {
        return partidaList;
    }

    public void setPartidaList(List<Partida> partidaList) {
        this.partidaList = partidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRonda != null ? idRonda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ronda)) {
            return false;
        }
        Ronda other = (Ronda) object;
        if ((this.idRonda == null && other.idRonda != null)
                || (this.idRonda != null && !this.idRonda.equals(other.idRonda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Ronda[ idRonda=" + idRonda + " ]";
    }

}
