import java.util.List;

/**
 * Escreva a descrição da classe Defesa aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Defesa extends Jogador
{
    
    //Construtor por omissão
    public Defesa(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, double valorJogador, List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador, historial);
    }

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.5*(double)this.getDestreza() + 0.3*(double)this.getPasse() + 0.2*((double)this.getVelocidade() + (double)this.getResistencia() + (double)this.getImplusao() + (double)this.getRemate() + (double)this.getCabecear());
    }
    
    public Jogador clone(){
        return new Defesa(this.getNome(), this.getNumeroJogador(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImplusao(), this.getCabecear(), this.getRemate(), this.getPasse(), this.getValorJogador(), this.getHistorial());
    }
    
}
