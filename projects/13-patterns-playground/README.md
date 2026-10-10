# 13 · Patterns Playground

**Unlocked by:** Week 9 (Design Patterns) · **Difficulty:** ★★★★☆ · **Time:** ~6-8 hours

## Goal
Implement four classic design patterns in small, focused demos. Each one is a retrofit of an earlier project, so you feel the problem the pattern solves.

## Concepts you'll practice
- Recognising a recurring design problem, then applying the standard solution
- Combining interfaces, inheritance and encapsulation
- Reading and drawing UML for pattern structure

## Requirements
Each pattern gets its own package with a `Demo` class and a UML diagram.

- [ ] **Singleton**: a `Logger` or `Config` with a private constructor and one shared instance. Explain why `static` alone isn't the same thing.
- [ ] **Factory**: a `ShapeFactory.create("circle", ...)` from project 09, so callers never write `new Circle`.
- [ ] **Strategy**: swappable algorithms. Retrofit project 11's fees, or sorting rules in project 12.
- [ ] **Observer**: `Library` from project 07 notifies subscribed `Member`s when a book becomes available.
- [ ] A `PATTERNS.md` with, for each pattern: the problem, the solution, one drawback.

## Milestones
1. Singleton (simplest).
2. Factory.
3. Strategy.
4. Observer (hardest, so do it last).
5. `PATTERNS.md`.

## Stretch goals
- Builder pattern for a class with many optional fields.
- Decorator, e.g. coffee shop with toppings.

## Done when
- [ ] You can explain each pattern's problem without naming the pattern first
- [ ] Each demo runs from its own `main`
- [ ] You can say when a pattern would be overkill
