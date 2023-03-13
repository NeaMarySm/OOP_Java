package cat;

import java.util.ArrayList;
import java.util.List;

public class Cat extends Animal implements Printable{

    public Cat(String name, String breed, int birthYear) {
        super(name,breed,birthYear);
        foodList = new ArrayList<>(List.of("fish", "milk", "meat", "water", "cat-feed"));
        nutrition = Nutrition.all;
        isWild = Boolean.FALSE;
    }

    @Override
    public void voice(){
        System.out.println(name + " says Meow-Meow");
    }
    @Override
    public void printInfo() {
        System.out.printf("Cat %s, breed: %s, age: %d\n", name, breed, getAge());
    }
    public String toString(){
        return String.format("Cat %s", name);
    }
}
