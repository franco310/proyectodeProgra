package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IDetalle_salida {
    public int insertar(Detalle_salida articulo) throws Exception;
    public int modificar(Detalle_salida articulo) throws Exception;
    public int eliminar(Detalle_salida articulo) throws Exception;
    public Detalle_salida obtener(int idSalida) throws Exception;
    public List<Detalle_salida> obtener() throws Exception;    
}
