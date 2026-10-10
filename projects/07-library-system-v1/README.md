# Library System v1 (Multi-Package Architecture and Lending Hub)

**Live Demo:** Not deployed (local execution only)

A modular university lending hub practicing Unified Modeling Language specification, multi-package namespace partitioning, and cross-package encapsulation.

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
This project synthesizes object-oriented design and package mechanics from Lecture 2 into an architectural multi-package resource lending system. It visualizes class structures, visibility boundaries, and entity associations using Unified Modeling Language (UML) specifications prior to code synthesis. The system demonstrates public Application Programming Interface exposure while defending package-internal state from external corruption.

## Architecture
The application organizes codebase concerns across three distinct packages:
- **`library.model`**: Core domain entities (`Book`, `Member`) storing identities, titles, and borrow states.
- **`library.service`**: The `Library` coordinator managing catalog arrays, member rosters, and circulation rules.
- **`library.app`**: The `Main` console driver executing user workflows across package boundaries.

```
library.app
    |
    v (imports and invokes)
library.service.Library
    |
    +---> aggregates 0..50 library.model.Book
    +---> aggregates 0..20 library.model.Member
                             |
                             +---> borrows 0..3 library.model.Book
```

The system architectural contract is documented in [`uml.md`](uml.md).

## Features
- **UML-First Specification**: Visualizes attributes, operations, access markers, and association relationships before coding.
- **Package Encapsulation**: Partitions domain models, service coordinates, and execution interfaces across distinct directories.
- **Catalog Indexing**: Supports item cataloging, availability status tracking, and duplicate ISBN detection.
- **Quota Enforced Circulation**: Enforces a strict maximum borrowing quota of 3 items per member.
- **Array Contiguity Compaction**: Shifts array elements sequentially upon book return to eliminate empty interior null gaps.
- **Interactive Lending Desk**: Delivers a full CLI menu for librarians to register members, add books, and process loans.

### What You Need To Do
- [x] Author `uml.md` documenting class diagrams with three compartments, visibility notation (`+`, `-`), and relationships.
- [x] Structure the codebase into `library.model`, `library.service`, and `library.app` packages.
- [x] Implement `Book` with ISBN, title, author, and checkout availability state.
- [x] Implement `Member` with member ID, name, fixed-size borrowed books array, and quota verification.
- [x] Implement `Library` providing centralized book addition, member enrollment, checkout, and checkin routines.
- [x] Implement `Main` providing a command-line menu interface to test cross-package integration.

### Hands-On Practice Challenges
- Challenge 1: Implement a `searchByTitle(String keyword)` method in `Library.java` that returns all catalog items containing a matching title substring.
- Challenge 2: Add a checkout duration counter to `Book.java` that tracks how many consecutive days an item has been loaned out.

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
cd java-project-roadmap/projects/07-library-system-v1
```

### Execution
Compile all package sources into a shared `bin` directory and launch the application:
```bash
mkdir -p bin
javac -d bin $(find src -name "*.java")
java -cp bin library.app.Main
```

## Project Structure
```
07-library-system-v1/
├── README.md
├── uml.md
└── src/
    └── library/
        ├── app/
        │   └── Main.java
        ├── model/
        │   ├── Book.java
        │   └── Member.java
        └── service/
            └── Library.java
```

## Hints
- Classes residing in different packages must be declared `public` and imported explicitly (`import library.model.Book;`).
- Package declarations must appear as the very first non-comment statement in each file (e.g., `package library.model;`).
- When compiling multi-package projects from the command line, use `javac -d bin $(find src -name "*.java")` to ensure dependencies resolve in one compiler pass.
- To execute a class within a package, specify its fully qualified name: `java -cp bin library.app.Main`.
- When an item is removed from a fixed array, shift subsequent elements leftward and set the trailing slot to `null` to avoid memory leaks.
