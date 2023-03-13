package cat;

import java.util.ArrayList;
import java.util.List;

public class Lion extends Animal implements Printable, Hunt{
    public Lion(String name, String breed, int birthYear) {
        super(name, breed, birthYear);
        foodList = new ArrayList<>(List.of( "meat", "water"));
        nutrition=Nutrition.meat;
        isWild = Boolean.TRUE;
    }

    @Override
    public void printInfo() {
        System.out.printf("Lion %s, breed: %s, age: %d\n", name, breed, getAge());

    }

    @Override
    public void hunt() {
        System.out.println("Lion starts hunt");

    }

    @Override
    public void voice() {
        System.out.println(name + " says Arrrrr!");
    }
    public String toString(){
        return String.format("Lion %s", name);
    }
}
