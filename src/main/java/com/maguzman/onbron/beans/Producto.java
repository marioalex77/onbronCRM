package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
public class Producto implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int idProducto;
    @Size(min=3, max=255)
    private String codigo;
    @Size(min=3, max=255)
    private String nombre;
    @Digits(integer = 8, fraction = 2, message = "El valor no puede ser mayor a 99999999.99")
    private double precioUnitario;
    @Digits(integer = 8, fraction = 2, message = "El valor no puede ser mayor a 99999999.99")
    private double precioCompra;
    @Digits(integer = 11, fraction = 0)
    private int orden;
    private String descripcion;
    private String estado = Estado.ACTIVO.getEstado();
    private char visible;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idDocumento")
    private Documento documento;
    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name="idImpuesto")
    private Impuesto impuesto;
    @ManyToOne
    @JoinColumn(name="idProveedor")
    private Proveedor proveedor;
    @Transient
    private MultipartFile file;
    @Transient
    private String fileDescripcion;

    public Producto() {
        super();
        this.idProducto = 0;
        this.codigo = "";
        this.nombre = "";
        this.precioUnitario = 0;
        this.precioCompra = 0;
        this.orden = 0;
        this.estado = Estado.ACTIVO.getEstado();
        this.visible = 0;
        this.documento = null;
        this.categoria = new Categoria();
        this.impuesto = new Impuesto();
        this.proveedor = new Proveedor();
    }

    public Producto(String codigo, String nombre, double precioUnitario,
                    double precioCompra, int orden, char habilitado, char visible,
                    Categoria categoria, Impuesto impuesto, Proveedor proveedor) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioCompra = precioCompra;
        this.orden = orden;
        this.estado = Estado.ACTIVO.getEstado();
        this.visible = visible;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
    }

    public Producto(int idProducto, String codigo, String nombre,
                    double precioUnitario, double precioCompra, int orden,
                    char habilitado, char visible, Categoria categoria,
                    Impuesto impuesto, Proveedor proveedor) {
        super();
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioCompra = precioCompra;
        this.orden = orden;
        this.estado = Estado.ACTIVO.getEstado();
        this.visible = visible;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public double getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }
    public int getOrden() {
        return orden;
    }
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public char getVisible() {
        return visible;
    }
    public void setVisible(char visible) {
        this.visible = visible;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Impuesto getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFileDescripcion() {
        return fileDescripcion;
    }

    public void setFileDescripcion(String fileDescripcion) {
        this.fileDescripcion = fileDescripcion;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precioUnitario=" + precioUnitario +
                ", precioCompra=" + precioCompra +
                ", orden=" + orden +
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado +
                ", visible=" + visible +
                ", categoria=" + categoria +
                ", impuesto=" + impuesto +
                ", proveedor=" + proveedor +
                '}';
    }
}
