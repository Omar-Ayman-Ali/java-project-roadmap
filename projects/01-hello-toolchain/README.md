# Hello Toolchain (Student Utility and Expense Suite)

**Live Demo:** Not deployed (local execution only)

A beginner-friendly suite of command-line tools practicing terminal compilation, standard I/O streaming, currency exchange, and floating-point precision.

![Language](https://img.shields.io/badge/Language-Java_21-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Course-CIS_201_L01-blue?style=flat-square)
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

### What You Need To Do
- [x] Run `HelloWorld.java` using direct terminal commands to inspect your local JVM setup.
- [x] Implement `CurrencyConverter.java` to support multiple currency conversion paths using a `switch` selection structure.
- [x] Implement `MealSplitter.java` to calculate bill splits with validation ensuring diner counts and subtotals remain positive.
- [x] Implement `ScoreCalculator.java` to compute academic quiz averages without losing fractional points to integer division.

### Hands-On Practice Challenges
- Challenge 1: In `CurrencyConverter.java`, add support for British Pounds (GBP) with an exchange rate of `1 USD = 0.77 GBP` and a 1.5% bank transaction fee.
- Challenge 2: In `MealSplitter.java`, add a 14% sales tax parameter calculated prior to tip percentage calculation.
- Challenge 3: In `ScoreCalculator.java`, calculate a weighted grade where Quiz 1 is 20%, Quiz 2 is 30%, and Quiz 3 is 50%.

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
cd java-project-roadmap/projects/01-hello-toolchain
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
01-hello-toolchain/
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
