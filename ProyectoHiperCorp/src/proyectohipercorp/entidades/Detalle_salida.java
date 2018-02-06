
package proyectohipercorp.entidades;

public class Detalle_salida {
    private Salida salida;
    private Articulo articulo;
    private int  cantidad;

    public Detalle_salida() {
    }

    public Detalle_salida(Salida salida, Articulo articulo, int cantidad) {
        this.salida = salida;
        this.articulo = articulo;
        this.cantidad = cantidad;
    }

    public Salida getSalida() {
        return salida;
    }

    public void setSalida(Salida salida) {
        this.salida = salida;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }  
}