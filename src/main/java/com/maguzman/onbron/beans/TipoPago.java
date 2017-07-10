package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="tipopago")
public class TipoPago implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoPago;
    @NotEmpty
    @Size(max=255)
    private String descripcion;
    @NotEmpty
    @Size(max=30)
    private String estado;

    public TipoPago() {
        this.idTipoPago = 0;
        this.descripcion = "";
        this.estado = Estado.ACTIVO.getEstado();
    }

    public TipoPago(Integer idTipoPago, String descripcion, String estado) {
        this.idTipoPago = idTipoPago;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdTipoPago() {
        return idTipoPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdTipoPago(Integer idTipoPago) {
        this.idTipoPago = idTipoPago;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoPago)) return false;

        TipoPago tipoPago = (TipoPago) o;

        if (!getIdTipoPago().equals(tipoPago.getIdTipoPago())) return false;
        return getDescripcion().equals(tipoPago.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getIdTipoPago().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TipoPago{" +
                "idTipoPago=" + idTipoPago +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
