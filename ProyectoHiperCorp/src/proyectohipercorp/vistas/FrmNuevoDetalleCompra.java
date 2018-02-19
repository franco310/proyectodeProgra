
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
import proyectohipercorp.dao.IDetalleCompra;
import proyectohipercorp.dao.IFacturaCompra;
import proyectohipercorp.dao.IProducto;
import proyectohipercorp.entidades.DetalleCompra;
import proyectohipercorp.entidades.FacturaCompra;
import proyectohipercorp.entidades.Producto;
import proyectohipercorp.impl.DetalleCompraImpl;
import proyectohipercorp.impl.FacturaCompraImpl;
import proyectohipercorp.impl.ProductoImpl;

public class FrmNuevoDetalleCompra extends JInternalFrame {
   List<Producto> lstProducto;
   JComboBox<Producto> cmbProducto;
    List<FacturaCompra> lstFacturaCompra;
    JComboBox<FacturaCompra> cmbFacturacompra;
 
    JLabel lblTitulo0;
    JLabel lblcodigoDetalleCompra;
    JLabel lblCantidad;
    JLabel lblPreciototal;
    JLabel lblProducto;
    JLabel lblFacturacompra;
    
    JTextField txtcodigoDetalleCompra;
    JTextField txtCantidad;
    JTextField txtPreciototal;
    
       
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoDetalleCompra() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Detalle-Compra");
        
        lblcodigoDetalleCompra= new JLabel("Código:");
        lblCantidad= new JLabel("Cantidad:");
        lblPreciototal= new JLabel("Precio total:");
        lblProducto= new JLabel("Producto:");
        lblFacturacompra= new JLabel("FacturaCompra:");
        
        txtcodigoDetalleCompra = new JTextField(2);
        txtCantidad= new JTextField(2);
        txtPreciototal= new JTextField(2);
        cargarProductos();
        cmbProducto= new JComboBox(lstProducto.toArray());
        cargarFacturaCompra();
        cmbFacturacompra= new JComboBox(lstFacturaCompra.toArray());
                
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblcodigoDetalleCompra);
        pnlCentral.add(txtcodigoDetalleCompra);
        pnlCentral.add(lblCantidad);
        pnlCentral.add(txtCantidad);
        pnlCentral.add(lblPreciototal);
        pnlCentral.add(txtPreciototal);
        pnlCentral.add(lblProducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblFacturacompra);
        pnlCentral.add(cmbFacturacompra);
                
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
        FrmNuevoDetalleCompra frmMenu= new FrmNuevoDetalleCompra();
        frmMenu.setVisible(true);
    } 
    public void cargarProductos(){
        IProducto producctoDao = new ProductoImpl();
        try {
            lstProducto = producctoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Producto!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void cargarFacturaCompra(){
        IFacturaCompra facturacompraDao = new FacturaCompraImpl();
        try {
            lstFacturaCompra = facturacompraDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los FacturaCompra!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        DetalleCompra detallecompra = new DetalleCompra();
        IDetalleCompra detallecompraDao = new DetalleCompraImpl();
        detallecompra.setCodigoDetalleCompra(Integer.parseInt(txtcodigoDetalleCompra.getText()));
        detallecompra.setCantidad(Integer.parseInt(txtCantidad.getText()));
        detallecompra.setPreciototal(Integer.parseInt(txtPreciototal.getText()));
        detallecompra.setProducto((Producto) cmbProducto.getSelectedItem());
        detallecompra.setFacturacompra((FacturaCompra) cmbFacturacompra.getSelectedItem());
            

        try {
            if (detallecompraDao.insertar(detallecompra) > 0) {
                JOptionPane.showMessageDialog(this, "Registrado correctamente!!",
                        "Transacción correcta", JOptionPane.INFORMATION_MESSAGE);
            } else {
            JOptionPane.showMessageDialog(this,"Error desconocido: ",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error desconocido: "+ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
         }  
    } 
    
}
