/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

import java.sql.Date;

/**
 *
 * @author Segovia
 */
public class FacturaCompra {
    
    private int codigoFacturaCompra;
    private Date fecha;
    private Proveedor proveedor;

    public FacturaCompra() {
    }

    public FacturaCompra(int codigoFacturaCompra, Date fecha, Proveedor proveedor) {
        this.codigoFacturaCompra = codigoFacturaCompra;
        this.fecha = fecha;
        this.proveedor = proveedor;
    }

    public int getCodigoFacturaCompra() {
        return codigoFacturaCompra;
    }

    public void setCodigoFacturaCompra(int codigoFacturaCompra) {
        this.codigoFacturaCompra = codigoFacturaCompra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
}
