import java.io.IOException;
import java.util.*;

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

    public void removeJogadorDeEquipa(Integer nr, String equipa){model.removeJogadorDeEquipa(nr,equipa);}

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
        Map<Integer,Integer> substituicoesC = new HashMap<>();

        for(int i=1 ; i<12 ; i++)
            titularesC.add(Integer.parseInt(campos[i]));

        String[] substitutosC1 = campos[12].split("->");
        String[] substitutosC2 = campos[13].split("->");
        String[] substitutosC3 = campos[14].split("->");
        substituicoesC.put(Integer.parseInt(substitutosC1[0]),Integer.parseInt(substitutosC1[1]));
        substituicoesC.put(Integer.parseInt(substitutosC2[0]),Integer.parseInt(substitutosC2[1]));
        substituicoesC.put(Integer.parseInt(substitutosC3[0]),Integer.parseInt(substitutosC3[1]));

        List<Integer> titularesF = new ArrayList<>();
        Map<Integer,Integer> substituicoesF = new HashMap<>();

        for(int i=16 ; i<27 ; i++)
            titularesF.add(Integer.parseInt(campos[i]));


        String[] substitutosF1 = campos[27].split("->");
        String[] substitutosF2 = campos[28].split("->");
        String[] substitutosF3 = campos[29].split("->");
        substituicoesF.put(Integer.parseInt(substitutosF1[0]),Integer.parseInt(substitutosF1[1]));
        substituicoesF.put(Integer.parseInt(substitutosF2[0]),Integer.parseInt(substitutosF2[1]));
        substituicoesF.put(Integer.parseInt(substitutosF3[0]),Integer.parseInt(substitutosF3[1]));

        model.criarJogo(campos[0],titularesC,substituicoesC,campos[15],titularesF,substituicoesF);
    }

    public void load(String ficheiro) throws LinhaIncorretaException {
        model.parse(ficheiro);
    }

    public void saveModel(String file) throws IOException {
        model.writeModel(file);
    }

    public void readModel(String Ficheiro) throws IOException, ClassNotFoundException {
        model.readModel(Ficheiro);
    }


    ///-------------------------------------------------Observer--------------------------------------------------------
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
