package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="categoria")
public class Categoria implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCategoria;
    @Size(max=255)
    @Column(name="nombre")
    private String nombre;
    @ManyToOne
    @JoinColumn(name="idTipoProducto")
    private TipoProducto tipoProducto;

    public Categoria() {
        this.nombre = "";
        this.tipoProducto = null;
    }

    public Categoria(String nombre, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.tipoProducto = tipoProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;

        Categoria categoria = (Categoria) o;

        if (getIdCategoria() != categoria.getIdCategoria()) return false;
        if (!getNombre().equals(categoria.getNombre())) return false;
        return getTipoProducto().equals(categoria.getTipoProducto());
    }

    @Override
    public int hashCode() {
        int result = getIdCategoria();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + getTipoProducto().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                ", tipoProducto=" + tipoProducto +
                '}';
    }
}
