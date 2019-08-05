package cpapi.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estadoproceso_demo", schema = "public", catalog = "demoifm")
public class EstadoprocesoDemo {
    private long id;
    private String nombre;
    private String estado;
    private Integer idlote;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Basic
    @Column(name = "idlote")
    public Integer getIdlote() {
        return idlote;
    }

    public void setIdlote(Integer idlote) {
        this.idlote = idlote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoprocesoDemo that = (EstadoprocesoDemo) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(estado, that.estado) &&
                Objects.equals(idlote, that.idlote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, estado, idlote);
    }
}
