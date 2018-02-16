
package proyectohipercorp.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.ICliente;
import proyectohipercorp.dao.IUsuario;
import proyectohipercorp.dao.IVenta;
import proyectohipercorp.entidades.Cliente;
import proyectohipercorp.entidades.Usuario;
import proyectohipercorp.entidades.Venta;

public class VentaImpl implements IVenta{
    
     @Override
    public int insertar(Venta venta) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into venta  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getIdVenta()));
        lstPar.add(new Parametro(2, venta.getFecha_emision()));
        lstPar.add(new Parametro(3, venta.getFecha_anulacion()));
        lstPar.add(new Parametro(4, venta.getCliente().getIdCliente()));
        lstPar.add(new Parametro(5, venta.getUsuario().getIdUsuario()));
             
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
                + "   SET Idventa=?, fecha-emision =?,fecha_anulacion=?,cliente=?, "
                + " usuario=? "
                + " where Idventa=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, venta.getIdVenta()));
        lstPar.add(new Parametro(2, venta.getFecha_anulacion()));
        lstPar.add(new Parametro(3, venta.getFecha_emision()));
        lstPar.add(new Parametro(4, venta.getCliente().getIdCliente()));
        lstPar.add(new Parametro(5, venta.getUsuario().getIdUsuario()));
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
         String sql = "DELETE FROM venta  where Idventa=?";
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
    public Venta obtener(int IdProvedor) throws Exception {
        Venta venta = null;
        String sql = "SELECT Idventa, fecha_emision , fecha_anulacion, cliente,  "
                + " usuario FROM venta where Idventa=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                venta = new Venta();
                venta.setIdVenta(rst.getInt(1));
                venta.setFecha_anulacion(rst.getDate(2));
                venta.setFecha_emision(rst.getDate(3));
                ICliente clientedao = new ClienteImpl();
                Cliente cliente = clientedao.obtener(rst.getInt(4));
                venta.setCliente(cliente);
                IUsuario usuariodao=new UsuarioImpl();
                Usuario usuario =usuariodao.obtener(rst.getInt(5));
                venta.setUsuario(usuario); 
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
         String sql = "SELECT Idventa, fecha_emision ,fecha_anulacion, cliente, "
                + " usuario FROM venta ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Venta venta=null;
            while (rst.next()) {
                venta = new Venta();
                
                venta.setIdVenta(rst.getInt(1));
                venta.setFecha_anulacion(rst.getDate(2));
                venta.setFecha_emision(rst.getDate(3));
                ICliente clientedao =new ClienteImpl();
                Cliente cliente=clientedao.obtener(rst.getInt(4));
                venta.setCliente(cliente);
                IUsuario usuariodao=new UsuarioImpl();
                Usuario usuario =usuariodao.obtener(rst.getInt(5));
                venta.setUsuario(usuario);              
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
