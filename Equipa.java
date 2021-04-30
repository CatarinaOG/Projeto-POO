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
    private int nrDefesas;
    private int nrMedios;
    private int nrAvancados;
    private int nrLaterais;
    private int nrGuardaRedes;
    
    //-----------------------------------------------------construtores------------------------------------------------------
    
    public Equipa(){
        this.nome = "";
        this.nrJogadores = 0;
        this.jogadores = new HashMap<>();
        this.nrDefesas = 0;
        this.nrMedios = 0;
        this.nrAvancados = 0;
        this.nrLaterais = 0;
        this.nrGuardaRedes = 0;
    }
    
    public Equipa(String nome, int nrJogadores, Map<String,Jogador> jogadores, int nrDefesas, int nrMedios, int nrAvancados, int nrLaterais, int nrGuardaRedes){
        this.nome = nome;
        this.nrJogadores = nrJogadores;
        this.jogadores = jogadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue)); //carefull
        this.nrDefesas = nrDefesas;
        this.nrMedios = nrMedios;
        this.nrAvancados = nrAvancados;
        this.nrLaterais = nrLaterais;
        this.nrGuardaRedes = nrGuardaRedes;
    }
    
    public Equipa(Equipa equipa){
        this.nome = equipa.getNome();
        this.nrJogadores = equipa.getNrJogadores();
        this.jogadores = equipa.getJogadores();
        this.nrDefesas = equipa.getNrDefesas();
        this.nrMedios = equipa.getNrMedios();
        this.nrAvancados = equipa.getNrAvancados();
        this.nrLaterais = equipa.getNrLaterais();
        this.nrGuardaRedes = equipa.getNrGuardaRedes();
    }
    
    //-----------------------------------------------------gets------------------------------------------------------
    
    public String getNome(){
        return this.nome;
    }
    
    public int getNrJogadores(){
        return this.nrJogadores;
    }
    
    public Map<String,Jogador> getJogadores(){
        return this.jogadores.entrySet().stream().map(Jogador::setValue(getValue.clone())).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
    
    public int getNrDefesas(){
        return this.nrDefesas;
    }
    
    public int getNrMedios(){
        return this.nrMedios;
    }
    
    public int getNrAvancados(){
        return this.nrAvancados;
    }
    
    public int getNrLaterais(){
        return this.nrLaterais;
    }
    
    public int getNrGuardaRedes(){
        return this.nrGuardaRedes;
    }
    
    public List getJogadoresSuplentes(){
        return this.jogadoresSuplentes;
    }
    
    public List getJogadoresTitulares(){
        return this.jogadoresTitulares;
    } 
    
    //-----------------------------------------------------seters------------------------------------------------------
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNrJogadoresTitulares(int nrJogadoresTitulares){
        this.nrJogadores = nrJogadores;
    }
    
    public void setJogadoresPrincipais(Map<String,Jogador> j){
        this.jogadores = j.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
    
    public void setNrdefesas(int nrDefesas){
        this.nrDefesas = nrDefesas;
    }
    
    public void setNrMedios(int nrMedios){
        this.nrMedios = nrMedios;
    }
    
    public void setNrAvancados(int nrAvancados){
        this.nrAvancados = nrAvancados;
    }
    
    public void setNrLaterais(int nrLaterais){
        this.nrLaterais = nrLaterais;
    }
    
    public void setNrGuardaRedes(int nrGuardaRedes){
        this.nrGuardaRedes = nrGuardaRedes;
    }
    
    public void setJogadoresSuplentes(List<Jogador> jSuplentes){
        this.jogadoresSuplentes = jSuplentes;
    }
    
    public void setJogadoresTitulares(List<Jogador> jTitulares){
        this.jogadoresTitulares = jTitulares;
    } 
    
    //-----------------------------------------------------métodos------------------------------------------------------
    
    public int addJogador(Jogador jogador){
        if (this.nrJogadores < 18){
            this.jogadores.put(jogador.getName(),jogador);
            this.nrJogadores++;
            return 0;
        }
        else return 1;
    }
    
    public int removeJogador(Jogador jogador){
        this.jogadores.remove(jogador);
    }
    
    public List findJogadoresSuplentes(List<Jogador> titulares){
        
        List<Jogador> suplentes = new ArrayList();
        
        //this.jogadores.getValue.stream.map(Jogador::removeJogador).collect(Collectors.toList
        
        for(Jogador j: this.jogadores ){
            
            
            
        }
        

}