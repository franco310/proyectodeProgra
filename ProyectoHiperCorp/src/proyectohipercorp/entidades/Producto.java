

package proyectohipercorp.entidades;
public class Producto {
    private int idProducto;
    private Categoria categoria;
    private String nombre;
    private int cantidad;
    private String estado;
    private String observacio;
    

    public Producto() {
    }

    public Producto(int idProducto, Categoria categoria, String nombre, int cantidad, String estado, String observacio) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.estado = estado;
        this.observacio = observacio;
    }

   @Override
    public String toString() {
        return nombre; 
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
}