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

import java.util.Random;

public class TelaPrincipal extends AppCompatActivity {

    TextView txtNomeJogador, txtTime, txtPergunta, txtErrar, txtParar, txtAcertar;
    Intent intent;
    Button a, b, c, d;
    MediaPlayer som;
    ImageButton btnCartas, btnPlacas, btnConvidados, btnPular, btnParar;

    String resposta, pergunta, opA, opB, opC, opD, resCerta;
    int rodada = 1;
    String errar, parar, acertar;
    String[] premio = {"R$ 0,00", "R$ 1.000", "R$ 2.000", "R$ 3.000", "R$ 4.000", "R$ 5.000",
                        "R$ 10.000", "R$ 20.000", "R$ 30.000", "R$ 40.000", "R$ 50.000",
                        "R$ 100.000", "R$ 200.000", "R$ 300.000", "R$ 400.000", "R$ 500.000",
                        "R$ 1.000.000"};

    // Atributos que recebe o valor gerado na tela de ajuda;
    int cartas;
    int convidados;
    int placas1;
    int pular = 3;

    String selecionado = "", eliminado1 = "", eliminado2 = "", eliminado3 = "";

    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

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
        rodada1();

    }

    public void opcaoA(View view) {
        a.setBackgroundColor(getResources().getColor(R.color.amarelo));
        a.setTextColor(getResources().getColor(R.color.black));
        resposta = "A";
        selecionado = "a";

        confimacao(resposta);
    }

    public void opcaoB(View view) {
        b.setBackgroundColor(getResources().getColor(R.color.amarelo));
        b.setTextColor(getResources().getColor(R.color.black));
        resposta = "B";
        selecionado = "b";

        confimacao(resposta);
    }

    public void opcaoC(View view) {
        c.setBackgroundColor(getResources().getColor(R.color.amarelo));
        c.setTextColor(getResources().getColor(R.color.black));
        resposta = "C";
        selecionado = "c";

        confimacao(resposta);
    }

    public void opcaoD(View view) {
        d.setBackgroundColor(getResources().getColor(R.color.amarelo));
        d.setTextColor(getResources().getColor(R.color.black));
        resposta = "D";
        selecionado = "d";

        confimacao(resposta);
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

    // FERRAMENTAS =================================================================================
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
                verificaResposta(rodada, resCerta, r);
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

    public void nivel() {
        if(rodada == 2){
            rodada2();
        } else if(rodada == 3){
            rodada3();
        } else if(rodada == 4){
            rodada4();
        } else if(rodada == 5){
            rodada5();
        }
    }

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
        //txtErrar.setText(premio[errar]);
        //txtParar.setText(premio[parar]);
        //txtAcertar.setText(premio[acertar]);
        txtErrar.setText(errar);
        txtParar.setText(parar);
        txtAcertar.setText(acertar);
    }

    public void verificaResposta(int rod, String rc, String r) {
        resCerta = rc;
        resposta = r;
        rodada = rod;

        if(resposta.equals(resCerta)) {
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
    public void clickCartas(View view) {
        cartas = random.nextInt(4);

        //Toast.makeText(this, "Resposta Certa: "+ resCerta, Toast.LENGTH_LONG).show();

        som.stop();

        // Chama a tela das cartas e passagem do valor do sorteio;
        intent = new Intent(this, Cartas.class);
        intent.putExtra("valor", cartas);
        startActivity(intent);

        // Boqueia e muda a imagem do botão cartas;
        btnCartas.setEnabled(false);
        btnCartas.setImageResource(R.drawable.cartas2);

        // Condição que define as respostas a serem eliminadas;
        if (resCerta.equals("A")) {
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
        } else if (resCerta.equals("B")) {
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
        } else if (resCerta.equals("C")) {
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
        } else if (resCerta.equals("D")) {
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

    // FORMATAÇÃO DAS PERGUNTAS POR NÍVEL ==========================================================
    public void formatacaoNivel1(){
        // Criação do objeto que recebe a classe Perguntas como instancia;
        Perguntas dados = new Perguntas();

        // Atribuição dos dados aos atributos;
        pergunta = dados.setPerguntaNivel1().get(0);
        opA = dados.setPerguntaNivel1().get(1);
        opB = dados.setPerguntaNivel1().get(2);
        opC = dados.setPerguntaNivel1().get(3);
        opD = dados.setPerguntaNivel1().get(4);

        // Formatação dos dados adicionando-os aos botões;
        txtPergunta.setText(pergunta);
        a.setText(opA);
        b.setText(opB);
        c.setText(opC);
        d.setText(opD);
        resCerta = dados.setPerguntaNivel1().get(5);

        // Premiação;
        premiacao();
    }

    public void formatacaoNivel2(){
        // Criação do objeto que recebe a classe Perguntas como instancia;
        Perguntas dados = new Perguntas();

        // Atribuição dos dados aos atributos;
        pergunta = dados.setPerguntaNivel2().get(0);
        opA = dados.setPerguntaNivel2().get(1);
        opB = dados.setPerguntaNivel2().get(2);
        opC = dados.setPerguntaNivel2().get(3);
        opD = dados.setPerguntaNivel2().get(4);

        // Formatação dos dados adicionando-os aos botões;
        txtPergunta.setText(pergunta);
        a.setText(opA);
        b.setText(opB);
        c.setText(opC);
        d.setText(opD);
        resCerta = dados.setPerguntaNivel2().get(5);

        // Premiação;
        premiacao();
    }

    // CONTINUAÇÃO DOS NIVEIS ATÉ O NÍVEL 5 ---->>>>>>>>>

    // PERGUNTAS POR RODADAS =======================================================================
    public void rodada1() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_1mil);
        som.start();

        // Chamada do método que faz o tratamento dos dados vindos da classe Perguntas;
        formatacaoNivel1();
    }

    public void rodada2() {
        // Comando para executar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_2mil);
        som.start();

        // Chamada do método que faz o tratamento dos dados vindos da classe Perguntas;
        formatacaoNivel1();
    }

    public void rodada3() {
        // Comando para executar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_3mil);
        som.start();

        // Chamada do método que faz o tratamento dos dados vindos da classe Perguntas;
        formatacaoNivel1();
    }

    public void rodada4() {
        // Comando para executar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_4mil);
        som.start();

        // Chamada do método que faz o tratamento dos dados vindos da classe Perguntas;
        formatacaoNivel1();
    }

    public void rodada5() {
        // Comando para executar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_5mil);
        som.start();

        // Chamada do método que faz o tratamento dos dados vindos da classe Perguntas;
        formatacaoNivel1();
    }

}