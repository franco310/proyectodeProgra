
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


public class FrmNuevoArticulo extends JInternalFrame{
    
    JLabel lblTitulo0;
    JLabel lblidArticulo;
    JLabel lblnombre;
    JLabel lblcantidad;
    JLabel lblestado;
    JLabel lblobservacion;
    
    
    JTextField txtidArticulo;
    JTextField txtnombre;
    JTextField txtcantidad;
    JTextField txtestado;
    JTextField txtobservacion;
    
 
    JButton btnLimpiar;
    JButton btnAceptar;
    
    JPanel pnlCentral;
    JPanel pnlPie;
    public FrmNuevoArticulo() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Articulo");
        
        lblidArticulo= new JLabel("id Articulo:");
        lblnombre= new JLabel("Nombre:");
        lblcantidad= new JLabel("Cantidad:");
        lblestado= new JLabel("Estado:");
        lblobservacion= new JLabel("Observacion:");
       

        txtidArticulo = new JTextField(2);
        txtnombre= new JTextField(2);
        txtcantidad= new JTextField(2);
        txtestado= new JTextField(2);
        txtobservacion= new JTextField(2);
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidArticulo);
        pnlCentral.add(txtidArticulo);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblcantidad);
        pnlCentral.add(txtcantidad);
        pnlCentral.add(lblestado);
        pnlCentral.add(txtestado);
        pnlCentral.add(lblobservacion);
        pnlCentral.add(txtobservacion);
              
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
        FrmNuevoArticulo frmMenu= new FrmNuevoArticulo();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        IArticulo articuloDao = new ArticuloImpl();
        Articulo articulo = new Articulo();
        articulo.setIdArticulo(Integer.parseInt(txtidArticulo.getText()));
        articulo.setNombre(txtnombre.getText());
        articulo.setCantidad(Integer.parseInt(txtcantidad.getText()));
        articulo.setEstado(txtestado.getText());
        articulo.setObservacio(txtobservacion.getText());
     
        
        try {
            if(articuloDao.insertar(articulo)>0){
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
