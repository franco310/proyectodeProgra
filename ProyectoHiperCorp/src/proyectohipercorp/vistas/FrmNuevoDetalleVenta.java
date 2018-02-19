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
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectohipercorp.dao.IDetalleVenta;
import proyectohipercorp.dao.IFacturaVenta;
import proyectohipercorp.dao.IProducto;
import proyectohipercorp.entidades.DetalleVenta;
import proyectohipercorp.entidades.FacturaVenta;
import proyectohipercorp.entidades.Producto;
import proyectohipercorp.impl.DetalleVentaImpl;
import proyectohipercorp.impl.FacturaVentaImpl;
import proyectohipercorp.impl.ProductoImpl;

/**
 *
 * @author Segovia
 */
public class FrmNuevoDetalleVenta extends JInternalFrame {
    List<Producto> lstProduto;
    JComboBox<Producto> cmbProducto;
    List<FacturaVenta> lstFacturaVenta;
    JComboBox<FacturaVenta> cmbFacturaVenta;
 
    JLabel lblidDetalleventa;
    JLabel lblProducto;
    JLabel lblFacturaventa;
    JLabel lblCantidad;
    JLabel lblPreciototal;
    JLabel lblTitulo0;
    
    JTextField txtidDetalleventa;
    JTextField txtProducto;
    JTextField txtFacturaventa;
    JTextField txtCantidad;
    JTextField txtPreciototal;
       
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;

    public FrmNuevoDetalleVenta() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Detalle-Venta");
        
        lblidDetalleventa= new JLabel("Código:");
        lblProducto= new JLabel("Producto:");
        lblFacturaventa= new JLabel("Factura:");
        lblCantidad= new JLabel("Cantidad:");
        lblPreciototal= new JLabel("Precio total:");
        
        txtidDetalleventa = new JTextField(2);
        cargarProducto();
        cmbProducto= new JComboBox(lstProduto.toArray());
        cargarFacturaVenta();
        cmbFacturaVenta= new JComboBox(lstFacturaVenta.toArray());
        txtCantidad= new JTextField(2);
        txtPreciototal= new JTextField(2);
                
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidDetalleventa);
        pnlCentral.add(txtidDetalleventa);
        pnlCentral.add(lblProducto);
        pnlCentral.add(cmbProducto);
        pnlCentral.add(lblFacturaventa);
        pnlCentral.add(cmbFacturaVenta);
        pnlCentral.add(lblCantidad);
        pnlCentral.add(txtCantidad);
        pnlCentral.add(lblPreciototal);
        pnlCentral.add(txtPreciototal);
                
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
        FrmNuevoDetalleVenta frmMenu= new FrmNuevoDetalleVenta();
        frmMenu.setVisible(true);
    } 
    public void cargarProducto(){
        IProducto producctoDao = new ProductoImpl();
        try {
            lstProduto = producctoDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los Producto!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void cargarFacturaVenta(){
        IFacturaVenta facturavetaDao = new FacturaVentaImpl();
        try {
            lstFacturaVenta = facturavetaDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Error al cargar los FacturaVenta!!",
                "Error"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
        }
        
    }
    public void btnAceptarActionListener(ActionEvent e){
        DetalleVenta detalleventa = new DetalleVenta();
        IDetalleVenta detalleventaDao = new DetalleVentaImpl();
        detalleventa.setIdCodigodetalle_venta(Integer.parseInt(txtidDetalleventa.getText()));
        detalleventa.setProducto((Producto) cmbProducto.getSelectedItem());
        detalleventa.setFacturaventa((FacturaVenta) cmbFacturaVenta.getSelectedItem());
        detalleventa.setCantidad(Integer.parseInt(txtCantidad.getText()));
        detalleventa.setPreciototal(Integer.parseInt(txtPreciototal.getText()));
            

        try {
            if (detalleventaDao.insertar(detalleventa) > 0) {
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
