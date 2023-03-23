package TaskPlanner;

import TaskPlanner.Tasks.BaseTask;

import java.util.ArrayList;
import java.util.UUID;

public class Storage<T extends BaseTask> {
    private ArrayList<T> tasks = new ArrayList<>();
    private String name;

    public Storage(String name) {
        this.name = name;
    }

    public ArrayList<T> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<T> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean add(T task) {
        return tasks.add(task);
    }

    public boolean remove(T task) {
        return tasks.remove(task);
    }

    public boolean addList(ArrayList<T> taskList) {
        return tasks.addAll(taskList);
    }

    public int size() {
        return tasks.size();
    }

    public T get(UUID id) {
        for (T t : tasks) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        System.out.println("Task not found");
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
