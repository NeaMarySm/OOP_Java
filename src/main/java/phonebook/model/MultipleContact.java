package phonebook.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class MultipleContact extends Contact {
    private ArrayList<String> phoneList = new ArrayList<>();

    public MultipleContact(String firstName, String lastName, String phone) {
        super(firstName, lastName, phone);
        this.phoneList.add(phone);
    }

    public MultipleContact(UUID id, String firstName, String lastName, LocalDate creationDate, String phone) {
        super(id, firstName, lastName, creationDate, phone);
        this.phoneList.add(phone);
    }

    public void addPhone(String phone) {
        phoneList.add(phone);
    }

    @Override
    public String next() {
        switch (index++) {
            case 0:
                return id.toString();
            case 1:
                return firstName;
            case 2:
                return lastName;
            case 3:
                return phoneListString();
            case 4:
                return creationDate.toString();
            default:
                return "";
        }
    }

    public String phoneListString() {
        return String.join(",", phoneList);
    }

    @Override
    public String toString() {
        return String.format("FirstName: %s\nLastName: %s\nPhone number: %s\nContact created: %s",
                firstName, lastName, phoneListString(), creationDate);
    }
}
