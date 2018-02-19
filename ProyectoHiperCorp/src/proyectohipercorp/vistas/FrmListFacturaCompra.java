
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectohipercorp.dao.IFacturaCompra;
import proyectohipercorp.entidades.FacturaCompra;
import proyectohipercorp.impl.FacturaCompraImpl;

/**
 *
 * @author Francisco
 */
public class FrmListFacturaCompra extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
     public FrmListFacturaCompra(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado de Facturas ");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
    }
     public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Id Factura Compra");
        modelo.addColumn("Id Proveedor");
        modelo.addColumn("Fecha");
        
        List<FacturaCompra> lista = new ArrayList<>();
        try {
            IFacturaCompra facturadao = new FacturaCompraImpl();
            lista = facturadao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(FacturaCompra est : lista){
            modelo.addRow(new Object[] { est.getIdFacturacompra(), est.getFecha(),
                est.getProveedor()});
            
            }
           tabla.setModel(modelo); 
        }
}
