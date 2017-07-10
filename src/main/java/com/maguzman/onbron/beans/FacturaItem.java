package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.io.Serializable;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="facturaitem")
public class FacturaItem implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFacturaItem;
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idFactura", nullable = false)
    private Factura factura;
    @NotEmpty
    private Integer cantidad;
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idProducto", nullable = false)
    private Producto producto;
    @NotEmpty
    @Digits(integer = 10, fraction = 2)
    private Double precioUnitario;
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idImpuesto", nullable = false)
    private Impuesto tipoImpuesto;
    @NotEmpty
    @Digits(integer = 15, fraction = 6)
    private Double impuesto;
    @NotEmpty
    @Digits(integer = 10, fraction = 2)
    private Double subTotal;
    private String descripcion;

    public FacturaItem() {
        this.idFacturaItem=0;
        this.producto = new Producto();
        this.factura = new Factura();
        this.precioUnitario= 0.00;
        this.cantidad=0;
        this.tipoImpuesto= new Impuesto();
        this.impuesto = 0.00;
        this.subTotal = 0.00;
        this.descripcion="";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdFacturaItem() {
        return idFacturaItem;
    }

    public Factura getFactura() {
        return factura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Impuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public Double getImpuesto() {
        return impuesto;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setIdFacturaItem(Integer idFacturaItem) {
        this.idFacturaItem = idFacturaItem;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setTipoImpuesto(Impuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
    }

    public void setImpuesto(Double impuesto) {
        this.impuesto = impuesto;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FacturaItem)) return false;

        FacturaItem that = (FacturaItem) o;

        if (!getIdFacturaItem().equals(that.getIdFacturaItem())) return false;
        if (!getFactura().equals(that.getFactura())) return false;
        if (!getCantidad().equals(that.getCantidad())) return false;
        return getProducto().equals(that.getProducto());
    }

    @Override
    public int hashCode() {
        int result = getIdFacturaItem().hashCode();
        result = 31 * result + getFactura().hashCode();
        result = 31 * result + getCantidad().hashCode();
        result = 31 * result + getProducto().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "FacturaItem{" +
                "idFacturaItem=" + idFacturaItem +
                ", factura=" + factura +
                ", cantidad=" + cantidad +
                ", producto=" + producto +
                ", precioUnitario=" + precioUnitario +
                ", tipoImpuesto=" + tipoImpuesto +
                ", impuesto=" + impuesto +
                ", subTotal=" + subTotal +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
