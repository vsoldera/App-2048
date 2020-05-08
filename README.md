# Jogo 2048

![2048](https://user-images.githubusercontent.com/38138765/66098467-105f5f00-e579-11e9-9b54-cb8f110560e3.png)

Jogo implementado para a disciplina **Paradigmas de Programação B** com a temática de *"espaço sideral"*. 

Baseado no jogo feito por [Gabriele Cirulli](https://github.com/gabrielecirulli).

## Objetivo
O  objetivo, como o próprio nome indica, é chegar ao número **2048** por meio da junção de blocos de mesmo valor em uma matriz 4x4.
Mas cuidado! Toda vez que você move blocos, todos movem-se juntos e ainda há a geração de um bloco *"randômico"* de valor 2(dois) ou 4(quatro).

## Tecnologias

- Jogo feito inteiramente na linguagem de programação **[Java](https://java.com/pt_BR/download/faq/whatis_java.xml).** 

- Feito por meio do **[Apache NetBeans 11.1](https://netbeans.apache.org/download/index.html).** 

## Execução

- Recomenda-se que rode-o por meio do **[Apache NetBeans 11.1](https://netbeans.apache.org/download/index.html).**
- Após abrir o projeto, execute a classe **Main.java** por meio da tecla de atalho **"F6"**. Se houver erro na execução, tente limpar e construir o projeto principal por meio do **"Shift" + "F11"**.

## Implementações

- Pode-se mover os blocos por meio das teclas **"W", "A", "S", "D"** e pelas **setas direcionais** do teclado.
- As setas brancas dentro do jogo, movem os blocos a partir do **clique no botão esquerdo do mouse**.

## Easter Egg
Se você achou o jogo muito dificil, pode apertar nosso NOOButton : **"K"**.

## Contribuidores
[Luiz Vinicius Dos Santos Ruoso](https://github.com/luizvruoso)

[Victor Luiz Fraga Soldera](https://github.com/VictorSoldera)



## UPDATE 1

Atualizações para o controle remoto a partir de um aplicativo mobile

  - Foi adicionado novas pastas APP e SERVER, ambas dizem o que são - risadas hehe
      - Para editar o APP, adentre o mesmo pelo Android Studio e o edite
      - Para rodar o server, aí teremos problemas, os senhores deveram instalar o node em suas máquinas (https://nodejs.org/en/download/)
          - Depois de instalado, instale o nodemon através do comando em Terminal: npm install -g nodemon
          - Após esses passinhos, entre na pasta 'Server' através do Terminal e digite: nodemon app
          - Done, executado! Acesse pelo: localhost:3000. Para acessar de outros dispositivos coloque: ip.da.sua.maquina/3000
## Update 2 

Atualizações para proporcionar novas formas de jogar e validação de IP: 

  - Adicionado controle via direcionais;
  
  - Detecção de imagens (Se for um laptop, vai para cima; Se for uma pessoa, vai para baixo; Se for uma mochila, vai para a esquerda; Se for um celular, vai para a direita);
  
  - Adicionado controle por acelerômetro (Movimente seu celular com vontade para as respectivas direções que deseja levar os blocos);
  
  - Adiciona controle por comandos de voz (Exemplo: Aperte o microfone no centro da tela, após o barulho diga "Going Up" e os blocos irão para cima);
  
  - Adicionado validação de IP, se o mesmo der "Error 401" (Conexão Recusada), o app avisará e não conectará a atividade principal;
  







