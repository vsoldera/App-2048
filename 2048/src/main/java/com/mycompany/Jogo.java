


/* 
#eee4da  == bloco2
#ede0c8 == bloco4
#f2b179 == bloco8
#f59563 == bloco16
#f67c5f == bloco32
#f65e3b == bloco64
#edcf72 == bloco128
#edcc61 == bloco256 

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author
 */
public class Jogo extends Tabuleiro implements KeyListener {
    int conte = 0;
    int setValor;
    int Pontuacao;
    boolean alreadyExecuted;
    int x;
    int y;
    Bloco[] bloco = new Bloco[16];
    
    Tabuleiro Janela = new Tabuleiro();
    JLabel c = null;
    JLabel derrota = null;
    
    
static void displayMenu()
    {
        JFrame frame6 = new JFrame("Menu!");

        // create our jbutton
        JButton showDialogButton = new JButton("Novo Jogo!");
  
        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener((ActionEvent e) -> {
            // display/center the jdialog when the button is pressed
                Jogo jogo = new Jogo();
                jogo.iniciaJogo();
                frame6.dispose();
        });
            

            // put the button on the frame
            frame6.getContentPane().setLayout(new FlowLayout());
            frame6.add(showDialogButton);

        // set up the jframe, then display it
            frame6.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame6.setPreferredSize(new Dimension(500, 500));
            frame6.pack();
            frame6.setLocationRelativeTo(null);
            frame6.setVisible(true);
        
    }
    

