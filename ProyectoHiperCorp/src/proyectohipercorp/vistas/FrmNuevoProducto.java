
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectohipercorp.dao.ICategoria;
import proyectohipercorp.dao.IProducto;
import proyectohipercorp.entidades.Categoria;
import proyectohipercorp.entidades.Producto;
import proyectohipercorp.impl.CategoriaImpl;
import proyectohipercorp.impl.ProductoImpl;

public class FrmNuevoProducto extends JInternalFrame {
    
    List<Categoria> lstCategoria;
    JComboBox<Categoria> cmbCategoria;
    JLabel lblTitulo0;
    JLabel lblCodigo;
    JLabel lblNombre;
    JLabel lblPrecio;
    JLabel lblCategoria;

     JTextField txtCodigo;
    JTextField txtNombre;
    JTextField txtPrecio;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoProducto() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Producto");
        
        lblCodigo = new JLabel("Código:");
        lblNombre = new JLabel("Nombre:");
        lblPrecio = new JLabel("Precio:");
        lblCategoria  = new JLabel("Categoria:");

        txtCodigo = new JTextField(2);
        txtNombre = new JTextField(2);
        txtPrecio = new JTextField(2);
        cargarCategorias();
        cmbCategoria = new JComboBox(lstCategoria.toArray());
        btnLimpiar = new JButton("Limpiar");
        btnAceptar = new JButton("Aceptar");
        
        pnlCentral.add(lblCodigo);
        pnlCentral.add(txtCodigo);
       
        pnlCentral.add(lblNombre);
        pnlCentral.add(txtNombre);
        pnlCentral.add(lblPrecio);
        pnlCentral.add(txtPrecio);
      
        pnlCentral.add(lblCategoria);
        pnlCentral.add(cmbCategoria);
        
                
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    btnAceptarActionListener(e);
                } catch (Exception ex) {
                    System.out.println("Error:"+ex.getMessage());
                }
            }
        });
        
        pnlPie.add(btnLimpiar);
        pnlPie.add(btnAceptar);
        
        this.add(lblTitulo0, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoProducto frmMenu= new FrmNuevoProducto();
        frmMenu.setVisible(true);
    } 
    public void cargarCategorias(){
        ICategoria categoriaDao = new CategoriaImpl();
        try {
            lstCategoria = categoriaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar las Categorias!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IProducto productoDao = new ProductoImpl();
        Producto producto = new Producto();
        producto.setCodigoProducto(Integer.parseInt(txtCodigo.getText()));
        producto.setNombre(txtNombre.getText());
        producto.setPrecio(Integer.parseInt(txtPrecio.getText()));
        producto.setCategoria((Categoria) cmbCategoria.getSelectedItem());
        
        try {
            if(productoDao.insertar(producto)>0){
                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this,"Error desconocido!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
            }           
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
                "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }
    
}
