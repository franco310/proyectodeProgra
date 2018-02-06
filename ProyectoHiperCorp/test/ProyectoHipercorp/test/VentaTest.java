
package ProyectoHipercorp.test;

import java.util.Date;

/**
 *
 * @author DiegoPatricio
 */
public class VentaTest {

    public VentaTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IVenta ventaDao = new VentaImpl();
        
        Cliente cliente = new Cliente(1, "Marco");
        Usuario usuario = new Usuario(1, "Francisco");
        
        
        Venta venta = new Venta(
                126, new Date(), new Date(), cliente, usuario);
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
            venta.setNombres("Prueba");
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
