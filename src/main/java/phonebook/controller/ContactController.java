package phonebook.controller;

import phonebook.model.Contact;
import phonebook.model.MultipleContact;
import phonebook.model.PhoneBook;
import phonebook.service.PhoneBookIterator;
import phonebook.service.exporter.CsvExporter;
import phonebook.service.importer.CsvImporter;
import phonebook.view.ContactView;

import java.io.IOException;

public class ContactController {
    protected PhoneBook phonebook;
    protected PhoneBookIterator iterator;
    protected ContactView view;

    public ContactController(PhoneBook phonebook, ContactView view) {
        this.phonebook = phonebook;
        this.view = view;
        this.iterator = new PhoneBookIterator(this.phonebook);
    }

    public PhoneBook getPhonebook() {
        return phonebook;
    }

    public void setPhonebook(PhoneBook phonebook) {
        this.phonebook = phonebook;
    }

    public ContactView getView() {
        return view;
    }

    public void setView(ContactView view) {
        this.view = view;
    }

    public void createContact() {
        String firstname = view.getFirstName();
        String lastname = view.getLastName();
        String phone = view.getPhone();
        Contact newContact = new MultipleContact(firstname, lastname, phone);
        boolean in = true;
        while (in) {
            System.out.println("Add more numbers?\n1-Yes\t2-No\n");
            int input = view.getInput();
            if (input == 1) {
                ((MultipleContact) newContact).addPhone(view.getPhone());
            } else {
                in = false;
            }
        }
        phonebook.addContact(newContact);
    }

    public void importCSV() throws IOException {
        String file = view.getFilename();
        new CsvImporter(phonebook.getPhonebook()).importFile(file);
    }

    public void exportCSV() throws IOException {
        new CsvExporter(phonebook.getPhonebook()).export();
    }


}
