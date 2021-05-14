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

    public String[] run(){

        System.out.print("Escreva o jogador na seguinte forma: ");
        for( int i=0 ; i<param.size() ; i++)
             System.out.print(param.get(i)+" ");

        return (scan.nextLine().split(" "));
    }

    public void showJogador(Jogador jogador){
        System.out.println(jogador.toString());


    }

}
