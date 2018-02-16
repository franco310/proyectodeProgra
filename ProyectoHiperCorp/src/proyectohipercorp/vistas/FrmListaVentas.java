
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectohipercorp.dao.IVenta;
import proyectohipercorp.entidades.Venta;
import proyectohipercorp.impl.VentaImpl;

public class FrmListaVentas extends JInternalFrame {
    JLabel lblTitulo;
   JTable tabla;
   DefaultTableModel modelo; 
   public FrmListaVentas(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Ventas");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
    }
   public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("IdVenta");
        modelo.addColumn("Fecha de Emision");
        modelo.addColumn("Fecha de Anulacion");
        modelo.addColumn("idCliente");
        modelo.addColumn("idUsuario");
        
        List<Venta> lista = new ArrayList<>();
        try {
            IVenta ventaDao = new VentaImpl();
            lista = ventaDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Venta est : lista){
            modelo.addRow(new Object[] { est.getIdVenta(), est.getFecha_emision(),
                est.getFecha_anulacion(), est.getCliente().getIdCliente(),est.getUsuario().getIdUsuario()});
            }
           tabla.setModel(modelo); 
        }
    
    
}
