package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IEntrada {
    public int insertar(Entrada entrada) throws Exception;
    public int modificar(Entrada entrada) throws Exception;
    public int eliminar(Entrada entrada) throws Exception;
    public Entrada obtener(int idEntrada) throws Exception;
    public List<Entrada> obtener() throws Exception;    
}
