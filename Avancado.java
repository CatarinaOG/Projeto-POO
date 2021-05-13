import java.util.List;

/**
 * Escreva a descrição da classe Avancado aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Avancado extends Jogador
{
    
    //Construtor por omissão
    public Avancado(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, double valorJogador, List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador, historial);
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.8 *((double)this.getImplusao() + (double)this.getRemate() + (double)this.getCabecear() + (double)this.getResistencia()) + 0.1*(double)this.getVelocidade() + 0.1*((double)this.getDestreza() + (double)this.getPasse());
    }
    
    public Jogador clone(){
        return new Avancado(this.getNome(), this.getNumeroJogador(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImplusao(), this.getCabecear(), this.getRemate(), this.getPasse(), this.getValorJogador(), this.getHistorial());
    }
}
