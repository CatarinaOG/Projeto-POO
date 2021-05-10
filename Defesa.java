
/**
 * Escreva a descrição da classe Defesa aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Defesa extends Jogador
{
    
    //Construtor por omissão
    public Defesa(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, double valorJogador){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.5*(double)this.destreza+ 0.3*(double)this.passe + 0.2*((double)this.velocidade + (double)this.resistencia + (double)this.implusao + (double)this.remate + (double)this.cabecear);
    }
    
    public Jogador clone(){
        return new Defesa(this.nome, this.numeroJogador, this.velocidade, this.resistencia, this.destreza, this.implusao, this.cabecear, this.remate, this.passe, this.valorJogador);   
    }
    
}
