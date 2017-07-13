package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */
import com.maguzman.onbron.enumeraciones.Estado;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
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
    @Size(max=255)
    private String codigo;
    @Size(max=255)
    private String nombre;
    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name="idImpuesto")
    private Impuesto impuesto;
    @ManyToOne
    @JoinColumn(name="idProveedor")
    private Proveedor proveedor;
    @ManyToOne
    @JoinColumn(name="idTipoProducto")
    private TipoProducto tipoProducto;
    @Digits(integer = 8, fraction = 2, message = "El valor no puede ser mayor a 99999999.99")
    private double precioUnitario;
    private int orden;
    private String descripcion;
    private String estado = Estado.ACTIVO.getEstado();
    private char visible;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idImagen")
    private Imagen imagen;
    @DateTimeFormat
    private DateTime fechaDesde;
    @DateTimeFormat
    private DateTime fechaHasta;

    @Transient
    private MultipartFile file;
    @Transient
    private String fileDescripcion;

    public Producto(String codigo, String nombre, Categoria categoria, Impuesto impuesto, Proveedor proveedor, TipoProducto tipoProducto, double precioUnitario, int orden, String descripcion, String estado, char visible, Imagen imagen, DateTime fechaDesde, DateTime fechaHasta, MultipartFile file, String fileDescripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
        this.tipoProducto = tipoProducto;
        this.precioUnitario = precioUnitario;
        this.orden = orden;
        this.descripcion = descripcion;
        this.estado = estado;
        this.visible = visible;
        this.imagen = imagen;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
        this.file = file;
        this.fileDescripcion = fileDescripcion;
    }

    public Producto(String codigo, String nombre, Categoria categoria, Impuesto impuesto, Proveedor proveedor, TipoProducto tipoProducto, double precioUnitario, int orden, String descripcion, String estado, char visible, Imagen imagen, DateTime fechaDesde, DateTime fechaHasta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
        this.tipoProducto = tipoProducto;
        this.precioUnitario = precioUnitario;
        this.orden = orden;
        this.descripcion = descripcion;
        this.estado = estado;
        this.visible = visible;
        this.imagen = imagen;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public Producto(String codigo, String nombre, Categoria categoria, Impuesto impuesto, Proveedor proveedor, TipoProducto tipoProducto, double precioUnitario, String estado, char visible, Imagen imagen, DateTime fechaDesde) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
        this.tipoProducto = tipoProducto;
        this.precioUnitario = precioUnitario;
        this.estado = estado;
        this.visible = visible;
        this.imagen = imagen;
        this.fechaDesde = fechaDesde;
    }

    public Producto() {
        this.codigo = "";
        this.nombre = "";
        this.categoria = null;
        this.impuesto = null;
        this.proveedor = null;
        this.tipoProducto = null;
        this.precioUnitario = 0.00;
        this.estado = "";
        this.visible = 0;
        this.imagen = null;
        this.fechaDesde = null;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public DateTime getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(DateTime fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public DateTime getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(DateTime fechaHasta) {
        this.fechaHasta = fechaHasta;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;

        Producto producto = (Producto) o;

        if (getIdProducto() != producto.getIdProducto()) return false;
        if (!getCodigo().equals(producto.getCodigo())) return false;
        return getNombre().equals(producto.getNombre());
    }

    @Override
    public int hashCode() {
        int result = getIdProducto();
        result = 31 * result + getCodigo().hashCode();
        result = 31 * result + getNombre().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria=" + categoria.toString() +
                ", impuesto=" + impuesto.toString() +
                ", proveedor=" + proveedor.toString() +
                ", tipoProducto=" + tipoProducto.toString() +
                ", precioUnitario=" + precioUnitario +
                ", orden=" + orden +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", visible=" + visible +
                ", imagen=" + imagen.toString() +
                ", fechaDesde=" + fechaDesde.toString() +
                ", fechaHasta=" + fechaHasta.toString() +
                ", file=" + file.toString() +
                ", fileDescripcion='" + fileDescripcion + '\'' +
                '}';
    }
}
