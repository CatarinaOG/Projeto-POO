import java.util.Map;
import java.util.HashMap;

public class Model
{
    private Map<String,Equipa> equipas;
    private Map<String,Jogador> jogadores;
    
    public Model(){
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
    }
    
    public void addJogador(Jogador j){
        this.jogadores.put(j.getNome(),j);
    }
    
    public void addEquipa( String nome){
        Equipa e = new Equipa(nome);
        this.equipas.put(e.getNome(),e);
    }
    
    public void addJogadorToTeam(String j, String t){
        Jogador jogador = this.jogadores.get(j);
        this.equipas.get(t).addJogador(jogador);
    }
    
    public void switchJogador(Jogador j, String t1, String t2){
        this.equipas.get(t1).removeJogador(j);
        this.equipas.get(t2).addJogador(j);
    }

    public Jogador getJogador(String nome){
        return jogadores.get(nome);
    }

    public Equipa getEquipa(String nome){return equipas.get(nome); }


}
