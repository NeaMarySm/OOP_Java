package TaskPlanner.Views;

import TaskPlanner.Menu;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuView extends View {
    private Menu menu;
    public MenuView(Menu menu) {
        super();
        this.menu = menu;
    }
    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    public void print(ArrayList<String> commands) {
        commands.forEach(el -> System.out.printf("%s\t", el));
    }
    public int getMainMenuChoice(){
        System.out.println("Main menu");
        menu.print(menu.getMainMenu());
        System.out.println("\nEnter command: ");
        int input = in.nextInt();
        in.nextLine();
        return input;
    }
    public int getFilterChoice(){
        System.out.println("Choose filter:");
        menu.print(menu.getSubFilter());
        System.out.println("Enter command: ");
        int input = in.nextInt();
        in.nextLine();
        return input;
    }

    public int getShowChoice(){
        System.out.println("Show All Tasks?");
        menu.print(menu.getSubShow());
        System.out.println("Enter command: ");
        int input = in.nextInt();
        in.nextLine();
        return input;
    }
    public String getFilename(){
        System.out.println("Enter filename:");
        return in.nextLine();
    }

}
