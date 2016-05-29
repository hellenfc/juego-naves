/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import BattleShip.ConectorClienteGUI;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class Prueba3 {
    public static void main (String args []){
        ConectorClienteGUI cF = new ConectorClienteGUI();
        cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cF.setSize(250,100);
        cF.setVisible(true);
    }
}
