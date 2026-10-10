import java.util.Scanner;

public class BankApp {
    private static final int MAX_WALLETS = 20;
    private static BankAccount[] wallets = new BankAccount[MAX_WALLETS];
    private static int walletCount = 0;

    private static BankAccount findWallet(int accountNumber) {
        for (int i = 0; i < walletCount; i++) {
            if (wallets[i] != null && wallets[i].getAccountNumber() == accountNumber) {
                return wallets[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=================================================");
        System.out.println("    Campus Pay & NeoBank Digital Wallet System   ");
        System.out.println("=================================================");

        // Seed initial wallets for demonstration (PIN: 1234 for both)
        wallets[walletCount++] = new BankAccount("Alice Smith", 450.0, 1234);
        wallets[walletCount++] = new BankAccount("Bob Johnson", 1100.0, 1234);

        System.out.println("Seeded test accounts initialized with default PIN: 1234");

        while (running) {
            System.out.println("\n--- Campus Wallet Menu ---");
            System.out.println("1. Open New Digital Wallet");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds (PIN Required)");
            System.out.println("4. Instant Peer-to-Peer Transfer (PIN Required)");
            System.out.println("5. Check Wallet Statement (PIN Required)");
            System.out.println("6. Institutional Platform Audit (Shared static data)");
            System.out.println("0. Exit Application");
            System.out.print("Select an operation (0-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please choose a menu number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (walletCount >= MAX_WALLETS) {
                        System.out.println("Registration Error: System capacity reached (" + MAX_WALLETS + " wallets).");
                        break;
                    }
                    scanner.nextLine(); // clear newline
                    System.out.print("Enter account owner full name: ");
                    String name = scanner.nextLine().trim();

                    System.out.printf("Enter opening balance (Minimum $%.2f): $", BankAccount.MIN_OPENING_BALANCE);
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid monetary amount.");
                        scanner.next();
                        break;
                    }
                    double initialDeposit = scanner.nextDouble();

                    System.out.print("Create a 4-digit security PIN (e.g., 5566): ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("Invalid PIN format.");
                        scanner.next();
                        break;
                    }
                    int pin = scanner.nextInt();

                    try {
                        BankAccount newWallet = new BankAccount(name, initialDeposit, pin);
                        wallets[walletCount++] = newWallet;
                        System.out.println("\nWallet created successfully!");
                        System.out.println("Assigned Wallet ID: #" + newWallet.getAccountNumber());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Registration Failed: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter destination Wallet ID #: ");
                    int depId = scanner.nextInt();
                    BankAccount depWallet = findWallet(depId);
                    if (depWallet == null) {
                        System.out.println("Wallet #" + depId + " does not exist.");
                        break;
                    }
                    System.out.print("Enter deposit amount: $");
                    double depAmount = scanner.nextDouble();
                    depWallet.deposit(depAmount);
                    break;

                case 3:
                    System.out.print("Enter your Wallet ID #: ");
                    int withId = scanner.nextInt();
                    BankAccount withWallet = findWallet(withId);
                    if (withWallet == null) {
                        System.out.println("Wallet #" + withId + " does not exist.");
                        break;
                    }
                    System.out.print("Enter 4-digit PIN: ");
                    int withPin = scanner.nextInt();
                    System.out.print("Enter withdrawal amount: $");
                    double withAmount = scanner.nextDouble();
                    withWallet.withdraw(withAmount, withPin);
                    break;

                case 4:
                    System.out.print("Enter your source Wallet ID #: ");
                    int srcId = scanner.nextInt();
                    BankAccount srcWallet = findWallet(srcId);
                    if (srcWallet == null) {
                        System.out.println("Source Wallet #" + srcId + " does not exist.");
                        break;
                    }
                    System.out.print("Enter destination recipient Wallet ID #: ");
                    int destId = scanner.nextInt();
                    BankAccount destWallet = findWallet(destId);
                    if (destWallet == null) {
                        System.out.println("Recipient Wallet #" + destId + " does not exist.");
                        break;
                    }
                    System.out.print("Enter your 4-digit security PIN: ");
                    int srcPin = scanner.nextInt();
                    System.out.print("Enter transfer amount: $");
                    double transferAmount = scanner.nextDouble();
                    srcWallet.transfer(destWallet, transferAmount, srcPin);
                    break;

                case 5:
                    System.out.print("Enter your Wallet ID #: ");
                    int queryId = scanner.nextInt();
                    BankAccount queryWallet = findWallet(queryId);
                    if (queryWallet == null) {
                        System.out.println("Wallet #" + queryId + " not found.");
                        break;
                    }
                    System.out.print("Enter 4-digit PIN: ");
                    int queryPin = scanner.nextInt();
                    double verifiedBalance = queryWallet.getBalance(queryPin);
                    if (verifiedBalance >= 0.0) {
                        System.out.println("\n--- Official Account Statement ---");
                        System.out.println(queryWallet);
                    }
                    break;

                case 6:
                    System.out.println("\n--- Institutional Platform Metrics (static state) ---");
                    System.out.println("Total Registered Wallets : " + BankAccount.getTotalAccounts());
                    System.out.printf("Total Vault Liquidity    : $%.2f%n", BankAccount.getTotalMoneyInBank());
                    System.out.println("\n--- Ledger Overview ---");
                    for (int i = 0; i < walletCount; i++) {
                        System.out.println((i + 1) + ". " + wallets[i]);
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using Campus Pay services. Session closed.");
                    running = false;
                    break;

                default:
                    System.out.println("Unrecognized choice.");
                    break;
            }

            // ==============================================================
            // TODO: Practice Challenge For You
            // 1. Add cashback rewards: deposit an extra 1% bonus on any deposit >= $500.
            // 2. Add an interest calculation method that increases balance by an annual rate.
            // ==============================================================
        }

        scanner.close();
    }
}
