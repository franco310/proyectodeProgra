package proyectohipercorp.impl;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.IArticulo;
import proyectohipercorp.entidades.Articulo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ArticuloImpl implements IArticulo {
    
    @Override
    public int insertar(Articulo articulo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into articulo  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, articulo.getIdArticulo()));
        lstPar.add(new Parametro(2, articulo.getNombre()));
        lstPar.add(new Parametro(3, articulo.getCantidad()));
        lstPar.add(new Parametro(4, articulo.getEstado()));
        lstPar.add(new Parametro(5, articulo.getObservacio()));
        
        
        
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
    public int modificar(Articulo articulo) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE articulo"
                + "   SET idArticulo=?, nombre=?, cantidad=?, estado=?, "
                + "Observacio=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, articulo.getIdArticulo()));
        lstPar.add(new Parametro(2, articulo.getNombre()));
        lstPar.add(new Parametro(3, articulo.getCantidad()));
        lstPar.add(new Parametro(4, articulo.getEstado()));
        lstPar.add(new Parametro(5, articulo.getObservacio()));
         
        
              
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
    public int eliminar(Articulo articulo) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM articulo  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, articulo.getIdArticulo()));       
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
    public Articulo obtener(int idArticulo) throws Exception {
        Articulo articulo = null;
        String sql = "SELECT idArticulo,nombre , cantidad, estado, "
                + "observacio FROM articulo where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, idArticulo));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                articulo = new Articulo();
                articulo.setIdArticulo(rst.getInt(1));
                articulo.setNombre(rst.getString(2));
                articulo.setCantidad(rst.getInt(3));
                articulo.setEstado(rst.getString(4));
                articulo.setObservacio(rst.getString(5));
                 
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return articulo;
    }

    @Override
    public List<Articulo> obtener() throws Exception {
        List<Articulo> lista = new ArrayList<>();
         String sql = "SELECT idArticulo, nombre, cantidad, estado, "
                 + "observacio FROM articulo";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Articulo articulo=null;
            while (rst.next()) {
                articulo = new Articulo();
                articulo.setIdArticulo(rst.getInt(1));
                articulo.setNombre(rst.getString(2));
                articulo.setCantidad(rst.getInt(3));
                articulo.setEstado(rst.getString(4));
                articulo.setObservacio(rst.getString(5));
               
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
