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
