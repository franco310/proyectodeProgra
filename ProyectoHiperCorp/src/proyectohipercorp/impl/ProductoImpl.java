package proyectohipercorp.impl;
import proyectohipercorp.accesodatos.Conexion;
import proyectohipercorp.accesodatos.Parametro;
import proyectohipercorp.dao.IProducto;
import proyectohipercorp.entidades.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import proyectohipercorp.dao.ICategoria;
import proyectohipercorp.entidades.Categoria;

public class ProductoImpl implements IProducto {
    
    @Override
    public int insertar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into producto  values "
                + "(?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getIdProducto()));
        lstPar.add(new Parametro(2, producto.getCategoria().getIdcategoria()));
        lstPar.add(new Parametro(3, producto.getNombre()));
        lstPar.add(new Parametro(4, producto.getPrecio()));
       
        
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
    public int modificar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE producto"
                + "   SET idproducto=?, idcategoria=?, nombre=?, precio=?, "
                + "where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getIdProducto()));
        lstPar.add(new Parametro(2, producto.getCategoria().getIdcategoria()));
        lstPar.add(new Parametro(2, producto.getNombre()));
        lstPar.add(new Parametro(4, producto.getPrecio()));
        
              
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
    public int eliminar(Producto producto) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM producto  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getIdProducto()));       
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
    public Producto obtener(int IdProducto) throws Exception {
        Producto producto = null;
        String sql = "SELECT idProducto,nombre , cantidad, estado, "
                + "observacio FROM producto where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdProducto));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                producto = new Producto();
                producto.setIdProducto(rst.getInt(1));
                ICategoria categoriadao =new CategoriaImpl();
                Categoria  categoria=categoriadao.obtener(rst.getInt(2));
                producto.setCategoria(categoria);
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getInt(4));
                
                 
                
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return producto;
    }

    @Override
    public List<Producto> obtener() throws Exception {
        List<Producto> lista = new ArrayList<>();
         String sql = "SELECT idArticulo, nombre, cantidad, estado, "
                 + "observacio FROM producto";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Producto producto=null;
            while (rst.next()) {
                producto = new Producto();
                producto.setIdProducto(rst.getInt(1));
                ICategoria categoriadao = new CategoriaImpl();
                Categoria  categoria=categoriadao.obtener(rst.getInt(2));
                producto.setCategoria(categoria);
                producto.setNombre(rst.getString(3));
                producto.setPrecio(rst.getInt(4));
               
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
