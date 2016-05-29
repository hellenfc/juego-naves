/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import BattleShip.Radar;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Prueba2 {
    public static void main (String args []){
        Radar cF = new Radar();
        cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cF.setSize(500,500);
        cF.setVisible(true);
    }
}
