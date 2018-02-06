
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import proyectohipercorp.dao.*;
import proyectohipercorp.impl.*;
import proyectohipercorp.entidades.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class FrmNuevoProveedor extends JInternalFrame {
    JLabel lblTitulo0;
    JLabel lblidProveedor;
    JLabel lblruc;
    JLabel lblnombre;
    JLabel lblapellido;
    JLabel lbldireccion;
    
    
    JTextField txtidProveedor;
    JTextField txtruc;
    JTextField txtnombre;
    JTextField txtapellido;
    JTextField txtdireccion;
    
 
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoProveedor() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Proveedor");
        
        lblidProveedor= new JLabel("id Proveedor:");
        lblruc= new JLabel("Ruc:");
        lblnombre = new JLabel("Nombre:");
        lblapellido = new JLabel("Apellido:");
        lbldireccion = new JLabel("Direccion:");
       

        txtidProveedor = new JTextField(2);
        txtruc = new JTextField(2);
        txtnombre = new JTextField(2);
        txtapellido= new JTextField(2);
        txtdireccion= new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidProveedor);
        pnlCentral.add(txtidProveedor);
        pnlCentral.add(lblruc);
        pnlCentral.add(txtruc);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblapellido);
        pnlCentral.add(txtapellido);
        pnlCentral.add(lbldireccion);
        pnlCentral.add(txtdireccion);
              
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
        FrmNuevoProveedor frmMenu= new FrmNuevoProveedor();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        IProveedor proveedorDao = new ProveedorImpl();
        Proveedor proveedor = new Proveedor();
        proveedor.setIdProveedor(Integer.parseInt(txtidProveedor.getText()));
        proveedor.setRuc(txtnombre.getText());
        proveedor.setNombre(txtnombre.getText());
        proveedor.setApellido(txtapellido.getText());
        proveedor.setDireccion(txtdireccion.getText());
     
        
        try {
            if(proveedorDao.insertar(proveedor)>0){
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
