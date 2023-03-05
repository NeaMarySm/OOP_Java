package wardrobe;

public class Main {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe(200, 180, 60, 35);
        Man man = new Man("Alex");
        Cloth sweater = new Cloth("sweater");
        Cloth shirt = new Cloth("shirt");
        man.store(wardrobe,sweater);
        man.store(wardrobe,shirt);
        man.store(wardrobe,shirt); // две ссылки на один и тот же объект?((
        wardrobe.showAll();
        man.getCloth(wardrobe, "shirt");
        man.getCloth(wardrobe, "skirt");
        wardrobe.showAll();
        wardrobe.getCapacity();
    }
}
