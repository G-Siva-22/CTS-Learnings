import java.util.Arrays;

public class Library {
    Book[] books;
    int count;

    public Library(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        }
    }

    public Book linearSearch(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, count, (a, b) -> a.title.compareToIgnoreCase(b.title));
    }

    public Book binarySearch(String title) {
        int low = 0, high = count - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0)
                return books[mid];
            else if (cmp < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return null;
    }

    public void displayBooks() {
        System.out.println("\nAll Books:");
        for (int i = 0; i < count; i++) {
            System.out.println(books[i]);
        }
    }
}
