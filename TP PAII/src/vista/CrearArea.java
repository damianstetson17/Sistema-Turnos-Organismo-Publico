
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
import modelo.Area;
import modelo.TipoTramite;

public class CrearArea extends javax.swing.JFrame {
    private Controlador controlador;
    private List<TipoTramite> tipostramites= new ArrayList<>();
    private  TipoTramite tram= new TipoTramite();
    private String nombreArea;
    
    public CrearArea( Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        
        setTitle("Crear Area");
        setVisible(true);
        this.setSize(1000, 900);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel4.setFont(fuente);
        nombreNuevaArea.setFont(fuente);
        jLabel3.setFont(fuente);
        TablaNombreTramite.setFont(fuente);
        TablaNombreAreasActuales.setFont(fuente);
        btnAgregar.setFont(fuente); 
        btnQuitar.setFont(fuente); 
        btnCrearArea.setFont(fuente);       
        btnSalir.setFont(fuente);       
                
        try {
            mostrarNombresTramites();
            mostrarNombreAreas();
        } catch (NotificarError ex) {
          JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        
    }
    /**
     * CARGA EL JTABLE CON LOS NOMBRES DE TODAS LAS AREAS EXISTENTES DE LA BD
     * @throws NotificarError 
     */
     private void mostrarNombreAreas() throws NotificarError{
        String matriz[][]= new String [controlador.buscarAreas().size()][1];
        int i=0;
        for(Area a:controlador.buscarAreas() ){
            matriz[i][0]=a.getNombreArea();
            i++;
        } 
         TablaNombreAreasActuales.setModel(new DefaultTableModel(
            matriz,
               new String [] {
                "Nombre"
            }
        ));
    }
      /**
       * CARGA EL JTABLE CON LOS NOMBRES DE TODOS LOS TIPOS TRAMITES DE LA BD
       * @throws NotificarError 
       */
     private void mostrarNombresTramites() throws NotificarError{
        String matriz[][]= new String [controlador.buscarTipoTramites().size()][1];
        int i=0;
        for(TipoTramite tt: controlador.buscarTipoTramites() ){
            matriz[i][0]=tt.getNombreTipoTramite();
            i++;
        } 
         TablaNombreTramite.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                "Nombre Tipo Tramite"
            }
        ));
    }
    /**
     * CARGA EL JTABLE CON LOS TIPOS TRAMITES AGREGADOS/QUITADOS
     * @throws NotificarError 
     */
    private void mostrarTiposTramitesAgregados() throws NotificarError{
        String matriz[][]= new String [tipostramites.size()][1];
        int i=0;
        for(TipoTramite tt: tipostramites ){
            matriz[i][0]=tt.getNombreTipoTramite();
            i++;
        } 
         TablaTipoTramiteAgregado.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                "Nombre"
            }
        ));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCrearArea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreNuevaArea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaNombreTramite = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnCrearArea = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaNombreAreasActuales = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaTipoTramiteAgregado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCrearArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Nueva Area:");
        PanelCrearArea.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 40));

        nombreNuevaArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreNuevaAreaActionPerformed(evt);
            }
        });
        PanelCrearArea.add(nombreNuevaArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 200, 40));

        TablaNombreTramite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nombre Tipo Tramite"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaNombreTramite.setColumnSelectionAllowed(true);
        TablaNombreTramite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaNombreTramiteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaNombreTramite);
        TablaNombreTramite.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        PanelCrearArea.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 270, 230));

        jLabel3.setText("Seleccione los Tipos de tramites asociados:");
        PanelCrearArea.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 370, 60));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelCrearArea.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 650, 90, 40));

        btnCrearArea.setText("Crear");
        btnCrearArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAreaActionPerformed(evt);
            }
        });
        PanelCrearArea.add(btnCrearArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 650, 110, 40));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        PanelCrearArea.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 140, 60));

        TablaNombreAreasActuales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane2.setViewportView(TablaNombreAreasActuales);

        PanelCrearArea.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, 290, 200));

        jLabel2.setText("Areas actuales: ");
        PanelCrearArea.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 140, 50));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        PanelCrearArea.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 140, 60));

        jLabel4.setText("TiposTramites agregados:");
        PanelCrearArea.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 220, 40));

        TablaTipoTramiteAgregado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane3.setViewportView(TablaTipoTramiteAgregado);

        PanelCrearArea.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 290, 230));

        getContentPane().add(PanelCrearArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreNuevaAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreNuevaAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreNuevaAreaActionPerformed
/**
 * ACCIONES DEL BOTON SALIR
 * @param evt 
 */
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
        MenuSupervisor irAlMenu = new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirActionPerformed
    /**
     * ACCIONES DEL BOTON CREAR
     * @param evt 
     */
    private void btnCrearAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAreaActionPerformed
        try {
             nombreArea= nombreNuevaArea.getText();
            if(nombreArea.equals("")){
                JOptionPane.showMessageDialog(null,"Debe cargar el nombre del Area.");
                setVisible(true);
            }
            if(tipostramites.isEmpty()){
                JOptionPane.showMessageDialog(null,"Debe cargar tipos tramites al Area.");
                setVisible(true);
            }
            if(nombreArea!="" && !tipostramites.isEmpty()){
                controlador.crearUnArea(nombreArea, tipostramites);
                JOptionPane.showMessageDialog(null,"Se creo el area: "+nombreArea);
                dispose();
                MenuSupervisor irAlMenu = new MenuSupervisor(controlador);
            }
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            setVisible(true);
        }
    }//GEN-LAST:event_btnCrearAreaActionPerformed
    /**
     * ACCIONES AL PRESIONAR EL NOMBRE TIPOTRAMITE
     * @param evt 
     */
    private void TablaNombreTramiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaNombreTramiteMouseClicked
        int row = TablaNombreTramite.getSelectedRow();
        String nombre=((String) TablaNombreTramite.getValueAt(row, 0)) ;
        try {
            tram=controlador.buscarUnTipoTramite(nombre);
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            setVisible(true);
        }  
    }//GEN-LAST:event_TablaNombreTramiteMouseClicked
