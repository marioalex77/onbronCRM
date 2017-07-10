package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idCliente", nullable = false)
    private Cliente cliente;
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idTipoFactura", nullable = false)
    private TipoFactura tipoFactura;
    @NotEmpty
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idFormato", nullable = false)
    private Formato formato;
    @NotEmpty
    @DateTimeFormat
    private GregorianCalendar fecha;
    @NotEmpty
    private String comentarios;
    @NotEmpty
    @Digits(integer = 10, fraction = 2)
    private Double totalGrabado;
    @NotEmpty
    @Digits(integer = 10, fraction = 2)
    private Double totalExento;
    @NotEmpty
    @Digits(integer = 11, fraction = 2)
    private Double total;
    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="facturaitem",
            joinColumns = {@JoinColumn(name="idFactura")},
            inverseJoinColumns = {@JoinColumn(name="idFacturaItem")})
    private Set<FacturaItem> facturaItemSet = new HashSet<FacturaItem>(0);*/


    public Factura() {
        this.idFactura=0;
        this.cliente= new Cliente();
        this.tipoFactura = new TipoFactura();
        this.formato= new Formato();
        this.fecha = new GregorianCalendar();
        this.comentarios="";
        this.totalGrabado=0.00;
        this.totalExento=0.00;
        this.total=0.00;
    }

    public Factura(Cliente cliente, TipoFactura tipoFactura, Formato formato, GregorianCalendar fecha, String comentarios, Double totalGrabado, Double totalExento, Double total) {
        this.cliente = cliente;
        this.tipoFactura = tipoFactura;
        this.formato = formato;
        this.fecha = fecha;
        this.comentarios = comentarios;
        this.totalGrabado = totalGrabado;
        this.totalExento = totalExento;
        this.total = total;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public TipoFactura getTipoFactura() {
        return tipoFactura;
    }

    public Formato getFormato() {
        return formato;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public String getComentarios() {
        return comentarios;
    }

    public Double getTotalGrabado() {
        return totalGrabado;
    }

    public Double getTotalExento() {
        return totalExento;
    }

    public Double getTotal() {
        return total;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTipoFactura(TipoFactura tipoFactura) {
        this.tipoFactura = tipoFactura;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setTotalGrabado(Double totalGrabado) {
        this.totalGrabado = totalGrabado;
    }

    public void setTotalExento(Double totalExento) {
        this.totalExento = totalExento;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    /*public Set<FacturaItem> getFacturaItemSet() {
        return facturaItemSet;
    }

    public void setFacturaItemSet(Set<FacturaItem> facturaItemSet) {
        this.facturaItemSet = facturaItemSet;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Factura)) return false;

        Factura factura = (Factura) o;

        if (!getIdFactura().equals(factura.getIdFactura())) return false;
        if (!getCliente().equals(factura.getCliente())) return false;
        if (!getTipoFactura().equals(factura.getTipoFactura())) return false;
        if (!getFecha().equals(factura.getFecha())) return false;
        return getTotal().equals(factura.getTotal());
    }

    @Override
    public int hashCode() {
        int result = getIdFactura().hashCode();
        result = 31 * result + getCliente().hashCode();
        result = 31 * result + getTipoFactura().hashCode();
        result = 31 * result + getFecha().hashCode();
        result = 31 * result + getTotal().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura=" + idFactura +
                ", cliente=" + cliente +
                ", tipoFactura=" + tipoFactura +
                ", formato=" + formato +
                ", fecha=" + fecha +
                ", comentarios='" + comentarios + '\'' +
                ", totalGrabado=" + totalGrabado +
                ", totalExento=" + totalExento +
                ", total=" + total +
                '}';
    }
}

