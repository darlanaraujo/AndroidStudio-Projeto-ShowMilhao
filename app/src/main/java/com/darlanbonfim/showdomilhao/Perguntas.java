package com.darlanbonfim.showdomilhao;

import android.content.Intent;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Perguntas {

    // ArreysList que vão receber as perguntas com os texto separados por indices;
    ArrayList<String> pergunta = new ArrayList<>();

    // Definição dos níveis e das perguntas;
    String[] perguntasNivel1 = {
            "Qual atleta foi desclassificado por uso de doping nas Olimpíadas de 1988?;MIKE POWELL;BEN JOHNSON;CARL LEWIS;LINFORD CHRISTIE;B",
            "Qual é o exame que emite ondas sonoras para visualizar os órgãos?;XEROGRAFIA;ULTRA-SONOGRAFIA;FOTOGRAFIA;RADIOGRAFIA;B",
            "Qual é a especialidade dos profissionais que analisam os sulcos e marcas de uma bala?;BALEAGEM;BALÍSTICA;LOGÍSTICA;IMPRESSÃO DIGITAL;B",
            "Qual metal possui o símbolo Hg?;FERRO;AÇO;MERCÚRIO;OURO;C",
            "Qual é o nome dado a um conjunto de sinos?;CORRIMÃO;CARRILHÃO;BADALADA;CORSELETE;B",
            "Em que estado brasileiro nasceu a apresentadora Xuxa?;Rio de Janeiro;Rio Grande do Sul;Santa Catarina;Goiás;B",
            "Qual o nome dado ao estado da água em forma de gelo?;Líquido;Sólido;Gasoso;Vaporoso;B",
            "Qual era o apelido da cantora Elis Regina?;Gauchinha;Paulistinha;Pimentinha;Andorinha;C",
            "Quem é a namorada do Mickey?;Margarida;Minnie;A pequena Sereia;Olívia Palito;B",
            "Que trópico atravessa o Saara?;CAPRICÓRNIO;VIRGEM;CÂNCER;LEÃO;C",
            "Quem foi aluno de Platão e tutor de Alexandre, o Grande?;PITÁGORAS;DIDEROT;ARISTÓTELES;GALILEU GALILEI;C",
            "“Guernica” é uma tela de qual pintor?;MONETMONET;RENOIR;PICASSO;LEONARDO DA VINCI;C",
            "Em que ano foi inaugurada a estátua do Cristo Redentor no Rio de Janeiro?;1921;1931;1941;1951;B",
            "Qual é a religião majoritária da Turquia?;BUDISTA;ISLÂMICA;CATÓLICA;PROTESTANTE;B",
            "Qual é o personagem brasileiro que tem uma perna só?;Cuca;Negrinho do Pastoreio;Boitatá;Saci-Pererê;D",
            "Fidel Castro nasceu em qual país?;Jamaica;Cuba;El Salvador;México;B",
            "Quem proclamou a república no Brasil em 1889?;Duque de Caxias;Marechal Rondon;Dom Pedro II;Marechal Deodoro;C",
            "Quem é o patrono do exército brasileiro?;MARECHAL DEODORO;BARÃO DE MAUÁ;DUQUE DE CAXIAS;MARQUÊS DE POMBAL;C",
            "Quem era o apresentador que reprovava os calouros tocando uma buzina?;RAUL GIL;BOLINHA;FLÁVIO CAVALCANTI;CHACRINHA;D",
            "O que era Frankenstein, de Mary Shelley?;MONSTRO;GORILA;PRÍNCIPE;SAPO;A",
            "Onde estão os sepulcros de Michelangelo, Maquiavel e Galileu?;MILÃO;FLORENÇA;VENEZA;GÊNOVA;B",
            "A que país deve-se viajar para subir o Monte Parnaso?;ITÁLIA;FRANÇA;GRÉCIA;TURQUIA;C",
            "A que letra do nosso alfabeto corresponde a letra grega tau?;F;H;J;T;D",
            "Em qual guerra lutou Paul Newman pela marinha americana?;PRIMEIRA GUERRA MUNDIAL;GUERRA DO VIETNÃ;GUERRA DA CORÉIA;SEGUNDA GUERRA MUNDIAL;D",
            "O que é talude?;AVALANCHE DE NEVE;FUNGO;INCLINAÇÃO DE TERRENO;RITO ISLÂMICO;C",
            "Qual é o signo do zodíaco de quem nasce no dia do ano-novo?;VIRGEM;AQUÁRIO;CAPRICÓRNIO;ÁRIES;C",
            "Quem fundou a fábrica de automóveis Ford?;HARRISON FORD;GERALD FORD;HENRY FORD;ANNA FORD;C",
            "Qual é a cor que se associa com os grupos ecológicos?;PRETA;VERMELHA;AZUL;VERDE;D",
            "A água ferve a quantos graus centígrados?;200;100;170;220;B",
            "Qual destas palavras é sinônimo de cabal?;BAIXO;PERFEITO;ATREVIDO;ENFERMO;B",
            "Qual desses poetas foi indicado para o prêmio Nobel de literatura?;MÁRIO QUINTANA;MANUEL BANDEIRA;VINÍCIUS DE MORAIS;CARLOS D. DE ANDRADE;D",
            "QUal foi a locomotiva a vapor que trafegou na Estrada de Ferro Mauá em 1854?;SANTA-FÉ;LOCO-BREQUE;AMERICAN;BARONESA;D",
            "O que é palato?;BARRIGA DA PERNA;MENINA DOS OLHOS;LÍNGUA;CÉU DA BOCA;D",
            " O que construía Stradivarius?;CASAS;VIOLINOS;ARMAS;ESTRADAS;B",
            "Quando é comemorado o dia da independência do Brasil?;21 DE ABRIL;12 DE OUTUBRO;7 DE SETEMBRO;25 DE DEZEMBRO;C",
            "Qual lugar é também chamado de Santa Sé?;VENEZA;VITÓRIA;VANCOUVER;VATICANO;D",
            "Quem tem por lema a frase: “Sempre alerta”?;MÉDICOS;ESCOTEIROS;BOMBEIROS;POLICIAIS;B",
            "Quem foi o grande amor de Julieta?;ROMEU;ORFEU;HAMLET;IAGO;A",
            "Quantos signos formam o zodíaco?;NOVE;DEZ;ONZE;DOZE;D",
            "Vatapá é uma comida típica de qual estado?;PARANÁ;SANTA CATARINA;SÃO PAULO;BAHIA;D",
            "Qual é a altura oficial do aro na cesta no basquete?;3,05 METROS;2,97 METROS;3,10 METROS;3,00 METROS;A",
            "Qual é o apelido do time da Ponte Preta?;FEITICEIRA;RAPOSA;BRUXA;MACACA;D",
            "Quem foi chamado de Águia de Haia?;JORGE AMADO;EÇA DE QUEIROZ;RUI BARBOSA;RAIMUNDO CORRÊA;C",
            "Quem escreveu “Dom Quixote”?;ESPINOZA;MIGUEL DE CERVANTES;CARLOS CONTE;ANGEL MORITA;B"
    }; // Perguntas de nivel 1 - R$ 1.000 até R$ 5.000;

    String[] perguntasNivel2 = {

            "Qual foi o material utilizado na construção do Partenon de Atenas?;MÁRMORE;GRANITO;GESSO;QUARTZO;A",
            "Bill Clinton nasceu em que cidade?;LOS ANGELES;CHICAGO;HOPE;DALLAS;C",
            "Que significa o prefixo exo?;DENTRO DE;DEBAIXO DE;FORA DE;ATRÁS DE;C",
            "Com que outro nome é conhecido o Cabo Canaveral?;CABO JEFFERSON;CABO LINCOLN;CABO KENNEDY;CABO REAGAN;C",
            "Que cidade foi capital do Império Inca?;LAPAZ;BUENOS AIRES;BOGOTÁ;CUZCO;D",
            "Quantos jogadores um jogo de vôlei reúne na quadra?;SEIS;OITO;DEZ;DOZE;D",
            "Qual é o país do tango?;URUGUAI;ARGENTINA;PARAGUAI;ESPANHA;B",
            "Que imperador pôs fogo em Roma?;TRAJANO;NERO;BRUTUS;CALÍGULA;B",
            "A cidade de Pompéia, que foi soterrada por um vulcão fica em qual desses países?;JAPÃO;MÉXICO;ITÁLIA;ESTADOS UNIDOS;C",
            "Como é chamado quem nasce em Milão, na Itália?;MILANENSE;MILANOSO;MILISTA;MILANÊS;D",
            "Que profissional usa uma ferramenta chamada formão?;CARPINTEIRO;RELOJOEIRO;CONFEITEIRO;BOMBEIRO;A",
            "Em qual estádio Pelé marcou seu milésimo gol?;MORUMBI;PACAEMBU;MARACANÃ;MINEIRÃO;C",
            "O que significa deprecar?;RENEGAR;SUJEITAR;DESMAIAR;PEDIR;D",
            "Qual o nome verdadeiro do jogador de futebol conhecido com Zico?;ARTHUR ANTUNES COIMBRA;ARTHUR ALVES PINTO;ARTHUR DA TÁVOLA;ARTHUR DOS SANTOS;A",
            "A quem se atribui a frase “Eu sou o Estado”?;LUIZ XIV;LUIZ XV;LUIZ XVI;NAPOLEÃO BONAPARTE;A",
            "Em que parte do nosso corpo está o úmero?;BRAÇO;PERNA;QUADRIL;COLUNA;A",
            "Quem construiu o primeiro telescópio astronômico completo?;CYRUS MCCORMICK;THOMAS EDISON;MICHELANGELO;GALILEU GALILEI;D",
            "O que é um oboé?;VULCÃO;COMIDA;INSTRUMENTO MUSICAL;TRIBO INDÍGENA;C",
            "Como eram chamados os pilotos suicidas da Segunda Guerra?;CAMICASES;SASHIMIS;HARAQUIRIS;SUMÔS;A",
            "O que é gôndola?;EMBARCAÇÃO;BRINQUEDO;MÚSICA;SÍMBOLO;A",
            "Sashimi é um prato originário de qual país?;JAPÃO;CHINA;ÍNDIA;INDONÉSIA;A",
            "De quem é a frase ”Penso, logo existo”?;PLATÃO;JÚLIO VERNE;ARISTÓTELES;RENÉ DESCARTES;D",
            "Que símbolo está desenhado no centro da bandeira Argentina?;SOL;LUA;ESTRELA;FOICE E MARTELO;A",
            "Qual é a menor República do mundo?;MÔNACO;SAN MARINO;NOVA ZELÂNDIA;CHINA;B",
            "Em que ano Ayrton Senna venceu o primeiro campeonato de Fórmula 1?;1987;1990;1985;1988;D",
            "“Arábica” e “robusta” são tipos de quê?;UVA;CAFÉ;MELÃO;LARANJA;B",
            "Como é chamada a cantora que representa o papel principal em uma ópera?;PRIMEIRA DAMA;DONA-PRIMA;PRIMA-DONA;OBRA-PRIMA;C",
            "Peroba é uma espécie de?;INSETO;ÁRVORE;VERME;VERDURA;B",
            "O alpinismo é praticado em que lugar?;MAR;MONTANHA;RIO;PRAIA;B",
            "O Coliseu é um monumento histórico de que cidade européia?;PARIS;COPENHAGUE;ROMA;LONDRES;C",
            "Que nome recebe a foz de um rio que se abre para o mar?;ALAGADO;MANGUEZAL;PÂNTANO;ESTUÁRIO;D",
            "De quem é este verso: “A praça é do povo, como o céu é do condor”?;TOBIAS BARRETO;DORIVAL CAIMI;MACHADO DE ASSIS;CASTRO ALVES;D",
            "Na criação do Estado do Tocantins, que estado teve o território reduzido?;GOIÁS;MATO GROSSO;PARÁ;MARANHÃO;A",
            "Em que país você pode gastar rublos?;HOLANDA;RÚSSIA;ESPANHA;ÁFRICA DO SUL;B",
            "A que país pertence a ilha de Terra Nova?;ESTADOS UNIDOS;DINAMARCA;CANADÁ;FRANÇA;C",
            "Qual é o ponto mais alto da Terra?;EVEREST;MONTE SINAI;MONTE CASTELO;MONT BLANC;A",
            "Que rio corta a cidade de Londres, na Inglaterra?;TÂMISA;SENA;RENO;AUBE;A",
            "Qual é a raça do personagem principal do filme “Beethoven”?;FILA;PASTOR ALEMÃO;POODLE;SÃO-BERNARDO;D",
            "Quem foi eleito presidente da África do Sul em 1994?;NELSON PIQUET;NELSON MANDELA;NELSON NED;JOHN NELSON;B",
            "Qual cantor ficou conhecido como “O rei da voz”?;ORLANDO SILVA;VICENTE CELESTINO;FRANCISCO ALVES;CARLOS GALHARDO;C",
            "A união do espermatozóide com o óvulo origina uma célula chamada:;ZIGOTO;BIGOTO;FETO;GAROTO;A",
            "Que figura mitológica é conhecida por sua força extraordinária?;ÁTILA;MINOTAURO;PERSEU;HÉRCULES;D",
            "Que parte do corpo humano é infectada pela cólera?;GARGANTA;INTESTINO;PULMÕES;RINS;B",
            "A Bélgica é:;UMA REPÚBLICA;UMA MONARQUIA CONSTITUCIONAL;UM EMIRADO;UM PRINCIPADO;B",
            "A eletrônica é parte de qual ciência?;FÍSICA;BIOLOGIA;QUÍMICA;BOTÂNICA;A",
            "Qual a ciência que estuda a distribuição dos animais?;ZOOTERAPIA;ZOOGEOGRAFIA;ZODÍACO;ZOOMETRIA;B"
    }; // Perguntas de nivel 2 - R$ 10.000 até R$ 50.000;

    String[] perguntasNivel3 = {
            "Em qual espécie o macho choca os ovos e a fêmea procura alimento?;ANDORINHA;PATO SELVAGEM;PINGÜIM;MARRECO;C",
            "Em qual país está localizado o “Muro das lamentações”?;ALEMANHA;BRASIL;VENEZUELA;ISRAEL;D",
            "Qual desses países não fica na Ásia?;PAQUISTÃO;JAPÃO;TAILÂNDIA;EGITO;D",
            "Qual desses astros de filmes de ação é belga?;ARNOLD SCHWARZENEGGER;SYLVESTER STALLONE;STEVEN SEAGAL;JEAN CLAUDE VAN DAMME;D",
            "Onde foi conduzida a vitória das forças aliadas na Segunda Guerra Mundial?;CANNES;NORMANDIA;CAPRI;MARSELHA;B",
            "Onde nasceu Van Gogh, o grande pintor impressionista?;POLÔNIA;FRANÇA;ITÁLIA;HOLANDA;D",
            "Qual é a primeira letra do alfabeto grego?;DELTA;BETA;ALFA;GAMA;C",
            "Qual presidente brasileiro instituiu o AI-5?;COSTA E SILVA;ERNESTO GEISEL;JOÃO FIGUEIREDO;ITAMAR FRANCO;A",
            "O que significa literalmente Perestroika?;CONVERSÃO;INVOLUÇÃO;REESTRUTURAÇÃO;REGRESSÃO;C",
            "Qual desses quatro pesos é o mais leve?;10 ONÇAS;10 GRAMAS;10 QUILOS;10 LIBRAS;B",
            "Brahma é o deus de que religião?;HINDUÍSMO;XINTOÍSMO;BUDISMO;ISLAMISMO;A",
            "Os nazistas foram julgados em:;BERLIM;NUREMBERGUE;MUNIQUE;PARIS;B",
            "Que ramo da pecuária ocupa- se de bodes e cabras?;ASININO;CAPRINO;BUFALINO;MUAR;B",
            "Qual oceano tem o maior volume de água?;ATLÂNTICO;PACÍFICO;ÍNDICO;ÁRTICO;B",
            "Qual foi o último presidente militar do Brasil?;FERNANDO COLLOR;JOÃO FIGUEIREDO;TANCREDO NEVES;JOÃO GOULART;B",
            "Que conflito ideológico envolveu os EUA e a União Soviética?;GUERRA FRIA;GUERRA DO VIETNÃ;GUERRA NAS ESTRELAS;GUERRA DA CORÉIA;A",
            "O trapézio é um músculo que está situado:;NO PESCOÇO;NO OMBRO;NA CABEÇA;NO BRAÇO;B",
            "Quem escreveu o livro “A sangue frio” em 1966?;TRUMAN CAPOTE;HENRY JAMES;JOHN STEINBECK;TONI MORRISON;A",
            "Quem escreveu “Ulisses” em 1922?;ERNEST HEMINGWAY;MARCEL PROUST;T.S. ELLIOT;JAMES JOYCE;D",
            "Qual o símbolo químico do radônio?;Rr;Rd;Rn;Ro;C",
            "O que são meninges?;CÉLULAS;NERVOS;MEMBRANAS;MÚSCULOS;C",
            "Qual produto gerou guerras e conflitos no século XX?;ÁLCOOL;PETRÓLEO;OURO;ALUMÍNIO;B",
            "Como é chamada a bola de gelo e poeira que orbita em torno do sol?;COMETA;METEORITO;CAMADA DE OZÔNIO;ESTRELA D’ALVA;A",
            "O confucionismo é uma filosofia de qual nacionalidade?;INDIANA;JAPONESA;CHINESA;COREANA;C",
            "O que significa a expressão e-mail?;CORREIO RÁPIDO;CORREIO ELETRÔNICO;CORREIO ELEGANTE;CORREIO DE MÁQUINA;B",
            "Quem dirigiu o filme “Central do Brasil”?;BRUNO BARRETO;HÉCTOR BABENCO;ARNALDO JABOR;WALTER SALLES JÚNIOR;D",
            "Qual foi o último imperador do Brasil?;D.PEDRO II;D.PEDRO I;D.JOÃO VI;DEODORO DA FONSECA;A",
            "Por quantos integrantes era formado o grupo Beatles?;TRÊS;QUATRO;CINCO;SEIS;B",
            "Camillo é o sobrenome de qual cantor nascido em Brotas?;LEONARDO;CHITÃOZINHO;DANIEL;VINNY;C",
            "Em que cidade fica a sede da rede de TV BBC?;LONDRES;NOVA YORK;MONTREAL;CALIFÓRNIA;A",
            "Qual era a profissão de Cecília Meirelles?;CANTORA;ESCRITORA;ARQUITETA;PIANISTA;B",
            "Qual é a fórmula química da água?;NACL;H2;H2O;CO2;C",
            "Por que nome são conhecidas as pessoas do Pólo Ártico?;SULISTAS;ESQUIMÓS;NORTISTAS;POLARES;B",
            "Quantos são os continentes?;CINCO;SETE;TRÊS;QUATRO;A",
            "Qual é a capital do Estado de Mato Grosso do Sul?;CUIABÁ;VÁRZEA GRANDE;RONDONÓPOLIS;CAMPO GRANDE;D",
            "Qual é o dia da Padroeira do Brasil?;12 DE OUTUBRO;12 DE NOVEMBRO;11 DE DEZEMBRO;1 DE JANEIRO;A",
            "O daltônico é deficiente em?;SENTIR DOR;SENTIR PALADAR;DIFERENCIAR CORES;SENTIR CHEIRO;C",
            "Sobre qual cidade do Japão foi lançada a primeira bomba atômica?;TÓQUIO;NAGASAKI;OSAKA;HIROXIMA;D",
            "Teresina é a capital de qual estado brasileiro?;TOCANTINS;PIAUÍ;ACRE;PARANÁ;B",
            "Em que ano ocorreu o incêndio do edifício Joelma, na cidade de São Paulo?;1971;1972;1973;1974;D",
            "Que animal é usado no jogo de pólo?;CAMELO;CAVALO;MACACO;CACHORRO;B",
            "Qual dessas cobras não é venenosa?;URUTU;CASCAVEL;JARARACA;PÍTON;D",
            "Qual personagem bíblico dividiu as águas do Mar Vermelho?;ABRAÃO;MOISÉS;JOSUÉ;ELIAS;B",
            "Qual o significado da sigla “AI”, no AI-5?;ATO INTENCIONAL;ATO INSTITUCIONAL;ATO INSPIRADOR;ATO IDEALIZADOR;B",
            "Qual é o médico que mais utiliza o eletrocardiograma?;ORTOPEDISTA;CARDIOLOGISTA;DERMATOLOGISTA;ACUPUNTURISTA;B",
            "O nome América foi associado a qual desses nomes?;AMÉRICO DOS REIS;AMÉRICO BRASILIENSE;AMÉRICO VESPÚCIO;JOSÉ AMÉRICO DA SILVA;C",
            "Qual é o nome do Patriarca da Independência do Brasil?;TIRADENTES;JOSÉ BONIFÁCIO;DOM PEDRO II;VASCO DA GAMA;B",
            "Em que país fica a grande muralha com cerca de 6.400 quilômetros?;JAPÃO;CHINA;AFEGANISTÃO;ÍNDIA;B",
            "Em que cidade foram realizados os jogos olímpicos de 2000?;MUNIQUE;SIDNEY;TÓQUIO;ATLANTA;B",
            "Em que cidade brasileira fica o Instituto Tecnológico de Aeronáutica?;SÃO JOSÉ DO RIO PRETO;SÃO JOSÉ DOS PINHAIS;SÃO JOSÉ DOS CAMPOS;SÃO JOSÉ DOS SANTOS;C",
            "O FBI é a polícia federal de qual país?;INGLATERRA;ESTADOS UNIDOS;CANADÁ;FRANÇA;B",
            "A que categoria pertence o cavalo-marinho?;MOLUSCO;CRUSTÁCEO;PEIXE;MAMÍFERO;C",
            "Como é chamado o templo sagrado dos judeus?;IGREJA;CAPELA;SINAGOGA;CATEDRAL;C",
            "Qual presidente dos Estados Unidos foi ator de cinema?;RONALD REAGAN;GEORGE BUSH;RICHARD NIXON;BILL CLINTON;A",
            "Qual é o nome do cachorro de Charlie Brown?;PLUTO;FLOQUINHO;BALEIA;SNOOPY;D"
    }; // Perguntas de nivel 3 - R$ 100.000 até R$ 500.000;

    String[] perguntasNivel4 = {
            "Qual a origem da palavra folclore?;HOLANDESA;INGLESA;FRANCESA;BRASILEIRA;B",
            "Quem ganhou a 1a medalha de ouro olímpico para o Brasil?;AFRANIO ANTONIO COSTA;GUILHERME PARAENSE;FERNANDO SOLEDADE;SEBASTIÃO WOLF;b",
            "Qual é o quarto planeta do sistema solar?;JÚPITER;VÊNUS;TERRA;MARTE;D",
            "Que pintor francês consagrou a mulher taitiana em suas telas?;RENOIR;GAUGUIN;CÉZANNE;MONET;B",
            "O que é glicose?;AMINOÁCIDO;HIDRATO DE CARBONO;LIPÍDIO;PROTEÍNA;B",
            "Qual foi a primeira mulher a entrar no “hall da fama” do rock and roll?;JANIS JOPLIN;CAROLE KING;ARETHA FRANKLIN;DIANA ROSS;C",
            "Nova Caledônia faz parte da:;MICRONÉSIA;MELANÉSIA;POLINÉSIA;INDONÉSIA;B",
            "O que procurava Juan Ponce de Leon quando descobriu a Flórida?;A CIDADE PERDIDA DE OURO;A FONTE DA JUVENTUDE;UNICÓRNIOS;SEU GATO;B",
            "As Ilhas Malvinas também são chamadas de:;STANLEY;WEDELLS;MEDANOSA;FALKLAND;D",
            "Qual destes países não se situa no Equador?;QUÊNIA;EQUADOR;CHILE;INDONÉSIA;C",
            "Em que país Leonardo da Vinci viveu seus últimos dias?;ESPANHA;HOLANDA;FRANÇA;ITÁLIA;C",
            "A que país pertence a Groenlândia?;DINAMARCA;INGLATERRA;NORUEGA;ESTADOS UNIDOS;D",
            "Pablo Picasso foi um dos criadores do:;CUBISMO;SURREALISMO;IMPRESSIONISMO;REALISMO;A",
            "Como se chama o explorador de grutas e cavernas?;ESPELEÓLOGO;AGROSTÓLOGO;PSICÓLOGO;CAMPANÓLOGO;A",
            "A baleia está classificada em qual grupo de mamíferos?;CETÁCEOS;FELINOS;SIRÊNIOS;CARNÍVOROS;A",
            "Qual é a maior ilha da Europa?;GRÃ-BRETANHA;IRLANDA;ISLÂNDIA;SICÍLIA;A",
            "O filme “A noviça rebelde”, premiado com 5 Oscars, foi estrelado por:;JUDY GARLAND;SHIRLEY TEMPLE;JULIE ANDREWS;DORIS DAY;C",
            "Qual foi o primeiro presidente do Brasil eleito pelo povo?;GETÚLIO VARGAS;PRUDENTE DE MORAES;WASHINGTON LUÍS;TANCREDO NEVES;B",
            "O que o pintor Claude Monet representou em suas telas?;OS JARDINS DE GIVERNY;OS BISTRÔS DE PARIS;CENAS DO MOULIN ROUGE;PAISAGENS DA PROVENÇA;A",
            "Miró, Picasso e Salvador Dalí eram pintores:;ITALIANOS;PORTUGUESES;ESPANHÓIS;CHILENOS;C",
            "Como é chamada a gravura impressa sobre pranchas de madeira?;MATEROGRAFIA;LITOGRAFIA;XILOGRAFIA;SERIGRAFIA;C"
    }; // Perguntas de nivel 4 - R$ 1.000.000

    // =============================================================================================

    /** Método random() para gerar número aleatório;
     *
     * Ele recebe um parametro que vem do método setIndice() que passa o nome da lista de perguntas
     * para que seja usado como medida de tamanho a ser percorrida, indo de 0 ao tamanho da lista
     * de perguntas.
     *
     * @return Retorna o valor gerado.
     */
    public Integer random(String[] nivelPergunta){
        int random = (int)(Math.random() * nivelPergunta.length);
        return random;
    }

    // Método para gerar as perguntas ==============================================================

    /** Esse método gera 8 números aleatórios sem repetição. Um número é gerado pelo método random();
     * e adicionado ao atributo valor. Ocorre um condição que verifica se o numero dentro de valor
     * já não se encontra dentro do Array indice, caso não tenha o valor é adicionado ao indice e o
     * contador recebe +1 até chegar em 8 quando ele para de gerar números.
     * Caso o valor já tenha dentro do indice o contador recebe -1, assim ele voltaria para o mesmo
     * giro até que o valor gerado seja um número que não exista no indice.
     *
     * Ele recebe um parametro que vem da Tela Principal que passa o nome da lista de perguntas
     * para que seja usado como medida de tamanho a ser percorrida pelo método random() indo de
     * 0 ao tamanho da lista de perguntas.
     *
     * @return Retorna o Array indice com um conjunto de 8 números;
     */
    public ArrayList<Integer> setIndice(String[] nivelPergunta){

        //int random = (int)(Math.random() * 21);
        String[] nivel = nivelPergunta;

        ArrayList<Integer> indice = new ArrayList<>(); // Atributo do tipo vetor que vai receber 8 numeros;

        // laço que faz o papel de contador para gerar 8 números que serão adicionados no vetor.
        for(int c = 0; c < 8; c++){
            int valor = random(nivel); // Atributo que recebe um valor aleatório;

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
