import java.util.ArrayList;

public class Controller
{

    private Model model;

    public Controller(){
        this.model = new Model();
    }

    public void run(){
        Menu menu = new Menu( new String[] {"Adicionar Jogador","Adicionar Equipa","Ver Jogador","Ver equipa","Trocar Jogador"});

        menu.setHandler(1, this::adicionarJogador);
        menu.setHandler(3,this::verJogador);

        menu.run();
    }

    public void adicionarJogador(){
        Menu menu = new Menu( new String[] {"Guarda-Redes","Defesa","Medio","Avancado","Lateral"});
        menu.setHandler(1, this::adicionarGuardaRedes);
        menu.setHandler(2, this::adicionarDefesa);
        menu.setHandler(2, this::adicionarMedio);
        menu.setHandler(2, this::adicionarAvancado);
        menu.setHandler(2, this::adicionarLateral);
        menu.run();
    }

    public void adicionarGuardaRedes(){
        Info guardaRedes = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Elasticidade"});
        Jogador gr = guardaRedes.getJogador("GuardaRedes");
        model.addJogador(gr);
    }

    public void adicionarDefesa(){
        Info guardaRedes = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe",});
        Jogador gr = guardaRedes.getJogador("Defesa");
        model.addJogador(gr);
    }

    public void adicionarMedio(){
        Info guardaRedes = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Recuperacao de Bolas"});
        Jogador gr = guardaRedes.getJogador("Medio");
        model.addJogador(gr);
    }

    public void adicionarAvancado(){
        Info guardaRedes = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe"});
        Jogador gr = guardaRedes.getJogador("Avancado");
        model.addJogador(gr);
    }

    public void adicionarLateral(){
        Info guardaRedes = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Cruzamento"});
        Jogador gr = guardaRedes.getJogador("Lateral");
        model.addJogador(gr);
    }



    private void verJogador(){
        Info jogador = new Info( new String[] {"Nome"});
        String[] campos = jogador.getCampos();

        Jogador j = model.getJogador(campos[0]);
        jogador.showJogador(j);
    }

    public void guardaEstado(String ficheiro) throws FileNotFoundException, IOException {
        File f = new File(ficheiro);
        if(!f.exists()){
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

}
