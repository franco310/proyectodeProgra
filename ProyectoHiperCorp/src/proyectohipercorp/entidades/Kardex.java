/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

/**
 *
 * @author Usuario
 */
public class Kardex {
    private int idKardex;
    private int precio_compra ;
    private int  precio_venta;
    private int  stok_anterior;
    private int  stock_actual;
    private int  cantidad;
    private int idArticulo;
    private int idEntrada;
    private int idSalida;

    public Kardex() {
    }

    public Kardex(int idKardex, int precio_compra, int precio_venta, int stok_anterior, int stock_actual, int cantidad, int idArticulo, int idEntrada, int idSalida) {
        this.idKardex = idKardex;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stok_anterior = stok_anterior;
        this.stock_actual = stock_actual;
        this.cantidad = cantidad;
        this.idArticulo = idArticulo;
        this.idEntrada = idEntrada;
        this.idSalida = idSalida;
    }

    public int getIdKardex() {
        return idKardex;
    }

    public void setIdKardex(int idKardex) {
        this.idKardex = idKardex;
    }

    public int getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(int precio_compra) {
        this.precio_compra = precio_compra;
    }

    public int getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(int precio_venta) {
        this.precio_venta = precio_venta;
    }

    public int getStok_anterior() {
        return stok_anterior;
    }

    public void setStok_anterior(int stok_anterior) {
        this.stok_anterior = stok_anterior;
    }

    public int getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(int stock_actual) {
        this.stock_actual = stock_actual;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }
    
    
}
