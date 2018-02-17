package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface ICategoria {
    public int insertar(Categoria categoria) throws Exception;
    public int modificar(Categoria categoria) throws Exception;
    public int eliminar(Categoria categoria) throws Exception;
    public Categoria obtener(int codigoCategoria) throws Exception;
    public List<Categoria> obtener() throws Exception;    
}
