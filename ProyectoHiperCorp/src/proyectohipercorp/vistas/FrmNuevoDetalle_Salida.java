//package proyectohipercorp.vistas;
//
//import java.awt.BorderLayout;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//import proyectohipercorp.dao.*;
//import proyectohipercorp.impl.*;
//import proyectohipercorp.entidades.*;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//
//public class FrmNuevoDetalle_Salida {
//    JLabel lblTitulo0;
//    JLabel lblidSalida;
//    JLabel lblidArticulo;
//    JLabel lblcantidad;
//    
//    JTextField txtidSalida;
//    JTextField txtidArticulo;
//    JTextField txtcantidad;
//    
//    JButton btnLimpiar;
//    JButton btnAceptar;
//    JPanel pnlCentral;
//    JPanel pnlPie;
//    
//    public FrmNuevoDetalle_Salida() {
//        
//        this.setSize(300, 300);
//        this.setLayout(new BorderLayout());
//        this.setClosable(true);
//        pnlCentral= new JPanel();
//        pnlPie= new JPanel();
//        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
//        pnlPie.setLayout(new GridLayout(1,2,5,5));
//        
//        lblTitulo0 = new JLabel("Datos Detalle_Salida");
//        
//        lblidSalida= new JLabel("id_Salida:");
//        lblidArticulo= new JLabel("id Articulo:");
//        lblcantidad= new JLabel("Cantidad:");
//        
//       
//        txtidSalida= new JTextField(2);
//        txtidArticulo = new JTextField(2);
//        txtcantidad= new JTextField(2);
//       
//        
//        btnLimpiar= new JButton("Limpiar");
//        btnAceptar= new JButton("Aceptar");
//        
//        pnlCentral.add(lblidSalida);
//        pnlCentral.add(txtidSalida);
//        pnlCentral.add(lblidArticulo);
//        pnlCentral.add(txtidArticulo);
//        pnlCentral.add(lblcantidad);
//        pnlCentral.add(txtcantidad);
//        
//              
//        btnAceptar.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    btnAceptarActionListener(e);
//                } catch (Exception ex) {
//                    System.out.println("Error:"+ex.getMessage());
//                }
//            }
//        });
//        
//        pnlPie.add(btnLimpiar);
//        pnlPie.add(btnAceptar);
//        
//        this.add(lblTitulo0, BorderLayout.NORTH);
//        this.add(pnlCentral, BorderLayout.CENTER);
//        this.add(pnlPie, BorderLayout.SOUTH);        
//    }
//    public static void main(String[] args) {
//        FrmNuevoDetalle_Salida frmMenu= new FrmNuevoDetalle_Salida();
//        frmMenu.setVisible(true);
//    } 
//    
//    public void btnAceptarActionListener(ActionEvent e){
//        
//        IDetalle_salida detalle_salidaDao = new Detalle_salidaImpl();
//        Detalle_salida detalle_salida = new Detalle_salida();
//        detalle_salida.setIdSalida(Integer.parseInt(txtidSalida.getText()));
//        detalle_salida.setIdArticulo(Integer.parseInt(txtidArticulo.getText()));
//        detalle_salida.setCantidad(Integer.parseInt(txtcantidad.getText()));
//        
//     
//        
//        try {
//            if(detalle_salidaDao.insertar(detalle_salida)>0){
//                JOptionPane.showMessageDialog(this,"Guaradado correctamente!!",
//                "Transacción", JOptionPane.INFORMATION_MESSAGE);
//            }else{
//                JOptionPane.showMessageDialog(this,"Error desconocido!!",
//                "Transacción", JOptionPane.INFORMATION_MESSAGE);
//            }           
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(this,"Error al guardar!!: " + ex.getMessage(),
//                "Error", JOptionPane.INFORMATION_MESSAGE);
//        }
//        
//    }
//    
//    
//}
