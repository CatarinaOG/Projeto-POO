
/**
 * Escreva a descrição da classe Medio aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Medio extends Jogador
{
    
    //Construtor por omissão
    public Medio(String nome,int numeroJogador,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, numeroJogador, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(Jogador medio){
        return 0.7*((double)medio.getPasse() + (double)medio.getDestreza() + (double)medio.getVelocidade()) +
               0.3*((double)medio.getResistencia() + (double)medio.getCabecear() + (double)medio.getRemate()+ (double)medio.getImplusao());
    
    }
    
}
