/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Calculo;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AndresFWilT
 * @author Niko_Andrade
 * @author JohanM - Chetos
 */

public class Tabla1 extends javax.swing.JFrame {

    String datos[][];
    Calculo c;
    String tablainicial[][];
    int n;

    //Tabla 1; es decir, tabla ingreso de datos para calculo de ruta critica
    public Tabla1(int N) {
        this.n = N;
        initComponents();
        this.setTitle("Calculo Ruta Critica");
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bCalculo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setRowSelectionAllowed(true);
        jTable1.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "Actividad", "Precedentes", "Tiempo"
            }
        ));
        CreacionTabla();

        if (n==8){
            inputdatos();
            for (int i=0;i<n;i++) {
                for (int j=0;j<3;j++) {
                    jTable1.setValueAt(tablainicial[i][j], i, j);
                }
            }
        }
        jScrollPane1.setViewportView(jTable1);

        bCalculo.setText("Calcular");
        bCalculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCalculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(bCalculo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(bCalculo)
                .addContainerGap())
        );

        bCalculo.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Envio de datos para calculo donde se calcula la tabla 2 con su ruta critica

    private void bCalculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCalculoActionPerformed
        datos = new String[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                datos[i][j] = String.valueOf(jTable1.getValueAt(i, j));
            }
        }
        c = new Calculo(datos, n);
        dispose();
    }//GEN-LAST:event_bCalculoActionPerformed

    public void CreacionTabla() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(n);
        modelo.setColumnCount(3);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                jTable1.setModel(modelo);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCalculo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void inputdatos() {
        tablainicial = new String[n][3];
        String[] Actividades = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String[] Tiempo = {"9", "12", "3", "7", "11", "8", "14", "5"};
        String[] predecesor = {null, "A", "B", "CH", "A", null, "F", "EG"};;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    tablainicial[i][0] = Actividades[i];
                }
                if (j == 1) {
                    tablainicial[i][1] = predecesor[i];
                }
                if (j == 2) {
                    tablainicial[i][2] = Tiempo[i];
                }
            }
        }
    }

}
