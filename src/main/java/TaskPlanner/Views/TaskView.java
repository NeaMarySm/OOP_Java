package TaskPlanner.Views;

import TaskPlanner.Storage;
import TaskPlanner.Tasks.Priority;
import TaskPlanner.Tasks.PriorityTask;
import TaskPlanner.Tasks.SimpleTask;
import TaskPlanner.Tasks.State;

import java.time.LocalDateTime;

public class TaskView extends View {
    public TaskView() {
        super();
    }

    public void print(SimpleTask task) {
        System.out.printf("%s\t%s\t%s\t%s\n", task.getTitle(), task.getContent(), task.getCreatedAt(), task.getAuthor());
    }

    public void print(PriorityTask task) {
        System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n",
                task.getTitle(), task.getPriority(), task.getDeadline(),
                task.getState(), task.getCreatedAt(), task.getAuthor());
    }

    public String getTitle() {
        System.out.println("Title: ");
        return in.nextLine();
    }

    public void setTitle(String value) {
        System.out.printf("Title changed to: %s\n", value);
    }

    public LocalDateTime getDeadline() {
        System.out.println("Enter day: ");
        int day = in.nextInt();
        System.out.println("Enter month: ");
        int month = in.nextInt();
        System.out.println("Enter year: ");
        int year = in.nextInt();
        in.nextLine();
        return LocalDateTime.of(year, month, day, 0, 0, 0);
    }

    public void setDeadline(LocalDateTime value) {
        System.out.printf("Deadline changed to %s\n", value);
    }

    public Priority getPriority() {
        System.out.println("Choose priority: ");
        for (Priority el : Priority.values()) {
            System.out.printf("%s\t", el);
        }
        System.out.println("\n");
        String input = in.nextLine();
        Priority priority = Priority.medium;
        while (true) {
            switch (input.toLowerCase()) {
                case "high":
                    priority = Priority.high;
                    break;
                case "medium":
                    break;
                case "low":
                    priority = Priority.low;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
            return priority;
        }
    }

    public void setPriority(Priority value) {
        System.out.printf("Priority changed to: %s\n", value);
    }

    public void setState(State value) {
        System.out.printf("State changed to: %s\n", value);
    }

    public String getContent() {
        System.out.println("Content: ");
        return in.nextLine();
    }

    public void setContent(String value) {
        System.out.printf("Content changed to: %s\n", value);
    }

}
