package com.darlanbonfim.showdomilhao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

public class Cartas extends AppCompatActivity {

    ImageButton btnCarta0, btnCarta1, btnCarta2, btnCarta3;
    TextView txtFrase;
    MediaPlayer som;
    Intent intent;

    int valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartas);

        txtFrase = findViewById(R.id.txtFrase);

        btnCarta0 = findViewById(R.id.btnCarta0);
        btnCarta1 = findViewById(R.id.btnCarta1);
        btnCarta2 = findViewById(R.id.btnCarta2);
        btnCarta3 = findViewById(R.id.btnCarta3);

        som = MediaPlayer.create(this, R.raw.frase_cartas);
        som.start();

        intent = getIntent();
        valor = intent.getExtras().getInt("valor");

    }

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

    public void janela(String txt) {

        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("Ajuda das Cartas!");
        pop.setIcon(R.drawable.logo);
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

    public String Teste() {
        String nome = "Darlan";

        return nome;
    }

}