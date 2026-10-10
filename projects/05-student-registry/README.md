# 05 · Student Registry

**Unlocked by:** L02 (classes, objects, constructors) · **Difficulty:** ★★☆☆☆ · **Time:** ~3-4 hours

## Goal
Your first real class. Model a `Student`, store many of them in an array, and manage them from a `main` driver.

## Concepts you'll practice
- A class is a blueprint, and an object is an instance created with `new`
- Fields (state) and methods (behaviour)
- Constructors: same name as the class, no return type
- Overloaded constructors, and the **default constructor disappearing** once you write any constructor
- The dot operator: `student.addMarks(10.5f)`
- Object arrays hold references, so `new Student[5]` is five `null`s

## Requirements
- [ ] `Student` has fields `name`, `id`, `marks`.
- [ ] Two constructors: `Student(String name, int id)` and `Student(String name, int id, float marks)`.
- [ ] Methods: `addMarks(float)` (returns new total), `isPassing()` (marks >= 50), `toString()`.
- [ ] `Registry` driver holds a `Student[]` and supports add, find by id, list all, and print the top student.
- [ ] Demonstrate the `null` problem: access an empty slot, catch what happens, and write about it in `NOTES.md`.

## Milestones
1. `Student` class + one constructor, create one object in `main`.
2. Second constructor, so you can see overloading.
3. Remove all constructors and see the compiler's default one. Add a parameterised one and try `new Student()`. Read the error.
4. The array-backed registry.
5. Sort the registry by marks.

## Stretch goals
- `equals`-style comparison by id (just a method for now).
- Draw the UML box for `Student` (3 compartments, `+ # -`).

## Done when
- [ ] You can explain exactly when Java gives you a default constructor
- [ ] You can explain why `Student[] roster = new Student[5]; roster[0].addMarks(1)` fails
- [ ] You drew the UML before writing the code, or at least after

## Hints
- `this.name = name;` resolves the clash when a parameter has the same name as a field.
- Overloaded constructors can share work, but you'll meet `this(...)` properly later. For now, duplicate the assignments.
