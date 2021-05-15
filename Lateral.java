import java.util.ArrayList;
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

    public int getCruzamento(){
        return this.cruzamento;
    }

    //Metodo para saber o overall do Jogador
    public double valorJogador(){
        return 0.7*((double)this.getVelocidade() + (double) this.getResistencia() + (double) this.cruzamento) + 0.2*((double) this.getCabecear() + (double) this.getRemate() + (double)this.getImplusao()) + 0.1*((double) this.getDestreza() + (double) this.getPasse());
    }
    
    public Jogador clone(){
        return new Lateral(this.getNome(), this.getNumeroJogador(), this.getVelocidade(), this.getResistencia(), this.getDestreza(), this.getImplusao(), this.getCabecear(), this.getRemate(), this.getPasse(),this.cruzamento, this.getValorJogador(), this.getHistorial());
    }

    public static Lateral parse(String input){
        String[] campos = input.split(",");
        Lateral l = new Lateral(campos[0], Integer.parseInt(campos[1]),
                Integer.parseInt(campos[2]),
                Integer.parseInt(campos[3]),
                Integer.parseInt(campos[4]),
                Integer.parseInt(campos[5]),
                Integer.parseInt(campos[6]),
                Integer.parseInt(campos[7]),
                Integer.parseInt(campos[8]),
                Integer.parseInt(campos[9]),
                0,
                new ArrayList<>());

        l.setValorJogador(l.valorJogador());
        return l;
    }

    public String toString(){
        String s = super.toString();
        StringBuffer sb = new StringBuffer();

        sb.append(s);
        sb.append("|Cruzamento: "+getCruzamento());
        sb.append("\n|---------------------------------------------|\n");

        return sb.toString();
    }

}
