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
- [Detailed Project Explanation](#detailed-project-explanation)
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

### Project Assignment: Make Project Array Toolkit
Make a project called `Digital Audio Signal and Waveform Analyzer` that implements a static utility class of fundamental array algorithms and an interactive driver demonstrating array memory semantics.

Specifically, you need to build:
1. `ArrayToolkit.java`: A class containing static utility methods and an illustrative `main` test driver.
2. `max(int[] a)` and `min(int[] a)`: Methods that throw an `IllegalArgumentException` on null or empty input and return the highest and lowest integer values respectively.
3. `average(int[] a)`: Computes the arithmetic mean as a floating-point `double`, preventing integer truncation.
4. `reverse(int[] a)`: Allocates and returns a fresh array containing elements in reverse order without mutating the input array.
5. `indexOf(int[] a, int target)`: Performs a linear search and returns the first matching index, or -1 if the target is absent.
6. `copy(int[] a)`: Allocates a new array on the heap of identical size and copies each element, creating an independent clone.
7. `bubbleSort(int[] a)`: Sorts the array in-place using adjacent element swaps, featuring an early-exit `swapped` boolean flag to stop once the array is ordered.
8. `renderWaveform(String label, int[] samples)`: Iterates through the sample array and prints ASCII bar charts (`#`) proportional to the magnitude of each sample.
9. A demonstration driver in `main` that proves:
   - Assigning `b = a` copies only the pointer reference (mutating `b` alters `a`).
   - Using `copy(a)` allocates isolated heap memory (mutating the copy does not alter `a`).
   - Default initialization produces zeroes for `int[]`, `false` for `boolean[]`, and `null` for `String[]`.

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

## Detailed Project Explanation

### 1. Memory Architecture: Stack References vs Heap Objects
In Java, variables declared inside methods reside on the method's stack frame, while all objects, including arrays, live on the heap:
- An array variable like `int[] numbers` does not store the array elements directly on the stack.
- Instead, `numbers` holds a 64-bit reference address pointing to the memory block on the heap where the elements are stored.

### 2. The Reference Aliasing Hazard
Because array variables are merely references:
```java
int[] original = {10, 20, 30};
int[] alias = original; // Only copies the memory address!
alias[0] = 999;
System.out.println(original[0]); // Prints 999!
```
Both `alias` and `original` point to the exact same heap memory block. This is called aliasing. If one part of your program alters the array through an alias, every other reference observing that array sees the mutation.

### 3. Deep Copying for Data Isolation
To safely process or sort data without corrupting the original recording, you must perform a deep copy:
```java
int[] clone = new int[original.length];
for (int i = 0; i < original.length; i++) {
    clone[i] = original[i];
}
```
The `new` keyword reserves a separate block of memory on the heap. Now, modifying `clone` has zero side effects on `original`.

### 4. Bubble Sort Mechanics
Bubble sort works by repeatedly swapping adjacent elements that are out of order:
- On each outer pass `i`, the largest unsorted element "bubbles up" to its correct position at the end of the array.
- The inner loop compares `a[j]` and `a[j + 1]`. If `a[j] > a[j + 1]`, they are swapped using a temporary storage variable.
- An optimization flag `boolean swapped` tracks whether any elements moved during a pass. If an entire pass completes with zero swaps, the array is already sorted, and the algorithm can terminate early via `break`.

### 5. Java Default Memory Initialization
Unlike C or C++, Java guarantees zero-initialization for all heap allocations:
- Primitive numeric arrays (`byte[]`, `int[]`, `double[]`) are initialized with `0` or `0.0`.
- Boolean arrays (`boolean[]`) are initialized with `false`.
- Object and reference arrays (`String[]`, `Student[]`) are initialized with `null`.

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
