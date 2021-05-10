
public class Football_Manager
{
    public static void main (String[] args){
        
        Model model = new Model();
        Controller controller = new Controller(model);
        View view = new View(controller);
        
        view.run();
        
    }
    
}
