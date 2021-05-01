import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
 

public class Equipa
{
    private String nome;
    private int nrJogadoresPrincipais;
    private int nrJogadoresSuplentes;
    private List<Jogador> jogadoresPrincipais;
    private List<Jogador> jogadoresSuplentes;
    private int nrDefesas;
    private int nrMedios;
    private int nrAvancados;
    private int nrLaterais;
    private int nrGuardaRedes;
    
    //-----------------------------------------------------construtores------------------------------------------------------
    
    public Equipa(){
        this.nome = "";
        this.nrJogadoresPrincipais = 0;
        this.nrJogadoresSuplentes = 0;
        this.jogadoresPrincipais = new ArrayList<>(11);
        this.jogadoresSuplentes = new ArrayList<>(11);
        this.nrDefesas = 0;
        this.nrMedios = 0;
        this.nrAvancados = 0;
        this.nrLaterais = 0;
        this.nrGuardaRedes = 0;
    }
    
    public Equipa(String nome, int nrJogadoresPrincipais, int nrJogadoresSuplentes, List<Jogador> jogadoresPrincipais, List<Jogador> jogadoresSuplentes, int nrDefesas, int nrMedios, int nrAvancados, int nrLaterais, int nrGuardaRedes){
        this.nome = nome;
        this.nrJogadoresPrincipais = nrJogadoresPrincipais;
        this.nrJogadoresSuplentes = nrJogadoresSuplentes;
        this.jogadoresPrincipais = jogadoresPrincipais.stream().map(Jogador::clone).collect(Collectors.toList());
        this.jogadoresSuplentes = new ArrayList<>(11);
        this.nrDefesas = nrDefesas;
        this.nrMedios = nrMedios;
        this.nrAvancados = nrAvancados;
        this.nrLaterais = nrLaterais;
        this.nrGuardaRedes = nrGuardaRedes;
    }
    
    public Equipa(Equipa equipa){
        this.nome = equipa.getNome();
        this.nrJogadoresPrincipais = equipa.getNrJogadoresPrincipais();
        this.nrJogadoresSuplentes = equipa.getNrJogadoresSuplentes();
        this.jogadoresPrincipais = equipa.getJogadoresPrincipais();
        this.jogadoresSuplentes = equipa.getJogadoresSuplentes();
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
    
    public int getNrJogadoresPrincipais(){
        return this.nrJogadoresPrincipais;
    }
    
    public int getNrJogadoresSuplentes(){
        return this.nrJogadoresSuplentes;
    }
    
    public List<Jogador> getJogadoresPrincipais(){
        return this.jogadoresPrincipais.stream().map(Jogador::clone).collect(Collectors.toList());
    }
    
    public List<Jogador> getJogadoresSuplentes(){
        return this.jogadoresSuplentes.stream().map(Jogador::clone).collect(Collectors.toList());
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
    
    //-----------------------------------------------------seters------------------------------------------------------
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setNrJogadoresPrinciapais(int nrJogadoresPrincipais){
        this.nrJogadoresPrincipais = nrJogadoresPrincipais;
    }
    
    public void getNrJogadoresSuplentes(int nrJogadoresSuplentes){
        this.nrJogadoresSuplentes = nrJogadoresSuplentes;
    }
    
    public void setJogadoresPrincipais(List<Jogador> jogadoresPrincipais){
        this.jogadoresPrincipais = jogadoresPrincipais.stream().map(Jogador::clone).collect(Collectors.toList());
    }
    
    public void getJogadoresSuplentes(List<Jogador> jogadoresSuplentes){
        this.jogadoresSuplentes = jogadoresSuplentes.stream().map(Jogador::clone).collect(Collectors.toList());
    }
    
    public void getNrdefesas(int nrDefesas){
        this.nrDefesas = nrDefesas;
    }
    
    public void getNrMedios(int nrMedios){
        this.nrMedios = nrMedios;
    }
    
    public void getNrAvancados(int nrAvancados){
        this.nrAvancados = nrAvancados;
    }
    
    public void getNrLaterais(int nrLaterais){
        this.nrLaterais = nrLaterais;
    }
    
    public void getNrGuardaRedes(int nrGuardaRedes){
        this.nrGuardaRedes = nrGuardaRedes;
    }
    
    //-----------------------------------------------------métodos------------------------------------------------------
    
    public int addJogadorPrincipal(Jogador jogador){
        if (this.nrJogadoresPrincipais < 11){
            this.jogadoresPrincipais.add(jogador);
            this.nrJogadoresPrincipais++;
            return 0;
        }
        else return 1;
    }
    
    public int addJogadorSuplente(Jogador jogador){
        if (this.nrJogadoresSuplentes < 11){
            this.jogadoresSuplentes.add(jogador);
            this.nrJogadoresSuplentes++;
            return 0;
        }
        else return 1;
    }
    
    public Double valorEquipa(){
        return this.jogadoresPrincipais.stream().mapToDouble(Jogador::valorJogador).sum();
    }

}