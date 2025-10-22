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
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "arbitro", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Arbitro.findAll", query = "SELECT a FROM Arbitro a"),
        @NamedQuery(name = "Arbitro.findByIdArbitro", query = "SELECT a FROM Arbitro a WHERE a.idArbitro = :idArbitro"),
        @NamedQuery(name = "Arbitro.findByNombre", query = "SELECT a FROM Arbitro a WHERE a.nombre = :nombre"),
        @NamedQuery(name = "Arbitro.findByApellido", query = "SELECT a FROM Arbitro a WHERE a.apellido = :apellido"),
        @NamedQuery(name = "Arbitro.findByCategoria", query = "SELECT a FROM Arbitro a WHERE a.categoria = :categoria"),
        @NamedQuery(name = "Arbitro.findByCorreo", query = "SELECT a FROM Arbitro a WHERE a.correo = :correo"),
        @NamedQuery(name = "Arbitro.findByTelefono", query = "SELECT a FROM Arbitro a WHERE a.telefono = :telefono") })
public class Arbitro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_arbitro", nullable = false)
    private Integer idArbitro;
    @Basic(optional = false)
    @Column(name = "nombre", nullable = false, length = 200)
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Column(name = "categoria", length = 50)
    private String categoria;
    @Column(name = "correo", length = 120)
    private String correo;
    @Column(name = "telefono", length = 50)
    private String telefono;
    @JsonIgnore
    @OneToMany(mappedBy = "idArbitro", fetch = FetchType.LAZY)
    private List<Torneo> torneoList;

    public Arbitro() {
    }

    public Arbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
    }

    public Arbitro(Integer idArbitro, String nombre, String apellido) {
        this.idArbitro = idArbitro;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Integer getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(Integer idArbitro) {
        this.idArbitro = idArbitro;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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

    public List<Torneo> getTorneoList() {
        return torneoList;
    }

    public void setTorneoList(List<Torneo> torneoList) {
        this.torneoList = torneoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idArbitro != null ? idArbitro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arbitro)) {
            return false;
        }
        Arbitro other = (Arbitro) object;
        if ((this.idArbitro == null && other.idArbitro != null)
                || (this.idArbitro != null && !this.idArbitro.equals(other.idArbitro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.Arbitro[ idArbitro=" + idArbitro + " ]";
    }

}
