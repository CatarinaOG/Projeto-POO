
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
    public Medio(String nome,int numeroJogador ,int velocidade,int resistencia ,int destreza, int implusao, int cabecear,int remate,int passe, int recuperaçãoDeBolas, double valorJogador){
        super(nome, numeroJogador, velocidade, resistencia, destreza, implusao, cabecear, remate, passe, valorJogador);
        this.recuperaçãoDeBolas = recuperaçãoDeBolas;
    }
    

    //Metodo para saber o overall do Jogador             ////////////////////////falta ter em consideraçao a recuperação de bolas/////////////////////////////////////////////
    public double valorJogador(){
        return 0.7*((double)this.passe + (double)this.destreza + (double)this.velocidade) + 0.3*((double)this.resistencia + (double)this.cabecear + (double)this.remate+ (double)this.implusao);
    }
    
    public Jogador clone(){
        return new Medio(this.nome, this.numeroJogador, this.velocidade, this.resistencia, this.destreza, this.implusao, this.cabecear, this.remate, this.passe, this.recuperaçãoDeBolas, this.valorJogador);   
    }
    
}
