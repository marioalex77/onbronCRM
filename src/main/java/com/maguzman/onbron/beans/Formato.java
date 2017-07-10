package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="formato")
public class Formato implements Serializable {
    public static final long serialVersionUID= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFormato;
    @Size(max=50)
    private String descripcion;
    @Size(max=50)
    private String signoMoneda;
    @Size(max=50)
    private String encabezado;
    @Size(max=50)
    private String subtitulo;
    @Size(max=50)
    private String encabezadoDetalle;
    private String leyendaDetalle;
    @Size(max=50)
    private String tipodePago;
    @Size(max=50)
    private String nombreEmpresa;
    @Size(max=50)
    private String nit;
    @Size(max=50)
    private String lenguaje;
    @Size(max=25)
    private String codigoMoneda;
    @Size(max=25)
    private String posicionMoneda;
    @Size(max=30)
    private String estado;

    public Formato() {
        this.idFormato=0;
        this.descripcion = "";
    }

    public Formato(String descripcion) {
        this.idFormato=0;
        this.descripcion = descripcion;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdFormato() {
        return idFormato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSignoMoneda() {
        return signoMoneda;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getEncabezadoDetalle() {
        return encabezadoDetalle;
    }

    public String getLeyendaDetalle() {
        return leyendaDetalle;
    }

    public String getTipodePago() {
        return tipodePago;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNit() {
        return nit;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public String getCodigoMoneda() {
        return codigoMoneda;
    }

    public String getPosicionMoneda() {
        return posicionMoneda;
    }

    public String getEstado() {
        return estado;
    }

    public void setIdFormato(Integer idFormato) {
        this.idFormato = idFormato;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setSignoMoneda(String signoMoneda) {
        this.signoMoneda = signoMoneda;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public void setEncabezadoDetalle(String encabezadoDetalle) {
        this.encabezadoDetalle = encabezadoDetalle;
    }

    public void setLeyendaDetalle(String leyendaDetalle) {
        this.leyendaDetalle = leyendaDetalle;
    }

    public void setTipodePago(String tipodePago) {
        this.tipodePago = tipodePago;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public void setCodigoMoneda(String codigoMoneda) {
        this.codigoMoneda = codigoMoneda;
    }

    public void setPosicionMoneda(String posicionMoneda) {
        this.posicionMoneda = posicionMoneda;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Formato)) return false;

        Formato formato = (Formato) o;

        if (!getIdFormato().equals(formato.getIdFormato())) return false;
        return getDescripcion().equals(formato.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getIdFormato().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Formato{" +
                "idFormato=" + idFormato +
                ", descripcion='" + descripcion + '\'' +
                ", signoMoneda='" + signoMoneda + '\'' +
                ", encabezado='" + encabezado + '\'' +
                ", subtitulo='" + subtitulo + '\'' +
                ", encabezadoDetalle='" + encabezadoDetalle + '\'' +
                ", leyendaDetalle='" + leyendaDetalle + '\'' +
                ", tipodePago='" + tipodePago + '\'' +
                ", nombreEmpresa='" + nombreEmpresa + '\'' +
                ", nit='" + nit + '\'' +
                ", lenguaje='" + lenguaje + '\'' +
                ", codigoMoneda='" + codigoMoneda + '\'' +
                ", posicionMoneda='" + posicionMoneda + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
