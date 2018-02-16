
package ProyectoHipercorp.test;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import proyectohipercorp.dao.*;
import proyectohipercorp.entidades.*;
import proyectohipercorp.impl.*;
public class ArticuloTest {

    public ArticuloTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IArticulo articuloDao = new ArticuloImpl();
        Articulo articulo = new Articulo( 10, "Radio", 15 , "Nuevo","Riobamba");
        try {
            filasAfectadas = articuloDao.insertar(articulo);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        articulo = null;
        try {
            articulo = articuloDao.obtener(10);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(articulo != null);

        try {
            articulo.setNombre("Prueba");
            filasAfectadas= articuloDao.modificar(articulo);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Articulo> lista = new ArrayList<>();
        try {
            lista = articuloDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= articuloDao.eliminar(articulo);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
