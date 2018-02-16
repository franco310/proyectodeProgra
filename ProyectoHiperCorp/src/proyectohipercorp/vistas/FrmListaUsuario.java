
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectohipercorp.dao.IUsuario;
import proyectohipercorp.entidades.Usuario;
import proyectohipercorp.impl.UsuarioImpl;

public class FrmListaUsuario  extends JInternalFrame{
   JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    public FrmListaUsuario(){
        
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Usuarios");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla();
        
    }
    public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido"); 
        modelo.addColumn("Contraseña"); 
        
        List<Usuario> lista = new ArrayList<>();
        try {
            IUsuario usuarioDao = new UsuarioImpl();
            lista = usuarioDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Usuario est : lista){
            modelo.addRow(new Object[] { est.getIdUsuario(), est.getNombre(),
                est.getApellido(), est.getContraseña()});
            }
           tabla.setModel(modelo); 
        }
}
