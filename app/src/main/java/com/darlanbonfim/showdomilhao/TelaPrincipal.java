package com.darlanbonfim.showdomilhao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;

public class TelaPrincipal extends AppCompatActivity {

    TextView txtNomeJogador, txtTime, txtPergunta, txtErrar, txtParar, txtAcertar;
    Intent intent;
    Button a, b, c, d;
    MediaPlayer som;
    ImageButton btnCartas, btnPlacas, btnConvidados, btnPular, btnParar;

    String resposta; // Recebe a resposta dada pelo jogador ao selecionar o botão A B C ou D;
    ArrayList<String> pergunta; // Recebe a pergunta gerada pelo sistema na classe Perguntas;
    //String opA, opB, opC, opD; // Recebe as opções de resposta gerada pelo sistema na classe Perguntas;
    String respCerta; // Recebe a resposta certa gerada pelo sistema na classe Perguntas;

    int rodada = 1; // Recebe +1 a cada pergunta certa registrando o numero da rodada atual;

    String[] premio = {"R$ 0,00", "R$ 1.000", "R$ 2.000", "R$ 3.000", "R$ 4.000", "R$ 5.000",
                        "R$ 10.000", "R$ 20.000", "R$ 30.000", "R$ 40.000", "R$ 50.000",
                        "R$ 100.000", "R$ 200.000", "R$ 300.000", "R$ 400.000", "R$ 500.000",
                        "R$ 1.000.000"};
    String errar, parar, acertar; // Recebe o valor do premio baseado no numero da rodada atual;

    // Atributos que recebe o valor gerado na tela de ajuda;
    int cartas; // Recebe o valor sorteado pelas cartas para indicar quantas respostas serão eliminadas;
    int convidados; // Recebe a opção correta indicada pelos convidados;
    int placas; // Recebe o valor indicado pelas placas com a opção mais indicada como correta;
    int pular = 3; // Quantidade de pulo no inicio do jogo, esse valor recebe -1 a cada utilização;

    // Esse atributo recebe as opções a, b, c, ou d para indicar o botão que foi selecionado ou quais botões devem ser eliminados;
    String selecionado = "", eliminado1 = "", eliminado2 = "", eliminado3 = "";

    Random random = new Random(); // Objeto da classe random para gerar números aleatórios;

    //Integer[] indice; // Atributo que recebe 8 numeros aleatorios sem repetição gerado na classe Perguntas;
    ArrayList<Integer> indice; // Atributo que recebe 8 numeros aleatorios sem repetição gerado na classe Perguntas;
    String[] nivelPergunta; // Atributo que recebe o nivel atual das perguntas no jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        // Liagação dos atributos com os objetos no layout;
        a = findViewById(R.id.btnA);
        b = findViewById(R.id.btnB);
        c = findViewById(R.id.btnC);
        d = findViewById(R.id.btnD);
        txtPergunta = findViewById(R.id.txtPergunta);
        txtNomeJogador = findViewById(R.id.txtNomeJogador);

        txtTime = findViewById(R.id.txtTime);

        txtErrar = findViewById(R.id.txtErrar);
        txtParar = findViewById(R.id.txtParar);
        txtAcertar = findViewById(R.id.txtAcertar);

        btnCartas = findViewById(R.id.btnCartas);
        btnPlacas = findViewById(R.id.btnPlacas);
        btnConvidados = findViewById(R.id.btnConvidados);
        btnPular = findViewById(R.id.btnPular);
        btnParar = findViewById(R.id.btnParar);

        // Comando para receber um valor vindo de outra tela;
        intent = getIntent();
        txtNomeJogador.setText(intent.getExtras().getString("nome"));

