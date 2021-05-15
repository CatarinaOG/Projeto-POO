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

    public Jogador getJogador(String classe){

        this.show();
        Jogador j = null;

        switch (classe){
            case "GuardaRedes": j = Guarda_Redes.parse(scan.nextLine());
            case "Defesa": j = Defesa.parse(scan.nextLine());
            case "Medio": j = Medio.parse(scan.nextLine());
            case "Avancado": j = Avancado.parse(scan.nextLine());
            case "Lateral": j = Lateral.parse(scan.nextLine());
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

}
