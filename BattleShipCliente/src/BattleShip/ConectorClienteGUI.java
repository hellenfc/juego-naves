/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShip;

import Main.BattleShipCliente;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author usuario
 */
public class ConectorClienteGUI extends JFrame{
    
    public static JTextField ip;
    JLabel etiquetaIP;
    BarraMenu barraMenu;
    
    public ConectorClienteGUI(){
        //Propiedades de la ventana
        super("BattleShip");
        barraMenu = new BarraMenu(this);
        setResizable(false);
        setLayout(new FlowLayout());
        
        ip = new JTextField(10);
        ip.addActionListener(new manejaEventosCasillaIP());
        etiquetaIP = new JLabel("Introduzca IP");
        
        add(ip);
        add(etiquetaIP);
        
        pack();
    }
    
    private class manejaEventosCasillaIP implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BattleShipCliente.initCliente(ip.getText());
            ColocandoFlota cF = new ColocandoFlota();
            cF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cF.setSize(500,275);
            cF.setVisible(true);
        }
        
    }
    
}
