package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 13/07/2017.
 */
@Entity
@Table(name="tipoproducto")
public class TipoProducto implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipoProducto;
    @Size(max=30)
    private String descripcion;

    public TipoProducto() {
        this.descripcion = "";
    }

    public TipoProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
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
        if (!(o instanceof TipoProducto)) return false;

        TipoProducto that = (TipoProducto) o;

        if (getIdTipoProducto() != that.getIdTipoProducto()) return false;
        return getDescripcion().equals(that.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getIdTipoProducto();
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TipoProducto{" +
                "idTipoProducto=" + idTipoProducto +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
