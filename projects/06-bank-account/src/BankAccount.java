public class BankAccount {
    public static final double MIN_OPENING_BALANCE = 50.0;
    public static final double MAX_TRANSFER_LIMIT = 2000.0;

    private static int totalAccounts = 0;
    private static double totalMoneyInBank = 0.0;
    private static int accountSequence = 1000;

    private final int accountNumber;
    private String owner;
    private double balance;
    private int pinCode;

    public BankAccount(String owner, double initialDeposit, int pinCode) {
        if (owner == null || owner.trim().isEmpty()) {
            throw new IllegalArgumentException("Account owner name cannot be empty.");
        }
        if (initialDeposit < MIN_OPENING_BALANCE) {
            throw new IllegalArgumentException(
                    "Initial deposit must be at least $" + MIN_OPENING_BALANCE + " (provided: $" + initialDeposit + ").");
        }
        if (pinCode < 1000 || pinCode > 9999) {
            throw new IllegalArgumentException("Security PIN must be a 4-digit number (1000-9999).");
        }

        accountSequence++;
        this.accountNumber = accountSequence;
        this.owner = owner.trim();
        this.balance = initialDeposit;
        this.pinCode = pinCode;

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

    public boolean verifyPin(int enteredPin) {
        return this.pinCode == enteredPin;
    }

    public double getBalance(int enteredPin) {
        if (!verifyPin(enteredPin)) {
            System.out.println("Security Error: Invalid PIN. Access denied.");
            return -1.0;
        }
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0.0) {
            System.out.println("Transaction Rejected: Deposit amount must be positive.");
            return false;
        }
        this.balance += amount;
        totalMoneyInBank += amount;
        System.out.printf("Success: Deposited $%.2f into Wallet #%d. New balance: $%.2f%n",
                amount, accountNumber, balance);
        return true;
    }

    public boolean withdraw(double amount, int enteredPin) {
        if (!verifyPin(enteredPin)) {
            System.out.println("Security Error: Invalid PIN. Withdrawal blocked.");
            return false;
        }
        if (amount <= 0.0) {
            System.out.println("Transaction Rejected: Withdrawal amount must be positive.");
            return false;
        }
        if (amount > balance) {
            System.out.printf("Transaction Rejected: Insufficient balance (Available: $%.2f, Requested: $%.2f)%n",
                    balance, amount);
            return false;
        }

        this.balance -= amount;
        totalMoneyInBank -= amount;
        System.out.printf("Success: Withdrew $%.2f from Wallet #%d. Remaining balance: $%.2f%n",
                amount, accountNumber, balance);
        return true;
    }

    public boolean transfer(BankAccount destination, double amount, int enteredPin) {
        if (!verifyPin(enteredPin)) {
            System.out.println("Security Error: Invalid PIN. Transfer blocked.");
            return false;
        }
        if (destination == null) {
            System.out.println("Transfer Error: Destination wallet not found.");
            return false;
        }
        if (this == destination) {
            System.out.println("Transfer Error: Cannot transfer funds to the same wallet.");
            return false;
        }
        if (amount <= 0.0) {
            System.out.println("Transfer Error: Amount must be positive.");
            return false;
        }
        if (amount > MAX_TRANSFER_LIMIT) {
            System.out.printf("Transfer Error: Amount exceeds daily security ceiling ($%.2f).%n", MAX_TRANSFER_LIMIT);
            return false;
        }
        if (amount > this.balance) {
            System.out.printf("Transfer Error: Insufficient funds (Available: $%.2f, Requested: $%.2f)%n",
                    this.balance, amount);
            return false;
        }

        this.balance -= amount;
        destination.balance += amount;
        // Internal transfer maintains institutional vault equilibrium
        System.out.printf("Success: Transferred $%.2f from Wallet #%d to Wallet #%d.%n",
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
        return String.format("CampusWallet[#%d, Owner='%s', Balance=$%.2f]",
                accountNumber, owner, balance);
    }
}
