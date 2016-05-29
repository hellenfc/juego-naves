/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import BattleShip.ColocandoFlota;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class Prueba {
    
    public static void main (String args []){
        ColocandoFlota cF = new ColocandoFlota();
        cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cF.setSize(500,275);
        cF.setVisible(true);
    }
}
