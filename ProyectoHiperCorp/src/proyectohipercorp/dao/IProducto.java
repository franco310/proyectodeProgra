package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IProducto {
    public int insertar(Producto producto) throws Exception;
    public int modificar(Producto producto) throws Exception;
    public int eliminar(Producto producto) throws Exception;
    public Producto obtener(int codigoProducto) throws Exception;
    public List<Producto> obtener() throws Exception;    
}
