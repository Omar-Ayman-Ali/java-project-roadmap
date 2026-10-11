# Enterprise Workflow Queue (Collections and Generics)

**Unlocked by:** Week 8 (Lists, Generics, Streams) · **Difficulty:** 4/5 · **Time:** ~6 hours

## Goal
A to-do manager that outgrows fixed-size arrays. Use collections for storage and streams for querying.

## Concepts you'll practice
- `ArrayList<T>` vs arrays (and why you've been fighting fixed size since project 03)
- Generics: `List<Task>`, and writing one generic class of your own
- `Comparator` and sorting
- Streams: `filter`, `map`, `sorted`, `collect`, `count`, `anyMatch`
- `Map<K,V>` for grouping

## Requirements
- [ ] `Task`: id, title, priority (enum), due day number, done flag.
- [ ] `TaskManager` stores tasks in a `List<Task>`, supporting add, remove, complete and edit.
- [ ] Queries **implemented with streams**: overdue tasks, tasks by priority, titles containing a keyword, count of completed.
- [ ] Sort by priority then due date, using a `Comparator`.
- [ ] Group tasks by priority into a `Map<Priority, List<Task>>`.
- [ ] A small generic class, such as `Pair<A,B>` or `Repository<T>`, used somewhere real in the app.
- [ ] Rewrite two of your stream queries as plain loops and compare which reads better.

## Milestones
1. `Task` + enum + list-backed manager.
2. CRUD from a menu.
3. Stream queries.
4. Comparators and grouping.
5. Generic `Repository<T>`.

## Stretch goals
- Save and load tasks from a text file.
- Recurring tasks via inheritance.

## Done when
- [ ] No arrays with a manual `count` variable remain
- [ ] You can explain what `List<Task>` prevents compared to a raw `List`
- [ ] You can describe the difference between an intermediate and terminal stream operation
