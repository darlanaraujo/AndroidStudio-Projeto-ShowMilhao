package com.darlanbonfim.showdomilhao;

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