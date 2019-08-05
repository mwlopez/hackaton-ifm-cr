package cpapi.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "lote_envio", schema = "public", catalog = "demoifm")
public class LoteEnvio {
    private long id;
    private Timestamp fecha;
    private Integer loteSinpe;
    private String estado;
    private Collection<LotePagoEncabezado> lotePagoEncabezadosById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fecha")
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "lote_sinpe")
    public Integer getLoteSinpe() {
        return loteSinpe;
    }

    public void setLoteSinpe(Integer loteSinpe) {
        this.loteSinpe = loteSinpe;
    }

    @Basic
    @Column(name = "estado")
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoteEnvio loteEnvio = (LoteEnvio) o;
        return id == loteEnvio.id &&
                Objects.equals(fecha, loteEnvio.fecha) &&
                Objects.equals(loteSinpe, loteEnvio.loteSinpe) &&
                Objects.equals(estado, loteEnvio.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, loteSinpe, estado);
    }

    @OneToMany(mappedBy = "loteEnvioByLoteEnvioId")
    public Collection<LotePagoEncabezado> getLotePagoEncabezadosById() {
        return lotePagoEncabezadosById;
    }

    public void setLotePagoEncabezadosById(Collection<LotePagoEncabezado> lotePagoEncabezadosById) {
        this.lotePagoEncabezadosById = lotePagoEncabezadosById;
    }
}
