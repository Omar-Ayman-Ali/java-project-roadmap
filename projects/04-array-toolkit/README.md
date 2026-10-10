# 04 · Array Toolkit

**Unlocked by:** L02 (arrays) · **Difficulty:** ★★☆☆☆ · **Time:** ~3 hours

## Goal
Write a small library of array utilities and a test `main` that exercises each one. The point is to feel exactly how Java arrays behave: fixed size, reference semantics, default values.

## Concepts you'll practice
- Declaring arrays: `new float[10]` vs `new float[]{1.2F, 3.4F}`
- Primitive arrays default to `0`/`0.0`/`false`; object arrays default to `null`
- Arrays are references, so assigning one to another variable doesn't copy it
- Foreach for reading, indexed `for` for writing

## Requirements
Implement each as a `static` method in `ArrayToolkit.java` (plain static methods are fine for now):
- [ ] `int max(int[] a)` and `int min(int[] a)`
- [ ] `double average(int[] a)`
- [ ] `int[] reverse(int[] a)` returns a **new** array
- [ ] `int indexOf(int[] a, int target)` returns -1 if not found
- [ ] `int[] copy(int[] a)` (a real copy, not an alias)
- [ ] `void bubbleSort(int[] a)`
- [ ] `String[] names = new String[5]`: print it right after creation and observe the `null`s

## Milestones
1. min / max / average.
2. indexOf and reverse.
3. Demonstrate aliasing: `int[] b = a; b[0] = 99;` then print `a[0]`. Explain it in `NOTES.md`.
4. copy, then show that changing the copy leaves the original alone.
5. bubbleSort.

## Stretch goals
- Binary search (on a sorted array).
- 2D array: matrix transpose.
- Rotate an array by `k` positions in place.

## Done when
- [ ] You can state the default value of every element in `new boolean[3]`, `new double[3]` and `new String[3]`
- [ ] You can explain the aliasing demo without looking anything up
- [ ] Every method handles an empty array without crashing (decide what "max of empty" should do)

## Hints
- `a.length` is a field, not a method.
- For `reverse`, create `new int[a.length]` and fill it from the back.
