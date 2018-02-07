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
import proyectohipercorp.dao.IArticulo;
import proyectohipercorp.dao.IEntrada;
import proyectohipercorp.dao.IKardex;
import proyectohipercorp.dao.IFactura;
import proyectohipercorp.dao.IKardex;
import proyectohipercorp.dao.IProveedor;
import proyectohipercorp.dao.ISalida;
import proyectohipercorp.dao.IUsuario;
import proyectohipercorp.entidades.Articulo;
import proyectohipercorp.entidades.Entrada;
import proyectohipercorp.entidades.Kardex;
import proyectohipercorp.entidades.Factura;
import proyectohipercorp.entidades.Proveedor;
import proyectohipercorp.entidades.Salida;
import proyectohipercorp.entidades.Usuario;


public class KardexImpl implements IKardex{
    
     @Override
    public int insertar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into kardex  values "
                + "(?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getIdKardex()));
        lstPar.add(new Parametro(2, kardex.getPrecio_compra()));
        lstPar.add(new Parametro(3, kardex.getPrecio_venta()));
        lstPar.add(new Parametro(4, kardex.getStok_anterior()));
        lstPar.add(new Parametro(5, kardex.getStock_actual()));
       lstPar.add(new Parametro(6, kardex.getCantidad()));
        lstPar.add(new Parametro(7, kardex.getArticulo().getIdArticulo()));
        lstPar.add(new Parametro(8, kardex.getEntrada().getIdEntrada()));
        lstPar.add(new Parametro(9, kardex.getSalida().getIdSalida()));
             
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
    public int modificar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE kardex"
                + "   SET Idkardex=?, precio_compra=?,precio_venta =?,stok_anterior=?,  stock_actual=? ,"
                + "cantidad=?,idArticulo=?,identrada=?,idSalida=?, where Idkardex=?";
        List<Parametro> lstPar = new ArrayList<>();
          lstPar.add(new Parametro(1, kardex.getIdKardex()));
        lstPar.add(new Parametro(2, kardex.getPrecio_compra()));
        lstPar.add(new Parametro(3, kardex.getPrecio_venta()));
        lstPar.add(new Parametro(4, kardex.getStok_anterior()));
        lstPar.add(new Parametro(5, kardex.getStock_actual()));
       lstPar.add(new Parametro(6, kardex.getCantidad()));
        lstPar.add(new Parametro(7, kardex.getArticulo().getIdArticulo()));
        lstPar.add(new Parametro(8, kardex.getEntrada().getIdEntrada()));
        lstPar.add(new Parametro(9, kardex.getSalida().getIdSalida()));
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
    public int eliminar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM kardex  where Idkardex=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getIdKardex()));       
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
    public Kardex obtener(int IdProvedor) throws Exception {
        Kardex kardex = null;
       String sql = "UPDATE kardex"
                + "   SET Idkardex=?, precio_compra=?,precio_venta =?,stok_anterior=?,  stock_actual=? ,"
                + "cantidad=?,idArticulo=?,identrada=?,idSalida=?, where Idkardex=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                kardex = new Kardex();
                kardex.setIdKardex(rst.getInt(1));
                kardex.setPrecio_compra(rst.getInt(2));
                kardex.setPrecio_venta(rst.getInt(3));
               kardex.setStok_anterior(rst.getInt(4));
                kardex.setStock_actual(rst.getInt(5));
                kardex.setCantidad(rst.getInt(6));
                IArticulo articulodao =new ArticuloImpl();
                Articulo articulo=articulodao.obtener(rst.getInt(7));
                kardex.setArticulo(articulo);
                IEntrada entradadao=new EntradaImpl();
                Entrada entrada=entradadao.obtener(rst.getInt(8));
                kardex.setEntrada(entrada);
                ISalida salidadao=new SalidaImpl();
                Salida salida =salidadao.obtener(rst.getInt(9));
                kardex.setSalida(salida); 
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return kardex;
    }

    @Override
    public List<Kardex> obtener() throws Exception {
        List<Kardex> lista = new ArrayList<>();
         String sql = "UPDATE kardex"
                + "   SET Idkardex=?, precio_compra=?,precio_venta =?,stok_anterior=?,  stock_actual=? ,"
                + "cantidad=?,idArticulo=?,identrada=?,idSalida=?, where Idkardex=?";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Kardex kardex=null;
            while (rst.next()) {
                kardex = new Kardex();
                 kardex.setIdKardex(rst.getInt(1));
                
                kardex = new Kardex();
                kardex.setIdKardex(rst.getInt(1));
                kardex.setPrecio_compra(rst.getInt(2));
                kardex.setPrecio_venta(rst.getInt(3));
               kardex.setStok_anterior(rst.getInt(4));
                kardex.setStock_actual(rst.getInt(5));
                kardex.setCantidad(rst.getInt(6));
                IArticulo articulodao =new ArticuloImpl();
                Articulo articulo=articulodao.obtener(rst.getInt(7));
                kardex.setArticulo(articulo);
                IEntrada entradadao=new EntradaImpl();
                Entrada entrada=entradadao.obtener(rst.getInt(8));
                kardex.setEntrada(entrada);
                ISalida salidadao=new SalidaImpl();
                Salida salida =salidadao.obtener(rst.getInt(9));
                kardex.setSalida(salida);            
                lista.add(kardex);
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
  



