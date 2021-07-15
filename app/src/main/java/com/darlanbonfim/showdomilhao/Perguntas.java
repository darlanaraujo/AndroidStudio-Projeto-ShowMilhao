package com.darlanbonfim.showdomilhao;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Perguntas {

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
    }; // Perguntas de nivel 1

    String[] perguntasNivel2 = {}; // Perguntas de nivel 2

    String[] perguntasNivel3 = {}; // Perguntas de nivel 3

    String[] perguntasNivel4 = {}; // Perguntas de nivel 4

    String[] perguntasNivel5 = {}; // Perguntas de nivel 5

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

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel1. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
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

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel2. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
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

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel3. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
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

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel4. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
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

    // Método para gerar as perguntas de nível1 ====================================================

    /** Esse método gera uma pergunta aleatoria vinda da lista perguntaNivel5. Dentro do método foi
     * criado um Array para guardar temporariamente a pergunta gerada fazendo a separação do texto
     * cada vez que o ";" é encontrado, esse texto separado é adicionado a um espaço dentro do
     * atributo texto. No final ele adiciona o atributo texto dentro do atributo pergunta que será
     * enviado para Tela principal para formatação do texto com o layout do App. Apos isso o atributo
     * texto é limpado para poder receber novamente o texto quando o método for chamado.
     * @return Retorna a pergunta que foi gerada no método.
     */
    public ArrayList<String> setPerguntaNivel5(){
        ArrayList<String> pergunta = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        String[] texto;

        //int n = random.nextInt(perguntasNivel1.length -1); // Sorteia o numero do indice da pergunta;

        sorteio = perguntasNivel5[random]; // Parametro recebido indicando qual o nivel das perguntas;

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

}
