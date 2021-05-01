
/**
 * Escreva a descrição da classe Lateral aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Lateral extends Jogador
{
    
    //Construtor por omissão
    public Lateral(String nome,int numeroJogador,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, numeroJogador, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    
    public int cruzamento;

    //Metodo para saber o overall do Jogador
    public double valorJogador(Jogador lateral){
        return 0.7*((double)velocidade + (double)resistencia + (double)this.cruzamento) + 0.2*((double)cabecear + (double)remate + (double)implusao) + 0.1*((double)destreza + (double)passe);
    
    }
    
}
