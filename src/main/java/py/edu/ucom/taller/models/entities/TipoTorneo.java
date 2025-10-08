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
@Table(name = "tipo_torneo", catalog = "proyectosdb", schema = "public")
@NamedQueries({
        @NamedQuery(name = "TipoTorneo.findAll", query = "SELECT t FROM TipoTorneo t"),
        @NamedQuery(name = "TipoTorneo.findByCodigo", query = "SELECT t FROM TipoTorneo t WHERE t.codigo = :codigo"),
        @NamedQuery(name = "TipoTorneo.findByDescripcion", query = "SELECT t FROM TipoTorneo t WHERE t.descripcion = :descripcion") })
public class TipoTorneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "codigo", nullable = false, length = 3)
    private String codigo;
    @Basic(optional = false)
    @Column(name = "descripcion", nullable = false, length = 50)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCodigo", fetch = FetchType.LAZY)
    private List<Torneo> torneoList;

    public TipoTorneo() {
    }

    public TipoTorneo(String codigo) {
        this.codigo = codigo;
    }

    public TipoTorneo(String codigo, String descripcion) {
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
        if (!(object instanceof TipoTorneo)) {
            return false;
        }
        TipoTorneo other = (TipoTorneo) object;
        if ((this.codigo == null && other.codigo != null)
                || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject1.entities.TipoTorneo[ codigo=" + codigo + " ]";
    }

}
