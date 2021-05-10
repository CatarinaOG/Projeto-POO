import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

public class Equipa
{
    private String nome;
    private int nrJogadores;
    private Map <String,Jogador> jogadores;
    private List<Jogador> jogadoresTitulares;
    private List<Jogador> jogadoresSuplentes;
    
    //-----------------------------------------------------construtores------------------------------------------------------
    
    public Equipa(){
        this.nome = "";
        this.nrJogadores = 0;
        this.jogadores = new HashMap<>();
        this.jogadoresTitulares = new ArrayList<>(11);
        this.jogadoresSuplentes = new ArrayList<>(11);
    }
    
    public Equipa(String nome, int nrJogadores, Map<String,Jogador> jogadores){
        this.nome = nome;
        this.nrJogadores = nrJogadores;
        this.jogadores = jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        this.jogadoresTitulares = new ArrayList<>(11);
        this.jogadoresSuplentes = new ArrayList<>(11);
    }
    
    public Equipa(Equipa equipa){
        this.nome = equipa.getNome();
        this.nrJogadores = equipa.getNrJogadores();
        this.jogadores = equipa.getJogadores();
        this.jogadoresTitulares = new ArrayList<>(11);
        this.jogadoresSuplentes = new ArrayList<>(11);
    }
    
    //-----------------------------------------------------gets------------------------------------------------------
    
    public String getNome(){
        return this.nome;
    }
    
    public int getNrJogadores(){
        return this.nrJogadores;
    }
    
    public Map<String,Jogador> getJogadores(){
        return this.jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
    
    public List<Jogador> getJogadoresTitulares(){
        return this.jogadoresTitulares;
    }
    
    public List<Jogador> getJogadoresSuplentes(){
        return this.jogadoresSuplentes;
    }
    
    //-----------------------------------------------------seters------------------------------------------------------
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNrJogadores(int nrJogadores){
        this.nrJogadores = nrJogadores;
    }
    
    public void setJogadores(Map<String,Jogador> j){
        this.jogadores = j;
    }
    
    public void setJogadoresTitulares(List<Jogador> jogadoresTitulares){
        this.jogadoresTitulares = jogadoresTitulares;
    }
    
    public void setJogadoresSuplentes(List<Jogador> jogadoresSuplentes){
        this.jogadoresSuplentes = jogadoresSuplentes;
    }

    
    //-----------------------------------------------------métodos------------------------------------------------------
    
    public int addJogador(Jogador jogador){
        if (this.nrJogadores < 18){
            this.jogadores.put(jogador.getNome(),jogador);
            this.nrJogadores++;
            return 0;
        }
        else return 1;
    }
    
    public void removeJogador(Jogador jogador){
        this.jogadores.remove(jogador);
        this.nrJogadores--;
    }

}