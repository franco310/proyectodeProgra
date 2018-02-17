package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IProveedor {
    public int insertar(Proveedor proveedor) throws Exception;
    public int modificar(Proveedor proveedor) throws Exception;
    public int eliminar(Proveedor proveedor) throws Exception;
    public Proveedor obtener(int ruc) throws Exception;
    public List<Proveedor> obtener() throws Exception;    
}
