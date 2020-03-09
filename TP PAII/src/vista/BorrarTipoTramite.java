
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.TipoTramite;



public class BorrarTipoTramite extends javax.swing.JFrame {
    private Controlador controlador;
    private boolean confirmar=false;
    private String nombre;
    
    public BorrarTipoTramite(Controlador control) {
        initComponents();
        this.controlador=control;
        setTitle("Borrar Tipo Tramite");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        setSize(1500, 1000);
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        btnSalir.setFont(fuente);        
        nombreTipoTramiteBorrar.setFont(fuente); 
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente); 
        Confirmar.setFont(fuente); 
        TablaTipoTramites.setFont(fuente);  
        
        try {
            mostrarTiposTramites();
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

     /**
      * carga la tabla de todos los Tramite actuales existentes en la BD
      * @throws NotificarError 
      */ 
     private void mostrarTiposTramites() throws NotificarError{
        String matriz[][] = new String[controlador.buscarTipoTramites().size()][1];
        List<TipoTramite> tipostramites= controlador.buscarTipoTramites();
        int i = 0;
        if(!tipostramites.isEmpty()){
            for (TipoTramite t: tipostramites) {
            matriz[i][0] = t.getNombreTipoTramite();
            i++;
            }
            TablaTipoTramites.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Nombre"
            }
            ));
       }else{
           TablaTipoTramites.setModel(new DefaultTableModel(
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTipoTramites = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        nombreTipoTramiteBorrar = new javax.swing.JTextField();
        Confirmar = new javax.swing.JCheckBox();
        btnBorrar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tipos Tramites activos:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 240, 40));

        TablaTipoTramites.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        TablaTipoTramites.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTipoTramitesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTipoTramites);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 400, 130));

        jLabel2.setText("Nombre Tipo Tramite a borrar:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 260, 40));
        getContentPane().add(nombreTipoTramiteBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 140, 30));

        Confirmar.setText("Confirmar");
        Confirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 130, 40));

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 110, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 370, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * ACCIONES AL SELECCIONAR LA TABLA
     * @param evt 
     */
    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
        confirmar=true;
    }//GEN-LAST:event_ConfirmarActionPerformed
    /**
     * ACCIONES DEL BOTON SALIR
     * @param evt 
     */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
         dispose();
        MenuSupervisor iralmenu = new MenuSupervisor(controlador);  
    }//GEN-LAST:event_btnSalirActionPerformed
    /**
     * ACCIONES DEL BOTON BORRAR
     * @param evt 
     */
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if((confirmar==true)&&(!(nombreTipoTramiteBorrar.getText().equals("")))){
            try {
                TipoTramite tipotramiteABorrar= controlador.buscarUnTipoTramite(nombre);
                if(tipotramiteABorrar!=null){
                    controlador.BorrarTipoTramite(tipotramiteABorrar);
                    JOptionPane.showMessageDialog(null,"Se borro el Tipo Tramite "+tipotramiteABorrar.getNombreTipoTramite());
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

    private void TablaTipoTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTipoTramitesMouseClicked
          int row = TablaTipoTramites.rowAtPoint(evt.getPoint());
        if(row>=0){
           
             nombre =TablaTipoTramites.getValueAt(row,0).toString();
            if(nombre.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un Tipo Tramite.");
                setVisible(true);
            }else{
                nombreTipoTramiteBorrar.setText(nombre);
            }    
        } 
        
    }//GEN-LAST:event_TablaTipoTramitesMouseClicked

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Confirmar;
    private javax.swing.JTable TablaTipoTramites;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nombreTipoTramiteBorrar;
    // End of variables declaration//GEN-END:variables
}
