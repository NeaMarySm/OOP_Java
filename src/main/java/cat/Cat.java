package cat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cat {
    private String name;
    private String breed;
    private int birthYear;
    private ArrayList<String> foodList = new ArrayList<>(List.of("fish", "milk", "meat", "water", "cat-feed"));


    public Cat(String name, String breed, int birthYear) {
        this.name = name;
        this.breed = breed;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public ArrayList<String> getFoodList() {
        return foodList;
    }

    public void setFoodList(ArrayList<String> foodList) {
        this.foodList = foodList;
    }

    public int getAge() {
        return LocalDateTime.now().getYear() - birthYear;
    }

    public void info() {
        System.out.printf("Cat %s, breed: %s, age: %d\n", name, breed, getAge());
    }

    public boolean eat(String food) {
        if (foodList.contains(food.toLowerCase())) {
            System.out.println(name + " eats " + food + "!");
            return true;
        } else {
            System.out.println("Bad food!");
            return false;
        }
    }
    public void meow(){
        System.out.println(name + " says Meow-Meow");
    }
    public void sleep(){
        System.out.println(name + " sleeps");
    }

}
