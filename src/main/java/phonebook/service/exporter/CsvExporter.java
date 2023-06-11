package phonebook.service.exporter;

import phonebook.model.Contact;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CsvExporter extends FileExporter<Contact>{

    public CsvExporter(ArrayList<Contact> data) {
        super(data);
    }
    @Override
    public void export() throws IOException {
        String filename = generateFileName("csv");
        FileWriter fw = new FileWriter(filename);
        data.forEach(line -> {
            try {
                fw.write(createFormattedLine(line));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        fw.close();
    }

    public String createFormattedLine(Contact contact) {
        StringBuilder sb = new StringBuilder();
        while (contact.hasNext()) {
            sb.append(contact.next());
            sb.append(';');
        }
        sb.append("\n");
        return sb.toString();
    }
}
