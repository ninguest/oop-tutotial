import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void borrowBook(String ISBN) throws Exception {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (!book.isBorrowed()) {
                    book.borrowBook();
                    System.out.println("You've successfully borrowed the book: " + book.getTitle());
                    return;
                } else {
                    System.out.println("Sorry, this book is already borrowed.");
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our library.");
    }

    public void returnBook(String ISBN) throws Exception{
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                if (book.isBorrowed()) {
                    book.returnBook();
                    System.out.println("You've successfully returned the book: " + book.getTitle());
                    return;
                } else {
                    System.out.println("This book was not borrowed.");
                    return;
                }
            }
        }
        System.out.println("Sorry, this book is not in our library.");
    }

    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084");
        Book book3 = new Book("1984", "George Orwell", "9780451524935");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        try {
            library.borrowBook("9780743273565");
            library.borrowBook("9780743273565");
            library.returnBook("9780743273565");
            library.returnBook("9780743273565");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}