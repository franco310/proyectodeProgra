
package proyectohipercorp.entidades;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombre, String apellido, String contraseña) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }

   

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    } 
    
    @Override
    public String toString() {
        return nombre; 
    }
     
}
