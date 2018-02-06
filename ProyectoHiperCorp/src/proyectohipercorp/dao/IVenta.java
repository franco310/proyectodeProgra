package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IVenta {
    public int insertar(Venta venta) throws Exception;
    public int modificar(Venta venta) throws Exception;
    public int eliminar(Venta venta) throws Exception;
    public Venta obtener(int idVenta) throws Exception;
    public List<Venta> obtener() throws Exception;    
}
