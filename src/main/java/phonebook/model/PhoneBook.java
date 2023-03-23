package phonebook.model;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class PhoneBook implements ListIterator<Contact> {
    private ArrayList<Contact> phonebook = new ArrayList<>();
    private static int counter = 0;
    private int index = 0;

    public ArrayList<Contact> getPhonebook() {
        return phonebook;
    }

    public void setPhonebook(ArrayList<Contact> phonebook) {
        this.phonebook = phonebook;
    }

    public boolean addContact(Contact contact) {
        if (!phonebook.contains(contact)) {
            return phonebook.add(contact);
        } else return false;
    }

    public boolean remove(Contact contact) {
        if (phonebook.contains(contact)) {
            return phonebook.remove(contact);
        } else return false;
    }

    public void exportCSV() throws IOException {
        String filename = String.format("export_contacts_%d.csv", ++counter);
        FileWriter fw = new FileWriter(filename);
        phonebook.forEach(line -> {
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

    public void importCSV(String file) throws IOException {
        ArrayList<ArrayList<String>> rawContacts = parseFile(file);
        for (ArrayList<String> contact : rawContacts) {
            phonebook.add(new Contact(
                    UUID.fromString(contact.get(0)), contact.get(1), contact.get(2), contact.get(3), LocalDate.parse(contact.get(4))));
        }
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

    public Contact getCurrentContact() {
        return phonebook.get(index);
    }

    @Override
    public boolean hasNext() {
        return index < phonebook.size();
    }

    @Override
    public Contact next() {
        return phonebook.get(index++);
    }

    @Override
    public boolean hasPrevious() {
        return index > 0;
    }

    @Override
    public Contact previous() {
        return phonebook.get(index--);
    }

    @Override
    public int nextIndex() {
        if (index < phonebook.size() - 1) {
            return ++index;
        } else return phonebook.size() - 1;
    }

    @Override
    public int previousIndex() {
        if (index > 0) {
            return --index;
        } else return 0;
    }

    @Override
    public void remove() {
        phonebook.remove(index);
    }

    @Override
    public void set(Contact contact) {
        phonebook.set(index, contact);
    }

    @Override
    public void add(Contact contact) {
        if (!phonebook.contains(contact)) {
            phonebook.add(index, contact);
        }
    }

}
