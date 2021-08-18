package com.darlanbonfim.perguntadomilhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class TelaPremio extends AppCompatActivity {

    TextView txtPremio;
    MediaPlayer som;
    Intent intent;

    String premio; // Atributo que vai receber o valor do premio do jogador;
    String jogador; // Atributo que vai receber o nome do jogador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_premio);

        txtPremio = findViewById(R.id.txtPremio);

        intent = getIntent();
        premio = intent.getExtras().getString("premio");
        jogador = intent.getExtras().getString("jogador");

        som = MediaPlayer.create(this, R.raw.abertura_continuacao);
        som.start();

        txtPremio.setText(premio);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                som.stop();
                intent = new Intent(getApplicationContext(), TelaRanking.class);
                intent.putExtra("premio", premio);
                intent.putExtra("jogador", jogador);
                startActivity(intent);
                finish();
            }
        }, 6000);

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