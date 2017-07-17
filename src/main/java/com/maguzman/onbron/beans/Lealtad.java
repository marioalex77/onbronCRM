package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name="lealtad")
public class Lealtad implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLealtad;
    @ManyToOne
    @JoinColumn(name="idCliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name="idTipoLealtad")
    private TipoLealtad tipoLealtad;
    @Digits(integer = 6, fraction = 6)
    private Double valor;
    @Size(max=20)
    private String referencia;

    public Lealtad(Cliente cliente, TipoLealtad tipoLealtad, Double valor, String referencia) {
        this.cliente = cliente;
        this.tipoLealtad = tipoLealtad;
        this.valor = valor;
        this.referencia = referencia;
    }

    public Lealtad() {
        this.cliente = null;
        this.tipoLealtad = null;
        this.valor = 0.00;
        this.referencia = "";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdLealtad() {
        return idLealtad;
    }

    public void setIdLealtad(Integer idLealtad) {
        this.idLealtad = idLealtad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoLealtad getTipoLealtad() {
        return tipoLealtad;
    }

    public void setTipoLealtad(TipoLealtad tipoLealtad) {
        this.tipoLealtad = tipoLealtad;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lealtad)) return false;

        Lealtad lealtad = (Lealtad) o;

        if (!getIdLealtad().equals(lealtad.getIdLealtad())) return false;
        if (!getValor().equals(lealtad.getValor())) return false;
        return getReferencia().equals(lealtad.getReferencia());
    }

    @Override
    public int hashCode() {
        int result = getIdLealtad().hashCode();
        result = 31 * result + getValor().hashCode();
        result = 31 * result + getReferencia().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Lealtad{" +
                "idLealtad=" + idLealtad +
                ", cliente=" + cliente +
                ", tipoLealtad=" + tipoLealtad +
                ", valor=" + valor +
                ", referencia='" + referencia + '\'' +
                '}';
    }
}
