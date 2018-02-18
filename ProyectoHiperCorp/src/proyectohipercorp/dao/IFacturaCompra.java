package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IFacturaCompra {
    public int insertar(FacturaCompra facturacompra) throws Exception;
    public int modificar(FacturaCompra facturacompra) throws Exception;
    public int eliminar(FacturaCompra facturacompra) throws Exception;
    public FacturaCompra obtener(int codigoFacturaCompra) throws Exception;
    public List<FacturaCompra> obtener() throws Exception;    
}
