package TaskPlanner;

import TaskPlanner.FileHandlers.Export.CSVExporter;
import TaskPlanner.FileHandlers.Import.CSVImporter;
import TaskPlanner.FileHandlers.Import.CSVPriorityImporter;
import TaskPlanner.Menu;
import TaskPlanner.Tasks.PriorityTask;
import TaskPlanner.Tasks.SimpleTask;
import TaskPlanner.Views.MenuView;

import java.io.IOException;
import java.util.Scanner;

public class Program {
    private MenuView menu;
    private User currentUser;
    private Storage<PriorityTask> priorityTaskStorage;
    private Storage<SimpleTask> simpleTaskStorage;
    private TaskHandler taskHandler;

    public Program(User currentUser) {
        this.menu = new MenuView(new Menu());
        this.currentUser = currentUser;
        this.priorityTaskStorage = new Storage<>("priorityTasks");
        this.simpleTaskStorage = new Storage<>("simpleTasks");
        this.taskHandler = new TaskHandler(this.currentUser, this.priorityTaskStorage, this.simpleTaskStorage);
    }

    public MenuView getMenu() {
        return menu;
    }

    public void setMenu(MenuView menu) {
        this.menu = menu;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Storage<PriorityTask> getPriorityTaskStorage() {
        return priorityTaskStorage;
    }

    public void setPriorityTaskStorage(Storage<PriorityTask> priorityTaskStorage) {
        this.priorityTaskStorage = priorityTaskStorage;
    }

    public Storage<SimpleTask> getSimpleTaskStorage() {
        return simpleTaskStorage;
    }

    public void setSimpleTaskStorage(Storage<SimpleTask> simpleTaskStorage) {
        this.simpleTaskStorage = simpleTaskStorage;
    }

    public TaskHandler getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(TaskHandler taskHandler) {
        this.taskHandler = taskHandler;
    }

    public void run() throws IOException {
        boolean inProgress = true;
        while (inProgress) {
            System.out.println("\nTask Planner");
            int input = menu.getMainMenuChoice();
            switch (input) {
                case 1:
                    taskHandler.createTask();
                    break;
                case 2:
                    input = menu.getShowChoice();
                    switch (input) {
                        case 1:
                            taskHandler.printAll();
                            break;
                        case 2:
                            input = menu.getFilterChoice();
                            switch (input) {
                                case 1:
                                    //Вывод фильтрованных по приоритету
                                    break;
                                case 2:
                                    //фильтрация по дедлайну
                                    break;
                                case 3:
                                    //по дате создания
                                    break;
                                case 4:
                                    //по автору
                                    break;
                                case 0:
                                    // возврат в главное меню
                                    break;
                                default:
                                    System.out.println("Invalid command.");
                            }
                            break;
                        case 0:
                            // возврат в главное меню
                            break;
                        default:
                            System.out.println("Invalid command.");
                    }
                    break;
                case 3:
                    String filename = menu.getFilename();
                    new CSVPriorityImporter(priorityTaskStorage).importFile(filename);
                    break;
                case 4:
                    new CSVExporter<>(priorityTaskStorage.getTasks()).export();
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