        // Início das perguntas;
        nivel();
        popUP("Alerta", "Numeros: "+ indice);
        rodada1();

    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoA(View view) {
        a.setBackgroundColor(getResources().getColor(R.color.amarelo));
        a.setTextColor(getResources().getColor(R.color.black));
        resposta = "A"; // Valor atribuido ao botão que representa a escolha A;
        selecionado = "a"; // Esse atributo recebe esse valor indicando qual foi a opção selecionada;

        confimacao(resposta); // Chamada do método que verifica se o usuário está certo da resposta;
    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoB(View view) {
        b.setBackgroundColor(getResources().getColor(R.color.amarelo));
        b.setTextColor(getResources().getColor(R.color.black));
        resposta = "B";
        selecionado = "b";

        confimacao(resposta);
    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoC(View view) {
        c.setBackgroundColor(getResources().getColor(R.color.amarelo));
        c.setTextColor(getResources().getColor(R.color.black));
        resposta = "C";
        selecionado = "c";

        confimacao(resposta);
    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoD(View view) {
        d.setBackgroundColor(getResources().getColor(R.color.amarelo));
        d.setTextColor(getResources().getColor(R.color.black));
        resposta = "D";
        selecionado = "d";

        confimacao(resposta);
    }

    // FERRAMENTAS =================================================================================

    public void popUP(String titulo, String msg){
        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setIcon(R.drawable.logo);
        pop.setTitle(titulo);
        pop.setMessage(msg);

        pop.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        pop.show();
    }

    /** Método pausa:
     * @param tempo Recebe um valor em milessegundos para definir o tempo de pausa.
     *
     * Método que cria uma pausa definida pelo tempo passado como parametro em milessegundos.
     * Tendo como execução o fecahemento da tela atual através do método finish().
     */
    public void pausa(int tempo){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                som.stop();
                finish();
            }
        }, tempo);
    }


    /** Esse método faz com que as cores dos botões retornem ao padrão do jogo eliminando a seleção
     * atual. Ele leva em consideração se algum botão que representa uma opção de resposta foi eliminado
     * isso é feito pela condição que verifica se os atributos eliminado1, 2 ou 3 estão com algum
     * valor atribuido.
     * @param play Parametro que indica se o som deve ser executado;
     */
    public void limparSelecao(boolean play) {

        if(play == true) {
            // Comando para execultar um som;
            som.stop();
            som = MediaPlayer.create(this, R.raw.frase_respondemos);
            som.start();
        }

        // Condição que verifica se algum dos botões foram eliminados, caso sim, a cor cinza não muda.
        // Essa cor cinza é atribuida no método cartas.
        if(! eliminado1.equals("a")){
            if(! eliminado2.equals("a")){
                if(! eliminado3.equals("a")){
                    a.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    a.setTextColor(getResources().getColor(R.color.white));
                    a.setEnabled(true);
                }
            }
        }

        if(! eliminado1.equals("b")){
            if(! eliminado2.equals("b")){
                if(! eliminado3.equals("b")){
                    b.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    b.setTextColor(getResources().getColor(R.color.white));
                    b.setEnabled(true);
                }
            }
        }

        if(! eliminado1.equals("c")){
            if(! eliminado2.equals("c")){
                if(! eliminado3.equals("c")){
                    c.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    c.setTextColor(getResources().getColor(R.color.white));
                    c.setEnabled(true);
                }
            }
        }

        if(! eliminado1.equals("d")){
            if(! eliminado2.equals("d")){
                if(! eliminado3.equals("d")){
                    d.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    d.setTextColor(getResources().getColor(R.color.white));
                    d.setEnabled(true);
                }
            }
        }

    }


