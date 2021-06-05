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

    //-------------------------------------------------Sets e Gets-------------------------------------------------------
    public Map<Integer, Jogador> getSubstitutosCasa() {
        return substitutosCasa;
    }

    public void setSubstitutosCasa(Map<Integer, Jogador> substitutosCasa) {
        this.substitutosCasa = substitutosCasa;
    }

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