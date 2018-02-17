package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IDetalleVenta {
    public int insertar(DetalleVenta detalleventa) throws Exception;
    public int modificar(DetalleVenta detalleventa) throws Exception;
    public int eliminar(DetalleVenta detalleventa) throws Exception;
    public DetalleVenta obtener(int codigoDetalleVenta) throws Exception;
    public List<DetalleVenta> obtener() throws Exception;    
}
