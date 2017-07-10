package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="tipoFactura")
public class TipoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoFactura;
    @NotEmpty
    @Size(max=255)
    private String descripción;

    public TipoFactura() {
        this.idTipoFactura=0;
        this.descripción="";
    }

    public TipoFactura(String descripción) {
        this.descripción = descripción;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdTipoFactura() {
        return idTipoFactura;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setIdTipoFactura(Integer idTipoFactura) {
        this.idTipoFactura = idTipoFactura;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoFactura)) return false;

        TipoFactura that = (TipoFactura) o;

        if (!getIdTipoFactura().equals(that.getIdTipoFactura())) return false;
        return getDescripción().equals(that.getDescripción());
    }

    @Override
    public int hashCode() {
        int result = getIdTipoFactura().hashCode();
        result = 31 * result + getDescripción().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TipoFactura{" +
                "idTipoFactura=" + idTipoFactura +
                ", descripción='" + descripción + '\'' +
                '}';
    }
}
