
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
    public int insertar(DetalleVenta detalle_venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into detalle_venta values(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, detalle_venta.getIdCodigodetalle_venta()));
        lstPar.add(new Parametro(2, detalle_venta.getProducto().getIdProducto()));
        lstPar.add(new Parametro(2, detalle_venta.getFacturaventa().getIdFactura()));
        lstPar.add(new Parametro(3, detalle_venta.getCantidad()));
        lstPar.add(new Parametro(4, detalle_venta.getPreciototal()));
    
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
        String sql = "update  detalle_ventaa set idCodigodetalle_venta=?,idproducto=?,idfactura=?,precio=?,preciototal=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, detalle_ventaa.getIdCodigodetalle_venta()));
        lstPar.add(new Parametro(2, detalle_ventaa.getProducto().getIdProducto()));
       lstPar.add(new Parametro(3, detalle_ventaa.getFacturaventa().getIdFactura()));
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
    public DetalleVenta obtener(int IdVenta) throws Exception {
        DetalleVenta detalle_venta = null;
         String sql = "select idVenta, nombre from detalle_ventaa where idVenta=?"; 
          List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);            
            while(rst.next()){
                detalle_venta= new DetalleVenta();
                detalle_venta.setIdCodigodetalle_venta(rst.getInt(1));
                
                IProducto productodao= new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                detalle_venta.setProducto(producto);
                
                IFacturaVenta facturadao=new FacturaVentaImpl();
                FacturaVenta factura_venta=facturadao.obtener(rst.getInt(3));
                detalle_venta.setFacturaventa(factura_venta);
                detalle_venta.setCantidad(rst.getInt(4));   
                detalle_venta.setPreciototal(rst.getInt(5));
                
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            con.desconectar();
        }
        return detalle_venta;
    }

    @Override
    public List<DetalleVenta> obtener() throws Exception {
        List<DetalleVenta> lista = new ArrayList<>();
         String sql = "select codigo, nombre from detalle_ventaa";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            DetalleVenta detalle_venta= null;
            while(rst.next()){
                 detalle_venta= new DetalleVenta();
                detalle_venta.setIdCodigodetalle_venta(rst.getInt(1));
                
                IProducto productodao= new ProductoImpl();
                Producto producto=productodao.obtener(rst.getInt(2));
                detalle_venta.setProducto(producto);
                
                IFacturaVenta facturadao=new FacturaVentaImpl();
                FacturaVenta factura_venta=facturadao.obtener(rst.getInt(3));
                detalle_venta.setFacturaventa(factura_venta);
                detalle_venta.setCantidad(rst.getInt(4));   
                detalle_venta.setPreciototal(rst.getInt(5));
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
   

