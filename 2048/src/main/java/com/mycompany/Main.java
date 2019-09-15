/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author luizviniciusruoso  
 */
public class Main {
    /* funcao para inciar o jogo e deixar ele tôp*/
     
        
    public static void main(String[] args) {
        /* tabuleiro speccs*/
         
        
       
       Jogo jogo = new Jogo();
       
       jogo.iniciaJogo();
        new KeyListener2048("Key Listener");
   
    }

   
 
   
      
          


}

