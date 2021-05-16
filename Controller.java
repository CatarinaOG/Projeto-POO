import java.util.ArrayList;

public class Controller
{

    private Model model;

    public Controller(){
        this.model = new Model();
    }

    public void run(){
        Menu menu = new Menu( new String[] {"Criar Jogador","Criar Equipa","Ver Jogador","Ver equipa","Adicionar jogador a equipa","Trocar Jogador"});

        menu.setHandler(1, this::criarJogador);
        menu.setHandler(2, this::criarEquipa);
        menu.setHandler(3,this::verJogador);
        menu.setHandler(4, this::verEquipa);
        menu.setHandler(5, this::adicionarJogadorToTeam);

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
        Info guardaRedes = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Elasticidade"});
        Jogador gr = guardaRedes.getJogador(1);
        model.addJogador(gr);
    }

    public void adicionarDefesa(){
        Info defesa = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe",});
        Jogador gr = defesa.getJogador(2);
        model.addJogador(gr);
    }

    public void adicionarMedio(){
        Info medio = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Recuperacao de Bolas"});
        Jogador gr = medio.getJogador(3);
        model.addJogador(gr);
    }

    public void adicionarAvancado(){
        Info avancado = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe"});
        Jogador gr = avancado.getJogador(4);
        model.addJogador(gr);
    }

    public void adicionarLateral(){
        Info lateral = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Cruzamento"});
        Jogador gr = lateral.getJogador(5);
        model.addJogador(gr);
    }

    private void verJogador(){
        Info jogador = new Info( new String[] {"Nome"});
        String[] campos = jogador.getCampos();

        Jogador j = model.getJogador(campos[0]).clone();
        jogador.showJogador(j);
    }

    public void criarEquipa(){
        Info equipa = new Info(new String[] {"Nome da Equipa"});
        String[] campos = equipa.getCampos();
        model.addEquipa(campos[0]);
    }

    public void verEquipa(){
        Info equipa = new Info( new String[] {"Nome da Equipa"});
        String[] campos = equipa.getCampos();

        Equipa e = model.getEquipa(campos[0]).clone();
        equipa.showEquipa(e);

    }

    public void adicionarJogadorToTeam(){
        Info jog_equipa = new Info(new String[] {"Jogador","Equipa"});
        String[] campos = jog_equipa.getCampos();

        model.addJogadorToTeam(campos[0],campos[1]);

    }


}
