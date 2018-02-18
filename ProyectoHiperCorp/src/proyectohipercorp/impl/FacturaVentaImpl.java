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
import proyectohipercorp.dao.IFacturaVenta;
import proyectohipercorp.entidades.Cliente;
import proyectohipercorp.entidades.FacturaVenta;

public class FacturaVentaImpl implements IFacturaVenta{
    
     @Override
    public int insertar(FacturaVenta factura) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into factura  values "
                + "(?,?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getIdFactura()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getCliente().getIdCliente()));
      
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
    public int modificar(FacturaVenta factura) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE factura"
                + "   SET Idfactura=?, fecha=?, idcliente=?, "
                + " where Idfactura=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, factura.getIdFactura()));
        lstPar.add(new Parametro(2,factura.getFecha()));
       lstPar.add(new Parametro(3, factura.getCliente().getIdCliente()));
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
    public int eliminar(FacturaVenta factura) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM factura  where Idfactura=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getIdFactura()));       
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
    public FacturaVenta obtener(int IdProvedor) throws Exception {
        FacturaVenta factura = null;
        String sql = "SELECT Idfactura,fecha,idcliente  "
                + "  FROM facturaventa where Idfactura=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                factura = new FacturaVenta();
                factura.setIdFactura(rst.getInt(1));
                factura.setFecha(rst.getDate(2));
                ICliente clientedao= new ClienteImpl();
                Cliente cliente =clientedao.obtener(rst.getInt(3));
                factura.setCliente(cliente);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return factura;
    }

    @Override
    public List<FacturaVenta> obtener() throws Exception {
        List<FacturaVenta> lista = new ArrayList<>();
         String sql = "SELECT Idfactura, fecha,idcliente, "
                + " precio, FROM factura ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            FacturaVenta factura=null;
            while (rst.next()) {
                factura = new FacturaVenta();
                factura.setIdFactura(rst.getInt(1));
                factura.setFecha(rst.getDate(2));
                ICliente clientedao= new ClienteImpl();
                Cliente cliente =clientedao.obtener(rst.getInt(3));
                factura.setCliente(cliente);
                
                lista.add(factura);
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
