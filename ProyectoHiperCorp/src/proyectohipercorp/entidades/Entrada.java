
package proyectohipercorp.entidades;

import java.sql.Date;

public class Entrada {
    private int idEntrada;
    private Proveedor proveedor;
    private Usuario usuario;  
    private Factura factura; 
     private Date fecha_entrada;

    public Entrada() {
    }

    public Entrada(int idEntrada, Proveedor proveedor, Usuario usuario, Factura factura, Date fecha_entrada) {
        this.idEntrada = idEntrada;
        this.proveedor = proveedor;
        this.usuario = usuario;
        this.factura = factura;
        this.fecha_entrada = fecha_entrada;
        
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProvedor(Proveedor provedor) {
        this.proveedor = provedor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
       
}