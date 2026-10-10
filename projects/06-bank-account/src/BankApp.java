import java.util.Scanner;

public class BankApp {
    private static final int MAX_ACCOUNTS = 20;
    private static BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];
    private static int accountCount = 0;

    private static BankAccount findAccount(int accountNumber) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i] != null && accounts[i].getAccountNumber() == accountNumber) {
                return accounts[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("       Banking Management System (L02)   ");
        System.out.println("=========================================");

        // Seed initial accounts to showcase system functionality
        accounts[accountCount++] = new BankAccount("Alice Smith", 500.0);
        accounts[accountCount++] = new BankAccount("Bob Johnson", 1200.0);

        while (running) {
            System.out.println("\n--- Bank Service Menu ---");
            System.out.println("1. Open New Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Account Details");
            System.out.println("6. Display Bank Global Summary (static audit)");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (accountCount >= MAX_ACCOUNTS) {
                        System.out.println("Error: Bank database has reached maximum capacity (" + MAX_ACCOUNTS + ").");
                        break;
                    }
                    scanner.nextLine(); // clear newline
                    System.out.print("Enter account owner full name: ");
                    String name = scanner.nextLine().trim();

                    System.out.printf("Enter opening balance (Minimum $%.2f): ", BankAccount.MIN_OPENING_BALANCE);
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid currency value.");
                        scanner.next();
                        break;
                    }
                    double initialDeposit = scanner.nextDouble();

                    try {
                        BankAccount newAcc = new BankAccount(name, initialDeposit);
                        accounts[accountCount++] = newAcc;
                        System.out.println("Account created successfully!");
                        System.out.println("Assigned Account Number: " + newAcc.getAccountNumber());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Registration failed: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    int depAccNum = scanner.nextInt();
                    BankAccount depAcc = findAccount(depAccNum);
                    if (depAcc == null) {
                        System.out.println("Account #" + depAccNum + " not found.");
                        break;
                    }
                    System.out.print("Enter deposit amount: ");
                    double depAmount = scanner.nextDouble();
                    depAcc.deposit(depAmount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    int withAccNum = scanner.nextInt();
                    BankAccount withAcc = findAccount(withAccNum);
                    if (withAcc == null) {
                        System.out.println("Account #" + withAccNum + " not found.");
                        break;
                    }
                    System.out.print("Enter withdrawal amount: ");
                    double withAmount = scanner.nextDouble();
                    withAcc.withdraw(withAmount);
                    break;

                case 4:
                    System.out.print("Enter source account number: ");
                    int srcNum = scanner.nextInt();
                    BankAccount srcAcc = findAccount(srcNum);
                    if (srcAcc == null) {
                        System.out.println("Source account #" + srcNum + " not found.");
                        break;
                    }
                    System.out.print("Enter destination account number: ");
                    int destNum = scanner.nextInt();
                    BankAccount destAcc = findAccount(destNum);
                    if (destAcc == null) {
                        System.out.println("Destination account #" + destNum + " not found.");
                        break;
                    }
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    srcAcc.transfer(destAcc, transferAmount);
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    int queryNum = scanner.nextInt();
                    BankAccount queryAcc = findAccount(queryNum);
                    if (queryAcc != null) {
                        System.out.println("\nAccount Record: " + queryAcc);
                    } else {
                        System.out.println("Account #" + queryNum + " does not exist.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- Bank Institutional Metrics (static fields) ---");
                    System.out.println("Total Active Accounts: " + BankAccount.getTotalAccounts());
                    System.out.printf("Total Vault Assets   : $%.2f%n", BankAccount.getTotalMoneyInBank());
                    System.out.println("\n--- Account Ledger ---");
                    for (int i = 0; i < accountCount; i++) {
                        System.out.println((i + 1) + ". " + accounts[i]);
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using Banking Services. Exiting.");
                    running = false;
                    break;

                default:
                    System.out.println("Unrecognized menu choice.");
                    break;
            }
        }

        scanner.close();
    }
}
