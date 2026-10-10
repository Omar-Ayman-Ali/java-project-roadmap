# Bank Account (Encapsulation and Static State Management)

**Live Demo:** Not deployed (local execution only)

A secure banking application enforcing object encapsulation, validation guards, immutable account numbers, and institutional static metrics.

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
This project implements an encapsulated banking system grounded in object-oriented principles from Lectures 1 and 2. It restricts direct attribute access through private fields and enforces transaction invariants during deposits, withdrawals, and account-to-account transfers. Class-level static state maintains institutional accountability by aggregating global account counts and circulating currency.

## Architecture
State is bifurcated between per-instance heap allocations and class-level metaspace memory:
- **Instance Variables (`balance`, `accountNumber`, `owner`)**: Unique to each instantiated account. `accountNumber` is marked `final` to ensure immutability post-instantiation.
- **Static Class Variables (`totalAccounts`, `totalMoneyInBank`, `accountSequence`)**: Shared globally across all account instances to generate unique identifiers and monitor bank liquidity.

```
+-------------------------------------------------------------------+
| Metaspace / Class Static Area: BankAccount                        |
|   totalAccounts: 2                                                |
|   totalMoneyInBank: $1700.00                                      |
|   accountSequence: 1002                                           |
+-------------------------------------------------------------------+
         ^                                           ^
         | shared static access                      | shared static access
+-------------------------------+           +-------------------------------+
| Heap Object: BankAccount      |           | Heap Object: BankAccount      |
|   accountNumber: 1001 (final) |           |   accountNumber: 1002 (final) |
|   owner: "Alice Smith"        |           |   owner: "Bob Johnson"        |
|   balance: $500.00 (private)  |           |   balance: $1200.00 (private) |
+-------------------------------+           +-------------------------------+
```

## Features
- **Strict Data Hiding**: Prevents unauthorized balance tampering by marking financial fields `private`.
- **Automated Identifier Generation**: Auto-increments unique integer account numbers using a static sequence tracker.
- **Transaction Invariant Guards**: Rejects negative transfers and defends against overdraft attempts.
- **Inter-Account Transfers**: Atomically decreases the source balance and increases the destination balance.
- **Institutional Liquidity Auditing**: Tracks the total money managed across all active accounts via static class members.
- **Interactive Console Menu**: Provides an operational CLI interface for account lifecycle management.

### What You Need To Do
- [x] Define `BankAccount` with `private double balance`, `private final int accountNumber`, and `private String owner`.
- [x] Configure class constants such as `public static final double MIN_OPENING_BALANCE = 100.0`.
- [x] Implement static fields `totalAccounts`, `totalMoneyInBank`, and automatic sequence incrementation in the constructor.
- [x] Implement transaction methods `deposit`, `withdraw`, and inter-account `transfer` with comprehensive guard validation.
- [x] Provide static accessors `getTotalAccounts()` and `getTotalMoneyInBank()`.
- [x] Implement `BankApp` with a console menu allowing accounts to be opened, searched, debited, credited, and audited.

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
Clone the repository and enter the project directory:
```bash
git clone https://github.com/Omar-Ayman-Ali/java-project-roadmap.git
cd java-project-roadmap/projects/06-bank-account
```

### Execution
Compile all classes into a `bin` directory and launch the interactive bank manager:
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
