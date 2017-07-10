package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="inventario")
public class Inventario implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventario;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name="idProducto")
    private Producto producto;
    @NotEmpty
    private Double cantidad;
    @NotEmpty
    private Double costo;
    @NotEmpty
    private GregorianCalendar fechaProduccion;
    @NotEmpty
    private GregorianCalendar fechaVencimiento;
    @NotEmpty
    private String comentario;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public Producto getProducto() {
        return producto;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Double getCosto() {
        return costo;
    }

    public GregorianCalendar getFechaProduccion() {
        return fechaProduccion;
    }

    public GregorianCalendar getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public void setFechaProduccion(GregorianCalendar fechaProduccion) {
        this.fechaProduccion = fechaProduccion;
    }

    public void setFechaVencimiento(GregorianCalendar fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inventario)) return false;

        Inventario that = (Inventario) o;

        return getIdInventario().equals(that.getIdInventario());
    }

    @Override
    public int hashCode() {
        return getIdInventario().hashCode();
    }
}
