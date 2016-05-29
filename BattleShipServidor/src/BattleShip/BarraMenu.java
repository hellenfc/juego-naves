/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BattleShip;

import javax.swing.*;

/**
 *
 * @author usuario
 */
public class BarraMenu{

    JMenuBar barraMenu;
    JMenu juego, ayuda;
    JMenuItem salir, nuevo, acercaDe;

    BarraMenu(JFrame c){
         //Barra de menu
        barraMenu = new JMenuBar();
        juego = new JMenu("Juego");
        ayuda = new JMenu("Ayuda");
        salir = new JMenuItem("Salir");
        nuevo = new JMenuItem("Nuevo");
        acercaDe = new JMenuItem("Acerca De...");
        juego.add(nuevo);
        juego.add(salir);
        ayuda.add(acercaDe);
        barraMenu.add(juego);
        barraMenu.add(ayuda);

        c.setJMenuBar(barraMenu);
    }

}
