import javax.management.modelmbean.ModelMBean;
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
        model.criarJogo(campos[0],Integer.parseInt(campos[1]),Integer.parseInt(campos[2]),campos[3],Integer.parseInt(campos[4]),Integer.parseInt(campos[5]));
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
