package ProyectoHipercorp.test;


import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;
import proyectohipercorp.dao.*;
import proyectohipercorp.entidades.*;
import proyectohipercorp.impl.*;
public class ProveedorTest {

    public ProveedorTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IProveedor proveedorDao = new ProveedorImpl();
       
        Proveedor proveedor = new Proveedor(
                123, "Tv", "15" , "Nuevo","Riobamba");
        try {
            filasAfectadas = proveedorDao.insertar(proveedor);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        proveedor = null;
        try {
            proveedor = proveedorDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(proveedor != null);

        try {
            proveedor.setNombre("Prueba");
            filasAfectadas= proveedorDao.modificar(proveedor);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Proveedor> lista = new ArrayList<>();
        try {
            lista = proveedorDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= proveedorDao.eliminar(proveedor);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
