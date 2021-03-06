
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Cliente;
import modelo.Empleado;
import modelo.Usuario;



public class BorrarCliente extends javax.swing.JFrame {

    private Controlador controlador;
    private long  dni;
    private boolean confirmado=false;
    
    public BorrarCliente(Controlador controlador) {
        initComponents();
        setVisible(true);
        this.controlador=controlador;
        setTitle("Borrar Cliente");
        setSize(800, 650);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        btnSalir.setFont(fuente);        
        nombreborrar.setFont(fuente); 
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente); 
        confirmar.setFont(fuente); 
        TablaNombre.setFont(fuente);         
        try {
            mostrarTablaNombres();
        } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }   
    }
    /**
     * METODO PARA CARGAR EL JTABLE
     * @throws NotificarError 
     */
    private void mostrarTablaNombres() throws NotificarError{
        String matriz[][]= new String [controlador.buscarClientes().size()][3];
        List <Cliente> clientes= controlador.buscarClientes();
         
        int i = 0;
        if(!clientes.isEmpty()){
            for(Cliente e: controlador.buscarClientes()){
            matriz[i][0]=e.getNombre();
            matriz[i][1]=e.getApellido();
            matriz[i][2]=String.valueOf(e.getDni());
             i++;
        }
         TablaNombre.setModel(new DefaultTableModel(
            matriz,
            new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ));
        } else{
           TablaNombre.setModel(new DefaultTableModel(
                null,
                new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ));
       } 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNombre = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nombreborrar = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        confirmar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Clientes activos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 320, 50));

        TablaNombre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "DNI"
            }
        ));
        TablaNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaNombreMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaNombre);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 590, 210));

        jLabel2.setText("Nombre cliente a borrar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 260, 40));
        getContentPane().add(nombreborrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 220, 40));

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 130, 50));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 510, 140, 50));

        confirmar.setText("Confirmar");
        confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarActionPerformed(evt);
            }
        });
        getContentPane().add(confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 190, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * ACCIONES AL SELECCIONAR LA TABLA
     * @param evt 
     */
    private void TablaNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaNombreMouseClicked
        int row = TablaNombre.rowAtPoint(evt.getPoint());
        if(row>=0){
            String dniingresado =TablaNombre.getValueAt(row,2).toString();
             String nombre =TablaNombre.getValueAt(row,0).toString();
            if(dniingresado.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un Cliente.");
                setVisible(true);
            }else{
                nombreborrar.setText(nombre);
                dni=Long.parseLong(dniingresado);
            }    
        }        
    }//GEN-LAST:event_TablaNombreMouseClicked
    /**
     * ACCIONES DEL BOTON BORRAR
     * @param evt 
     */
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
       
        if((confirmado==true)&&(!(nombreborrar.getText().equals("")))){
            try {
                Cliente clienteABorrar= controlador.buscarUnCliente(dni);
                if(clienteABorrar!=null){
                    Usuario usuarioBorrar = clienteABorrar.getUsuario();
                    controlador.BorrarCliente(clienteABorrar);
                    controlador.BorrarUsuario(usuarioBorrar);
                    JOptionPane.showMessageDialog(null,"Se borro el Cliente "+clienteABorrar.getNombre()+ " "+clienteABorrar.getApellido()+" y su usuario.");
                    dispose();
                    MenuSupervisor iralmenu = new MenuSupervisor(controlador);
                } 
            } catch (NotificarError ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Debe confirmar para continuar.");
            setVisible(true);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed
    /**
     * ACCIONES DEL CHECK POINT
     * @param evt 
     */
    private void confirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarActionPerformed
        confirmado=true;
    }//GEN-LAST:event_confirmarActionPerformed
    /**
     * ACCIONES DEL BOTON SALIR
     * @param evt 
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu = new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaNombre;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox confirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreborrar;
    // End of variables declaration//GEN-END:variables
}
