package com.darlanbonfim.showdomilhao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent tela;
    MediaPlayer som;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Comando para ocultar a barra superior do celular;
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        // Comando que gera um som no jogo;
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
                finish();
            }
        }, tempo);
    }


    /** Esse método permite a chamada da tela de cadastro do jogador.
     * @param view Parametro que posibilita a chamada do método pelo botão no layout;
     */
    public void setTelaCadastro(View view) {
        som.stop();
        tela = new Intent(this, TelaCadastro.class);
        startActivity(tela);
        finish();
    }


    /** Esse método permite a chamada da tela que vai mostrar o ranking do jogo.
     * @param view Parametro que posibilita a chamada do método pelo botão no layout;
     */
    public void ranking(View view) {
        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("Comando em Construção!");
        pop.setIcon(R.drawable.logo);
        pop.setMessage("Essa parte do projeto ainda está em desenvolvimento");

        pop.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        pop.show();
    }

    /** Esse método permite ao jogador fechar o App.
     * @param view Parametro que posibilita a chamada do método pelo botão no layout;
     */
    public void finalizar(View view) {
        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("Confirmação");
        pop.setIcon(R.drawable.logo);
        pop.setMessage("Deseja sair do App?");

        pop.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        pop.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                som.stop();
                som = MediaPlayer.create(MainActivity.this, R.raw.frase_tchau);
                som.start();

                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                finish();
            }
        });

        pop.show();

    }

    public void finalizar(){



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        finish();
    }
}