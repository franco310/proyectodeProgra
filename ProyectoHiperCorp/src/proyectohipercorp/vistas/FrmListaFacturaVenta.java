
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectohipercorp.dao.IFacturaVenta;
import proyectohipercorp.entidades.FacturaVenta;
import proyectohipercorp.impl.FacturaVentaImpl;

public class FrmListaFacturaVenta extends JInternalFrame{
    
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaFacturaVenta(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado FacturaVentas");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Fecha");
        
        List<FacturaVenta> lista = new ArrayList<>();
        try {
            IFacturaVenta estudianteDao = new FacturaVentaImpl();
            lista = estudianteDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(FacturaVenta est : lista){
            modelo.addRow(new Object[] { est.getCodigoFacturaVenta(), est.getFecha()});
            
           tabla.setModel(modelo); 
        }
    
}
}
