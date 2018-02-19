
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectohipercorp.dao.ICliente;
import proyectohipercorp.dao.IFacturaVenta;
import proyectohipercorp.entidades.Cliente;
import proyectohipercorp.entidades.FacturaVenta;
import proyectohipercorp.impl.ClienteImpl;
import proyectohipercorp.impl.FacturaVentaImpl;

public class FrmNuevoFacturaVenta extends JInternalFrame{
    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
     JLabel lblTitulo0;
    JLabel lblcodigoFacturaVenta;
    JLabel lblfecha;
    JLabel lblcliente;
    
    
    JTextField txtcodigoFacturaVenta;
    JTextField txtfecha;
 
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
    
     public FrmNuevoFacturaVenta() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos FacturaVenta");
        
        lblcodigoFacturaVenta= new JLabel("Código:");
        lblfecha = new JLabel("Fecha:");
        lblcliente = new JLabel("Cliente:");

        txtcodigoFacturaVenta = new JTextField(2);
        txtfecha = new JTextField(2);
        cargarClientes();
        cmbCliente = new JComboBox(lstCliente.toArray());
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblcodigoFacturaVenta);
        pnlCentral.add(txtcodigoFacturaVenta);
        pnlCentral.add(lblfecha);
        pnlCentral.add(txtfecha);
        pnlCentral.add(lblcliente);
        pnlCentral.add(cmbCliente);
        
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
        FrmNuevoFacturaVenta frmMenu= new FrmNuevoFacturaVenta();
        frmMenu.setVisible(true);
    } 
    public void cargarClientes(){
        ICliente clienteDao = new ClienteImpl();
        try {
            lstCliente = clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los cursos!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }       
    }
    public void btnAceptarActionListener(ActionEvent e){
        IFacturaVenta facturaventaDao = new FacturaVentaImpl();
        FacturaVenta facturaventa = new FacturaVenta();
        facturaventa.setCodigoFacturaVenta(Integer.parseInt(txtcodigoFacturaVenta.getText()));
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        try {                        
            facturaventa.setFecha((Date) formatoFecha.parse(txtfecha.getText()));
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Transacción", JOptionPane.INFORMATION_MESSAGE);
        }
        facturaventa.setCliente((Cliente) cmbCliente.getSelectedItem());
        
        try {
            if(facturaventaDao.insertar(facturaventa)>0){
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
