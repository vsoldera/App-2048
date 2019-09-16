/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import static com.sun.glass.ui.Cursor.setVisible;
import com.sun.java.accessibility.util.AWTEventMonitor;
import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author 
 */
public class Jogo extends Tabuleiro implements KeyListener {
    int setValor;
    Bloco[] bloco = new Bloco[16];
    Tabuleiro Janela = new Tabuleiro();
    public void KeyListener2048(){
      
        
        Janela.setTitle("2048");   
        Janela.setBackground(Color.blue);
        Janela.setVisible(true);
        Janela.setResizable(false);
        Janela.addKeyListener(this);
        
       
}

    
    
    
    
    public void iniciaJogo(){
        
        KeyListener2048();
        
        bloco[0] = new Bloco();
        bloco[1] = new Bloco();
        bloco[2] = new Bloco();
        bloco[3] = new Bloco();
        bloco[4] = new Bloco();
        bloco[5] = new Bloco();
        bloco[6] = new Bloco();
        bloco[7] = new Bloco();
        bloco[8] = new Bloco();
        bloco[9] = new Bloco();
        bloco[10] = new Bloco();
        bloco[11] = new Bloco();
        bloco[12] = new Bloco();
        bloco[13] = new Bloco();
        bloco[14] = new Bloco();
        bloco[15] = new Bloco();
  
        
        
        
        int NumRandBloco;
        Bloco bloco = new Bloco();
        
        
        
            getRandomicoBloco();
        
        
        
                
     }
    
    
    
 public void getRandomicoBloco(){
        
        int min = 1;
        int max = 16;
        JPanel janela = new JPanel();
        Color corBloco;
        int NumRandBloco = (int) ((Math.random()*((max-min)+1))+min);
        Bloco bloco1 = new Bloco();
        System.out.println(NumRandBloco);
        switch (NumRandBloco){
            case 1:
                bloco1 = bloco[0];
                janela = Janela.pos1;
                bloco1.setCampoTexto(Janela.label1);
                bloco1.setSituacao(1); //Bloco gerado, entao sua posicao esta ocupada
            break;
            case 2:
                bloco1 = bloco[1];
                janela = Janela.pos2;
                bloco1.setCampoTexto(Janela.label2);
                bloco1.setSituacao(1);
            break;
            case 3:
                bloco1 = bloco[2];
                janela = Janela.pos3;
                bloco1.setCampoTexto(Janela.label3);
                bloco1.setSituacao(1);
            break;
            case 4:
                bloco1 = bloco[3];
                janela = Janela.pos4;
                bloco1.setCampoTexto(Janela.label4);
                bloco1.setSituacao(1);
                
            break;
            case 5:
                bloco1 = bloco[4];
                janela = Janela.pos5;
                bloco1.setCampoTexto(Janela.label5);
                bloco1.setSituacao(1);
            break;
            case 6:
                bloco1 = bloco[5];
                janela = Janela.pos6;
                bloco1.setCampoTexto(Janela.label6);
                bloco1.setSituacao(1);
            break;
            case 7:
                bloco1 = bloco[6];
                janela = Janela.pos7;
                bloco1.setCampoTexto(Janela.label7);
                bloco1.setSituacao(1);
            break;
            case 8:
                bloco1 = bloco[7];
                janela = Janela.pos8;
                bloco1.setCampoTexto(Janela.label8);
                bloco1.setSituacao(1);
            break;
            case 9:
                bloco1 = bloco[8];
                janela = Janela.pos9;
                bloco1.setCampoTexto(Janela.label9);
                bloco1.setSituacao(1);
            break;
            case 10:
                bloco1 = bloco[9];
                janela = Janela.pos10;
                bloco1.setCampoTexto(Janela.label10);
                bloco1.setSituacao(1);
            break;
            case 11:
                bloco1 = bloco[10];
                janela = Janela.pos11;
                bloco1.setCampoTexto(Janela.label11);
                bloco1.setSituacao(1);
            break;
            case 12:
                bloco1 = bloco[11];
                janela = Janela.pos12;
                bloco1.setCampoTexto(Janela.label12);
                bloco1.setSituacao(1);
            break;
            case 13:
                bloco1 = bloco[12];
                janela = Janela.pos13;
                bloco1.setCampoTexto(Janela.label13);
                bloco1.setSituacao(1);
            break;
            case 14:
                bloco1 = bloco[13];
                janela = Janela.pos14;
                bloco1.setCampoTexto(Janela.label14);
                bloco1.setSituacao(1);
                break;
            case 15:
                bloco1 = bloco[14];
                janela = Janela.pos15;
                bloco1.setCampoTexto(Janela.label15);
                bloco1.setSituacao(1);
            break;
            case 16:
                bloco1 = bloco[15];
                janela = Janela.pos15;
                bloco1.setCampoTexto(Janela.label16);
                bloco1.setSituacao(1);
            break;
        }
        if(bloco1.GeraValor() == 2) {
           bloco1.campoTexto.setText((String.valueOf(2)) );
           bloco1.setPosicao(janela, Color.decode("#eee4da"));
        }else{
           bloco1.campoTexto.setText((String.valueOf(4)) );
           bloco1.setPosicao(janela, Color.decode("#ede0c8"));
            
        }
        

        
    }
           
     
     
