
package proyectohipercorp.entidades;

import java.sql.Date;

public class Detalle_venta {
    private int idDetalle_venta;
    private FacturaVenta facturaventa;
    private Producto producto;
    private int  cantidad;   
    private Date fecha_anulacion;
    private int monto;

    public Detalle_venta() {
    }

    public Detalle_venta(int idDetalle_venta, FacturaVenta facturaventa, Producto producto, int cantidad, Date fecha_anulacion, int monto) {
        this.idDetalle_venta = idDetalle_venta;
        this.facturaventa = facturaventa;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha_anulacion = fecha_anulacion;
        this.monto = monto;
    }

    public int getIdDetalle_venta() {
        return idDetalle_venta;
        
    }

    public void setIdDetalle_venta(int idDetalle_venta) {
        this.idDetalle_venta = idDetalle_venta;
    }

    public FacturaVenta getFacturaventa() {
        return facturaventa;
    }

    public void setFacturaventa(FacturaVenta facturaventa) {
        this.facturaventa = facturaventa;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(Date fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

}