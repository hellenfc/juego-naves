/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShip;

import Main.BattleShipCliente;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author usuario
 */
public class Radar extends JFrame{
    
    JPanel miFlota, flotaEnemiga;
    JPanel panel1, panel2, panel3, panel4;
    public static JTextArea chat;
    public static JTextField mensaje;
    JScrollPane sPChat;
    JLabel etiqueta1, etiqueta2;
    BarraMenu barraMenu;
    
    
    public Radar(){
        //Propiedades de la ventana
        super("BattleShip");
        setLayout(new BorderLayout());
        setResizable(false);


        barraMenu = new BarraMenu(this);
        
        
        //Etiquetas
        etiqueta1 = new JLabel("                             Mi Flota                                ");
        etiqueta2 = new JLabel("                          Flota Enemiga                                ");
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel1.add(etiqueta1);
        panel1.add(etiqueta2);
        
        //Paneles que representan el radar
        miFlota = new JPanel();
        miFlota.setLayout(new GridLayout(10,10, 5,5));
        flotaEnemiga = new JPanel();
        flotaEnemiga.setLayout(new GridLayout(10,10, 5,5));
        
        
        //Chat
        chat = new JTextArea();
        chat.setEditable(false);
        sPChat = new JScrollPane(chat);
        sPChat.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mensaje = new JTextField();
        mensaje.addActionListener(new manejaEventosMensaje());
        panel3 = new JPanel(new BorderLayout());
        panel3.add(sPChat, "Center");
        panel3.add(mensaje, "South");

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2,5,5));
        panel2.add(miFlota);
        panel2.add(flotaEnemiga);
        
        panel4 = new JPanel(new GridLayout(2,1,5,5));
        panel4.add(panel2);
        panel4.add(panel3);
        
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                
                JButton botonA = new JButton();
                miFlota.add(botonA);
                JToggleButton botonB = new JToggleButton();
                flotaEnemiga.add(botonB);
                
                if(ColocandoFlota.manejaPosicionesFlota[i][j] == 1){
                    botonA.setBackground(Color.red);
                }else{
                    botonA.setBackground(Color.black);
                }
            }
        }
        
        
        //Agregando los componentes creados
        add(panel1, "North");
        add(panel4, "Center");
        
        pack();
    }
    
    private class manejaEventosMensaje implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            BattleShipCliente.cliente.enviarMSG(mensaje.getText());
        }
        
    }
    
}
