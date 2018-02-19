
package proyectohipercorp.impl;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.entidades.DetalleVenta;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.dao.IDetalleVenta;
import proyectohipercorp.dao.IFacturaVenta;
import proyectohipercorp.dao.IProducto;
import proyectohipercorp.entidades.FacturaVenta;

import proyectohipercorp.entidades.Producto;

/*freferfe*
 *
 * @author Segovia
 */
public class DetalleVentaImpl implements IDetalleVenta {
    @Override
    public int insertar(DetalleVenta detalleventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into DetalleVenta values"
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalleventa.getCodigoDetalleVenta()));
        lstPar.add(new Parametro(2, detalleventa.getProducto().getCodigoProducto()));
        lstPar.add(new Parametro(2, detalleventa.getFacturaventa().getCodigoFacturaVenta()));
        lstPar.add(new Parametro(3, detalleventa.getCantidad()));
        lstPar.add(new Parametro(4, detalleventa.getPreciototal()));
    
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
    public int modificar(DetalleVenta detalle_ventaa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "update  DetalleVentaa set CodigoVetalleVenta=?,codigoProducto=?,codigoFacturaVenta=?,cantidad=?,preciototal=? "
                + "where codigoDetalleventa=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, detalle_ventaa.getCodigoDetalleVenta()));
        lstPar.add(new Parametro(2, detalle_ventaa.getProducto().getCodigoProducto()));
       lstPar.add(new Parametro(3, detalle_ventaa.getFacturaventa().getCodigoFacturaVenta()));
        lstPar.add(new Parametro(4, detalle_ventaa.getCantidad()));
        lstPar.add(new Parametro(5, detalle_ventaa.getPreciototal()));
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
    public int eliminar(DetalleVenta detalle_ventaa) throws Exception {
        int numFilasAfectadas = 0;
        return numFilasAfectadas;
    }

    @Override
    public DetalleVenta obtener(int codigoDetalleVenta) throws Exception {
        DetalleVenta detalleventa = null;
         String sql = "select codigoDetalleVenta, codigoProducto, codigoFacturaVenta,cantidad, "
                 + "preciototal from DetalleVentaa where codigoDetalleVenta=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoDetalleVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                detalleventa= new DetalleVenta();
                detalleventa.setCodigoDetalleVenta(rst.getInt(1));
                
                IProducto productodao= new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                detalleventa.setProducto(producto);
                
                IFacturaVenta facturadao=new FacturaVentaImpl();
                FacturaVenta factura_venta=facturadao.obtener(rst.getInt(3));
                detalleventa.setFacturaventa(factura_venta);
                detalleventa.setCantidad(rst.getInt(4));   
                detalleventa.setPreciototal(rst.getInt(5));
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return detalleventa;
    }

    @Override
    public List<DetalleVenta> obtener() throws Exception {
        List<DetalleVenta> lista = new ArrayList<>();
         String sql = "select codigDetalleVenta, codigoProducto, codifoFacturaVenta, cantidad,"
                 + "preciototal from DetalleVenta";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            DetalleVenta detalleventa= null;
            while(rst.next()){
                 detalleventa= new DetalleVenta();
                detalleventa.setCodigoDetalleVenta(rst.getInt(1));
                
                IProducto productodao= new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                detalleventa.setProducto(producto);
                
                IFacturaVenta facturadao=new FacturaVentaImpl();
                FacturaVenta factura_venta=facturadao.obtener(rst.getInt(3));
                detalleventa.setFacturaventa(factura_venta);
                detalleventa.setCantidad(rst.getInt(4));   
                detalleventa.setPreciototal(rst.getInt(5));
                lista.add(detalleventa);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return lista;
    }

}
   

