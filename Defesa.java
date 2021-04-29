
/**
 * Escreva a descrição da classe Defesa aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Defesa extends Jogador
{
    
    //Construtor por omissão
    public Defesa(String nome,int posicao,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        return 0.5*(double)destreza+ 0.3*(double)passe + 0.2*((double)velocidade + (double)resistencia + (double)implusao + (double)remate + (double)cabecear);
    
    }
    
}
