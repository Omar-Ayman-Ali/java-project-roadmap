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
- [Detailed Project Explanation](#detailed-project-explanation)
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

### Project Assignment: Make Project Student Registry
Make a project called `Collegiate Academic Advising Registry` that models student entities and manages them in a registry coordinator while practicing class blueprints, constructor overloading, and object array null-safety.

Specifically, you need to build:
1. `Student.java`: An entity class modeling student academic state.
   - Private attributes: `id` (integer), `name` (String), `major` (String), `gpa` (double), and `creditsEarned` (integer).
   - Overloaded Constructor 1: `Student(name, id)` initializes name and ID, defaulting major to "Computer Science & AI", GPA to 0.0, and credits to 0.
   - Overloaded Constructor 2: `Student(name, id, major, gpa, credits)` initializes all attributes while validating that GPA is clamped between 0.0 and 4.0.
   - Constructor chaining: Use `this(...)` inside Constructor 1 to forward parameters to Constructor 2.
   - Public member methods: `updateGpa(double)`, `addCredits(int)`, `getAcademicStanding()` (returning "Dean's List (Honors)" for GPA >= 3.5, "Good Standing" for GPA >= 2.0, or "Academic Probation" otherwise), `isGraduationEligible()`, and a formatted `toString()`.
2. `StudentRegistry.java`: A coordinator class managing a fixed-size `Student[]` array.
   - Private fields: `Student[] students` and `int count`.
   - Constructor: `StudentRegistry(int capacity)` allocating the array and initializing `count` to 0.
   - Methods: `addStudent(Student s)` with capacity limit checks and duplicate ID prevention; `findById(int id)` using safe linear search; `filterByMajor(String query)` printing all matching students; `getTopStudent()` returning the student with the highest GPA; and `listAll()`.
3. Execution driver: A `main` method demonstrating object creation with `new`, calling instance methods via the dot operator (`s1.updateGpa(3.60)`), and explicitly demonstrating safe checks against unassigned `null` array slots.

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

## Detailed Project Explanation

### 1. Classes vs Objects
In Java, a class is a blueprint or template defined in source code, while an object is a concrete instance living in heap memory:
- The `Student` class defines the shape: what state every student will possess (`name`, `gpa`) and what behaviors they can execute (`updateGpa()`).
- Writing `Student s1 = new Student("Alice", 101);` creates a new instance on the heap and assigns its memory address to reference variable `s1`.

### 2. Information Hiding (Encapsulation)
Encapsulation bundles data attributes and methods together while restricting direct access to object internals:
- All fields in `Student` are marked `private`. If fields were public, outside code could write `s1.gpa = -50.0;` or `s1.gpa = 999.0;`, placing the object in an invalid state.
- By exposing access solely through methods like `updateGpa(double)`, the class enforces validation invariants: `this.gpa = Math.max(0.0, Math.min(4.0, newGpa));`.

### 3. Constructor Mechanics and Compiler Defaults
- Constructors have no return type and share the exact name of their class.
- When you do not write any constructors in a class, the Java compiler automatically creates an invisible, no-argument default constructor.
- The moment you define any custom constructor (such as `Student(String, int)`), the compiler retracts the automatic default constructor. If you still want a no-arg constructor, you must code it explicitly.

### 4. Constructor Delegation with this(...)
When writing multiple constructors (constructor overloading), avoid duplicating validation and assignment logic across each one:
- In `Student(String name, int id)`, you can write `this(name, id, "Computer Science & AI", 0.0, 0);`.
- The `this(...)` call must be the very first statement in the constructor body. It routes execution directly into the primary 5-parameter constructor.

### 5. Object Arrays and Null Reference Protection
Allocating an object array like `new Student[6]` allocates space for 6 reference pointers on the heap, each default-initialized to `null`. It does not create any `Student` objects:
- If index 5 is empty and you write `students[5].getGpa()`, the JVM attempts to dereference a `null` address and throws a `NullPointerException`.
- Always check `if (students[i] != null)` or iterate strictly up to the active populated count (`i < count`).

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
