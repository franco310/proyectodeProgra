
package proyectohipercorp.entidades;

public class Kardex {
    private int idKardex;
    private int precio_compra ;
    private int  precio_venta;
    private int  stok_anterior;
    private int  stock_actual;
    private int  cantidad;
    private Producto articulo;

    public Kardex() {
    }

    public Kardex(int idKardex, int precio_compra, int precio_venta, int stok_anterior, int stock_actual, int cantidad, Producto articulo) {
        this.idKardex = idKardex;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stok_anterior = stok_anterior;
        this.stock_actual = stock_actual;
        this.cantidad = cantidad;
        this.articulo = articulo;
        
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

    public Producto getArticulo() {
        return articulo;
    }

    public void setArticulo(Producto articulo) {
        this.articulo = articulo;
    }
   
}