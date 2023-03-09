package BookShelf;


public class Man {
    private String name;

    public Man(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void openDoors(BookShelf bookShelf) {
        if (!bookShelf.isOpened) {
            bookShelf.open();
        }
    }

    public void closeDoors(BookShelf bookShelf) {
        if (bookShelf.isOpened) {
            bookShelf.close();
        }
    }
    public boolean storeBook(BookShelf bookShelf){
        openDoors(bookShelf);
        boolean result = bookShelf.addBook();
        closeDoors(bookShelf);
        return result;

    }
    public boolean removeBook(BookShelf bookShelf){
        openDoors(bookShelf);
        boolean result = bookShelf.removeBook();
        closeDoors(bookShelf);
        return result;
    }
}
