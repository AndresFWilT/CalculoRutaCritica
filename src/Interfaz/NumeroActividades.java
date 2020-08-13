/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author AndresFWilT
 * @author Niko_Andrade
 * @author JohanM - Chetos
 */
public class NumeroActividades extends javax.swing.JFrame {

    String Tf;
    int n;
    char validar;
    
    //Ventana donde se ingresa el numero de actividades, luego abre ventana Tabla1
    
    public NumeroActividades() {
        this.setTitle("Calculo Ruta Critica");
        initComponents();
        this.setLocationRelativeTo(this);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        BIngresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFActionPerformed(evt);
            }
        });
        TextF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextFKeyTyped(evt);
            }
        });

        jLabel1.setText("Ingrese el numero de actividades de su proyecto:");

        BIngresar.setText("Ingresar");
        BIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(TextF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(BIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(TextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BIngresar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextFActionPerformed

    private void BIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BIngresarActionPerformed
        Tf = String.valueOf(TextF.getText());
        n = Integer.parseInt(Tf);
        Tabla1 iniciar = new Tabla1(n);
        iniciar.setVisible(true);
        iniciar.setResizable(false);
        dispose();
    }//GEN-LAST:event_BIngresarActionPerformed

    private void TextFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextFKeyTyped
       validar = evt.getKeyChar();
                if (Character.isLetter(validar)) {
                    getToolkit().beep();
                    evt.consume();
                    JOptionPane.showMessageDialog(getContentPane(), "Solo ingrese numeros", "Error", JOptionPane.ERROR_MESSAGE);
                }
    }//GEN-LAST:event_TextFKeyTyped

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BIngresar;
    private javax.swing.JTextField TextF;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
