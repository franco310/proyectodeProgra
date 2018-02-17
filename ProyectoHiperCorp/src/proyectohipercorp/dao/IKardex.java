package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IKardex {
    public int insertar(Kardex kardex) throws Exception;
    public int modificar(Kardex kardex) throws Exception;
    public int eliminar(Kardex kardex) throws Exception;
    public Kardex obtener(int codigoKardex) throws Exception;
    public List<Kardex> obtener() throws Exception;    
}
