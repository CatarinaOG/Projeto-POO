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

    public void runJogo(){

        
    }

}
