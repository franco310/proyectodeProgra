/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.impl;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.entidades.Detalle_venta;
import proyectohipercorp.dao.IDetalle_venta;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.dao.IArticulo;
import proyectohipercorp.dao.IVenta;
import proyectohipercorp.entidades.Articulo;
import proyectohipercorp.entidades.Venta;


/*freferfe*
 *
 * @author Segovia
 */
public class Detalle_ventaImpl implements IDetalle_venta {
    @Override
    public int insertar(Detalle_venta detalle_venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into detalle_ventaa values(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_venta.getVenta().getIdVenta()));
        lstPar.add(new Parametro(2, detalle_venta.getArticulo().getIdArticulo()));
       lstPar.add(new Parametro(3, detalle_venta.getCantidad()));
        lstPar.add(new Parametro(4, detalle_venta.getFecha_anulacion()));
        lstPar.add(new Parametro(5, detalle_venta.getMonto()));
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
    public int modificar(Detalle_venta detalle_ventaa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  detalle_ventaa set idVenta=?,idArticulo=?,cantidad=?,fecha_anulacion=?,monto=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, detalle_ventaa.getVenta()));
        lstPar.add(new Parametro(2, detalle_ventaa.getArticulo()));
       lstPar.add(new Parametro(3, detalle_ventaa.getCantidad()));
        lstPar.add(new Parametro(4, detalle_ventaa.getFecha_anulacion()));
        lstPar.add(new Parametro(5, detalle_ventaa.getMonto()));
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
    public int eliminar(Detalle_venta detalle_ventaa) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public Detalle_venta obtener(int IdVenta) throws Exception {
        Detalle_venta detalle_venta = null;
         String sql = "select idVenta, nombre from detalle_ventaa where idVenta=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                
                detalle_venta= new Detalle_venta();
                IVenta ventadao = new VentaImpl();
                Venta  venta = ventadao.obtener(rst.getInt(1));
                detalle_venta.setVenta(venta);
                IArticulo articulodao =new ArticuloImpl();
                Articulo articulo =articulodao.obtener(rst.getInt(2));
                detalle_venta.setArticulo(articulo);
                detalle_venta.setFecha_anulacion(rst.getDate(3));   
                detalle_venta.setMonto(rst.getInt(4));
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return detalle_venta;
    }

    @Override
    public List<Detalle_venta> obtener() throws Exception {
        List<Detalle_venta> lista = new ArrayList<>();
         String sql = "select codigo, nombre from detalle_ventaa";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Detalle_venta detalle_venta= null;
            while(rst.next()){
                detalle_venta= new Detalle_venta();
                
                IVenta ventadao = new VentaImpl();
                Venta  venta = ventadao.obtener(rst.getInt(1));
                detalle_venta.setVenta(venta);
                IArticulo articulodao =new ArticuloImpl();
                Articulo articulo =articulodao.obtener(rst.getInt(2));
                detalle_venta.setArticulo(articulo);
                detalle_venta.setFecha_anulacion(rst.getDate(3));   
                detalle_venta.setMonto(rst.getInt(4));
                lista.add(detalle_venta);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
   

