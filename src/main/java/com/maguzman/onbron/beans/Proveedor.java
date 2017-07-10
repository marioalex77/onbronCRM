package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    @NotEmpty
    @Size(min=3, max=255)
    private String nombre;
    private String nrc;// Numero de registro de contribuyente
    private String nit;
    private String email;
    private String telefono;

    public Proveedor() {
        this.nombre = "";
        this.nrc="";
        this.nit="";
        this.email="";
        this.telefono="";
    }

    public Proveedor(int idProveedor, String nombre) {
        super();
        this.idProveedor = idProveedor;
        this.nombre = nombre;
    }

    public Proveedor(String nombre, String nrc, String nit) {
        this.nombre = nombre;
        this.nrc = nrc;
        this.nit = nit;
        this.email="";
        this.telefono="";
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Proveedor)) return false;

        Proveedor proveedor = (Proveedor) o;

        if (idProveedor != proveedor.idProveedor) return false;
        return (nombre != null ? nombre.equals(proveedor.nombre) : proveedor.nombre == null);
    }

    @Override
    public int hashCode() {
        int result = idProveedor;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "idProveedor=" + idProveedor +
                ", nombre='" + nombre + '\'' +
                ", nrc='" + nrc + '\'' +
                ", nit='" + nit + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
