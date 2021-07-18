package com.darlanbonfim.showdomilhao;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.darlanbonfim.showdomilhao.databinding.ActivityInicioBinding;

public class Inicio extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityInicioBinding binding;

    Intent tela;
    Intent navegacao;
    MediaPlayer som;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityInicioBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarInicio.toolbar);
        binding.appBarInicio.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_inicio);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
        // =========================================================================================

        // Comando que gera um som no jogo;
        som = MediaPlayer.create(this, R.raw.abertura);
        som.start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_inicio);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
    // =============================================================================================

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
                som = MediaPlayer.create(Inicio.this, R.raw.frase_tchau);
                som.start();

                closeContextMenu();
                pausa(3000);

            }
        });

        pop.show();

    }

    public void creditos(View view){
        Toast.makeText(this, "Você será direcionado para o GitHub Darlan Araujo", Toast.LENGTH_LONG).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                navegacao = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/darlanaraujo?tab=repositories"));
                startActivity(navegacao);
            }
        }, 2000);

    }
}