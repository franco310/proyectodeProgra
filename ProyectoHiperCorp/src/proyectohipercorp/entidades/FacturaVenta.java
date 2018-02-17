/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

import java.sql.Date;

/**
 *
 * @author diego
 */
public class FacturaVenta {
    
    private int idFactura;
    private Date fecha;
    private String nombreCliente;
    private String nombreProducto;
    private int cantidad;
    private int precio;
    

    public FacturaVenta() {
    }

    public FacturaVenta(int idFactura, Date fecha, String nombreCliente, String nombreProducto, int cantidad, int precio) {
        this.idFactura = idFactura;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
