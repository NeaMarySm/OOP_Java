package phonebook;

import phonebook.controller.ContactController;
import phonebook.controller.MenuController;
import phonebook.model.Menu;
import phonebook.model.PhoneBook;
import phonebook.view.ContactView;
import phonebook.view.MenuView;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ContactController contactController = new ContactController(new PhoneBook(), new ContactView());
        MenuController menuController = new MenuController(new Menu(), new MenuView());
        Program program = new Program(contactController, menuController);
        program.run();
    }
}
