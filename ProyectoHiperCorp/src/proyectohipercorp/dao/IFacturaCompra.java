package proyectohipercorp.dao;
import proyectohipercorp.entidades.*;
import java.util.*;

public interface IFacturaCompra {
    public int insertar(Factura_Compra facturacompra) throws Exception;
    public int modificar(Factura_Compra facturacompra) throws Exception;
    public int eliminar(Factura_Compra facturacompra) throws Exception;
    public Factura_Compra obtener(int codigoFacturaCompra) throws Exception;
    public List<Factura_Compra> obtener() throws Exception;    
}
