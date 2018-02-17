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
import proyectohipercorp.dao.ICategoria;
import proyectohipercorp.entidades.Categoria;


public class CategoriaImpl  implements ICategoria{
    
     @Override
    public int insertar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "insert into categoria  values "
                + "(?,?,?,?,?)";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getIdcategoria()));
        lstPar.add(new Parametro(2, categoria.getNombre()));
        lstPar.add(new Parametro(3, categoria.getNombre()));
        lstPar.add(new Parametro(4, categoria.getDescripcion()));
     
        
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
    public int modificar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
        String sql = "UPDATE categoria"
                + "   SET idArticulo=?, nombre=?, cantidad=?, estado=?, "
                + "Observacio=? where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getIdcategoria()));
        lstPar.add(new Parametro(2, categoria.getNombre()));
        lstPar.add(new Parametro(3, categoria.getNombre()));
        lstPar.add(new Parametro(4, categoria.getDescripcion()));
         
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
    public int eliminar(Categoria categoria) throws Exception {
        int numFilasAfectadas = 0;
         String sql = "DELETE FROM categoria  where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, categoria.getIdcategoria()));       
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
    public Categoria obtener(int IdCategoria) throws Exception {
        Categoria categoria = null;
        String sql = "SELECT idCategoria,nombre , cantidad, estado, "
                + "observacio FROM categoria where codigo=?";
        List<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, IdCategoria));
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, lstPar);
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setIdcategoria(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
                 
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if(con!=null)
            con.desconectar();
        }
        return categoria;
    }

    @Override
    public List<Categoria> obtener() throws Exception {
        List<Categoria> lista = new ArrayList<>();
         String sql = "SELECT idArticulo, nombre,descripcion "
                 + " FROM categoria";        
        Conexion con = null;
        try {
            con = new Conexion();
            con.conectar();
            ResultSet rst = con.ejecutaQuery(sql, null);
            Categoria categoria=null;
            while (rst.next()) {
                categoria = new Categoria();
                categoria.setIdcategoria(rst.getInt(1));
                categoria.setNombre(rst.getString(2));
                categoria.setDescripcion(rst.getString(3));
               
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
