# Student Registry (Academic Advising and Standing System)

**Live Demo:** Not deployed (local execution only)

An object-oriented student registry modeling collegiate academic records, constructor overloading delegation, and sparse array null-safety.

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
This project models a collegiate academic advising registry grounded in Object-Oriented Programming principles from Lecture 2. It demonstrates class blueprint mechanics, field encapsulation, overloaded constructor chaining, and object instance state mutations. The system maintains student records within fixed-capacity reference arrays while implementing defensive checks to eliminate `NullPointerException` runtime errors.

## Architecture
The system consists of two collaborating classes:
- **`Student` (Entity Blueprint)**: Encapsulates individual student state (`id`, `name`, `major`, `gpa`, `creditsEarned`), constructor chaining, and academic standing classification.
- **`StudentRegistry` (Coordinator)**: Maintains an array of `Student` object references (`Student[]`), managing enrollment capacity, identification lookup, and standing filters.

```
+------------------------------------+        holds references       +-----------------------------------------------+
|          StudentRegistry           | ----------------------------> |                    Student                    |
+------------------------------------+  1                      0..N  +-----------------------------------------------+
| - students: Student[]              |                               | - id: int                                     |
| - count: int                       |                               | - name: String                                |
+------------------------------------+                               | - major: String                               |
| + addStudent(s: Student): boolean  |                               | - gpa: double                                 |
| + findById(id: int): Student       |                               | - creditsEarned: int                           |
| + filterByMajor(query: String)     |                               +-----------------------------------------------+
| + getTopStudent(): Student         |                               | + Student(name, id)                           |
| + listAll(): void                  |                               | + Student(name, id, major, gpa, credits)      |
+------------------------------------+                               | + updateGpa(newGpa: double): void             |
                                                                     | + getAcademicStanding(): String               |
                                                                     +-----------------------------------------------+
```

## Features
- **Constructor Overloading**: Provides 2-argument and 5-argument constructor variants to accommodate different student enrollment workflows.
- **Constructor Delegation**: Reuses initialization logic through `this(...)` to guarantee invariant consistency.
- **Academic Standing Classification**: Maps continuous GPA metrics into descriptive collegiate categories (`Dean's List`, `Good Standing`, `Academic Probation`).
- **Linear ID Search**: Queries registered student references by integer ID in linear time.
- **Major Filtering**: Filters and outputs all student records enrolled in a specific degree major.
- **Highest GPA Discovery**: Identifies the valedictorian across registered cohort members.
- **Sparse Array Null-Safety**: Demonstrates defensive reference checking to prevent runtime `NullPointerException` failures.

### What You Need To Do
- [x] Create the `Student` entity class with fields for ID, name, major, GPA, and credits earned.
- [x] Implement overloaded constructors and delegate defaults using `this(...)`.
- [x] Implement business logic for updating GPA, earning credits, and classifying academic standing.
- [x] Create `StudentRegistry` holding a fixed-size `Student[]` array with duplicate ID prevention.
- [x] Implement lookup, major filtering, and highest GPA search routines.
- [x] Defend array iteration loops against unassigned `null` array elements.

### Hands-On Practice Challenges
- Challenge 1: Implement a `removeStudent(int id)` method in `StudentRegistry` that deletes a student and shifts trailing array elements to maintain contiguity.
- Challenge 2: Add a `countHonorStudents()` method that calculates the percentage of enrolled students holding a GPA >= 3.5.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` and `java`
- **Libraries**: `java.lang.Math`, `java.lang.String`

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
cd java-project-roadmap/projects/05-student-registry
```

### Execution
Compile the classes and run the registry demonstration:
```bash
mkdir -p bin
javac -d bin src/*.java
java -cp bin StudentRegistry
```

## Project Structure
```
05-student-registry/
├── README.md
└── src/
    ├── Student.java
    └── StudentRegistry.java
```

## Hints
- Writing any custom constructor removes the default no-argument constructor generated by the Java compiler.
- Use `this(name, id, ...)` inside overloaded constructors to chain into the primary constructor, avoiding duplicated initialization code.
- Allocating an array with `new Student[6]` allocates space for 6 object references on the heap, each initialized to `null`.
- Calling a method on an unassigned slot like `students[5].getGpa()` throws a `NullPointerException`.
- Always verify `students[i] != null` or constrain loop bounds strictly to `i < count`.
