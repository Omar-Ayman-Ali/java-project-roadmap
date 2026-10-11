package library.app;

import library.model.Book;
import library.model.Member;
import library.service.Library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("=========================================");
        System.out.println("       Library Management System v1      ");
        System.out.println("=========================================");

        // Seed sample catalog and members
        library.addBook(new Book("978-0134685991", "Effective Java", "Joshua Bloch"));
        library.addBook(new Book("978-0134686097", "Java: How to Program", "Paul Deitel"));
        library.addBook(new Book("978-0596009205", "Head First Design Patterns", "Eric Freeman"));

        Member m1 = new Member("John Doe");
        Member m2 = new Member("Jane Smith");
        library.registerMember(m1);
        library.registerMember(m2);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add New Book");
            System.out.println("2. Register New Member");
            System.out.println("3. Issue Book to Member");
            System.out.println("4. Return Book from Member");
            System.out.println("5. Display Book Catalog");
            System.out.println("6. Display Member Roster");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine().trim();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine().trim();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine().trim();

                    try {
                        Book book = new Book(isbn, title, author);
                        if (library.addBook(book)) {
                            System.out.println("Book added successfully.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Failed to add book: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter Member Full Name: ");
                    String name = scanner.nextLine().trim();

                    try {
                        Member member = new Member(name);
                        if (library.registerMember(member)) {
                            System.out.println("Member registered successfully. Assigned ID: " + member.getMemberId());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Registration failed: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ISBN to issue: ");
                    String issueIsbn = scanner.nextLine().trim();
                    System.out.print("Enter Member ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid Member ID.");
                        scanner.next();
                        break;
                    }
                    int issueMemberId = scanner.nextInt();
                    library.issueBook(issueIsbn, issueMemberId);
                    break;

                case 4:
                    System.out.print("Enter Book ISBN to return: ");
                    String returnIsbn = scanner.nextLine().trim();
                    System.out.print("Enter Member ID: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid Member ID.");
                        scanner.next();
                        break;
                    }
                    int returnMemberId = scanner.nextInt();
                    library.returnBook(returnIsbn, returnMemberId);
                    break;

                case 5:
                    library.displayCatalog();
                    break;

                case 6:
                    library.displayMembers();
                    break;

                case 0:
                    System.out.println("Exiting Library Management System.");
                    running = false;
                    break;

                default:
                    System.out.println("Unrecognized choice.");
                    break;
            }

            // ==============================================================
            // TODO: Practice Challenge For You
            // 1. Add searchByTitle(String keyword) to find books by partial title match.
            // 2. Add a loan duration tracker: mark books with a checkout date or day counter.
            // ==============================================================
        }

        scanner.close();
    }
}
