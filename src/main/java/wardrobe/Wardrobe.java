package wardrobe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class Wardrobe {
    private ArrayList<Shelf> shelves = new ArrayList<>();
    private int height; // все размеры в см
    private int width;
    private int depth;
    public boolean isOpened = false;

    public Wardrobe(int height, int width, int depth, int shelfHeight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        int shelvesNumber = height / shelfHeight;
        while (shelvesNumber > 0) {
            shelves.add(new Shelf(shelfHeight, width, depth));
            shelvesNumber--;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public boolean open() {
        if (!isOpened) {
            isOpened = true;
        }
        return true;
    }

    public boolean close() {
        if (isOpened) {
            isOpened = false;
        }
        return true;
    }

    public boolean store(Cloth cloth) {
        if (isOpened) {
            for (Shelf shelf : shelves) {
                if (!shelf.isFull()) {
                    shelf.store(cloth);
                    return true;
                }
            }
            System.out.println("No empty space");
            return false;
        } else System.out.println("Need to open the doors first!");
        return false;
    }

    public Cloth findCloth(String model) {
        for (Shelf shelf : shelves) {
            for (Cloth cloth : shelf.getStored()) {
                if (Objects.equals(cloth.getModel(), model)) {
                    return cloth;
                }
            }
        }
        System.out.println("No such cloth stored");
        return null;
    }

    public boolean unstore(Cloth cloth) {
        if (isOpened) {
            for (Shelf shelf : shelves) {
                if (shelf.getStored().contains(cloth)) {
                    shelf.unstore(cloth);
                    return true;
                }
                return false;
            }
        } else System.out.println("Need to open the doors first!");
        return false;
    }

    public void showAll() {
        for (int i = 0; i < shelves.size(); i++) {
            if (!shelves.get(i).isEmpty()) {
                shelves.get(i).showStored();
            }
        }
    }
    public int getCapacity(){
        System.out.println(shelves.size()+" shelves with capacity "+shelves.get(0).getMaxCapacity());
        int total = shelves.size()*shelves.get(0).getMaxCapacity();
        System.out.println("Total space: "+ total);
        return total;
    }

}


