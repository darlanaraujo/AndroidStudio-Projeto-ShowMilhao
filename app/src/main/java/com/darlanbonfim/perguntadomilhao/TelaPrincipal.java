package com.darlanbonfim.perguntadomilhao;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class TelaPrincipal extends AppCompatActivity {

    TextView txtNomeJogador, txtTimer, txtPergunta, txtErrar, txtParar, txtAcertar;
    Intent intent, navegacao;
    Button a, b, c, d;
    MediaPlayer som;
    ImageButton btnCartas, btnPlacas, btnConvidados, btnPular, btnParar;

    String jogador; // Atributo que vai receber o nome do jogador vindo da tela Cadastro;

    ArrayList<String> pergunta; // Recebe a pergunta gerada pelo sistema na classe Perguntas;
    String resposta; // Recebe a resposta dada pelo jogador ao selecionar o botão A B C ou D;
    String respCerta = ""; // Recebe a resposta certa gerada pelo sistema na classe Perguntas;

    int rodada = 1; // Recebe +1 a cada pergunta certa registrando o numero da rodada atual;

    String[] premio = {"R$ 0,00", "R$ 1.000", "R$ 2.000", "R$ 3.000", "R$ 4.000", "R$ 5.000",
                        "R$ 10.000", "R$ 20.000", "R$ 30.000", "R$ 40.000", "R$ 50.000",
                        "R$ 100.000", "R$ 200.000", "R$ 300.000", "R$ 400.000", "R$ 500.000",
                        "R$ 1.000.000"};
    String errar = "R$ 0,00", parar = "R$ 0,00", acertar = "R$ 0,00"; // Recebe o valor do premio baseado no numero da rodada atual;
    String ganhou = "R$ 0,00";

    // Atributos que recebe o valor gerado na tela de ajuda;
    int valorCartas; // Recebe o valor sorteado pelas cartas para indicar quantas respostas serão eliminadas;

    // Atributos que defini o valor para cada ajuda no ínicio do jogo.
    int cartas = 1;
    int convidados = 1;
    int placas = 1;
    int pulos = 3;

    // Esse atributo recebe as opções a, b, c, ou d para indicar o botão que foi selecionado ou quais botões devem ser eliminados;
    String selecionado = "", eliminado1 = "", eliminado2 = "", eliminado3 = "";

    // Atributo que controla o tempo do jogo;
    private Timer timer; // Instanciamento da classe Timer
    private long start = 30*1000; // Atributo que recebe o tempo em milessegundos = 00:30 segundos;

    Random random = new Random(); // Objeto da classe random para gerar números aleatórios;

    //Integer[] indice; // Atributo que recebe 8 numeros aleatorios sem repetição gerado na classe Perguntas;
    ArrayList<Integer> indice; // Atributo que recebe 8 numeros aleatorios sem repetição gerado na classe Perguntas;
    String[] nivelPergunta; // Atributo que recebe o nivel atual das perguntas no jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        // Liagação dos atributos com os objetos no layout;
        a = findViewById(R.id.btnA);
        b = findViewById(R.id.btnB);
        c = findViewById(R.id.btnC);
        d = findViewById(R.id.btnD);
        txtPergunta = findViewById(R.id.txtPergunta);
        txtNomeJogador = findViewById(R.id.txtNomeJogador);

        txtTimer = findViewById(R.id.txtTimer);

        txtErrar = findViewById(R.id.txtErrar);
        txtParar = findViewById(R.id.txtParar);
        txtAcertar = findViewById(R.id.txtAcertar);

        btnCartas = findViewById(R.id.btnCartas);
        btnPlacas = findViewById(R.id.btnPlacas);
        btnConvidados = findViewById(R.id.btnConvidados);
        btnPular = findViewById(R.id.btnPular);
        btnParar = findViewById(R.id.btnParar);

        // Comando para receber um valor vindo de outra tela;
        intent = getIntent();
        jogador = intent.getExtras().getString("nome");

        // Comando para mostrar na tela o nome do jogador;
        txtNomeJogador.setText(jogador);

        // Início das perguntas;
        nivel();
        rodada1();

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

    // FERRAMENTAS PARA FINALIZAR O JOGO ===========================================================

    /** Esse método recebe um parametro com o tempo determinado para regreção. Fora do método a classe
     * Timer foi instanciada e criado um objeto timer. Esse objeto passa 6 parametros para a classe,
     * 1 - Contexto (que é a tela atual);
     * 2 - O TextView que vai mostrar o relógio;
     * 3 - O tempo da contagem regressiva. Ex: 30 segundos
     * 4 - O tempo de intervalo do tempo. Ex: 1 segundo;
     * 5 - O valor do premio atual do jogador;
     * 6 - O nome do jogador;
     * Os dois últimos parametros são usados caso a contagem regressiva acabe, ele passa esses
     * parametros para a tela de premiação;
     * @param tempo Parametro que recebe o tempo que será usado como regreção;
     */
    public void setTimer(long tempo){

        timer = new Timer(this, txtTimer, tempo, 1000, acertar, jogador);
        timer.start();

    }

    /** Esse método é chamado toda vez que a resposta do jogador é confirmada como correta ou
     * quando o jogo acaba.
     * Ele faz parar a contagem regressiva;
     */
    public void stopTimer(){
        timer.cancel();
    }

    /** Esse método é chamado ao termino do jogo, seja pelo tempo, na última resposta, ao errar a
     * pergunta ou o jogador parar o jogo.
     * Ele recebe como parametro o premio atual que pode ser quado erra, acerta ou para.
     * Ele chama a classe Tela Premio e passa o valor do premio e o nome do jogador como parametro
     * @param ganhou Parametro que recebe o valor do premio atual do jogador;
     */
    public void setFinal(String ganhou){
        // Comando para parar o tempo;
        stopTimer();

        // Para o som atual;
        som.stop();

        // Inicia um novo audio;
        som = MediaPlayer.create(this, R.raw.frase_lombardi);
        som.start();

        // Instanciamento da tela Premio;
        intent = new Intent(this, TelaPremio.class);
        intent.putExtra("premio", ganhou); // Passagem de parametro do valor
        intent.putExtra("jogador", jogador);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 1500);

    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoA(View view) {
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            a.setBackgroundColor(getResources().getColor(R.color.amarelo));
            a.setTextColor(getResources().getColor(R.color.black));
            resposta = "A"; // Valor atribuido ao botão que representa a escolha A;
            selecionado = "a"; // Esse atributo recebe esse valor indicando qual foi a opção selecionada;

            confirmacao(resposta); // Chamada do método que verifica se o usuário está certo da resposta;
        }

    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoB(View view) {
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            b.setBackgroundColor(getResources().getColor(R.color.amarelo));
            b.setTextColor(getResources().getColor(R.color.black));
            resposta = "B";
            selecionado = "b";

            confirmacao(resposta);
        }
    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoC(View view) {
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            c.setBackgroundColor(getResources().getColor(R.color.amarelo));
            c.setTextColor(getResources().getColor(R.color.black));
            resposta = "C";
            selecionado = "c";

            confirmacao(resposta);
        }
    }

    /** Esse método permite que o jogador faça a escolha da resposta referente a pergunta atual.
     * Ao clicar no botão a cor do fundo e do texto muda para dar destaque a seleção, o atributo
     * respota é preenchido com a escolha do botão (a, b, c ou d) assim também como o atributo
     * selecionado.
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * Depois é chamado o método de confirmação passando a resposta como parametro.
     * @param view Parametro que permite associar o método com o botão no layout;
     */
    public void opcaoD(View view) {
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            d.setBackgroundColor(getResources().getColor(R.color.amarelo));
            d.setTextColor(getResources().getColor(R.color.black));
            resposta = "D";
            selecionado = "d";

            confirmacao(resposta);
        }
    }

    // BOTÕES DAS AJUDAS ===========================================================================

    /** Esse método é o botão Cartas do jogo, ele chama o método setCartas() que executa o comando
     * par esse proposito, o método teve que ser criado separado para que pudesse ser usado em outro
     * momento do jogo, uma vez que não era possível chamar um método do botão com o parametro View
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * @param view Parametro que permite associar o método com o botão;
     */
    public void Cartas(View view){
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            // Chama o método setParar() que para o jogo;
            setCartas();
        }
    }

    /** Esse método é o botão Placas do jogo, ele chama o método setPlacas() que executa o comando
     * par esse proposito, o método teve que ser criado separado para que pudesse ser usado em outro
     * momento do jogo, uma vez que não era possível chamar um método do botão com o parametro View
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * @param view Parametro que permite associar o método com o botão;
     */
    public void Placas(View view){
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            // Chama o método setParar() que para o jogo;
            setPlacas();
        }
    }

    /** Esse método é o botão Convidados do jogo, ele chama o método setConvidados() que executa o comando
     * par esse proposito, o método teve que ser criado separado para que pudesse ser usado em outro
     * momento do jogo, uma vez que não era possível chamar um método do botão com o parametro View
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * @param view Parametro que permite associar o método com o botão;
     */
    public void Convidados(View view){
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            // Chama o método setParar() que para o jogo;
            setConvidados();
        }
    }

    /** Esse método é o botão Pular do jogo, ele chama o método setPular() que executa o comando
     * par esse proposito, o método teve que ser criado separado para que pudesse ser usado em outro
     * momento do jogo, uma vez que não era possível chamar um método do botão com o parametro View
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * @param view Parametro que permite associar o método com o botão;
     */
    public void Pular(View view){
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            // Chama o método setParar() que para o jogo;
            setPular();
        }
    }

    /** Esse método é o botão que para o jogo, ele chama o método setParar() que executa o comando
     * par esse proposito, o método teve que ser criado separado para que pudesse ser usado em outro
     * momento do jogo, uma vez que não era possível chamar um método do botão com o parametro View
     *
     * O método tem uma condição, ele verifica se a resposta certa está vazia, se estiver é por que
     * uma nova pergunta ainda não foi gerada, e assim impede o jogador de clicar no botão até que
     * isso ocorra.
     *
     * @param view Parametro que permite associar o método com o botão;
     */
    public void Parar(View view){
        // Condição que verifica se a resposta certa está vazia;
        if(respCerta.equals("")){
            // Mostra mensagem na tela;
            Toast.makeText(this, "Aguarde a pergunta ser gerada!", Toast.LENGTH_LONG).show();
        } else {
            // Chama o método setParar() que para o jogo;
            setParar();
        }
    }

    // FERRAMENTAS =================================================================================

    /** Esse método permite que um site seja aberto quando o jogador clicar no texto do crétido do
     * jogo.
     * @param view Parametro que permite associar o método com o botão;
     */
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

    /** Esse método faz com que os textos dos botões, o timer e da pergunta do jogo seja limpa antes
     * de chamar a proxima pergunta;
     */
    public void limparTextos(){
        // Limpa a seleção atual;
        eliminado1 = "";
        eliminado2 = "";
        eliminado3 = "";

        // Limpa o texto;
        txtPergunta.setText("Processando...");
        txtTimer.setText("00:00");
        a.setText("");
        b.setText("");
        c.setText("");
        d.setText("");
    }

    /** Esse método faz com que as cores dos botões retornem ao padrão do jogo eliminando a seleção
     * atual. Ele leva em consideração se algum botão que representa uma opção de resposta foi eliminado
     * isso é feito pela condição que verifica se os atributos eliminado1, 2 ou 3 estão com algum
     * valor atribuido.
     * @param play Parametro que indica se o som deve ser executado;
     */
    public void limparSelecao(boolean play) {

        if(play == true) {
            // Comando para execultar um som;
            som.stop();
            som = MediaPlayer.create(this, R.raw.frase_respondemos);
            som.start();
        }

        // Condição que verifica se algum dos botões foram eliminados, caso sim, a cor cinza não muda.
        // Essa cor cinza é atribuida no método cartas.
        if(! eliminado1.equals("a")){
            if(! eliminado2.equals("a")){
                if(! eliminado3.equals("a")){
                    a.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    a.setTextColor(getResources().getColor(R.color.white));
                    a.setEnabled(true);
                }
            }
        }

        if(! eliminado1.equals("b")){
            if(! eliminado2.equals("b")){
                if(! eliminado3.equals("b")){
                    b.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    b.setTextColor(getResources().getColor(R.color.white));
                    b.setEnabled(true);
                }
            }
        }

        if(! eliminado1.equals("c")){
            if(! eliminado2.equals("c")){
                if(! eliminado3.equals("c")){
                    c.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    c.setTextColor(getResources().getColor(R.color.white));
                    c.setEnabled(true);
                }
            }
        }

        if(! eliminado1.equals("d")){
            if(! eliminado2.equals("d")){
                if(! eliminado3.equals("d")){
                    d.setBackgroundColor(getResources().getColor(R.color.secundaria));
                    d.setTextColor(getResources().getColor(R.color.white));
                    d.setEnabled(true);
                }
            }
        }

    }


    /** Esse método gera um popup na tela para que o jogador confirme se está certo da resposta dada,
     * ele pode voltar para poder escolher uma outra resposta fazendo com que o programa limpe a
     * seleção atual no método limparSelecao().
     * Caso ele esteja certo da resposta o botão sim, chama o método verificaResposta() e passa como
     * parametro o valor da rodada, a resposta certa e a resposta do jogador.
     * @param r Parametro que recebe a resposta dada pelo jogador;
     */
    public void confirmacao(String r) {
        // Comando para execultar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_pergunta);
        som.start();

        // Intanciamento da classe que permite o uso de caixas de dialogo;
        AlertDialog.Builder pop = new AlertDialog.Builder(this);

        // Personalização da caixa;
        pop.setTitle("Confirmação"); // Titulo;
        pop.setIcon(R.drawable.logo_jogo_preta); // Icone ou imagem;
        pop.setMessage("Você está certo disso?"); // Mensagem;

        // Botão que confirma a resposta;
        pop.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                verificaResposta(rodada, respCerta, r);
            }
        });

        // Botão que cancela a resposta atual;
        pop.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                limparSelecao(true);
            }
        });

        // Comando que mostra a janela de dialogo;
        pop.show();

    }

    /** Esse método recebe a resposta do jogador e compara com a resposta certa. Se a resposta estiver
     * correta o método limpa os valores dos atributos eliminado 1, 2 e 3 e limpa a seleção dos
     * botões com o método limparSelecao(), depois adiciona +1 a rodada e chama o método nível que
     * vai levar a proxima pergunta.
     * Caso a resposta esteja errada o jogador será levado a tela que mostra o resultado.
     * @param rod Parametro que recebe o valor da rodada atual;
     * @param rc Parametro que recebe a resposta certa gerada pela classe Perguntas;
     * @param r Parametro que recebe a resposta selecionada pelo jogador;
     */
    public void verificaResposta(int rod, String rc, String r) {
        respCerta = rc;
        resposta = r;
        rodada = rod;

        // Condição que verifica se a resposta do jogador está correta;
        if(resposta.equals(respCerta)) {

            // Comando para executar o som;
            som.stop();

            // Essa condição verifica se o jogo ainda está em andamento ou se é a pergunta final para tocar o som personalizado;
            if(rodada == 16){
                som = MediaPlayer.create(this, R.raw.frase_ganhou_final);
            } else{
                som = MediaPlayer.create(this, R.raw.frase_acerto);
            }
            som.start();

            stopTimer(); // Para o tempo a cada nova rodada;

            // Comando que retarda por 3 segundos antes de limpar a seleção dos botões e avançar o jogo;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    limparTextos(); // Limpa os textos dos botões até que uma nova pergunta seja gerada;

                    limparSelecao(false); // Limpa a seleção dos botões;

                    // Comando que adiciona o valor atual do premio ao jogador;
                    ganhou = acertar;

                    if(rodada == 16){
                        // Essa condição verifica se for a última pergunta do jogo chama o final;
                        setFinal(ganhou);
                    } else {
                        // Chama o proximo nivel da rodada;
                        respCerta = ""; // Limpa a resposta certa para que os botões fiquem bloqueados até que uma nova pergunta seja gerada;
                        rodada += 1; // Adiciona +1 do atributo rodada para avançar o jogo;
                        nivel(); // Chama a proxima rodada;
                    }
                }
            }, 3000);

        } else {
            // Comando para executar o som;
            som.stop();
            som = MediaPlayer.create(this, R.raw.frase_erro);
            som.start();

            // Comando que adiciona o valor atual do premio ao jogador;
            ganhou = errar;

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Chama a Tela final passando o valor ganho como parametro;
                    setFinal(ganhou);
                }
            },2000);

        }

    }


    /** Esse método é a espinha dorsal do jogo, aqui é definido as rodadas de perguntas e o nível
     * atual do jogo.
     *
     * Na primeira condição ele adiciona ao atributo nivelPergunta as perguntas de nível 1 vindas
     * da classe Perguntas. Depois adiciona ao atributo indice uma lista de 8 números aleatórios
     * sem repetição que vem da classe Perguntas pelo método setIndice() é passado como parametro
     * o nome da lista de perguntas que vai ser usada como médida de tamanho.
     *
     * A cada 5 rodadas o atributo nivelPergunta recebem o proximo nível das perguntas e o indice
     * recebe uma nova lista com 8 números. Esses atributos são usados nos métodos rodada() e
     * pular() para regar uma nova pergunta.
     *
     * Na segunda condição faz o jogo ir avançando para a proxima rodada sendo um total de 16 até
     * a pergunta final.

     */
    public void nivel() {

        Perguntas dados = new Perguntas();

        // Condição que define o nivel das perguntas e o indice do sorteio;
        if(rodada == 1){
            nivelPergunta = dados.perguntasNivel1;
            indice = dados.setIndice(nivelPergunta);
        } else if(rodada == 6){
            nivelPergunta = dados.perguntasNivel2;
            indice = dados.setIndice(nivelPergunta);
        } else if(rodada == 11){
            nivelPergunta = dados.perguntasNivel3;
            indice = dados.setIndice(nivelPergunta);
        } else if(rodada == 16){
            nivelPergunta = dados.perguntasNivel4;
            indice = dados.setIndice(nivelPergunta);
        }

        // Essa condição faz com que o programa mostra uma nova pergunta a cada rodada;
        if(rodada == 2){
            rodada2();
        } else if(rodada == 3){
            rodada3();
        } else if(rodada == 4){
            rodada4();
        } else if(rodada == 5){
            rodada5();
        } else if(rodada == 6){
            rodada6();
        } else if(rodada == 7){
            rodada7();
        } else if(rodada == 8){
            rodada8();
        } else if(rodada == 9){
            rodada9();
        } else if(rodada == 10){
            rodada10();
        } else if(rodada == 11){
            rodada11();
        } else if(rodada == 12){
            rodada12();
        } else if(rodada == 13){
            rodada13();
        } else if(rodada == 14){
            rodada14();
        } else if(rodada == 15){
            rodada15();
        } else if(rodada == 16){
            rodada16();
        }
    }


    /** Esse método define o valor do premio atual do jogo baseado na rodada em que o jogo está.
     * Ele também avalia as opções se o jogador parar ou errar uma pergunta. O valor da rodada é
     * usado como posição do indice que dentro da lista premio tem as posições definidas.
     */
    public void premiacao(){

        if(rodada == 1){
            errar = premio[0];
            parar = premio[0];
            acertar = premio[rodada];
        } else if(rodada == 2){
            errar = premio[0];
            parar = premio[rodada -1];
            acertar = premio[rodada];
        } else if(rodada > 2 && rodada < 16){
            errar = premio[rodada -2];
            parar = premio[rodada -1];
            acertar = premio[rodada];
        } else if(rodada == 16){
            errar = premio[0];
            parar = premio[0];
        }

        // Premiação;
        txtErrar.setText(errar);
        txtParar.setText(parar);
        txtAcertar.setText(acertar);
    }

    // AJUDAS ======================================================================================

    /** Esse método gera um numero aleatorio de 0 a 3. Esse valor é passado como parametro usando
     * o intent junto com a chamada da Activity Cartas, essa Activity permite ao jogador escolher
     * uma carta que vai mostrar o valor gerado aletoriamente como sendo o numero de respostas a
     * serem eliminadas do jogo. A Activity Cartas se fecha apos o uso e retorna para a Tela Principal
     * aonde várias condições são analizadas para verificar a quantidade de respostas que serão
     * bloqueadas e terão as cores do botão alterados para indicar que foram eliminadas.
     */
    public void setCartas() {
        valorCartas = random.nextInt(4);

        som.stop();


        // Teste -->> Toast.makeText(this, "Resposta Certa: "+ respCerta, Toast.LENGTH_LONG).show();

        // Chama a tela das cartas e passagem do valor do sorteio;
        intent = new Intent(this, Cartas.class);
        intent.putExtra("valor", valorCartas);
        startActivity(intent);

        // Boqueia e muda a imagem do botão cartas;
        btnCartas.setEnabled(false);
        btnCartas.setImageResource(R.drawable.cartas2);

        // Comando que gera um tempo antes de executar o comando dentro do método rum();
        // Esse comando é para atrazar as opções que serão eliminadas da pergunta;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                eliminaResposta();
            }
        }, 2000);

    }

    /** Esse método é chamado quando o jogador escolhe a carta na Tela Cartas, de acordo com o valor
     * do sorteio na carta corresponde a quantidade de respostas que serão eliminadas.
     */
    public void eliminaResposta(){
        // Condição que define as respostas a serem eliminadas;
        if (respCerta.equals("A")) {
            if (valorCartas == 1) {
                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado1 = "c";

            } else if (valorCartas == 2) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado2 = "d";

            } else if (valorCartas == 3) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado3 = "d";
            }
            //====================================================================================
        } else if (respCerta.equals("B")) {
            if (valorCartas == 1) {
                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado1 = "d";

            } else if (cartas == 2) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

            } else if (valorCartas == 3) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado3 = "d";
            }
        } else if (respCerta.equals("C")) {
            if (valorCartas == 1) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

            } else if (valorCartas == 2) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado2 = "d";

            } else if (valorCartas == 3) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado2 = "b";

                d.setBackgroundColor(getResources().getColor(R.color.cinza));
                d.setEnabled(false);
                eliminado3 = "d";
            }
        } else if (respCerta.equals("D")) {
            if (valorCartas == 1) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

            } else if (valorCartas == 2) {
                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado1 = "b";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado2 = "c";

            } else if (valorCartas == 3) {
                a.setBackgroundColor(getResources().getColor(R.color.cinza));
                a.setEnabled(false);
                eliminado1 = "a";

                b.setBackgroundColor(getResources().getColor(R.color.cinza));
                b.setEnabled(false);
                eliminado2 = "b";

                c.setBackgroundColor(getResources().getColor(R.color.cinza));
                c.setEnabled(false);
                eliminado3 = "c";
            }
        }
    }

    /** Esse método chama a tela Placas passando como parametro a resposta certa atual do jogo.
     * Depois de gerado as ações na tela Placas, a tela se fecha retornando para a tela Principal,
     * o método continua a executar os comando para tirar -1 do atributo placas e inutiliza o
     * uso do botão.
     * Depois ele gera um retardo no tempo e mostra o botão que corresponde a resposta certa dando
     * a ele uma cor em destaque.
     */
    public void setPlacas(){
        // Comando que chama a tela Placas e passa como parametro a resposta certa da pergunta atual;
        intent = new Intent(this, Placas.class);
        intent.putExtra("resposta", respCerta);
        startActivity(intent);

        // Comando que para o som atual;
        som.stop();

        // Comando que zera a possibilidade de usar a ajuda convidados novamente;
        placas -= 1;
        btnPlacas.setImageResource(R.drawable.placas2); // Muda a imagem do botão;
        btnPlacas.setEnabled(false);

        // Comando que gera um tempo de 3 segundos para execultar o código que muda a cor do botão;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Condição que muda a cor do botão que corresponde a resposta certa;
                if(respCerta.equals("A")){
                    a.setBackgroundColor(getResources().getColor(R.color.primaria));
                } else if(respCerta.equals("B")){
                    b.setBackgroundColor(getResources().getColor(R.color.primaria));
                } else if(respCerta.equals("C")){
                    c.setBackgroundColor(getResources().getColor(R.color.primaria));
                } else if(respCerta.equals("D")){
                    d.setBackgroundColor(getResources().getColor(R.color.primaria));
                }
            }
        }, 3000);
    }

    /** Esse método chama a tela Convidados passando como parametro a resposta certa atual do jogo.
     * Depois de gerado as ações na tela Convidados, a tela se fecha retornando para a tela Principal,
     * o método continua a executar os comando para tirar -1 do atributo convidados e inutiliza o
     * uso do botão.
     * Depois ele gera um retardo no tempo e mostra o botão que corresponde a resposta certa dando
     * a ele uma cor em destaque.
     */
    public void setConvidados(){
        // Comando que chama a tela Convidados e passa como parametro a resposta certa da pergunta atual;
        intent = new Intent(this, Convidados.class);
        intent.putExtra("resposta", respCerta);
        startActivity(intent);

        // Comando que para o som atual;
        som.stop();

        // Comando que zera a possibilidade de usar a ajuda convidados novamente;
        convidados -= 1;
        btnConvidados.setImageResource(R.drawable.convidados2); // Muda a imagem do botão;
        btnConvidados.setEnabled(false);

        // Comando que gera um tempo de 3 segundos para execultar o código que muda a cor do botão;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Condição que muda a cor do botão que corresponde a resposta certa;
                if(respCerta.equals("A")){
                    a.setBackgroundColor(getResources().getColor(R.color.primaria));
                } else if(respCerta.equals("B")){
                    b.setBackgroundColor(getResources().getColor(R.color.primaria));
                } else if(respCerta.equals("C")){
                    c.setBackgroundColor(getResources().getColor(R.color.primaria));
                } else if(respCerta.equals("D")){
                    d.setBackgroundColor(getResources().getColor(R.color.primaria));
                }
            }
        }, 3000);

    }

    /** Método que permite ao jogador efetuar o pulo da pergunta. O jogo começa com 3 pulos e a cada
     * pulo o valor recebe -1.
     * Ao clicar no botão pular uma janela de confirmação é exibida dando a possibilidade de voltar
     * a pergunta atual. Caso o jogador clique em sim é gerado uma nova pergunta, essa ação ocorre
     * da mesma forma que uma pergunta normal do jogo, passando o parametro com o nivel da pergunta
     * e o indice. Quando o jogador utiliza os 3 pulos o botão de pular é desativado.
     *
     * NOTA: Assim como nas rodadas, a cada 5 rodadas o nível do jogo muda, então as perguntas
     *       geradas para o pulo acompanham o nivel de perguntas atual do jogo, sendo atualizadas
     *       a cada 5 rodadas.
     */
    public void setPular() {
        // Comando para executar um som;
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_ajuda1);
        som.start();

        // Comando que personaliza a tela de PopUp;
        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("Confirmação!");
        pop.setIcon(R.drawable.logo_jogo_preta);

        // Condição que termina o texto que vai ser exibido no PopUp;
        if(pulos == 1){
            pop.setMessage(String.format("Você só tem mais %d pulo. Realmente deseja pular essa pergunta", pulos));
        } else{
            pop.setMessage(String.format("Você ainda tem %d pulos. Realmente deseja pular essa pergunta", pulos));

        }

        // Botão do PopUp para não confirmar a ação;
        pop.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // Botão do PopUp para confirmar a ação;
        pop.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                pulos -= 1; // A cada confirmação de pulo o atributo pulos recebe -1;

                // Para o Timer;
                stopTimer();

                // Limpa os textos do jogo;
                limparTextos();

                // Condição que verifica se os pulos acabaram, ela inutiliza o uso do botão pular;
                if(pulos == 0){
                    btnPular.setEnabled(false);
                    btnPular.setImageResource(R.drawable.pular2);
                }

                // Atributo local que recebe o indice das perguntas para os pulos;
                int numIndice = 0;

                // Condição que define o indice da pergunta para cada pulo;
                if(pulos == 3){
                    numIndice = indice.get(5);
                } else if(pulos == 2){
                    numIndice = indice.get(6);
                } else if(pulos == 1){
                    numIndice = indice.get(7);
                }

                // Comando para executar um som;
                som.stop();
                som = MediaPlayer.create(TelaPrincipal.this, R.raw.frase_pular);
                som.start();

                // Instancimaneto da classe Perguntas;
                Perguntas dados = new Perguntas();

                // O atributo pergunta recebe uma pergunta gerada pelo método setNivel() passando como parametro o nivel da pergunta e o indice;
                pergunta = dados.setNivel(nivelPergunta, numIndice);

                // Chamada do método que formata a pergunta do jogo;
                formatacaoPergunta(pergunta);

            }
        });

        pop.show(); // Comando para mostrar o PopUp.
    }

    /** Esse método tem os comando que faz parar o jogo se o jogador confirmar a intenção.
     * Ele precisou ser criado separado do botão para que pudesse ser usado em outro momento do
     * jogo.
     */
    public void setParar(){
        som.stop();
        som = MediaPlayer.create(this, R.raw.frase_parar);
        som.start();

        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("Confirmação!");
        pop.setIcon(R.drawable.logo_jogo_preta);
        pop.setMessage("Tem certeza que quer Desistir do jogo?");


        pop.setNegativeButton("Voltar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeContextMenu();
            }
        });

        pop.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Para o Timer;
                stopTimer();

                // Comando para adionar o valor do premio ao parar o jogo.
                ganhou = parar;

                // Chamada da tela final de premiação;
                setFinal(ganhou);
            }
        });
        pop.show();
    }

    // FORMATAÇÃO DAS PERGUNTAS ====================================================================

    /** Esse método recebe como um parametro vindo da rodada, esse parametro é a pergunta que foi
     * gerada na classe Perguntas.
     * O texto vem sem formatação tendo apenas a separação da pergunta, opções de resposta e a
     * resposta separada por posição, esse método utiliza essa posição para distribuir os texto
     * no layout da tela. Ele também adiciona ao atributo respCerta a opção correta entre A, B, C ou D.
     * por fim ele chama o método premiacao() que mostra o valor do premio atual do jogo a cada rodada.
     */
    public void formatacaoPergunta(ArrayList<String> pergunta){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Inicia o Timer
                setTimer(start);

                // Formatação dos dados adicionando-os aos botões;
                txtPergunta.setText(pergunta.get(0));
                a.setText(pergunta.get(1));
                b.setText(pergunta.get(2));
                c.setText(pergunta.get(3));
                d.setText(pergunta.get(4));
                respCerta = pergunta.get(5);

                // Premiação;
                premiacao();
            }
        },3000);

    }

    // PERGUNTAS POR RODADAS =======================================================================

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada1() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_1mil);
        som.start();

        // Instanciamento da classe Perguntas para poder ter acesso ao método que gera uma pergunta;
        Perguntas dados = new Perguntas();

        // Comando que gera um retardo de 4 segundos antes de formatar uma nova pergunta;
        // Esse retardo é devido ao som da primeira rodada ser um pouco longo;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pergunta = dados.setNivel(nivelPergunta, indice.get(0));
                // teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(0), Toast.LENGTH_LONG).show();

                formatacaoPergunta(pergunta);
            }
        }, 4000);

    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada2() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_2mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(1));
        // teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(1), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);

    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada3() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_3mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(2));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(2), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);

    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada4() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_4mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(3));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(3), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada5() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_5mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(4));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    // INÍCIO DO NÍVEL 2 ===========================================================================

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada6() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_10mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(0));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada7() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_20mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(1));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada8() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_30mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(2));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada9() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_40mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(3));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada10() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_50mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(4));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    // INÍCIO DO NÍVEL 3 ===========================================================================

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada11() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_100mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(0));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada12() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_200mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(1));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada13() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_300mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(2));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada14() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_400mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(3));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método define uma rodada de perguntas do jogo. São 16 rodadas no total.
     * Ele faz o instanciamento da classe Perguntas para ter acesso ao método setNivel().
     * O método setNivel() recebe dois parametros, nivelPergunta e indice, ele gera um pergunta
     * aleatória e retorna esse dado para dentro do atributo pergunta. Essa pergunta vem sem
     * formatação tendo o texto separado por posição, para fazer a formatação do texto a ser
     * apresentado na tela ele chama o método formatacaoPergunta() e recebe a pergutna como parametro.
     *
     * NOTA: A cada nova rodada o indice vai mudando de 0 até 5 que são os 5 primeiros números
     * sorteados no método setIndice() na classe Perguntas. Os outros 3 números são reservados para
     * os 3 pulos, que podem ocorrer no nivel atual de perguntas.
     *
     * Depois de 5 rodadas o método nivel() muda os atributos nivelPergunta para o proximo nivel
     * e o indice chama o método setIndice() para gerar novos números. Assim a cada 5 rodadas o
     * jogo atualiza sozinho o nivel de perguntas.
     */
    public void rodada15() {
        // Comando para executar um som;
        som = MediaPlayer.create(this, R.raw.frase_500mil);
        som.start();

        Perguntas dados = new Perguntas();

        pergunta = dados.setNivel(nivelPergunta, indice.get(4));
        // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

        formatacaoPergunta(pergunta);
    }

    /** Esse método corresponde a última pergunta do jogo, quando o método é chamado ele mostra um
     * popUP na tela para que o jogador confirme a intenção de continuar ou desistir do jogo.
     * De acordo com a resposta do jogador o método setParar() é chamado ou o código segue o fluxo.
     * Os botões de ajudas são desabilitados e uma nova pergunta é gerada chamando o método de
     * formatacaoPergunta();
     */
    public void rodada16() {

        AlertDialog.Builder pop = new AlertDialog.Builder(this);
        pop.setTitle("ARRISCA TUDO!");
        pop.setIcon(R.drawable.logo_jogo_preta);
        pop.setMessage("Você quer arriscar tudo na última pergunta?");

        pop.setNegativeButton("Desistir!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                som = MediaPlayer.create(TelaPrincipal.this, R.raw.frase_desistiu_500mil);
                som.start();

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        setParar();
                    }
                },5000);

            }
        });

        pop.setPositiveButton("Arriscar!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Na última pergunta as ajudas precisam ser zeradas;
                btnPular.setEnabled(false);
                btnPular.setImageResource(R.drawable.pular2);

                btnConvidados.setEnabled(false);
                btnConvidados.setImageResource(R.drawable.convidados2);

                btnPlacas.setEnabled(false);
                btnPlacas.setImageResource(R.drawable.placas2);

                btnCartas.setEnabled(false);
                btnCartas.setImageResource(R.drawable.cartas2);

                // Comando para executar um som;
                som = MediaPlayer.create(TelaPrincipal.this, R.raw.frase_final);
                som.start();

                Perguntas dados = new Perguntas();

                pergunta = dados.setNivel(nivelPergunta, indice.get(0));
                // Teste -->> Toast.makeText(this, "Indice: "+ indice.indexOf(4), Toast.LENGTH_LONG).show();

                formatacaoPergunta(pergunta);
            }
        });

        pop.show();

    }

}