    public Jogo() {
          
            Janela.cima.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toUp();
                geraExibeBloco();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
            Janela.direita.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toRight();
                geraExibeBloco();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
            Janela.esquerda.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toLeft();
                geraExibeBloco();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });

            
            Janela.baixo.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                toDown();
                geraExibeBloco();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
            }
        });
    }
    
    
    

    public void KeyListener2048() {

        Janela.setTitle("2048");
        Janela.setBackground(Color.blue);
        Janela.setVisible(true);
        Janela.setResizable(false);
        Janela.addKeyListener(this);
        Janela.getContentPane().setBackground(Color.decode("#baac9f"));
        Janela.jButton1.setBackground(Color.decode("#baac9f"));

    }
    
    
        
    
    
            

    public void iniciaJogo() {

        KeyListener2048();

        bloco[0] = new Bloco("#afc3e2", 0, Janela.pos1, Janela.label1, 0);
        bloco[1] = new Bloco("#afc3e2", 0, Janela.pos2, Janela.label2, 0);
        bloco[2] = new Bloco("#afc3e2", 0, Janela.pos3, Janela.label3, 0);
        bloco[3] = new Bloco("#afc3e2", 0, Janela.pos4, Janela.label4, 0);
        bloco[4] = new Bloco("#afc3e2", 0, Janela.pos5, Janela.label5, 0);
        bloco[5] = new Bloco("#afc3e2", 0, Janela.pos6, Janela.label6, 0);
        bloco[6] = new Bloco("#afc3e2", 0, Janela.pos7, Janela.label7, 0);
        bloco[7] = new Bloco("#afc3e2", 0, Janela.pos8, Janela.label8, 0);
        bloco[8] = new Bloco("#afc3e2", 0, Janela.pos9, Janela.label9, 0);
        bloco[9] = new Bloco("#afc3e2", 0, Janela.pos10, Janela.label10, 0);
        bloco[10] = new Bloco("#afc3e2", 0, Janela.pos11, Janela.label11, 0);
        bloco[11] = new Bloco("#afc3e2", 0, Janela.pos12, Janela.label12, 0);
        bloco[12] = new Bloco("#afc3e2", 0, Janela.pos13, Janela.label13, 0);
        bloco[13] = new Bloco("#afc3e2", 0, Janela.pos14, Janela.label14, 0);
        bloco[14] = new Bloco("#afc3e2", 0, Janela.pos15, Janela.label15, 0);
        bloco[15] = new Bloco("#afc3e2", 0, Janela.pos16, Janela.label16, 0);
        
            
         Janela.direita.setIcon(new ImageIcon(Janela.criaIcones("/img/getirghtrue.png")));
         Janela.esquerda.setIcon(new ImageIcon(Janela.criaIcones("/img/getleft.png")));
         Janela.baixo.setIcon(new ImageIcon(Janela.criaIcones("/img/getright.png")));
         Janela.cima.setIcon(new ImageIcon(Janela.criaIcones("/img/getup.png")));
         
        
        int NumRandBloco;
        //Bloco bloco = new Bloco();

        getRandomicoBlocoInicial();

    }

    public void printaMatriz() {

        for (int i = 0; i < 4; i++) {
            System.out.print(bloco[i].getValor());

        }
        System.out.print("\n");
        for (int i = 4; i < 8; i++) {

            System.out.print(bloco[i].getValor());

        }
        System.out.print("\n");
        for (int i = 8; i < 12; i++) {
            System.out.print(bloco[i].getValor());

        }
        System.out.print("\n");
        for (int i = 12; i < 16; i++) {
            System.out.print(bloco[i].getValor());

        }

        

            

        

    }
    
    
      static void displayVitoria()
      {
        JFrame frame4 = new JFrame("Vitória");

        // create our jbutton
        JButton showDialogButton = new JButton("Novo Jogo");
  
        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener((ActionEvent e) -> {
            // display/center the jdialog when the button is pressed
                Jogo jogo = new Jogo();
                jogo.iniciaJogo();
                frame4.dispose();
        });
            

            // put the button on the frame
            frame4.getContentPane().setLayout(new FlowLayout());
            frame4.add(showDialogButton);

        // set up the jframe, then display it
            frame4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame4.setPreferredSize(new Dimension(300, 200));
            frame4.pack();
            frame4.setLocationRelativeTo(null);
            frame4.setVisible(true);
        
    }
    
      static void displayDerrota()
      {
        JFrame frame5 = new JFrame("Derrota");

        // create our jbutton
        JButton showDialogButton = new JButton("Novo Jogo");
  
        // add the listener to the jbutton to handle the "pressed" event
        showDialogButton.addActionListener((ActionEvent e) -> {
            // display/center the jdialog when the button is pressed
                Jogo jogo = new Jogo();
                jogo.iniciaJogo();
                frame5.dispose();
        });
            

            // put the button on the frame
            frame5.getContentPane().setLayout(new FlowLayout());
            frame5.add(showDialogButton);

        // set up the jframe, then display it
            frame5.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame5.setPreferredSize(new Dimension(300, 200));
            frame5.pack();
            frame5.setLocationRelativeTo(null);
            frame5.setVisible(true);
        
    }

    public void autoWin() {
        
            bloco[14].setSituacao(1);
            bloco[15].setSituacao(1);
            bloco[14].setValor(1024);
            bloco[15].setValor(1024);
            

        
    }

    public void getRandomicoBlocoInicial() {

        int min = 1;
        int max = 16;
        JPanel janela = new JPanel();

        Color corBloco;
        int NumRandBloco = (int) ((Math.random() * ((max - min) + 1)) + min);
        int aux = NumRandBloco;
        System.out.println("1o: " + NumRandBloco);
        int NumRandBloco2 = (int) ((Math.random() * ((max - min) + 1)) + min);

        while (NumRandBloco2 == aux) {
            NumRandBloco2 = (int) ((Math.random() * ((max - min) + 1)) + min);
            System.out.println("Gerados: " + NumRandBloco2);
        }

        Bloco bloco1 = new Bloco();

        System.out.println(NumRandBloco);
        for (int k = 0; k < 2; k++) {
            switch (NumRandBloco) {
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
                    janela = Janela.pos16;
                    bloco1.setCampoTexto(Janela.label16);
                    bloco1.setSituacao(1);
                    break;
            }
            if (bloco1.GeraValor() == 2) {
                bloco1.setValor(2);
                bloco1.setPosicao(janela, Color.decode(bloco1.CorRetorno(2))); //alterei a cor do novo

            } else {
                bloco1.setValor(4);
                bloco1.setPosicao(janela, Color.decode(bloco1.CorRetorno(4))); //alterei a cor do novo

            }
            NumRandBloco = NumRandBloco2;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            toRight();
            System.out.println("Seta Direita Pressionada");
            printaMatriz();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            setValor = 2; //Bloco vai para a esquerda
            System.out.println("Seta Esquerda Pressionada");
            toLeft();
            printaMatriz();
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            toUp();
            System.out.println("Seta Cima Pressionada");
            printaMatriz();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            toDown();
            System.out.println("Seta Baixo Pressionada");
            printaMatriz();
        } else if (e.getKeyCode() == KeyEvent.VK_W) {
            toUp();
            setValor = 3; //Bloco vai para cima
            System.out.println("Botao 'W' Pressionado");
            printaMatriz();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            toDown();
            setValor = 4; //Bloco vai para baixo
            System.out.println("Botao 'S' Pressionado");
            printaMatriz();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            toRight();
            setValor = 1; // Bloco vai para a direita
            System.out.println("Botao 'D' Pressionado");
            printaMatriz();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            toLeft();
            setValor = 2; //Bloco vai para a esquerda
            System.out.println("Botao 'A' Pressionado");
            printaMatriz();
        }
        if (e.getKeyCode() == KeyEvent.VK_V) Janela.criaExibeTelas(1, Janela);
        if (e.getKeyCode() == KeyEvent.VK_K) {
            autoWin();
            
            Janela.criaExibeTelas(2, Janela);
          
            //labelGif = 
            System.out.println("Botao 'K' Pressionado");

        }

        geraExibeBloco();
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
        if (e.getKeyCode() == KeyEvent.VK_W) {
            System.out.println("Botao 'W' solto");
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            System.out.println("Botao 'S' solto");
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            System.out.println("Botao 'D' solto");
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            System.out.println("Botao 'A' solto");
        }
        if (e.getKeyCode() == KeyEvent.VK_K) {
            System.out.println("Botao 'K' solto");
        }

    }

    public void geraExibeBloco() {
        int min = 0;
        int max = 15;
        int contador = 0;

        int NumRandBlocoJogo = (int) ((Math.random() * ((max - min) + 1)) + min);
  
           while (bloco[NumRandBlocoJogo].getSituacao() == 1 ) {
                NumRandBlocoJogo = (int) ((Math.random() * ((max - min) + 1)) + min);
                contador++;
                System.out.println("contador: "+contador);
                if(contador == 50) break;
            }
       
        if(contador != 50){// condicao para derrota, isso quer dizer 
            //que o while nao conseguiu encontar uma posicao vazia, logo o usuario perdeu, 
            //ja que em cada movimentacao do bloco, libera um e outro é logo preenchido por um randimico
            
        System.out.println("NumRand: " + NumRandBlocoJogo);
        JPanel janela = new JPanel();
        Bloco bloco1 = new Bloco();

        switch (NumRandBlocoJogo) {
            case 0:
                bloco1 = bloco[0];
                janela = Janela.pos1;
                bloco1.setCampoTexto(Janela.label1);
                bloco1.setSituacao(1); //Bloco gerado, entao sua posicao esta ocupada
                break;
            case 1:
                bloco1 = bloco[1];
                janela = Janela.pos2;
                bloco1.setCampoTexto(Janela.label2);
                bloco1.setSituacao(1);
                break;
            case 2:
                bloco1 = bloco[2];
                janela = Janela.pos3;
                bloco1.setCampoTexto(Janela.label3);
                bloco1.setSituacao(1);
                break;
            case 3:
                bloco1 = bloco[3];
                janela = Janela.pos4;
                bloco1.setCampoTexto(Janela.label4);
                bloco1.setSituacao(1);
                break;
            case 4:
                bloco1 = bloco[4];
                janela = Janela.pos5;
                bloco1.setCampoTexto(Janela.label5);
                bloco1.setSituacao(1);
                break;
            case 5:
                bloco1 = bloco[5];
                janela = Janela.pos6;
                bloco1.setCampoTexto(Janela.label6);
                bloco1.setSituacao(1);
                break;
            case 6:
                bloco1 = bloco[6];
                janela = Janela.pos7;
                bloco1.setCampoTexto(Janela.label7);
                bloco1.setSituacao(1);
                break;
            case 7:
                bloco1 = bloco[7];
                janela = Janela.pos8;
                bloco1.setCampoTexto(Janela.label8);
                bloco1.setSituacao(1);
                break;
            case 8:
                bloco1 = bloco[8];
                janela = Janela.pos9;
                bloco1.setCampoTexto(Janela.label9);
                bloco1.setSituacao(1);
                break;
            case 9:
                bloco1 = bloco[9];
                janela = Janela.pos10;
                bloco1.setCampoTexto(Janela.label10);
                bloco1.setSituacao(1);
                break;
            case 10:
                bloco1 = bloco[10];
                janela = Janela.pos11;
                bloco1.setCampoTexto(Janela.label11);
                bloco1.setSituacao(1);
                break;
            case 11:
                bloco1 = bloco[11];
                janela = Janela.pos12;
                bloco1.setCampoTexto(Janela.label12);
                bloco1.setSituacao(1);
                break;
            case 12:
                bloco1 = bloco[12];
                janela = Janela.pos13;
                bloco1.setCampoTexto(Janela.label13);
                bloco1.setSituacao(1);
                break;
            case 13:
                bloco1 = bloco[13];
                janela = Janela.pos14;
                bloco1.setCampoTexto(Janela.label14);
                bloco1.setSituacao(1);
                break;
            case 14:
                bloco1 = bloco[14];
                janela = Janela.pos15;
                bloco1.setCampoTexto(Janela.label15);
                bloco1.setSituacao(1);
                break;
            case 15:
                bloco1 = bloco[15];
                janela = Janela.pos16;
                bloco1.setCampoTexto(Janela.label16);
                bloco1.setSituacao(1);
                break;
        }

        if (bloco1.GeraValor() == 2) {
            bloco1.setValor(2);
            bloco1.setPosicao(janela, Color.decode(bloco1.CorRetorno(2))); //alterei a cor do novo
        } else {
            bloco1.setValor(4);
            bloco1.setPosicao(janela, Color.decode(bloco1.CorRetorno(4))); //alterei a cor do novo

        }
      }
           else{
               System.out.println("perdeu");
               Janela.criaExibeTelas(1, Janela);
      }

    }

    @SuppressWarnings("empty-statement")
    public void movBloco(int Inicio, int Final, int Razao, int Direcao) { //1 subir(maior que) - exemplo: ToUP; 2 descer (menor que)
        int ctrl = 0;

        switch (Direcao) {
            case 1:
                for (int i = Inicio; i >= Final; i = i - Razao) {
                    //System.out.println("for 1"+bloco[i].getSituacao());,

                    if (bloco[i].getSituacao() == 1) {
                        for (int j = i - Razao; j >= Final; j = j - Razao) {
                            // System.out.println("for 2"+bloco[j].getSituacao());

                            if (bloco[j].getSituacao() == 0) {

                                bloco[j + Razao].setSituacao(0);//desativei o bloco antigo
                                bloco[j + Razao].setPosicao(getJanela(j + Razao), Color.decode("#CBBFB2")); //alterei a cor do antigo para a padrao
                                bloco[j].setValor(bloco[j + Razao].getValor()); // passo o valor do antigo para o novo
                                bloco[j + Razao].setValor(0);// zero o antigo
                                bloco[j].setSituacao(1);//ativei o novo
                                bloco[j].setPosicao(getJanela(j), Color.decode(bloco[j].CorRetorno(bloco[j].getValor()))); //alterei a cor do novo

                            } else if (bloco[j + Razao].getValor() == bloco[j].getValor() && ctrl != 1) {
                                try{
                                conte = 1;
                                bloco[j].setValor(bloco[j].getValor() * 2);
                                bloco[j].setPosicao(getJanela(j), Color.decode(bloco[j].CorRetorno(bloco[j].getValor()))); //alterei a cor do novo
                                bloco[j + Razao].setValor(0);
                                bloco[j + Razao].setSituacao(0); //Desativando logicamente
                                bloco[j + Razao].setPosicao(getJanela(j + Razao), Color.decode("#CBBFB2")); //alterei a cor do antigo para a padrao
                                //System.out.println("ELSE");
                                ctrl = 1;
                                
                                y += bloco[j].getValor();
                                System.out.println("VALOR DE Y: " + y);
                                }
                                catch(NumberFormatException e)
                                {
                                    System.out.println("Just numbers");
                                }  
                                
                            }
                        }

                    }
                }
                break;
            case 2:

                for (int i = Inicio; i <= Final; i = i + Razao) {
                    //System.out.println("for 1"+bloco[i].getSituacao());

                    if (bloco[i].getSituacao() == 1) {
                        for (int j = i + Razao; j <= Final; j = j + Razao) {

                            // System.out.println("for 2"+bloco[j].getSituacao());
                            if (bloco[j].getSituacao() == 0) {

                                bloco[j - Razao].setSituacao(0);//desativei o bloco antigo
                                bloco[j - Razao].setPosicao(getJanela(j - Razao), Color.decode("#CBBFB2")); //alterei a cor do antigo para a padrao
                                bloco[j].setValor(bloco[j - Razao].getValor()); // passo o valor do antigo para o novo
                                bloco[j - Razao].setValor(0);// zero o antigo
                                bloco[j].setSituacao(1);//ativei o novo
                                bloco[j].setPosicao(getJanela(j), Color.decode(bloco[j].CorRetorno(bloco[j].getValor()))); //alterei a cor do novo

                            } else if (bloco[j - Razao].getValor() == bloco[j].getValor() && ctrl != 1) {
                                conte = 1;
                                bloco[j].setValor(bloco[j].getValor() * 2);
                                bloco[j].setPosicao(getJanela(j), Color.decode(bloco[j].CorRetorno(bloco[j].getValor()))); //alterei a cor do novo
                                bloco[j - Razao].setValor(0);
                                bloco[j - Razao].setSituacao(0); //Desativando logicamente
                                bloco[j - Razao].setPosicao(getJanela(j - Razao), Color.decode("#CBBFB2"));
                                //System.out.println("ELSE2");

                                x += bloco[j].getValor();

                                System.out.println("VALOR DE X: " + x);

                                ctrl = 1;

                            }

                        }

                    }

                }

        }

        Pontuacao = x + y;
        System.out.println("PONTUACAO: " + Pontuacao);
        atualizarPontuacao(Pontuacao);

    }

    public void toLeft() {
        int moveAte = 0;
        int atual = 0, proximo = 0, k = 0;

        movBloco(3, 0, 1, 1);
        movBloco(7, 4, 1, 1);
        movBloco(11, 8, 1, 1);
        movBloco(15, 12, 1, 1);

    }

    public void toRight() {
        int moveAte = 0;
        int atual = 0, proximo = 0, k = 0;

        movBloco(0, 3, 1, 2);
        movBloco(4, 7, 1, 2);
        movBloco(8, 11, 1, 2);
        movBloco(12, 15, 1, 2);

    }

    public void toDown() {
        int moveAte = 0;
        int i, k = 0;
        int atual = 0, proximo = 0;

        movBloco(0, 12, 4, 2);
        movBloco(1, 13, 4, 2);
        movBloco(2, 14, 4, 2);
        movBloco(3, 15, 4, 2);

    }

    public void toUp() {
        int moveAte = 0;
        int i, k = 0;
        int atual = 0, proximo = 0;

        movBloco(12, 0, 4, 1);
        movBloco(13, 1, 4, 1);
        movBloco(14, 2, 4, 1);
        movBloco(15, 3, 4, 1);
    }

    public JPanel getJanela(int i) {
        JPanel janela = new JPanel();
        switch (i) {
            case 0:
                janela = Janela.pos1;
                break;
            case 1:
                janela = Janela.pos2;
                break;
            case 2:
                janela = Janela.pos3;
                break;
            case 3:
                janela = Janela.pos4;
                break;
            case 4:
                janela = Janela.pos5;
                break;
            case 5:
                janela = Janela.pos6;
                break;
            case 6:
                janela = Janela.pos7;
                break;
            case 7:
                janela = Janela.pos8;
                break;

            case 8:
                janela = Janela.pos9;
                break;

            case 9:
                janela = Janela.pos10;
                break;

            case 10:
                janela = Janela.pos11;
                break;

            case 11:
                janela = Janela.pos12;
                break;

            case 12:
                janela = Janela.pos13;
                break;

            case 13:
                janela = Janela.pos14;
                break;

            case 14:
                janela = Janela.pos15;
                break;
            case 15:
                janela = Janela.pos16;
                break;

        }

        return janela;

    }

    public void atualizarPontuacao(int Pontuacao) {
        Janela.pont.setText(String.valueOf(Pontuacao));

    }
    
     


}
