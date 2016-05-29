/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import BattleShip.ConectorServidor;
import BattleShip.ConectorServidorGUI;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class BattleShipServidor {
    public static ConectorServidor servidor;
    
    public static void main (String args[]){
        ConectorServidorGUI cF = new ConectorServidorGUI();
        cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cF.setSize(250,100);
        cF.setVisible(true);
    }
    
    public static void initServidor(){
        servidor = new ConectorServidor();
        servidor.start();
    }
}
