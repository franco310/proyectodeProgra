
package proyectohipercorp.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.watermark.SubstanceImageWatermark;


public class FrmMenuPrincipal extends JFrame {
    JMenuBar mnbPrincipal;
    JMenu mnInicio;
    JMenuItem mniLogin;
    JMenuItem mniSalir;
    
    //Articulos
    JMenu mnArticulos;
    JMenuItem mniNuevoArticulo;
    JMenuItem mniModificaArticulo;
    JMenuItem mniEliminaArticulo;
    JMenuItem mniBuscaArticulo;
    JMenuItem mniListaArticulo;
     
    // Clientes      
    JMenu mnClientes;
    JMenuItem mniNuevoCliente;
    JMenuItem mniModificaCliente;
    JMenuItem mniEliminaCliente;
    JMenuItem mniBuscaCliente;
    JMenuItem mniListaCliente;
    
     //Proveedor
    JMenu mnProveedor;
    JMenuItem mniNuevoProveedor;
    JMenuItem mniModificaProveedor;
    JMenuItem mniEliminaProveedor;
    JMenuItem mniBuscaProveedor;
    JMenuItem mniListaProveedor;
    
    //Detalle_Salida
    JMenu mnDetalle_Salida;
    JMenuItem mniNuevoDetalle_Salida;
    JMenuItem mniModificaDetalle_Salida;
    JMenuItem mniEliminaDetalle_Salida;
    JMenuItem mniBuscaDetalle_Salida;
    JMenuItem mniListaDetalle_Salida;
    
    //Detalle_venta
    JMenu mnDetalle_Venta;
    JMenuItem mniNuevoDetalle_Venta;
    JMenuItem mniModificaDetalle_Venta;
    JMenuItem mniEliminaDetalle_Venta;
    JMenuItem mniBuscaDetalle_Venta;
    JMenuItem mniListaDetalle_Venta;
            
    //Entrada
    JMenu mnEntrada;
    JMenuItem mniNuevoEntrada;
    JMenuItem mniModificaEntrada;
    JMenuItem mniEliminaEntrada;
    JMenuItem mniBuscaEntrada;
    JMenuItem mniListaEntrada;
    
    //Kardex
    JMenu mnKardex;
    JMenuItem mniNuevoKardex;
    JMenuItem mniModificaKardex;
    JMenuItem mniEliminaKardex;
    JMenuItem mniBuscaKardex;
    JMenuItem mniListaKardex;
   
    //Usuario
    JMenu mnUsuario;
    JMenuItem mniNuevoUsuario;
    JMenuItem mniModificaUsuario;
    JMenuItem mniEliminaUsuario;
    JMenuItem mniBuscaUsuario;
    JMenuItem mniListaUsuario;
    
   //Venta
    JMenu mnVentas;
    JMenuItem mniNuevoVentas;
    JMenuItem mniModificaVentas;
    JMenuItem mniEliminaVentas;
    JMenuItem mniBuscaVentas;
    JMenuItem mniListaVentas;
    
    JDesktopPane dkpEscritorio;
    
