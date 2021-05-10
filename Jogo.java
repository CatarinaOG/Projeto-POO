import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class Jogo{
    
    private Equipa equipa1;
    private Equipa equipa2;
    private LocalDateTime data;
    private int estadoJogo;
    private List<Jogador> golos1;
    private List<Jogador> golos2;
    private static final int porIniciar = 0;
    private static final int aDecorrer = 1;
    private static final int terminado = 2;
    
    public Jogo(Equipa e1 , Equipa e2, int estadio){
        this.equipa1 = e1;
        this.equipa2 = e2;
        this.data = LocalDateTime.now();
        this.estadoJogo = porIniciar;
        this.golos1 = new ArrayList();
        this.golos2 = new ArrayList();        
    }
    
    // Passar uma copia dos jogadores
    public void startJogo(List<Jogador> jTitulares1 , List<Jogador> jTitulares2, List<Jogador> jSuplentes1 , List<Jogador> jSuplentes2){
        this.estadoJogo = aDecorrer;
        this.equipa1.setJogadoresTitulares(jTitulares1);
        this.equipa2.setJogadoresTitulares(jTitulares2);
        this.equipa1.setJogadoresSuplentes(jSuplentes1);
        this.equipa2.setJogadoresSuplentes(jSuplentes2);
    }
    
}
