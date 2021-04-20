
/**
 * Escreva a descrição da classe Lateral aqui.
 * 
 * @author (Gerson Junior) 
 * @version (número de versão ou data)
 */
public class Lateral extends Jogador
{
    private double valorJogador;
    private int velocidade;
    private int resistencia;
    private int destreza;
    private int implusao;
    private int cabecear;
    private int remate;
    private int passe;
    
    //Construtor por omissão
    public Lateral(){
        this.valorJogador = 0;
        this.velocidade = 0;
        this.resistencia = 0;
        this.destreza = 0;
        this.implusao = 0;
        this.cabecear = 0;
        this.remate = 0;
        this.passe = 0;
    }
    
    //Construtor parametrizado
    public Lateral(double valorJogador,int velocidade,int resistencia,int destreza,int implusao,int cabecear,int remate,int passe){
        this.valorJogador = valorJogador;
        this.velocidade = velocidade;
        this.resistencia = resistencia;
        this.destreza = destreza;
        this.implusao = implusao;
        this.cabecear = cabecear;
        this.remate = remate;
        this.passe = passe;
    }
    
    //Construtor de copia
    public Lateral(Jogador umLateral){
        this.valorJogador = umLateral.getValorJogador();
        this.velocidade = umLateral.getVelocidade();
        this.resistencia = umLateral.getResistencia();
        this.destreza = umLateral.getDestreza();
        this.implusao = umLateral.getImplusao();
        this.cabecear = umLateral.getCabecear();
        this.remate = umLateral.getRemate();
        this.passe = umLateral.getPasse();
    }
    
    //Metodo para saber o overall do Jogador
    public double valorLateral(){
        this.valorJogador = 0.7*(this.implusao + this.velocidade + this.resistencia) + 0.2*(this.cabecear + this.remate) + 0.1*(this.destreza + this.passe);
        return valorJogador;
    }
    
}
