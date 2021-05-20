import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    private Controller controller;

    public View(Controller controller){
        this.controller = controller;
    }

    public void runView() {
        Menu menu = new Menu( new String[] {"Criar Jogador","Criar Equipa","Ver Jogador","Ver equipa","Adicionar jogador a equipa","Trocar Jogador","Jogar","Load"});

        menu.setHandler(1, this::criarJogador);
        menu.setHandler(2, this::criarEquipa);
        menu.setHandler(3, this::verJogador);
        menu.setHandler(4, this::verEquipa);
        menu.setHandler(5, this::adicionarJogadorToTeam);
        menu.setHandler(6, this::trocarJogador);
        menu.setHandler(7, this::jogar);
        menu.setHandler(8, this::load);

        menu.run();
    }

    public void criarJogador(){
        Menu menu = new Menu( new String[] {"Guarda-Redes","Defesa","Medio","Avancado","Lateral"});
        menu.setHandler(1, this::adicionarGuardaRedes);
        menu.setHandler(2, this::adicionarDefesa);
        menu.setHandler(3, this::adicionarMedio);
        menu.setHandler(4, this::adicionarAvancado);
        menu.setHandler(5, this::adicionarLateral);
        menu.run();
    }

    public void adicionarGuardaRedes(){
        GetInput guardaRedes = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Elasticidade"});
        String campos = guardaRedes.getLine();
        controller.adicionarGuardaRedes(campos);
    }

    public void adicionarDefesa(){
        GetInput defesa = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe",});
        String campos = defesa.getLine();
        controller.adicionarDefesa(campos);
    }

    public void adicionarMedio(){
        GetInput medio = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Recuperacao de Bolas"});
        String campos = medio.getLine();
        controller.adicionarMedio(campos);
    }

    public void adicionarAvancado(){
        GetInput avancado = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe"});
        String campos = avancado.getLine();
        controller.adicionarAvancado(campos);
    }

    public void adicionarLateral(){
        GetInput lateral = new GetInput(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Cruzamento"});
        String campos = lateral.getLine();
        controller.adicionarLateral(campos);
    }

    private void verJogador(){
        GetInput jogador = new GetInput( new String[] {"Nome"});
        String[] campos = jogador.getCampos();

        Jogador j = controller.getJogador(Integer.parseInt(campos[0]));
        jogador.showJogador(j);
    }

    public void criarEquipa(){
        GetInput equipa = new GetInput(new String[] {"Nome da Equipa"});
        String[] campos = equipa.getCampos();
        controller.addEquipa(campos[0]);
    }

    public void verEquipa(){
        GetInput equipa = new GetInput( new String[] {"Nome da Equipa"});
        String[] campos = equipa.getCampos();

        Equipa e = controller.getEquipa(campos[0]);
        equipa.showEquipa(e);

    }

    public void adicionarJogadorToTeam(){
        GetInput jog_equipa = new GetInput(new String[] {"Jogador","Equipa"});
        String[] campos = jog_equipa.getCampos();

        controller.addJogadorToTeam(campos);
    }

    public void trocarJogador(){
        GetInput i = new GetInput(new String[] {"Nr do Jogador","Equipa Inicial","Equipa Final"});
        String[] campos = i.getCampos();

        controller.switchJogador(campos);
    }

    public void jogar(){
        GetInput jogo = new GetInput(new String[] {"Equipa casa","j1","j2","Equipa fora","j1","j2"});
        String[] campos = jogo.getCampos();

        controller.criarJogo(campos);
    }

    public void load() {
        try {
            controller.load();
        }catch(LinhaIncorretaException l){
            System.out.println("erro");
        }

    }

    //-----------------------------------------------Observer-----------------------------------------------------------

    public void update(Observable o, Object arg) {
        String evento = (String) arg;
        System.out.println(evento);
    }
}
