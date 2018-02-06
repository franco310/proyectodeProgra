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
import proyectohipercorp.dao.IVenta;
import proyectohipercorp.entidades.Venta;

/**
 *
 * @author Segovia
 */
public class VentaImpl implements IVenta {

 
    @Override
    public int insertar(Venta venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into venta  values "
                +"(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getIdVenta()));
        lstPar.add(new Parametro(2, venta.getFecha_emision()));
        lstPar.add(new Parametro(3, venta.getFecha_anulacion()));
        lstPar.add(new Parametro(4, venta.getCliente()));
        lstPar.add(new Parametro(5, venta.getUsuario()));
        
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
    public int modificar(Venta venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE venta"
                + "   SET idVenta=?, fecha_emision=?, fecha_anulacion=?, cliente=?, usuario=?, "
                + " where idVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getIdVenta()));
        lstPar.add(new Parametro(2, venta.getFecha_emision()));
        lstPar.add(new Parametro(3, venta.getFecha_anulacion()));
        lstPar.add(new Parametro(4, venta.getCliente()));
        lstPar.add(new Parametro(5, venta.getUsuario()));
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
    public int eliminar(Venta venta) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM estudiante  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getIdVenta()));       
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
    public Venta obtener(int codigo) throws Exception {
        Venta venta = null;
        String sql = "SELECT idVenta, fecha_emision,fecha_anulacion, cliente, usuario, "
                + " FROM venta where idVenta=?;";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                venta = new Venta();
                venta.setIdVenta(rst.getInt(1));
                venta.setFecha_emision(rst.getDate(2));
                venta.setFecha_anulacion(rst.getDate(3));
                venta.setCliente(rst.getString(4));
                venta.setUsuario(rst.getString(5));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return venta;
    }

    @Override
    public List<Venta> obtener() throws Exception {
        List<Venta> lista = new ArrayList<>();
         String sql = "SELECT idVenta, nombre, cantidad, estado, observacio, "
                + "   FROM venta ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Venta venta=null;
            while (rst.next()) {
                venta = new Venta();
                venta.setIdVenta(rst.getInt(1));
                venta.setFecha_emision(rst.getDate(2));
                venta.setFecha_anulacion(rst.getDate(3));
                venta.setCliente(rst.getString(4));
                venta.setUsuario(rst.getString(5));
                lista.add(venta);
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

