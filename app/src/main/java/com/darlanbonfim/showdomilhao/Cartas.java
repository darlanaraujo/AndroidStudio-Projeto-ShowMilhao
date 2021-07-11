package com.darlanbonfim.showdomilhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import java.util.Random;

public class Cartas extends AppCompatActivity {

    ImageButton btnCarta0, btnCarta1, btnCarta2, btnCarta3;
    TextView txtFrase;
    MediaPlayer som;

    Random random = new Random();

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

    }

    public void clickCarta0(View view){
        valor = random.nextInt(4);

        if(valor == 0){
            btnCarta0.setImageResource(R.drawable.img_carta0);
            Toast.makeText(this, "Que pena, você tirou um ZERO!", Toast.LENGTH_LONG).show();
        } else if(valor == 1){
            btnCarta0.setImageResource(R.drawable.img_carta1);
            Toast.makeText(this, "Hum... Você eliminou apenas UMA resposta!", Toast.LENGTH_LONG).show();
        } else if(valor == 2){
            btnCarta0.setImageResource(R.drawable.img_carta2);
            Toast.makeText(this, "Boa... Você eliminou DUAS respostas!", Toast.LENGTH_LONG).show();
        } else if(valor == 3){
            btnCarta0.setImageResource(R.drawable.img_carta3);
            Toast.makeText(this, "Parabéns!!! Você eliminou TRÊS respostas!", Toast.LENGTH_LONG).show();
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);

        // Comando para informar o valor da carta;


        pausa(3000);

    }

    public void clickCarta1(View view){
        valor = random.nextInt(4);

        if(valor == 0){
            btnCarta1.setImageResource(R.drawable.img_carta0);
            Toast.makeText(this, "Que pena, você tirou um ZERO!", Toast.LENGTH_LONG).show();
        } else if(valor == 1){
            btnCarta1.setImageResource(R.drawable.img_carta1);
            Toast.makeText(this, "Hum... Você eliminou apenas UMA resposta!", Toast.LENGTH_LONG).show();
        } else if(valor == 2){
            btnCarta1.setImageResource(R.drawable.img_carta2);
            Toast.makeText(this, "Boa... Você eliminou DUAS respostas!", Toast.LENGTH_LONG).show();
        } else if(valor == 3){
            btnCarta1.setImageResource(R.drawable.img_carta3);
            Toast.makeText(this, "Parabéns!!! Você eliminou TRÊS respostas!", Toast.LENGTH_LONG).show();
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);

        pausa(3000);

    }

    public void clickCarta2(View view){
        valor = random.nextInt(4);
        if(valor == 0){
            btnCarta2.setImageResource(R.drawable.img_carta0);
            Toast.makeText(this, "Que pena, você tirou um ZERO!", Toast.LENGTH_LONG).show();
        } else if(valor == 1){
            btnCarta2.setImageResource(R.drawable.img_carta1);
            Toast.makeText(this, "Hum... Você eliminou apenas UMA resposta!", Toast.LENGTH_LONG).show();
        } else if(valor == 2){
            btnCarta2.setImageResource(R.drawable.img_carta2);
            Toast.makeText(this, "Boa... Você eliminou DUAS respostas!", Toast.LENGTH_LONG).show();
        } else if(valor == 3){
            btnCarta2.setImageResource(R.drawable.img_carta3);
            Toast.makeText(this, "Parabéns!!! Você eliminou TRÊS respostas!", Toast.LENGTH_LONG).show();
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);

        pausa(3000);

    }

    public void clickCarta3(View view){
        valor = random.nextInt(4);
        if(valor == 0){
            btnCarta3.setImageResource(R.drawable.img_carta0);
            Toast.makeText(this, "Que pena, você tirou um ZERO!", Toast.LENGTH_LONG).show();
        } else if(valor == 1){
            btnCarta3.setImageResource(R.drawable.img_carta1);
            Toast.makeText(this, "Hum... Você eliminou apenas UMA resposta!", Toast.LENGTH_LONG).show();
        } else if(valor == 2){
            btnCarta3.setImageResource(R.drawable.img_carta2);
            Toast.makeText(this, "Boa... Você eliminou DUAS respostas!", Toast.LENGTH_LONG).show();
        } else if(valor == 3){
            btnCarta3.setImageResource(R.drawable.img_carta3);
            Toast.makeText(this, "Parabéns!!! Você eliminou TRÊS respostas!", Toast.LENGTH_LONG).show();
        }

        // Comando para desabilitar os botões depois de escolher uma carta;
        btnCarta0.setEnabled(false);
        btnCarta1.setEnabled(false);
        btnCarta2.setEnabled(false);
        btnCarta3.setEnabled(false);
        pausa(3000);

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

}