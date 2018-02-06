package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface ICliente {
    public int insertar(Cliente articulo) throws Exception;
    public int modificar(Cliente articulo) throws Exception;
    public int eliminar(Cliente articulo) throws Exception;
    public Cliente obtener(int idCliente) throws Exception;
    public List<Cliente> obtener() throws Exception;    
}
