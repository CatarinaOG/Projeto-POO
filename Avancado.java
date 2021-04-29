/**
 * Escreva a descrição da classe Avancado aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Avancado extends Jogador
{
    
    //Construtor por omissão
    public Avancado(String nome,int posicao,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        return 0.8 *((double)implusao + (double)remate + (double)cabecear + (double)resistencia) + 0.1*(double)velocidade + 0.1*((double)destreza + (double)passe);
    
    }
    
}
