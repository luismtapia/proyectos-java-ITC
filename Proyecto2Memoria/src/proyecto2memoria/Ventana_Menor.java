package proyecto2memoria;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author luis_
 */
public class Ventana_Menor extends javax.swing.JFrame {
    ManejoDeMemoria memoria = new ManejoDeMemoria();
    ManejoDeFila fila = new ManejoDeFila();
    Object[][] datostabla;
    int contador=1;
    
    public Ventana_Menor() {
        initComponents();
        llenado();
    }

    private void llenado(){
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            setFilas(),
            getColumnas()
        ));
        jScrollPane1.setViewportView(jTable1);
    }
    
    private String[] getColumnas(){
        String columna[] = new String[]{
            "1","2","3","4","5","6","7","8","9","10",
            "11","12","13","14","15","16","17","18","19","20",
            "21","22","23","24","25","26","27","28","29","30",
            "31","32","33","34","35","36","37","38","39","40",
            "41","42","43","44","45","46","47","48","49","50"};
        return columna;
    }
    
    private Object[][] setFilas(){
        String[] vector_m = memoria.getMemoria();
        datostabla = new Object [][] {
           {vector_m[0], vector_m[1], vector_m[2], vector_m[3], vector_m[4], vector_m[5], vector_m[6], vector_m[7], vector_m[8], vector_m[9],
            vector_m[10], vector_m[11], vector_m[12], vector_m[13], vector_m[14], vector_m[15], vector_m[16], vector_m[17], vector_m[18], vector_m[19],
            vector_m[20], vector_m[21], vector_m[22], vector_m[23], vector_m[24], vector_m[25], vector_m[26], vector_m[27], vector_m[28], vector_m[29],
            vector_m[30], vector_m[31], vector_m[32], vector_m[33], vector_m[34], vector_m[35], vector_m[36], vector_m[37], vector_m[38], vector_m[39],
            vector_m[40], vector_m[41], vector_m[42], vector_m[43], vector_m[44], vector_m[45], vector_m[46], vector_m[47], vector_m[48], vector_m[49]
           }
        };
        return datostabla;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_tamaño = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 1330, 60);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MEMORIA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(570, 40, 90, 14);

        txt_tamaño.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(txt_tamaño);
        txt_tamaño.setBounds(40, 380, 150, 30);

        jLabel1.setText("INGRESE TAMAÑO: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 350, 160, 30);

        jLabel3.setText("QUE PROCESO DESEA SACAR");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(310, 350, 200, 20);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(310, 380, 160, 30);

        jButton1.setText("Entrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(70, 540, 80, 23);

        jButton2.setText("Salir de Memoria");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(310, 530, 160, 23);

        jButton3.setText("Salir de fila");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(590, 530, 130, 23);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(810, 210, 300, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int textfield = Integer.parseInt(txt_tamaño.getText());
            if(textfield > 50 || textfield <= 0){
                JOptionPane.showMessageDialog(null, "NO SE PERMITEN PROCESOS DE TAMAÑO CERO");
            }else{
                boolean memoriaOfila = memoria.dondeEstaElProceso("P"+contador, textfield);
            
                if(memoriaOfila){
                    if(fila.FilaVacia()){//EL PROCESO ESTA EN MEMORIA
                        memoria.meterAMemoriaSinFila("P"+contador, Integer.parseInt(txt_tamaño.getText()));
                        llenado();
                        jComboBox1.addItem("P"+contador);
                        contador++;
                    }else{//EL PROCESO ESTA EN FILA
                        fila.MeterAFila("P"+contador, Integer.parseInt(txt_tamaño.getText()));
                        jTextArea1.setText(fila.getFila());
                        contador++;
                    }
                }else{
                    fila.MeterAFila("P"+contador, Integer.parseInt(txt_tamaño.getText()));
                    jTextArea1.setText(fila.getFila());
                    contador++;
                }
            }
            
        } catch (NumberFormatException | HeadlessException e) {
            JOptionPane.showMessageDialog(this, "NO ES NUMERO ENTERO");
            System.err.println(e);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //obtiene de combo de item seleccionado convierte a string
        String procesoSeleccionado = String.valueOf(jComboBox1.getSelectedItem());

        if(procesoSeleccionado.equals("")){
            JOptionPane.showMessageDialog(null, "NO HAY PROCESOS EN MEMORIA");
        }else{
            memoria.salirDeMemoria(procesoSeleccionado);
            llenado();
            //ELIMINA EL A ITEM SELECCIONADO YA QUE ES EL PROCESO QUE ACABO DE SACAR
            jComboBox1.removeItem(procesoSeleccionado);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            if(fila.FilaVacia()){
                JOptionPane.showMessageDialog(null, "No hay Procesos en la Fila");
            }else{
                int tamaño = fila.regresaTamañoDeProcesoMenor();
                //JOptionPane.showMessageDialog(null, tamaño);
                if(tamaño == -1){
                    //no hay nada en inicio
                }else{
                    if(memoria.buscarEspacio(tamaño)){
                        Nodo x = fila.getNodoMenor();
                        String noProceso = x.noProceso;
                        //JOptionPane.showMessageDialog(null, noProceso);
                        memoria.meterAMemoriaSinFila(noProceso, x.tamaño);
                        jComboBox1.addItem(noProceso);
                        llenado();
                        jTextArea1.setText(fila.getFila());
                    }else
                    JOptionPane.showMessageDialog(null, "LIBERE MEMORIA");
                }
            }
        } catch (Exception ex) {
            System.err.println(""+ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Menor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Menor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Menor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Menor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ventana_Menor().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JFormattedTextField txt_tamaño;
    // End of variables declaration//GEN-END:variables
}
