package TaskPlanner.FileHandlers.Export;

import TaskPlanner.Tasks.BaseTask;

import java.util.ArrayList;

public abstract class FileExporter<T extends BaseTask> {
    protected ArrayList<T> tasks;
    public static int counter = 0;

    public FileExporter(ArrayList<T> tasks) {
        this.tasks = tasks;
        counter++;
    }

    public ArrayList<T> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<T> tasks) {
        this.tasks = tasks;
    }
}
