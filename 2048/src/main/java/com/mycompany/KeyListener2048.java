/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author CarryBit
 */
public class KeyListener2048 extends JFrame implements KeyListener {

    JLabel label;

    public KeyListener2048(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT  ) {
            System.out.println("Seta Direita Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Seta Esquerda Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Seta Cima Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Seta Baixo Pressionada");
        }
        if (e.getKeyCode() == KeyEvent.VK_W  ) {
            System.out.println("Botao 'W' Pressionado");
        }
        if (e.getKeyCode() == KeyEvent.VK_S  ) {
            System.out.println("Botao 'S' Pressionado");
        }
        if (e.getKeyCode() == KeyEvent.VK_D  ) {
            System.out.println("Botao 'D' Pressionado");
        }
        if (e.getKeyCode() == KeyEvent.VK_E  ) {
            System.out.println("Botao 'E' Pressionado");
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
        if (e.getKeyCode() == KeyEvent.VK_E  ) {
            System.out.println("Botao 'E' solto");
        }

        
    }


}
