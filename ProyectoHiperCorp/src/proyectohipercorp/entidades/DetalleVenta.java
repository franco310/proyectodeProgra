
package proyectohipercorp.entidades;

import java.sql.Date;

public class DetalleVenta {
    private int idCodigodetalle_venta;
    private  Producto producto;
    private FacturaVenta facturaventa;
    private int precio;
    private int preciototal;

    public DetalleVenta() {
    }

    public DetalleVenta(int idCodigodetalle_venta, Producto producto, FacturaVenta facturaventa, int precio, int preciototal) {
        this.idCodigodetalle_venta = idCodigodetalle_venta;
        this.producto = producto;
        this.facturaventa = facturaventa;
        this.precio = precio;
        this.preciototal = preciototal;
    }

    public int getIdCodigodetalle_venta() {
        return idCodigodetalle_venta;
    }

    public void setIdCodigodetalle_venta(int idCodigodetalle_venta) {
        this.idCodigodetalle_venta = idCodigodetalle_venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaVenta getFacturaventa() {
        return facturaventa;
    }

    public void setFacturaventa(FacturaVenta facturaventa) {
        this.facturaventa = facturaventa;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }
    
    
}