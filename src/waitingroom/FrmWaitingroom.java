/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package waitingroom;

import clinic.Clinic;
import interfaces.iViews.iView;
import javax.swing.JOptionPane;
import patients.Patient;
public class FrmWaitingroom extends javax.swing.JFrame implements iView<Patient>{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmWaitingroom.class.getName());
    private Clinic clinic; 
    
    public FrmWaitingroom(Clinic clinic) {
        initComponents();
        this.clinic = clinic;
        
        Patient siguiente = clinic.getNextPatient();
        
        if (siguiente != null) {
            lblProximoPaciente.setText(siguiente.getFullName());
        }else{
            lblProximoPaciente.setText("Ninguno");            
        }
    }

    @Override
    public void clear() {
        
    }

    @Override
    public void showData(Patient data) {
        if (data == null) return;
        lblPacienteActual1.setText(data.getFullName());  
    }

    @Override
    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error",
                JOptionPane.ERROR_MESSAGE);
        
    }

    @Override
    public void showMenssage(String message) {
        JOptionPane.showMessageDialog(this,
                message); 
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSiguiente = new javax.swing.JButton();
        lblPacienteActual1 = new javax.swing.JLabel();
        lblProximoPaciente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSiguiente.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(this::btnSiguienteActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblProximoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPacienteActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSiguiente)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(447, 447, 447)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSiguiente)
                    .addComponent(lblPacienteActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProximoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(30);
        jTable1.setShowHorizontalLines(true);
        jTable1.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
    Patient actual = clinic.attendNextPatient();

    if (actual == null) {
        showError("No hay pacientes en espera");
        return;
    }
    showData(actual);
    
    Patient siguiente = clinic.getNextPatient();

    if (siguiente != null) {
        lblProximoPaciente.setText(siguiente.getFullName());
    } else {
        lblProximoPaciente.setText("Ninguno");
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmWaitingroom(new Clinic()).setVisible(true)
);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblPacienteActual1;
    private javax.swing.JLabel lblProximoPaciente;
    // End of variables declaration//GEN-END:variables
}


