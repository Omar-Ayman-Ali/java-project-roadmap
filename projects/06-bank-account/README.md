# Bank Account (Campus NeoBank and Digital Wallet)

**Live Demo:** Not deployed (local execution only)

A secure mobile digital wallet application enforcing object encapsulation, PIN security verification, transfer ceiling limits, and institutional static metrics.

![Language](https://img.shields.io/badge/Language-Java_21-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Course-CIS_201_L01--L02-blue?style=flat-square)
![Build](https://img.shields.io/badge/Build-javac_CLI-green?style=flat-square)

## Table of Contents
- [About](#about)
- [Architecture](#architecture)
- [Features](#features)
- [Detailed Project Explanation](#detailed-project-explanation)
- [Tech Stack](#tech-stack)
- [Run Locally](#run-locally)
- [Project Structure](#project-structure)
- [Hints](#hints)

## About
This project implements an encapsulated digital wallet system grounded in object-oriented fundamentals from Lectures 1 and 2. It protects user balances behind private fields, enforces authentication via 4-digit security PIN verification, and imposes transaction ceilings on peer-to-peer transfers. Class-level static members maintain platform accountability by tracking global account counts and circulating institutional liquidity.

## Architecture
Memory is partitioned between per-wallet heap allocations and class-level static metaspace data:
- **Instance Variables (`balance`, `accountNumber`, `owner`, `pinCode`)**: Unique to each individual wallet instance. `accountNumber` is marked `final` to ensure immutability post-instantiation.
- **Static Class Variables (`totalAccounts`, `totalMoneyInBank`, `accountSequence`)**: Shared across all instantiated wallets to produce unique account numbers and track overall money supply.

```
+-------------------------------------------------------------------+
| Metaspace / Class Static Area: BankAccount                        |
|   totalAccounts: 2                                                |
|   totalMoneyInBank: $1550.00                                      |
|   accountSequence: 1002                                           |
+-------------------------------------------------------------------+
         ^                                           ^
         | shared static access                      | shared static access
+-------------------------------+           +-------------------------------+
| Heap Object: BankAccount      |           | Heap Object: BankAccount      |
|   accountNumber: 1001 (final) |           |   accountNumber: 1002 (final) |
|   owner: "Alice Smith"        |           |   owner: "Bob Johnson"        |
|   balance: $450.00 (private)  |           |   balance: $1100.00 (private) |
|   pinCode: 1234 (private)     |           |   pinCode: 1234 (private)     |
+-------------------------------+           +-------------------------------+
```

## Features
- **Strict Data Encapsulation**: Restricts balance modification and inspection behind private access modifiers and PIN validation.
- **Automated Sequence Generation**: Auto-increments distinct 4-digit wallet identifiers using a static counter.
- **PIN-Protected Transactions**: Guards withdrawals, fund transfers, and balance statement lookups behind 4-digit PIN authentication.
- **Transfer Ceiling Guard**: Enforces a `$2000.00` daily transfer ceiling to defend against fraudulent transactions.
- **Institutional Liquidity Auditing**: Tracks the total money managed across all active wallets via static class fields.
- **Interactive Console Menu**: Delivers an interactive terminal ATM interface for wallet management.

### Project Assignment: Make Project Bank Account
Make a project called `Campus NeoBank and Digital Wallet` that models a secure financial account system with strict encapsulation, PIN validation, and shared institutional metrics.

Specifically, you need to build:
1. `BankAccount.java`: The core wallet account entity class.
   - Private attributes: `balance` (double), `accountNumber` (final int), `owner` (String), and `pinCode` (int).
   - Static class fields: `totalAccounts` (tracking total active wallets), `totalMoneyInBank` (tracking sum of all balances across the institution), and `accountSequence` (starting at 1000 for auto-generating IDs).
   - Constants: `public static final double MIN_OPENING_BALANCE = 50.0;` and `public static final double MAX_TRANSFER_LIMIT = 2000.0;`.
   - Constructor: `BankAccount(owner, initialDeposit, pinCode)` validating that owner name is not empty, initial deposit is at least $50.0, and PIN is a 4-digit number between 1000 and 9999.
   - Member methods: `deposit(double amount)` updating balance and total institutional liquidity; `withdraw(double amount, int enteredPin)` validating PIN, rejecting negative values or overdrafts; `transfer(BankAccount destination, double amount, int enteredPin)` verifying PIN, destination presence, transfer ceilings, and fund sufficiency; and `getBalance(int enteredPin)` protecting statement lookups.
   - Static getters: `getTotalAccounts()` and `getTotalMoneyInBank()`.
2. `BankApp.java`: An interactive console application.
   - Stores up to 20 accounts in a `BankAccount[]` array.
   - Provides a menu with operations to open a new wallet, deposit money, withdraw with PIN, perform peer-to-peer transfers with PIN, check statements, and run an institutional audit displaying platform liquidity.

### What You Need To Do
- [x] Define `BankAccount` with `private double balance`, `private final int accountNumber`, `private String owner`, and `private int pinCode`.
- [x] Configure class constants such as `MIN_OPENING_BALANCE = 50.0` and `MAX_TRANSFER_LIMIT = 2000.0`.
- [x] Implement static fields `totalAccounts`, `totalMoneyInBank`, and automatic sequence incrementation in the constructor.
- [x] Implement transactions `deposit`, `withdraw`, and inter-wallet `transfer` with PIN authentication.
- [x] Provide static accessors `getTotalAccounts()` and `getTotalMoneyInBank()`.
- [x] Implement `BankApp` with an interactive console menu allowing wallets to be opened, debited, credited, and audited.

### Hands-On Practice Challenges
- Challenge 1: Add a 1% promotional cashback deposit bonus whenever a deposit amount exceeds `$500.00`.
- Challenge 2: Implement a method `changePin(int oldPin, int newPin)` that validates the old PIN before updating to a new 4-digit passcode.

## Detailed Project Explanation

### 1. Encapsulation and Data Hiding
Encapsulation prevents direct external manipulation of an object's internal fields:
- If `balance` were declared public, any part of the codebase could alter it directly without passing through business rules.
- By making `balance` private, you guarantee that deposits and withdrawals always pass through validation logic, ensuring balances cannot become negative or corrupted.

### 2. The Static Modifier: Class-Level vs Instance-Level Memory
Java partitions memory between instance variables and static variables:
- **Instance Variables** (`owner`, `balance`): Each `BankAccount` object gets its own private copy stored on the heap. Changing Alice's balance does not affect Bob's balance.
- **Static Variables** (`totalAccounts`, `totalMoneyInBank`): Only a single shared copy exists in class metadata memory. Every instantiated object shares and observes the exact same variable. When a deposit occurs on any account, `totalMoneyInBank` increments globally.

### 3. The Final Keyword and Immutability
Declaring `private final int accountNumber` makes the account number immutable:
- A `final` blank field can only be assigned once, either at declaration or within the constructor.
- Once set during account opening, Java prevents any subsequent code from reassigning or altering the account number, ensuring lifelong identity integrity.

### 4. PIN Security and Invariant Guards
Every critical transaction requires user authentication:
- `withdraw` and `transfer` mandate an `enteredPin` parameter. If `!verifyPin(enteredPin)`, the operation terminates immediately before modifying balances.
- Invariants guard boundaries: deposits must be positive (`amount > 0`), withdrawals cannot exceed balance (`amount <= balance`), and transfers cannot exceed the institutional limit (`amount <= MAX_TRANSFER_LIMIT`).

### 5. Institutional Liquidity Invariant
During an internal fund transfer between Alice and Bob:
- Alice's account decreases by `amount`.
- Bob's account increases by `amount`.
- Notice that `totalMoneyInBank` remains unchanged because the money merely transferred between two vaults inside the same platform. Only external deposits and withdrawals adjust total platform liquidity.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` and `java`
- **Libraries**: `java.util.Scanner`, `java.lang.Math`

## Run Locally

### Prerequisites
- OpenJDK 17 or 21:
  ```bash
  javac -version
  ```

### Installation
Clone the repository and enter the project folder:
```bash
git clone https://github.com/Omar-Ayman-Ali/java-project-roadmap.git
cd java-project-roadmap/projects/06-bank-account
```

### Execution
Compile all classes into a `bin` directory and launch the banking console:
```bash
mkdir -p bin
javac -d bin src/*.java
java -cp bin BankApp
```

## Project Structure
```
06-bank-account/
├── README.md
└── src/
    ├── BankAccount.java
    └── BankApp.java
```

## Hints
- `static` variables belong to the class itself, not to individual instances. Modifying `totalMoneyInBank` updates the single shared value across all objects.
- A `final` field cannot be modified once set. It must be assigned either at its declaration or inside the constructor body.
- When performing a fund transfer, verify that `this != destination` and that the destination reference is not `null`.
- In an internal transfer between two accounts within the same institution, `totalMoneyInBank` remains unchanged because money is neither deposited nor withdrawn from the bank vault.
- Never make fields `public` unless they are explicitly declared `static final` constants.
