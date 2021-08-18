package com.darlanbonfim.perguntadomilhao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.os.Handler;

public class Cartas extends AppCompatActivity {

    ImageButton btnCarta0, btnCarta1, btnCarta2, btnCarta3;
    TextView txtFrase, txtTimer;
    MediaPlayer som;
    Intent intent;

    int valor; // Atributo que recebe o valor vindo da Tela Principal. Esse valor vai definir o valor dado a carta sorteada.

    TelaPrincipal dados = new TelaPrincipal();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartas);

        txtFrase = findViewById(R.id.txtFrase);

        btnCarta0 = findViewById(R.id.btnCarta0);
        btnCarta1 = findViewById(R.id.btnCarta1);
        btnCarta2 = findViewById(R.id.btnCarta2);
        btnCarta3 = findViewById(R.id.btnCarta3);

        // Comando para gerar um som ao programa;
        //som.stop();
        som = MediaPlayer.create(this, R.raw.frase_cartas);
        som.start();

        // Comando que recebe o valor vindo da Tela Principal e passado para o atributo valor;
        intent = getIntent();
        valor = intent.getExtras().getInt("valor");

    }

    // Método que faz com que o App oculpe a tela inteira
    @Override
    protected void onResume() {
        super.onResume();

        // Comandoqueocultaabarradenavegação;
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // Ocultaabarrainferior
                // | View.SYSTEM_UI_FLAG_FULLSCREEN // Ocultaabarrasuperior;
                //|View.SYSTEM_UI_FLAG_IMMERSIVE // Faz a barra inferior aparecer permanete se passar o dedo debaixo para cima na tela;
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY; // Faz a barra inferior aparecer por algum tempo se passar o dedo debaixo para cima na tela;

        decorView.setSystemUiVisibility(uiOptions);

    }

    /** Esse método gera várias condições que avaliam o valor da carta. De acordo com esse valor
     * o método janela() é chamado para exibir um popup na tela que vai mostrar um texto personalizado.
     * Ao escolher uma das cartas o método faz com que as outras sejam bloqueadas para o jogador.
     * @param view Parametro que posibilita a chamada do método pelo botão no layout;
     */
    public void clickCarta0(View view){
        //valor = intent.getExtras().getInt("valor");

        if(valor == 0){
            btnCarta0.setImageResource(R.drawable.img_carta0);
            janela("Que pena, você tirou um ZERO!");
            //Toast.makeText(this, "Que pena, você tirou um ZERO!", Toast.LENGTH_LONG).show();
        } else if(valor == 1){
            btnCarta0.setImageResource(R.drawable.img_carta1);
            janela("Hum... Você eliminou apenas UMA resposta!");
            //Toast.makeText(this, "Hum... Você eliminou apenas UMA resposta!", Toast.LENGTH_LONG).show();
        } else if(valor == 2){
            btnCarta0.setImageResource(R.drawable.img_carta2);
            janela("Boa... Você eliminou DUAS respostas!");
            //Toast.makeText(this, "Boa... Você eliminou DUAS respostas!", Toast.LENGTH_LONG).show();
        } else if(valor == 3){
            btnCarta0.setImageResource(R.drawable.img_carta3);
            janela("Parabéns!!! Você eliminou TRÊS respostas!");
            //Toast.makeText(this, "Parabéns!!! Você eliminou TRÊS respostas!", Toast.LENGTH_LONG).show();
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);

    }

    /** Esse método gera várias condições que avaliam o valor da carta. De acordo com esse valor
     * o método janela() é chamado para exibir um popup na tela que vai mostrar um texto personalizado.
     * Ao escolher uma das cartas o método faz com que as outras sejam bloqueadas para o jogador.
     * @param view Parametro que posibilita a chamada do método pelo botão no layout;
     */
    public void clickCarta1(View view){
        //valor = intent.getExtras().getInt("valor");

        if(valor == 0){
            btnCarta1.setImageResource(R.drawable.img_carta0);
            janela("Que pena, você tirou um ZERO!");
        } else if(valor == 1){
            btnCarta1.setImageResource(R.drawable.img_carta1);
            janela("Hum... Você eliminou apenas UMA resposta!");
        } else if(valor == 2){
            btnCarta1.setImageResource(R.drawable.img_carta2);
            janela("Boa... Você eliminou DUAS respostas!");
        } else if(valor == 3){
            btnCarta1.setImageResource(R.drawable.img_carta3);
            janela("Parabéns!!! Você eliminou TRÊS respostas!");
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);

    }

    /** Esse método gera várias condições que avaliam o valor da carta. De acordo com esse valor
     * o método janela() é chamado para exibir um popup na tela que vai mostrar um texto personalizado.
     * Ao escolher uma das cartas o método faz com que as outras sejam bloqueadas para o jogador.
     * @param view Parametro que posibilita a chamada do método pelo botão no layout;
     */
    public void clickCarta2(View view){
        //valor = intent.getExtras().getInt("valor");

        if(valor == 0){
            btnCarta2.setImageResource(R.drawable.img_carta0);
            janela("Que pena, você tirou um ZERO!");
        } else if(valor == 1){
            btnCarta2.setImageResource(R.drawable.img_carta1);
            janela("Hum... Você eliminou apenas UMA resposta!");
        } else if(valor == 2){
            btnCarta2.setImageResource(R.drawable.img_carta2);
            janela("Boa... Você eliminou DUAS respostas!");
        } else if(valor == 3){
            btnCarta2.setImageResource(R.drawable.img_carta3);
            janela("Parabéns!!! Você eliminou TRÊS respostas!");
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);

    }

    /** Esse método gera várias condições que avaliam o valor da carta. De acordo com esse valor
     * o método janela() é chamado para exibir um popup na tela que vai mostrar um texto personalizado.
     * Ao escolher uma das cartas o método faz com que as outras sejam bloqueadas para o jogador.
     * @param view Parametro que posibilita a chamada do método pelo botão no layout;
     */
    public void clickCarta3(View view){
        //valor = intent.getExtras().getInt("valor");

        if(valor == 0){
            btnCarta3.setImageResource(R.drawable.img_carta0);
            janela("Que pena, você tirou um ZERO!");
        } else if(valor == 1){
            btnCarta3.setImageResource(R.drawable.img_carta1);
            janela("Hum... Você eliminou apenas UMA resposta!");
        } else if(valor == 2){
            btnCarta3.setImageResource(R.drawable.img_carta2);
            janela("Boa... Você eliminou DUAS respostas!");
        } else if(valor == 3){
            btnCarta3.setImageResource(R.drawable.img_carta3);
            janela("Parabéns!!! Você eliminou TRÊS respostas!");
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);

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


    /** Esse método gera uma janela de popup com algumas personalizações do jogo. Ele recebe um texto
     * que sera exibido e também chama o método pausa() que faz com que a Activity Cartas fique
     * aberta por um tempo e depois se elimine apos o jogador clicar no botão voltar.
     * @param txt Parametro que recebe um texto a ser exibido na janela de popup.
     */
    public void janela(String txt) {

        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("Ajuda das Cartas!");
        pop.setIcon(R.drawable.logo_jogo_preta);
        pop.setMessage(txt);

        pop.setNeutralButton("Voltar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pausa(1000);
                closeContextMenu();
            }
        });

        pop.show();
    }

}