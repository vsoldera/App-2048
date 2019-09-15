/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.awt.event.KeyEvent;

/**
 *
 * @author CarryBit
 */








//Caso de Herança
public class Movimentacao extends Bloco{
    public boolean livreCima;
    public boolean livreDireita;
    public boolean livreEsquerda;
    public boolean livreBaixo;
    
    /**
     *
     * @return
     */
    public boolean isLivreCima() {
        
        return livreCima;
    }

    public void setLivreCima(boolean livreCima) {
        this.livreCima = livreCima;
    }

    public boolean isLivreDireita() {
        return livreDireita;
    }

    public void setLivreDireita(boolean livreDireita) {
        this.livreDireita = livreDireita;
    }

    public boolean isLivreEsquerda() {
        return livreEsquerda;
    }

    public void setLivreEsquerda(boolean livreEsquerda) {
        this.livreEsquerda = livreEsquerda;
    }

    public boolean isLivreBaixo() {
        return livreBaixo;
    }

    public void setLivreBaixo(boolean livreBaixo) {
        this.livreBaixo = livreBaixo;
    }

    @Override
    public String getCor() {
        return Cor;
    }

    @Override
    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    @Override
    public int getSituacao() {
        return Situacao;
    }

    @Override
    public void setSituacao(int Situacao) {
        this.Situacao = Situacao;
    }

    @Override
    public int getValor() {
        return Valor;
    }

    /**
     *
     * @param Valor
     */
    @Override
    public void setValor(int Valor) {
        this.Valor = Valor;
    }
    
    //Detecta Posicao do quadrado
   
    

  

    //Luiz escreve "Meche"
    public int mexeBloco(KeyEvent e) {

        int x = keyPressed(e); 
        if(x == 1) {
            
        }
    }
    
    
       
    
    
    
    
    
    
 }



    


