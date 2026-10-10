# Array Toolkit (Memory and Reference Operations)

**Live Demo:** Not deployed (local execution only)

A utility library demonstrating Java array reference semantics, deep cloning, boundary searches, and in-place sorting.

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
This project implements a foundational static utility toolkit exploring array data structure mechanics in Java. It provides essential algorithms for extremum detection, linear search, inversion, deep duplication, and bubble sort ordering. The driver illustrates the distinction between reference aliasing and heap memory cloning.

## Architecture
Arrays in Java are first-class heap objects manipulated through reference variables located on the method stack frame.

```
Stack Frame (main)                    Heap Memory
+-----------------------+             +-------------------------------+
| sample  (reference)   | ----------> | [ 42, 17, 89, 5, 23, 68, 12 ] |
+-----------------------+             +-------------------------------+
| alias   (reference)   | -------------^  (Points to identical heap object)
+-----------------------+
| cloned  (reference)   | ----------> +-------------------------------+
+-----------------------+             | [ 42, 17, 89, 5, 23, 68, 12 ] | (Independent allocation)
                                      +-------------------------------+
```

When one array variable is assigned to another (`alias = sample`), only the pointer address is duplicated. Generating a separate instance requires allocating a new heap array (`copy(sample)`) and duplicating each element sequentially.

## Features
- **Extremum Detection**: Identifies maximum and minimum elements across integer sequences.
- **Statistical Computation**: Computes exact floating-point arithmetic means.
- **Pure Array Reversal**: Constructs and returns a new inverted array without mutating input operands.
- **Linear Search**: Scans for target elements and returns zero-based indices or -1 on absence.
- **Deep Memory Cloning**: Duplicates array contents into distinct heap allocations.
- **Bubble Sort Ordering**: Sorts arrays in-place in ascending order with early-termination optimization.
- **Default Value Audit**: Demonstrates Java runtime default initialization for primitive types and object reference arrays.

### What You Need To Do
- [x] Implement static routines `max`, `min`, and `average` for non-empty integer arrays.
- [x] Implement `reverse` returning an independent inverted array instance.
- [x] Implement `indexOf` returning the first matching element index or -1.
- [x] Implement `copy` to construct an isolated deep copy of an array.
- [x] Implement an in-place `bubbleSort` routine.
- [x] Create a `main` execution driver demonstrating reference aliasing side effects versus deep copying.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` and `java`
- **Libraries**: `java.util.Arrays` (for test diagnostic output)

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
cd java-project-roadmap/projects/04-array-toolkit
```

### Execution
Compile the utility class and run the demonstration test suite:
```bash
mkdir -p bin
javac -d bin src/ArrayToolkit.java
java -cp bin ArrayToolkit
```

## Project Structure
```
04-array-toolkit/
├── README.md
└── src/
    └── ArrayToolkit.java
```

## Hints
- Assigning `b = a` creates an alias pointing to the same array object in heap memory; modifying `b[0]` modifies `a[0]`.
- To create a true independent copy, allocate a new array (`new int[a.length]`) and copy elements individually or via system arraycopy.
- `reverse` should create a new array whose index `i` maps to `a[a.length - 1 - i]`.
- Default values upon heap allocation: numeric primitives default to `0` or `0.0`, boolean arrays default to `false`, and reference types like `String[]` default to `null`.
- In bubble sort, track a `swapped` boolean flag per pass to break early if no elements were exchanged.
