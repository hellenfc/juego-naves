/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package BattleShip;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


/**
 *
 * @author usuario
 */
public class ColocandoFlota extends JFrame{
    
    //0 Componente no utilizada
    //1 Componente Utilizada(Indica las posiciones de los barcos)
    //2 Opciones primer nivel
    //3 Opciones segundo nivel
    //4 Opciones tercer nivel
    static int[][] manejaPosicionesFlota= new int[10][10];
    private JButton[][] flota = new JButton[10][10];
    private int manejaBarcosColocados[]= new int[5];
    int sumaBarco1 = 0;
    int sumaBarco2 = 0;
    int sumaBarco3 = 0;
    int sumaBarco4 = 0;
    int sumaBarco5 = 0;
    int x,y; 
    int xAnt;
    int yAnt;
    BarraMenu barraMenu;
    JLabel etiqueta1, etiqueta2;
    JLabel etiquetaBarco1, etiquetaBarco2, etiquetaBarco3, etiquetaBarco4, etiquetaBarco5;
    JPanel panel1, panel2;
    JPanel miFlota, acciones;
    JTabbedPane barcos;
    JButton aceptar;
    JRadioButton barco1, barco2, barco3, barco4, barco5;
    ButtonGroup grupoOpcionesBarco;

    public ColocandoFlota(){

        super("BattleShip");
        barraMenu = new BarraMenu(this);
        setResizable(false);

        //Etiquetas Titulos
        etiqueta1 = new JLabel("Mi Flota                         ");
        etiqueta2 = new JLabel("                                 Colocar Barco");
        panel1 = new JPanel(new GridLayout(1,2,5,5));
        panel1.setLayout(new FlowLayout());
        panel1.add(etiqueta1);
        panel1.add(etiqueta2);

        //Paneles para colocar mi flota
        miFlota = new JPanel();
        miFlota.setPreferredSize(new Dimension (230,230));
        miFlota.setLayout(new GridLayout(10,10, 5,5));
        
        //Imagenes
        Icon iBarco5 = new ImageIcon(getClass().getResource("Barco5.jpg"));
        /*Icon iBarco4 = new ImageIcon(getClass().getResource("Barco4.jpg"));
        Icon iBarco3 = new ImageIcon(getClass().getResource("Barco3.jpg"));
        Icon iBarco2 = new ImageIcon(getClass().getResource("Barco2.jpg"));
        Icon iBarco1 = new ImageIcon(getClass().getResource("Barco1.jpg"));*/
        
        //Etiquetas Barcos (Imagenes)
        etiquetaBarco1 = new JLabel(iBarco5);
        etiquetaBarco2 = new JLabel(iBarco5);
        etiquetaBarco3 = new JLabel(iBarco5);
        etiquetaBarco4 = new JLabel(iBarco5);
        etiquetaBarco5 = new JLabel(iBarco5);
        
        //Radio Botones acciones
        barco1 = new JRadioButton("Barco 1");
        barco2 = new JRadioButton("Barco 2");
        barco3 = new JRadioButton("Barco 3");
        barco4 = new JRadioButton("Barco 4");
        barco5 = new JRadioButton("Barco 5");
        aceptar = new JButton("Iniciar Juego");
        
        //Crea una relacion logica entre los JRadioButtons
        grupoOpcionesBarco = new ButtonGroup();
        grupoOpcionesBarco.add(barco1);
        grupoOpcionesBarco.add(barco2);
        grupoOpcionesBarco.add(barco3);
        grupoOpcionesBarco.add(barco4);
        grupoOpcionesBarco.add(barco5);
        
        
        //Eventos 
        aceptar.addMouseListener(new ManejadorBotonComenzarJuego());
        
        //Agregando Botones acciones
        acciones = new JPanel();
        acciones.setPreferredSize(new Dimension (230,230));
        acciones.setLayout(new GridLayout(6,2,5,5));
        acciones.add(barco1);
        acciones.add(etiquetaBarco1);
        acciones.add(barco2);
        acciones.add(etiquetaBarco2);
        acciones.add(barco3);
        acciones.add(etiquetaBarco3);
        acciones.add(barco4);
        acciones.add(etiquetaBarco4);
        acciones.add(barco5);
        acciones.add(etiquetaBarco5);
        acciones.add(aceptar);

        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1,2,5,5));
        panel2.add(miFlota);
        panel2.add(acciones);
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                JButton botonA = new JButton();
                botonA.setBackground(Color.BLACK);
                miFlota.add(botonA);
                flota[i][j] = botonA;
                botonA.addMouseListener(new ManejadorBotonesFlota());
            }
        }
        //Agregando los componentes creados
        add(panel1, "North");
        add(panel2, "Center");
        pack();
    }// Fin Constructor ColocandoFlota
    
    private class ManejadorBotonesFlota extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent e){
            x=ColocandoFlota.obtenerCoordenadaX(e);
            y=ColocandoFlota.obtenerCoordenadaY(e);
            
            //Barco de tamaño 2
            if(barco1.isSelected()){ // Primer if
                if(manejaBarcosColocados[0]==0 && sumaBarco1 <2){ // Segundo if
                    if(sumaBarco1==0){ // Tercer if
                        if(manejaPosicionesFlota[y][x] != 1){ // Cuarto if
                            
                            ColocandoFlota.colocaPrimeraCoordenada(x, y, e, flota, manejaPosicionesFlota);
                            manejaPosicionesFlota[y][x] = 1;
                            
                        }else{// else cuarto if
                            JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                            sumaBarco1 -= 1;
                        }
                        
                    }else { //else tercer if
                          if(sumaBarco1 == 1){
                              if(manejaPosicionesFlota[y][x] == 2){
                                  e.getComponent().setBackground(Color.red);
                                  manejaPosicionesFlota[y][x] = 1;
                              }else{
                                  JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                  sumaBarco1 -= 1;
                              }
                          }
                    }
                    sumaBarco1 += 1;    
                    if(sumaBarco1 == 2){
                        manejaBarcosColocados[0]= 1;
                        for(int i=0; i<10; i++){
                            for(int j=0; j<10; j++){
                                if(manejaPosicionesFlota[i][j] == 2){
                                    manejaPosicionesFlota[i][j]=0;
                                    flota[i][j].setBackground(Color.BLACK);
                                    
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Barco colocado con exito ", "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    }
                    
                }else{ // else segundo if
                    JOptionPane.showMessageDialog(null,"Este barco ya fue colocado ", "Error" , JOptionPane.ERROR_MESSAGE);
                }
            }
            
            
            // Barco de tamaño 3
            if(barco2.isSelected()){ // Primer if
               if(manejaBarcosColocados[1]==0  && sumaBarco2 <3){ // Segundo if
                    if(sumaBarco2==0){ // Tercer if
                        if(manejaPosicionesFlota[y][x] != 1){ // Cuarto if
                            
                            ColocandoFlota.colocaPrimeraCoordenada(x, y, e, flota, manejaPosicionesFlota);
                            manejaPosicionesFlota[y][x] = 1;
                            xAnt = x;
                            yAnt = y;
                            
                        }else{// else cuarto if
                            JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                            sumaBarco2 -= 1;
                        }
                    }else{ //else tercer if
                        if(sumaBarco2 == 1){
                            if(manejaPosicionesFlota[y][x] == 2){
                                
                                manejaPosicionesFlota[y][x] = 1;
                                ColocandoFlota.colocaSegundaCoordenada(xAnt, yAnt, x, y, e, flota, manejaPosicionesFlota);
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                sumaBarco2 -= 1;
                            }
                        }else{
                            if(sumaBarco2 == 2){
                                if(manejaPosicionesFlota[y][x] == 3){
                                    e.getComponent().setBackground(Color.red);
                                    manejaPosicionesFlota[y][x] = 1;
                                }else{
                                    JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                    sumaBarco2 -= 1;
                                }
                            }
                        }
                    }
                    
                    sumaBarco2 += 1;    
                    if(sumaBarco2 == 3){
                        manejaBarcosColocados[1]= 1;
                        for(int i=0; i<10; i++){
                            for(int j=0; j<10; j++){
                                if(manejaPosicionesFlota[i][j] == 3){
                                    manejaPosicionesFlota[i][j]=0;
                                    flota[i][j].setBackground(Color.BLACK);
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Barco colocado con exito ", "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    }
                        
               }else{ // else segundo if
                    JOptionPane.showMessageDialog(null,"Este barco ya fue colocado ", "Error" , JOptionPane.ERROR_MESSAGE);
               }
            }
            
            
            // Barco de tamaño 3
            if(barco3.isSelected()){
                if(manejaBarcosColocados[2]==0  && sumaBarco3 <3){ // Segundo if
                    if(sumaBarco3==0){ // Tercer if
                        if(manejaPosicionesFlota[y][x] != 1){ // Cuarto if
                            
                            ColocandoFlota.colocaPrimeraCoordenada(x, y, e, flota, manejaPosicionesFlota);
                            manejaPosicionesFlota[y][x] = 1;
                            xAnt = x;
                            yAnt = y;
                            
                        }else{// else cuarto if
                            JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                            sumaBarco3 -= 1;
                        }
                    }else{ //else tercer if
                        if(sumaBarco3 == 1){
                            if(manejaPosicionesFlota[y][x] == 2){
                                
                                manejaPosicionesFlota[y][x] = 1;
                                ColocandoFlota.colocaSegundaCoordenada(xAnt, yAnt, x, y, e, flota, manejaPosicionesFlota);
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                sumaBarco3 -= 1;
                            }
                        }else{
                            if(sumaBarco3 == 2){
                                if(manejaPosicionesFlota[y][x] == 3){
                                    e.getComponent().setBackground(Color.red);
                                    manejaPosicionesFlota[y][x] = 1;
                                }else{
                                    JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                    sumaBarco3 -= 1;
                                }
                            }
                        }
                    }
                    
                    sumaBarco3 += 1;    
                    if(sumaBarco3 == 3){
                        manejaBarcosColocados[2]= 1;
                        for(int i=0; i<10; i++){
                            for(int j=0; j<10; j++){
                                if(manejaPosicionesFlota[i][j] == 3){
                                    manejaPosicionesFlota[i][j]=0;
                                    flota[i][j].setBackground(Color.BLACK);
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Barco colocado con exito ", "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    }
                        
               }else{ // else segundo if
                    JOptionPane.showMessageDialog(null,"Este barco ya fue colocado ", "Error" , JOptionPane.ERROR_MESSAGE);
               }
            }
            
            
            // Barco de tamaño 4
            if(barco4.isSelected()){
                if(manejaBarcosColocados[3]==0  && sumaBarco2 <4){ // Segundo if
                    if(sumaBarco4==0){ // Tercer if
                        if(manejaPosicionesFlota[y][x] != 1){ // Cuarto if
                            
                            ColocandoFlota.colocaPrimeraCoordenada(x, y, e, flota, manejaPosicionesFlota);
                            manejaPosicionesFlota[y][x] = 1;
                            xAnt = x;
                            yAnt = y;
                            
                        }else{// else cuarto if
                            JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                            sumaBarco4 -= 1;
                        }
                    }else{ //else tercer if
                        if(sumaBarco4 == 1){
                            if(manejaPosicionesFlota[y][x] == 2){
                                
                                manejaPosicionesFlota[y][x] = 1;
                                ColocandoFlota.colocaSegundaCoordenada(xAnt, yAnt, x, y, e, flota, manejaPosicionesFlota);
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                sumaBarco4 -= 1;
                            }
                        }else{
                            if(sumaBarco4 == 2){
                                if(manejaPosicionesFlota[y][x] == 3){
                                    
                                    manejaPosicionesFlota[y][x] = 1;
                                    ColocandoFlota.colocaTerceraCuartaCoordenada(x, y, e, flota, manejaPosicionesFlota);
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                    sumaBarco4 -= 1;
                                }
                            }else{
                                if(sumaBarco4 == 3){
                                    if(manejaPosicionesFlota[y][x] == 4 || manejaPosicionesFlota[y][x] == 3){
                                        e.getComponent().setBackground(Color.red);
                                        manejaPosicionesFlota[y][x] = 1;
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                        sumaBarco4 -= 1;
                                    }
                                }
                            }
                        }
                    }
                    
                    sumaBarco4 += 1;    
                    if(sumaBarco4 == 4){
                        manejaBarcosColocados[3] = 1;
                        for(int i=0; i<10; i++){
                            for(int j=0; j<10; j++){
                                if(manejaPosicionesFlota[i][j] == 4 || manejaPosicionesFlota[i][j] == 3){
                                    manejaPosicionesFlota[i][j]=0;
                                    flota[i][j].setBackground(Color.BLACK);
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Barco colocado con exito ", "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    }
                        
               }else{ // else segundo if
                    JOptionPane.showMessageDialog(null,"Este barco ya fue colocado ", "Error" , JOptionPane.ERROR_MESSAGE);
               }
                
            }
            
            // Barco de tamaño 5
            if(barco5.isSelected()){
                if(manejaBarcosColocados[4]==0  && sumaBarco5 <5){ // Segundo if
                    if(sumaBarco5==0){ // Tercer if
                        if(manejaPosicionesFlota[y][x] != 1){ // Cuarto if
                            
                            ColocandoFlota.colocaPrimeraCoordenada(x, y, e, flota, manejaPosicionesFlota);
                            manejaPosicionesFlota[y][x] = 1;
                            xAnt = x;
                            yAnt = y;
                            
                        }else{// else cuarto if
                            JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                            sumaBarco5 -= 1;
                        }
                    }else{ //else tercer if
                        if(sumaBarco5 == 1){
                            if(manejaPosicionesFlota[y][x] == 2){
                                
                                manejaPosicionesFlota[y][x] = 1;
                                ColocandoFlota.colocaSegundaCoordenada(xAnt, yAnt, x, y, e, flota, manejaPosicionesFlota);
                                
                            }else{
                                JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                sumaBarco5 -= 1;
                            }
                        }else{
                            if(sumaBarco5 == 2){
                                if(manejaPosicionesFlota[y][x] == 3){
                                    
                                    manejaPosicionesFlota[y][x] = 1;
                                    ColocandoFlota.colocaTerceraCuartaCoordenada(x, y, e, flota, manejaPosicionesFlota);
                                    
                                }else{
                                    JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                    sumaBarco5 -= 1;
                                }
                            }else{
                                if(sumaBarco5 == 3){
                                    if(manejaPosicionesFlota[y][x] == 4 || manejaPosicionesFlota[y][x] == 3){
                                        ColocandoFlota.colocaTerceraCuartaCoordenada(x, y, e, flota, manejaPosicionesFlota);
                                        manejaPosicionesFlota[y][x] = 1;
                                    }else{
                                        JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                        sumaBarco5 -= 1;
                                    }
                                }else{
                                    if(sumaBarco5 == 4){
                                        if(manejaPosicionesFlota[y][x] == 4 || manejaPosicionesFlota[y][x] == 3){
                                            e.getComponent().setBackground(Color.red);
                                            manejaPosicionesFlota[y][x] = 1;
                                        }else{
                                            JOptionPane.showMessageDialog(null,"Posicion no valida ", "Error" , JOptionPane.ERROR_MESSAGE);
                                            sumaBarco5 -= 1;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    
                    sumaBarco5 += 1;    
                    if(sumaBarco5 == 5){
                        manejaBarcosColocados[4] = 1;
                        for(int i=0; i<10; i++){
                            for(int j=0; j<10; j++){
                                if(manejaPosicionesFlota[i][j] == 4 || manejaPosicionesFlota[i][j] == 3){
                                    manejaPosicionesFlota[i][j]=0;
                                    flota[i][j].setBackground(Color.BLACK);
                                }
                            }
                        }
                        JOptionPane.showMessageDialog(null,"Barco colocado con exito ", "Exito" , JOptionPane.INFORMATION_MESSAGE);
                    }
                        
               }else{ // else segundo if
                    JOptionPane.showMessageDialog(null,"Este barco ya fue colocado ", "Error" , JOptionPane.ERROR_MESSAGE);
               }
            }
        }
        
    }//Fin de la clase interna ManejadorBotonesFlota;
    
    private class ManejadorBotonComenzarJuego extends MouseAdapter {
        
        int sumaArreglo;
        public void mouseReleased(MouseEvent e){
            for(int i=0; i<5; i++){
                sumaArreglo += manejaBarcosColocados[i];
            }
            
            if(sumaArreglo == 5){
                //Empieza el juego
                Radar radar = new Radar();
                radar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                radar.setSize(500,500);
                radar.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Faltan barcos por colocar", "Error", JOptionPane.ERROR_MESSAGE);
            } 
        }
    }// Fin de la clase interna ManejadorBotonComenzarJuego
    
    static int obtenerCoordenadaX(MouseEvent e){
        int x=0;
        switch(e.getComponent().getX()){
                case 0:{
                    x=0;
                    break;
                }
                case 24:{
                    x=1;
                    break;
                }
                case 48:{
                    x=2;
                    break;
                }
                case 72:{
                    x=3;
                    break;
                }
                case 96:{
                    x=4;
                    break;
                }
                case 120:{
                    x=5;
                    break;
                }
                case 144:{
                    x=6;
                    break;
                }
                case 168:{
                    x=7;
                    break;
                }
                case 192:{
                    x=8;
                    break;
                }
                case 216:{
                    x=9;
                } 
        }
        return x;
    }//Fin metodo estatico obtenerComponenteX 
    
    static int obtenerCoordenadaY(MouseEvent e){
        int y=0;
        switch(e.getComponent().getY()){
                case 0:{
                    y=0;
                    break;
                }
                case 20:{
                    y=1;
                    break;
                }
                case 40:{
                    y=2;
                    break;
                }
                case 60:{
                    y=3;
                    break;
                }
                case 80:{
                    y=4;
                    break;
                }
                case 100:{
                    y=5;
                    break;
                }
                case 120:{
                    y=6;
                    break;
                }
                case 140:{
                    y=7;
                    break;
                }
                case 160:{
                    y=8;
                    break;
                }
                case 180:{
                    y=9;
                }
        }
        return y;
    }//Fin metodo estatico obtenerComponenteY
    
    static void colocaPrimeraCoordenada(int x, int y, MouseEvent e, JButton[][] flota, int[][] manejaPosicionesFlota){
        
        e.getComponent().setBackground(Color.red);
         
        if(x==0 && y == 0){
            flota[y+1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y+1][x] = 2;
            flota[y][x+1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x+1] = 2;
        }
        
        if(x==0 && y == 9){
            flota[y-1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y-1][x] = 2;
            flota[y][x+1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x+1] = 2;
        }
                            
        if(x==9 && y == 0){
            flota[y][x-1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x-1] = 2;
            flota[y+1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y+1][x] = 2;
        }
        
        if(x==9 && y == 9){
            flota[y][x-1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x-1] = 2;
            flota[y-1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y-1][x] = 2;
        }
        
        if(x==0 && ((y != 0) && (y != 9) )){
            flota[y][x+1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x+1] = 2;
            flota[y+1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y+1][x] = 2;
            flota[y-1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y-1][x] = 2;
        }
        
        if(x==9 && ((y != 0) && (y != 9) )){
            flota[y][x-1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x-1] = 2;
            flota[y+1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y+1][x] = 2;
            flota[y-1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y-1][x] = 2;
        }
        
        if(y==0 && ((x != 0) && (x != 9) )){
            flota[y][x+1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x+1] = 2;
            flota[y][x-1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x-1] = 2;
            flota[y+1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y+1][x] = 2;
        }   
        
        if(y==9 && ((x != 0) && (x != 9) )){
            flota[y][x+1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x+1] = 2;
            flota[y][x-1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x-1] = 2;
            flota[y-1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y-1][x] = 2;
        }
        
        if(x!=0 && y !=0 && x !=9 && y !=9){
            flota[y][x+1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x+1] = 2;
            flota[y][x-1].setBackground(Color.gray);
            manejaPosicionesFlota[y][x-1] = 2;
            flota[y+1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y+1][x] = 2;
            flota[y-1][x].setBackground(Color.gray);
            manejaPosicionesFlota[y-1][x] = 2;
        }
    }// Fin del metodo colocaPrimeraCoordenada
    
    
    static void colocaSegundaCoordenada(int xAnt, int yAnt, int x, int y, MouseEvent e, JButton[][] flota, int[][] manejaPosicionesFlota){
        
        e.getComponent().setBackground(Color.red);
        
        //Horizontales
        if((xAnt-x) != 0){
            if(xAnt == 0 || x==0){
                flota[y][2].setBackground(Color.gray);
                manejaPosicionesFlota[y][2] = 3;
            }else{
                if(xAnt == 9 || x == 9){
                    flota[y][7].setBackground(Color.gray);
                    manejaPosicionesFlota[y][7] = 3;
                }else{
                    if(xAnt < x){
                        flota[y][x-2].setBackground(Color.gray);
                        manejaPosicionesFlota[y][x-2] = 3;
                        flota[y][x+1].setBackground(Color.gray);
                        manejaPosicionesFlota[y][x+1] = 3;
                    }else{
                        flota[y][x+2].setBackground(Color.gray);
                        manejaPosicionesFlota[y][x+2] = 3;
                        flota[y][x-1].setBackground(Color.gray);
                        manejaPosicionesFlota[y][x-1] = 3;
                    }
                }
            }
        }
        
        //Verticales
        if((yAnt - y) != 0){
            if(yAnt == 0 || y==0){
                flota[2][x].setBackground(Color.gray);
                manejaPosicionesFlota[2][x] = 3;
            }else{
                if(yAnt == 9 || y == 9){
                    flota[7][x].setBackground(Color.gray);
                    manejaPosicionesFlota[7][x] = 3;
                }else{
                    if(yAnt < y){
                        flota[y-2][x].setBackground(Color.gray);
                        manejaPosicionesFlota[y-2][x] = 3;
                        flota[y+1][x].setBackground(Color.gray);
                        manejaPosicionesFlota[y+1][x] = 3;
                    }else{
                        flota[y+2][x].setBackground(Color.gray);
                        manejaPosicionesFlota[y+2][x] = 3;
                        flota[y-1][x].setBackground(Color.gray);
                        manejaPosicionesFlota[y-1][x] = 3;
                    }
                }
            }
        }
       
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                if(manejaPosicionesFlota[i][j] == 2){
                    manejaPosicionesFlota[i][j]=0;
                    flota[i][j].setBackground(Color.BLACK);
                }
            }
        }
    }// Fin del metodo colocaSegundaCoordenada
    
    static void colocaTerceraCuartaCoordenada(int x, int y, MouseEvent e, JButton[][] flota, int[][] manejaPosicionesFlota){
        
        e.getComponent().setBackground(Color.red);
        
        if(x != 0 && x != 9){
            if(manejaPosicionesFlota[y][x-1] == 1){
                flota[y][x+1].setBackground(Color.gray);
                manejaPosicionesFlota[y][x+1] = 4;
            }
            if(manejaPosicionesFlota[y][x+1] == 1){
                flota[y][x-1].setBackground(Color.gray);
                manejaPosicionesFlota[y][x-1] = 4;
            }
        }
        
        if(y != 0 && y != 9){
            if(manejaPosicionesFlota[y-1][x] == 1){
                flota[y+1][x].setBackground(Color.gray);
                manejaPosicionesFlota[y+1][x] = 4;
            }
            if(manejaPosicionesFlota[y+1][x] == 1){
                flota[y-1][x].setBackground(Color.gray);
                manejaPosicionesFlota[y-1][x] = 4;
            }
        }        
    }//Fin del metodo colocaTerceraCoordenada
    
    
}//Fin de la clase ColocandoFlota