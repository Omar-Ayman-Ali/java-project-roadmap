# Student Expense and Currency Suite (Toolchain and Syntax)

**Live Demo:** Not deployed (local execution only)

A beginner-friendly suite of command-line tools practicing terminal compilation, standard I/O streaming, currency exchange, and floating-point precision.

![Language](https://img.shields.io/badge/Language-Java_21-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Course-CIS_201_L01-blue?style=flat-square)
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
This project provides an approachable, real-world introduction to Java programming and terminal development workflows. It grounds fundamental concepts like bytecode compilation, standard input streaming with `Scanner`, and primitive numeric promotion in everyday tasks such as splitting dining checks, exchanging currency, and calculating quiz scores. The programs form the starting point for second-year computer science students mastering the Java Virtual Machine.

## Architecture
The application illustrates how human-readable Java source files are compiled into platform-independent bytecode and interpreted by the Java Virtual Machine:

```
[ Developer Source ]  --> ( javac compiler ) --> [ Bytecode (.class) ] --> ( Java Virtual Machine ) --> [ Console Output ]
  MealSplitter.java                                MealSplitter.class          Execution Engine                Formatted Stream
```

User inputs stream synchronously from the keyboard via `System.in`, get parsed into typed tokens by `java.util.Scanner`, and are stored on the thread stack frame for arithmetic evaluation.

## Features
- **JVM Environment Diagnostics**: Inspects active Java runtime versions, operating system architecture, and allocated heap memory.
- **Real-World Currency Exchange**: Calculates bi-directional conversions between US Dollars, Egyptian Pounds, and Euros with guarded bounds checking.
- **Group Dining Bill Splitter**: Calculates custom tip allocations, grand totals, and fair per-person contributions.
- **Floating-Point Precision Evaluator**: Contrasts integer division truncation against explicit type promotion (`(double) sum / 3.0`).

### Project Assignment: Make Project Student Expense and Currency Suite
Make a project called `Student Expense and Currency Suite` that demonstrates how to write, compile, and execute Java programs directly from the terminal without relying on an IDE.

Specifically, you need to build:
1. `HelloWorld.java`: A diagnostic program that queries the Java runtime environment (`System.getProperty`) and prints the operating system name, JDK version, and maximum heap memory.
2. `CurrencyConverter.java`: A multi-currency conversion utility that prompts the user to select a conversion route (USD to EGP, EGP to USD, or USD to EUR), reads the monetary amount via `Scanner`, and outputs the converted amount with input bounds validation.
3. `MealSplitter.java`: A group dining expense calculator that takes the bill total, tip percentage, and number of people, checks that all values are positive, and computes the tip amount, grand total, and individual payment per diner.
4. `ScoreCalculator.java`: An academic score evaluator that reads three integer quiz scores, demonstrates the difference between integer division truncation and floating-point division, and outputs an academic standing message based on the accurate average.

### What You Need To Do
- [x] Run `HelloWorld.java` using direct terminal commands to inspect your local JVM setup.
- [x] Implement `CurrencyConverter.java` to support multiple currency conversion paths using a `switch` selection structure.
- [x] Implement `MealSplitter.java` to calculate bill splits with validation ensuring diner counts and subtotals remain positive.
- [x] Implement `ScoreCalculator.java` to compute academic quiz averages without losing fractional points to integer division.

### Hands-On Practice Challenges
- Challenge 1: In `CurrencyConverter.java`, add support for British Pounds (GBP) with an exchange rate of `1 USD = 0.77 GBP` and a 1.5% bank transaction fee.
- Challenge 2: In `MealSplitter.java`, add a 14% sales tax parameter calculated prior to tip percentage calculation.
- Challenge 3: In `ScoreCalculator.java`, calculate a weighted grade where Quiz 1 is 20%, Quiz 2 is 30%, and Quiz 3 is 50%.

## Detailed Project Explanation

### 1. The Compilation Pipeline
In Java, your source code file (`.java`) is not directly translated into machine code for your specific processor. Instead, the `javac` compiler converts it into intermediate bytecode (`.class`). When you run `java ClassName`, the Java Virtual Machine (JVM) loads the bytecode, verifies its integrity, and translates it just-in-time into native machine instructions. This two-step process enables Java to run across different operating systems without modifying the source code.

### 2. Standard Input with Scanner
The `Scanner` class from `java.util` breaks standard input streams (`System.in`) into individual tokens:
- `scanner.nextInt()` reads the next available integer token.
- `scanner.nextDouble()` reads floating-point numbers.
- `scanner.hasNextInt()` returns a boolean indicating whether the upcoming token can be parsed as an integer, preventing crashes on invalid input.
- Always close the scanner with `scanner.close()` when your application is done reading input to release the underlying system resource.

### 3. The Integer Division Trap
One of the most common pitfalls for students transitioning to Java is integer division:
- In Java, dividing two integers (`11 / 4`) discards any remainder and returns an integer result (`2`).
- To retain decimal precision, at least one operand must be promoted to a floating-point type: `(double) 11 / 4` or `11.0 / 4`.
- In `ScoreCalculator.java`, calculating `sum / 3` loses fractional marks, whereas `(double) sum / 3.0` ensures the correct mathematical average is preserved.

### 4. Monetary Calculations and Formatting
Floating-point numbers can accumulate minor precision anomalies. When displaying financial figures, use formatted printing via `System.out.printf("%.2f", value)`:
- `%f` denotes a floating-point specifier.
- `.2` instructs the runtime to round and format the output to exactly two decimal places.
- `%n` outputs a platform-independent newline character.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` compiler and `java` application launcher
- **Libraries**: `java.util.Scanner`, `java.lang.System`, `java.lang.Runtime`

## Run Locally

### Prerequisites
- OpenJDK 17 or OpenJDK 21 installed and accessible via command line:
  ```bash
  javac -version
  java -version
  ```

### Installation
Clone the repository and enter the project folder:
```bash
git clone https://github.com/Omar-Ayman-Ali/java-project-roadmap.git
cd java-project-roadmap/projects/01-campus-utility-toolkit
```

### Execution
Compile all source files into a `bin` directory and run any of the utility programs:

```bash
mkdir -p bin
javac -d bin src/*.java

# Run JVM Environment Diagnostic
java -cp bin HelloWorld

# Run Currency Converter
java -cp bin CurrencyConverter

# Run Group Dining Splitter
java -cp bin MealSplitter

# Run Score and Grade Evaluator
java -cp bin ScoreCalculator
```

## Project Structure
```
01-campus-utility-toolkit/
├── README.md
└── src/
    ├── CurrencyConverter.java
    ├── HelloWorld.java
    ├── MealSplitter.java
    └── ScoreCalculator.java
```

## Hints
- The public class name must match the source file name exactly, including capitalization.
- In Java, dividing two integers such as `11 / 4` results in `2` because integer division truncates decimals toward zero.
- To produce a floating-point result, cast at least one operand: `(double) 11 / 4` or use floating-point literals: `11.0 / 4`.
- Use `System.out.printf("%.2f", value)` to format monetary numbers cleanly to two decimal places.
- Always remember to close `Scanner` instances with `scanner.close()` to release standard input streams when input handling is complete.
