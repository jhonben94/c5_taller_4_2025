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
@Table(name = "titulo_fide", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "TituloFide.findAll", query = "SELECT t FROM TituloFide t"),
        @NamedQuery(name = "TituloFide.findByCodigo", query = "SELECT t FROM TituloFide t WHERE t.codigo = :codigo"),
        @NamedQuery(name = "TituloFide.findByDescripcion", query = "SELECT t FROM TituloFide t WHERE t.descripcion = :descripcion") })
public class TituloFide implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 5)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @OneToMany(mappedBy = "tituloCodigo", fetch = FetchType.LAZY)
    @JsonManagedReference("jugador-titulo")
    private List<Jugador> jugadorList;

    public TituloFide() {
    }

    public TituloFide(String codigo) {
        this.codigo = codigo;
    }

    public TituloFide(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TituloFide)) {
            return false;
        }
        TituloFide other = (TituloFide) object;
        if ((this.codigo == null && other.codigo != null)
                || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.TituloFide[ codigo=" + codigo + " ]";
    }

}
