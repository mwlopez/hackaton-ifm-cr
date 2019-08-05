package cpapi.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lote_pago_encabezado", schema = "public", catalog = "demoifm")
public class LotePagoEncabezado {
    private int id;
    private String entidad;
    private Date fechaRegistro;
    private String estado;
    private LoteEnvio loteEnvioByLoteEnvioId;

    @Id
    @Column(name = "id_lote")
    public int getId() {
        return id;
    }

    public void setId(int idLote) {
        this.id = idLote;
    }

    @Basic
    @Column(name = "entidad")
    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Basic
    @Column(name = "fecha_registro")
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
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
        LotePagoEncabezado that = (LotePagoEncabezado) o;
        return id == that.id &&
                Objects.equals(entidad, that.entidad) &&
                Objects.equals(fechaRegistro, that.fechaRegistro) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, entidad, fechaRegistro, estado);
    }

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "lote_envio_id", referencedColumnName = "id")
    public LoteEnvio getLoteEnvioByLoteEnvioId() {
        return loteEnvioByLoteEnvioId;
    }

    public void setLoteEnvioByLoteEnvioId(LoteEnvio loteEnvioByLoteEnvioId) {
        this.loteEnvioByLoteEnvioId = loteEnvioByLoteEnvioId;
    }
}