/**
 * ACCIONES DEL BOTON AGREGAR TIPOTRAMITE
 * @param evt 
 */
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       if(!nombreNuevaArea.getText().equals("")){
            if(!tipostramites.contains(tram)){
                tipostramites.add(tram);
                JOptionPane.showMessageDialog(null, "se agrego el tipo tramite "+ tram.getNombreTipoTramite());  
                try {
                    mostrarTiposTramitesAgregados();
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"El area ya posee el Tipo Tramite seleccionado.");
            }
       }else{
           JOptionPane.showMessageDialog(null,"Debe ingresar el Nuevo Nombre Area.");
       }
           
    }//GEN-LAST:event_btnAgregarActionPerformed
/**
 * ACCIONES DEL BOTON QUITAR TIPO TRAMITE
 * @param evt 
 */
    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        if(!nombreNuevaArea.getText().equals("")){
            if(tipostramites!=null){
                if(tipostramites.contains(tram)){
                    tipostramites.remove(tram);
                    JOptionPane.showMessageDialog(null, "se quitó el tipo tramite "+ tram.getNombreTipoTramite());   
                    try {
                        mostrarTiposTramitesAgregados();
                    } catch (NotificarError ex) {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{
                     JOptionPane.showMessageDialog(null,"El area no posee el Tipo Tramite a quitar");
                }
            }else{
                JOptionPane.showMessageDialog(null,"El area no posee Tipos Tramite");
            }
        }else{
           JOptionPane.showMessageDialog(null,"Debe ingresar el Nuevo Nombre Area.");
       }
    }//GEN-LAST:event_btnQuitarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelCrearArea;
    private javax.swing.JTable TablaNombreAreasActuales;
    private javax.swing.JTable TablaNombreTramite;
    private javax.swing.JTable TablaTipoTramiteAgregado;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCrearArea;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombreNuevaArea;
    // End of variables declaration//GEN-END:variables



}
