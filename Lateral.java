
/**
 * Escreva a descrição da classe Lateral aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Lateral extends Jogador
{
    private int cruzamento;
    
    //Construtor por omissão
    public Lateral(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, int cruzamento, double valorJogador){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador);
        this.cruzamento = cruzamento;
    }

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.7*((double)this.velocidade + (double) this.resistencia + (double) this.cruzamento) + 0.2*((double) this.cabecear + (double) this.remate + (double)this.implusao) + 0.1*((double) this.destreza + (double) this.passe);
    
    }
    
    public Jogador clone(){
        return new Lateral(this.nome, this.numeroJogador, this.velocidade, this.resistencia, this.destreza, this.implusao, this.cabecear, this.remate, this.passe,this.cruzamento, this.valorJogador);   
    }
}
