
package proyectohipercorp.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.IUsuario;
import proyectohipercorp.entidades.Usuario;

public class UsuarioImpl implements IUsuario{
    
    @Override
    public int insertar(Usuario usuario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into usuario  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getIdUsuario()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getApellido()));
        lstPar.add(new Parametro(4, usuario.getDireccion()));
        lstPar.add(new Parametro(5, usuario.getTelefono()));
             
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
    public int modificar(Usuario usuario) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE usuario"
                + "   SET Idusuario=?, nombre=?, apellidos=?, "
                + " direccion=?, telefono=? "
                + " where Idusuario=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getIdUsuario()));
        lstPar.add(new Parametro(2, usuario.getNombre()));
        lstPar.add(new Parametro(3, usuario.getApellido()));
        lstPar.add(new Parametro(4, usuario.getDireccion()));
        lstPar.add(new Parametro(5, usuario.getTelefono()));
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
    public int eliminar(Usuario usuario) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM usuario  where Idusuario=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, usuario.getIdUsuario()));       
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
    public Usuario obtener(int IdProvedor) throws Exception {
        Usuario usuario = null;
        String sql = "SELECT Idusuario, nombre , apellidos,  "
                + " direccion,telefono , FROM usuario where Idusuario=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProvedor));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rst.getInt(1));
                usuario.setNombre(rst.getString(2));
                usuario.setApellido(rst.getString(3));
                usuario.setDireccion(rst.getString(4)); 
                usuario.setTelefono(rst.getString(5));   
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return usuario;
    }

    @Override
    public List<Usuario> obtener() throws Exception {
        List<Usuario> lista = new ArrayList<>();
         String sql = "SELECT Idusuario, nombre , apellidos "
                + " direccion,telefono FROM usuario ";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Usuario usuario=null;
            while (rst.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rst.getInt(1));
                usuario.setNombre(rst.getString(2));
                usuario.setApellido(rst.getString(3));
                usuario.setDireccion(rst.getString(4)); 
                usuario.setTelefono(rst.getString(5));   
                               
                lista.add(usuario);
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