    /** Esse método gera um popup na tela para que o jogador confirme se está certo da resposta dada,
     * ele pode voltar para poder escolher uma outra resposta fazendo com que o programa limpe a
     * seleção atual no método limparSelecao().
     * Caso ele esteja certo da resposta o botão sim, chama o método verificaResposta() e passa como
     * parametro o valor da rodada, a resposta certa e a resposta do jogador.
     * @param r Parametro que recebe a resposta dada pelo jogador;
     */
    public void confimacao(String r) {
        // Comando para execultar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_pergunta);
        som.start();

        // Intanciamento da classe que permite o uso de caixas de dialogo;
        AlertDialog.Builder pop = new AlertDialog.Builder(this);

        // Personalização da caixa;
        pop.setTitle("Confirmação"); // Titulo;
        pop.setIcon(R.drawable.logo); // Icone ou imagem;
        pop.setMessage("Você está certo disso?"); // Mensagem;

        // Botão que confirma a resposta;
        pop.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                verificaResposta(rodada, respCerta, r);
            }
        });

        // Botão que cancela a resposta atual;
        pop.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                limparSelecao(true);
            }
        });

        // Comando que mostra a janela de dialogo;
        pop.show();

    }


    /** Esse método verifica qual o valor da rodada. De acordo com a rodada é chamado o método da
     * proxima rodada que gera uma nova pergunta e tudo mais relacionado ao jogo.
     *
     * A primeira condição define o nivel atual das perguntas e o indice do sorteio, a cada 5 rodadas
     * esses dados mudam para que as perguntas do proximo nivel comece a ser sorteadas.
     *
     * A segunda condição faz o jogo avança para a proxima rodada sendo um total de 16 até a pergunta
     * final.
     */
    public void nivel() {

        Perguntas dados = new Perguntas();

        // Condição que define o nivel das perguntas e o indice do sorteio;
        if(rodada <= 5){
            //indice = dados.setSorteio(dados.perguntasNivel1);
            indice = dados.setIndice();
            nivelPergunta = dados.perguntasNivel1;
        } else if(rodada <= 10){
            //indice = dados.setSorteio(dados.perguntasNivel2);
            indice = dados.setIndice();
            nivelPergunta = dados.perguntasNivel2;
        } else if(rodada <= 15){
            //indice = dados.setSorteio(dados.perguntasNivel3);
            indice = dados.setIndice();
            nivelPergunta = dados.perguntasNivel3;
        } else if(rodada == 16){
            //indice = dados.setSorteio(dados.perguntasNivel4);
            indice = dados.setIndice();
            nivelPergunta = dados.perguntasNivel4;
        }

        // Essa condição faz com que o programa mostra uma nova pergunta a cada rodada;
        if(rodada == 2){
            rodada2();
        } else if(rodada == 3){
            rodada3();
        } else if(rodada == 4){
            rodada4();
        } else if(rodada == 5){
            rodada5();
        }
        // Continuar até a rodada 16....
    }


    /** Esse método define o valor do premio atual do jogo baseado na rodada em que o jogo está.
     * Ele também avalia as opções se o jogador parar ou errar uma pergunta. O valor da rodada é
     * usado como posição do indice que dentro da lista premio tem as posições definidas.
     */
    public void premiacao(){

        if(rodada == 1){
            errar = premio[0];
            parar = premio[0];
            acertar = premio[rodada];
        } else if(rodada == 2){
            errar = premio[0];
            parar = premio[rodada -1];
            acertar = premio[rodada];
        } else if(rodada > 2){
            errar = premio[rodada -2];
            parar = premio[rodada -1];
            acertar = premio[rodada];
        }

        // Premiação;
        txtErrar.setText(errar);
        txtParar.setText(parar);
        txtAcertar.setText(acertar);
    }


    /** Esse método recebe a resposta do jogador e compara com a resposta certa. Se a resposta estiver
     * correta o método limpa os valores dos atributos eliminado 1, 2 e 3 e limpa a seleção dos
     * botões com o método limparSelecao(), depois adiciona +1 a rodada e chama o método nível que
     * vai levar a proxima pergunta.
     * Caso a resposta esteja errada o jogador será levado a tela que mostra o resultado.
     * @param rod Parametro que recebe o valor da rodada atual;
     * @param rc Parametro que recebe a resposta certa gerada pela classe Perguntas;
     * @param r Parametro que recebe a resposta selecionada pelo jogador;
     */
    public void verificaResposta(int rod, String rc, String r) {
        respCerta = rc;
        resposta = r;
        rodada = rod;

        if(resposta.equals(respCerta)) {
            // Comando para executar o som;
            som.stop();
            som = MediaPlayer.create(this, R.raw.frase_acerto);
            som.start();

            // Limpa a seleção atual;
            eliminado1 = "";
            eliminado2 = "";
            eliminado3 = "";
            limparSelecao(false);

            // Verifica qual o proximo nivel da rodada;
            rodada += 1;
            nivel();

        } else {
            // Comando para executar o som;
            som.stop();
            som = MediaPlayer.create(this, R.raw.frase_erro);
            som.start();

            // Aqui vai ser chamado o método para o fim do jogo!
        }

    }


    // AJUDAS ======================================================================================

    /** Método que permite ao jogador efetuar o pulo da pergunta. O jogo começa com 3 pulos e a cada
     * pulo o valor recebe -1.
     * Ao clicar no botão pular uma janela de confirmação é exibida dando a possibilidade de voltar
     * a pergunta atual. Caso o jogador clique em sim é gerado uma nova pergunta, essa ação ocorre
     * da mesma forma que uma pergunta normal do jogo, passando o parametro com o nivel da pergunta
     * e o indice. Quando o jogador utiliza os 3 pulos o botão de pular é desativado.
     * @param view Parametro que permite a associação do método com o botão;
     *
     * NOTA: Assim como nas rodadas, a cada 5 rodadas o nível do jogo muda, então as perguntas
     *       geradas para o pulo acompanham o nivel de perguntas atual do jogo, sendo atualizadas
     *       a cada 5 rodadas.
     */
    public void setPulo(View view) {
        // Comando para executar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_pular);
        som.start();

        if(pular == 1){
            btnPular.setEnabled(false);
            btnPular.setImageResource(R.drawable.pular2);
        }

        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("Confirmação!");
        pop.setIcon(R.drawable.logo);
        pop.setMessage("Você realmente deseja pular essa pergunta?");

        pop.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        pop.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pular -= 1;

                Perguntas dados = new Perguntas();

                int numIndice = indice.indexOf(5);

                if(pular == 3){
                    numIndice = indice.indexOf(5);
                } else if(pular == 2){
                    numIndice = indice.indexOf(6);
                } else if(pular == 1){
                    numIndice = indice.indexOf(7);
                }

                pergunta = dados.setNivel(nivelPergunta, numIndice);
                // Teste -->> Toast.makeText(TelaPrincipal.this, "Indice: "+ numIndice, Toast.LENGTH_LONG).show();
                formatacaoPergunta(pergunta);
            }
        });

        pop.show();

    }

    /** Esse método gera um numero aleatorio de 0 a 3. Esse valor é passado como parametro usando
     * o intent junto com a chamada da Activity Cartas, essa Activity permite ao jogador escolher
     * uma carta que vai mostrar o valor gerado aletoriamente como sendo o numero de respostas a
     * serem eliminadas do jogo. A Activity Cartas se fecha apos o uso e retorna para a Tela Principal
     * aonde várias condições são analizadas para verificar a quantidade de respostas que serão
     * bloqueadas e terão as cores do botão alterados para indicar que foram eliminadas.
     * @param view Parametro para o método ser usado com o botão no layout;
     */
    public void clickCartas(View view) {
        cartas = random.nextInt(4);

        //Toast.makeText(this, "Resposta Certa: "+ resCerta, Toast.LENGTH_LONG).show();

        // Chama a tela das cartas e passagem do valor do sorteio;
        intent = new Intent(this, Cartas.class);
        intent.putExtra("valor", cartas);
        startActivity(intent);

        // Boqueia e muda a imagem do botão cartas;
        btnCartas.setEnabled(false);
        btnCartas.setImageResource(R.drawable.cartas2);

        // Condição que define as respostas a serem eliminadas;
        if (respCerta.equals("A")) {
            if (cartas == 1) {
                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado1 = "c";

            } else if (cartas == 2) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado2 = "d";

            } else if (cartas == 3) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado3 = "d";
            }
            //====================================================================================
        } else if (respCerta.equals("B")) {
            if (cartas == 1) {
                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado1 = "d";

            } else if (cartas == 2) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

            } else if (cartas == 3) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado3 = "d";
            }
        } else if (respCerta.equals("C")) {
            if (cartas == 1) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

            } else if (cartas == 2) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado2 = "d";

            } else if (cartas == 3) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado2 = "b";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado3 = "d";
            }
        } else if (respCerta.equals("D")) {
            if (cartas == 1) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

            } else if (cartas == 2) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

            } else if (cartas == 3) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado2 = "b";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado3 = "c";
            }
        }
    }

    // FORMATAÇÃO DAS PERGUNTAS ====================================================================

    /** Esse método recebe como um parametro vindo da rodada, esse parametro é a pergunta que foi
     * gerada na classe Perguntas.
     * O texto vem sem formatação tendo apenas a separação da pergunta, opções de resposta e a
     * resposta separada por posição, esse método utiliza essa posição para distribuir os texto
     * no layout da tela. Ele também adiciona ao atributo respCerta a opção correta entre A, B, C ou D.
     * por fim ele chama o método premiacao() que mostra o valor do premio atual do jogo a cada rodada.
     */
    public void formatacaoPergunta(ArrayList<String> pergunta){

        // Formatação dos dados adicionando-os aos botões;
        txtPergunta.setText(pergunta.get(0));
        a.setText(pergunta.get(1));
        b.setText(pergunta.get(2));
        c.setText(pergunta.get(3));
        d.setText(pergunta.get(4));
        respCerta = pergunta.get(5);

        // Premiação;
        premiacao();
    }

    // PERGUNTAS POR RODADAS =======================================================================

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada1() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_1mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.indexOf(0));
        // teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(0), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada2() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_2mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.indexOf(1));
        // teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(1), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada3() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_3mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.indexOf(2));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(2), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada4() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_4mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.indexOf(3));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(3), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada5() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_5mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.indexOf(4));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    // É PRECISO CONTINUAR ATÉ A RODADA 16 --->>>>

}