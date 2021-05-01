
/**
 * Escreva a descrição da classe Defesa aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Defesa extends Jogador
{
    
    //Construtor por omissão
    public Defesa(String nome,int numeroJogador,double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        super(nome, numeroJogador, valorJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(Jogador defesa){
        return 0.5*(double)defesa.getDestreza()+
               0.3*(double)defesa.getPasse() +
               0.2*((double)defesa.getVelocidade() + (double)defesa.getResistencia() + (double)defesa.getImplusao() + (double)defesa.getRemate() + (double)defesa.getCabecear());
    
    }
    
}
