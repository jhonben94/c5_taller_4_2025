/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package py.edu.ucom.taller.models.entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author jhony
 */
@Entity
@Table(name = "ritmo_torneo", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "RitmoTorneo.findAll", query = "SELECT r FROM RitmoTorneo r"),
        @NamedQuery(name = "RitmoTorneo.findByCodigo", query = "SELECT r FROM RitmoTorneo r WHERE r.codigo = :codigo"),
        @NamedQuery(name = "RitmoTorneo.findByDescripcion", query = "SELECT r FROM RitmoTorneo r WHERE r.descripcion = :descripcion") })
public class RitmoTorneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 3)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ritmoCodigo", fetch = FetchType.LAZY)
    private List<Torneo> torneoList;

    public RitmoTorneo() {
    }

    public RitmoTorneo(String codigo) {
        this.codigo = codigo;
    }

    public RitmoTorneo(String codigo, String descripcion) {
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

    public List<Torneo> getTorneoList() {
        return torneoList;
    }

    public void setTorneoList(List<Torneo> torneoList) {
        this.torneoList = torneoList;
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
        if (!(object instanceof RitmoTorneo)) {
            return false;
        }
        RitmoTorneo other = (RitmoTorneo) object;
        if ((this.codigo == null && other.codigo != null)
                || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.RitmoTorneo[ codigo=" + codigo + " ]";
    }

}
