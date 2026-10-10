public class BankAccount {
    public static final double MIN_OPENING_BALANCE = 100.0;

    private static int totalAccounts = 0;
    private static double totalMoneyInBank = 0.0;
    private static int accountSequence = 1000;

    private final int accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String owner, double initialDeposit) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Account owner name cannot be empty.");
        }
        if (initialDeposit < MIN_OPENING_BALANCE) {
            throw new IllegalArgumentException(
                    "Initial deposit must be at least $" + MIN_OPENING_BALANCE + " (provided: $" + initialDeposit + ").");
        }

        accountSequence++;
        this.accountNumber = accountSequence;
        this.owner = owner.trim();
        this.balance = initialDeposit;

        totalAccounts++;
        totalMoneyInBank += initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if (owner != null && !owner.trim().isEmpty()) {
            this.owner = owner.trim();
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0.0) {
            System.out.println("Transaction rejected: Deposit amount must be positive.");
            return false;
        }
        this.balance += amount;
        totalMoneyInBank += amount;
        System.out.printf("Deposited $%.2f to Account #%d. New balance: $%.2f%n", amount, accountNumber, balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0.0) {
            System.out.println("Transaction rejected: Withdrawal amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.printf("Transaction rejected: Insufficient funds in Account #%d (Available: $%.2f, Requested: $%.2f)%n",
                    accountNumber, balance, amount);
            return false;
        }
        this.balance -= amount;
        totalMoneyInBank -= amount;
        System.out.printf("Withdrew $%.2f from Account #%d. New balance: $%.2f%n", amount, accountNumber, balance);
        return true;
    }

    public boolean transfer(BankAccount destination, double amount) {
        if (destination == null) {
            System.out.println("Transfer rejected: Destination account reference is null.");
            return false;
        }
        if (this == destination) {
            System.out.println("Transfer rejected: Cannot transfer funds to the same account.");
            return false;
        }
        if (amount <= 0.0) {
            System.out.println("Transfer rejected: Transfer amount must be positive.");
            return false;
        }
        if (amount > this.balance) {
            System.out.printf("Transfer rejected: Insufficient funds (Available: $%.2f, Requested: $%.2f)%n",
                    this.balance, amount);
            return false;
        }

        this.balance -= amount;
        destination.balance += amount;
        // Total money in bank remains invariant during an internal transfer
        System.out.printf("Successfully transferred $%.2f from Account #%d to Account #%d.%n",
                amount, this.accountNumber, destination.accountNumber);
        return true;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static double getTotalMoneyInBank() {
        return totalMoneyInBank;
    }

    @Override
    public String toString() {
        return String.format("BankAccount[#%d, Owner='%s', Balance=$%.2f]",
                accountNumber, owner, balance);
    }
}
