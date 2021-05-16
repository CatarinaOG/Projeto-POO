import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Model
{
    private Map<String,Equipa> equipas;
    private Map<Integer,Jogador> jogadores;
    private List<Jogo> jogos;
    
    public Model(){
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
        this.equipas.get(t).addJogador(jogador);
    }
    
    public void switchJogador(int nr, String t1, String t2){
        this.equipas.get(t1).removeJogador(jogadores.get(nr));
        this.equipas.get(t2).addJogador(jogadores.get(nr));
    }

    public Jogador getJogador(int nr){
        return jogadores.get(nr);
    }

    public Equipa getEquipa(String nome){return equipas.get(nome); }

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
        List<String> linhas = lerFicheiro("output.txt");
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

}
