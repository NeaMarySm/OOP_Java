package wardrobe;

public class Man {
    private String name;

    public Man(String name) {
        this.name = name;
    }

    public void openDoors(Wardrobe wardrobe) {
        if (!wardrobe.isOpened) {
            wardrobe.open();
        }
    }

    public void closeDoors(Wardrobe wardrobe) {
        if (wardrobe.isOpened) {
            wardrobe.close();
        }
    }

    public boolean store(Wardrobe wardrobe, Cloth cloth) {
        openDoors(wardrobe);
        boolean result = wardrobe.store(cloth);
        closeDoors(wardrobe);
        if (result) {
            System.out.println("Successfully stored!");
        }
        return result;
    }

    public Cloth getCloth(Wardrobe wardrobe, String clothModel) {
        openDoors(wardrobe);
        Cloth cloth = wardrobe.findCloth(clothModel);
        if (!(cloth == null)) {
            wardrobe.unstore(cloth);
        }
        closeDoors(wardrobe);
        return cloth;
    }
}

