package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name="estadotipofactura")
public class EstadoTipoFactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstadoTipoFactura;
    @ManyToOne
    @JoinColumn(name="tipoFactura")
    private TipoFactura tipoFactura;
    @Size(max=30)
    private String descripcion;

    public EstadoTipoFactura(TipoFactura tipoFactura, String descripcion) {
        this.tipoFactura = tipoFactura;
        this.descripcion = descripcion;
    }

    public EstadoTipoFactura() {
        this.tipoFactura = null;
        this.descripcion = "";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdEstadoTipoFactura() {
        return idEstadoTipoFactura;
    }

    public void setIdEstadoTipoFactura(Integer idEstadoTipoFactura) {
        this.idEstadoTipoFactura = idEstadoTipoFactura;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
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
        if (!(o instanceof EstadoTipoFactura)) return false;

        EstadoTipoFactura that = (EstadoTipoFactura) o;

        if (!getIdEstadoTipoFactura().equals(that.getIdEstadoTipoFactura())) return false;
        if (!getTipoFactura().equals(that.getTipoFactura())) return false;
        return getDescripcion().equals(that.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getIdEstadoTipoFactura().hashCode();
        result = 31 * result + getTipoFactura().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EstadoTipoFactura{" +
                "idEstadoTipoFactura=" + idEstadoTipoFactura +
                ", tipoFactura=" + tipoFactura +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
