import javax.management.modelmbean.ModelMBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Controller extends Observable implements Observer {
    private Model model;

    public Controller(Model model ){
        this.model = model;
    }

    public void adicionarGuardaRedes(String campos){
        model.adicionarGuardaRedes(campos);
    }

    public void adicionarDefesa(String campos){
        model.adicionarDefesa(campos);
    }

    public void adicionarMedio(String campos){
        model.adicionarMedio(campos);
    }

    public void adicionarAvancado(String campos){
        model.adicionarAvancado(campos);
    }

    public void adicionarLateral(String campos){
        model.adicionarLateral(campos);
    }

    public Jogador getJogador(String nome){
        return model.getJogador(nome);
    }

    public void addEquipa(String equipaNome){
        model.addEquipa(equipaNome);
    }

    public Equipa getEquipa(String nome){
        return model.getEquipa(nome);
    }

    public void addJogadorToTeam(String[] campos){
        model.addJogadorToTeam(campos[0],campos[1]);
    }

    public void switchJogador(String[] campos){
        model.switchJogador(campos[0],campos[1],campos[2]);
    }

    public void criarJogo(String[] campos){

        List<Integer> titularesC = new ArrayList<>();

        for(int i=1 ; i<3 ; i++) // 12
            titularesC.add(Integer.parseInt(campos[i]));

        List<Integer> titularesF = new ArrayList<>();

        for(int i=4 ; i<6 ; i++) //13 e 24
            titularesF.add(Integer.parseInt(campos[i]));

        model.criarJogo(campos[0],titularesC,campos[3],titularesC);
    }

    public void load() throws LinhaIncorretaException {
        model.parse();
    }


    ///-------------------------------------------------Observer--------------------------------------------------------
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
