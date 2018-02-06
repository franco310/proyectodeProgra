package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IProveedor {
    public int insertar(Proveedor articulo) throws Exception;
    public int modificar(Proveedor articulo) throws Exception;
    public int eliminar(Proveedor articulo) throws Exception;
    public Proveedor obtener(int idProveedor) throws Exception;
    public List<Proveedor> obtener() throws Exception;    
}
