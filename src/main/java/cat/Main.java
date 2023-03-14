package cat;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Man person = new Man("Misha");
        Cat fluffy = new Cat("Fluffy", "British", 2019);
        Hamster chip = new Hamster("Chip", "Chipmunk", 1999);
        Animal dale = new Hamster("Dale", "Chipmunk", 1989);
        Lion simba = new Lion("Simba", "African", 1994);
//        ((Hamster) dale).printInfo();
        simba.printInfo();
        person.addPet(fluffy);
        person.addPet(chip);
        person.addPet(dale);
        person.addPet(simba);

        while (person.hasNext()){
            System.out.println(person.next());
        }
        while ((chip.hasNext())){
            System.out.println(chip.next());
        }
        AnimalAgeComparator ageComparator = new AnimalAgeComparator();
        List<Animal> pets = person.getPets();
        System.out.println(pets);
        pets.sort(ageComparator);
        System.out.println(pets);


    }
}
