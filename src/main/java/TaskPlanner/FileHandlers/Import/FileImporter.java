package TaskPlanner.FileHandlers.Import;

import TaskPlanner.Storage;
import TaskPlanner.Tasks.BaseTask;

public abstract class FileImporter<T extends BaseTask> {
    protected Storage<T> storage;

    public FileImporter(Storage<T> storage) {
        this.storage = storage;
    }

    public Storage<T> getStorage() {
        return storage;
    }

    public void setStorage(Storage<T> storage) {
        this.storage = storage;
    }
}
