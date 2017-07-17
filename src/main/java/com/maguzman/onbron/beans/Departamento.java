package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name="departamento")
public class Departamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDepartamento;
    @Size(max = 45)
    private String descripcion;

    public Departamento(Integer idDepartamento, String descripcion) {
        this.idDepartamento = idDepartamento;
        this.descripcion = descripcion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Departamento)) return false;

        Departamento that = (Departamento) o;

        if (!getIdDepartamento().equals(that.getIdDepartamento())) return false;
        return getDescripcion().equals(that.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getIdDepartamento().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Depdescripcionartamento{" +
                "idDepartamento=" + idDepartamento +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

}
