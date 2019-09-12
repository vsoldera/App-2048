/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;
import java.lang.Math; 
/**
 *
 * @author luizviniciusruoso
 */
public class Bloco {
    String Cor;
    int Posicao;
    int Situacao;
    int Valor;
    
    //Funcao GeraValor = Gera Valor Inicial de Blocos (2 ou 4)
    public int GeraValor(int min, int max) { 
         int ValorRand = (int) ((Math.random()*((max-min)+1))+min);
         if(ValorRand == 2 || ValorRand == 4) {
             return ValorRand;
               }
         return 0;
    }
    
    //Getters
    public String getCor() {
        return Cor;
    }

    public int getPosicao() {
        return Posicao;
    }

    public int getSituacao() {
        return Situacao;
    }

    public int getValor() {
        return Valor;
    }
    
    
    //Setters
    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public void setPosicao(int Posicao) {
        this.Posicao = Posicao;
    }

    public void setSituacao(int Situacao) {
        this.Situacao = Situacao;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }
    
    
    
    
    
}
