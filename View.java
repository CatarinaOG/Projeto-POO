
public class View
{
    private Controller controller;
    
    
    public View(Controller controller){
        this.controller = controller;
    }

    public void run(){

        String[] menu = {"Adicionar Jogador","Trocar Jogador","jogar","Sair"};
        String[] menu11 = {"Novo jogo","Carregar jogo","Sair"};
        Menu m = new Menu(menu);

        m.showMenu();
        int os = m.getOpcao();

        while( os != 0) {
            }
        }

    }
    

}
