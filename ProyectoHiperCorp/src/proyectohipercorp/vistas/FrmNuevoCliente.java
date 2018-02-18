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

public class FrmNuevoCliente extends JInternalFrame {
    /*
         private int idCliente;
      private String nombre;
      private String apellido;
      private String direccion;
      private String telefono;
      private String email;
      private Date fecha_Nace;
    */
    JLabel lblTitulo0;
    JLabel lblidCliente;
    JLabel lblnombre;
    JLabel lblapellido;
    JLabel lbldireccion;
    JLabel lbltelefono;
    JLabel lblemail;
    JLabel lblFecha;
    
    JTextField txtidCliente;
    JTextField txtnombre;
    JTextField txtapellido;
    JTextField txtdireccion;
    JTextField txttelefono;
    JTextField txtemail;
    JTextField txtfecha;
    
    JButton btnLimpiar;
    JButton btnAceptar;
    JPanel pnlCentral;
    JPanel pnlPie;
    
     public FrmNuevoCliente() {
        this.setSize(300, 300);
        this.setLayout(new BorderLayout());
        this.setClosable(true);
        pnlCentral= new JPanel();
        pnlPie= new JPanel();
        pnlCentral.setLayout(new GridLayout(10, 2, 5, 5));
        pnlPie.setLayout(new GridLayout(1,2,5,5));
        
        lblTitulo0 = new JLabel("Datos del Cliente");
        
        lblidCliente= new JLabel("id Cliente:");
        lblnombre= new JLabel("Nombre:");
        lblapellido= new JLabel("Apelldio:");
        lbldireccion= new JLabel("Direccion:");
        lbltelefono= new JLabel("Telefono:");
       lblemail= new JLabel("Email:");
        lblFecha= new JLabel("Fecha de nacimiento:"); 

        txtidCliente = new JTextField(2);
        txtnombre= new JTextField(2);
        txtapellido= new JTextField(2);
        txtdireccion= new JTextField(2);
        txttelefono= new JTextField(2);
        txtemail= new JTextField(2);
        txtfecha= new JTextField(2);
        
        
        btnLimpiar= new JButton("Limpiar");
        btnAceptar= new JButton("Aceptar");
        
        pnlCentral.add(lblidCliente);
        pnlCentral.add(txtidCliente);
        pnlCentral.add(lblnombre);
        pnlCentral.add(txtnombre);
        pnlCentral.add(lblapellido);
        pnlCentral.add(txtapellido);
        pnlCentral.add(lbldireccion);
        pnlCentral.add(txtdireccion);
        pnlCentral.add(lbltelefono);
        pnlCentral.add(txttelefono);
        pnlCentral.add(lblemail);
        pnlCentral.add(txtemail);
        pnlCentral.add(lblFecha);
        pnlCentral.add(txtfecha);       
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
        FrmNuevoCliente frmMenu= new FrmNuevoCliente();
        frmMenu.setVisible(true);
    } 
    
    public void btnAceptarActionListener(ActionEvent e){
        ICliente clienteDao = new ClienteImpl();
        Cliente cliente = new Cliente();
        cliente.setIdCliente(Integer.parseInt(txtidCliente.getText()));
        cliente.setNombre(txtnombre.getText());
        cliente.setApellido(txtapellido.getText());
        cliente.setDireccion(txtdireccion.getText());
        cliente.setTelefono(txttelefono.getText());
       cliente.setDireccion(txtemail.getText());
        cliente.setTelefono(txtfecha.getText());
        
        
        try {
            if(clienteDao.insertar(cliente)>0){
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
