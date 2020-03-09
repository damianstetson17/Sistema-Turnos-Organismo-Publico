
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

public class CrearTramite extends javax.swing.JFrame {

   
    private Controlador controlador;
    private Requisito req;
    private  List <Requisito> requisitostram=new ArrayList<>();
    private  String nombretipotramite ;
    
    public CrearTramite(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        setTitle("Crear Nuevo Tramite");
        
        this.setSize(1200,1000);
        jPanel1.setSize(1200, 1000);
        setVisible(true);
        jPanel1.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);   
        jLabel3.setFont(fuente);
        jLabel4.setFont(fuente);
        jLabel5.setFont(fuente);
        ComboTipoTramite.setFont(fuente);
        nombretramite.setFont(fuente);
        TablaRequisito.setFont(fuente);  
        TablaTramitesActuales.setFont(fuente);       
        btnAceptar.setFont(fuente); 
        btnQuitar.setFont(fuente);
        btnSalir.setFont(fuente);
        btnAgregar.setFont(fuente);
        try {
            mostrarRequisitos();
            mostrarTramitesActuales();
            cargarComboTipoTramite();
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }

    /**
     * carga la tabla con todos los requisitos existentes en la BD
     * @throws NotificarError 
     */
     private void mostrarRequisitos() throws NotificarError{
        String matriz[][] = new String[controlador.buscarRequisitos().size()][1];
        List <Requisito>  requisitos= controlador.buscarRequisitos();
         
        int i = 0;
        if(!requisitos.isEmpty()){
           for (Requisito r: controlador.buscarRequisitos()) {
            matriz[i][0] = r.getNombreRequisito();
            i++;
            }
            TablaRequisito.setModel(new DefaultTableModel(
                matriz,
                 new String [] {
                "Nombre"
                }
            ));
        }else{
            TablaRequisito.setModel(new DefaultTableModel(
                null,
                new String [] {
                "Nombre"
                }
            ));
        } 
    }
    
     /**
      * carga la tabla de todos los tramites actuales existentes en la BD
      * @throws NotificarError 
      */
     private void mostrarTramitesActuales() throws NotificarError{
        String matriz[][] = new String[controlador.buscarTramites().size()][2];
        List <Tramite>  tramite= controlador.buscarTramites();
         
        int i = 0;
         if(!tramite.isEmpty()){
           
            for (Tramite t: controlador.buscarTramites()) {
                matriz[i][0] = t.getNombreTramite();
                matriz[i][1] = t.getTipoTramite().getNombreTipoTramite();
                i++;
            }
        TablaTramitesActuales.setModel(new DefaultTableModel(
                matriz,
               new String [] {
                "nombre", "TipoTramite"
            }
        ));
       }else{
           TablaTramitesActuales.setModel(new DefaultTableModel(
                null,
               new String [] {
                "nombre", "TipoTramite"
            }
        ));
       }  
    }
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
     
     /**
     * CARGA EL JTABLE CON LOS REQUISITOS AGREGADOS/QUITADOS
     * @throws NotificarError 
     */
    private void mostrarRequisitosAgregados() throws NotificarError{
        String matriz[][]= new String [requisitostram.size()][1];
        int i=0;
        for(Requisito r: requisitostram ){
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombretramite = new java.awt.TextField();
        btnAceptar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaRequisito = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaTramitesActuales = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        ComboTipoTramite = new javax.swing.JComboBox<>();
        btnQuitar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaRequisitoAsignado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Tramite:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 150, 50));
        jPanel1.add(nombretramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 210, 40));

        btnAceptar.setText("Crear");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 590, 100, 40));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 590, 90, 40));

        jLabel2.setText("seleccione los requisitos del tramite:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 300, 60));

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
        jScrollPane1.setViewportView(TablaRequisito);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 290, 220));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 120, 120, 60));

        jLabel3.setText("Tramites actuales:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 40));

        TablaTramitesActuales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "nombre", "TipoTramite"
            }
        ));
        TablaTramitesActuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTramitesActualesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaTramitesActuales);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 340, 200));

        jLabel4.setText("Tipo Tramite: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, 130, 40));

        jPanel1.add(ComboTipoTramite, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 210, 40));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        jPanel1.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 200, 120, 60));

        jLabel5.setText("Requisitos asignados:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 260, 200, 40));

        TablaRequisitoAsignado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane3.setViewportView(TablaRequisitoAsignado);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 310, 300, 160));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1240, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor iralmenu =new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String  nombre=nombretramite.getText();
        String nombretipotramite=ComboTipoTramite.getSelectedItem().toString();
        if(ComboTipoTramite.getSelectedItem().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Debe seleccionar un Tipo Tramite");       
        }else{
            if(nombre.equals("")){
                JOptionPane.showMessageDialog(null, "Debe ingresar un nombre");
                setVisible(true);
            }else{
                try {
                    Integer nro =controlador.buscarUltimoNroTramite();
                    controlador.crearUnTramite(nro, nombre,   nombretipotramite , requisitostram);
                     JOptionPane.showMessageDialog(null,"Se creo el Tramite "+nombre);  
                    dispose();
                    MenuSupervisor iralmenu = new MenuSupervisor(controlador);
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * al hacer click en agregar requisito se agrega a 
     * una lista local de requisitos vacia, al llamar a controlador
     * para crear el tramite se envia esa lista
     * @param evt 
     */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
         if(!nombretramite.getText().equals("")){
            if(!requisitostram.contains(req)){
                requisitostram.add(req);
                JOptionPane.showMessageDialog(null, "se agrego el Requisito "+ req.getNombreRequisito());  
                try {
                    mostrarRequisitosAgregados();
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"El Tramite ya posee el Requisito seleccionado.");
            }
       }else{
           JOptionPane.showMessageDialog(null,"Debe ingresar el Nuevo Nombre Tramite.");
       }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void TablaRequisitoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaRequisitoMouseClicked
       int row = TablaRequisito.rowAtPoint(evt.getPoint());
        if(row>=0){
            String nombre =TablaRequisito.getValueAt(row, 0).toString()   ;
            if(nombre.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un Requisito");
                setVisible(true);
            }else{
                try {
                    req=controlador.buscarRequisito(nombre);
                   // JOptionPane.showMessageDialog(null, req.getNombreRequisito());
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_TablaRequisitoMouseClicked

    private void TablaTramitesActualesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTramitesActualesMouseClicked
        
    }//GEN-LAST:event_TablaTramitesActualesMouseClicked

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(!nombretramite.getText().equals("")){
            if(requisitostram!=null){
                if(requisitostram.contains(req)){
                    requisitostram.remove(req);
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
        }else{
           JOptionPane.showMessageDialog(null,"Debe ingresar el Nuevo Nombre Tramite.");
       }
    }//GEN-LAST:event_btnQuitarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboTipoTramite;
    private javax.swing.JTable TablaRequisito;
    private javax.swing.JTable TablaRequisitoAsignado;
    private javax.swing.JTable TablaTramitesActuales;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.TextField nombretramite;
    // End of variables declaration//GEN-END:variables



}
