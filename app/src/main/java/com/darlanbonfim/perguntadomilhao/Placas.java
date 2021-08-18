package com.darlanbonfim.perguntadomilhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Placas extends AppCompatActivity {

    TextView txtMsgParticipantes;
    ImageView imgPlaca1, imgPlaca2, imgPlaca3, imgVoto1, imgVoto2, imgVoto3;
    Button btnVoltar2;

    Intent intent;
    MediaPlayer som;

    String respCerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_placas);

        txtMsgParticipantes = findViewById(R.id.txtMsgParticipantes);
        imgPlaca1 = findViewById(R.id.imgPlaca1);
        imgPlaca2 = findViewById(R.id.imgPlaca2);
        imgPlaca3 = findViewById(R.id.imgPlaca3);
        imgVoto1 = findViewById(R.id.imgVoto1);
        imgVoto2 = findViewById(R.id.imgVoto2);
        imgVoto3 = findViewById(R.id.imgVoto3);
        btnVoltar2 = findViewById(R.id.btnVoltar2);

        // Comando para ocultar os objetos;
        imgPlaca1.setVisibility(View.INVISIBLE);
        imgPlaca2.setVisibility(View.INVISIBLE);
        imgPlaca3.setVisibility(View.INVISIBLE);
        imgVoto1.setVisibility(View.INVISIBLE);
        imgVoto2.setVisibility(View.INVISIBLE);
        imgVoto3.setVisibility(View.INVISIBLE);
        btnVoltar2.setVisibility(View.INVISIBLE);

        // Comando que recebe a resposta certa como parametro e passa para o atributo respCerta;
        intent = getIntent();
        respCerta = intent.getExtras().getString("resposta");

        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_colegas);
        som.start();

        // Comando que chama os métodos dos votos, dando um retardo no tempo de 3s para cada voto;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Voto1();

                // 3s - Tempo para mostrar o voto2();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Voto2();

                        // 3s - Tempo para mostrar o voto3();
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Comando para executar um som;
                                som = MediaPlayer.create(Placas.this, R.raw.frase_dificil_ajuda);
                                som.start();

                                Voto3();

                                // 2s - Tempo para mostrar o botão voltar;
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        btnVoltar2.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                finish();
                                            }
                                        });
                                    }
                                }, 1000);
                            }
                        }, 1500);

                    }
                }, 1500);

            }
        },1500);

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

    /** Esse método mostra a placa e a resposta dos participantes quando o jogador solicita a ajuda
     * das placas.
     * O voto1() sempre mostra a resposta certa.
     * O voto2() só mostra a resposta certa se for A ou C.
     * O voto3() só mostra a resposta certa se for B ou D.
     *
     * Isso é para que as placas mudem o lado que acompanha o primeiro voto, assim o jogo fica mais
     * interativo.
     *
     * Depois da condição é gerado um retardo no tempo para mostrar a placa e depois a resposta.
     */
    public void Voto1(){

        // Condição que determina a imagem do voto de acordo com a resposta certa;
        if(respCerta.equals("A")){
            imgVoto1.setImageResource(R.drawable.icon_btn_a);
        } else if(respCerta.equals("B")){
            imgVoto1.setImageResource(R.drawable.icon_btn_b);
        } else if(respCerta.equals("C")){
            imgVoto1.setImageResource(R.drawable.icon_btn_c);
        } else if(respCerta.equals("D")){
            imgVoto1.setImageResource(R.drawable.icon_btn_d);
        }

        // Comando que retarda o tempo em 1.5 segundos para mostrar a placa e mais 0.5 seg para mostrar a resposta
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txtMsgParticipantes.setVisibility(View.INVISIBLE); // Oculta o texto;

                imgPlaca1.setVisibility(View.VISIBLE); // Mostra a placa;

                // Como que retarda o tempo para mostrar a resposta;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgVoto1.setVisibility(View.VISIBLE); // Mostra a resposta;
                    }
                }, 500);
            }
        }, 1500);


    }

    /** Esse método mostra a placa e a resposta dos participantes quando o jogador solicita a ajuda
     * das placas.
     * O voto1() sempre mostra a resposta certa.
     * O voto2() só mostra a resposta certa se for A ou C.
     * O voto3() só mostra a resposta certa se for B ou D.
     *
     * Isso é para que as placas mudem o lado que acompanha o primeiro voto, assim o jogo fica mais
     * interativo.
     *
     * Depois da condição é gerado um retardo no tempo para mostrar a placa e depois a resposta.
     */
    public void Voto2(){

        // Condição que determina a imagem do voto de acordo com a resposta certa;
        if(respCerta.equals("A")){
            imgVoto2.setImageResource(R.drawable.icon_btn_a); // Certa
        } else if(respCerta.equals("B")){
            imgVoto2.setImageResource(R.drawable.icon_btn_a); // Errada
        } else if(respCerta.equals("C")){
            imgVoto2.setImageResource(R.drawable.icon_btn_c); // Certa
        } else if(respCerta.equals("D")){
            imgVoto2.setImageResource(R.drawable.icon_btn_c); // Errada
        }

        // Comando que retarda o tempo em 1.5 segundos para mostrar a placa e mais 0.5 seg para mostrar a resposta
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgPlaca2.setVisibility(View.VISIBLE); // Mostra a placa;

                // Como que retarda o tempo para mostrar a resposta;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgVoto2.setVisibility(View.VISIBLE); // Mostra a resposta;
                    }
                }, 500);
            }
        }, 1500);
    }

    /** Esse método mostra a placa e a resposta dos participantes quando o jogador solicita a ajuda
     * das placas.
     * O voto1() sempre mostra a resposta certa.
     * O voto2() só mostra a resposta certa se for A ou C.
     * O voto3() só mostra a resposta certa se for B ou D.
     *
     * Isso é para que as placas mudem o lado que acompanha o primeiro voto, assim o jogo fica mais
     * interativo.
     *
     * Depois da condição é gerado um retardo no tempo para mostrar a placa e depois a resposta.
     */
    public void Voto3(){

        // Condição que determina a imagem do voto de acordo com a resposta certa;
        if(respCerta.equals("A")){
            imgVoto3.setImageResource(R.drawable.icon_btn_b); // Errada
        } else if(respCerta.equals("B")){
            imgVoto3.setImageResource(R.drawable.icon_btn_b); // Certa
        } else if(respCerta.equals("C")){
            imgVoto3.setImageResource(R.drawable.icon_btn_d); // Errada
        } else if(respCerta.equals("D")){
            imgVoto3.setImageResource(R.drawable.icon_btn_d); // Certa
        }

        // Comando que retarda o tempo em 1.5 segundos para mostrar a placa e mais 0.5 seg para mostrar a resposta
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                imgPlaca3.setVisibility(View.VISIBLE); // Mostra a placa;

                // Como que retarda o tempo para mostrar a resposta;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        imgVoto3.setVisibility(View.VISIBLE); // Mostra a resposta;

                        btnVoltar2.setVisibility(View.VISIBLE); // Mostra o botão voltar;
                    }
                }, 500);
            }
        }, 1500);
    }

}