package wardrobe;

import java.util.LinkedList;

class Shelf {
    private int height;
    private int width;
    private int depth;

    private int maxCapacity;
    private LinkedList<Cloth> stored = new LinkedList<>();
    private boolean isFull = false;

    public Shelf(int height, int width, int depth) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        maxCapacity = countVolume() / 10000; // 10000 ориентировочный объем 1 предмета в см3
        // если избавиться от магического числа, можно будет не привязываться к см
    }

    public int getHeight() {
        return height;
    }
    public int getMaxCapacity() {
        return maxCapacity;
    }
    public boolean isFull() {
        return isFull;
    }
    public boolean isEmpty() {
        return stored.size() == 0;
    }

    public LinkedList<Cloth> getStored() {
        return stored;
    }

    public int countVolume() {
        return height * width * depth;
    }

    public boolean store(Cloth cloth) {
        if (!isFull) {
            stored.add(cloth);
            if (stored.size() == maxCapacity) {
                isFull = true;
            }
            return true;
        }
        return false;
    }

    public boolean unstore(Cloth cloth) {
        boolean result = stored.remove(cloth);
        isFull = false;
        return result;
    }

    public void showStored() {
        stored.forEach(v -> System.out.println("* " + v.getModel()));
    }
}