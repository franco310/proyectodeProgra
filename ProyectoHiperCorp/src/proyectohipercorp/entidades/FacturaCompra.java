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
    
    private int idFacturacompra;
    private Date fecha;
    private Proveedor proveedor;

    public FacturaCompra() {
    }

    public FacturaCompra(int idFacturacompra, Date fecha, Proveedor proveedor) {
        this.idFacturacompra = idFacturacompra;
        this.fecha = fecha;
        this.proveedor = proveedor;
    }

    public int getIdFacturacompra() {
        return idFacturacompra;
    }

    public void setIdFacturacompra(int idFacturacompra) {
        this.idFacturacompra = idFacturacompra;
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
