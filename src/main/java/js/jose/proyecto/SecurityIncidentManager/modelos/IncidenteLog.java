/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js.jose.proyecto.SecurityIncidentManager.modelos;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
/**
 *
 * @author josepino
 */
@Entity
@Table(name = "incidente_log")
@NamedQueries({
    @NamedQuery(name = "IncidenteLog.findAll", query = "SELECT i FROM IncidenteLog i"),
    @NamedQuery(name = "IncidenteLog.findById", query = "SELECT i FROM IncidenteLog i WHERE i.id = :id"),
    @NamedQuery(name = "IncidenteLog.findByAccion", query = "SELECT i FROM IncidenteLog i WHERE i.accion = :accion"),
    @NamedQuery(name = "IncidenteLog.findByFechaAccionIncidente", query = "SELECT i FROM IncidenteLog i WHERE i.fechaAccionIncidente = :fechaAccionIncidente"),
    @NamedQuery(name = "IncidenteLog.findByNotas", query = "SELECT i FROM IncidenteLog i WHERE i.notas = :notas")})
public class IncidenteLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "accion")
    private String accion;
    @Column(name = "fecha_accion_incidente")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAccionIncidente;
    @Column(name = "notas")
    private String notas;
    @JoinColumn(name = "id_incidente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Incidente idIncidente;
    @JoinColumn(name = "id_usuario_accion", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuarioAccion;

    public IncidenteLog() {
    }

    public IncidenteLog(Long id) {
        this.id = id;
    }

    public IncidenteLog(Long id, String accion) {
        this.id = id;
        this.accion = accion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFechaAccionIncidente() {
        return fechaAccionIncidente;
    }

    public void setFechaAccionIncidente(Date fechaAccionIncidente) {
        this.fechaAccionIncidente = fechaAccionIncidente;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public Incidente getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Incidente idIncidente) {
        this.idIncidente = idIncidente;
    }

    public Usuario getIdUsuarioAccion() {
        return idUsuarioAccion;
    }

    public void setIdUsuarioAccion(Usuario idUsuarioAccion) {
        this.idUsuarioAccion = idUsuarioAccion;
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
        if (!(object instanceof IncidenteLog)) {
            return false;
        }
        IncidenteLog other = (IncidenteLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "js.jose.proyecto.SecurityIncidentManager.modelos.IncidenteLog[ id=" + id + " ]";
    }
    
}
