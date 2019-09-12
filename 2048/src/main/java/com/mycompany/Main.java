/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

/**
 *
 * @author luizviniciusruoso  
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bloco Bloco = new Bloco();
        System.out.println(Bloco.GeraValor(2, 4));

        Tabuleiro Janela = new Tabuleiro();
        Janela.setTitle("2048");
        
        Janela.setVisible(true);
    }
    
}
