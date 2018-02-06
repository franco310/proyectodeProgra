
package proyectohipercorp.vistas;
import proyectohipercorp.dao.ICliente;
import proyectohipercorp.entidades.Cliente;
import proyectohipercorp.impl.ClienteImpl;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class FrmListaCliente extends JInternalFrame {
   JLabel lblTitulo;
   JTable tabla;
   DefaultTableModel modelo; 
   
   public FrmListaCliente(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Clientes");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
    }
   public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("IdCliente");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Direccion");
        modelo.addColumn("Telefono");
        
        List<Cliente> lista = new ArrayList<>();
        try {
            ICliente clienteDao = new ClienteImpl();
            lista = clienteDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Cliente est : lista){
            modelo.addRow(new Object[] { est.getIdCliente(), est.getNombre(),
                est.getApellido(), est.getDireccion(),est.getTelefono()});
            }
           tabla.setModel(modelo); 
        }
    
}
