import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class Model extends Observable {
    private String evento;

    private Map<String,Equipa> equipas;
    private Map<Integer,Jogador> jogadores;
    private List<Jogo> jogos;

    public Model(){
        this.evento = "";
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
    }

    public void addJogador(Jogador j){
        this.jogadores.put(j.getNrCamisola(),j);
    }

    public void addEquipa( String nome){
        Equipa e = new Equipa(nome);
        this.equipas.put(e.getNome(),e);
    }

    public void addJogadorToTeam(int nr, String t){
        Jogador jogador = this.jogadores.get(nr);
        this.equipas.get(t).addJogador(jogador.clone());
    }

    public void switchJogador(int nr, String t1, String t2){
        this.equipas.get(t1).removeJogador(jogadores.get(nr));
        this.equipas.get(t2).addJogador(jogadores.get(nr).clone());
    }

    public Jogador getJogador(int nr){
        return jogadores.get(nr).clone();
    }

    public Equipa getEquipa(String nome){return equipas.get(nome).clone(); }

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

    public void parse() throws LinhaIncorretaException {
        List<String> linhas = lerFicheiro("logs.txt");
        this.equipas = new HashMap<>(); //nome, equipa
        this.jogadores = new HashMap<>(); //numero, jogador
        this.jogos = new ArrayList<>();
        Equipa ultima = null;
        Jogador j = null;
        String[] linhaPartida;

        for (String linha : linhas) {
            linhaPartida = linha.split(":", 2);
            switch(linhaPartida[0]){
                case "Equipa":
                    Equipa e = Equipa.parse(linhaPartida[1]);
                    equipas.put(e.getNome(), e);
                    ultima = e;
                    break;
                case "Guarda-Redes":
                    j = Guarda_Redes.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    jogadores.put(j.getNrCamisola(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1],this.jogadores);
                    jogos.add(jo);
                    break;
                default:
                    throw new LinhaIncorretaException();

            }
        }
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }

    public void adicionarGuardaRedes(String campos){
        Jogador j = Guarda_Redes.parse(campos);
        j.setValorJogador(j.valorJogador());
        addJogador(j);
    }

    public void adicionarDefesa(String campos){
        Jogador j = Defesa.parse(campos);
        addJogador(j);
    }

    public void adicionarMedio(String campos){
        Jogador j = Medio.parse(campos);
        addJogador(j);
    }

    public void adicionarAvancado(String campos){
        Jogador j = Avancado.parse(campos);
        addJogador(j);
    }

    public void adicionarLateral(String campos){
        Jogador j = Lateral.parse(campos);
        addJogador(j);
    }

    public void criarJogo(String casa, int j1 , int j2 , String fora, int j3 , int j4){
        LocalDate d = LocalDate.now();
        Map<Integer,Integer> sc = new HashMap<>();
        Map<Integer,Integer> sf = new HashMap<>();
        Map<Integer,Jogador> ec = equipas.get(casa).getJogadores();
        Map<Integer,Jogador> ef = equipas.get(fora).getJogadores();

        List<Integer> titularesC = new ArrayList<>();
        titularesC.add(j1);
        titularesC.add(j2);

        List<Integer> titularesF = new ArrayList<>();
        titularesC.add(j3);
        titularesF.add(j4);

        JogoAtivo j = new JogoAtivo(casa,fora,0,0,d,ec,sc,ef,sf,titularesC,titularesF);
        j.run();



    }


    //---------------------------------------------Observer-------------------------------------------------------------
    public void setEvento(){
            this.evento = "Maria";
            setChanged();
            notifyObservers(evento);
    }
}
