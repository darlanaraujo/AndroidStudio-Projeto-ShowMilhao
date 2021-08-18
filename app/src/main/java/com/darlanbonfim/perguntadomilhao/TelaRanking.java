package com.darlanbonfim.perguntadomilhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaRanking extends AppCompatActivity {

    TextView txtNomeLista, txtValorLista;
    Intent intent;
    MediaPlayer som;

    Button btnVoltarInicio;

    String jogador, premio; // Atributos que vao receber o nome e o valor ganho pelo jogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_ranking);

        txtNomeLista = findViewById(R.id.txtNomeLista);
        txtValorLista = findViewById(R.id.txtValorLista);
        btnVoltarInicio = findViewById(R.id.btnVoltarInicio);

        intent = getIntent();
        jogador = intent.getExtras().getString("jogador");
        premio = intent.getExtras().getString("premio");

        txtNomeLista.setText(jogador);
        txtValorLista.setText(premio);

        som = MediaPlayer.create(this, R.raw.abertura);
        som.start();

        btnVoltarInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                som.stop();
                intent = new Intent(TelaRanking.this, Inicio.class);
                startActivity(intent);
                finish();
            }
        });

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
}