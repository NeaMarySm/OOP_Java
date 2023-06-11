package phonebook.controller;

import phonebook.model.Menu;
import phonebook.view.MenuView;


public class MenuController {
    private Menu menu;
    private MenuView view;

    public MenuController(Menu menu, MenuView view) {
        this.menu = menu;
        this.view = view;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public MenuView getView() {
        return view;
    }

    public void setView(MenuView view) {
        this.view = view;
    }
    public int getChoice(){
        menu.print(menu.getCommands());
        return view.getInput();
    }
    public int navigateChoice(){
        menu.print(menu.getNavigation());
        return view.getInput();
    }
}
