package phonebook.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<String> commands = new ArrayList<>(
            List.of("1-ShowContacts", "2-AddContact", "3-ImportContacts", "4-ExportContacts", "0-Exit"));
    private ArrayList<String> navigation = new ArrayList<>(List.of("1-Previous", "2-Next"));

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public ArrayList<String> getNavigation() {
        return navigation;
    }

    public void setNavigation(ArrayList<String> navigation) {
        this.navigation = navigation;
    }

    public void print(ArrayList<String> commands) {
        commands.forEach(el -> System.out.printf("%s\t", el));
    }

}
