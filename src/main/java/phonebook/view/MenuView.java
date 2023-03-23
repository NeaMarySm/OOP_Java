package phonebook.view;

public class MenuView extends View{
    public int getInput(){
        System.out.println("\nEnter command: ");
        int input = in.nextInt();
        in.nextLine();
        return input;
    }
}
