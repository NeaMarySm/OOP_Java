package TaskPlanner.FileHandlers.Export;

import TaskPlanner.Tasks.BaseTask;

import java.io.*;
import java.util.ArrayList;

public class CSVExporter<T extends BaseTask> extends FileExporter<T> implements Export {
    public CSVExporter(ArrayList<T> tasks) {
        super(tasks);
    }

    @Override
    public void export() throws IOException {
        String filename = String.format("document_%d.csv", counter);
        FileWriter fw = new FileWriter(filename);
        tasks.forEach(line -> {
            try {
                fw.write(createFormattedLine(line));
                System.out.println(filename);
                System.out.println(line);
                System.out.println("printed");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        fw.close();
    }

    public void exportNew() {
        StringBuilder sb = new StringBuilder();
        try (PrintWriter writer = new PrintWriter(new File("res.csv"))) {

            for (T task : tasks) {
                while (task.hasNext()) {
                    sb.append(task.next());
                    sb.append(";");
                }
                sb.append("\n");
            }
            writer.write(sb.toString());
            writer.close();
            System.out.println("Файл записан");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public String createFormattedLine(T task) {
        StringBuilder sb = new StringBuilder();
        while (task.hasNext()) {
            sb.append(task.next());
            sb.append(';');
        }
        sb.append("\n");
        return sb.toString();
    }

}
