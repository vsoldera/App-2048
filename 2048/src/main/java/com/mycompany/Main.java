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
     static Bloco bloco1 = new Bloco();
     static Bloco bloco2 = new Bloco();
     static Bloco bloco3 = new Bloco();
     static Bloco bloco4 = new Bloco();
     static Bloco bloco5 = new Bloco();
     static Bloco bloco6 = new Bloco();
     static Bloco bloco7 = new Bloco();
     static Bloco bloco8 = new Bloco();
     static Bloco bloco9 = new Bloco();
     static Bloco bloco10 = new Bloco();
     static Bloco bloco11 = new Bloco();
     static Bloco bloco12 = new Bloco();
     static Bloco bloco13 = new Bloco();
     static Bloco bloco14 = new Bloco();
     static Bloco bloco15 = new Bloco();
     static Bloco bloco16 = new Bloco();
    
    static Tabuleiro Janela = new Tabuleiro();
        
    public static void main(String[] args) {
        /* tabuleiro speccs*/
         
        
        Janela.setTitle("2048");   
        Janela.setBackground(Color.blue);
        Janela.setVisible(true);
        Janela.setResizable(false);
    
        /* end*/
        
        iniciaJogo();
       
        detectaPosicao();
        

        
    }
    
    public static void iniciaJogo(){
        int NumRandBloco;
        Bloco bloco = new Bloco();
        
        bloco = getRandomicoBloco();
        bloco.Posicao.setBackground(Color.red);
        bloco.campoTexto.setText((String.valueOf(bloco.GeraValor())) );
        bloco = getRandomicoBloco();
        bloco.Posicao.setBackground(Color.red);
        bloco.campoTexto.setText((String.valueOf(bloco.GeraValor())) );
       
    }
    public static Bloco getRandomicoBloco(){
        
        int min = 1;
        int max = 16;
        
        int NumRandBloco = (int) ((Math.random()*((max-min)+1))+min);
        Bloco bloco = new Bloco();
        System.out.println(NumRandBloco);
        switch (NumRandBloco){
            case 1:
                bloco = bloco1;
                bloco.setPosicao(Janela.pos1);
                bloco.setCampoTexto(Janela.label1);
                bloco.setSituacao(1);
            break;
            case 2:
                bloco = bloco2;
                bloco.setPosicao(Janela.pos2);
                bloco.setCampoTexto(Janela.label2);
                bloco.setSituacao(1);
            break;
            case 3:
                bloco = bloco3;
                bloco.setPosicao(Janela.pos3);
                bloco.setCampoTexto(Janela.label3);
                bloco.setSituacao(1);
            break;
            case 4:
                bloco = bloco4;
                bloco.setPosicao(Janela.pos4);
                bloco.setCampoTexto(Janela.label4);
                bloco.setSituacao(1);
                
            break;
            case 5:
                bloco = bloco5;
                bloco.setPosicao(Janela.pos5);
                bloco.setCampoTexto(Janela.label5);
                bloco.setSituacao(1);
            break;
            case 6:
                bloco = bloco6;
                bloco.setPosicao(Janela.pos6);
                bloco.setCampoTexto(Janela.label6);
                bloco.setSituacao(1);
            break;
            case 7:
                bloco = bloco7;
                bloco.setPosicao(Janela.pos7);
                bloco.setCampoTexto(Janela.label7);
                bloco.setSituacao(1);
            break;
            case 8:
                bloco = bloco8;
                bloco.setPosicao(Janela.pos8);
                bloco.setCampoTexto(Janela.label8);
                bloco.setSituacao(1);
            break;
            case 9:
                bloco = bloco9;
                bloco.setPosicao(Janela.pos9);
                bloco.setCampoTexto(Janela.label9);
                bloco.setSituacao(1);
            break;
            case 10:
                bloco = bloco10;
                bloco.setPosicao(Janela.pos10);
                bloco.setCampoTexto(Janela.label10);
                bloco.setSituacao(1);
            break;
            case 11:
                bloco = bloco11;
                bloco.setPosicao(Janela.pos11);
                bloco.setCampoTexto(Janela.label11);
                bloco.setSituacao(1);
            break;
            case 12:
                bloco = bloco12;
                bloco.setPosicao(Janela.pos12);
                bloco.setCampoTexto(Janela.label12);
                bloco.setSituacao(1);
            break;
            case 13:
                bloco = bloco13;
                bloco.setPosicao(Janela.pos13);
                bloco.setCampoTexto(Janela.label13);
                bloco.setSituacao(1);
            break;
            case 14:
                bloco = bloco14;
                bloco.setPosicao(Janela.pos14);
                bloco.setCampoTexto(Janela.label14);
                bloco.setSituacao(1);
                break;
            case 15:
                bloco = bloco15;
                bloco.setPosicao(Janela.pos15);
                bloco.setCampoTexto(Janela.label15);
                bloco.setSituacao(1);
            break;
            case 16:
                bloco = bloco16;
                bloco.setPosicao(Janela.pos16);
                bloco.setCampoTexto(Janela.label16);
                bloco.setSituacao(1);
            break;
        }
        return bloco;
    
    }
    
    
      public int keyPressed(KeyEvent e) {
     
        int key = e.getKeyCode();
        
            if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                return 1; //Pressionada pra baixo(S)  
            }
        
            if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                return 2; //Pressionado para a direita(D)
            }
        
            if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                return 3; //Pressionado para a esquerda(A)
            }
        
            if(key == KeyEvent.VK_UP|| key == KeyEvent.VK_W) {
                return 4; //Pressionado para cima (W)
            }

           return -1; //Default
    }
    
    
     public static detectaPosicao() {

         
      for(int i = 1; i <= 16; i++) {
          String x = "bloco" + i;
          int x;
          System.out.println(x);
            if(bloco1.getSituacao() != 1) {
                  
            }
        }
    }
      
          


}

