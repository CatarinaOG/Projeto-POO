import java.util.List;

/**
 * Escreva a descrição da classe Medio aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Medio extends Jogador
{
    private int recuperaçãoDeBolas;
    
    //Construtor por omissão
    public Medio(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, int recuperaçãoDeBolas, double valorJogador, List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador, historial);
        this.recuperaçãoDeBolas = recuperaçãoDeBolas;
    }
    

    //Metodo para saber o overall do Jogador             ////////////////////////falta ter em consideraçao a recuperação de bolas/////////////////////////////////////////////
    public double valorJogador(){
        return 0.7*((double)this.getPasse() + (double)this.getDestreza() + (double)this.getVelocidade()) + 0.3*((double)this.getResistencia() + (double)this.getCabecear() + (double)this.getRemate()+ (double)this.getImplusao());
    }
    
    public Jogador clone(){
        return new Medio(this.getNome(), this.getNumeroJogador(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImplusao(), this.getCabecear(), this.getRemate(), this.getPasse(), this.recuperaçãoDeBolas, this.getValorJogador(), this.getHistorial());
    }
    
}
