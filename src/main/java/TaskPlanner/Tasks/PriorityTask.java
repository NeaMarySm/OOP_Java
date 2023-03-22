package TaskPlanner.Tasks;

import TaskPlanner.User;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.UUID;

public class PriorityTask extends BaseTask implements Iterator<String> {
    private LocalDateTime deadline;
    private State state;
    private Priority priority;

    public PriorityTask(String title, User author, LocalDateTime deadline, Priority priority) {
        super(title, author);
        this.deadline = deadline;
        this.state = State.created;
        this.priority = priority;
    }

    public PriorityTask(UUID id, String title, User author,LocalDateTime createdAt, LocalDateTime deadline, State state, Priority priority) {
        super(id, title,createdAt, author);
        this.deadline = deadline;
        this.state = state;
        this.priority = priority;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        String base = super.toString();
        return base + String.format(" Deadline: %s, Priority: %s, State: %s", this.deadline, this.priority, this.state);
    }

    @Override
    public boolean hasNext() {
        return index < 7;
    }

    @Override
    public String next() {
        switch (index++) {
            case 0:
                return String.format("%s", id);
            case 1:
                return String.format("%s", title);
            case 2:
                return String.format("%s", author);
            case 3:
                return String.format("%s", createdAt);
            case 4:
                return String.format("%s", deadline);
            case 5:
                return String.format("%s", state);
            case 6:
                return String.format("%s", priority);
            default:
                return "";
        }
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (this.getClass() != o.getClass()) {
            return false;
        } else return (this.priority == ((PriorityTask) o).getPriority()) &&
                (this.title.equals(((PriorityTask) o).getTitle())) &&
                (this.deadline.equals(((PriorityTask) o).getDeadline()));
    }
}
