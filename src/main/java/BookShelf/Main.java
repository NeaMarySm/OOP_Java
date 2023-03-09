package BookShelf;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("Alex");
        BookShelf bookShelf_1 = new BookShelf(1,12);
        bookShelf_1.info();
        BookShelf bookShelf_2 = new BookShelf(2,12, 6,8);
        bookShelf_2.info();
        man.storeBook(bookShelf_1);
        man.removeBook(bookShelf_1);
        man.removeBook(bookShelf_1);

        man.storeBook(bookShelf_2);
        man.removeBook(bookShelf_2);
        man.removeBook(bookShelf_2);

        bookShelf_1.info();
        bookShelf_2.info();

    }

}
