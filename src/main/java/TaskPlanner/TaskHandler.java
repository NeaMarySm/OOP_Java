package TaskPlanner;

import TaskPlanner.Tasks.BaseTask;
import TaskPlanner.Tasks.SimpleTask;
import TaskPlanner.Views.TaskView;
import TaskPlanner.Tasks.PriorityTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TaskHandler {
    private TaskView tw;
    private Storage<PriorityTask> priorityTaskStorage;
    private Storage<SimpleTask> simpleTaskStorage;
    private ArrayList<BaseTask> result = new ArrayList<>();
    private User user;

    public TaskHandler(User user, Storage<PriorityTask> priorityTaskStorage, Storage<SimpleTask> simpleTaskStorage) {
        this.tw = new TaskView();
        this.user = user;
        this.priorityTaskStorage = priorityTaskStorage;
        this.simpleTaskStorage = simpleTaskStorage;
    }

    public PriorityTask createPriorityTask() {
        return new PriorityTask(tw.getTitle(), user, tw.getDeadline(), tw.getPriority());
    }


    public SimpleTask createSimpleTask() {
        return new SimpleTask(tw.getTitle(), user, tw.getContent());
    }

    public void createTask() {
        System.out.println("1 - SimpleTask\t2 - PriorityTask");
        int input = tw.getIn().nextInt();
        tw.getIn().nextLine();
        if (input == 1) {
            simpleTaskStorage.add(createSimpleTask());
        } else if (input == 2) {
            priorityTaskStorage.add(createPriorityTask());
        } else System.out.println("Invalid input");
    }

    public void printAll() {
        System.out.println("Priority tasks");
        System.out.println("№\tTitle\tPriority\tDeadline\tStatus\tCreatedAt\tAuthor");
        for (int i = 0; i < priorityTaskStorage.size(); i++) {
            System.out.printf("%d\t", (i + 1));
            tw.print(priorityTaskStorage.getTasks().get(i));
        }
        System.out.println("Simple tasks");
        System.out.println("№\tTitle\tContent\tCreatedAt\tAuthor");
        for (int i = 0; i < simpleTaskStorage.size(); i++) {
            System.out.printf("%d\t", (i + 1));
            tw.print(simpleTaskStorage.getTasks().get(i));
        }
    }
    public ArrayList<BaseTask> filterByPriority(){
        priorityTaskStorage.getTasks().sort(new PriorityComparator());
        return result;
    }

}
