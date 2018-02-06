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
public class Venta {
    private int idVenta;
    private Date fecha_emision;
    private Date fecha_anulacion;
    private Cliente cliente;
    private Usuario usuario;

    public Venta() {
    }

    public Venta(int idVenta, Date fecha_emision, Date fecha_anulacion, Cliente cliente, Usuario usuario) {
        this.idVenta = idVenta;
        this.fecha_emision = fecha_emision;
        this.fecha_anulacion = fecha_anulacion;
        this.cliente = cliente;
        this.usuario = usuario;
    }

    
}
