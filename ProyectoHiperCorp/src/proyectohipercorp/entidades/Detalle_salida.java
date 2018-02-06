
package proyectohipercorp.entidades;

public class Detalle_salida {
    private int idSalida;
    private int idArticulo;
    private int  cantidad;

    public Detalle_salida() {
    }

    public Detalle_salida(int idSalida, int idArticulo, int cantidad) {
        this.idSalida = idSalida;
        this.idArticulo = idArticulo;
        this.cantidad = cantidad;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
      
    
}