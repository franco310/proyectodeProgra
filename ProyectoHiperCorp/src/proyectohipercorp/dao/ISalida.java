package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface ISalida {
    public int insertar(Salida salida) throws Exception;
    public int modificar(Salida salida) throws Exception;
    public int eliminar(Salida salida) throws Exception;
    public Salida obtener(int idSalida) throws Exception;
    public List<Salida> obtener() throws Exception;    
}
