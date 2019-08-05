package cpapi.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_estado", schema = "public", catalog = "demoifm")
public class TipoEstado {
    private int id;
    private String nombre;
    private Collection<LotePagoDetalle> lotePagoDetallesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoEstado that = (TipoEstado) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }

    @OneToMany(mappedBy = "tipoEstadoByEstadoId")
    public Collection<LotePagoDetalle> getLotePagoDetallesById() {
        return lotePagoDetallesById;
    }

    public void setLotePagoDetallesById(Collection<LotePagoDetalle> lotePagoDetallesById) {
        this.lotePagoDetallesById = lotePagoDetallesById;
    }
}