    public void checaArredores(){
        //Se o bloco existir
            for(int i = 0; i < 3; i++) {
                if(bloco[i].getSituacao() == 1) {
                    if(bloco[0] == true) {
                        
                    }
                }
            }
        
          return -1;  
    }
    
     @Override
    public void keyTyped(KeyEvent e) {


    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT  ) {
            toRight();
            System.out.println("Seta Direita Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setValor = 2; //Bloco vai para a esquerda
            System.out.println("Seta Esquerda Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            setValor = 3; //Bloco vai para cima
            System.out.println("Seta Cima Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            setValor = 4; //Bloco vai para baixo
            System.out.println("Seta Baixo Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_W  ) {
            setValor = 3; //Bloco vai para cima
            System.out.println("Botao 'W' Pressionado");
        }
        if (e.getKeyCode() == KeyEvent.VK_S  ) {
            setValor = 4; //Bloco vai para baixo
            System.out.println("Botao 'S' Pressionado");
        }
        if (e.getKeyCode() == KeyEvent.VK_D  ) {
            setValor = 1; // Bloco vai para a direita
            System.out.println("Botao 'D' Pressionado");
        }
        if (e.getKeyCode() == KeyEvent.VK_A  ) {
            setValor = 2; //Bloco vai para a esquerda
            System.out.println("Botao 'A' Pressionado");
        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Seta direita solta");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Seta esquerda solta");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Seta Cima solta");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Seta Baixo solta");
        }
        if (e.getKeyCode() == KeyEvent.VK_W  ) {
            System.out.println("Botao 'W' solto");
        }
        if (e.getKeyCode() == KeyEvent.VK_S  ) {
            System.out.println("Botao 'S' solto");
        }
        if (e.getKeyCode() == KeyEvent.VK_D  ) {
            System.out.println("Botao 'D' solto");
        }
        if (e.getKeyCode() == KeyEvent.VK_A  ) {
            System.out.println("Botao 'A' solto");
        }

        
    }
    
    public void toRight(){
        
        //if(bloco[3].getSituacao() == 1 && bloco[2].getSituacao() == 1 &&
          //      bloco[1].getSituacao() == 1 && bloco[0].getSituacao() == 1) { //verificando se a linha esta 
            
            
        //}
      
        for(int i=0; i <16; i++){
            System.out.println(bloco[i].getSituacao());
            if(bloco[i].getSituacao() == 1){ 
                bloco[i].setSituacao(0);
               bloco[i].setPosicao(getJanela(i), Color.decode("#afc3e2"));
                bloco[i++].setPosicao(getJanela(i), Color.decode("#eee4da"));
                
                bloco[i++].setSituacao(1);
            
            
            }
        }
     
    }
    public JPanel getJanela(int i){
        JPanel janela  = new JPanel();
        switch(i){
            case 1:
                janela = Janela.pos1;
                break;
            case 2:
                janela = Janela.pos2;
                break;
            case 3:
                janela = Janela.pos3;
                break;   
            case 4:
                janela = Janela.pos4;
                break;   
            case 5:
                janela = Janela.pos5;
                break;
            case 6:
                janela = Janela.pos6;
                break;    
            case 7:
                janela = Janela.pos7;
                break;   
             case 8:
                janela = Janela.pos8;
                break;   
                
             case 9:
                janela = Janela.pos9;
                break;   
                
             case 10:
                janela = Janela.pos10;
                break;
                
             case 11:
                janela = Janela.pos11;
                break;
                
             case 12:
                janela = Janela.pos12;
                break;
                
                
             case 13:
                janela = Janela.pos13;
                break;
                
             case 14:
                janela = Janela.pos14;
                break;
                
            case 15:
                janela = Janela.pos15;
                break; 
            case 16:
                janela = Janela.pos16;
                break;
                
        }
        
        return janela;
        
    }
   

}
