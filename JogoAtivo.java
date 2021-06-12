import java.awt.image.ImageObserver;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Random;

public class JogoAtivo extends Jogo {

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


    //-------------------------------------------------Auxiliares-------------------------------------------------------
    public static int randomP(double p) {
        return (Math.random() > p) ? 1 : 0;
    }

    public int random(){
        Random r = new Random();
        return r.nextInt(2);
    }

    public void run (){
        StringBuffer sb = new StringBuffer();
        int acontecimento;

        Map<Integer,Jogador> jogTitularesC = super.getTitularesCasa();
        Map<Integer,Jogador> jogTitularesF = super.getTitularesFora();

        double probTrocaDeBola;
        double probMarcar;
        int equipaComBola = random(); //0 -> casa 1-> fora


        for(int i = 0;i<=180; i++) {

            //------------------------------------tempo-------------------------------------

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            //-------------------------------Acontecimentos---------------------------------
            if(i != 90) {
                if (equipaComBola == 0) {
                    probTrocaDeBola = probPerderBola(jogTitularesC, i / 20);
                    acontecimento = randomP(probTrocaDeBola);

                    if (acontecimento == 1) {
                        equipaComBola = 1;

                        super.setEvento("Casa " + getGolosCasa() + " X " + getGolosFora() + " Fora: Posse de Bola: Fora");
                    } else {

                        probMarcar = probMarcarGolo(jogTitularesC, i / 20);
                        acontecimento = randomP(probMarcar);

                        if (acontecimento == 1) {
                            super.setEvento("Casa " + getGolosCasa() + " X " + getGolosFora() + " Fora: Golo de Casa. Posse de Bola: Fora");
                            super.goloCasa();
                            equipaComBola = 1;
                        } else {
                            super.setEvento("Casa " + getGolosCasa() + " X " + getGolosFora() + " Fora: Golo falhado de Casa. Posse de Bola: Fora");
                            equipaComBola = 1;
                        }
                    }
                } else {
                    probTrocaDeBola = probPerderBola(jogTitularesF, i / 20);
                    acontecimento = randomP(probTrocaDeBola);

                    if (acontecimento == 1) {
                        equipaComBola = 0;
                        super.setEvento("Casa " + getGolosCasa() + " X " + getGolosFora() + " Fora: Posse de Bola: Casa");
                    } else {

                        probMarcar = probMarcarGolo(jogTitularesF, i / 20);
                        acontecimento = randomP(probMarcar);

                        if (acontecimento == 1) {
                            super.setEvento("Casa " + getGolosCasa() + " X " + getGolosFora() + " Fora: Golo de Fora. Posse de Bola: Casa");
                            super.goloFora();
                            equipaComBola = 0;
                        } else {
                            super.setEvento("Casa " + getGolosCasa() + " X " + getGolosFora() + " Fora: Golo falhado de Fora. Posse de Bola: Casa");
                            equipaComBola = 0;
                        }
                    }
                }
            }
            else{

                for( Map.Entry<Integer,Integer> jog   : getSubstituicoesCasa().entrySet() )
                    super.setEvento("Substituicao de Casa: "+ jog.getKey() +"->"+jog.getValue());

                for( Map.Entry<Integer,Integer> jog   : getSubstituicoesCasa().entrySet() ){
                    substitutosCasa.put(jog.getKey(),getTitularesCasa().get(jog.getKey()));
                    getTitularesCasa().remove(jog.getKey());
                    getTitularesCasa().put(jog.getValue(),substitutosCasa.get(jog.getValue()));
                    substitutosCasa.remove(jog.getValue());
                }

                for( Map.Entry<Integer,Integer> jog   : getSubstituicoesFora().entrySet() )
                    super.setEvento("Substituicao de Fora: "+ jog.getKey() +"->"+jog.getValue());

                for( Map.Entry<Integer,Integer> jog   : getSubstituicoesFora().entrySet() ){
                    substitutosFora.put(jog.getKey(),getTitularesFora().get(jog.getKey()));
                    getTitularesFora().remove(jog.getKey());
                    getTitularesFora().put(jog.getValue(),substitutosFora.get(jog.getValue()));
                    substitutosFora.remove(jog.getValue());
                }
            }
        }
    }

    //-------------------------------------------------Metodos-------------------------------------------------------

    public double valorEquipaTitular(Map<Integer,Jogador> equipa ){
        return equipa.values().stream().mapToDouble(Jogador::getValorJogador).sum();
    }

    public double valorCruzamentoTitular(Map<Integer,Jogador> equipa){
        return equipa.values().stream().mapToDouble(Jogador::getPasse).sum();
    }

    public double probPerderBola(Map<Integer,Jogador> jogTitulares, int tempo){
        return -((0.67)/(tempo+0.88))+1 - valorCruzamentoTitular(jogTitulares)/1000;
    }

    public double probMarcarGolo (Map<Integer,Jogador> jogTitulares, int tempo){
        return -((0.20)/(tempo+4))+1 - valorEquipaTitular(jogTitulares)/20000;
    }

}