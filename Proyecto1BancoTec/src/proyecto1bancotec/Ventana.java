package proyecto1bancotec;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis_
 */
public class Ventana extends javax.swing.JFrame {
    int turno,contadordePersonas;
    String[][] datostabla = new String[100][5];
    
    Fecha fecha= new Fecha();
    Manejo_Colas cola= new Manejo_Colas();
    
    public Ventana() throws Exception {
        initComponents();
        
        String fec=fecha.ObtenerFecha();
        String hor = fecha.ObtenerHora();
        
        jlabel_fecha.setText(fec);
        jlabel_reloj.setText(hor);
        
        jTable1.setVisible(false);
        jScrollPane1.setVisible(false);
    }
    
    private void llenarTabla(){
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            datostabla,
            new String [] {
                "Cliente", "Llegada", "Ventanilla", "Salida", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
    }
    
    private void cargar_clientes() throws Exception{
        //CARGA LOS PRIMEROS 12 NODOS DE LA FILA
        String[] lugares = cola.Sillas();
        
        cliente0.setText(""+lugares[0]);
        cliente1.setText(""+lugares[1]);
        cliente2.setText(""+lugares[2]);
        cliente3.setText(""+lugares[3]);
        cliente4.setText(""+lugares[4]);
        cliente5.setText(""+lugares[5]);
        cliente6.setText(""+lugares[6]);
        cliente7.setText(""+lugares[7]);
        cliente8.setText(""+lugares[8]);
        cliente9.setText(""+lugares[9]);
        cliente10.setText(""+lugares[10]);
        cliente11.setText(""+lugares[11]);
        cliente12.setText(""+lugares[12]);
                
    }
    
    private String calculotiempo(String horallegada, String horasalida){
        int horallegada1,horasalida2,minutollegada1,minutosalida2,segundollegada1,segundosalida2;
        int segundosuno,segundosdos,totalsegundos;
        int horas=0,minutos=0,segundos=0;
        String tiempototal;
        
        //SEPARA HORAS, MINUTOS Y SEGUNDOS
        horallegada1 = Integer.parseInt(horallegada.substring(0, 2));
        horasalida2 = Integer.parseInt(horasalida.substring(0, 2));
        minutollegada1 = Integer.parseInt(horallegada.substring(3, 5));
        minutosalida2 = Integer.parseInt(horasalida.substring(3, 5));
        segundollegada1 = Integer.parseInt(horallegada.substring(6, 8));
        segundosalida2 = Integer.parseInt(horasalida.substring(6, 8));
        
        
        System.err.println("L "+horallegada1+":"+minutollegada1+":"+segundollegada1);
        System.err.println("S "+horasalida2+":"+minutosalida2+":"+segundosalida2);
        
        
        segundosuno = segundollegada1+(minutollegada1*60)+(horallegada1*3600);
        segundosdos = segundosalida2+(minutosalida2*60)+(horasalida2*3600);
        totalsegundos = segundosdos -segundosuno;
        
        while(totalsegundos > 3600){
            horas++;
            totalsegundos = totalsegundos - 3600;
        }
        while (totalsegundos > 60) {            
            minutos++;
            totalsegundos = totalsegundos - 60;
        }
        segundos = totalsegundos;
        
        System.out.println("segundosuno "+segundosuno+"\nsegundosdos "+segundosdos+"\ntotal: "+totalsegundos);
        
        
        return horas+":"+minutos+":"+segundos;
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        llegada = new javax.swing.JButton();
        salida = new javax.swing.JButton();
        detalle = new javax.swing.JButton();
        jlabel_reloj = new javax.swing.JLabel();
        jlabel_fecha = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cliente1 = new javax.swing.JButton();
        cliente2 = new javax.swing.JButton();
        cliente3 = new javax.swing.JButton();
        cliente4 = new javax.swing.JButton();
        cliente6 = new javax.swing.JButton();
        cliente0 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        cliente5 = new javax.swing.JButton();
        cliente7 = new javax.swing.JButton();
        cliente8 = new javax.swing.JButton();
        cliente9 = new javax.swing.JButton();
        cliente10 = new javax.swing.JButton();
        cliente11 = new javax.swing.JButton();
        cliente12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BANCO TEC");
        setAlwaysOnTop(true);
        getContentPane().setLayout(null);

        llegada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1bancotec/person_add.png"))); // NOI18N
        llegada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                llegadaActionPerformed(evt);
            }
        });
        getContentPane().add(llegada);
        llegada.setBounds(10, 420, 60, 60);

        salida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1bancotec/directions_run.png"))); // NOI18N
        salida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salidaActionPerformed(evt);
            }
        });
        getContentPane().add(salida);
        salida.setBounds(110, 420, 60, 60);

        detalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto1bancotec/transfer_within_a_station.png"))); // NOI18N
        detalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detalleActionPerformed(evt);
            }
        });
        getContentPane().add(detalle);
        detalle.setBounds(210, 420, 60, 60);

        jlabel_reloj.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlabel_reloj.setText("RELOJ");
        getContentPane().add(jlabel_reloj);
        jlabel_reloj.setBounds(10, 10, 60, 28);

        jlabel_fecha.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlabel_fecha.setText("FECHA");
        getContentPane().add(jlabel_fecha);
        jlabel_fecha.setBounds(570, 10, 160, 28);

        jLabel2.setBackground(new java.awt.Color(102, 204, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VENTANILLA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(209, 7, 274, 14);

        cliente1.setEnabled(false);
        getContentPane().add(cliente1);
        cliente1.setBounds(20, 150, 50, 50);

        cliente2.setEnabled(false);
        getContentPane().add(cliente2);
        cliente2.setBounds(90, 150, 50, 50);

        cliente3.setEnabled(false);
        getContentPane().add(cliente3);
        cliente3.setBounds(160, 150, 50, 50);

        cliente4.setEnabled(false);
        getContentPane().add(cliente4);
        cliente4.setBounds(230, 150, 50, 50);

        cliente6.setEnabled(false);
        getContentPane().add(cliente6);
        cliente6.setBounds(90, 230, 50, 50);

        cliente0.setEnabled(false);
        getContentPane().add(cliente0);
        cliente0.setBounds(318, 34, 50, 50);

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "null"
            }
        ));
        jTable1.setEnabled(false);
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(300, 160, 430, 320);

        cliente5.setEnabled(false);
        getContentPane().add(cliente5);
        cliente5.setBounds(20, 230, 50, 50);

        cliente7.setEnabled(false);
        getContentPane().add(cliente7);
        cliente7.setBounds(160, 230, 50, 50);

        cliente8.setEnabled(false);
        getContentPane().add(cliente8);
        cliente8.setBounds(230, 230, 50, 50);

        cliente9.setEnabled(false);
        getContentPane().add(cliente9);
        cliente9.setBounds(20, 300, 50, 50);

        cliente10.setEnabled(false);
        getContentPane().add(cliente10);
        cliente10.setBounds(90, 300, 50, 50);

        cliente11.setEnabled(false);
        getContentPane().add(cliente11);
        cliente11.setBounds(160, 300, 50, 50);

        cliente12.setEnabled(false);
        getContentPane().add(cliente12);
        cliente12.setBounds(230, 300, 50, 50);

        setSize(new java.awt.Dimension(760, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void llegadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_llegadaActionPerformed

        try {
            if(cola.VentanillaVacia()){
                cola.insertar_cola(""+turno, fecha.ObtenerHora(), fecha.ObtenerHora());
            }else{
                cola.insertar_cola(""+turno, fecha.ObtenerHora(),null);
            }
            cargar_clientes();
        } catch (Exception ex) {
            System.err.println("SUPERA LA CAPACIDAD DEL BANCO");
            System.exit(0);
        }
        turno ++;
    }//GEN-LAST:event_llegadaActionPerformed

    private void detalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detalleActionPerformed
        
        llenarTabla();
        jScrollPane1.setVisible(true);
        jTable1.setVisible(true);
        
    }//GEN-LAST:event_detalleActionPerformed

    private void salidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salidaActionPerformed
        //SALE LA PERSONA QUE ESTA EN LA VENTANILLA
        try {
            
            //OBTIENE LA HORA EN QUE SE DESOCUPA LA VENTANILLA Y SE OCUPA POR OTRO CLIENTE //SERA LA MISMA
            cola.pasaaVentanilla(fecha.ObtenerHora());
            String[] datos = cola.eliminar_cola();
            
            //PASA LOS DATOS DEL NODO A LA TABLA 
            //CONTIENE TODA LA INFORMACION DEL CLIENTE QUE SE ACABA DE IR
            datostabla[contadordePersonas][0] = datos[0];
            datostabla[contadordePersonas][1] = datos[1];
            datostabla[contadordePersonas][2] = datos[2];
            datostabla[contadordePersonas][3] = datos[3];
            
            
            //HACE LOS CALCULOS PARA DETERMINAR EL TIEMPO QUE TARDO
            
            String horallegada,horasalida;
            
            horallegada = datos[1];
            horasalida = datos[3];
            
            String tiempototal = calculotiempo(horallegada, horasalida);
            
            datostabla[contadordePersonas][4] = tiempototal;
            
            if(cola.VentanillaVacia()){
                contadordePersonas++;
                //datostabla[contadordePersonas][1] = "BANCO ESTA VACIO";
            }
            contadordePersonas++;
            cargar_clientes();
        } catch (Exception ex) {
            cliente0.setText("");
            System.err.println("NO HAY NADIE EN EL BANCO");
        }
    }//GEN-LAST:event_salidaActionPerformed

    
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ventana().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cliente0;
    private javax.swing.JButton cliente1;
    private javax.swing.JButton cliente10;
    private javax.swing.JButton cliente11;
    private javax.swing.JButton cliente12;
    private javax.swing.JButton cliente2;
    private javax.swing.JButton cliente3;
    private javax.swing.JButton cliente4;
    private javax.swing.JButton cliente5;
    private javax.swing.JButton cliente6;
    private javax.swing.JButton cliente7;
    private javax.swing.JButton cliente8;
    private javax.swing.JButton cliente9;
    private javax.swing.JButton detalle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel_fecha;
    private javax.swing.JLabel jlabel_reloj;
    private javax.swing.JButton llegada;
    private javax.swing.JButton salida;
    // End of variables declaration//GEN-END:variables
}

