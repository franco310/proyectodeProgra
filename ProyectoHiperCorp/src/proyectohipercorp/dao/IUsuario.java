package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IUsuario {
    public int insertar(Usuario usuario) throws Exception;
    public int modificar(Usuario usuario) throws Exception;
    public int eliminar(Usuario usuario) throws Exception;
    public Usuario obtener(int idUsuario) throws Exception;
    public List<Usuario> obtener() throws Exception;    
}
