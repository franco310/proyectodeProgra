package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IFactura {
    public int insertar(Factura factura) throws Exception;
    public int modificar(Factura factura) throws Exception;
    public int eliminar(Factura factura) throws Exception;
    public Factura obtener(int idFactura) throws Exception;
    public List<Factura> obtener() throws Exception;    
}
