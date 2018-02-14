
package ProyectoHipercorp.test;
import proyectohipercorp.entidades.*;
import proyectohipercorp.dao.*;
import proyectohipercorp.impl.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class VentaTest {

    public VentaTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IVenta ventaDao = new VentaImpl();
        Venta venta = new Venta();
        
        Cliente cliente = new Cliente(1,"17-10-2017","12-12-2018", "Marco","Marco");
        Usuario usuario = new Usuario(1,"1-12-2017","12-12-2018", "Francisco","Francisco");
        
      
        try {
            filasAfectadas = ventaDao.insertar(venta);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        venta = null;
        try {
            venta = ventaDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(venta != null);

        try {
            venta.setCliente(cliente);
            filasAfectadas= ventaDao.modificar(venta);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Venta> lista = new ArrayList<>();
        try {
            lista = ventaDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= ventaDao.eliminar(venta);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
