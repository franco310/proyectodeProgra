package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IKardex {
    public int insertar(Kardex articulo) throws Exception;
    public int modificar(Kardex articulo) throws Exception;
    public int eliminar(Kardex articulo) throws Exception;
    public Kardex obtener(int idKardex) throws Exception;
    public List<Kardex> obtener() throws Exception;    
}
