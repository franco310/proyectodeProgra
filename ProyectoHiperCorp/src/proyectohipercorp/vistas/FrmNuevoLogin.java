
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
import proyectohipercorp.dao.IUsuario;
import proyectohipercorp.entidades.Usuario;
import proyectohipercorp.impl.UsuarioImpl;

public class FrmNuevoLogin extends JInternalFrame {
    
    JLabel lblTitulo;
    JLabel lblUsuario;
    JLabel lblContraseña;
    
    
    JTextField txtUsuario;
    JTextField txtContraseña;
    
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoLogin() {
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(11, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo = new JLabel("Ingrese sus Datos");
        
        lblUsuario = new JLabel("Usuario:");
        lblContraseña = new JLabel("Contraseña:");
        
       
        

        txtUsuario = new JTextField(2);
        txtContraseña = new JTextField(2);
       
               
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblUsuario);
        pnlCentral.add(txtUsuario);
        pnlCentral.add(lblContraseña);
        pnlCentral.add(txtContraseña);
                 
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
        FrmNuevoLogin frmMenu= new FrmNuevoLogin();
            frmMenu.setVisible(true);
    }    
    public void btnAceptarActionListener(ActionEvent e){
        
        if(txtUsuario.getText().equals("marco") && txtContraseña.getText().equals("123")){
            
            JOptionPane.showMessageDialog(this, "Datos Correctos");
            
            
            
        }
        else{
            
            JOptionPane.showMessageDialog(this, "Datos Incorrectos");
        }
        
        
    }
    
}
