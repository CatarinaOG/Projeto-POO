import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Info {

    private static Scanner scan = new Scanner(System.in);
    private List<String> param;

    public Info(String[] params){
        this.param = Arrays.asList(params);
    }

    public Jogador getJogador(int i){
        this.show();
        Jogador j = null;

        switch (i){
            case 1: j = Guarda_Redes.parse(scan.nextLine()); break;
            case 2: j = Defesa.parse(scan.nextLine()); break;
            case 3: j = Medio.parse(scan.nextLine()); break;
            case 4: j = Avancado.parse(scan.nextLine()); break;
            case 5: j = Lateral.parse(scan.nextLine()); break;
        }

        return j;
    }

    public String[] getCampos(){
        this.show();
        return scan.nextLine().split(",");
    }

    private void show(){
        int i;

        System.out.print("(");
        for( i=0 ; i<param.size()-1 ; i++)
            System.out.print(param.get(i)+",");
        System.out.println(param.get(i)+")");
    }

    public void showJogador(Jogador jogador){
        System.out.println(jogador.toString());
    }

    public void showEquipa(Equipa equipa){
        System.out.println(equipa.toString());
    }

}
