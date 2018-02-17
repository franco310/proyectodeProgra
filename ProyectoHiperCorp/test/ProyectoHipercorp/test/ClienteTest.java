package ProyectoHipercorp.test;
import proyectohipercorp.entidades.*;
import proyectohipercorp.dao.*;
import proyectohipercorp.impl.*;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class ClienteTest {

    public ClienteTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        ICliente clienteDao = new ClienteImpl();
       
        Cliente cliente = new Cliente(20, "Diego", "Curimilma","Ayacucho", "0983851377" );
        try {
            filasAfectadas = clienteDao.insertar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        cliente = null;
        try {
            cliente = clienteDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        

        try {
            cliente.setNombre("Prueba");
            filasAfectadas= clienteDao.modificar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Cliente> lista = new ArrayList<>();
        try {
            lista = clienteDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= clienteDao.eliminar(cliente);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
