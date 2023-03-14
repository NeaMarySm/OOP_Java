package cat;

import java.util.Comparator;

public class AnimalAgeComparator implements Comparator<Animal> {
    @Override
    public int compare(Animal o1, Animal o2) {
        return o2.getBirthYear()-o1.getBirthYear();
    }
}
