package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IVenta {
    public int insertar(Venta articulo) throws Exception;
    public int modificar(Venta articulo) throws Exception;
    public int eliminar(Venta articulo) throws Exception;
    public Venta obtener(int idVenta) throws Exception;
    public List<Venta> obtener() throws Exception;    
}
