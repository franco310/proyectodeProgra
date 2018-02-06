/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.impl;
import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.dao.IDetalle_salida;
import proyectohipercorp.entidades.Detalle_salida;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;

/**
 *
 * @author Segovia
 */
public class Detalle_salidaImpl implements IDetalle_salida{
   
    @Override
    public int insertar(Detalle_salida detalle_salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into detalle_salida values(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_salida.getIdSalida()));
        lstPar.add(new Parametro(2, detalle_salida.getIdArticulo()));
       lstPar.add(new Parametro(3, detalle_salida.getCantidad()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int modificar(Detalle_salida detalle_salida) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  detalle_salida set idSalida=?,IdArticulo=?,cantidad=?, where getIdSalida=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_salida.getIdSalida()));
        lstPar.add(new Parametro(2, detalle_salida.getIdArticulo()));
       lstPar.add(new Parametro(3, detalle_salida.getCantidad()));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            numFilasAfectadas = con.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return numFilasAfectadas;
    }

    @Override
    public int eliminar(Detalle_salida detalle_salida) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public Detalle_salida obtener(int idSalida) throws Exception {
        Detalle_salida detalle_salida = null;
         String sql = "select idSalida, descripcion from detalle_salida where idSalida=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idSalida));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                detalle_salida= new Detalle_salida();
                detalle_salida.setIdSalida(rst.getInt(1));
                detalle_salida.setIdArticulo(rst.getInt(2));  
               detalle_salida.setCantidad(rst.getInt(3));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return detalle_salida;
    }

    @Override
    public List<Detalle_salida> obtener() throws Exception {
        List<Detalle_salida> lista = new ArrayList<>();
         String sql = "select idSalida, descripcion from detalle_salida";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Detalle_salida detalle_salida= null;
            while(rst.next()){
                detalle_salida= new Detalle_salida();
                detalle_salida.setIdSalida(rst.getInt(1));
                detalle_salida.setIdArticulo(rst.getInt(2));
                detalle_salida.setCantidad(rst.getInt(3));
                lista.add(detalle_salida);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
