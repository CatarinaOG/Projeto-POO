import java.time.LocalDateTime;

public class Jogo{
    
    private Equipa equipa1;
    private Equipa equipa2;
    private LocalDateTime data;
    private int estadio;
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
        this.estadio = estadio;
        this.estadoJogo = porIniciar;
        this.golos1 = new ArrayList();
        this.golos2 = new ArrayList();        
    }
    
    
    public void startJogo(List<Jogador> jTitulares1 , List<Jogador> jTitulares2){
        this.estadoJogo = aDecorrer;
        this.equipa1.setJogadoresTitulares(jTitulares1);
        this.equipa2.setJogadoresTitulares(jTitulares2);
        List<Jogador> jSuplentes1 = equipa1.findJogadoresSuplentes(jTitulares1);
        List<Jogador> jSuplentes2 = equipa2.findJogadoresSuplentes(jTitulares2);
        this.equipa1.setJogadoresSuplentes(jSuplentes1);
        this.equipa2.setJogadoresSuplentes(jSuplentes2);
        
    }
    
}
