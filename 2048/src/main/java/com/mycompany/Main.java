/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import com.sun.corba.se.spi.activation.Server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luizviniciusruoso  
 */
public class Main extends Jogo{
    /* funcao para inciar o jogo e deixar ele tôp*/
     
        
    public static void main(String[] args) {
        /* tabuleiro speccs*/
        Jogo jogo = new Jogo();
        
        jogo.displayMenu();
        
        try {
            ServerSocket Servidor = new ServerSocket(3000);

            while(true){
                Socket C = Servidor.accept();
                Scanner s = new Scanner(C.getInputStream());
                System.out.println(s.nextLine());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
      
    }
    

   
 
   
      
          




