package proyectohipercorp.impl;

import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.ICliente;
import proyectohipercorp.entidades.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ClienteImpl implements ICliente{
    
    @Override
    public int insertar(Cliente cliente) throws Exception{
        int numFilasAfectadas=0;
          String sql = "insert into cliente values"
                  + "(?,?,?,?,?)";
          List<Parametro> lstPar = new ArrayList<>();
          lstPar.add(new Parametro(1, cliente.getIdCliente()));
          lstPar.add(new Parametro(2, cliente.getNombre()));
          lstPar.add(new Parametro(3, cliente.getApellido()));
          lstPar.add(new Parametro(4, cliente.getDireccion()));
          lstPar.add(new Parametro(5, cliente.getTelefono()));
          
        Conexion con = null;
        try{
            con = new Conexion();
            con.conectar();
            numFilasAfectadas=con.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            throw e;
        }finally {
            if(con!=null)
            con.desconectar();
        }
        return numFilasAfectadas;
    }
   @Override
    public int modificar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE cliente"
                + "   SET IdCliente=?,nombre=?, apellido=?,  direccion=?, telefono=? "
                + " where IdCliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getIdCliente()));
          lstPar.add(new Parametro(2, cliente.getNombre()));
          lstPar.add(new Parametro(3, cliente.getApellido()));
          lstPar.add(new Parametro(4, cliente.getDireccion()));
          lstPar.add(new Parametro(5, cliente.getTelefono()));  
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
    public int eliminar(Cliente cliente) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM cliente  where IdCliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, cliente.getIdCliente()));       
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
    public Cliente obtener(int idCliente) throws Exception {
        Cliente cliente = null;
        String sql = "SELECT IdCliente, nombre , apellido ,direccion,"
                + " telefono  FROM cliente where IdCliente=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idCliente));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setDireccion(rst.getString(4));                
                cliente.setTelefono(rst.getString(5));   
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtener() throws Exception {
        List<Cliente> lista = new ArrayList<>();
         String sql = "SELECT IdCliente, nombre , apellido, direccion,"
                 + " telefono  FROM cliente ";       
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Cliente cliente=null;
            while (rst.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rst.getInt(1));
                cliente.setNombre(rst.getString(2));
                cliente.setApellido(rst.getString(3));
                cliente.setDireccion(rst.getString(4));                
                cliente.setTelefono(rst.getString(5));                
                lista.add(cliente);
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
