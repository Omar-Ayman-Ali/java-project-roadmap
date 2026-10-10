# Menu-Driven Gradebook (Academic Transcript and Honors Portal)

**Live Demo:** Not deployed (local execution only)

A menu-driven academic transcript portal managing course grades, honors classification, and aggregate performance statistics using fixed arrays and switch selection.

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
This project implements an interactive student academic record and honors classification system based on Lecture 2 syntax concepts. It models fixed-capacity storage using parallel arrays (`double[]` and `String[]`) while managing active record counts independently from physical array capacities. The system demonstrates command routing via `switch` statements and continuous score mapping through chained `if-else` blocks.

## Architecture
The application separates total allocated array capacity from active enrollment counts:
- **Parallel Heap Arrays**: Allocates `String[30]` for course identifiers and `double[30]` for score records.
- **Active Record Counter**: An integer pointer tracking the exact count of entered courses.
- **Menu Dispatch Engine**: A central `switch` loop routing user operations to distinct business logic blocks.

```
+---------------------------------------------------------------+
| Gradebook Heap Layout: Parallel Arrays (Capacity = 30)        |
|                                                               |
| Course Names: [ "Intro to Prog", "Discrete Math", null, ... ] |
| Course Scores: [     92.5      ,      78.0      ,  0.0, ... ] |
| Index:         [       0       ,        1       ,   2 , ... ] |
|                                                               |
| Status:        <------ Active Data (count=2) ----> <-- Free ->|
+---------------------------------------------------------------+
```

## Features
- **Interactive Menu Dispatch**: Navigates six operational modes using `switch` cases with complete break isolation.
- **Parallel Array Coordination**: Synchronizes course names and numerical marks across shared index locations.
- **Aggregate Performance Metrics**: Computes sample size, cumulative class average, highest score, lowest score, and pass rate percentage.
- **Honors Classification**: Converts continuous percentages into letter grades (`A`, `B`, `C`, `D`, `F`) and descriptive academic standings.
- **Selective Criteria Filtering**: Isolates passing marks (score >= 50.0) from remedial course records.

### What You Need To Do
- [x] Create an interactive menu loop offering options to add grades, view transcripts, inspect statistics, display honors, filter passing courses, and exit.
- [x] Allocate fixed-size arrays for course names and scores with a capacity of 30, tracking active records with a separate integer variable.
- [x] Protect against array overflow by checking capacity limits prior to appending new records.
- [x] Compute average, maximum, and minimum scores using array traversal loops.
- [x] Map continuous numeric ranges to letter grades using chained `if-else if` statements.

### Hands-On Practice Challenges
- Challenge 1: Introduce credit hours per course (e.g., 3 or 4 credits) and calculate a weighted grade point average.
- Challenge 2: Implement a search feature that prompts for a course title keyword and prints matching course entries.

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
Clone the repository and enter the project folder:
```bash
git clone https://github.com/Omar-Ayman-Ali/java-project-roadmap.git
cd java-project-roadmap/projects/03-menu-gradebook
```

### Execution
Compile the source file into a `bin` directory and run the transcript portal:
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
- `switch` operates on discrete values (`int`, `char`, `String`), so score intervals like `score >= 90.0` must be handled using `if-else if` chains.
- Be sure to place a `break;` at the end of each `switch` case branch to prevent fall-through bugs into subsequent cases.
- An array created with `new double[30]` has all entries initialized to `0.0` by default.
- Keep track of the active course count in an independent variable like `count` so empty slots are never factored into averages.
- When alternating between `scanner.nextInt()` and `scanner.nextLine()`, call `scanner.nextLine()` once to discard the leftover newline character.
