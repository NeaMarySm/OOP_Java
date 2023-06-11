package TaskPlanner.Tasks;

import TaskPlanner.User;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.UUID;

public abstract class BaseTask implements Iterator<String> {
    protected UUID id;
    protected String title;
    protected LocalDateTime createdAt;
    protected User author;
    protected int index = 0;

    public BaseTask(String title, User author) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.createdAt = LocalDateTime.now();
        this.author = author;
    }

    public BaseTask(UUID id, String title, LocalDateTime createdAt, User author) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.author = author;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Task id:%s, %s, created at %s, author: %s",
                this.id, this.title, this.createdAt, this.author);
    }

}
