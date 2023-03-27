package phonebook.model;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.UUID;

public class Contact implements Iterator<String>{
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String phone;
    protected LocalDate creationDate;
    protected int index = 0;


    public Contact(String firstName, String lastName, String phone) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.creationDate = LocalDate.now();
    }

    public Contact(UUID id, String firstName, String lastName, LocalDate creationDate, String phone) {
        this(firstName, lastName, phone);
        this.id = id;
        this.creationDate = creationDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!this.getClass().equals(obj.getClass())) {
            return false;
        } else
            return this.firstName.equals(((Contact) obj).firstName)
                    && this.lastName.equals(((Contact) obj).lastName)
                    && this.phone.equals(((Contact) obj).phone);
    }


    @Override
    public boolean hasNext() {
        return index < 5;
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
                return phone;
            case 4:
                return creationDate.toString();
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return String.format("FirstName: %s\nLastName: %s\nPhone number: %s\nContact created: %s",
                                firstName, lastName, phone, creationDate);
    }
}
