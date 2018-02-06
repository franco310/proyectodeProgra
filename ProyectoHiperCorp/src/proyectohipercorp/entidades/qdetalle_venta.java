/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

import java.sql.Date;

/**
 *
 * @author Usuario
 */
public class qdetalle_venta {
    
 private int idVenta;
    private int idArticulo;
    private int  monto;   
     private Date fecha_anulacion;

    public qdetalle_venta() {
    }

    public qdetalle_venta(int idVenta, int idArticulo, int monto, Date fecha_anulacion) {
        this.idVenta = idVenta;
        this.idArticulo = idArticulo;
        this.monto = monto;
        this.fecha_anulacion = fecha_anulacion;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(Date fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }
     
     
}
