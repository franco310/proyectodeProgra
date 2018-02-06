/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.entidades;

import java.sql.Date;

/**
 *
 * @author diego
 */
public class Salida {
    private int idSalida;
    private Date fecha_registro;
    private Date fecha_salida;
    private String responsable;

    public Salida() {
    }

    public Salida(int idSalida, Date fecha_registro, Date fecha_salida, String responsable) {
        this.idSalida = idSalida;
        this.fecha_registro = fecha_registro;
        this.fecha_salida = fecha_salida;
        this.responsable = responsable;
    }

    public int getIdSalida() {
        return idSalida;
    }

    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    
    
    
}
