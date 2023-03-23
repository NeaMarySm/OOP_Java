package phonebook.controller;

import phonebook.model.Contact;
import phonebook.model.PhoneBook;
import phonebook.view.ContactView;

import java.io.IOException;

public class ContactController {
    private PhoneBook phonebook;
    private ContactView view;

    public ContactController(PhoneBook phonebook, ContactView view) {
        this.phonebook = phonebook;
        this.view = view;
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

    public boolean createContact(){
        return phonebook.addContact(new Contact(view.getFirstName(), view.getLastName(), view.getPhone()));
    }
    public Contact getCurrentContact(){
        return phonebook.getCurrentContact();
    }
    public Contact nextContact(){
        phonebook.nextIndex();
        return phonebook.getCurrentContact();
    }
    public Contact previousContact(){
        phonebook.previousIndex();
        return phonebook.getCurrentContact();
    }
    public void importContacts() throws IOException {
        String file = view.getFilename();
        phonebook.importCSV(file);
    }
    public void exportContacts() throws IOException {
        phonebook.exportCSV();
    }


}
