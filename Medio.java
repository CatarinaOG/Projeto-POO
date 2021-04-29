
/**
 * Escreva a descrição da classe Medio aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Medio extends Jogador
{
    
    //Construtor por omissão
    public Medio(String nome,int posicao,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        return 0.7*((double)passe + (double)destreza + (double)velocidade) + 0.3*((double)resistencia + (double)cabecear + (double)remate+ (double)implusao);
    
    }
    
}
