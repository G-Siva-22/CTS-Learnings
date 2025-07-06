public class Main {
    public static void main(String[] args) {
        Library library = new Library(10);

        library.addBook(new Book(1, "The Hobbit", "J.R.R. Tolkien"));
        library.addBook(new Book(2, "1984", "George Orwell"));
        library.addBook(new Book(3, "Pride and Prejudice", "Jane Austen"));
        library.addBook(new Book(4, "To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book(5, "The Great Gatsby", "F. Scott Fitzgerald"));

        library.displayBooks();

        // Linear Search
        System.out.println("\n-- Linear Search for '1984' --");
        Book foundLinear = library.linearSearch("1984");
        System.out.println(foundLinear != null ? foundLinear : "Book not found");

        // Binary Search
        library.sortBooksByTitle();  // Must sort before binary search
        System.out.println("\n-- Binary Search for 'Pride and Prejudice' --");
        Book foundBinary = library.binarySearch("Pride and Prejudice");
        System.out.println(foundBinary != null ? foundBinary : "Book not found");
    }
}
