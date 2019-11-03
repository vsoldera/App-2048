/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;


public class Main extends Jogo{
    /* funcao para inciar o jogo e deixar ele tôp*/
     
        
    public static void main(String[] args) {
        /* tabuleiro speccs*/
        Jogo jogo = new Jogo();
            
//        Servidor servidor = new Servidor(8080);
        
        jogo.displayMenu();
      
        WebClient cliente = new WebClient("http://localhost:3000/postInfo", "http://localhost:3000/getPos", jogo); 
        //servidor.getMsg(jogo);
        try {
            cliente.controleGeral();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
    

   
 
   
      
          




