package proyectohipercorp.entidades;
public class Articulo {
    private int idArticulo;
    private String nombre;
    private int cantidad;
    private String estado;
    private String observacio;

    public Articulo() {
    }

    public Articulo(int idArticulo, String nombre, int cantidad, String estado, String observacio) {
        this.idArticulo = idArticulo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estado = estado;
        this.observacio = observacio;
        
    }

  

    public int getIdArticulo() {
        return idArticulo;
    }

    public void setIdArticulo(int idArticulo) {
        this.idArticulo = idArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacio() {
        return observacio;
    }

    public void setObservacio(String observacio) {
        this.observacio = observacio;
    }

   @Override
    public String toString() {
        return nombre; 
    }
}