package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;
public interface IArticulos {
    public int insertar(Articulo articulo) throws Exception;
    public int modificar(Articulo articulo) throws Exception;
    public int eliminar(Articulo articulo) throws Exception;
    public Articulo obtener(int codigo) throws Exception;
    public List<Articulo> obtener() throws Exception;    
}
