/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import BattleShip.ConectorCliente;
import BattleShip.ConectorClienteGUI;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class BattleShipCliente {
    
    public static ConectorCliente cliente;
    
    public static void main (String args[]){
        ConectorClienteGUI cF = new ConectorClienteGUI();
        cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cF.setSize(250,100);
        cF.setVisible(true);
    }
    
    public static void initCliente(String ip){
        cliente = new ConectorCliente(ip);
        cliente.start();
    }
}
