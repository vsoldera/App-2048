/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author luizviniciusruoso
 */
public class Servidor extends Jogo{
    int port;
    ServerSocket Servidor;
    public Servidor(int port){
        this.port = port;
    }
    
    public void initServer(){
        
        try {
            Servidor = new ServerSocket(this.port);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void getMsg(Jogo jogo){
         Scanner s = null;
         String aux = null;
          String aux1 = null;
         JSONObject jsonObject;
         try {
            ServerSocket Servidor = new ServerSocket(80);
            
            while(true){
               //System.out.println(1);
                Socket C = Servidor.accept();
                s = new Scanner(C.getInputStream());
                aux = s.nextLine();
                //System.out.println(s.nextLine());
                 //System.out.println(s.nextLine());
                jsonObject = new JSONObject(aux);
                System.out.println(jsonObject.get("posicao"));
                aux1 = (String) jsonObject.get("posicao");
               
                if(aux1.equals("up")) jogo.toUp();
                if(aux1.equals("down")) jogo.toDown();
                if(aux1.equals("left")) jogo.toLeft();
                if(aux1.equals("right")) jogo.toRight();
                
                aux1 = null;
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
         
    }
    
}
