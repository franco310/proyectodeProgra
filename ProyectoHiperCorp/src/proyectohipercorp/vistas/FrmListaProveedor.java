
package proyectohipercorp.vistas;
import proyectohipercorp.dao.IProveedor;
import proyectohipercorp.entidades.Proveedor;
import proyectohipercorp.impl.ProveedorImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmListaProveedor extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    /*
    private int idProveedor;
      private String nombre;
      private String direccion;
      private String telefono;
      private String emai
    */
     public FrmListaProveedor(){
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
        modelo.addColumn("IdProveedor");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");
        modelo.addColumn("Email");
        
        List<Proveedor> lista = new ArrayList<>();
        try {
            IProveedor proveedorDao = new ProveedorImpl();
            lista = proveedorDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Proveedor est : lista){
            modelo.addRow(new Object[] { est.getIdProveedor(), est.getNombre(),
                est.getDireccion(), est.getTelefono(),est.getEmail()});
            
            }
           tabla.setModel(modelo); 
        }
    
}
