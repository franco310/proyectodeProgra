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
    
    private int codigoFacturaVenta;   
    private Date fecha;
    private Cliente cliente;

    public FacturaVenta() {
    }

    public FacturaVenta(int codigoFacturaVenta, Date fecha, Cliente cliente) {
        this.codigoFacturaVenta = codigoFacturaVenta;
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public int getCodigoFacturaVenta() {
        return codigoFacturaVenta;
    }

    public void setCodigoFacturaVenta(int codigoFacturaVenta) {
        this.codigoFacturaVenta = codigoFacturaVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

   

}