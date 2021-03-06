package vista;

import controlador.Controlador;
import errores.NotificarError;
import java.awt.Font;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Area;
import modelo.TipoTramite;
import modelo.Tramite;

public class ModificarArea extends javax.swing.JFrame {

    private Controlador controlador;
    private String nombre, nuevonombre;
    private List<TipoTramite> tramites = null;
    private TipoTramite tram = null;
    String nombreTipoTramite ;

    public ModificarArea(Controlador controlador) {
       initComponents();
        this.controlador = controlador;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setVisible(true);
        
        Font fuente= new Font("Dialog",15,18);
        setFont(fuente);
        setTitle("Actualizar Area");
        PanelInicioModificarArea.setSize(1500, 1000);
        PanelModificarArea.setSize(1500, 1000);
        PanelInicioModificarArea.setVisible(true);
        PanelModificarArea.setVisible(false);
        jLabel1.setFont(fuente);
        jLabel2.setFont(fuente);
        jLabel6.setFont(fuente);
        TablatipostramitesAsignados.setFont(fuente);
        jButton1  .setFont(fuente);  
        jLabel3.setFont(fuente);
        jLabel4.setFont(fuente);
        jLabel5.setFont(fuente);
        LabelNombreActualArea.setFont(fuente);
        btnAceptar.setFont(fuente);
        TablaAreasActuales.setFont(fuente);
        TablaNombresTipoTramitesActivos.setFont(fuente);
        TablatipostramitesAsignados.setFont(fuente);
        btnSalirAMenu.setFont(fuente);      
        btnQuitar.setFont(fuente);        
        btnActualizarArea.setFont(fuente);
        btnSalir.setFont(fuente);        
        nombreAreaamodificar.setFont(fuente); 
        NuevoNombre.setFont(fuente); 
        
        try {
           mostrarAreasActuales();
        } catch (NotificarError ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void mostrarAreasActuales() throws NotificarError{
        String matriz[][] = new String[controlador.buscarAreas().size()][1];
        List <Area> areas= controlador.buscarAreas();
        int i = 0;
        if(!areas.isEmpty()){
           
            for (Area a: controlador.buscarAreas()) {
            matriz[i][0] = a.getNombreArea();
            i++;
        }
        TablaAreasActuales.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Nombre"
            }
        ));
       }else{
           TablaAreasActuales.setModel(new DefaultTableModel(
                null,
                new String[]{
                    "Nombre"
                }
        ));
       }   
    }
    
    private void  mostrarNombresTramites(String nombre)throws NotificarError
    {
        String matriz[][] = new String[controlador.buscarTipoTramiteArea(nombre).size()][1];
        tramites= controlador.buscarTipoTramiteArea(nombre);
        int i = 0;
        if(!tramites.isEmpty()){
           
            for (TipoTramite t: tramites) {
            matriz[i][0] = t.getNombreTipoTramite();
            i++;
        }
        TablaNombresTipoTramitesActivos.setModel(new DefaultTableModel(
                matriz,
                new String [] {
                "Nombre"
            }
        ));
       }else{
           TablaNombresTipoTramitesActivos.setModel(new DefaultTableModel(
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

        PanelInicioModificarArea = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        nombreAreaamodificar = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnSalirAMenu = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaAreasActuales = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        PanelModificarArea = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnQuitar = new javax.swing.JButton();
        LabelNombreActualArea = new javax.swing.JLabel();
        NuevoNombre = new javax.swing.JTextField();
        btnActualizarArea = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaNombresTipoTramitesActivos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablatipostramitesAsignados = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelInicioModificarArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Areas Actuales:");
        PanelInicioModificarArea.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 150, 50));
        PanelInicioModificarArea.add(nombreAreaamodificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 190, 40));

        btnAceptar.setText("Modificar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        PanelInicioModificarArea.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 550, 110, 40));

        btnSalirAMenu.setText("Salir");
        btnSalirAMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirAMenuActionPerformed(evt);
            }
        });
        PanelInicioModificarArea.add(btnSalirAMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 90, 40));

        TablaAreasActuales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        TablaAreasActuales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaAreasActualesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaAreasActuales);

        PanelInicioModificarArea.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 270, 320));

        jLabel5.setText("Area a modificar: ");
        PanelInicioModificarArea.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 150, 50));

        getContentPane().add(PanelInicioModificarArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 710));

        PanelModificarArea.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre Actual: ");
        PanelModificarArea.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 160, 50));

        jLabel2.setText("Nuevo Nombre: ");
        PanelModificarArea.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 170, 50));

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        PanelModificarArea.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 580, 100, 50));

        jLabel4.setText("Tipos Tramites activos: ");
        PanelModificarArea.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 230, 60));

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });
        PanelModificarArea.add(btnQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 110, 50));
        PanelModificarArea.add(LabelNombreActualArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 180, 50));

        NuevoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoNombreActionPerformed(evt);
            }
        });
        PanelModificarArea.add(NuevoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, 190, 40));

        btnActualizarArea.setText("Actualizar");
        btnActualizarArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarAreaActionPerformed(evt);
            }
        });
        PanelModificarArea.add(btnActualizarArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 580, 120, 50));

        TablaNombresTipoTramitesActivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nombre"
            }
        ));
        TablaNombresTipoTramitesActivos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaNombresTipoTramitesActivosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaNombresTipoTramitesActivos);

        PanelModificarArea.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 260, 240));

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelModificarArea.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 110, 50));

        TablatipostramitesAsignados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre"
            }
        ));
        jScrollPane1.setViewportView(TablatipostramitesAsignados);

        PanelModificarArea.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 220, 250));

        jLabel6.setText("Tipos Tramites asignados:");
        PanelModificarArea.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 250, 40));

        getContentPane().add(PanelModificarArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        /*
            Al seleccionar aceptar se carga y controla el nombre del area ingresado, si este no
            esta cargado, se lanza un mensaje para que ingrese el nombre, un vez ingresado
            se busca el nombre en persistencia, si existe el area, se visualiza el jpanel 
            modificar area, donde se muestra el nombre actual y el supervisor puede cambiar el
            nombre, quitar un tramite de esa area o agregar
            finalmente se invoca al constructor enviandole el nombre del area antiguo, el nombreactualizado
            y la lista de tramites actualizadas.
        */
            setVisible(true);
            PanelInicioModificarArea.setVisible(false);
            PanelModificarArea.setVisible(true);
            try {
                    Area area =controlador.buscarUnArea(nombre);
                    if(area!=null){
                        PanelModificarArea.setSize(1500, 1000);
                        setVisible(true);
                        PanelInicioModificarArea.setVisible(false);
                        PanelModificarArea.setVisible(true);
                        LabelNombreActualArea.setText(nombre);
                         NuevoNombre.setText(nombre);
                         mostrarNombresTramites(nombre);
                        mostrarTiposTramitesAgregados();
                    
                    }else{
                        JOptionPane.showMessageDialog(null, "No se encontro el area seleccionada.");
                        setVisible(true);
                        PanelInicioModificarArea.setVisible(true);
                        PanelModificarArea.setVisible(true);
                    }
              } catch (NotificarError ex) {
                     JOptionPane.showMessageDialog(null,ex.getMessage());
            }
    }//GEN-LAST:event_btnAceptarActionPerformed

    /**
     * CARGA EL JTABLE CON LOS TIPOS TRAMITES AGREGADOS/QUITADOS
     * @throws NotificarError 
     */
    private void mostrarTiposTramitesAgregados() throws NotificarError{
        String matriz[][]= new String [tramites.size()][1];
        int i=0;
        for(TipoTramite tt: tramites ){
            matriz[i][0]=tt.getNombreTipoTramite();
            i++;
        } 
         TablatipostramitesAsignados.setModel(new DefaultTableModel(
            matriz,
             new String [] {
                "Nombre"
            }
        ));
    }
    
    
    private void btnActualizarAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarAreaActionPerformed
        nuevonombre = NuevoNombre.getText();
        try {
             if(nuevonombre.equals("")){
                    String mensaje = String.format("Debe ingresar un nuevo nombre del area valido.");
			throw new NotificarError(mensaje);
                }
            controlador.actualizaUnArea(nombre,nuevonombre, tramites);
            JOptionPane.showMessageDialog(null, "Se modifico el area: " + nombre);
            dispose();
            MenuSupervisor irAlMenu = new MenuSupervisor(controlador);
        } catch (NotificarError ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
                ex.printStackTrace();
        }
    }//GEN-LAST:event_btnActualizarAreaActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
       if(tramites!=null){
                if(tramites.contains(tram)){
                    tramites.remove(tram);
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
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void NuevoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoNombreActionPerformed
  
    }//GEN-LAST:event_NuevoNombreActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(true);
        PanelInicioModificarArea.setVisible(true);
        PanelModificarArea.setVisible(false);        
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSalirAMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirAMenuActionPerformed
        dispose();
        MenuSupervisor iralmenu = new MenuSupervisor(controlador);
    }//GEN-LAST:event_btnSalirAMenuActionPerformed

    private void TablaAreasActualesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaAreasActualesMouseClicked
        int row = TablaAreasActuales.rowAtPoint(evt.getPoint());
        if(row>=0){
            nombre =TablaAreasActuales.getValueAt(row, 0).toString()   ;
            if(nombre.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un Area");
                setVisible(true);
                PanelInicioModificarArea.setVisible(true);
                PanelModificarArea.setVisible(false);  
            }else{
                nombreAreaamodificar.setText(nombre);
            }
        } 
    }//GEN-LAST:event_TablaAreasActualesMouseClicked

    private void TablaNombresTipoTramitesActivosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaNombresTipoTramitesActivosMouseClicked
        
        int row = TablaNombresTipoTramitesActivos.rowAtPoint(evt.getPoint());
        if(row>=0){
             nombreTipoTramite =TablaNombresTipoTramitesActivos.getValueAt(row, 0).toString()   ;
            if(nombreTipoTramite.equals("")){
                JOptionPane.showMessageDialog(null, "Debe seleccionar el nombre de un TipoTramite");
                setVisible(true);
                PanelInicioModificarArea.setVisible(true);
                PanelModificarArea.setVisible(false);  
                 
            }else{
                try {
                    tram=controlador.buscarUnTipoTramite(nombreTipoTramite);
                    try {
                        mostrarTiposTramitesAgregados();
                    } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                 }
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_TablaNombresTipoTramitesActivosMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!tramites.contains(tram)){
                tramites.add(tram);
                JOptionPane.showMessageDialog(null, "se agrego el tipo tramite "+ tram.getNombreTipoTramite());  
                try {
                    mostrarTiposTramitesAgregados();
                } catch (NotificarError ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }else{
                JOptionPane.showMessageDialog(null,"El area ya posee el Tipo Tramite seleccionado.");
            }
      
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNombreActualArea;
    private javax.swing.JTextField NuevoNombre;
    private javax.swing.JPanel PanelInicioModificarArea;
    private javax.swing.JPanel PanelModificarArea;
    private javax.swing.JTable TablaAreasActuales;
    private javax.swing.JTable TablaNombresTipoTramitesActivos;
    private javax.swing.JTable TablatipostramitesAsignados;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnActualizarArea;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalirAMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField nombreAreaamodificar;
    // End of variables declaration//GEN-END:variables


    
}
