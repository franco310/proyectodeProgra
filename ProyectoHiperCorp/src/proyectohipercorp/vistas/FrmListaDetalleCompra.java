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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import proyectohipercorp.dao.IDetalleCompra;
import proyectohipercorp.entidades.DetalleCompra;
import proyectohipercorp.impl.DetalleCompraImpl;

/**
 *
 * @author Segovia
 */
public class FrmListaDetalleCompra extends JInternalFrame {
 JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    JScrollPane jscTabla;

    public FrmListaDetalleCompra() {
    this.setSize(800,600);
    this.setLayout(new BorderLayout());
    this.setClosable(true);
    lblTitulo =new JLabel("Listado Detalle-Compra");
    tabla = new JTable();
    jscTabla= new JScrollPane(tabla); 
    this.add(lblTitulo, BorderLayout.NORTH);
    this.add(jscTabla, BorderLayout.CENTER);
    cargarTabla();
    }
   
    public void cargarTabla(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Codigo");
        modelo.addColumn("Producto");
        modelo.addColumn("Factura ");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio total");
        
        List<DetalleCompra>lista= new ArrayList<>();
        try {
            IDetalleCompra detallecompraDao = new DetalleCompraImpl();
            lista = detallecompraDao.obtener();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
      for(DetalleCompra est : lista){
            modelo.addRow(new Object[] { est.getCodigoDetalleCompra(),est.getCantidad(),est.getPreciototal()});
            
            }
           tabla.setModel(modelo); 
        }
    
}
