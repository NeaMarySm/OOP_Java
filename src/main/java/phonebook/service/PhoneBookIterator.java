package phonebook.service;

import phonebook.model.Contact;
import phonebook.model.PhoneBook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class PhoneBookIterator implements ListIterator<Contact> {
    private PhoneBook phonebook;

    public PhoneBookIterator(PhoneBook phonebook) {
        this.phonebook = phonebook;
    }

    @Override
    public boolean hasNext() {
        return phonebook.index < phonebook.getPhonebook().size();
    }

    @Override
    public Contact next() {
        return phonebook.getPhonebook().get(phonebook.index++);
    }

    @Override
    public boolean hasPrevious() {
        return phonebook.index > 0;
    }

    @Override
    public Contact previous() {
        return phonebook.getPhonebook().get(phonebook.index--);
    }

    @Override
    public int nextIndex() {
        if (phonebook.index < phonebook.getPhonebook().size() - 1) {
            return ++phonebook.index;
        } else return phonebook.getPhonebook().size() - 1;
    }

    @Override
    public int previousIndex() {
        if (phonebook.index > 0) {
            return --phonebook.index;
        } else return 0;
    }

    @Override
    public void remove() {
        phonebook.getPhonebook().remove(phonebook.index);
    }

    @Override
    public void set(Contact contact) {
        phonebook.getPhonebook().set(phonebook.index, contact);
    }

    @Override
    public void add(Contact contact) {
        if (!phonebook.getPhonebook().contains(contact)) {
            phonebook.getPhonebook().add(phonebook.index, contact);
        }
    }

}
