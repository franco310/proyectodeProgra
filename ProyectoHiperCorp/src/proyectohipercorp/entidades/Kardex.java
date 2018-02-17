
package proyectohipercorp.entidades;

import java.sql.Date;

public class Kardex {
    private int idKardex;
    
    private Producto producto;
    private Date fechaEmision;
    private String tipotransaccion;
    private int existencias;
    private int valortotal;

    public Kardex() {
    }

    public Kardex(int idKardex, Producto producto, Date fechaEmision, String tipotransaccion, int existencias, int valortotal) {
        this.idKardex = idKardex;
        this.producto = producto;
        this.fechaEmision = fechaEmision;
        this.tipotransaccion = tipotransaccion;
        this.existencias = existencias;
        this.valortotal = valortotal;
    }

    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getTipotransaccion() {
        return tipotransaccion;
    }

    public void setTipotransaccion(String tipotransaccion) {
        this.tipotransaccion = tipotransaccion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    
}