
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyectohipercorp.dao.IUsuario;
import proyectohipercorp.entidades.Usuario;
import proyectohipercorp.impl.UsuarioImpl;

public class FrmNuevoUsuario extends JInternalFrame {
    JLabel lblTitulo;
    JLabel lblidUsuario;
    JLabel lblnombre;
    JLabel lblapellido;
    JLabel lblcontraseña;
    
    
    JTextField txtidUsuario;
    JTextField txtnombre;
    JTextField txtapellido;
    JTextField txtcontraseña;
    ;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
    public FrmNuevoUsuario() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo = new JLabel("Datos Usuario");
        
        lblidUsuario = new JLabel("idUsuario:");
        lblnombre = new JLabel("Nombre:");
        lblapellido = new JLabel("Apellido:");
        lblcontraseña = new JLabel("Contraseña:");
        
       
        

        txtidUsuario = new JTextField(2);
        txtnombre = new JTextField(2);
        txtapellido = new JTextField(2);
        txtcontraseña = new JTextField(2);
       
               
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidUsuario);
        pnlCentral.add(txtidUsuario);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblapellido);
        pnlCentral.add(txtapellido);
        pnlCentral.add(lblcontraseña);
        pnlCentral.add(txtcontraseña);
       ;
                         
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
        
        this.add(lblTitulo, BorderLayout.NORTH);
        this.add(pnlCentral, BorderLayout.CENTER);
        this.add(pnlPie, BorderLayout.SOUTH);        
    }
    public static void main(String[] args) {
        FrmNuevoUsuario frmMenu= new FrmNuevoUsuario();
        frmMenu.setVisible(true);
    }    
    public void btnAceptarActionListener(ActionEvent e){
        IUsuario usuarioDao = new UsuarioImpl();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(Integer.parseInt(txtidUsuario.getText()));
        usuario.setNombre(txtnombre.getText());
        usuario.setApellido(txtapellido.getText());
        usuario.setContraseña(txtcontraseña.getText());
        
      
        
        try {
            if(usuarioDao.insertar(usuario)>0){
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
