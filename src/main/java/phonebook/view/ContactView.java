package phonebook.view;

public class ContactView extends View{
    public String getFirstName() {
        System.out.print("FirstName: ");
        return in.nextLine();
    }

    public void setFirstName(String value) {
        System.out.printf("FirstName changed to: %s\n", value);
    }

    public String getLastName() {
        System.out.print("LastName: ");
        return in.nextLine();
    }

    public void setLastName(String value) {
        System.out.printf("LastName changed to: %s\n", value);
    }

    public String getPhone() {
        System.out.print("Phone: ");
        return in.nextLine();
    }

    public void setPhone(String value) {
        System.out.printf("Phone changed to: %s\n", value);
    }
    public String getFilename() {
        System.out.print("Filename: ");
        return in.nextLine();
    }

}