    public FrmMenuPrincipal(){
        //Inicio
        dkpEscritorio= new JDesktopPane();
        dkpEscritorio.setBackground(new Color(240, 240, 240));      
        mnbPrincipal = new JMenuBar();
        mnInicio = new JMenu("Inicio");
        mniLogin = new JMenuItem("Iniciar Sesión");
        mniSalir = new JMenuItem("Salir");

        mniSalir.addActionListener(new ActionListener() {
        @Override
            public void actionPerformed(ActionEvent e) {
                mniSalirActionPerformed(e);
            }
        });
        
       
        
        //Clientes
        mnClientes= new JMenu("Clientes");
        mniNuevoCliente= new JMenuItem("Nuevo");
        mniNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoClienteActionPerformed(e);
            }
        });
        mniModificaCliente= new JMenuItem("Modifica");
        mniEliminaCliente= new JMenuItem("Elimina");
        mniBuscaCliente= new JMenuItem("Busca");
        mniListaCliente= new JMenuItem("Lista"); 
         mniListaCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaClienteActionPerformed(e);
            }
        });
        mnClientes.add(mniNuevoCliente);
        mnClientes.add(mniModificaCliente);
        mnClientes.add(mniEliminaCliente);
        mnClientes.addSeparator();
        mnClientes.add(mniBuscaCliente);
        mnClientes.add(mniListaCliente);
         
         //Proveedor
        mnProveedor= new JMenu("Proveedor");
        mniNuevoProveedor= new JMenuItem("Nuevo");
        mniNuevoProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProveedorActionPerformed(e);
            }
        });
        mniModificaProveedor = new JMenuItem("Modifica");
        mniEliminaProveedor = new JMenuItem("Elimina");
        mniBuscaProveedor = new JMenuItem("Busca");
        mniListaProveedor = new JMenuItem("Lista"); 
         mniListaProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProveedorActionPerformed(e);
            }
        });
        mnProveedor.add(mniNuevoProveedor);
        mnProveedor.add(mniModificaProveedor);
        mnProveedor.add(mniEliminaProveedor);
        mnProveedor.addSeparator();
        mnProveedor.add(mniBuscaProveedor);
        mnProveedor.add(mniListaProveedor);
        
        //Articulo
        mnArticulos= new JMenu("Articulos");
        mniNuevoArticulo = new JMenuItem("Nuevo");
        mniNuevoArticulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoArticuloActionPerformed(e);
            }
        });
        mniModificaArticulo= new JMenuItem("Modifica");
        mniEliminaArticulo= new JMenuItem("Elimina");
        mniBuscaArticulo= new JMenuItem("Busca");
        mniListaArticulo= new JMenuItem("Lista"); 
        mniListaArticulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaArticuloActionPerformed(e);
            }
        });
        mnArticulos.add(mniNuevoArticulo);
        mnArticulos.add(mniModificaArticulo);
        mnArticulos.add(mniEliminaArticulo);
        mnArticulos.addSeparator();
        mnArticulos.add(mniBuscaArticulo);
        mnArticulos.add(mniListaArticulo);
        
        //Usuario
        mnUsuario = new JMenu("Usuarios");
        mniNuevoUsuario = new JMenuItem("Nuevo");
        mniNuevoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoUsuarioActionPerformed(e);
            }
        });
        mniModificaUsuario = new JMenuItem("Modifica");
        mniEliminaUsuario = new JMenuItem("Elimina");
        mniBuscaUsuario = new JMenuItem("Busca");
        mniListaUsuario = new JMenuItem("Lista");
         mniListaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaUsuarioActionPerformed(e);
            }
        });
        mnUsuario.add(mniNuevoUsuario);
        mnUsuario.add(mniModificaUsuario);
        mnUsuario.add(mniEliminaUsuario);
        mnUsuario.addSeparator();
        mnUsuario.add(mniBuscaUsuario);
        mnUsuario.add(mniListaUsuario);
        
        //Ventas
        mnVentas = new JMenu("Ventas");
        mniNuevoVentas= new JMenuItem("Nuevo");
        mniNuevoVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoVentasActionPerformed(e);
            }
        });
        mniModificaVentas= new JMenuItem("Modifica");
        mniEliminaVentas= new JMenuItem("Elimina");
        mniBuscaVentas= new JMenuItem("Busca");
        mniListaVentas= new JMenuItem("Lista"); 
        mniListaVentas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaVentasActionPerformed(e);
            }
        });
        mnVentas.add(mniNuevoVentas);
        mnVentas.add(mniModificaVentas);
        mnVentas.add(mniEliminaVentas);
        mnVentas.addSeparator();
        mnVentas.add(mniBuscaVentas);
        mnVentas.add(mniListaVentas);
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnClientes);
        mnbPrincipal.add(mnProveedor);
        mnbPrincipal.add(mnArticulos);
        mnbPrincipal.add(mnUsuario);
        mnbPrincipal.add(mnVentas);
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        
        
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setBounds(250,250,450,450);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
        
    } //Fin public FrmMenuPrincipal
    
    //Ventas
     public void mniNuevoVentasActionPerformed(ActionEvent e){
        FrmNuevoVentas frm = new FrmNuevoVentas();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaVentasActionPerformed(ActionEvent e){
        FrmListaVentas frm = new FrmListaVentas();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    //Usuario
     public void mniNuevoUsuarioActionPerformed(ActionEvent e){
        FrmNuevoUsuario frm = new FrmNuevoUsuario();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaUsuarioActionPerformed(ActionEvent e){
        FrmListaUsuario frm = new FrmListaUsuario();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    //Proveedor
    public void mniNuevoProveedorActionPerformed(ActionEvent e){
        FrmNuevoProveedor frm = new FrmNuevoProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaProveedorActionPerformed(ActionEvent e){
        FrmListaProveedor frm = new FrmListaProveedor();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
       //Cliente
     public void mniNuevoClienteActionPerformed(ActionEvent e){
        FrmNuevoCliente frm = new FrmNuevoCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaClienteActionPerformed(ActionEvent e){
        FrmListaCliente frm = new FrmListaCliente();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    //Articulo
    public void mniNuevoArticuloActionPerformed(ActionEvent e){
        FrmNuevoArticulo frm = new FrmNuevoArticulo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     public void mniListaArticuloActionPerformed(ActionEvent e){
        FrmListaArticulo frm = new FrmListaArticulo();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
     
   
     public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    public static void main(String[] args) {
         JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
       SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteSkin"); 
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark. SubstanceBubblesWatermark");//Ejemplo de aplicacion de un watermark de Substance
        SubstanceLookAndFeel.setCurrentWatermark( new SubstanceImageWatermark("e:\\hipercorp.jpg"));
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.9));//valor aproximado de la opacidad por default de imageWatermark
       // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin"); // Setencia que aplica el skin Creme de Substance
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
    
    
}
