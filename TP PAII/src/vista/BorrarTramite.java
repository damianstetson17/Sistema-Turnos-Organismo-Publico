
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Tramite;

public class BorrarTramite extends javax.swing.JFrame {
    private Controlador controlador;
    private boolean confirmar=false;
    private String nombre;
    
    public BorrarTramite(Controlador control) {
        initComponents();
        this.controlador=control;
        setTitle("Borrar Tramite");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        setSize(800, 650);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        btnSalir.setFont(fuente);        
        nombretramiteAborrar.setFont(fuente); 
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente); 
        Confirmar.setFont(fuente); 
        TablaTramites.setFont(fuente);  
        
        try {
            mostrarTramites();
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    /**
      * carga la tabla de todos los Tramite actuales existentes en la BD
      * @throws NotificarError 
      */ 
     private void mostrarTramites() throws NotificarError{
        String matriz[][] = new String[controlador.buscarTramites().size()][1];
        List<Tramite> tramites= controlador.buscarTramites();
        int i = 0;
        if(!tramites.isEmpty()){
            for (Tramite t: tramites) {
            matriz[i][0] = t.getNombreTramite();
            i++;
            }
            TablaTramites.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Nombre"
            }
            ));
       }else{
           TablaTramites.setModel(new DefaultTableModel(
                null,
                new String[]{
                    "Nombre"
                }
        ));
       }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTramites = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombretramiteAborrar = new javax.swing.JTextField();
        Confirmar = new javax.swing.JCheckBox();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        TablaTramites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTramitesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTramites);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 310, 160));

        jLabel1.setText("Tramites activos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 230, 40));

        jLabel2.setText("Tramite a borrar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 150, 30));
        getContentPane().add(nombretramiteAborrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 160, 30));

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 110, 40));

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 120, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 400, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
    * ACCIONES DEL CHECK CONFIRMAR
    * @param evt 
    */
    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
       confirmar=true;
    }//GEN-LAST:event_ConfirmarActionPerformed
  /**
     * ACCIONES DEL BOTON BORRAR
     * @param evt 
     */
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if((confirmar==true)&&(!(nombretramiteAborrar.getText().equals("")))){
            try {
                Tramite tramiteABorrar= controlador.buscarUntramite(nombre);
                if(tramiteABorrar!=null){
                    controlador.BorrarTramite(tramiteABorrar);
                    JOptionPane.showMessageDialog(null,"Se borro el Tramite "+tramiteABorrar.getNombreTramite());
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
     * ACCIONES AL SELECCIONAR LA TABLA
     * @param evt 
     */
    private void TablaTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTramitesMouseClicked
      int row = TablaTramites.rowAtPoint(evt.getPoint());
        if(row>=0){
           
             nombre =TablaTramites.getValueAt(row,0).toString();
            if(nombre.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un Tramite.");
                setVisible(true);
            }else{
                nombretramiteAborrar.setText(nombre);
            }    
        } 
    }//GEN-LAST:event_TablaTramitesMouseClicked
    /**
     * ACCIONES DEL BOTON SALIR
     * @param evt 
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu = new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Confirmar;
    private javax.swing.JTable TablaTramites;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombretramiteAborrar;
    // End of variables declaration//GEN-END:variables
}
