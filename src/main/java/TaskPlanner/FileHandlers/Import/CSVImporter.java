package TaskPlanner.FileHandlers.Import;

import TaskPlanner.Storage;
import TaskPlanner.Tasks.BaseTask;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CSVImporter<T extends BaseTask> extends FileImporter<T> implements Import {
    public CSVImporter(Storage<T> storage) {
        super(storage);
    }
    public ArrayList<ArrayList<String>> parseFile(String file) throws IOException {
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            lines.add(getArray(sc.nextLine(), ";"));
        }
        fr.close();
        System.out.println(lines);
        return lines;
    }

    public ArrayList<String> getArray(String line, String delimiter) {
        return new ArrayList<>(List.of(line.split(delimiter)));
    }
}
