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
import proyectohipercorp.dao.ICliente;
import proyectohipercorp.dao.IUsuario;
import proyectohipercorp.dao.IEntrada;
import proyectohipercorp.dao.IEntrada;
import proyectohipercorp.dao.IFactura;
import proyectohipercorp.dao.IProveedor;
import proyectohipercorp.entidades.*;
import proyectohipercorp.entidades.Usuario;
import proyectohipercorp.entidades.Entrada;

/**
 *
 * @author Segovia
 */
public class EntradaImpl implements IEntrada{

     @Override
    public int insertar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into entrada  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getIdEntrada()));
        lstPar.add(new Parametro(2, entrada.getProveedor().getIdProveedor()));
        lstPar.add(new Parametro(3, entrada.getUsuario().getIdUsuario()));
        lstPar.add(new Parametro(4, entrada.getFactura().getIdFactura()));
        lstPar.add(new Parametro(5, entrada.getFecha_entrada()));
             
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
    public int modificar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE entrada"
                + "   SET Identrada=?, idProveedor=?,idUsuario =?,idFactura=?,  fecha_entrada=? "
                + " where Identrada=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getIdEntrada()));
        lstPar.add(new Parametro(2, entrada.getProveedor().getIdProveedor()));
        lstPar.add(new Parametro(3, entrada.getUsuario().getIdUsuario()));
        lstPar.add(new Parametro(4, entrada.getFactura().getIdFactura()));
        lstPar.add(new Parametro(5, entrada.getFecha_entrada()));
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
    public int eliminar(Entrada entrada) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM entrada  where Identrada=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, entrada.getIdEntrada()));       
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
    public Entrada obtener(int IdProvedor) throws Exception {
        Entrada entrada = null;
        String sql = "UPDATE entrada"
                + "   SET Identrada=?,  idProveedor=?,idUsuario =?,idFactura=?,  fecha_entrada=? "
                + " where Identrada=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                entrada = new Entrada();
                entrada.setIdEntrada(rst.getInt(1));
                
                IProveedor proveedordao =new ProveedorImpl();
                Proveedor proveedor=proveedordao.obtener(rst.getInt(2));
                entrada.setProvedor(proveedor);
                IUsuario usuariodao=new UsuarioImpl();
                Usuario usuario =usuariodao.obtener(rst.getInt(3));
                entrada.setUsuario(usuario);
                IFactura facturadao=new FacturaImpl();
                Factura factura =facturadao.obtener(rst.getInt(4));
                entrada.setFactura(factura); 
                entrada.setFecha_entrada(rst.getDate(5));
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return entrada;
    }

    @Override
    public List<Entrada> obtener() throws Exception {
        List<Entrada> lista = new ArrayList<>();
         String sql = "SELECT Identrada, fecha_anulacion, fecha_emision ,cliente "
                + " usuario, FROM entrada ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Entrada entrada=null;
            while (rst.next()) {
                entrada = new Entrada();
                 entrada.setIdEntrada(rst.getInt(1));
                
                IProveedor proveedordao =new ProveedorImpl();
                Proveedor proveedor=proveedordao.obtener(rst.getInt(2));
                entrada.setProvedor(proveedor);
                IUsuario usuariodao=new UsuarioImpl();
                Usuario usuario =usuariodao.obtener(rst.getInt(3));
                entrada.setUsuario(usuario);
                IFactura facturadao=new FacturaImpl();
                Factura factura =facturadao.obtener(rst.getInt(4));
                entrada.setFactura(factura); 
                entrada.setFecha_entrada(rst.getDate(5));             
                lista.add(entrada);
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
  

