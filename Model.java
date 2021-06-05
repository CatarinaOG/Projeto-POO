import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Model extends Observable implements Observer {
    private String evento;

    private Map<String,Equipa> equipas;
    private Map<String,Jogador> jogadores;
    private List<Jogo> jogos;

    public Model(){
        this.evento = "";
        this.equipas = new HashMap<>();
        this.jogadores = new HashMap<>();
    }

    public void addJogador(Jogador j){
        this.jogadores.put(j.getNome(),j);
    }

    public void addEquipa(String nome){
        Equipa e = new Equipa(nome);
        this.equipas.put(e.getNome(),e);
    }

    public void addJogadorToTeam(String nome, String t){
        Jogador jogador = this.jogadores.get(nome);
        this.equipas.get(t).addJogador(jogador.clone());
    }

    public void switchJogador(String nome, String t1, String t2){
        this.equipas.get(t1).removeJogador(jogadores.get(nome));
        this.equipas.get(t2).addJogador(jogadores.get(nome).clone());
    }

    public Jogador getJogador(String nome){
        return jogadores.get(nome).clone();
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
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Defesa":
                    j = Defesa.parse(linhaPartida[1]);
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Medio":
                    j = Medio.parse(linhaPartida[1]);
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Lateral":
                    j = Lateral.parse(linhaPartida[1]);
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Avancado":
                    j = Avancado.parse(linhaPartida[1]);
                    jogadores.put(j.getNome(), j);
                    if (ultima == null) throw new LinhaIncorretaException(); //we need to insert the player into the team
                    ultima.addJogador(j.clone()); //if no team was parsed previously, file is not well-formed
                    break;
                case "Jogo":
                    Jogo jo = Jogo.parse(linhaPartida[1],this.equipas);
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

    public void criarJogo(String casa, List<Integer> jogCasa, String fora, List<Integer> jogFora ){
        Equipa equipaCasa = equipas.get(casa);
        Equipa equipaFora = equipas.get(fora);

        LocalDate d = LocalDate.now();

        Map<Integer,Jogador> substitutosC = equipas.get(casa).getJogadores();
        Map<Integer,Jogador> substitutosF = equipas.get(fora).getJogadores();

        Map<Integer,Jogador> titularesC = new HashMap<>();
        Map<Integer,Jogador> titularesF = new HashMap<>();

        for(Integer nr : jogCasa){
            if(substitutosC.containsKey(nr)) {
                titularesC.put(nr, substitutosC.get(nr));
                substitutosC.remove(nr);
            }
        }

        Map<Integer,Integer> substituicoesC = new HashMap<>();
        Map<Integer,Integer> substituicoesF = new HashMap<>();


        JogoAtivo j = new JogoAtivo(casa,fora,0,0,d,titularesC,substitutosC,substituicoesC,titularesF,substitutosF,substituicoesF);
        j.run();

    }

    //---------------------------------------------Observer-------------------------------------------------------------
    public void setEvento(){
            this.evento = "Maria";
            setChanged();
            notifyObservers(evento);
    }
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers(arg);
    }

}
