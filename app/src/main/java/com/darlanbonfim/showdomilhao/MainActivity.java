package com.darlanbonfim.showdomilhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    Intent tela;
    MediaPlayer som;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Comando para ocultar a barra superior do celular;
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        som = MediaPlayer.create(MainActivity.this, R.raw.abertura);
        som.start();

    }

    /**
     * Método que faz com que a barra superior e inferior do celular seja oculta, assim a aplicação
     * ocupa a tela inteira. Porém ao clicar em qualquer lugar da tela as barras voltam a aparecer.
     */
    private void setSystemUiVisibility() {
        View decorView = getWindow().getDecorView();
        // Hide both the navigation bar and the status bar.
        // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
        // a general rule, you should design your app to hide the status bar whenever you
        // hide the navigation bar.
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }


    public void setTelaCadastro(View view) {
        som.stop();
        tela = new Intent(this, TelaCadastro.class);
        startActivity(tela);
        finish();
    }
}