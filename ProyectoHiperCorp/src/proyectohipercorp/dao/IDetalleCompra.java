package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IDetalleCompra {
    public int insertar(DetalleCompra detallecompra) throws Exception;
    public int modificar(DetalleCompra detallecompra) throws Exception;
    public int eliminar(DetalleCompra detallecompra) throws Exception;
    public DetalleCompra obtener(int codigoDetalleCompra) throws Exception;
    public List<DetalleCompra> obtener() throws Exception;    
}
