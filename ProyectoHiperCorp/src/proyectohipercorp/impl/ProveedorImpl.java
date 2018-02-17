
package proyectohipercorp.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.IProveedor;
import proyectohipercorp.entidades.Proveedor;

public class ProveedorImpl implements IProveedor{
      @Override
    public int insertar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into proveedor  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getIdProveedor()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getDireccion()));
        lstPar.add(new Parametro(4, proveedor.getTelefono()));
        lstPar.add(new Parametro(5, proveedor.getEmail()));
             
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
    public int modificar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE proveedor"
                + "   SET Idproveedor=?, nombre=?, "
                + " direccion=?,telefono=?,email=?, "
                + " where Idproveedor=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getIdProveedor()));
        lstPar.add(new Parametro(2, proveedor.getNombre()));
        lstPar.add(new Parametro(3, proveedor.getDireccion()));
        lstPar.add(new Parametro(4, proveedor.getTelefono()));
        lstPar.add(new Parametro(5, proveedor.getEmail()));
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
    public int eliminar(Proveedor proveedor) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM proveedor  where IdProveedor=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, proveedor.getIdProveedor()));       
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
    public Proveedor obtener(int IdProvedor) throws Exception {
        Proveedor proveedor = null;
        String sql =  "UPDATE proveedor"
                + "   SET Idproveedor=?, nombre=?, "
                + " direccion=?,telefono=?,email=?, "
                + " where Idproveedor=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5));   
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return proveedor;
    }

    @Override
    public List<Proveedor> obtener() throws Exception {
        List<Proveedor> lista = new ArrayList<>();
         String sql = "SELECT IdProveedor,nombre , direccion,telefono,email"
                 + " FROM proveedor ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Proveedor proveedor=null;
            while (rst.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rst.getInt(1));
                proveedor.setNombre(rst.getString(2));
                proveedor.setDireccion(rst.getString(3));
                proveedor.setTelefono(rst.getString(4));
                proveedor.setEmail(rst.getString(5)); 
                               
                lista.add(proveedor);
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
