package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IFactura {
    public int insertar(Factura articulo) throws Exception;
    public int modificar(Factura articulo) throws Exception;
    public int eliminar(Factura articulo) throws Exception;
    public Factura obtener(int idFactura) throws Exception;
    public List<Factura> obtener() throws Exception;    
}
