/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShip;

import Main.BattleShipServidor;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author usuario
 */
public class ConectorServidorGUI extends JFrame {
    
    JButton conectar;
    BarraMenu barraMenu;
    
    public ConectorServidorGUI(){
        //Propiedades de la ventana
        super("BattleShip");
        barraMenu = new BarraMenu(this);
        setResizable(false);
        setLayout(new FlowLayout());
        
        conectar = new JButton("Conectar Servidor");
        conectar.addMouseListener(new manejaEventosBoton());
        
        add(conectar);
        
        pack();
    }
    
    private class manejaEventosBoton extends MouseAdapter{
        
        public void mouseReleased(MouseEvent e){
            BattleShipServidor.initServidor();
            ColocandoFlota cF = new ColocandoFlota();
            cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cF.setSize(500,275);
            cF.setVisible(true);
        }
        
    }
    
}
