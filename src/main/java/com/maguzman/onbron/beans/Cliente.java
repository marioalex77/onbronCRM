package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="categoria")
public class Cliente implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    @NotEmpty
    @Size(max=45)
    private String nombres;
    @NotEmpty
    @Size(max=45)
    private String primerApellido;
    @Size(max=45)
    private String segundoApellido;
    @NotEmpty
    @Size(max=1)
    private Character genero;
    @Size(max=255)
    private String email;
    @Size(max=10)
    private String telefono;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public Character getGenero() {
        return genero;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombres='" + nombres + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", genero=" + genero +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;

        Cliente cliente = (Cliente) o;

        return getIdCliente().equals(cliente.getIdCliente());
    }

    @Override
    public int hashCode() {
        return getIdCliente().hashCode();
    }
}
