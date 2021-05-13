import java.util.Scanner;

public class Menu {

    private String[] menu;

    public Menu (String[] list){
        this.menu = list;
    }

    public void showMenu (){

        System.out.println("---------Menu---------");

        for( int i=1 ; i< menu.length+1 ; i++)
            System.out.println(i+" "+menu[i-1]);
    }

    public int getOpcao (){

        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();

    }

}