/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

import java.sql.Date;

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

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_anulacion() {
        return fecha_anulacion;
    }

    public void setFecha_anulacion(Date fecha_anulacion) {
        this.fecha_anulacion = fecha_anulacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
