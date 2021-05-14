import java.util.List;
import java.util.ArrayList;

//Gerson Henrique de Araujo Junior
//29-03-2021

public abstract class Jogador
{
    private String nome;
    private int numeroJogador;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int implusao;
    private int cabecear;
    private int remate;
    private int passe;
    private double valorJogador;
    private List<String> historial;
    
    
    public Jogador(){
        this.nome = "";
        this.numeroJogador = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.implusao = 0;
        this.cabecear = 0;
        this.remate = 0;
        this.passe = 0;
        this.valorJogador = 0;
        this.historial = new ArrayList<>();
    }
    
    //Construtor parametrizado
    public Jogador(String nome,int numeroJogador, int velocidade, int resistencia, int destreza, int implusao, int cabecear, int remate, int passe, double valorJogador, List<String> historial){
        this.nome = nome;
        this.numeroJogador = numeroJogador;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.implusao = implusao;
        this.cabecear = cabecear;
        this.remate = remate;
        this.passe = passe;
        this.valorJogador = valorJogador;
        this.historial = historial;
    }
    
    //Construtor de copia
    public Jogador(Jogador umJogador){
        this.nome = umJogador.getNome();
        this.numeroJogador = umJogador.getNumeroJogador();
        this.velocidade = umJogador.getVelocidade();
        this.resistencia = umJogador.getResistencia();
        this.destreza = umJogador.getDestreza();
        this.implusao = umJogador.getImplusao();
        this.cabecear = umJogador.getCabecear();
        this.remate = umJogador.getRemate();
        this.passe = umJogador.getPasse();
        this.valorJogador = umJogador.getValorJogador();
        this.historial = umJogador.getHistorial();
    }

    public String getNome(){
        return this.nome;
    }
    
    public int getNumeroJogador(){
        return this.numeroJogador;
    }
    
    public int getVelocidade(){
        return this.velocidade;
    }
    
    public int getResistencia(){
        return this.resistencia;
    }
    
    public int getDestreza(){
        return this.destreza;
    }
    
    public int getImplusao(){
        return this.implusao;
    }
    
    public int getCabecear(){
        return this.cabecear;
    }
    
    public int getRemate(){
        return this.remate;
    }
    
    public int getPasse(){
        return this.passe;
    }
    
    public double getValorJogador(){
        return this.valorJogador;
    }
    
    public List<String> getHistorial(){
        return this.historial;
    }
    
    //--------------------------------------------------------------------------\\
    
    public void setValorJogador(String nome){
        this.nome = nome;
    }
    
    public void setNumeroJogador(int numeroJogador){
        this.numeroJogador = numeroJogador;
    }
    
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    
    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }
    
    public void setDestreza(int destreza){
        this.destreza = destreza;
    }
    
    public void setImplusao(int implusao){
        this.implusao = implusao;
    }
    
    public void setCabecear(int cabecear){
        this.cabecear = cabecear;
    }
    
    public void setRemate(int remate){
        this.remate = remate;
    }
    
    public void setPasse(int passe){
        this.passe = passe;
    } 
        
    public void setValorJogador(double valorJogador){
        this.valorJogador = valorJogador;
    }
    
    public void setHistorial(List<String> historial){
        this.historial = historial;
    }
    
    public void addHistorial(String equipa){
        this.historial.add(equipa);
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Nome: "+getNome()+"\n");
        sb.append("NumeroJogador: "+getNumeroJogador()+"\n");
        sb.append("Velocidade: "+getVelocidade()+"\n");
        sb.append("Resistencia: "+getResistencia()+"\n");
        sb.append("Destreza: "+getDestreza()+"\n");
        sb.append("Impulsao: "+getImplusao()+"\n");
        sb.append("Cabecear: "+getCabecear()+"\n");

        return sb.toString();
    }

}
