package ProyectoHipercorp.test;

import proyectohipercorp.dao.*;
import proyectohipercorp.entidades.*;
import proyectohipercorp.impl.*;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class UsuarioTest {

    public UsuarioTest() {
    }

    @Test
    public void pruebageneral() {
        int filasAfectadas = 0;
        IUsuario usuarioDao = new UsuarioImpl();
       
        Usuario usuario = new Usuario(
                16, "Marco", "Amancha","09838");
        try {
            filasAfectadas = usuarioDao.insertar(usuario);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertEquals((filasAfectadas > 0), true);

        usuario = null;
        try {
            usuario = usuarioDao.obtener(10003);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
       

        try {
            usuario.setNombre("Prueba");
            filasAfectadas= usuarioDao.modificar(usuario);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
         
         List<Usuario> lista = new ArrayList<>();
        try {
            lista = usuarioDao.obtener();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
        assertTrue(lista.size()>0);

        try {            
            filasAfectadas= usuarioDao.eliminar(usuario);
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
         assertEquals((filasAfectadas > 0), true);
    }

}
