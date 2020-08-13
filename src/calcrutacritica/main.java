/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcrutacritica;

import Interfaz.NumeroActividades;

/**
 *
 * @author AndresFWilT
 * @author Niko_Andrade
 * @author JohanM - Chetos
 */
public class main {

    /**
     * @param args the command line arguments
     */
    
    //Inicio del programa, abre ventana Numero de Actividades
    
    public static void main(String[] args) {
        
        NumeroActividades iniciar = new NumeroActividades();
        iniciar.setVisible(true);
        iniciar.setResizable(false);
        
        
    }
    
}
