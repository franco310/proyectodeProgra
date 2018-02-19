/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

/**
 *
 * @author Segovia
 */
public class DetalleCompra {
    private int codigoDetalleCompra;
    private Producto producto;
    private FacturaCompra facturacompra;
    private int cantidad;
    private int preciototal;

    public DetalleCompra() {
    }

    public DetalleCompra(int codigoDetalleCompra, Producto producto, FacturaCompra facturacompra, int cantidad, int preciototal) {
        this.codigoDetalleCompra = codigoDetalleCompra;
        this.producto = producto;
        this.facturacompra = facturacompra;
        this.cantidad = cantidad;
        this.preciototal = preciototal;
    }

    public int getCodigoDetalleCompra() {
        return codigoDetalleCompra;
    }

    public void setCodigoDetalleCompra(int codigoDetalleCompra) {
        this.codigoDetalleCompra = codigoDetalleCompra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public FacturaCompra getFacturacompra() {
        return facturacompra;
    }

    public void setFacturacompra(FacturaCompra facturacompra) {
        this.facturacompra = facturacompra;
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
