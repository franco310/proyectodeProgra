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
    public int insertar(FacturaVenta facturaventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into FacturaVenta  values "
                + "(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaventa.getCodigoFacturaVenta()));
        lstPar.add(new Parametro(2, facturaventa.getFecha()));
        lstPar.add(new Parametro(3, facturaventa.getCliente().getCedula()));
      
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
    public int modificar(FacturaVenta facturaventa) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE FacturaVenta"
                + "   SET CodigoFacturaVenta=?, fecha=?, cedula=?, "
                + " where CodigoFacturaVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, facturaventa.getCodigoFacturaVenta()));
        lstPar.add(new Parametro(2,facturaventa.getFecha()));
       lstPar.add(new Parametro(3, facturaventa.getCliente().getCedula()));
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
    public int eliminar(FacturaVenta facturaventa) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM FacturaVenta  where codigoFacturaVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, facturaventa.getCodigoFacturaVenta()));       
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
    public FacturaVenta obtener(int codigoFacturaVenta) throws Exception {
        FacturaVenta factura = null;
        String sql = "SELECT codigoFacturaVenta,fecha,cedula  "
                + "  FROM FacturaVenta where codigoFacturaVenta=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, codigoFacturaVenta));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                factura = new FacturaVenta();
                factura.setCodigoFacturaVenta(rst.getInt(1));
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
         String sql = "SELECT codigoFacturaVenta, fecha,cedula, "
                + " precio, FROM FacturaVenta ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            FacturaVenta facturaventa=null;
            while (rst.next()) {
                facturaventa = new FacturaVenta();
                facturaventa.setCodigoFacturaVenta(rst.getInt(1));
                facturaventa.setFecha(rst.getDate(2));
                ICliente clientedao= new ClienteImpl();
                Cliente cliente =clientedao.obtener(rst.getInt(3));
                facturaventa.setCliente(cliente);
                
                lista.add(facturaventa);
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
