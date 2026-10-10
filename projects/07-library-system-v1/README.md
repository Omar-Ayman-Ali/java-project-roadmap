# Library System v1 (Multi-Package Architecture and UML Design)

**Live Demo:** Not deployed (local execution only)

A modular library management system practicing UML class modeling, multi-package namespace partitioning, and visibility boundaries.

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
This project synthesizes object-oriented design and package mechanics from Lecture 2 into a cohesive multi-package system. It models domain entities and coordinating services through Unified Modeling Language (UML) specifications prior to code implementation. The system demonstrates access modifier boundaries between package-internal logic and public consumer interfaces.

## Architecture
The application organizes functionality into three distinct packages:
- **`library.model`**: Contains core domain objects (`Book`, `Member`) encapsulating identity and internal states.
- **`library.service`**: Contains the `Library` coordinator managing catalog arrays, member registries, and transaction operations.
- **`library.app`**: Houses the console CLI entry point (`Main`), consuming services across package boundaries.

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

The system architectural contract is visualized in [`uml.md`](uml.md).

## Features
- **UML-First Specification**: Defines attributes, behaviors, visibility markers, and associations before code synthesis.
- **Package Encapsulation**: Isolates data models, services, and execution interfaces across distinct namespaces.
- **Catalog Management**: Supports book indexing, availability tracking, and duplicate ISBN detection.
- **Member Registry**: Enforces per-member borrowing quotas (maximum 3 books) and maintains individual borrow records.
- **Circulation Lifecycle**: Handles checkout and return transactions with state synchronization across book and member instances.
- **Array Contiguity Compaction**: Compacts member borrow arrays upon returns to maintain dense sequential memory.

### What You Need To Do
- [x] Author `uml.md` documenting class diagrams with three compartments, visibility notation (`+`, `-`), and relationships.
- [x] Structure the codebase into `library.model`, `library.service`, and `library.app` packages.
- [x] Implement `Book` with ISBN, title, author, and checkout availability state.
- [x] Implement `Member` with member ID, name, fixed-size borrowed books array, and quota verification.
- [x] Implement `Library` providing centralized book addition, member enrollment, checkout, and checkin routines.
- [x] Implement `Main` providing a command-line menu interface to test cross-package integration.

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
cd java-project-roadmap/projects/07-library-system-v1
```

### Execution
Compile all packages into a shared `bin` directory and execute the main application:
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
