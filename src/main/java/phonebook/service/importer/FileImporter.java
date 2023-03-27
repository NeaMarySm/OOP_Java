package phonebook.service.importer;

import java.util.ArrayList;

public abstract class FileImporter<T> implements Import {
    protected ArrayList<T> storage;

    public FileImporter(ArrayList<T> storage) {
        this.storage = storage;
    }

    public ArrayList<T> getStorage() {
        return storage;
    }

    public void setStorage(ArrayList<T> storage) {
        this.storage = storage;
    }
}
