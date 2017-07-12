package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */

import com.maguzman.onbron.enumeraciones.Estado;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import javax.persistence.*;
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
    private double valor;
    private String descripcion;
    @NotEmpty
    private String estado;
    @ManyToOne
    @JoinColumn(name="idTipoImpuesto")
    private TipoImpuesto tipoImpuesto;

    public Impuesto() {
        this.idImpuesto=0;
        this.nombre = "";
        this.valor = 0.00;
        this.descripcion = "";
        this.estado = Estado.ACTIVO.getEstado();
    }

    public Impuesto(String nombre, double valor, String descripcion, String estado) {
        this.nombre = nombre;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    public void setTipoImpuesto(TipoImpuesto tipoImpuesto) {
        this.tipoImpuesto = tipoImpuesto;
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
        temp = Double.doubleToLongBits(valor);
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
                ", valor=" + valor +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
