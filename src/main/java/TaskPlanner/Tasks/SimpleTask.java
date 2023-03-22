package TaskPlanner.Tasks;

import TaskPlanner.User;

import java.time.LocalDateTime;
import java.util.UUID;

public class SimpleTask extends BaseTask {
    private String content;

    public SimpleTask(String title, User author, String content) {
        super(title, author);
        this.content = content;
    }

    public SimpleTask(UUID id, String title, String content, User author, LocalDateTime createdAt) {
        super(id, title, createdAt, author);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean hasNext() {
        return index < 5;
    }

    @Override
    public String next() {
        switch (index++) {
            case 1:
                return String.format("%s", id);
            case 2:
                return String.format("%s", title);
            case 3:
                return String.format("%s", content);
            case 4:
                return String.format("%s", author);
            case 5:
                return String.format("%s", createdAt);
            default:
                return "";
        }
    }
}
