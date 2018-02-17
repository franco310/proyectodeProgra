package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IDetalleVenta {
    public int insertar(Detalle_venta detalleventa) throws Exception;
    public int modificar(Detalle_venta detalleventa) throws Exception;
    public int eliminar(Detalle_venta detalleventa) throws Exception;
    public Detalle_venta obtener(int codigoDetalleVenta) throws Exception;
    public List<Detalle_venta> obtener() throws Exception;    
}
