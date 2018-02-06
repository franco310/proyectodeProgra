package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IDetalle_venta {
    public int insertar(Detalle_venta articulo) throws Exception;
    public int modificar(Detalle_venta articulo) throws Exception;
    public int eliminar(Detalle_venta articulo) throws Exception;
    public Detalle_venta obtener(int idVenta) throws Exception;
    public List<Detalle_venta> obtener() throws Exception;    
}
