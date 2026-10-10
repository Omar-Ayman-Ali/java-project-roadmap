# 03 · Menu-Driven Gradebook

**Unlocked by:** L02 (`switch`, `for`, foreach, arrays) · **Difficulty:** ★★☆☆☆ · **Time:** ~3 hours

## Goal
A text-menu program that stores up to 30 student marks in an array and lets the user add, list, and analyse them.

## Concepts you'll practice
- `switch` on `int`, `char` and `String`, including `default`, and fall-through when you forget `break`
- Standard `for` vs enhanced `for`
- Fixed-size arrays and managing a "count" separately from capacity
- Chained `if-else` for ranges (`switch` can't do ranges!)

## Requirements
- [ ] Menu loop: 1) Add mark, 2) List marks, 3) Statistics, 4) Letter grades, 0) Exit. Use `switch`.
- [ ] Marks stored in a `double[]` of size 30. Reject the 31st entry politely.
- [ ] Statistics prints count, average, highest, lowest.
- [ ] Letter grades: convert each mark to A/B/C/D/F using `if-else if` (ranges).
- [ ] Use foreach where you only read, and indexed `for` where you need the index.

## Milestones
1. Menu skeleton with stub cases.
2. Add + list.
3. Statistics.
4. Letter grades.
5. Make the menu accept a `String` command (`"add"`, `"list"`) with a `switch` on `String`.

## Stretch goals
- Count how many students fall in each grade band and draw a text histogram.
- Delete a mark by index (shift the rest left).

## Done when
- [ ] You can explain why `switch` can't handle the grade ranges
- [ ] You saw fall-through happen once (remove a `break` on purpose) and wrote it in `NOTES.md`
- [ ] No `ArrayIndexOutOfBoundsException` under any input

## Hints
- Keep `int count` alongside the array. `marks.length` is capacity, not how many you've stored.
