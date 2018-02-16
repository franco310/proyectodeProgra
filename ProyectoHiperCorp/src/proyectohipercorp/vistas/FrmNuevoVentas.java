
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectohipercorp.dao.*;
import proyectohipercorp.entidades.*;
import proyectohipercorp.impl.*;

public class FrmNuevoVentas extends JInternalFrame {
    
    List<Cliente> lstCliente;
    JComboBox<Cliente> cmbCliente;
    
    List<Usuario> lstUsuario;
    JComboBox<Usuario> cmbUsuario;
    
    JLabel lblTitulo0;
    JLabel lblidVenta;
    JLabel lblFecha_Emision;
    JLabel lblFecha_Anulacion;
    JLabel lblCliente;
    JLabel lblUsuario;
    
    JTextField txtidVenta;
    JTextField txtFecha_Emision;
    JTextField txtFecha_Anulacion;
    
    
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoVentas() {
        this.setSize(350, 350);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(9, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Ventas");
        
        lblidVenta = new JLabel("Código Venta:");
        lblFecha_Emision = new JLabel("Fecha Emision:");
        lblFecha_Anulacion = new JLabel("Fecha Anulacion:");
        lblCliente = new JLabel("Cliente");
        lblUsuario = new JLabel("Usuario:");
        
        
        txtidVenta = new JTextField(2);
        txtFecha_Emision = new JTextField(2); 
        txtFecha_Anulacion = new JTextField(2);
        cargarClientes();
        cmbCliente = new JComboBox(lstCliente.toArray());
        cargarUsuarios();
        cmbUsuario = new JComboBox(lstUsuario.toArray());
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidVenta);
        pnlCentral.add(txtidVenta);
        pnlCentral.add(lblFecha_Emision);
        pnlCentral.add(txtFecha_Emision);
        pnlCentral.add(lblFecha_Anulacion);
        pnlCentral.add(txtFecha_Anulacion);
        pnlCentral.add(lblCliente);
        pnlCentral.add(cmbCliente);
        pnlCentral.add(lblUsuario);
        pnlCentral.add(cmbUsuario);
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
        FrmNuevoVentas frmMenu= new FrmNuevoVentas();
        frmMenu.setVisible(true);
    }

    private void cargarClientes() {
        ICliente clienteDao = new ClienteImpl();
        try {
            lstCliente = (ArrayList<Cliente>) clienteDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR CLIENTES", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    private void cargarUsuarios() {
        IUsuario usuarioDao = new UsuarioImpl();
        try {
            lstUsuario = (ArrayList<Usuario>) usuarioDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "ERROR AL CARGAR USUARIOS", "ERROR" + e.getMessage(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void btnAceptarActionListener(ActionEvent e){
         Venta venta = new Venta();
        IVenta ventaDao = new VentaImpl();
        venta.setIdVenta(Integer.parseInt(txtidVenta.getText()));
        DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                venta.setFecha_emision((Date) formatoFecha.parse(txtFecha_Emision.getText()));
                venta.setFecha_anulacion((Date) formatoFecha.parse(txtFecha_Anulacion.getText()));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            }
        
        venta.setCliente((Cliente) cmbCliente.getSelectedItem());
       venta.setUsuario((Usuario) cmbUsuario.getSelectedItem());

        try {
            if (ventaDao.insertar(venta) > 0) {
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
