package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
public class Imagen implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int idImagen;
    @Size(min=3, max=255)
    private String nombre;
    @Lob
    private byte[] imagen;

    public Imagen() {
        this.nombre="";
        this.imagen = null;
    }

    public Imagen(String nombre, byte[] imagen) {
        super();
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public Imagen(int idImagen, String nombre, byte[] imagen) {
        super();
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}
