package cat;

public class Main {
    public static void main(String[] args) {
        Man person = new Man("Misha");
        Cat fluffy = new Cat("Fluffy", "British", 2019);
        Hamster chip = new Hamster("Chip", "Chipmunk", 1989);
        Animal dale = new Hamster("Dale", "Chipmunk", 1989);
        Lion simba = new Lion("Simba", "African", 1994);
//        ((Hamster) dale).printInfo();
        simba.printInfo();
        person.addPet(fluffy);
        person.addPet(chip);
        person.addPet(dale);
        System.out.println(person.getPets());
        fluffy.sleep();
//        person.call(fluffy);
//        person.feed(fluffy, "fish");
//        person.feed(fluffy, "mouse");
        person.feed(simba, "mouse");
        simba.hunt();
    }
}
