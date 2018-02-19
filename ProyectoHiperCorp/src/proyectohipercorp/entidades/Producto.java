

package proyectohipercorp.entidades;
public class Producto {
    private int CodigoProducto;
    private Categoria categoria;
    private String nombre;
    private int precio;

    public Producto() {
    }

    public Producto(int CodigoProducto, Categoria categoria, String nombre, int precio) {
        this.CodigoProducto = CodigoProducto;
        this.categoria = categoria;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCodigoProducto() {
        return CodigoProducto;
    }

    public void setCodigoProducto(int CodigoProducto) {
        this.CodigoProducto = CodigoProducto;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
   

    

    

   
}