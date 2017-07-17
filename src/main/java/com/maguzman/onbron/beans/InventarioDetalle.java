package com.maguzman.onbron.beans;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name="inventarioDetalle")
public class InventarioDetalle implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInventarioDetalle;
    @ManyToOne
    @JoinColumn(name="idInventario")
    private Inventario inventario;
    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name ="idFacturaItem")
    private FacturaItem facturaItem;
    @ManyToOne
    @JoinColumn(name="idProveedor")
    private Proveedor proveedor;

    public InventarioDetalle(Inventario inventario, FacturaItem facturaItem, Proveedor proveedor) {
        this.inventario = inventario;
        this.facturaItem = facturaItem;
        this.proveedor = proveedor;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdInventarioDetalle() {
        return idInventarioDetalle;
    }

    public void setIdInventarioDetalle(Integer idInventarioDetalle) {
        this.idInventarioDetalle = idInventarioDetalle;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public FacturaItem getFacturaItem() {
        return facturaItem;
    }

    public void setFacturaItem(FacturaItem facturaItem) {
        this.facturaItem = facturaItem;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InventarioDetalle)) return false;

        InventarioDetalle that = (InventarioDetalle) o;

        if (!getIdInventarioDetalle().equals(that.getIdInventarioDetalle())) return false;
        if (!getInventario().equals(that.getInventario())) return false;
        if (!getFacturaItem().equals(that.getFacturaItem())) return false;
        return getProveedor().equals(that.getProveedor());
    }

    @Override
    public int hashCode() {
        int result = getIdInventarioDetalle().hashCode();
        result = 31 * result + getInventario().hashCode();
        result = 31 * result + getFacturaItem().hashCode();
        result = 31 * result + getProveedor().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "InventarioDetalle{" +
                "idInventarioDetalle=" + idInventarioDetalle +
                ", inventario=" + inventario +
                ", facturaItem=" + facturaItem +
                ", proveedor=" + proveedor +
                '}';
    }
}
