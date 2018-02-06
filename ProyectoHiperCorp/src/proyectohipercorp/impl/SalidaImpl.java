/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.ISalida;
import proyectohipercorp.entidades.Salida;

public class SalidaImpl implements ISalida{
     @Override
    public int insertar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into salida  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getIdSalida()));
        lstPar.add(new Parametro(2, salida.getFecha_registro()));
        lstPar.add(new Parametro(3, salida.getFecha_salida()));
        lstPar.add(new Parametro(4, salida.getResponsable()));
 
             
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE salida"
                + "   SET Idsalida=?, fecha_registro=?, fecha_salida=?, responsable=?, "
                + " where Idsalida=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getIdSalida()));
        lstPar.add(new Parametro(2, salida.getFecha_registro()));
        lstPar.add(new Parametro(3, salida.getFecha_salida()));
        lstPar.add(new Parametro(4, salida.getResponsable()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Salida salida) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM salida  where Idsalida=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, salida.getIdSalida()));       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            if (con != null) {
                con.desconectar();
            }
        }
        return numFilasAfectadas;
    }

    @Override
    public Salida obtener(int IdProvedor) throws Exception {
        Salida salida = null;
        String sql = "SELECT Idsalida, fecha_registro, fecha_salida , responsable,  "
                + " FROM salida where Idsalida=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                salida = new Salida();
                salida.setIdSalida(rst.getInt(1));
                salida.setFecha_registro(rst.getDate(2));
                salida.setFecha_salida(rst.getDate(3));
                salida.setResponsable(rst.getString(4));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return salida;
    }

    @Override
    public List<Salida> obtener() throws Exception {
        List<Salida> lista = new ArrayList<>();
         String sql = "SELECT Idsalida, fecha_registro, fecha_salida , responsable"
                + " FROM salida ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Salida salida=null;
            while (rst.next()) {
                salida = new Salida();
                salida.setIdSalida(rst.getInt(1));
                salida.setFecha_registro(rst.getDate(2));
                salida.setFecha_salida(rst.getDate(3));
                salida.setResponsable(rst.getString(4));
                lista.add(salida);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return lista;
    }
   
    
}
