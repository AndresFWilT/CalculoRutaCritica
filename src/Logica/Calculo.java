/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Interfaz.Tabla2;
import java.lang.reflect.Array;

/**
 *
 * @author AndresFWilT
 * @author Niko_Andrade
 * @author JohanM - Chetos
 */
public class Calculo {
    
    Tabla2 v;
    String[] Actividad;
    String[] Precedentes;
    int[] Tiempo;
    String[][] Tabla;
    String[][] Matriz;
    int tiempo;
    int n;
    
    //Clase que calculo la tabla 2; es decir, la ruta critica con su Holgura etc...
    
    
    public Calculo(String table1[][],int N) {
        this.n=N;
        Tabla = new String[n][9];
        this.Tabla = table1;
        Pasodatos();

    }

    private void Pasodatos() {

        Matriz = new String[n][9];

        Actividad = new String[n];
        Precedentes = new String[n];
        Tiempo = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                switch (j) {
                    case 0: {
                        Actividad[i] = Tabla[i][0];
                        Matriz[i][0] = Tabla[i][0];
                    }
                    break;
                    case 1: {
                        Precedentes[i] = Tabla[i][1];
                        Matriz[i][1] = Tabla[i][1];

                    }
                    break;
                    case 2: {
                        if (Tabla[i][2] == "null" || Tabla[i][2] == null) {
                            Tabla[i][2] = "0";
                        }
                        Tiempo[i] = Integer.parseInt(Tabla[i][2]);
                        Matriz[i][2] = Tabla[i][2];
                    }
                    break;
                }
            }
        }

       
        Gestion();
    }

    private void Gestion() {
        
         AnalisisPrc();
        
        for (int i = 0; i < n; i++) {
            if (Matriz[i][1] != null) {
                int p = (Matriz[i][1]).length();
                int mayor = 0;
                for (int t = 0; t < p; t++) {
                    String act = Matriz[i][1];
                    char pr = act.charAt(t);
                    for (int j = 0; j < n; j++) {
                        if (Character.toString(pr).equals(Matriz[j][0])) {
                            if (Matriz[j][4] == null) {
                                determinar(j);
                            }
                            if (Integer.parseInt(Matriz[j][4]) > mayor) {
                                mayor = Integer.parseInt(Matriz[j][4]);
                            }
                        }

                    }
                }
                Matriz[i][3] = String.valueOf(mayor);
                Matriz[i][4] = String.valueOf(Integer.parseInt(Matriz[i][3]) + Integer.parseInt(Matriz[i][2]));
            }

        }

        tiempo = 0;

        for (int i = 0; i < n; i++) {
            if (Integer.parseInt(Matriz[i][4]) > tiempo) {
                tiempo = Integer.parseInt(Matriz[i][4]);
            }
        }

        for (int i = n - 1; i > -1; i--) {
            for (int r = 0; r < n; r++) {
                int p = (Matriz[r][1]).length();
                for (int t = 0; t < p; t++) {
                    String act = Matriz[r][1];
                    char pr = act.charAt(t);
                    if (Character.toString(pr).equals(Matriz[i][0])) {
                        
                        if (Matriz[i][6] == null) {
                            Matriz[i][6] = String.valueOf(tiempo);
                        }
                        if (Matriz[r][5] == null) {
                            der(r);
                        }
                        if (Integer.parseInt(Matriz[r][5]) < Integer.parseInt(Matriz[i][6])) {
                            Matriz[i][6] = Matriz[r][5];
                        }
                    }

                }
            }
            
            if (Matriz[i][6] != null) {
                Matriz[i][5] = String.valueOf(Integer.parseInt(Matriz[i][6]) - Integer.parseInt(Matriz[i][2]));
            } else if (Matriz[i][6] == null) {
                Matriz[i][6] = String.valueOf(tiempo);
                
                Matriz[i][5] = String.valueOf(Integer.parseInt(Matriz[i][6]) - Integer.parseInt(Matriz[i][2]));
            }
        }

        for (int i = 0; i < n; i++) {
            int aux;
            Matriz[i][7] = String.valueOf(Integer.parseInt(Matriz[i][6]) - Integer.parseInt(Matriz[i][4]));
            if (Integer.parseInt(Matriz[i][7]) == 0) {
                Matriz[i][8] = "True";
            } else {
                Matriz[i][8] = "False";
            }
        }
        
        
       v = new Tabla2(Matriz,n);
    }

    private void Impresion() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(Matriz[i][j]);
            }
        }
    }

    private void AnalisisPrc() {
        for (int i = 0; i < n; i++) {
            if (Matriz[i][1] == null) {
                Matriz[i][3] = "0";
                Matriz[i][4] = Matriz[i][2];
            }
        }
    }

    private void determinar(int j) {
        char pr;
        String act;
        if (!Matriz[j][1].equals(null) && Matriz[j][1]!= null) {
            int p = (Matriz[j][1]).length();
            int mayor = 0;
            for (int t = 0; t < p; t++) {
                act = Matriz[j][1];
                pr = act.charAt(t);
                for (int o = 0;o<n;o++) {
                    if (Character.toString(pr).equals(Matriz[o][0])) {
                        if (null == Matriz[o][4]) {
                            determinar(o);
                        }
                        if (Integer.parseInt(Matriz[o][4]) > mayor) {
                            mayor = Integer.parseInt(Matriz[o][4]);
                        }
                    }
                }
            }
            Matriz[j][3] = String.valueOf(mayor);
            Matriz[j][4] = String.valueOf(Integer.parseInt(Matriz[j][3]) + Integer.parseInt(Matriz[j][2]));
        }
    }

    private void der(int i) {
        for (int r = 0; r < n; r++) {
            int p = (Matriz[r][1]).length();
            for (int t = 0; t < p; t++) {
                String act = Matriz[r][1];
                char pr = act.charAt(t);
                if (Character.toString(pr).equals(Matriz[i][0])) {
                    if (Matriz[i][6] == null) {
                        Matriz[i][6] = String.valueOf(tiempo);
                    }
                    if (Matriz[r][5] == null) {
                        der(r);
                    }
                    if (Integer.parseInt(Matriz[r][5]) < Integer.parseInt(Matriz[i][6])) {
                        Matriz[i][6] = Matriz[r][5];
                    }
                }
            }
        }
        if (Matriz[i][6] != null) {
            Matriz[i][5] = String.valueOf(Integer.parseInt(Matriz[i][6]) - Integer.parseInt(Matriz[i][2]));
        } else if (Matriz[i][6] == null) {
            Matriz[i][6] = String.valueOf(tiempo);
            Matriz[i][5] = String.valueOf(Integer.parseInt(Matriz[i][6]) - Integer.parseInt(Matriz[i][2]));
        }
    }

}
