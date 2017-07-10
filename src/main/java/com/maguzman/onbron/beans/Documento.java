package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by maguzman on 18/05/2017.
 */
@Entity
@Table(name="documento")
public class Documento implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDocumento;
    @NotEmpty
    @Column(name="nombre", length=100, nullable=false)
    private String nombre;

    @Column(name="descripcion")
    private String descripcion;
    @NotEmpty
    @Column(name="tipo", length=100, nullable=false)
    private String tipo;

    @Lob @Basic(fetch = FetchType.LAZY)
    @Column(name="documento", nullable=false)
    private byte[] documento;

    public Documento() {
        this.idDocumento=0;
        this.nombre = "";
        this.descripcion = "";
        this.tipo = "";
    }

    public Documento(String nombre, String descripcion, String tipo, byte[] documento) {
        this.idDocumento=0;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.documento = documento;
    }


    public Integer getIdDocumento() {
        return idDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public byte[] getDocumento() {
        return documento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDocumento(byte[] documento) {
        this.documento = documento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Documento)) return false;

        Documento documento = (Documento) o;

        if (idDocumento != null ? !idDocumento.equals(documento.idDocumento) : documento.idDocumento != null)
            return false;
        return nombre != null ? nombre.equals(documento.nombre) : documento.nombre == null;
    }

    @Override
    public int hashCode() {
        int result = idDocumento != null ? idDocumento.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "idDocumento=" + idDocumento +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", tipo='" + tipo + '\'' +
                ", documento=" + Arrays.toString(documento) +
                '}';
    }
}
