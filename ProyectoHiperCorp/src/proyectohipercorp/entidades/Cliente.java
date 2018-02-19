
package proyectohipercorp.entidades;

import java.sql.Date;

public class Cliente {
    
     private int cedula;
      private String nombres;
      private String apellidos;
      private String direccion;
      private String telefono;
      private String email;
      private Date fecha_Nace;

    public Cliente() {
    }

    public Cliente(int cedula, String nombres, String apellidos, String direccion, String telefono, String email, Date fecha_Nace) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fecha_Nace = fecha_Nace;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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