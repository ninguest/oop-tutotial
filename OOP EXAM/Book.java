public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;

    // Constructor
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isBorrowed = false;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    // Methods
    public void borrowBook() throws Exception {
        if (!isBorrowed) {
            isBorrowed = true;
        } else {
            throw new Exception("This book is already borrowed.");
        }
    }

    public void returnBook() throws Exception{
        if (isBorrowed) {
            isBorrowed = false;
        } else {
            throw new Exception("This book was not borrowed.");
        }
    }
}