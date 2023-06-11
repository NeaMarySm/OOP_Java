package TaskPlanner.FileHandlers.Import;

import TaskPlanner.Storage;
import TaskPlanner.Tasks.Priority;
import TaskPlanner.Tasks.PriorityTask;
import TaskPlanner.Tasks.State;
import TaskPlanner.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class CSVPriorityImporter extends CSVImporter<PriorityTask> {
    public CSVPriorityImporter(Storage<PriorityTask> storage) {
        super(storage);
    }

    public void importFile(String file) throws IOException {
        ArrayList<ArrayList<String>> rawTasks = parseFile(file);
        for (ArrayList<String> task:rawTasks) {
            storage.add(new PriorityTask(UUID.fromString(task.get(0)),
                    task.get(1),new User(task.get(2)), LocalDateTime.parse(task.get(3)),
                    LocalDateTime.parse(task.get(4)), State.valueOf(task.get(5)), Priority.valueOf(task.get(6))));
        }}
}
