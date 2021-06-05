import java.awt.image.ImageObserver;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class JogoAtivo extends Jogo{

    /*
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private Map<Integer,Jogador> titularesCasa;
    private Map<Integer,Jogador> titularesFora;
    private Map<Integer,Integer> substituicoesCasa;
    private Map<Integer,Integer> substitucoesFora;
    private final LocalDate data;
     */
    private Map<Integer,Jogador> substitutosCasa;
    private Map<Integer,Jogador> substitutosFora;

    //-------------------------------------------------Construtor-------------------------------------------------------
    public JogoAtivo(String ec, String ef, int gc, int gf, LocalDate d, Map<Integer, Jogador> titularesC, Map<Integer, Jogador> substitutosC, Map<Integer, Integer> substituicoesC, Map<Integer, Jogador> titularesF,Map<Integer, Jogador> substitutosF, Map<Integer, Integer> substituicoesF){
        super(ec, ef, gc, gf, d, titularesC, substituicoesC, titularesF, substituicoesF);
        this.substitutosCasa = substitutosC;
        this.substitutosFora = substitutosF;
    }

    public static int randomP(double p) {
        return (Math.random() < p) ? 1 : 0;
    }
    public static int sizeA (int [] n){
        if(n[0] != 1) return 0;
        int j = 0;
        for (int i = 0; n[i] == 1; i++) j = i;
        return j+1;
    }
    //-------------------------------------------------Sets e Gets-------------------------------------------------------
    public Map<Integer, Jogador> getSubstitutosCasa() {
        return substitutosCasa;
    }

    public static double probabilidade (double eq1,double eq2){
        double temp;
        temp = eq1 + eq2;
        return eq1/temp;
    public void setSubstitutosCasa(Map<Integer, Jogador> substitutosCasa) {
        this.substitutosCasa = substitutosCasa;
    }

    //Isto esta feito para o interpertador se for para ser em aplicacao tem que ser de maneira ligeiramente diferente, e falta adicionar o calculo da prob_eq pois ainda preciso
    // do valor das equipas para fazer uma funcao que faca a probabilidade
    //E tambem esta sem substituacoes nao estou conseguir fazer isso

    private static void runJogo (){
        int acontecimento,golos1,golos2;
        int ac, j = 0,f = 0;
        int [] golo1 = new int[90];
        int [] golo2 = new int[90];
        double prob, prob_eq = 0.75;
        double temp;
        //String text = "";


        for(int i = 0;i<=90; i++) {

            //prob_eq = probabilidade(valorEqupa(titularesCasa), valorEquipa(titularesFora));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if(prob_eq < 0.5) prob_eq = 1-prob_eq;

            temp = (i+4);
            prob = -(prob_eq / temp) + 1;
            acontecimento = randomP(prob);

            if (acontecimento == 0){
                ac = randomP(prob_eq);
                if (ac == 1) {
                    golo1[j] = 1;
                    j++;
                    //text = text.concat("Equipa1 marcou no minuto ").concat(String.valueOf(i)).concat(" \n");
                    System.out.printf("Equipa1 marcou no minuto %d\n", i);
                }
                else {
                    golo2[f] = 1;
                    f++;
                    //text = text.concat("Equipa2 marcou no minuto ").concat(String.valueOf(i)).concat(" \n");
                    System.out.printf("Equipa2 marcou no minuto %d\n", i);
                }
            }
            //text = text.concat("Minutos").concat(String.valueOf(i)).concat(" \n");
            //System.out.printf("Minuto %d\n", i);
        }
        golos1 = sizeA(golo1);
        golos2 = sizeA(golo2);

        //text = text.concat("Equipa1 : ").concat(String.valueOf(golos1)).concat(" x ").concat(String.valueOf(golos2)).concat(" : Equipa2\n");
        System.out.printf("Eq1 : %d x %d : Eq2", golos1,golos2);



    }

   // public static void main(String[] args) {
   //     runJogo();
   //  }

    public Map<Integer, Jogador> getSubstitutosFora() {
        return substitutosFora;
    }

    public void setSubstitutosFora(Map<Integer, Jogador> substitutosFora) {
        this.substitutosFora = substitutosFora;
    }

    //-------------------------------------------------Metodos-------------------------------------------------------


    public void run(){











    }

    public double valorEquipaTitular(Map<Integer,Jogador> equipa ){
        return equipa.values().stream().mapToDouble(Jogador::getValorJogador).sum();
    }

}