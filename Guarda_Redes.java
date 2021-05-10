import java.util.List;

/**
 * Escreva a descrição da classe Guarda_Redes aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */

public class Guarda_Redes extends Jogador
{
    private int elasticidade; 
    
    //Construtor por omissão
    
    public Guarda_Redes(){
        super();
        this.elasticidade = 0;
    }
    
    
    public Guarda_Redes(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, int elasticidade, double valorJogador,List<String> historial){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador,historial);
        this.elasticidade = elasticidade;
    }
    

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.6* (double)this.elasticidade + 0.1*(double)this.getRemate() + 0.3*(double)this.getDestreza();
    }
    
    public Jogador clone(){
        return new Guarda_Redes(this.getNome(), this.getNumeroJogador(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImplusao(), this.getCabecear(), this.getRemate(), this.getPasse(),this.elasticidade, this.getValorJogador(), this.getHistorial()); 
    }
    
}
