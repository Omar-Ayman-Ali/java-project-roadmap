package library.model;

public class Member {
    private static final int MAX_BORROW_LIMIT = 3;
    private static int idSequence = 2000;

    private final int memberId;
    private String name;
    private Book[] borrowedBooks;
    private int borrowedCount;

    public Member(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Member name cannot be null or empty.");
        }
        idSequence++;
        this.memberId = idSequence;
        this.name = name.trim();
        this.borrowedBooks = new Book[MAX_BORROW_LIMIT];
        this.borrowedCount = 0;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public int getBorrowedCount() {
        return borrowedCount;
    }

    public Book[] getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean canBorrow() {
        return borrowedCount < MAX_BORROW_LIMIT;
    }

    public boolean addBorrowedBook(Book book) {
        if (book == null) {
            return false;
        }
        if (!canBorrow()) {
            System.out.println("Borrow failed: Member #" + memberId + " reached maximum borrowing limit (" + MAX_BORROW_LIMIT + ").");
            return false;
        }
        borrowedBooks[borrowedCount] = book;
        borrowedCount++;
        return true;
    }

    public boolean removeBorrowedBook(String isbn) {
        if (isbn == null || borrowedCount == 0) {
            return false;
        }
        for (int i = 0; i < borrowedCount; i++) {
            if (borrowedBooks[i] != null && borrowedBooks[i].getIsbn().equalsIgnoreCase(isbn)) {
                // Shift remaining elements to keep array contiguous
                for (int j = i; j < borrowedCount - 1; j++) {
                    borrowedBooks[j] = borrowedBooks[j + 1];
                }
                borrowedBooks[borrowedCount - 1] = null;
                borrowedCount--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Member[ID=%d, Name='%s', Borrowed=%d/%d]",
                memberId, name, borrowedCount, MAX_BORROW_LIMIT);
    }
}
