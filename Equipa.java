import java.util.*;
import java.util.stream.Collectors;

public class Equipa
{
    private String nome;
    private int nrJogadores;
    private Map <Integer,Jogador> jogadores;
    private List<Jogador> jogadoresTitulares;
    private List<Jogador> jogadoresSuplentes;
    
    //-----------------------------------------------------construtores------------------------------------------------------
    
    public Equipa(String nome){
        this.nome = nome;
        this.nrJogadores = 0;
        this.jogadores = new HashMap<>();
        this.jogadoresTitulares = new ArrayList<>(11);
        this.jogadoresSuplentes = new ArrayList<>(11);
    }
    
    public Equipa(String nome, int nrJogadores, Map<Integer,Jogador> jogadores){
        this.nome = nome;
        this.nrJogadores = nrJogadores;
        this.jogadores = jogadores.values().stream().collect(Collectors.toMap( Jogador::getNrCamisola , Jogador::clone));
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
    
    public Map<Integer,Jogador> getJogadores(){
        return this.jogadores.values().stream().collect(Collectors.toMap( Jogador::getNrCamisola , Jogador::clone));
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
    
    public void setJogadores(Map<Integer,Jogador> j){
        this.jogadores = j;
    }
    
    public void setJogadoresTitulares(List<Jogador> jogadoresTitulares){
        this.jogadoresTitulares = jogadoresTitulares;
    }
    
    public void setJogadoresSuplentes(List<Jogador> jogadoresSuplentes){
        this.jogadoresSuplentes = jogadoresSuplentes;
    }

    //---------------------------------------------------métodos base---------------------------------------------------

    public Equipa clone(){
        return new Equipa(this.getNome(),this.getNrJogadores(),this.getJogadores());
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();

        for(Jogador j : this.jogadores.values())
            sb.append(j.toString());

        return sb.toString();
    }
    
    //-----------------------------------------------------métodos------------------------------------------------------
    
    public void addJogador(Jogador jogador){
        if (this.nrJogadores < 18){
            this.jogadores.put(jogador.getNrCamisola(),jogador);
            this.nrJogadores++;
            jogador.addHistorial(this.getNome());
        }
    }
    
    public void removeJogador(Jogador jogador){
        this.jogadores.remove(jogador);
        this.nrJogadores--;
    }

    public Jogador getJogador(Integer nr){
        return this.jogadores.get(nr);
    }

    public static Equipa parse(String input){
        String[] campos = input.split(",");
        return new Equipa(campos[0]);
    }

}