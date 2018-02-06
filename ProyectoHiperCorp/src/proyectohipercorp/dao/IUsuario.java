package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IUsuario {
    public int insertar(Usuario articulo) throws Exception;
    public int modificar(Usuario articulo) throws Exception;
    public int eliminar(Usuario articulo) throws Exception;
    public Usuario obtener(int idUsuario) throws Exception;
    public List<Usuario> obtener() throws Exception;    
}
