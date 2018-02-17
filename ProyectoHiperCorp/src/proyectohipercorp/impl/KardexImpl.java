
package proyectohipercorp.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;

import proyectohipercorp.dao.IKardex;
import proyectohipercorp.dao.IProducto;
import proyectohipercorp.entidades.Producto;
import proyectohipercorp.entidades.Kardex;


public class KardexImpl implements IKardex{
    
     @Override
    public int insertar(Kardex kardex) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into kardex  values "
                + "(?,?,?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getIdKardex()));
        lstPar.add(new Parametro(2, kardex.getProducto().getIdProducto()));
        lstPar.add(new Parametro(3, kardex.getFechaEmision()));
        lstPar.add(new Parametro(4, kardex.getTipotransaccion()));
        lstPar.add(new Parametro(5, kardex.getExistencias()));
        lstPar.add(new Parametro(6, kardex.getValortotal()));
        
             
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
                + "   SET Idkardex=?, idproducto=?,fechaemision =?,tipotransaccion=?, existencais=? ,"
                + "valortotal=?, where Idkardex=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, kardex.getIdKardex()));
        lstPar.add(new Parametro(2, kardex.getProducto().getIdProducto()));
        lstPar.add(new Parametro(3, kardex.getFechaEmision()));
        lstPar.add(new Parametro(4, kardex.getTipotransaccion()));
        lstPar.add(new Parametro(5, kardex.getExistencias()));
        lstPar.add(new Parametro(6, kardex.getValortotal()));
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
              +" SET Idkardex=?, idproducto=?,fechaemision =?,tipotransaccion=?, existencais=? ,"
                + "valortotal=?, where Idkardex=?";
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
                IProducto productodao =new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                kardex.setProducto(producto);
                kardex.setFechaEmision(rst.getDate(3));
                kardex.setExistencias(rst.getInt(4));
                kardex.setTipotransaccion(rst.getString(5));
                kardex.setValortotal(rst.getInt(6));
               
                
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
              +" SET Idkardex=?, idproducto=?,fechaemision =?,tipotransaccion=?, existencais=? ,"
              + "valortotal=?, where Idkardex=?";     
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Kardex kardex=null;
            while (rst.next()) {
                kardex = new Kardex();
                kardex.setIdKardex(rst.getInt(1));
                IProducto productodao =new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                kardex.setProducto(producto);
                kardex.setFechaEmision(rst.getDate(3));
                kardex.setExistencias(rst.getInt(4));
                kardex.setTipotransaccion(rst.getString(5));
                kardex.setValortotal(rst.getInt(6));
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
  



