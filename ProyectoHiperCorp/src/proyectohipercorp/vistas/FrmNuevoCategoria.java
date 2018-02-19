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
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectohipercorp.dao.ICategoria;
import proyectohipercorp.entidades.Categoria;
import proyectohipercorp.impl.CategoriaImpl;

/**
 *
 * @author Segovia
 */
public class FrmNuevoCategoria  extends JInternalFrame {
    /*
      private int idcategoria;
    private String nombre;
    private String descripcion;
    */
    JLabel lblTitulo0;
    JLabel lblidcategoria;
    JLabel lblnombre;
    JLabel lbldescripcion;
    
    
    JTextField txtidcategoria;
    JTextField txtnombre;
    JTextField txtdescripcion;
 
    
 
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoCategoria() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos Proveedor");
        
        lblidcategoria= new JLabel("Id Proveedor:");
        lblnombre= new JLabel("Nombre:");
        lbldescripcion= new JLabel("Descripcion:");
       
        txtidcategoria = new JTextField(2);
        txtnombre = new JTextField(2);
        txtdescripcion = new JTextField(2);
       
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidcategoria);
        pnlCentral.add(txtidcategoria);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lbldescripcion);
        pnlCentral.add(txtdescripcion);
              
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
        FrmNuevoCategoria frmMenu= new FrmNuevoCategoria();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        ICategoria categoriaDao = new CategoriaImpl();
        Categoria categoria = new Categoria();
        categoria.setCodigoCategoria(Integer.parseInt(txtidcategoria.getText()));
        categoria.setNombre(txtnombre.getText());
        categoria.setDescripcion(txtdescripcion.getText());
        
        
        try {
            if(categoriaDao.insertar(categoria)>0){
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
