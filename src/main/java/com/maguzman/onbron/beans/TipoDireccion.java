package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name="tipodireccion")
public class TipoDireccion implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoDireccion;
    @Size(max=45)
    private String descripcion;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdTipoDireccion() {
        return idTipoDireccion;
    }

    public void setIdTipoDireccion(Integer idTipoDireccion) {
        this.idTipoDireccion = idTipoDireccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoDireccion)) return false;

        TipoDireccion that = (TipoDireccion) o;

        if (!getIdTipoDireccion().equals(that.getIdTipoDireccion())) return false;
        return getDescripcion().equals(that.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getIdTipoDireccion().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TipoDireccion{" +
                "idTipoDireccion=" + idTipoDireccion +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
