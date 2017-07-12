package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 12/07/2017.
 */
@Entity
@Table(name="tipoimpuesto")
public class TipoImpuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoImpuesto;
    @NotEmpty
    @Size(max=45)
    private String descripcion;

    public TipoImpuesto() {
        this.idTipoImpuesto=0;
        this.descripcion="";
    }

    public TipoImpuesto(String descripcion) {
        this.descripcion = descripcion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdTipoImpuesto() {
        return idTipoImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdTipoImpuesto(Integer idTipoImpuesto) {
        this.idTipoImpuesto = idTipoImpuesto;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoImpuesto)) return false;

        TipoImpuesto that = (TipoImpuesto) o;

        if (getIdTipoImpuesto() != null ? !getIdTipoImpuesto().equals(that.getIdTipoImpuesto()) : that.getIdTipoImpuesto() != null)
            return false;
        return getDescripcion() != null ? getDescripcion().equals(that.getDescripcion()) : that.getDescripcion() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdTipoImpuesto() != null ? getIdTipoImpuesto().hashCode() : 0;
        result = 31 * result + (getDescripcion() != null ? getDescripcion().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TipoImpuesto{" +
                "idTipoImpuesto=" + idTipoImpuesto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
