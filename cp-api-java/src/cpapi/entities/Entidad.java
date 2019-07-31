package cpapi.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Entidad {
    private long id;
    private String codigo;
    private String nombre;
    private String emailNotificacion;
    private String uriCallback;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    @Column(name = "email_notificacion")
    public String getEmailNotificacion() {
        return emailNotificacion;
    }

    public void setEmailNotificacion(String emailNotificacion) {
        this.emailNotificacion = emailNotificacion;
    }

    @Basic
    @Column(name = "uri_callback")
    public String getUriCallback() {
        return uriCallback;
    }

    public void setUriCallback(String uriCallback) {
        this.uriCallback = uriCallback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entidad entidad = (Entidad) o;
        return id == entidad.id &&
                Objects.equals(codigo, entidad.codigo) &&
                Objects.equals(nombre, entidad.nombre) &&
                Objects.equals(emailNotificacion, entidad.emailNotificacion) &&
                Objects.equals(uriCallback, entidad.uriCallback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, nombre, emailNotificacion, uriCallback);
    }
}
