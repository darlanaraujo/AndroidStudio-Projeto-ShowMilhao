package com.darlanbonfim.perguntadomilhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TelaCadastro extends AppCompatActivity {

    EditText editNome;
    Intent tela;

    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        editNome = findViewById(R.id.editNome);

        // Chamada do som;
        MediaPlayer somParticipante = MediaPlayer.create(this, R.raw.frase_participante);
        somParticipante.start();
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

    public void setSalvar(View view) {

        boolean dadosOk = true;

        if(editNome.getText().toString().trim().isEmpty()){
            dadosOk = false;
            editNome.setError(getString(R.string.txtTextoVazio));
            Toast.makeText(this, R.string.txtTextoVazio, Toast.LENGTH_LONG).show();
        }

        if(dadosOk) {

            nome = editNome.getText().toString().toUpperCase();

            tela = new Intent(this, TelaPrincipal.class);
            tela.putExtra("nome", nome);
            startActivity(tela);
            finish();
        }

    }

}