/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

/**
 *
 * @author AndresFWilT
 * @author Niko_Andrade
 * @author JohanM - Chetos
 */
public class Grafico extends javax.swing.JFrame {

    int contadores[];
    int n;
    int nivelJerarqu[];
    int nivelFila[];
    int tempNivel;
    String[][] Matriz; //Matriz con todos los datos de tabla 2

    //Ventana donde se hace el grafo
    public Grafico(String[][] Datos, int N) {
        contadores = new int[8];
        nivelFila = new int[N];
        nivelJerarqu = new int[N];
        for (int i = 0; i < 8; i++) {
            contadores[i] = 0;
        }
        this.setTitle("Grafo Calculo Ruta Critica");
        this.setResizable(false);
        this.setLocationRelativeTo(this);
        this.n = N;
        Matriz = new String[n][9];
        Matriz = Datos;
        int temporal;
        int temporal2;
        for (int i = 0; i < n; i++) {
            temporal = 0;
            temporal2 = 0;
            if (Matriz[i][1] == "null") {
                nivelJerarqu[i] = 0;
            } else {
                for (int j = 0; j < Matriz[i][1].length(); j++) {
                    temporal2 = hallarNivel(Matriz[i][1].charAt(j)) + 1;
                    if (temporal2 > temporal) {
                        temporal = temporal2;
                    }
                }
                nivelJerarqu[i] = temporal;
            }
            System.out.println(nivelJerarqu[i]);
        }
        initComponents();
        this.setLocation(15, 15);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        //Por si se repinta
        for (int i = 0; i < 8; i++) {
            contadores[i] = 0;
        }
        //Dibujar circulitos
        for (int i = 0; i < n; i++) {
            g2d.setColor(Color.blue);
            g2d.drawOval((200 * nivelJerarqu[i]) + 30, (200 * contadores[nivelJerarqu[i]]) + 80, 80, 80);
            g2d.fillOval((200 * nivelJerarqu[i]) + 30 + 25, (200 * contadores[nivelJerarqu[i]]) + 80 + 25, 30, 30);
            g2d.drawLine((200 * nivelJerarqu[i]) + 30 + 40, (200 * contadores[nivelJerarqu[i]]) + 80, (200 * nivelJerarqu[i]) + 30 + 40, (200 * contadores[nivelJerarqu[i]]) + 80 + 25);
            g2d.drawLine((200 * nivelJerarqu[i]) + 30 + 40, (200 * contadores[nivelJerarqu[i]]) + 80 + 25 + 30, (200 * nivelJerarqu[i]) + 30 + 40, (200 * contadores[nivelJerarqu[i]]) + 80 + 25 + 30 + 25);
            g2d.drawLine((200 * nivelJerarqu[i]) + 30, (200 * contadores[nivelJerarqu[i]]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 + 25, (200 * contadores[nivelJerarqu[i]]) + 80 + 40);
            g2d.drawLine((200 * nivelJerarqu[i]) + 30 + 25 + 30, (200 * contadores[nivelJerarqu[i]]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 + 25 + 30 + 25, (200 * contadores[nivelJerarqu[i]]) + 80 + 40);
            //Dibujo Texto
            g2d.setColor(Color.white);
            g2d.drawString(Matriz[i][0], (200 * nivelJerarqu[i]) + 30 + 37, (200 * contadores[nivelJerarqu[i]]) + 80 + 45);
            g2d.setColor(Color.blue);
            g2d.drawString(Matriz[i][3], (200 * nivelJerarqu[i]) + 30 + 10, (200 * contadores[nivelJerarqu[i]]) + 80 + 25);
            g2d.drawString(Matriz[i][5], (200 * nivelJerarqu[i]) + 30 + 10, (200 * contadores[nivelJerarqu[i]]) + 80 + 40 + 25);
            g2d.drawString(Matriz[i][4], (200 * nivelJerarqu[i]) + 30 + 40 + 10, (200 * contadores[nivelJerarqu[i]]) + 80 + 25);
            g2d.drawString(Matriz[i][6], (200 * nivelJerarqu[i]) + 30 + 40 + 10, (200 * contadores[nivelJerarqu[i]]) + 80 + 40 + 25);
            nivelFila[i] = contadores[nivelJerarqu[i]];
            contadores[nivelJerarqu[i]]++;
        }
        //Dibujar relaciones / Flechas
        for (int i = 0; i < n; i++) {
            if (!"null".equals(Matriz[i][1])) {
                for (int j = 0; j < Matriz[i][1].length(); j++) {
                    if ((nivelJerarqu[i] - nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))] > 1) || (nivelJerarqu[i] - nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))] < -1)) {
                        g2d.drawLine((200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40, (200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5 + 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80);
                        g2d.drawLine((200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5 + 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80, (200 * nivelJerarqu[i]) + 30 - 5 - 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80);
                        g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5 - 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80, (200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40);
                        g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 30);
                        g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 50);
                        if (("True".equals(Matriz[i][8])) & ("True".equals(Matriz[hallarFilaDeActividad(Matriz[i][1].charAt(j))][8]))) {
                            g2d.setColor(Color.RED);
                            g2d.drawLine((200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40, (200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5 + 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80);
                            g2d.drawLine((200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5 + 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80, (200 * nivelJerarqu[i]) + 30 - 5 - 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80);
                            g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5 - 80, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40 + 80, (200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40);
                            g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 30);
                            g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 50);
                            g2d.setColor(Color.BLUE);
                        }
                    } else {
                        g2d.drawLine((200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40);
                        g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 30);
                        g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 50);
                        if (("True".equals(Matriz[i][8])) & ("True".equals(Matriz[hallarFilaDeActividad(Matriz[i][1].charAt(j))][8]))) {
                            g2d.setColor(Color.RED);
                            g2d.drawLine((200 * (nivelJerarqu[hallarFilaDeActividad(Matriz[i][1].charAt(j))])) + 30 + 25 + 30 + 25 + 5, (200 * nivelFila[hallarFilaDeActividad(Matriz[i][1].charAt(j))]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40);
                            g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 30);
                            g2d.drawLine((200 * nivelJerarqu[i]) + 30 - 5, (200 * nivelFila[i]) + 80 + 40, (200 * nivelJerarqu[i]) + 30 - 15, (200 * nivelFila[i]) + 80 + 50);
                            g2d.setColor(Color.BLUE);
                        }
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1250, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int hallarNivel(char Actividad) {
        int temporal;
        int temporal2;
        for (int i = 0; i < n; i++) {
            temporal = 0;
            temporal2 = 0;
            if (Matriz[i][0].equals(String.valueOf(Actividad))) {
                if (Matriz[i][1] == "null") {
                    return 0;
                } else {
                    for (int j = 0; j < Matriz[i][1].length(); j++) {
                        temporal2 = hallarNivel(Matriz[i][1].charAt(j)) + 1;
                        if (temporal2 > temporal) {
                            temporal = temporal2;
                        }
                    }
                    return temporal;
                }
            }
        }
        return 0;
    }

    private int hallarFilaDeActividad(char Actividad) {
        for (int i = 0; i < n; i++) {
            if (Matriz[i][0].equals(String.valueOf(Actividad))) {
                return i;
            }
        }
        return 0;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
