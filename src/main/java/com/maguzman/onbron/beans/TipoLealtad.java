package com.maguzman.onbron.beans;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
public class TipoLealtad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoLealtad;
    @Size(max=45)
    private String descripcion;

    public TipoLealtad(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoLealtad() {
        this.descripcion = "";
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getIdTipoLealtad() {
        return idTipoLealtad;
    }

    public void setIdTipoLealtad(Integer idTipoLealtad) {
        this.idTipoLealtad = idTipoLealtad;
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
        if (!(o instanceof TipoLealtad)) return false;

        TipoLealtad that = (TipoLealtad) o;

        if (!getIdTipoLealtad().equals(that.getIdTipoLealtad())) return false;
        return getDescripcion().equals(that.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result = getIdTipoLealtad().hashCode();
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TipoLealtad{" +
                "idTipoLealtad=" + idTipoLealtad +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
