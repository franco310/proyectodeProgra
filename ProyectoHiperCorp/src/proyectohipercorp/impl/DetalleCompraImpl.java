
package proyectohipercorp.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.IDetalleCompra;
import proyectohipercorp.dao.IFacturaCompra;
import proyectohipercorp.dao.IProducto;
import proyectohipercorp.entidades.DetalleCompra;
import proyectohipercorp.entidades.FacturaCompra;
import proyectohipercorp.entidades.Producto;

/**
 *
 * @author Francisco
 */
public class DetalleCompraImpl implements IDetalleCompra{
    @Override
    public int insertar(DetalleCompra detalle_compra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into detalle_compra values(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_compra.getIdDetallecompra()));
        lstPar.add(new Parametro(2, detalle_compra.getProducto().getCodigoProducto()));
        lstPar.add(new Parametro(2, detalle_compra.getFacturacompra().getIdFacturacompra()));
        lstPar.add(new Parametro(3, detalle_compra.getCantidad()));
        lstPar.add(new Parametro(4, detalle_compra.getPreciototal()));
    
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
    public int modificar(DetalleCompra detalle_compra) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  DetalleCompraa set codigoDetalleCompra=?,idproducto=?,idfacturacompra=?,cantidad=?,preciototal=? where codigoDetalleCompra=?";
        List<Parametro> lstPar = new ArrayList<>();
      lstPar.add(new Parametro(1, detalle_compra.getIdDetallecompra()));
        lstPar.add(new Parametro(2, detalle_compra.getProducto().getCodigoProducto()));
        lstPar.add(new Parametro(2, detalle_compra.getFacturacompra().getIdFacturacompra()));
        lstPar.add(new Parametro(3, detalle_compra.getCantidad()));
        lstPar.add(new Parametro(4, detalle_compra.getPreciototal()));
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
    public int eliminar(DetalleCompra detalle_compraa) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public DetalleCompra obtener(int IdDetallecompra) throws Exception {
        DetalleCompra detalle_compra = null;
         String sql = "select codigoDetalleCompra, codigoFactCompra,cantidad,preciototal from detalle_compraa where codigoDetalleCompra=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdDetallecompra));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                detalle_compra= new DetalleCompra();
                detalle_compra.setIdDetallecompra(rst.getInt(1));  
                IProducto productodao= new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                detalle_compra.setProducto(producto); 
                IFacturaCompra facturadao=new FacturaCompraImpl();
                FacturaCompra factura_compra=facturadao.obtener(rst.getInt(3));
                detalle_compra.setFacturacompra(factura_compra);
                detalle_compra.setCantidad(rst.getInt(4));   
                detalle_compra.setPreciototal(rst.getInt(5));
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return detalle_compra;
    }

    @Override
    public List<DetalleCompra> obtener() throws Exception {
        List<DetalleCompra> lista = new ArrayList<>();
         String sql = "select codigoDetalleCompra, nombre from DetalleCompraa";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            DetalleCompra detalle_compra= null;
            while(rst.next()){
                detalle_compra= new DetalleCompra();
                detalle_compra= new DetalleCompra();
                detalle_compra.setIdDetallecompra(rst.getInt(1));  
                IProducto productodao= new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                detalle_compra.setProducto(producto); 
                IFacturaCompra facturadao=new FacturaCompraImpl();
                FacturaCompra factura_compra=facturadao.obtener(rst.getInt(3));
                detalle_compra.setFacturacompra(factura_compra);
                detalle_compra.setCantidad(rst.getInt(4));   
                detalle_compra.setPreciototal(rst.getInt(5));
                
                lista.add(detalle_compra);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
