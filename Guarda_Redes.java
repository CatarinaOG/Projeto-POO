
/**
 * Escreva a descrição da classe Guarda_Redes aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Guarda_Redes extends Jogador
{
    
    //Construtor por omissão
    public Guarda_Redes(String nome,int posicao,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    
    public int elasticidade;

    //Metodo para saber o overall do Jogador
    public double valorJogador(int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        return 0.6* (double)this.elasticidade + 0.1*(double)remate + 0.3*(double)destreza;
    
    }
    
}
