package BookShelf;
public class BookShelf {
    private int id;
    private int maxCapacity;
    private int booksAmount;
    private int thingsAmount;
    private boolean isFull = false;
    public boolean isOpened = false;

    public BookShelf(int id, int maxCapacity, int booksAmount, int thingsAmount) {
        if (booksAmount + thingsAmount > maxCapacity) {
            maxCapacity = booksAmount + thingsAmount;
            System.out.println("Max capacity of bookshelf with id: " +id+ " changed to " + maxCapacity);
        }
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.booksAmount = booksAmount;
        this.thingsAmount = thingsAmount;
        if (booksAmount + thingsAmount > maxCapacity) isFull = true;
    }

    public BookShelf(int id, int maxCapacity) {
        this(id, maxCapacity, 0, 0);
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getBooksAmount() {
        return booksAmount;
    }

    public int getThingsAmount() {
        return thingsAmount;
    }

    public boolean addBook() {
        if (!isFull) {
            booksAmount++;
            if (isFullCheck()) {
                isFull = true;
            }
            return true;
        }
        System.out.println("Not enough free space");
        return false;

    }

    public boolean removeBook() {
        if (booksAmount != 0) {
            booksAmount--;
            isFull = false;
            return true;
        }
        return false;
    }

    public boolean isFullCheck() {
        return (booksAmount + thingsAmount) == maxCapacity;
    }
    public void open(){
        if(!isOpened){
            isOpened=true;
        }
    }
    public void close(){
        if(isOpened){
            isOpened=false;
        }
    }
    public void info(){
        System.out.printf("Bookshelf #%d\nMax capacity: %d;\nContains %d books, %d other objects;\n", id, maxCapacity, booksAmount, thingsAmount);
    }
}
