//Gerson Henrique de Araujo Junior
//29-03-2021

public class Jogador
{
    public String nome;
    public double valorJogador;
    public int velocidade;
    public int resistencia;
    public int destreza;
    public int implusao;
    public int cabecear;
    public int remate;
    public int passe;
        
    //Construtor parametrizado
    public Jogador(String nome, double valorJogador, int velocidade, int resistencia, int destreza, int implusao, int cabecear, int remate, int passe){
        this.nome = nome;
        this.valorJogador = valorJogador;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.implusao = implusao;
        this.cabecear = cabecear;
        this.remate = remate;
        this.passe = passe;
    }
    
    //Construtor de copia
    public Jogador(Jogador umJogador){
        this.nome = umJogador.getNome();
        this.valorJogador = umJogador.getValorJogador();
        this.velocidade = umJogador.getVelocidade();
        this.resistencia = umJogador.getResistencia();
        this.destreza = umJogador.getDestreza();
        this.implusao = umJogador.getImplusao();
        this.cabecear = umJogador.getCabecear();
        this.remate = umJogador.getRemate();
        this.passe = umJogador.getPasse();
    }  
    
    public String getNome(){
        return this.nome;
    }
    
    public double getValorJogador(){
        return this.valorJogador;
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
    
    //--------------------------------------------------------------------------\\
    
    public void setValorJogador(String nome){
        this.nome = nome;
    }
    
    public void setValorJogador(double valorJogador){
        this.valorJogador = valorJogador;
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
    
    //Metodo para saber o overall do Jogador
    public double valorJogador(int velocidade, int resistencia, int destreza, int implusao, int cabecear, int remate, int passe){
        return ((double) velocidade + (double) resistencia + (double) destreza + (double) implusao + (double)cabecear + (double) remate + (double) passe) / 7;
    }
    /*
    public void cloneJogador(){
        return new Jogador(this);
    }
    */
}
