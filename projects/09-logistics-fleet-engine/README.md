# Logistics Fleet Engine (Inheritance and Polymorphism)

**Unlocked by:** Week 4 (Inheritance, Polymorphism) · **Difficulty:** 3/5 · **Time:** ~5 hours

## Goal
Build two small hierarchies, one for shapes and one for vehicles, and use polymorphism to treat different objects uniformly.

## Concepts you'll practice
- `extends`, and Java's single class inheritance only
- `super(...)` constructor calls, and the implicit `super()`
- **Overriding** (same signature, runtime) vs **overloading** (same name, different parameters, compile-time)
- `@Override`
- `private` members are invisible to subclasses, so use getters or `protected`
- Dynamic method dispatch: `Vehicle v = new Car(); v.move();`

## Requirements
**Shapes**
- [ ] Superclass `Shape` with `name`, `double area()`, `double perimeter()`, `toString()`.
- [ ] Subclasses `Circle`, `Rectangle`, `Triangle` override `area` and `perimeter`.
- [ ] A `Shape[]` mixing all types, and a loop printing each area. The *same call* must behave differently.

**Vehicles** (mirrors the lecture's hierarchy: `Vehicle → Land/Water/Air → Car, Bus, Ship, ...`)
- [ ] `Vehicle` with `speed`, `fuelCapacity`, `move()`.
- [ ] At least two intermediate classes and four concrete ones, each overriding `move()`.
- [ ] Overload a method (e.g. `refuel(double)` and `refuel(double, String fuelType)`).

## Milestones
1. UML for both hierarchies. Use the hollow-triangle arrow pointing to the superclass.
2. `Shape` and one subclass.
3. All shapes plus the polymorphic array.
4. Vehicle hierarchy.
5. A bug on purpose: make a subclass read a `private` field, read the error, then fix it two ways.

## Stretch goals
- Sort shapes by area.
- `final` method and `final` class: try to override or extend them and read the errors.

## Done when
- [ ] You can state which polymorphism is compile-time and which is runtime, and why
- [ ] You know why `class A extends B, C` can't compile
- [ ] You can explain what happens if you forget the `super(...)` call and the parent has no no-arg constructor
