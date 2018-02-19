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
import proyectohipercorp.dao.ICategoria;
import proyectohipercorp.entidades.Categoria;
import proyectohipercorp.impl.CategoriaImpl;

/**
 *
 * @author Segovia
 */
public class FrmListaCategoria extends JInternalFrame {
    JLabel lblTitulo;
    JTable tabla;
    DefaultTableModel modelo;
    /*
   private int idcategoria;
    private String nombre;
    private String descripcion;
    */
     public FrmListaCategoria(){
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
        modelo.addColumn("Id Categoria");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripcion");
        
        List<Categoria> lista = new ArrayList<>();
        try {
            ICategoria categoriaDao = new CategoriaImpl();
            lista = categoriaDao.obtener();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error",
             JOptionPane.ERROR_MESSAGE);
        }
        for(Categoria est : lista){
            modelo.addRow(new Object[] { est.getCodigoCategoria(), est.getNombre(),
                est.getDescripcion()});
            
            }
           tabla.setModel(modelo); 
        }
    
}
