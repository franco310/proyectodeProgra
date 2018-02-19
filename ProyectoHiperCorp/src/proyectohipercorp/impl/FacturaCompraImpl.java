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
import proyectohipercorp.dao.IFacturaCompra;
import proyectohipercorp.dao.IProveedor;
import proyectohipercorp.entidades.FacturaCompra;
import proyectohipercorp.entidades.Proveedor;

/**
 *
 * @author Francisco
 */
public class FacturaCompraImpl implements IFacturaCompra{
    @Override
    public int insertar(FacturaCompra factura) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into factura  values "
                + "(?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getCodigoFacturaCompra()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getProveedor().getIdProveedor()));
       
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
    public int modificar(FacturaCompra factura) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE factura"
                + "   SET Idfacturacompra=?,fecha=?,idproveedor=?"
                + " where Idfacturacompra=?";
        List<Parametro> lstPar = new ArrayList<>();
       lstPar.add(new Parametro(1, factura.getCodigoFacturaCompra()));
        lstPar.add(new Parametro(2, factura.getFecha()));
        lstPar.add(new Parametro(3, factura.getProveedor().getIdProveedor()));
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
    public int eliminar(FacturaCompra factura) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM facturacompra  where Idfacturacompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, factura.getCodigoFacturaCompra()));       
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
    public FacturaCompra obtener(int IdProvedor) throws Exception {
        FacturaCompra factura = null;
        String sql = "SELECT Idfacturacompra,fecha, idproveedor  "
                + "  FROM facturacompra where Idfacturacompra=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                factura = new FacturaCompra();
                factura.setCodigoFacturaCompra(rst.getInt(1));
                factura.setFecha(rst.getDate(2));
                IProveedor proveedordao=new ProveedorImpl();      
                Proveedor proveedor= proveedordao.obtener(rst.getInt(2));
                factura.setProveedor(proveedor);
               
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
    public List<FacturaCompra> obtener() throws Exception {
        List<FacturaCompra> lista = new ArrayList<>();
         String sql = "SELECT Idfacturacompra,fecha,idproveedor  "
                + "FROM facturacompra where Idfacturacompra=?";      
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            FacturaCompra factura=null;
            while (rst.next()) {
              
               factura = new FacturaCompra();
                factura.setCodigoFacturaCompra(rst.getInt(1));
                factura.setFecha(rst.getDate(2));
                IProveedor proveedordao=new ProveedorImpl();      
                Proveedor proveedor= proveedordao.obtener(rst.getInt(2));
                factura.setProveedor(proveedor);
                
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
