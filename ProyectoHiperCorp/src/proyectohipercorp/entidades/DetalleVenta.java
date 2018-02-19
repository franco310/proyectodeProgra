
package proyectohipercorp.entidades;

import java.sql.Date;

public class DetalleVenta {
    private int codigoDetalleVenta;
    private Producto producto;
    private FacturaVenta facturaventa;
    private int cantidad;
    private int preciototal;

    public DetalleVenta() {
    }

    public DetalleVenta(int codigoDetalleVenta, Producto producto, FacturaVenta facturaventa, int cantidad, int preciototal) {
        this.codigoDetalleVenta = codigoDetalleVenta;
        this.producto = producto;
        this.facturaventa = facturaventa;
        this.cantidad = cantidad;
        this.preciototal = preciototal;
    }

    public int getCodigoDetalleVenta() {
        return codigoDetalleVenta;
    }

    public void setCodigoDetalleVenta(int codigoDetalleVenta) {
        this.codigoDetalleVenta = codigoDetalleVenta;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(int preciototal) {
        this.preciototal = preciototal;
    }

   
   
}