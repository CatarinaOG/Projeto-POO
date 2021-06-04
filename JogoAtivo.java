import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class JogoAtivo extends Jogo{

    private List<Integer> titularesCasa;
    private List<Integer> titularesFora;
    private List<Integer> substitutosCasa;
    private List<Integer> substitutosFora;

    public JogoAtivo(String ec, String ef, int gc, int gf, LocalDate d, Map<Integer, Jogador> jc, Map<Integer, Integer> sc, Map<Integer, Jogador> jf, Map<Integer, Integer> sf, List<Integer> tc , List<Integer> substitutosC , List<Integer> tf, List<Integer> substitutosF) {
        super(ec, ef, gc, gf, d, jc, sc, jf, sf);
        this.titularesCasa = tc;
        this.titularesFora = tf;
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

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

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
            // System.out.printf("Minuto %d\n", i);
        }
        golos1 = sizeA(golo1);
        golos2 = sizeA(golo2);

        //text = text.concat("Equipa1 : ").concat(String.valueOf(golos1)).concat(" x ").concat(String.valueOf(golos2)).concat(" : Equipa2\n");
        System.out.printf("Eq1 : %d x %d : Eq2", golos1,golos2);



    }

    //public static void main(String[] args) {
    //    runJogo();
    //}

}
