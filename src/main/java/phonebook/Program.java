package phonebook;

import phonebook.controller.ContactController;
import phonebook.controller.MenuController;
import phonebook.controller.PhonebookNavigationController;

import java.io.IOException;

public class Program {
    private ContactController contactController;
    private MenuController menuController;

    public Program(ContactController contactController, MenuController menuController) {
        this.contactController = contactController;
        this.menuController = menuController;
    }

    public void run() throws IOException {
        boolean inProgress = true;
        while (inProgress) {
            System.out.println("PhoneBook");
            int input = menuController.getChoice();
            switch (input) {
                case 1:
                    boolean inContacts = true;
                    PhonebookNavigationController nav = new PhonebookNavigationController(this.contactController.getPhonebook(), this.contactController.getView());
                    System.out.println(nav.getCurrentContact());
                    while (inContacts) {
                        input = menuController.navigateChoice();
                        if (input == 1) {
                            System.out.println(nav.previousContact());
                        } else if (input == 2) {
                            System.out.println(nav.nextContact());
                        } else {
                            System.out.println("Invalid input");
                            inContacts = false;
                        }
                    }
                    break;
                case 2:
                    contactController.createContact();
                    break;
                case 3:
                    contactController.importCSV();
                    break;
                case 4:
                    contactController.exportCSV();
                    break;
                case 0:
                    inProgress = false;
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}

