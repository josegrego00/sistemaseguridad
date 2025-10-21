/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js.jose.proyecto.SecurityIncidentManager.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author josepino
 */
@Entity
@Table(name = "incidente")
@NamedQueries({
    @NamedQuery(name = "Incidente.findAll", query = "SELECT i FROM Incidente i"),
    @NamedQuery(name = "Incidente.findById", query = "SELECT i FROM Incidente i WHERE i.id = :id"),
    @NamedQuery(name = "Incidente.findByTitulo", query = "SELECT i FROM Incidente i WHERE i.titulo = :titulo"),
    @NamedQuery(name = "Incidente.findByDescripcion", query = "SELECT i FROM Incidente i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Incidente.findByPrioridad", query = "SELECT i FROM Incidente i WHERE i.prioridad = :prioridad"),
    @NamedQuery(name = "Incidente.findByEstado", query = "SELECT i FROM Incidente i WHERE i.estado = :estado"),
    @NamedQuery(name = "Incidente.findByReporteCreado", query = "SELECT i FROM Incidente i WHERE i.reporteCreado = :reporteCreado"),
    @NamedQuery(name = "Incidente.findByReporteCerrado", query = "SELECT i FROM Incidente i WHERE i.reporteCerrado = :reporteCerrado")})
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "prioridad")
    private String prioridad;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @Column(name = "reporte_creado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reporteCreado;
    @Column(name = "reporte_cerrado")
    @Temporal(TemporalType.TIMESTAMP)
    private Date reporteCerrado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIncidente")
    private List<IncidenteLog> incidenteLogList;
    @JoinColumn(name = "id_tipo_incidente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TipoIncidente idTipoIncidente;
    @JoinColumn(name = "id_usuario_reporte", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuarioReporte;
    @JoinColumn(name = "id_usuario_responsable", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuario idUsuarioResponsable;

    public Incidente() {
    }

    public Incidente(Long id) {
        this.id = id;
    }

    public Incidente(Long id, String titulo, String prioridad, String estado, Date reporteCreado) {
        this.id = id;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.estado = estado;
        this.reporteCreado = reporteCreado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getReporteCreado() {
        return reporteCreado;
    }

    public void setReporteCreado(Date reporteCreado) {
        this.reporteCreado = reporteCreado;
    }

    public Date getReporteCerrado() {
        return reporteCerrado;
    }

    public void setReporteCerrado(Date reporteCerrado) {
        this.reporteCerrado = reporteCerrado;
    }

    public List<IncidenteLog> getIncidenteLogList() {
        return incidenteLogList;
    }

    public void setIncidenteLogList(List<IncidenteLog> incidenteLogList) {
        this.incidenteLogList = incidenteLogList;
    }

    public TipoIncidente getIdTipoIncidente() {
        return idTipoIncidente;
    }

    public void setIdTipoIncidente(TipoIncidente idTipoIncidente) {
        this.idTipoIncidente = idTipoIncidente;
    }

    public Usuario getIdUsuarioReporte() {
        return idUsuarioReporte;
    }

    public void setIdUsuarioReporte(Usuario idUsuarioReporte) {
        this.idUsuarioReporte = idUsuarioReporte;
    }

    public Usuario getIdUsuarioResponsable() {
        return idUsuarioResponsable;
    }

    public void setIdUsuarioResponsable(Usuario idUsuarioResponsable) {
        this.idUsuarioResponsable = idUsuarioResponsable;
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
        if (!(object instanceof Incidente)) {
            return false;
        }
        Incidente other = (Incidente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "js.jose.proyecto.SecurityIncidentManager.modelos.Incidente[ id=" + id + " ]";
    }
    
}
