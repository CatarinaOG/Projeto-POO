
/**
 * Escreva a descrição da classe Guarda_Redes aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Guarda_Redes extends Jogador
{
    private int elasticidade; 
    
    //Construtor por omissão
    public Guarda_Redes(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, int elasticidade, double valorJogador){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador);
        this.elasticidade = elasticidade;
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.6* (double)this.elasticidade + 0.1*(double)this.remate + 0.3*(double)this.destreza;
    }
    
    public Jogador clone(){
        return new Guarda_Redes(this.nome, this.numeroJogador, this.velocidade, this.resistencia, this.destreza, this.implusao, this.cabecear, this.remate, this.passe,this.elasticidade, this.valorJogador);
    }
    
}
