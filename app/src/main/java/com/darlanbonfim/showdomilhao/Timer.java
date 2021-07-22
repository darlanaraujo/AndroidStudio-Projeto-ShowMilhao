package com.darlanbonfim.showdomilhao;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.Toast;

import java.util.Calendar;

public class Timer extends CountDownTimer {

    private Context context; // Atributo que recebe o contexto atual (ou a tela atual)
    private TextView txtTimer; // Atributo que define o TextView da tela que vai mostrar o relogio;
    private long millisInFuture; // Atributo que determina o tempo da contagem;
    private long countDownInterval; // Atributo que determina o intervalo da contagem;

    Intent intent;
    MediaPlayer som;

    String premio;
    String jogador;

    /**
     * @param context           Esse parametro recebe o contexto atual. Por exemplo, posso passar
     *                          a tela atual que estou usando para chamar o método.
     *
     * @param txtTimer           Esse parametro passa o TextView (o texto) que está na tela e que vai
     *                          mostrar o tempo.
     *
     * @param millisInFuture    Esse parametro é que determina o tempo do time. Por exemplo 30 segundos.
     *
     * @param countDownInterval Esse parametro é que determina o intervalo. Por exemplo, quero que
     *                          o intervalo seja de 1 segundo.
     */
    public Timer(Context context, TextView txtTimer, long millisInFuture, long countDownInterval, String valor, String nome) {

        // Chamada da classe pai passando os parametro de tempo e intervalo;
        super(millisInFuture, countDownInterval);

        this.txtTimer = txtTimer; // Esse comando é só para não deixar o atributo nullo
        this.context = context; // Esse comando é só para não deixar o atributo nullo
        premio = valor;
        jogador = nome;

    }

    @Override
    public void onTick(long millisUntilFinished) {
        // Esse método é chamada e recebe como parametro o tempo do time;
        txtTimer.setText(getCorrectTime(true, millisUntilFinished)+":"+getCorrectTime(false, millisUntilFinished));

        countDownInterval = millisUntilFinished;
    }

    @Override
    public void onFinish() {
        // Esse método é chamado quando termina o time;

        // Atributo que determina o tempo recebe -1 segundo;
        millisInFuture -= 1000;

        if(millisInFuture <= 10){
            txtTimer.setTextColor(Color.RED);
        }

        // Chamada do textView que mostra o tempo na tela;
        txtTimer.setText(getCorrectTime(false, millisInFuture)+":"+getCorrectTime(false, millisInFuture));

        som = MediaPlayer.create(context, R.raw.frase_acabou_tempo);
        som.start();

        // Aqui vai ser chamado a tela final que mostra o premio, uma vez que o tempo acabaou;
        AlertDialog.Builder pop = new AlertDialog.Builder(context);
        pop.setTitle("ACABOU O TEMPO!");
        pop.setIcon(R.drawable.logo);
        pop.setMessage("Que pena! Seu tempo acabou.");

        txtTimer.setText("00:00");

        pop.setPositiveButton("Finalizar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Inicia um novo audio;
                som = MediaPlayer.create(context, R.raw.frase_lombardi);
                som.start();

                // Instanciamento da tela Premio;
                intent = new Intent(context, TelaPremio.class);
                intent.putExtra("premio", premio); // Passagem de parametro do valor
                intent.putExtra("jogador", jogador);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        context.startActivity(intent);
                        try {
                            Timer.this.finalize();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                }, 1500);

            }
        });

        pop.show();

    }

    private String getCorrectTime(boolean isMinute, long millisUntilFinished){
        String aux; // Atributo que vai auxiliar ...

        /* Atributo que verifica uma condição:
         * Se o parametro isMinute for menos de 60 segundos o atributo recebe a constante de segundos
         * se for maior ou igual a 60 segundos o atributo recebe a constante de minutos
         *
         * Essa constante vem da biblioteca java.util.Calendar
         */

        int constCalendar = isMinute ? Calendar.MINUTE : Calendar.SECOND;

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(millisUntilFinished);

        /* O atributo aux recebe o atributo c com parametro da constante (minuto ou segundo)
         * se o valor passado for menor que 10 ele recebe um 0 na frente.
         * exemplo: 00:09
         */
        aux = c.get(constCalendar) < 10 ? "0" + c.get(constCalendar) : "" + c.get(constCalendar);



        return aux;
    }
}
