package ProyectoHipercorp.test;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import proyectohipercorp.dao.*;
import proyectohipercorp.entidades.*;
import proyectohipercorp.impl.*;
public class SalidaTest {

    public SalidaTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        ISalida salidaDao = new SalidaImpl();
       
        Salida salida = new Salida(
                123, (java.sql.Date) new Date(), (java.sql.Date) new Date(),"Riobamba");
        try {
            filasAfectadas = salidaDao.insertar(salida);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        salida = null;
        try {
            salida = salidaDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(salida != null);

        try {
            salida.setResponsable("Prueba");
            filasAfectadas= salidaDao.modificar(salida);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Salida> lista = new ArrayList<>();
        try {
            lista = salidaDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= salidaDao.eliminar(salida);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
