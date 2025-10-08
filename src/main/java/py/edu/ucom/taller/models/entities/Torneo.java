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
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "torneo", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Torneo.findAll", query = "SELECT t FROM Torneo t"),
        @NamedQuery(name = "Torneo.findByIdTorneo", query = "SELECT t FROM Torneo t WHERE t.idTorneo = :idTorneo"),
        @NamedQuery(name = "Torneo.findByNombre", query = "SELECT t FROM Torneo t WHERE t.nombre = :nombre"),
        @NamedQuery(name = "Torneo.findByFechaInicio", query = "SELECT t FROM Torneo t WHERE t.fechaInicio = :fechaInicio"),
        @NamedQuery(name = "Torneo.findByFechaFin", query = "SELECT t FROM Torneo t WHERE t.fechaFin = :fechaFin"),
        @NamedQuery(name = "Torneo.findByLugar", query = "SELECT t FROM Torneo t WHERE t.lugar = :lugar"),
        @NamedQuery(name = "Torneo.findByRondas", query = "SELECT t FROM Torneo t WHERE t.rondas = :rondas"),
        @NamedQuery(name = "Torneo.findByEstado", query = "SELECT t FROM Torneo t WHERE t.estado = :estado"),
        @NamedQuery(name = "Torneo.findByDirectorTorneo", query = "SELECT t FROM Torneo t WHERE t.directorTorneo = :directorTorneo") })
public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_torneo", nullable = false)
    private Integer idTorneo;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 150)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;
    @Column(name = "lugar", length = 150)
    private String lugar;
    @Column(name = "rondas")
    private Integer rondas;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "director_torneo", length = 120)
    private String directorTorneo;
    @JoinColumn(name = "id_arbitro", referencedColumnName = "id_arbitro")
    @ManyToOne(fetch = FetchType.LAZY)
    private Arbitro idArbitro;
    @JoinColumn(name = "ritmo_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RitmoTorneo ritmoCodigo;
    @JoinColumn(name = "tipo_codigo", referencedColumnName = "codigo", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TipoTorneo tipoCodigo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTorneo", fetch = FetchType.LAZY)
    @JsonManagedReference("torneo-ronda")
    private List<Ronda> rondaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTorneo", fetch = FetchType.LAZY)
    @JsonManagedReference("torneo-participacion")
    private List<Participacion> participacionList;

    public Torneo() {
    }

    public Torneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Torneo(Integer idTorneo, String nombre, LocalDate fechaInicio) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
    }

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public String getDirectorTorneo() {
        return directorTorneo;
    }

    public void setDirectorTorneo(String directorTorneo) {
        this.directorTorneo = directorTorneo;
    }

    public Arbitro getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(Arbitro idArbitro) {
        this.idArbitro = idArbitro;
    }

    public RitmoTorneo getRitmoCodigo() {
        return ritmoCodigo;
    }

    public void setRitmoCodigo(RitmoTorneo ritmoCodigo) {
        this.ritmoCodigo = ritmoCodigo;
    }

    public TipoTorneo getTipoCodigo() {
        return tipoCodigo;
    }

    public void setTipoCodigo(TipoTorneo tipoCodigo) {
        this.tipoCodigo = tipoCodigo;
    }

    public List<Ronda> getRondaList() {
        return rondaList;
    }

    public void setRondaList(List<Ronda> rondaList) {
        this.rondaList = rondaList;
    }

    public List<Participacion> getParticipacionList() {
        return participacionList;
    }

    public void setParticipacionList(List<Participacion> participacionList) {
        this.participacionList = participacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTorneo != null ? idTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.idTorneo == null && other.idTorneo != null)
                || (this.idTorneo != null && !this.idTorneo.equals(other.idTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Torneo[ idTorneo=" + idTorneo + " ]";
    }

}
