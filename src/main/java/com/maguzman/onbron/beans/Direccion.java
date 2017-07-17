package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name="direccion")
public class Direccion {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDireccion;
    @NotEmpty
    private Cliente cliente;
    @Size(max=255)
    private String descripcion;
    @Size(max=255)
    private String referencia;
    @ManyToOne
    @JoinColumn(name="idDepartamento")
    private Departamento departamento;
    @ManyToOne
    @JoinColumn(name="idMunicipio")
    private Municipio municipio;
    @Size(max=10)
    private String telefono;
    @Digits(integer = 3, fraction = 6)
    private Double longitud;
    @Digits(integer = 3, fraction = 6)
    private Double latitud;
    @ManyToOne
    @JoinColumn(name="idTipoDireccion")
    private TipoDireccion tipoDireccion;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public TipoDireccion getTipoDireccion() {
        return tipoDireccion;
    }

    public void setTipoDireccion(TipoDireccion tipoDireccion) {
        this.tipoDireccion = tipoDireccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Direccion)) return false;

        Direccion direccion = (Direccion) o;

        if (!getIdDireccion().equals(direccion.getIdDireccion())) return false;
        if (!getCliente().equals(direccion.getCliente())) return false;
        if (!getDescripcion().equals(direccion.getDescripcion())) return false;
        if (!getDepartamento().equals(direccion.getDepartamento())) return false;
        if (!getMunicipio().equals(direccion.getMunicipio())) return false;
        if (getLongitud() != null ? !getLongitud().equals(direccion.getLongitud()) : direccion.getLongitud() != null)
            return false;
        if (getLatitud() != null ? !getLatitud().equals(direccion.getLatitud()) : direccion.getLatitud() != null)
            return false;
        return getTipoDireccion().equals(direccion.getTipoDireccion());
    }

    @Override
    public int hashCode() {
        int result = getIdDireccion().hashCode();
        result = 31 * result + getCliente().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        result = 31 * result + getDepartamento().hashCode();
        result = 31 * result + getMunicipio().hashCode();
        result = 31 * result + (getLongitud() != null ? getLongitud().hashCode() : 0);
        result = 31 * result + (getLatitud() != null ? getLatitud().hashCode() : 0);
        result = 31 * result + getTipoDireccion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "idDireccion=" + idDireccion +
                ", cliente=" + cliente +
                ", descripcion='" + descripcion + '\'' +
                ", referencia='" + referencia + '\'' +
                ", departamento=" + departamento +
                ", municipio=" + municipio +
                ", telefono='" + telefono + '\'' +
                ", longitud=" + longitud +
                ", latitud=" + latitud +
                ", tipoDireccion=" + tipoDireccion +
                '}';
    }
}
