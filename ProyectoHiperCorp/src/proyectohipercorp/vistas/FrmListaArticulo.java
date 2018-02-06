
package proyectohipercorp.vistas;
import proyectohipercorp.dao.IArticulo;
import proyectohipercorp.entidades.Articulo;
import proyectohipercorp.impl.ArticuloImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaArticulo extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    
    public FrmListaArticulo(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Articulos");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("IdArticulo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Estado");
        modelo.addColumn("Observacion");
        
        List<Articulo> lista = new ArrayList<>();
        try {
            IArticulo articuloDao = new ArticuloImpl();
            lista = articuloDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Articulo est : lista){
            modelo.addRow(new Object[] { est.getIdArticulo(), est.getNombre(),
                est.getCantidad(), est.getEstado(),est.getObservacio()});
            }
           tabla.setModel(modelo); 
        }
    
}
