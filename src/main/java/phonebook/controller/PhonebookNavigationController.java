package phonebook.controller;

import phonebook.model.Contact;
import phonebook.model.PhoneBook;
import phonebook.view.ContactView;

public class PhonebookNavigationController extends ContactController {
    public PhonebookNavigationController(PhoneBook phonebook, ContactView view) {
        super(phonebook, view);
    }
    public Contact getCurrentContact(){
        return phonebook.getCurrentContact();
    }
    public Contact nextContact(){
        iterator.nextIndex();
        return phonebook.getCurrentContact();
    }
    public Contact previousContact(){
        iterator.previousIndex();
        return phonebook.getCurrentContact();
    }
}
