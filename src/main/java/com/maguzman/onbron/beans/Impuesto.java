package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
public class Impuesto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int idImpuesto;
    @NotEmpty
    @Size (min=3, max=50)
    private String nombre;
    @NotEmpty
    @Digits(integer = 2, fraction = 3, message = "El valor no puede ser mayor a 99.999")
    private double porcentaje;
    private String descripcion;
    @NotEmpty
    private String estado;

    public Impuesto() {
        this.idImpuesto=0;
        this.nombre = "";
        this.porcentaje = 0.00;
        this.descripcion = "";
        this.estado = Estado.ACTIVO.getEstado();
    }

    public Impuesto(String nombre, double porcentaje, String descripcion, String estado) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
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
        if (!(o instanceof Impuesto)) return false;

        Impuesto impuesto = (Impuesto) o;

        if (idImpuesto != impuesto.idImpuesto) return false;
        return nombre.equals(impuesto.nombre);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idImpuesto;
        result = 31 * result + nombre.hashCode();
        temp = Double.doubleToLongBits(porcentaje);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + descripcion.hashCode();
        result = 31 * result + estado.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Impuesto{" +
                "idImpuesto=" + idImpuesto +
                ", nombre='" + nombre + '\'' +
                ", porcentaje=" + porcentaje +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
