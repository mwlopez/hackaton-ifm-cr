package cpapi.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "lote_pago_detalle", schema = "public", catalog = "demoifm")
public class LotePagoDetalle {
    private Integer idLote;
    private String firstName;
    private String lastName;
    private String email;
    private String program;
    private Date date;
    private Double value;
    private String iban;
    private String transactionId;
    private String response;
    private String tag;
    private String description;
    private long id;
    private String identificacion;
    private String referenciaMhSinpe;
    private TipoEstado tipoEstadoByEstadoId;

    @Basic
    @Column(name = "id_lote")
    public Integer getIdLote() {
        return idLote;
    }

    public void setIdLote(Integer idLote) {
        this.idLote = idLote;
    }

    @Basic
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "program")
    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "value")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Basic
    @Column(name = "iban")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Basic
    @Column(name = "transaction_id")
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Basic
    @Column(name = "response")
    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "identificacion")
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Basic
    @Column(name = "referencia_mh_sinpe")
    public String getReferenciaMhSinpe() {
        return referenciaMhSinpe;
    }

    public void setReferenciaMhSinpe(String referenciaMhSinpe) {
        this.referenciaMhSinpe = referenciaMhSinpe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotePagoDetalle that = (LotePagoDetalle) o;
        return id == that.id &&
                Objects.equals(idLote, that.idLote) &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(email, that.email) &&
                Objects.equals(program, that.program) &&
                Objects.equals(date, that.date) &&
                Objects.equals(value, that.value) &&
                Objects.equals(iban, that.iban) &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(response, that.response) &&
                Objects.equals(tag, that.tag) &&
                Objects.equals(description, that.description) &&
                Objects.equals(identificacion, that.identificacion) &&
                Objects.equals(referenciaMhSinpe, that.referenciaMhSinpe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLote, firstName, lastName, email, program, date, value, iban, transactionId, response, tag, description, id, identificacion, referenciaMhSinpe);
    }

    @ManyToOne
    @JoinColumn(name = "estado_id", referencedColumnName = "id")
    public TipoEstado getTipoEstadoByEstadoId() {
        return tipoEstadoByEstadoId;
    }

    public void setTipoEstadoByEstadoId(TipoEstado tipoEstadoByEstadoId) {
        this.tipoEstadoByEstadoId = tipoEstadoByEstadoId;
    }
}
