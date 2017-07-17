package com.maguzman.onbron.beans;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by maguzman on 17/07/2017.
 */
@Entity
@Table(name="zonacobertura")
public class ZonaCobertura implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZonaCobertura;
    @Size(max=45)
    private String descripcion;
    @Digits(integer = 6, fraction = 6)
    private Double latitudIni;
    @Digits(integer = 6, fraction = 6)
    private Double longitudIni;
    @Digits(integer = 6, fraction = 6)
    private Double latitudFin;
    @Digits(integer = 6, fraction = 6)
    private Double longitudFin;
}
