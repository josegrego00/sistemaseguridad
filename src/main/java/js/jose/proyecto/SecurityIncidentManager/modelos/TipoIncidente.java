/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js.jose.proyecto.SecurityIncidentManager.modelos;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author josepino
 */
@Entity
@Table(name = "tipo_incidente")
@NamedQueries({
    @NamedQuery(name = "TipoIncidente.findAll", query = "SELECT t FROM TipoIncidente t"),
    @NamedQuery(name = "TipoIncidente.findById", query = "SELECT t FROM TipoIncidente t WHERE t.id = :id"),
    @NamedQuery(name = "TipoIncidente.findByNombre", query = "SELECT t FROM TipoIncidente t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoIncidente.findByDescripcion", query = "SELECT t FROM TipoIncidente t WHERE t.descripcion = :descripcion")})
public class TipoIncidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoIncidente")
    private List<Incidente> incidenteList;

    public TipoIncidente() {
    }

    public TipoIncidente(Integer id) {
        this.id = id;
    }

    public TipoIncidente(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Incidente> getIncidenteList() {
        return incidenteList;
    }

    public void setIncidenteList(List<Incidente> incidenteList) {
        this.incidenteList = incidenteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoIncidente)) {
            return false;
        }
        TipoIncidente other = (TipoIncidente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "js.jose.proyecto.SecurityIncidentManager.modelos.TipoIncidente[ id=" + id + " ]";
    }
    
}
