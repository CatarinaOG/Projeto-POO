import java.util.Map;
import java.util.HashMap;

public class Dados
{
    private Map<String,Equipa> equipas;
    private Map<String,Jogador> jogadores;
    
    public Dados(){
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
    }
    
    public void createJogador(Jogador j){
        this.jogadores.put(j.getNome(),j);   
    }
    
    public void createEquipa( Equipa e){
        this.equipas.put(e.getNome(),e);
    }
    
    public void addJogadorToTeam(Jogador j, String t, String tipo){
        this.equipas.get(t).addJogador(j);
    }
    
    public void switchJogador(Jogador j, String t1, String t2){
        this.equipas.get(t1).removeJogador(j);
        this.equipas.get(t2).addJogador(j);
    }
    
    
    public static void main(String[] args) {
    }
}
