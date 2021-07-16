package com.darlanbonfim.showdomilhao;

import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perguntas {

    // ArreysList que vão receber as perguntas com os texto separados por indices;
    ArrayList<String> pergunta = new ArrayList<>();

    ArrayList<String> pergunta1 = new ArrayList<>();
    ArrayList<String> pergunta2 = new ArrayList<>();
    ArrayList<String> pergunta3 = new ArrayList<>();
    ArrayList<String> pergunta4 = new ArrayList<>();
    ArrayList<String> pergunta5 = new ArrayList<>();
    ArrayList<String> pulo1 = new ArrayList<>();
    ArrayList<String> pulo2 = new ArrayList<>();
    ArrayList<String> pulo3 = new ArrayList<>();

    // Definição dos níveis e das perguntas;
    String[] perguntasNivel1 = {
            "Em que estado brasileiro nasceu a apresentadora Xuxa?;A) Rio de Janeiro;B) Rio Grande do Sul; C) Santa Catarina; D) Goiás;B",
            "Qual o nome dado ao estado da água em forma de gelo?;A) Líquido;B) Sólido;C) Gasoso;D) Vaporoso;B",
            "Qual era o apelido da cantora Elis Regina?;A) Gauchinha;B) Paulistinha;C) Pimentinha;D) Andorinha;C",
            "Quem é a namorada do Mickey?;A) Margarida;B) Minnie;C) A pequena Sereia;D) Olívia Palito;B",
            "Qual é o personagem brasileiro que tem uma perna só?;A) Cuca;B) Negrinho do Pastoreio;C) Boitatá;D) Saci-Pererê;D",
            "Fidel Castro nasceu em qual país?;A) Jamaica;B) Cuba;C) El Salvador;D) México;B",
            "Quem proclamou a república no Brasil em 1889?;A) Duque de Caxias;B) Marechal Rondon;C) Dom Pedro II;D) Marechal Deodoro;C",
            "Quem é o patrono do exército brasileiro?;A) MARECHAL DEODORO;B) BARÃO DE MAUÁ;C) DUQUE DE CAXIAS;D) MARQUÊS DE POMBAL;C"
    }; // Perguntas de nivel 1 - R$ 1.000 até R$ 5.000;

    String[] perguntasNivel2 = {}; // Perguntas de nivel 2 - R$ 10.000 até R$ 50.000;

    String[] perguntasNivel3 = {}; // Perguntas de nivel 3 - R$ 100.000 até R$ 500.000;

    String[] perguntasNivel4 = {}; // Perguntas de nivel 4 - R$ 1.000.000

    // =============================================================================================

    /** Método random() para gerar número aleatório;
     * @return Retorna o valor gerado.
     */
    public Integer random(){
        int random = (int )(Math.random() * perguntasNivel1.length);
        return random;
    }

    // Atributos globais;
    int random = random(); // Atributo que recebe o valor gerado no método random();
    String sorteio; // atributo que vai receber uma pergunta vindo da lista de perguntas;


    // Método para gerar as perguntas ==============================================================

    /** Esse método gera 8 números aleatórios sem repetição. Um número é gerado pelo método random();
     * e adicionado ao atributo valor. Ocorre um condição que verifica se o numero dentro de valor
     * já não se encontra dentro do Array indice, caso não tenha o valor é adicionado ao indice e o
     * contador recebe +1 até chegar em 8 quando ele para de gerar números.
     * Caso o valor já tenha dentro do indice o contador recebe -1, assim ele voltaria para o mesmo
     * giro até que o valor gerado seja um número que não exista no indice.
     * @return Retorna o Array indice com um conjunto de 8 números;
     */
    public ArrayList<Integer> setIndice(){

        //int random = (int)(Math.random() * lisPerNivel.length);

        ArrayList<Integer> indice = new ArrayList<>(); // Atributo do tipo vetor que vai receber 8 numeros;

        // laço que faz o papel de contador para gerar 8 números que serão adicionados no vetor.
        for(int c = 0; c < 8; c++){
            int valor = random(); // Atributo que recebe um valor aleatório;

            if(indice.contains(valor)){ // Verifica se o numero sorteado já existe no vetor indice;
                c--; // Se existir o contador c recebe -1;
            } else {
                indice.add(valor); // se não existir o valor gerado vai para dentro do indice;
            }

        }

        return  indice; // Retorna o indice contendo 8 números aleatorios sem repetição;
    }

    /** Esse método recebe 2 parametros, um com o nível da pergunta e o indice. O atributo p1 recebe
     * essas informações e gera uma pergunta vinda da lista definida pelo parametro, ele passa o
     * texto para maiusculo. Depois o vetor texto recebe esse atributo e faz a separação dos textos
     * a cada ";" encontrado e por fim troca o salto de linha por um espaço vazio.
     * Depois o Array temp recebe esse vetor separado por indice gerando a pergunta, as opções e a
     * resposta certa, no final tudo é adicionado ao Array pergunta que será acessado pela Tela Principal
     * para ser formatada e mostrada no layout do App.
     * @param lisPerNivel Parametro que vem da Tela Principal para definir o nivel das perguntas;
     * @param numIndice Parametro que vem da Tela Principal para definir o indice da pergunta;
     * @return Retorna uma pergunta separada da lista e dividida entre pergunta, opções de resposta e resposta certa;
     */
    public ArrayList<String> setNivel(String[] lisPerNivel, int numIndice){
        ArrayList<String> temp = new ArrayList<>();

        String p1; // Atributo que vai recebe a pergunta sem tratamento;
        String[] texto; // Vetor que vai receber o texto da pergunta gerada pelo sorteio;

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método setIndice e colocada em maiúscula;
        p1 = lisPerNivel[numIndice].toUpperCase();

        texto = p1.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        return  pergunta;
    }






// --->>> CÓDIGO ANTIGO QUE FOI MELHORADO.

/*
    public Integer[] setSorteio(String[] lisPerNivel){
        int random = (int )(Math.random() * lisPerNivel.length);
        Integer[] num = new Integer[8];

        List<Integer> lista = Arrays.asList(num);

        for(int c = 0; c < 8; c++){
            int valor = random;

            if(lista.contains(valor)){
                c--;
            } else {
                lista.add(valor);
            }
        }
        return num;
    }


 */

    /** Esse método gera as 5 perguntas e os 3 pulos com perguntas do nivel 1;
     * Esses atributos são preenchidos com novos dados a cada novo nivel, recebendo uma lista
     * com a respectiva rodada e seu grau de dificudade.
     *
     * Ele utiliza a lista de perguntas perguntaNivel1(), perguntaNivel2(), perguntaNivel3(),
     * perguntaNivel4(), perguntaNivel5(). E utiliza o método setIndice que gera 8 números aleatórios
     * sem repetição. Esses números são usados para definir as 5 perguntas e os 3 pulos a cada rodada.
     */
    /*
    public ArrayList<String> setNivel1(){

        ArrayList<String> temp = new ArrayList<>();

        String p1, p2, p3, p4, p5, p6, p7, p8; // Atributo que vai recebe a pergunta sem tratamento;
        String[] texto; // Vetor que vai receber o texto da pergunta gerada pelo sorteio;

        // Definição da 1 pergunta =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p1 = perguntasNivel1[setIndice().get(0)].toUpperCase();

        texto = p1.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta1.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        // Definição da 2 pergunta =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p2 = perguntasNivel1[setIndice().get(1)].toUpperCase();

        texto = p2.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta2.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        // Definição da 3 pergunta =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p3 = perguntasNivel1[setIndice().get(2)].toUpperCase();

        texto = p3.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta3.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        // Definição da 4 pergunta =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p4 = perguntasNivel1[setIndice().get(3)].toUpperCase();

        texto = p4.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta4.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        // Definição da 5 pergunta =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p5 = perguntasNivel1[setIndice().get(4)].toUpperCase();

        texto = p5.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta5.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        // Definição da 1 pulo =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p6 = perguntasNivel1[setIndice().get(5)].toUpperCase();

        texto = p6.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pulo1.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        // Definição da 2 pulo =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p7 = perguntasNivel1[setIndice().get(6)].toUpperCase();

        texto = p7.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pulo2.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        // Definição da 3 pulo =================================================================

        // Recebimento da pergunta vindo da lista recebendo o indice gerado no método geraSorteio e colocada em maiúscula;
        p8 = perguntasNivel1[setIndice().get(7)].toUpperCase();

        texto = p8.split(";"); // Separação do texto ao encontrar o ";"
        texto[5] = texto[5].replace("\n", ""); // Troca do salto de linha por um espa;o vazio;

        // Separação do texto;
        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pulo3.addAll(temp); // Aqui é adicionado a pergunta, as opções de resposta e a resposta certa ao vetor;

        temp.clear(); // Comando para limpar o vetor temp;

        return pergunta1;
    }


     */
    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel1. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
    /*
    public ArrayList<String> setPerguntaNivel1(){
        ArrayList<String> pergunta = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        String[] texto;

        //int n = random.nextInt(perguntasNivel1.length -1); // Sorteia o numero do indice da pergunta;

        sorteio = perguntasNivel1[random].toUpperCase(); // Parametro recebido indicando qual o nivel das perguntas;

        // Formatação do texto separando a pergunta das opções e da resposta;
        texto = sorteio.split(";"); // Trata a pergunta separando por ";";
        texto[5] = texto[5].replace("\n", ""); // Trata a última linha referente a quabra de linha;

        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta.addAll(temp); // Adiciona tudo que há em temp para dentro do nivel1;

        temp.clear(); // Apaga o que tem em temp.

        return pergunta;
    }

     */

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel2. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
    /*
    public ArrayList<String> setPerguntaNivel2(){
        ArrayList<String> pergunta = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        String[] texto;

        //int n = random.nextInt(perguntasNivel1.length -1); // Sorteia o numero do indice da pergunta;

        sorteio = perguntasNivel2[random]; // Parametro recebido indicando qual o nivel das perguntas;

        // Formatação do texto separando a pergunta das opções e da resposta;
        texto = sorteio.split(";"); // Trata a pergunta separando por ";";
        texto[5] = texto[5].replace("\n", ""); // Trata a última linha referente a quabra de linha;

        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta.addAll(temp); // Adiciona tudo que há em temp para dentro do nivel1;

        temp.clear(); // Apaga o que tem em temp.

        return pergunta;
    }

     */

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel3. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
   /*
    public ArrayList<String> setPerguntaNivel3(){
        ArrayList<String> pergunta = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        String[] texto;

        //int n = random.nextInt(perguntasNivel1.length -1); // Sorteia o numero do indice da pergunta;

        sorteio = perguntasNivel3[random]; // Parametro recebido indicando qual o nivel das perguntas;

        // Formatação do texto separando a pergunta das opções e da resposta;
        texto = sorteio.split(";"); // Trata a pergunta separando por ";";
        texto[5] = texto[5].replace("\n", ""); // Trata a última linha referente a quabra de linha;

        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta.addAll(temp); // Adiciona tudo que há em temp para dentro do nivel1;

        temp.clear(); // Apaga o que tem em temp.

        return pergunta;
    }

    */

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel4. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
    /*
    public ArrayList<String> setPerguntaNivel4(){
        ArrayList<String> pergunta = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        String[] texto;

        //int n = random.nextInt(perguntasNivel1.length -1); // Sorteia o numero do indice da pergunta;

        sorteio = perguntasNivel4[random]; // Parametro recebido indicando qual o nivel das perguntas;

        // Formatação do texto separando a pergunta das opções e da resposta;
        texto = sorteio.split(";"); // Trata a pergunta separando por ";";
        texto[5] = texto[5].replace("\n", ""); // Trata a última linha referente a quabra de linha;

        temp.add(texto[0]); // pergunta
        temp.add(texto[1]); // Opção A
        temp.add(texto[2]); // Opção B
        temp.add(texto[3]); // Opção C
        temp.add(texto[4]); // Opção D
        temp.add(texto[5]); // Resposta

        pergunta.addAll(temp); // Adiciona tudo que há em temp para dentro do nivel1;

        temp.clear(); // Apaga o que tem em temp.

        return pergunta;
    }

     */

    // Método para gerar as perguntas de nível1 ====================================================

}
