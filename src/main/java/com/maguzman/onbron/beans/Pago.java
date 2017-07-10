package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * Created by maguzman on 23/05/2017.
 */
@Entity
@Table(name="pago")
public class Pago implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpago;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name="idFactura")
    private Factura factura;
    @NotEmpty
    @ManyToOne
    @JoinColumn(name="idTipoPago")
    private TipoPago tipoPago;
    @NotEmpty
    @Digits(integer = 10,fraction = 2)
    private Double monto;
    @NotEmpty
    private GregorianCalendar fecha;
    @NotEmpty
    @Size(max=255)
    private String referenciaExterna;
    private String comentario;

    public Pago() {
        this.idpago = 0;
        this.factura = new Factura();
        this.tipoPago = new TipoPago();
        this.monto = 0.00;
        this.fecha = new GregorianCalendar();
        this.referenciaExterna = "";
        this.comentario = "";
    }

    public Integer getIdpago() {
        return idpago;
    }

    public Factura getFactura() {
        return factura;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public Double getMonto() {
        return monto;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public String getReferenciaExterna() {
        return referenciaExterna;
    }

    public String getComentario() {
        return comentario;
    }

    public void setIdpago(Integer idpago) {
        this.idpago = idpago;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public void setReferenciaExterna(String referenciaExterna) {
        this.referenciaExterna = referenciaExterna;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pago)) return false;

        Pago pago = (Pago) o;

        if (!getIdpago().equals(pago.getIdpago())) return false;
        if (!getFactura().equals(pago.getFactura())) return false;
        if (!getTipoPago().equals(pago.getTipoPago())) return false;
        if (!getMonto().equals(pago.getMonto())) return false;
        return getFecha().equals(pago.getFecha());
    }

    @Override
    public int hashCode() {
        int result = getIdpago().hashCode();
        result = 31 * result + getFactura().hashCode();
        result = 31 * result + getTipoPago().hashCode();
        result = 31 * result + getMonto().hashCode();
        result = 31 * result + getFecha().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Pago{" +
                "idpago=" + idpago +
                ", factura=" + factura +
                ", tipoPago=" + tipoPago +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", referenciaExterna='" + referenciaExterna + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
