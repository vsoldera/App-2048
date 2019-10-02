/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.swing.JFrame;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author CarryBit
 */

//Polimorfismo
abstract class Animacao extends JFrame implements ActionListener{
    
    Timer tm = new Timer(125, this);
   
    double x = 250, y = 250, vel = 0.2, angle = 90;
    private int velX = 4;
    private int velY = 4;
    public void Animacao(){ 
        setFocusable(true);
        

         
         
         
    }
    
    
    
    public void acaoPerformada(ActionEvent e) {
        x += (velX * (float) Math.cos(Math.toRadians(angle - 90)));
        y += (velX * (float) Math.sin(Math.toRadians(angle - 90)));
      
    }


    

    
}
