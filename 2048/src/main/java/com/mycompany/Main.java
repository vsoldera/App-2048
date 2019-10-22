/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;
import org.json.JSONObject;
import com.sun.corba.se.spi.activation.Server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main extends Jogo{
    /* funcao para inciar o jogo e deixar ele tôp*/
     
        
    public static void main(String[] args) {
        /* tabuleiro speccs*/
        Jogo jogo = new Jogo();
        Servidor servidor = new Servidor(8080);
                
        jogo.displayMenu();
        servidor.getMsg(jogo);
        
        
      
    }
    
}
    

   
 
   
      
          




