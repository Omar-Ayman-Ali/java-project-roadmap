# Menu-Driven Gradebook (Fixed Array Management)

**Live Demo:** Not deployed (local execution only)

A menu-driven console application managing student grade records using fixed-size primitive arrays and multi-way branch selection.

![Language](https://img.shields.io/badge/Language-Java_21-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Course-CIS_201_L02-blue?style=flat-square)
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
This project implements a command-line student gradebook based on Lecture 2 syntax concepts. It explores fixed-size array management by maintaining an explicit logical element count distinct from array capacity. The system utilizes `switch` statements for command routing and chained `if-else` branches for grading boundary evaluation.

## Architecture
The system decouples maximum storage allocation from the active element count:
- **Storage Allocation**: Fixed array of size 30 (`double[30]`) initialized on the heap.
- **Logical Count**: Independent integer tracker incremented upon each validated insertion.
- **Dispatch Loop**: Evaluates user input through a `switch` statement with explicit break targets.

```
+-----------------------------------------------------------+
| Gradebook Heap Layout: double[30]                         |
|                                                           |
| Index:    [ 0 ]   [ 1 ]   [ 2 ] ... [count-1] [count] ... |
| Value:    [88.5]  [92.0]  [74.0]     [65.0]    [0.0]  ... |
| Status:   <------ Active Data ------>         <-- Empty ->|
+-----------------------------------------------------------+
```

## Features
- **Menu-Driven Dispatch**: Routes program flow using `switch` cases on integer tokens.
- **Bounded Capacity Guard**: Enforces an upper limit of 30 records, rejecting overflow inputs gracefully.
- **Aggregate Statistics**: Computes sample size, arithmetic mean, minimum, and maximum values across active records.
- **Grade Classification**: Maps continuous numeric scores to standard letter grades (`A`, `B`, `C`, `D`, `F`).
- **Hybrid Traversal**: Leverages indexed `for` loops for indexed listings and enhanced `for` (foreach) loops for read-only aggregation.

### What You Need To Do
- [x] Construct an interactive menu loop with options for adding marks, listing entries, calculating statistics, showing grades, and exiting.
- [x] Allocate a `double[]` array of length 30 and maintain an independent integer counter tracking stored elements.
- [x] Protect against array overflow by rejecting entries beyond index 29.
- [x] Implement numerical aggregation routines calculating average, highest mark, and lowest mark.
- [x] Use chained `if-else if` constructs to map numerical score intervals to letter grades.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` and `java`
- **Libraries**: `java.util.Scanner`

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
cd java-project-roadmap/projects/03-menu-gradebook
```

### Execution
Compile the source file into a `bin` directory and run the application:
```bash
mkdir -p bin
javac -d bin src/Gradebook.java
java -cp bin Gradebook
```

## Project Structure
```
03-menu-gradebook/
├── README.md
└── src/
    └── Gradebook.java
```

## Hints
- `switch` works only on discrete primitive integers, characters, strings, and enums; it cannot evaluate numeric intervals like `mark >= 90.0`.
- Always remember the `break` statement at the conclusion of each `switch` case block to prevent unintended fall-through.
- An array created with `new double[30]` has all 30 elements default-initialized to `0.0` in Java.
- Keep track of the current number of entered marks in a separate variable (e.g. `count`) so you do not process empty array slots.
- Use enhanced `for` loops (`for (double mark : marks)`) strictly for reading data, because foreach does not provide write access to array indices.
