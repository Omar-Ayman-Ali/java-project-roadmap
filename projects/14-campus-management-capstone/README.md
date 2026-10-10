# 14 · Campus Management System (Capstone)

**Unlocked by:** everything above · **Difficulty:** ★★★★★ · **Time:** 15-25 hours

## Goal
A console application for a university: students, professors, courses and enrolment. It's the Course/Professor domain model from the L02 UML exercise, grown into a real program that uses every concept in this roadmap.

## Concepts you'll practice
- Design before code: full UML and a written spec
- Packages and encapsulation across a multi-package codebase
- Inheritance (`Person → Student / Professor`) and interfaces (`Gradable`, `Payable`, ...)
- Exceptions with custom types, and Javadoc on the public API
- Collections, generics and streams for all queries
- At least two design patterns from project 13, used for a real reason
- File persistence, so data survives restarts

## Requirements
- [ ] `docs/design.md`: requirements, UML class diagram, package layout. Written **first**.
- [ ] Domain: `Person` (abstract-ish base) → `Student`, `Professor`. `Course`, `Enrollment`, `Department`.
- [ ] Rules: a professor teaches many courses, a student enrols in many (max 6 per term), a course has a capacity.
- [ ] Features: add/remove students, professors and courses; enrol and drop; assign grades; compute GPA; list a student's transcript; search by name.
- [ ] Reports built with streams: top students, course fill rates, professor workload.
- [ ] Custom exceptions for rule violations (`CourseFullException`, `AlreadyEnrolledException`, ...).
- [ ] Persistence to text/CSV files (load on start, save on exit).
- [ ] Menu-driven UI that doesn't leak business logic. The UI package only calls services.
- [ ] Javadoc generated for the service layer.
- [ ] README with a screenshot or transcript of a sample session.

## Milestones
1. Design doc and UML.
2. Model classes and inheritance.
3. Services with rules and exceptions.
4. Console UI.
5. Streams-based reports.
6. File persistence.
7. Patterns refactor, then Javadoc, then polish.

## Stretch goals
- Replace the console UI with a simple web or Swing front end, with the services unchanged (this proves the layering).
- Move storage to SQLite via JDBC.
- Unit tests with JUnit.

## Done when
- [ ] A new teammate could run it from your README alone
- [ ] You can swap persistence (CSV → something else) by changing one class
- [ ] No class has a `public` field
- [ ] You can walk someone through the UML and show each concept in the code
