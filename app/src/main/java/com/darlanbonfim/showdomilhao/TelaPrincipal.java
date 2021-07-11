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

public class TelaPrincipal extends AppCompatActivity {

    TextView txtNomeJogador, txtTime, txtPergunta, txtErrar, txtParar, txtAcertar;
    Intent intent;
    Button a, b, c, d;
    MediaPlayer som;
    ImageButton btnCartas, btnPlacas, btnConvidados, btnPular, btnParar;

    String resposta, resCerta;
    int rodada = 1;
    int errar, parar, acertar;
    String[] premio = {"R$ 0,00", "R$ 1.000", "R$ 2.000", "R$ 3.000"};

    // Atributos que recebe o valor gerado na tela de ajuda;
    int cartas;
    int convidados;
    int placas1;
    int pular = 3;

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

        // Comando para executar um som;
        //som = MediaPlayer.create(this, R.raw.frase_inicio);
        //som.start();

        rodada1();

    }

    public void opcaoA(View view) {
        a.setBackgroundColor(getResources().getColor(R.color.amarelo));
        a.setTextColor(getResources().getColor(R.color.black));
        resposta = "A";

        b.setBackgroundColor(getResources().getColor(R.color.secundaria));
        b.setTextColor(getResources().getColor(R.color.white));

        c.setBackgroundColor(getResources().getColor(R.color.secundaria));
        c.setTextColor(getResources().getColor(R.color.white));

        d.setBackgroundColor(getResources().getColor(R.color.secundaria));
        d.setTextColor(getResources().getColor(R.color.white));

        confimacao(resposta);

    }

    public void opcaoB(View view) {
        b.setBackgroundColor(getResources().getColor(R.color.amarelo));
        b.setTextColor(getResources().getColor(R.color.black));
        resposta = "B";

        a.setBackgroundColor(getResources().getColor(R.color.secundaria));
        a.setTextColor(getResources().getColor(R.color.white));

        c.setBackgroundColor(getResources().getColor(R.color.secundaria));
        c.setTextColor(getResources().getColor(R.color.white));

        d.setBackgroundColor(getResources().getColor(R.color.secundaria));
        d.setTextColor(getResources().getColor(R.color.white));

        confimacao(resposta);
    }

    public void opcaoC(View view) {
        c.setBackgroundColor(getResources().getColor(R.color.amarelo));
        c.setTextColor(getResources().getColor(R.color.black));
        resposta = "C";

        b.setBackgroundColor(getResources().getColor(R.color.secundaria));
        b.setTextColor(getResources().getColor(R.color.white));

        a.setBackgroundColor(getResources().getColor(R.color.secundaria));
        a.setTextColor(getResources().getColor(R.color.white));

        d.setBackgroundColor(getResources().getColor(R.color.secundaria));
        d.setTextColor(getResources().getColor(R.color.white));

        confimacao(resposta);
    }

    public void opcaoD(View view) {
        d.setBackgroundColor(getResources().getColor(R.color.amarelo));
        d.setTextColor(getResources().getColor(R.color.black));
        resposta = "D";

        b.setBackgroundColor(getResources().getColor(R.color.secundaria));
        b.setTextColor(getResources().getColor(R.color.white));

        c.setBackgroundColor(getResources().getColor(R.color.secundaria));
        c.setTextColor(getResources().getColor(R.color.white));

        a.setBackgroundColor(getResources().getColor(R.color.secundaria));
        a.setTextColor(getResources().getColor(R.color.white));

        confimacao(resposta);
    }

    public void time() {
        for(int c = 30; c >= 0; c--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            txtTime.setText(String.valueOf(c));
        }
    }

    public void limparSelecao(boolean play) {

        if(play == true) {
            // Comando para execultar um som;
            som.stop();
            som = MediaPlayer.create(this, R.raw.frase_respondemos);
            som.start();
        }

        a.setBackgroundColor(getResources().getColor(R.color.secundaria));
        a.setTextColor(getResources().getColor(R.color.white));

        b.setBackgroundColor(getResources().getColor(R.color.secundaria));
        b.setTextColor(getResources().getColor(R.color.white));

        c.setBackgroundColor(getResources().getColor(R.color.secundaria));
        c.setTextColor(getResources().getColor(R.color.white));

        d.setBackgroundColor(getResources().getColor(R.color.secundaria));
        d.setTextColor(getResources().getColor(R.color.white));
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
            Toast.makeText(this, "Em Construção!", Toast.LENGTH_LONG).show();
        }
    }

    public void premiacao(){

        if(rodada == 1){
            errar = 0;
            parar = 0;
            acertar = rodada;
        } else if(rodada == 2){
            errar = 0;
            parar = rodada -1;
            acertar = rodada;
        } else if(rodada > 2){
            errar = rodada -2;
            parar = rodada -1;
            acertar = rodada;
        }

        // Premiação;
        txtErrar.setText(premio[errar]);
        txtParar.setText(premio[parar]);
        txtAcertar.setText(premio[acertar]);
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
    public void clickCartas(View view){
        som.stop();
        Toast.makeText(this, "Resposta Certa: "+ resCerta, Toast.LENGTH_LONG).show();

        // Chama a tela das cartas;
        intent = new Intent(this, Cartas.class);
        startActivity(intent);

        // Boqueia e muda a imagem do botão cartas;
        btnCartas.setEnabled(false);
        btnCartas.setImageResource(R.drawable.cartas2);

        // Comando que recebe o valor da carta;


        if(resCerta.equals("A")){
            if(cartas == 1){
                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
            } else if(cartas == 2) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
            } else if(cartas == 3){
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
            }
        }

    }

    // PERGUNTAS ===================================================================================
    public void rodada1() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_1mil);
        som.start();

        txtPergunta.setText("Qual o nome do navegador que supostamente descobril o Brasil em 1500?");
        a.setText("A) Pedro Alvares Cabral");
        b.setText("B) Cristoval Colombo");
        c.setText("C) Vasco da Gama");
        d.setText("D) Dom pedro I");
        resCerta = "A";

        // Premiação;
        premiacao();
    }

    public void rodada2() {
        // Comando para executar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_2mil);
        som.start();

        txtPergunta.setText("Qual o nome do personagem biblico que foi engolido por um peixe ficando " +
                "em seu estomago por 3 dias?");
        a.setText("A) Daniel");
        b.setText("B) Sansão");
        c.setText("C) Jonas");
        d.setText("D) Pedro");
        resCerta = "C";

        // Premiação;
        premiacao();
    }

}