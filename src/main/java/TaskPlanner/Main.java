package TaskPlanner;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        User john = new User("John");
        Program program = new Program(john);
        program.run();
    }
}
