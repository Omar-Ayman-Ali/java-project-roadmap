package library.service;

import library.model.Book;
import library.model.Member;

public class Library {
    private static final int MAX_BOOKS = 50;
    private static final int MAX_MEMBERS = 20;

    private Book[] books;
    private int bookCount;
    private Member[] members;
    private int memberCount;

    public Library() {
        this.books = new Book[MAX_BOOKS];
        this.bookCount = 0;
        this.members = new Member[MAX_MEMBERS];
        this.memberCount = 0;
    }

    public boolean addBook(Book book) {
        if (book == null) {
            System.out.println("Error: Cannot add null book.");
            return false;
        }
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Error: Library catalog is full.");
            return false;
        }
        if (findBookByIsbn(book.getIsbn()) != null) {
            System.out.println("Error: Book with ISBN " + book.getIsbn() + " already exists in catalog.");
            return false;
        }
        books[bookCount] = book;
        bookCount++;
        return true;
    }

    public boolean registerMember(Member member) {
        if (member == null) {
            System.out.println("Error: Cannot register null member.");
            return false;
        }
        if (memberCount >= MAX_MEMBERS) {
            System.out.println("Error: Membership roster is full.");
            return false;
        }
        if (findMemberById(member.getMemberId()) != null) {
            System.out.println("Error: Member with ID " + member.getMemberId() + " already registered.");
            return false;
        }
        members[memberCount] = member;
        memberCount++;
        return true;
    }

    public Book findBookByIsbn(String isbn) {
        if (isbn == null) {
            return null;
        }
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null && books[i].getIsbn().equalsIgnoreCase(isbn.trim())) {
                return books[i];
            }
        }
        return null;
    }

    public Member findMemberById(int memberId) {
        for (int i = 0; i < memberCount; i++) {
            if (members[i] != null && members[i].getMemberId() == memberId) {
                return members[i];
            }
        }
        return null;
    }

    public boolean issueBook(String isbn, int memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Operation failed: Book with ISBN '" + isbn + "' not found in catalog.");
            return false;
        }
        if (book.isIssued()) {
            System.out.println("Operation failed: Book '" + book.getTitle() + "' is already checked out.");
            return false;
        }

        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Operation failed: Member ID #" + memberId + " not found.");
            return false;
        }
        if (!member.canBorrow()) {
            System.out.println("Operation failed: Member '" + member.getName() + "' has reached borrowing quota.");
            return false;
        }

        if (member.addBorrowedBook(book)) {
            book.setIssued(true);
            System.out.printf("Success: '%s' issued to member '%s' (ID #%d).%n",
                    book.getTitle(), member.getName(), member.getMemberId());
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn, int memberId) {
        Book book = findBookByIsbn(isbn);
        if (book == null) {
            System.out.println("Operation failed: Book with ISBN '" + isbn + "' not recognized.");
            return false;
        }
        Member member = findMemberById(memberId);
        if (member == null) {
            System.out.println("Operation failed: Member ID #" + memberId + " not found.");
            return false;
        }

        if (member.removeBorrowedBook(isbn)) {
            book.setIssued(false);
            System.out.printf("Success: '%s' returned by member '%s'.%n",
                    book.getTitle(), member.getName());
            return true;
        } else {
            System.out.printf("Operation failed: Member '%s' does not currently hold book '%s'.%n",
                    member.getName(), book.getTitle());
            return false;
        }
    }

    public void displayCatalog() {
        if (bookCount == 0) {
            System.out.println("The library catalog is currently empty.");
            return;
        }
        System.out.println("\n--- Library Catalog (" + bookCount + "/" + MAX_BOOKS + " books) ---");
        for (int i = 0; i < bookCount; i++) {
            if (books[i] != null) {
                System.out.println((i + 1) + ". " + books[i]);
            }
        }
    }

    public void displayMembers() {
        if (memberCount == 0) {
            System.out.println("No registered members found.");
            return;
        }
        System.out.println("\n--- Registered Members (" + memberCount + "/" + MAX_MEMBERS + ") ---");
        for (int i = 0; i < memberCount; i++) {
            if (members[i] != null) {
                System.out.println((i + 1) + ". " + members[i]);
                Book[] borrowed = members[i].getBorrowedBooks();
                for (int b = 0; b < members[i].getBorrowedCount(); b++) {
                    if (borrowed[b] != null) {
                        System.out.println("     -> [Borrowed] " + borrowed[b].getTitle() + " (ISBN: " + borrowed[b].getIsbn() + ")");
                    }
                }
            }
        }
    }
}
