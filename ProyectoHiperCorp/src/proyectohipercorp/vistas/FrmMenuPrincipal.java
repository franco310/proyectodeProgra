
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
    
    //Producto
    JMenu mnProducto;
    JMenuItem mniNuevoProducto;
    JMenuItem mniModificaProducto;
    JMenuItem mniEliminaProducto;
    JMenuItem mniBuscaProducto;
    JMenuItem mniListaProducto;
     
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
    
   //Categoria
    JMenu mnCategoria;
    JMenuItem mniNuevoCategoria;
    JMenuItem mniModificaCategoria;
    JMenuItem mniEliminaCategoria;
    JMenuItem mniBuscaCategoria;
    JMenuItem mniListaCategoria;
    
    //DetalleCompra
    JMenu mnDetalleCompra;
    JMenuItem mniNuevoDetalleCompra;
    JMenuItem mniModificaDetalleCompra;
    JMenuItem mniEliminaDetalleCompra;
    JMenuItem mniBuscaDetalleCompra;
    JMenuItem mniListaDetalleCompra;
    
    //FacturaVenta
    JMenu mnFacturaVenta;
    JMenuItem mniNuevoFacturaVenta;
    JMenuItem mniModificaFacturaVenta;
    JMenuItem mniEliminaFacturaVenta;
    JMenuItem mniBuscaFacturaVenta;
    JMenuItem mniListaFacturaVenta;
    
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
        
        //Producto
        mnProducto = new JMenu("Producto");
        mniNuevoProducto = new JMenuItem("Nuevo");
        mniNuevoProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoProductoActionPerformed(e);
            }
        });
        mniModificaProducto = new JMenuItem("Modifica");
        mniEliminaProducto = new JMenuItem("Elimina");
        mniBuscaProducto = new JMenuItem("Busca");
        mniListaProducto = new JMenuItem("Lista");
         mniListaProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaProductoActionPerformed(e);
            }
        });
        mnProducto.add(mniNuevoProducto);
        mnProducto.add(mniModificaProducto);
        mnProducto.add(mniEliminaProducto);
        mnProducto.addSeparator();
        mnProducto.add(mniBuscaProducto);
        mnProducto.add(mniListaProducto);
        
        //Categoria
        mnCategoria = new JMenu("Categoria");
        mniNuevoCategoria = new JMenuItem("Nuevo");
        mniNuevoCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoCategoriaActionPerformed(e);
            }
        });
        mniModificaCategoria = new JMenuItem("Modifica");
        mniEliminaCategoria = new JMenuItem("Elimina");
        mniBuscaCategoria = new JMenuItem("Busca");
        mniListaCategoria = new JMenuItem("Lista");
         mniListaCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaCategoriaActionPerformed(e);
            }
        });
        mnCategoria.add(mniNuevoCategoria);
        mnCategoria.add(mniModificaCategoria);
        mnCategoria.add(mniEliminaCategoria);
        mnCategoria.addSeparator();
        mnCategoria.add(mniBuscaCategoria);
        mnCategoria.add(mniListaCategoria);
        
        //DetalleCompra
        mnDetalleCompra = new JMenu("DetalleCompra");
        mniNuevoDetalleCompra = new JMenuItem("Nuevo");
        mniNuevoDetalleCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoDetalleCompraActionPerformed(e);
            }
        });
        mniModificaDetalleCompra = new JMenuItem("Modifica");
        mniEliminaDetalleCompra = new JMenuItem("Elimina");
        mniBuscaDetalleCompra = new JMenuItem("Busca");
        mniListaDetalleCompra = new JMenuItem("Lista");
        mniListaDetalleCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaDetalleCompraActionPerformed(e);
            }
        });
        mnDetalleCompra.add(mniNuevoDetalleCompra);
        mnDetalleCompra.add(mniModificaDetalleCompra);
        mnDetalleCompra.add(mniEliminaDetalleCompra);
        mnDetalleCompra.addSeparator();
        mnDetalleCompra.add(mniBuscaDetalleCompra);
        mnDetalleCompra.add(mniListaDetalleCompra);
        
         //FacturaVenta
        mnFacturaVenta = new JMenu("FacturaVenta");
        mniNuevoFacturaVenta = new JMenuItem("Nuevo");
        mniNuevoFacturaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniNuevoFacturaVentaActionPerformed(e);
            }
        });
        mniModificaFacturaVenta = new JMenuItem("Modifica");
        mniEliminaFacturaVenta = new JMenuItem("Elimina");
        mniBuscaFacturaVenta = new JMenuItem("Busca");
        mniListaFacturaVenta = new JMenuItem("Lista");
        mniListaFacturaVenta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mniListaFacturaVentaActionPerformed(e);
            }
        });
        mnFacturaVenta.add(mniNuevoFacturaVenta);
        mnFacturaVenta.add(mniModificaFacturaVenta);
        mnFacturaVenta.add(mniEliminaFacturaVenta);
        mnFacturaVenta.addSeparator();
        mnFacturaVenta.add(mniBuscaFacturaVenta);
        mnFacturaVenta.add(mniListaFacturaVenta);
        
        
        
        mnbPrincipal.add(mnInicio);
        mnbPrincipal.add(mnClientes);
        mnbPrincipal.add(mnProveedor);
        mnbPrincipal.add(mnUsuario);
        mnbPrincipal.add(mnProducto);
        mnbPrincipal.add(mnCategoria);
        mnbPrincipal.add(mnDetalleCompra);
        mnbPrincipal.add(mnFacturaVenta);
        
        mnInicio.add(mniLogin);
        mnInicio.add(mniSalir);
        
        
        this.setLayout(new BorderLayout());
        this.add(mnbPrincipal, BorderLayout.NORTH);
        this.add(dkpEscritorio, BorderLayout.CENTER);
        this.setExtendedState(MAXIMIZED_BOTH); //Para maximizar
        this.setBounds(350,350,550,550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); //Para terminar el programa
        
    } //Fin public FrmMenuPrincipal
    //FacturaVenta
     public void mniNuevoFacturaVentaActionPerformed(ActionEvent e){
        FrmNuevoFacturaVenta frm = new FrmNuevoFacturaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaFacturaVentaActionPerformed(ActionEvent e){
        FrmListaFacturaVenta frm = new FrmListaFacturaVenta();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
    
     //DetalleCategoria
     public void mniNuevoDetalleCompraActionPerformed(ActionEvent e){
        FrmNuevoDetalleCompra frm = new FrmNuevoDetalleCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaDetalleCompraActionPerformed(ActionEvent e){
        FrmListaDetalleCompra frm = new FrmListaDetalleCompra();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
    
     //Categoria
     public void mniNuevoCategoriaActionPerformed(ActionEvent e){
        FrmNuevoCategoria frm = new FrmNuevoCategoria();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaCategoriaActionPerformed(ActionEvent e){
        FrmListaCategoria frm = new FrmListaCategoria();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }

   //Producto
     public void mniNuevoProductoActionPerformed(ActionEvent e){
        FrmNuevoProducto frm = new FrmNuevoProducto();
        dkpEscritorio.add(frm);
        frm.setVisible(true);
    }
       public void mniListaProductoActionPerformed(ActionEvent e){
        FrmListaProducto frm = new FrmListaProducto();
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
  
   
     public void mniSalirActionPerformed(ActionEvent e){
        System.exit(0);
    }
    
    public static void main(String[] args) {
         JFrame.setDefaultLookAndFeelDecorated(true); //que nos permite dejar a Substance la decoracion ( por asi decirlo) 
       SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.RavenGraphiteSkin"); 
        SubstanceLookAndFeel.setCurrentWatermark("org.jvnet.substance.watermark. SubstanceBubblesWatermark");//Ejemplo de aplicacion de un watermark de Substance
        SubstanceLookAndFeel.setCurrentWatermark( new SubstanceImageWatermark("e:\\fondo.jpg"));
        SubstanceLookAndFeel.setImageWatermarkOpacity(new Float(0.9));//valor aproximado de la opacidad por default de imageWatermark
       // SubstanceLookAndFeel.setSkin("org.jvnet.substance.skin.CremeSkin"); // Setencia que aplica el skin Creme de Substance
        FrmMenuPrincipal frm = new FrmMenuPrincipal();
        frm.setVisible(true);
    }
    
    
}
