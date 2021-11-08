import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class
    String name;
    ArrayList<Book> booklist;

    public Library(String libraryName){
        this.name = libraryName;
    }

    public void addBook(Book newBook) {
        booklist.add(newBook);
    }

    private static void printOpeningHours() {
        System.out.println("Libraries are open 9am to 5pm daily");
    }

    private void printAddress() {
        System.out.println(name);
    }

    private void borrowBook(String bookName) {
        for (Book book : booklist) {
            if(book.getTitle().equals(bookName)) {
                System.out.println("Sorry, this book is already being borrowed");
                return;
            } else {
                System.out.println("You borrowed the book: " + bookName);
                return;
            }
        }
        System.out.println("Sorry, this book is not in our library");
    }

    private void printAvailableBooks() {
        if (booklist.size() == 0) {
            System.out.println("No book in catalog");
        } else {
            for (Book book : booklist) {
                if (!book.isBorrowed()) {
                    System.out.println(book.getTitle());
                }
            }
        }
    }

    private void returnBook(String bookName) {
        for (Book book : booklist) {
            if (book.getTitle().equals(bookName)) {
                if (book.isBorrowed() == true) {
                    System.out.println("You return the book: " + bookName);
                    book.returned();
                    return;
                } else {
                    System.out.println("This book was not borrowed");
                    return;
                }
            }
        }
        System.out.println("Sorry, this book does not belong to us");
    }
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}