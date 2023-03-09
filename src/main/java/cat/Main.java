package cat;

public class Main {
    public static void main(String[] args) {
        Man person = new Man("Misha");
        Cat cat = new Cat("Fluffy", "British", 2019);
        cat.info();
        cat.sleep();
        person.callCat(cat);
        person.feedCat(cat, "fish");
        person.feedCat(cat, "mouse");
    }
}
