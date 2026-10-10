# Hello Toolchain (CLI Utility Suite)

**Live Demo:** Not deployed (local execution only)

A suite of console programs practicing source-to-bytecode compilation, standard stream I/O, and primitive type arithmetic.

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
This project establishes fundamental mastery over the Java command-line developer workflow, contrasting compiler bytecode generation against Java Virtual Machine execution. It implements foundational procedural routines to handle terminal interaction, user input parsing via `Scanner`, and arithmetic evaluation. The implementation serves as the entry point for the Ain Shams University CIS 201 curriculum.

## Architecture
Java source files (`.java`) are compiled by `javac` into architecture-neutral bytecode (`.class`). The platform-specific Java Virtual Machine (JVM) interprets and executes this bytecode at runtime:

```
[ Developer Source ]  --> ( javac compiler ) --> [ Bytecode (.class) ] --> ( Java Virtual Machine ) --> [ System Output ]
  HelloWorld.java                                  HelloWorld.class            Execution Runtime               Console Stream
```

User input flows synchronously from standard input (`System.in`) through `java.util.Scanner` tokenizers into primitive memory variables on the thread stack.

## Features
- **Bytecode Verification**: Verifies JVM entry point execution and class loading.
- **Arithmetic Processing**: Reads integer pairs and computes sum, difference, product, and integer quotient.
- **Financial Calculation**: Computes bill tip allocations and total payable balances using floating-point precision.
- **Type Promotion Safeguards**: Demonstrates integer division truncation resolution via explicit type casting.

### What You Need To Do
- [x] Compile and execute `HelloWorld.java` using the terminal toolchain without IDE automation.
- [x] Implement `SimpleCalculator.java` to read two integers and display arithmetic operations with zero-division validation.
- [x] Implement `TipCalculator.java` to compute custom tip percentages and total cost with formatted currency output.
- [x] Implement `AverageOfThree.java` to parse three integers and calculate accurate decimal averages using floating-point casting.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` compiler and `java` launcher
- **Libraries**: `java.util.Scanner`, `java.lang.System`

## Run Locally

### Prerequisites
- OpenJDK 17 or OpenJDK 21 installed and accessible in the system path:
  ```bash
  javac -version
  java -version
  ```

### Installation
Clone the repository and navigate to the project directory:
```bash
git clone https://github.com/Omar-Ayman-Ali/java-project-roadmap.git
cd java-project-roadmap/projects/01-hello-toolchain
```

### Execution
Compile all source files into a `bin` directory and run any of the programs:

```bash
mkdir -p bin
javac -d bin src/*.java

# Run Hello World
java -cp bin HelloWorld

# Run Simple Calculator
java -cp bin SimpleCalculator

# Run Tip Calculator
java -cp bin TipCalculator

# Run Average of Three
java -cp bin AverageOfThree
```

## Project Structure
```
01-hello-toolchain/
├── README.md
└── src/
    ├── AverageOfThree.java
    ├── HelloWorld.java
    ├── SimpleCalculator.java
    └── TipCalculator.java
```

## Hints
- The public class name must match the source file name exactly, including letter case.
- The standard entry signature requires `public static void main(String[] args)`.
- When dividing two integers like `sum / 3`, Java performs integer division and discards any fractional part.
- Cast at least one operand to a floating-point type prior to division, e.g. `(double) sum / 3.0`, to retain decimal precision.
- Always close the `Scanner` resource when input streaming finishes to avoid resource leaks.
