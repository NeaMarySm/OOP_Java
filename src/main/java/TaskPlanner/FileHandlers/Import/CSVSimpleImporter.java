package TaskPlanner.FileHandlers.Import;

import TaskPlanner.Storage;
import TaskPlanner.Tasks.SimpleTask;
import TaskPlanner.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class CSVSimpleImporter extends CSVImporter<SimpleTask> {
    public CSVSimpleImporter(Storage<SimpleTask> storage) {
        super(storage);
    }

    @Override
    public void importFile(String file) throws IOException {
        ArrayList<ArrayList<String>> rawTasks = parseFile(file);
        for (ArrayList<String> task : rawTasks) {
            storage.add(new SimpleTask(UUID.fromString(task.get(0)),
                    task.get(1), task.get(2), new User(task.get(3)), LocalDateTime.parse(task.get(4))));
        }
    }
}

