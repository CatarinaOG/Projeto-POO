import java.util.List;

/**
 * Escreva a descrição da classe Lateral aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Lateral extends Jogador
{
    private int cruzamento;
    
    //Construtor por omissão
    public Lateral(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, int cruzamento, double valorJogador, List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador,historial);
        this.cruzamento = cruzamento;
    }

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.7*((double)this.getVelocidade() + (double) this.getResistencia() + (double) this.cruzamento) + 0.2*((double) this.getCabecear() + (double) this.getRemate() + (double)this.getImplusao()) + 0.1*((double) this.getDestreza() + (double) this.getPasse());
    }
    
    public Jogador clone(){
        return new Lateral(this.getNome(), this.getNumeroJogador(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImplusao(), this.getCabecear(), this.getRemate(), this.getPasse(),this.cruzamento, this.getValorJogador(), this.getHistorial());
    }

}
