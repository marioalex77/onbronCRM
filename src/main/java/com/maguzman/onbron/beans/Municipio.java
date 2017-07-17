package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMunicipio;
    @Size(max=45)
    private String descripcion;
    private Integer idDepartamento;

    public Municipio(Integer idMunicipio, String descripcion, Integer idDepartamento) {
        this.idMunicipio = idMunicipio;
        this.descripcion = descripcion;
        this.idDepartamento = idDepartamento;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Municipio)) return false;

        Municipio municipio = (Municipio) o;

        if (!getIdMunicipio().equals(municipio.getIdMunicipio())) return false;
        if (!getDescripcion().equals(municipio.getDescripcion())) return false;
        return getIdDepartamento().equals(municipio.getIdDepartamento());
    }

    @Override
    public int hashCode() {
        int result = getIdMunicipio().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        result = 31 * result + getIdDepartamento().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "idMunicipio=" + idMunicipio +
                ", descripcion='" + descripcion + '\'' +
                ", idDepartamento=" + idDepartamento +
                '}';
    }
}
