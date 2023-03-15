package cat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class Animal implements Iterator<String> {
    protected String name;
    protected int birthYear;
    protected String breed;
    protected Nutrition nutrition;
    protected boolean isWild;
    protected ArrayList<String> foodList = new ArrayList<>();
    int index;


    public Animal(String name, String breed, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.breed = breed;
        index = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isWild() {
        return isWild;
    }

    public void setWild(boolean wild) {
        isWild = wild;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
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

    public boolean eat(String food) {
        if (foodList.contains(food.toLowerCase())) {
            System.out.println(name + " eats " + food + "!");
            return true;
        } else {
            System.out.println("Bad food!");
            return false;
        }
    }

    public void sleep() {
        System.out.println(name + " sleeps");
    }

    public abstract void voice();

    @Override
    public boolean hasNext() {
        return index < 6;
    }

    @Override
    public String next() {
        switch (index++) {
            case 0:
                return String.format("%s", this);
            case 1:
                return String.format("Age %d", this.getAge());
            case 2:
                return String.format("Breed %s", this.breed);
            case 3:
                return String.format("Eats %s-food", this.nutrition);
            case 4:
                return this.isWild ? "Wild" : "Domestic";
            case 5:
                return String.format("Diet: %s", this.foodList.toString());
            default:
                return "";

        }
    }
}
