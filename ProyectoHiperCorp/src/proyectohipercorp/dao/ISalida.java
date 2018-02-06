package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface ISalida {
    public int insertar(Salida articulo) throws Exception;
    public int modificar(Salida articulo) throws Exception;
    public int eliminar(Salida articulo) throws Exception;
    public Salida obtener(int idSalida) throws Exception;
    public List<Salida> obtener() throws Exception;    
}
