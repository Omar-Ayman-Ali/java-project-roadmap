# 07 · Library System v1

**Unlocked by:** L02 (UML, packages, access modifiers) · **Difficulty:** ★★★☆☆ · **Time:** ~5-6 hours

## Goal
Design first, then build. A library with books and members, organised into packages, with the UML diagram drawn *before* any code.

## Concepts you'll practice
- UML class diagram: 3 compartments, `+ # -`, association lines
- Packages and the package-local (no modifier) boundary
- Visibility across packages, which is where the access matrix matters
- `static` ID generation, `final` fields
- Object arrays and `null` checks

## Suggested structure
```
src/
└── library/
    ├── model/      Book, Member
    ├── service/    Library
    └── app/        Main
```

## Requirements
- [ ] **Deliverable 0:** `uml.md` with a class diagram (Mermaid is fine) showing `Book`, `Member`, `Library` and their relationships. Commit it before the code.
- [ ] `Book`: id (auto, `static` counter), title, author, `final` isbn, `boolean available`.
- [ ] `Member`: id (auto), name, borrowed books (fixed array, max 3).
- [ ] `Library`: add book, register member, `checkout(memberId, bookId)`, `returnBook(...)`, list available books.
- [ ] At least one class with **no modifier** (package-local) and one `protected` member. Be able to explain why each is that visibility.
- [ ] Put classes in the packages above and compile with `javac -d out $(find src -name "*.java")`.

## Milestones
1. UML diagram.
2. `model` package: Book and Member.
3. `Library` in `service`, with checkout and return rules (3 book limit, can't borrow an unavailable book).
4. `Main` in `app` with a menu.
5. Review: could any field be more private?

## Stretch goals
- Due dates (store as ints for now, since you'll use real date types later).
- A second UML diagram of the final code, then compare it to the first. What changed?

## Done when
- [ ] The UML was drawn first and updated honestly afterwards
- [ ] You can fill in the access matrix (same package / subclass / other package) from memory
- [ ] You can explain why a package-local class in `model` can't be used from `app`

## Hints
- When a subclass needs to read a private field, that field needs a getter (or `protected`). You'll see why in project 09.
