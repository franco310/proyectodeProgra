package ProyectoHipercorp.test;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import proyectohipercorp.dao.*;
import proyectohipercorp.entidades.*;
import proyectohipercorp.impl.*;
public class FacturaTest {

    public FacturaTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IFactura facturaDao = new FacturaImpl();
       
        Factura factura = new Factura(
                123, (java.sql.Date) new Date(),"Nuevo","Riobamba", 15 , 25);
        try {
            filasAfectadas = facturaDao.insertar(factura);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        factura = null;
        try {
            factura = facturaDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(factura != null);

        try {
            factura.setNombreArticulo("Prueba");
            filasAfectadas= facturaDao.modificar(factura);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Factura> lista = new ArrayList<>();
        try {
            lista = facturaDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= facturaDao.eliminar(factura);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
