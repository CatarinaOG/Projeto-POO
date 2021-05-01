/**
 * Escreva a descrição da classe Avancado aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Avancado extends Jogador
{
    
    //Construtor por omissão
    public Avancado(String nome,int numeroJogador,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, numeroJogador, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    
    //Metodo para saber o overall do Jogador
    public double valorJogador(Jogador avancado){
        return 0.8 *((double)avancado.getImplusao()+(double)avancado.getRemate()+(double)avancado.getCabecear()+(double)avancado.getResistencia())+
               0.1*(double)avancado.getVelocidade()+
               0.1*((double)avancado.getDestreza() +(double)avancado.Passe());
    }
    
}
