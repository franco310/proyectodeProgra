/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

/**
 *
 * @author Usuario
 */
public class Proveedor {
    private int idProveedor;
    private int ruc; 
      private String nombre;
      private String apellido;
      private String direccion;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, int ruc, String nombre, String apellido, String direccion) {
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

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
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
