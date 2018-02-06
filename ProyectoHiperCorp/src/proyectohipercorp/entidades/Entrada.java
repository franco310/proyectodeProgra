
package proyectohipercorp.entidades;

import java.sql.Date;

public class Entrada {
    private int idEntrada;
    private int idProveedor;
    private String usuario;  
    private String factura; 
     private Date fecha_entrada;

    public Entrada() {
    }

    public Entrada(int idEntrada, int idProveedor, String usuario, String factura, Date fecha_entrada) {
        this.idEntrada = idEntrada;
        this.idProveedor = idProveedor;
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

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }
    
}