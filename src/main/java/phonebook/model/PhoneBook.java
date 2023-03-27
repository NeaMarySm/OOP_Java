package phonebook.model;
import java.util.*;

public class PhoneBook {
    private ArrayList<Contact> phonebook = new ArrayList<>();
    public int index = 0;

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

    public Contact getCurrentContact() {
        return phonebook.get(index);
    }

}
