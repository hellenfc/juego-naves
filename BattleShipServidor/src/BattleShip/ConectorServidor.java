/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BattleShip;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author usuario
 */
public class ConectorServidor extends Thread {
    
    private Socket s;
    private ServerSocket ss;
    private InputStreamReader entradaSocket;
    private DataOutputStream salida;
    private BufferedReader entrada;
    final int puerto = 9000;
    
    public ConectorServidor(){
        try{
            this.ss = new ServerSocket(this.puerto);
            this.s = this.ss.accept();
            
            //Creacion de entrada de datos para lectura de mensajes
            this.entradaSocket = new InputStreamReader(this.s.getInputStream());
            this.entrada = new BufferedReader(this.entradaSocket);
            
            //Creacion de salida de datos para el envio de mensajes
            this.salida = new DataOutputStream(s.getOutputStream());
            
        }catch(IOException e){
        
        }
    }
    
    public void enviarMSG(String msg){
        try{
            this.salida.writeUTF(msg + "\n");
        }catch(IOException e){};
    }
    
    public void run(){
        String text = "";            
            while(true){
                try{
                    text = this.entrada.readLine();
                    Radar.chat.setText(Radar.chat.getText() + "\n" + text);
                }catch(IOException e){
        
                }
            }
    }
    
    public void desconectar(){
        try{
            ss.close();
        }catch (Exception e){
            
        }
    }
}