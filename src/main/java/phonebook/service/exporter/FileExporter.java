package phonebook.service.exporter;

import java.util.ArrayList;

public abstract class FileExporter<T> implements Export{
    protected ArrayList<T> data;
    private int counter;

    public FileExporter(ArrayList<T> data) {
        this.data = data;
    }

    public ArrayList<T> getData() {
        return data;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public String generateFileName(String fileType) {
        return String.format("contacts_%d.%s", counter++, fileType);
    }
}
