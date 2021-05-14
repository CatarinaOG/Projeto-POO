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
        //menu.setHandler(2,()->adicionarDefesa());
        //menu.setHandler(2,()->adicionarDefesa());
        //menu.setHandler(2,()->adicionarDefesa());
        menu.run();
    }

    public void adicionarGuardaRedes(){

        Info guardaRedes = new Info(new String[] {"Nome","NrCamisola","Velocidade","Resistencia","Destreza","Impulsao","Cabecear","Remate","Passe","Elasticidade"});
        String[] campos = guardaRedes.run();
        Guarda_Redes gr = new Guarda_Redes(campos[0],
                Integer.parseInt(campos[1]),
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

        model.addJogador(gr);
    }

    private void verJogador(){
        Info jogador = new Info( new String[] {"Nome"});
        String[] campos = jogador.run();

        Jogador j = model.getJogador(campos[0]);
        jogador.showJogador(j);
    }



}
