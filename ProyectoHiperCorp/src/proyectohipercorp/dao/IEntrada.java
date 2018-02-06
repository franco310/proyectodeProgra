package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IEntrada {
    public int insertar(Entrada articulo) throws Exception;
    public int modificar(Entrada articulo) throws Exception;
    public int eliminar(Entrada articulo) throws Exception;
    public Entrada obtener(int idEntrada) throws Exception;
    public List<Entrada> obtener() throws Exception;    
}
