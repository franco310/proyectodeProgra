/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import proyectohipercorp.dao.IFacturaCompra;
import proyectohipercorp.dao.IProveedor;
import proyectohipercorp.entidades.FacturaCompra;
import proyectohipercorp.entidades.Proveedor;
import proyectohipercorp.impl.FacturaCompraImpl;
import proyectohipercorp.impl.ProveedorImpl;

/**
 *
 * @author Segovia
 */
public class FrmNuevoFacturaCompra extends JInternalFrame {
    List<Proveedor> lstProveedor;
    JComboBox<Proveedor> cmbProveedor;
 
    JLabel lblidFactura;
    JLabel lblFecha;
    JLabel lblProveedor;
    JLabel lblTitulo0;
    
    JTextField txtidFactura;
    JTextField txtFecha;
    JTextField txtProveedor;
       
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoFacturaCompra () {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Factura-Compra");
        
        lblidFactura= new JLabel("Código:");
        lblFecha= new JLabel("Fecha:");
        lblProveedor= new JLabel("Proveedor:");
   
        
        txtidFactura = new JTextField(2);
        txtFecha= new JTextField(2);
        cargarProveedor();
        cmbProveedor= new JComboBox(lstProveedor.toArray());
                
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidFactura);
        pnlCentral.add(txtidFactura);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtFecha);
        pnlCentral.add(lblProveedor);
        pnlCentral.add(cmbProveedor);
                
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
        FrmNuevoFacturaCompra  frmMenu= new FrmNuevoFacturaCompra ();
        frmMenu.setVisible(true);
    } 
    public void cargarProveedor(){
        IProveedor proveedorDao = new ProveedorImpl();
        try {
            lstProveedor = proveedorDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Proveedor!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        FacturaCompra facturacompra = new FacturaCompra();
        IFacturaCompra FacturacompraDao = new FacturaCompraImpl();
        facturacompra.setIdFacturacompra(Integer.parseInt(txtidFactura.getText()));
         DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
            try {
                facturacompra.setFecha((Date) formatoFecha.parse(txtFecha.getText()));
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this,"Error en la fecha!!",
                "Error", JOptionPane.ERROR_MESSAGE);
            }
        facturacompra.setProveedor((Proveedor) cmbProveedor.getSelectedItem());
       
 
            

        try {
            if (FacturacompraDao.insertar(facturacompra) > 0) {
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