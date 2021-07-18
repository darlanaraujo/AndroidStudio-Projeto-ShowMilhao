package com.darlanbonfim.showdomilhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Convidados extends AppCompatActivity {

    TextView txtMsgConvidados;
    ImageView imgConvidados, imgResCerta;
    Button btnVoltar;
    Intent intent;

    MediaPlayer som;

    String respCerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convidados);

        txtMsgConvidados = findViewById(R.id.txtMsgConvidados);
        imgResCerta = findViewById(R.id.imgResCerta);
        imgConvidados = findViewById(R.id.imgParticipantes);
        btnVoltar = findViewById(R.id.btnVoltar);

        Convidados();

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void Convidados(){
        // Comando para gerar um som no jogo;
        som = MediaPlayer.create(Convidados.this, R.raw.frase_convidados);
        som.start();

        // Comando que esconde o botão voltar e a resposta certa;
        btnVoltar.setVisibility(View.INVISIBLE);
        imgResCerta.setVisibility(View.INVISIBLE);

        // Comando que mostra a primeira imagem dos convidados;
        imgConvidados.setImageResource(R.drawable.img_convidados2);

        // Comando que recebe a resposta correta vindo da Tela Principal;
        intent = getIntent();
        respCerta = intent.getExtras().getString("resposta");

        // Condição que determina qual a imagem da resposta certa;
        if(respCerta.equals("A")){
            imgResCerta.setImageResource(R.drawable.icon_a_m);
        } else if(respCerta.equals("B")){
            imgResCerta.setImageResource(R.drawable.icon_b_m);
        } else if(respCerta.equals("C")){
            imgResCerta.setImageResource(R.drawable.icon_c_m);
        } else if(respCerta.equals("D")){
            imgResCerta.setImageResource(R.drawable.icon_d_m);
        }


        // Comando que gera um tempo antes de mostrar a resposta dos convidados;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                som.stop();
                som = MediaPlayer.create(Convidados.this, R.raw.frase_dificil_ajuda);
                som.start();

                // Comando que troca o texto dos convidados;
                txtMsgConvidados.setText("A resposta dos convidados é:");
                // Comando que trocca a imagem dos convidados;
                imgConvidados.setImageResource(R.drawable.img_convidados);
                // Comando que mostra a resposta certa;
                txtMsgConvidados.setTextColor(getResources().getColor(R.color.secundaria));
                imgResCerta.setVisibility(View.VISIBLE);

                // Comando que gera um tempo antes de mostrar o botão de voltar;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnVoltar.setVisibility(View.VISIBLE);
                    }
                },1500);

            }
        }, 5000);

    }

}