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
- [Detailed Project Explanation](#detailed-project-explanation)
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

### Project Assignment: Make Project Menu Gradebook
Make a project called `Academic Transcript and Honors Portal` that manages up to 30 course records in memory using parallel arrays and an interactive menu.

Specifically, you need to build:
1. `Gradebook.java`: The primary application class containing the interactive console loop.
2. Parallel array allocation: Allocate `String[] courseNames = new String[30]` and `double[] grades = new double[30]` on the heap.
3. Logical count tracker: Maintain an integer variable `int count = 0` that increments each time a valid course is recorded, keeping track of active items separately from the array length of 30.
4. Menu dispatch using `switch`: Provide options for:
   - Option 1: Add a new course name and numerical score (with bounds validation 0.0 to 100.0).
   - Option 2: Display the formatted transcript of all enrolled courses.
   - Option 3: Compute aggregate statistics (average score, highest score, lowest score, and pass rate percentage).
   - Option 4: Convert numerical marks to letter grades (A, B, C, D, F) with collegiate academic standing descriptions.
   - Option 5: Filter and display only courses where the score is at or above 50.0.
   - Option 0: Terminate the application gracefully.
5. Capacity overflow guard: Verify `count < 30` before accepting new records, alerting the user politely if the transcript capacity is full.
6. Range evaluation with `if-else if`: Use chained conditional branches for score boundaries (A >= 90, B >= 80, C >= 70, D >= 60, F < 60).

### What You Need To Do
- [x] Create an interactive menu loop offering options to add grades, view transcripts, inspect statistics, display honors, filter passing courses, and exit.
- [x] Allocate fixed-size arrays for course names and scores with a capacity of 30, tracking active records with a separate integer variable.
- [x] Protect against array overflow by checking capacity limits prior to appending new records.
- [x] Compute average, maximum, and minimum scores using array traversal loops.
- [x] Map continuous numeric ranges to letter grades using chained `if-else if` statements.

### Hands-On Practice Challenges
- Challenge 1: Introduce credit hours per course (e.g., 3 or 4 credits) and calculate a weighted grade point average.
- Challenge 2: Implement a search feature that prompts for a course title keyword and prints matching course entries.

## Detailed Project Explanation

### 1. Fixed-Size Arrays and Memory Pre-Allocation
In Java, arrays are fixed-length containers created on the heap. When you write `new double[30]`, Java allocates contiguous memory for exactly 30 double-precision numbers, each pre-initialized to `0.0`. You cannot dynamically shrink or expand this array at runtime.

### 2. Logical Count vs Physical Capacity
Because all 30 array slots exist immediately upon allocation, you must never rely solely on `grades.length` when computing averages or listing records. If a student has completed only 3 courses, reading all 30 elements would factor 27 unused zero-marks into the calculations, heavily distorting the average. Maintaining an independent integer variable `count` ensures your program traverses strictly the active, populated slice of data (`i < count`).

### 3. Command Routing with Switch
The `switch` statement provides clean, multi-way branch selection based on a single discrete variable (such as an `int` menu choice):
- Each option is enclosed in a `case` label.
- Every `case` block must conclude with a `break;` statement. Omitting `break` triggers fall-through, executing subsequent case blocks unintentionally.
- The `default:` block catches any unrecognized numbers typed by the user, providing a resilient fallback.

### 4. Continuous Range Categorization with If-Else
While `switch` is ideal for discrete numbers, it cannot evaluate range conditions like `score >= 90.0`. Chaining `if ... else if ... else` statements allows you to test ordered intervals from highest to lowest:
```java
if (g >= 90.0) {
    letter = 'A';
} else if (g >= 80.0) {
    letter = 'B';
} else if (g >= 70.0) {
    letter = 'C';
} else if (g >= 60.0) {
} else {
    letter = 'F';
}
```
Because the conditions execute sequentially, once a match is found, all subsequent `else if` checks are skipped.

### 5. Indexed For vs Enhanced For (Foreach)
- Use indexed `for (int i = 0; i < count; i++)` when you need the index number (e.g., printing `Course #1`, `Course #2`), or when coordinating between parallel arrays (`courseNames[i]` and `grades[i]`).
- Use enhanced `for (double g : activeGrades)` when reading data sequentially without needing to modify values or track indices.

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
