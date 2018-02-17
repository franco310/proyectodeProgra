package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface ICliente {
    public int insertar(Cliente cliente) throws Exception;
    public int modificar(Cliente cliente) throws Exception;
    public int eliminar(Cliente cliente) throws Exception;
    public Cliente obtener(int cedula) throws Exception;
    public List<Cliente> obtener() throws Exception;    
}
