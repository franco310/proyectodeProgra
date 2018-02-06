
package proyectohipercorp.entidades;


public class Proveedor {
    private int idProveedor;
    private String ruc; 
      private String nombre;
      private String apellido;
      private String direccion;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String ruc, String nombre, String apellido, String direccion) {
        this.idProveedor = idProveedor;
        this.ruc = ruc;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
      
      
}