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
    @Size(min=3, max=255)
    @Column(name="nombre")
    private String nombre;

    public Categoria() {
        this.nombre = "";
    }

    public Categoria(String nombre){

        this.nombre = nombre;
    }

    public Categoria(int idCategoria, String nombre){
        this.idCategoria = idCategoria;
        this.nombre = nombre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Categoria)) return false;

        Categoria categoria = (Categoria) o;

        if (getIdCategoria() != categoria.getIdCategoria()) return false;
        return getNombre().equals(categoria.getNombre());
    }

    @Override
    public int hashCode() {
        int result = getIdCategoria();
        result = 31 * result + getNombre().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
