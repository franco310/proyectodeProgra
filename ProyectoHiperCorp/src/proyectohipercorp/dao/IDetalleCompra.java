package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IDetalleCompra {
    public int insertar(Detalle_compra detallecompra) throws Exception;
    public int modificar(Detalle_compra detallecompra) throws Exception;
    public int eliminar(Detalle_compra detallecompra) throws Exception;
    public Detalle_compra obtener(int codigoDetalleCompra) throws Exception;
    public List<Detalle_compra> obtener() throws Exception;    
}
