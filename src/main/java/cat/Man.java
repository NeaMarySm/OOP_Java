package cat;

import java.util.ArrayList;

public class Man implements Printable {
    private String name;
    private ArrayList<Animal> pets = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Man(String name) {
        this.name = name;
    }

    public ArrayList<Animal> getPets() {
        return pets;
    }

    public void setPets(ArrayList<Animal> pets) {
        this.pets = pets;
    }
    public void addPet(Animal pet){
        pets.add(pet);
    }

    public void call(Animal animal) {
        System.out.println(name + " calls " + animal.getName());
        animal.voice();
    }

    public boolean feed(Animal animal, String food) {
        System.out.println(name + " feeds " + animal.getName() + " with " + food);
        return animal.eat(food);
    }

    @Override
    public void printInfo() {
        System.out.println("A man named " + name);
    }
}
