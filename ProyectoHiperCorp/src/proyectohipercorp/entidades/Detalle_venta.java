
package proyectohipercorp.entidades;

import java.sql.Date;

public class Detalle_venta {
    
 private Venta venta;
    private Articulo articulo;
    private int  cantidad;   
    private Date fecha_anulacion;
    private int monto;

    public Detalle_venta() {
    }

    public Detalle_venta(Venta venta, Articulo articulo, int cantidad, Date fecha_anulacion, int monto) {
        this.venta = venta;
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.fecha_anulacion = fecha_anulacion;
        this.monto = monto;
        
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
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