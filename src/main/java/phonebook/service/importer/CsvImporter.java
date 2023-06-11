package phonebook.service.importer;

import phonebook.model.Contact;
import phonebook.model.MultipleContact;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class CsvImporter extends FileImporter<Contact> {
    boolean multiple = false;

    public CsvImporter(ArrayList<Contact> storage) {
        super(storage);
    }

    @Override

    public void importFile(String file) throws IOException {
        ArrayList<ArrayList<String>> lines = new ArrayList<>();
        FileReader fr = new FileReader(file);
        Scanner sc = new Scanner(fr);
        while (sc.hasNextLine()) {
            ArrayList<String> contact = getArray(sc.nextLine(), ";");
            if (multiple) {
                String phones = contact.get(3);
                ArrayList<String> phoneList = new ArrayList<>(List.of(phones.split(",")));
                Contact newContact = new MultipleContact(UUID.fromString(contact.get(0)), contact.get(1), contact.get(2), LocalDate.parse(contact.get(4)), phoneList.get(0));
                for (int i = 1; i < phoneList.size(); i++) {
                    ((MultipleContact) newContact).addPhone(phoneList.get(i));
                }
                storage.add(newContact);
            } else {
                storage.add(new Contact(
                        UUID.fromString(contact.get(0)), contact.get(1), contact.get(2), LocalDate.parse(contact.get(4)), contact.get(3)));
            }
        }
        fr.close();
    }

    public ArrayList<String> getArray(String line, String delimiter) {
        ArrayList<String> contact = new ArrayList<>(List.of(line.split(delimiter)));
        multiple = contact.get(3).contains(",");
        return contact;
    }
}
