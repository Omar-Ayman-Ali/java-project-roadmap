# Array Toolkit (Digital Audio and Signal Analyzer)

**Live Demo:** Not deployed (local execution only)

A utility library modeling digital audio waveform processing to demonstrate array reference semantics, deep cloning, boundary searches, and in-place sorting.

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
This project models digital audio signal processing to provide an intuitive, practical exploration of Java array mechanics from Lecture 2. It implements foundational algorithms for peak amplitude detection, noise floor calculation, waveform time inversion, deep memory cloning, and bubble sort ordering. The test driver features an ASCII waveform visualizer and showcases memory differences between reference aliasing and heap allocations.

## Architecture
Arrays in Java are reference types allocated on the garbage-collected heap and manipulated via stack frame addresses:

```
Stack Frame (main method)             Heap Allocation
+-------------------------+           +-------------------------------+
| rawAudioSignal (ref)    | --------> | [ 42, 17, 89, 5, 23, 68, 12 ] |
+-------------------------+           +-------------------------------+
| alias (ref)             | -----------^  (Direct pointer sharing)
+-------------------------+
| cleanBackup (ref)       | --------> +-------------------------------+
+-------------------------+           | [ 42, 17, 89, 5, 23, 68, 12 ] | (Isolated memory clone)
                                      +-------------------------------+
```

When an array reference is assigned (`alias = rawAudioSignal`), only the pointer address is copied. Modifying data via an alias mutates the shared heap object. Creating a protected copy requires allocating fresh heap space and duplicating elements individually.

## Features
- **Peak and Floor Detection**: Identifies maximum and minimum amplitude values across digital sample buffers.
- **Signal Baseline Computation**: Calculates arithmetic mean signal intensity with floating-point precision.
- **Waveform Inversion**: Inverts signal order to produce a new, time-reversed audio buffer without altering raw input.
- **Frequency Target Search**: Scans buffers for target signal levels and returns the matching index or -1 if absent.
- **Deep Heap Cloning**: Creates isolated heap duplicates of primitive array buffers to safeguard raw recordings.
- **In-Place Bubble Sort**: Orders sound frequencies ascendingly with an early-termination optimization flag.
- **ASCII Waveform Visualizer**: Renders sound amplitude levels as graphical console bar charts.

### What You Need To Do
- [x] Implement static routines `max`, `min`, and `average` for non-empty integer arrays.
- [x] Implement `reverse` returning an independent inverted array instance.
- [x] Implement `indexOf` returning the first matching element index or -1.
- [x] Implement `copy` to construct an isolated deep copy of an array.
- [x] Implement an in-place `bubbleSort` routine.
- [x] Create a `main` execution driver demonstrating reference aliasing side effects versus deep copying.

### Hands-On Practice Challenges
- Challenge 1: Implement a `normalize(int[] a, int maxLimit)` method that scales all sample levels proportionally so the peak amplitude matches a target ceiling.
- Challenge 2: Implement a `countPeaks(int[] a, int threshold)` method that counts how many samples exceed a given noise threshold.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` and `java`
- **Libraries**: `java.util.Arrays`, `java.lang.Math`

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
- Assigning `b = a` copies only the memory reference; modifying `b[0]` modifies `a[0]` as they share the same heap object.
- To create a true independent clone, allocate a new array (`new int[a.length]`) and duplicate values element by element.
- When reversing an array, map each target index `i` to the source index `a.length - 1 - i`.
- By default, uninitialized Java primitive integer arrays fill with `0`, boolean arrays fill with `false`, and reference arrays like `String[]` fill with `null`.
- In bubble sort, use a boolean `swapped` flag per outer pass to exit early once the array is completely sorted.
