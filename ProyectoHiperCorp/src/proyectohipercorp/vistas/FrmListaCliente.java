/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectohipercorp.dao.ICliente;
import proyectohipercorp.entidades.Cliente;
import proyectohipercorp.impl.ClienteImpl;

/**
 *
 * @author Segovia
 */
public class FrmListaCliente extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
  
     public FrmListaCliente(){
        this.setSize(800, 600);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        lblTitulo = new JLabel("Listado Articulos");
        tabla = new JTable();
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(tabla, BorderLayout.CENTER);
        cargarTabla(); 
        
    }
     public void cargarTabla(){
        modelo = new  DefaultTableModel();
        modelo.addColumn("Id Cliente:");
        modelo.addColumn("Nombre:");
        modelo.addColumn("Apellido:");
        modelo.addColumn("Telefono:");
        modelo.addColumn("Email:");
        modelo.addColumn("Fecha de nacimiento");
        
        List<Cliente> lista = new ArrayList<>();
        try {
            ICliente clienteDao = new ClienteImpl();
            lista = clienteDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Cliente est : lista){
            modelo.addRow(new Object[] { est.getCedula(), est.getNombres(),
                est.getApellidos(),est.getDireccion(),est.getTelefono(),est.getEmail(),est.getFecha_Nace()});
            
            }
           tabla.setModel(modelo); 
        }
    
}
