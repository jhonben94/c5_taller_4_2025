/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.taller.models.entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "club", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
        @NamedQuery(name = "Club.findByIdClub", query = "SELECT c FROM Club c WHERE c.idClub = :idClub"),
        @NamedQuery(name = "Club.findByNombre", query = "SELECT c FROM Club c WHERE c.nombre = :nombre"),
        @NamedQuery(name = "Club.findByCiudad", query = "SELECT c FROM Club c WHERE c.ciudad = :ciudad"),
        @NamedQuery(name = "Club.findByPais", query = "SELECT c FROM Club c WHERE c.pais = :pais") })
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_club", nullable = false)
    private Integer idClub;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "ciudad", length = 100)
    private String ciudad;
    @Column(name = "pais", length = 100)
    private String pais;
    @OneToMany(mappedBy = "clubId", fetch = FetchType.LAZY)
    @JsonManagedReference("jugador-club")
    private List<Jugador> jugadorList;

    public Club() {
    }

    public Club(Integer idClub) {
        this.idClub = idClub;
    }

    public Club(Integer idClub, String nombre) {
        this.idClub = idClub;
        this.nombre = nombre;
    }

    public Integer getIdClub() {
        return idClub;
    }

    public void setIdClub(Integer idClub) {
        this.idClub = idClub;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClub != null ? idClub.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Club)) {
            return false;
        }
        Club other = (Club) object;
        if ((this.idClub == null && other.idClub != null)
                || (this.idClub != null && !this.idClub.equals(other.idClub))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Club[ idClub=" + idClub + " ]";
    }

}
