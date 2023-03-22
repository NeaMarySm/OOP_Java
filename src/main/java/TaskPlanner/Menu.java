package TaskPlanner;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private ArrayList<String> mainMenu = new ArrayList<>(List.of("1 - NewTask", "2 - ShowTasks","3 - ImportTasks","4 - ExportTasks", "0 - Exit"));
    private ArrayList<String> subShow = new ArrayList<>(List.of("1 - All", "2 - Filter", "0 - Return"));
    private ArrayList<String> subFilter = new ArrayList<>(List.of("1 - ByPriority", "2 - ByDeadline", "3 - ByCreationDate", "4 - ByAuthor", "0 - Return"));

    public ArrayList<String> getMainMenu() {
        return mainMenu;
    }

    public void setMainMenu(ArrayList<String> mainMenu) {
        this.mainMenu = mainMenu;
    }

    public ArrayList<String> getSubShow() {
        return subShow;
    }

    public void setSubShow(ArrayList<String> subShow) {
        this.subShow = subShow;
    }

    public ArrayList<String> getSubFilter() {
        return subFilter;
    }

    public void setSubFilter(ArrayList<String> subFilter) {
        this.subFilter = subFilter;
    }

    public void print(ArrayList<String> commands) {
        commands.forEach(el -> System.out.printf("%s\t", el));
    }

}
