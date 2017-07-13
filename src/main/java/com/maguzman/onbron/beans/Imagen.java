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
@Table(name="imagen")
public class Imagen implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int idImagen;
    @Size(max = 100)
    private String nombre;
    @Size(max = 255)
    private String descripcion;
    @Size(max = 45)
    private String tipoObjeto;
    @Size(max = 45)
    private String tipoArchivo;
    private String stream;

    public Imagen(String nombre, String descripcion, String tipoObjeto, String tipoArchivo, String stream) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoObjeto = tipoObjeto;
        this.tipoArchivo = tipoArchivo;
        this.stream = stream;
    }

    public Imagen() {
        this.nombre = "";
        this.descripcion = "";
        this.tipoObjeto = "";
        this.tipoArchivo = "";
        this.stream = "";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoObjeto() {
        return tipoObjeto;
    }

    public void setTipoObjeto(String tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Imagen)) return false;

        Imagen imagen = (Imagen) o;

        if (getIdImagen() != imagen.getIdImagen()) return false;
        if (!getNombre().equals(imagen.getNombre())) return false;
        if (!getTipoObjeto().equals(imagen.getTipoObjeto())) return false;
        if (!getTipoArchivo().equals(imagen.getTipoArchivo())) return false;
        return getStream().equals(imagen.getStream());
    }

    @Override
    public int hashCode() {
        int result = getIdImagen();
        result = 31 * result + getNombre().hashCode();
        result = 31 * result + getTipoObjeto().hashCode();
        result = 31 * result + getTipoArchivo().hashCode();
        result = 31 * result + getStream().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Imagen{" +
                "idImagen=" + idImagen +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipoObjeto='" + tipoObjeto + '\'' +
                ", tipoArchivo='" + tipoArchivo + '\'' +
                ", stream='" + stream + '\'' +
                '}';
    }
}
