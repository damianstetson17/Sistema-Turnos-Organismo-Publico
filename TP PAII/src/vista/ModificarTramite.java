
package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Requisito;
import modelo.TipoTramite;
import modelo.Tramite;

public class ModificarTramite extends javax.swing.JFrame {

    
    private Controlador controlador;
    private List<Tramite> tramites=new ArrayList<>();
    private Tramite tram=null;
    private Requisito req;
    private List<Requisito> requisitos=new ArrayList<>();
    private String nombretramite,nuevonombre, nombretipotramite;
    
    public ModificarTramite(Controlador control) {
        initComponents();
        this.controlador=control;
        setTitle("Actualizar Tramite");
       //this.setSize(1500, 1000);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        setSize(1200, 950);
       
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel3.setFont(fuente);       
        jLabel4.setFont(fuente);        
        nombtramite .setFont(fuente);       
        ComboTipoTramite .setFont(fuente);       
        btnQuitar .setFont(fuente);       
        btnAceptar.setFont(fuente);
        btnSalir.setFont(fuente);       
        TablaTramites.setFont(fuente);
        TablaRequisito.setFont(fuente);
        TablaRequisitoAsignado  .setFont(fuente);
        jLabel5.setFont(fuente);
        jButton1.setFont(fuente); 
        try { 
            mostrarTramites();
            mostrarRequisitos();
            cargarComboTipoTramite();
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
        tramites= controlador.buscarTramites();
         
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
    
    /**
      * carga la tabla de todos los requisitos De Un Tramite existentes en la BD
      * @throws NotificarError 
      */ 
    private void mostrarRequisitos() throws NotificarError{
        String matriz[][]= new String [controlador.buscarRequisitos().size()][1];
        
        int i=0;
        for(Requisito r: controlador.buscarRequisitos()){
            matriz[i][0]=r.getNombreRequisito();
            i++;
        }
         TablaRequisito.setModel(new DefaultTableModel(
            matriz,
            new String [] {
                "Nombre"
            }
        ));
    }
     /**
     * CARGA EL JTABLE CON LOS REQUISITOS AGREGADOS/QUITADOS
     * @throws NotificarError 
     */
    private void mostrarRequisitosAgregados() throws NotificarError{
        String matriz[][]= new String [requisitos.size()][1];
        int i=0;
        for(Requisito r: requisitos ){
            matriz[i][0]=r.getNombreRequisito();
            i++;
        } 
         TablaRequisitoAsignado.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                "Nombre"
            }
        ));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTramites = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaRequisito = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nombtramite = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ComboTipoTramite = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaRequisitoAsignado = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccione el nombre del Tramite a modificar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 430, 60));

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, 300));

        TablaRequisito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        TablaRequisito.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaRequisitoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaRequisito);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 240, 320));

        jLabel2.setText("Nuevo Nombre:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 130, 40));

        jLabel3.setText("Tipo Tramite:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 140, 40));

        nombtramite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombtramiteActionPerformed(evt);
            }
        });
        getContentPane().add(nombtramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 200, 40));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 120, 60));

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 120, 50));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 530, 100, 50));

        jLabel4.setText("Requisitos activos");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 210, 40));

        getContentPane().add(ComboTipoTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 200, 40));

        jLabel5.setText("Requisitos asignados:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 240, 40));

        TablaRequisitoAsignado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane3.setViewportView(TablaRequisitoAsignado);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 310, 200));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 120, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaTramitesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTramitesMouseClicked
        int row = TablaTramites.rowAtPoint(evt.getPoint());
        if(row>=0){
            nombretramite =TablaTramites.getValueAt(row, 0).toString()   ;
            if(nombretramite.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un tramite");
                setVisible(true);
            }else{
                try {
                    tram=controlador.buscarUntramite(nombretramite);
                    requisitos.addAll(tram.getRequisitosObligatorios());
                    mostrarRequisitosAgregados();
                    nombtramite.setText(nombretramite);
                    mostrarRequisitos();
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    
                }
                
            }
        }    
    }//GEN-LAST:event_TablaTramitesMouseClicked

    /**
      * cargar el combo con todos los tipos tramites existentes en la BD
      */
     private void cargarComboTipoTramite () {
            try{
                for(TipoTramite tt: controlador.buscarTipoTramites()){
                    ComboTipoTramite.addItem(tt.getNombreTipoTramite());  
                }
            } catch (NotificarError ex) {
             JOptionPane.showMessageDialog(null,ex.getMessage());
        }     
    }
    
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if(nombtramite.getText().equals("") || ComboTipoTramite.getSelectedItem().equals("")){
             JOptionPane.showMessageDialog(null, "debe completar todos los campos");
              setVisible(true);
        }else{
            nuevonombre=nombtramite.getText();
            nombretipotramite= ComboTipoTramite.getSelectedItem().toString();
            try {
                 controlador.actualizarTramite(nombretramite, nuevonombre, nombretipotramite, requisitos);
                 JOptionPane.showMessageDialog(null, "se modifico el tramite" + nombretramite);
                 dispose();
                 MenuSupervisor iralmenusupervisor = new MenuSupervisor(controlador);
            }catch (NotificarError ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                } 
        } 
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu = new MenuSupervisor(controlador); 
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
      if(requisitos!=null){
                if(requisitos.contains(req)){
                    requisitos.remove(req);
                    JOptionPane.showMessageDialog(null, "se quitó el Requisito "+ req.getNombreRequisito());   
                    try {
                        mostrarRequisitosAgregados();
                    } catch (NotificarError ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                     JOptionPane.showMessageDialog(null,"El Tramite no posee el Requisito a quitar");
                }
            }else{
                JOptionPane.showMessageDialog(null,"El Tramite no posee Requisitos");
            }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void TablaRequisitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaRequisitoMouseClicked
        int row = TablaRequisito.rowAtPoint(evt.getPoint());
        if(row>=0){
            String nombrerequisito =TablaRequisito.getValueAt(row, 0).toString()   ;
            if(nombrerequisito.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un Requisito.");
                setVisible(true);
            }else{
                try {
                    req=controlador.buscarRequisito(nombrerequisito);
                } catch (NotificarError ex) {
                  JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }  
    }//GEN-LAST:event_TablaRequisitoMouseClicked

    private void nombtramiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombtramiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombtramiteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!requisitos.contains(req)){
                requisitos.add(req);
                JOptionPane.showMessageDialog(null, "se agrego el Requisito "+ req.getNombreRequisito());  
                try {
                    mostrarRequisitosAgregados();
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"El Tramite ya posee el Requisito seleccionado.");
            }      
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTipoTramite;
    private javax.swing.JTable TablaRequisito;
    private javax.swing.JTable TablaRequisitoAsignado;
    private javax.swing.JTable TablaTramites;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombtramite;
    // End of variables declaration//GEN-END:variables
}
