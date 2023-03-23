package phonebook.view;

import java.util.Scanner;

public abstract class View {
    protected Scanner in;

    public View() {
        this.in = new Scanner(System.in);
    }

    public Scanner getIn() {
        return in;
    }

    public void setIn(Scanner in) {
        this.in = in;
    }
}
