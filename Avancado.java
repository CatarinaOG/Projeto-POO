/**
 * Escreva a descrição da classe Avancado aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Avancado extends Jogador
{
    
    //Construtor por omissão
    public Avancado(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, double valorJogador){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.8 *((double)this.implusao + (double)this.remate + (double)this.cabecear + (double)this.resistencia) + 0.1*(double)this.velocidade + 0.1*((double)this.destreza + (double)this.passe);
    }
    
    public Jogador clone(){
        return new Avancado(this.nome, this.numeroJogador, this.velocidade, this.resistencia, this.destreza, this.implusao, this.cabecear, this.remate, this.passe, this.valorJogador);   
    }
}
