import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class JogoAtivo extends Jogo{

    private List<Integer> titularesCasa;
    private List<Integer> titularesFora;

    public JogoAtivo(String ec, String ef, int gc, int gf, LocalDate d, Map<Integer, Jogador> jc, Map<Integer, Integer> sc, Map<Integer, Jogador> jf, Map<Integer, Integer> sf, List<Integer> tc, List<Integer> tf){
        super(ec, ef, gc, gf, d, jc, sc, jf, sf);
        this.titularesCasa = tc;
        this.titularesFora = tf;
    }

    public List<Integer> getTitularesCasa() {
        return titularesCasa;
    }

    public void setTitularesCasa(List<Integer> titularesCasa) {
        this.titularesCasa = titularesCasa;
    }

    public List<Integer> getTitularesFora() {
        return titularesFora;
    }

    public void setTitularesFora(List<Integer> titularesFora) {
        this.titularesFora = titularesFora;
    }

    public void run(){









    }


}