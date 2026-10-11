# UML Class Diagram (Library System v1)

```mermaid
classDiagram
    direction TB

    class Book {
        -String isbn
        -String title
        -String author
        -boolean issued
        +Book(isbn: String, title: String, author: String)
        +getIsbn() String
        +getTitle() String
        +getAuthor() String
        +isIssued() boolean
        +setIssued(issued: boolean) void
        +toString() String
    }

    class Member {
        -int memberId
        -String name
        -Book[] borrowedBooks
        -int borrowedCount
        -static int MAX_BORROW_LIMIT$
        -static int idSequence$
        +Member(name: String)
        +getMemberId() int
        +getName() String
        +setName(name: String) void
        +getBorrowedCount() int
        +getBorrowedBooks() Book[]
        +canBorrow() boolean
        +addBorrowedBook(book: Book) boolean
        +removeBorrowedBook(isbn: String) boolean
        +toString() String
    }

    class Library {
        -Book[] books
        -int bookCount
        -Member[] members
        -int memberCount
        -static int MAX_BOOKS$
        -static int MAX_MEMBERS$
        +Library()
        +addBook(book: Book) boolean
        +registerMember(member: Member) boolean
        +findBookByIsbn(isbn: String) Book
        +findMemberById(id: int) Member
        +issueBook(isbn: String, memberId: int) boolean
        +returnBook(isbn: String, memberId: int) boolean
        +displayCatalog() void
        +displayMembers() void
    }

    class Main {
        +main(args: String[]) void$
    }

    Library o-- "0..50" Book : aggregates
    Library o-- "0..20" Member : aggregates
    Member o-- "0..3" Book : borrows
    Main ..> Library : utilizes
```

## Notation Legend
- `+` Public member
- `-` Private member
- `#` Protected member
- `$` Static member
- `o--` Aggregation relationship
- `..>` Dependency relationship
