
package proyectohipercorp.entidades;

import java.sql.Date;

public class Cliente {
    
     private int idCliente;
      private String nombre;
      private String apellido;
      private String direccion;
      private String telefono;
      private String email;
      private Date fecha_Nace;

    public Cliente() {
    }

    public Cliente(int idCliente, String nombre, String apellido, String direccion, String telefono, String email, Date fecha_Nace) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_Nace = fecha_Nace;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_Nace() {
        return fecha_Nace;
    }

    public void setFecha_Nace(Date fecha_Nace) {
        this.fecha_Nace = fecha_Nace;
    }
}