package cat;

import java.util.ArrayList;
import java.util.List;

public class Hamster extends Animal implements Printable{

    public Hamster(String name, String breed, int birthYear) {
        super(name,breed,birthYear);
        foodList = new ArrayList<>(List.of("seeds", "salad", "oats"));
        nutrition = Nutrition.plants;
        isWild = Boolean.FALSE;
    }

    @Override
    public void printInfo() {
        System.out.printf("Hamster %s, breed: %s, age: %d\n", name, breed, getAge());
    }

    @Override
    public void voice() {
        System.out.println(name + " says Hrum-hrum");
    }
    public String toString(){
        return String.format("Hamster %s", name);
    }
}
