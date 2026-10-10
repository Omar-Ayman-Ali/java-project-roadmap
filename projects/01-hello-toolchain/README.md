# 01 · Hello Toolchain

**Unlocked by:** L01 · **Difficulty:** ★☆☆☆☆ · **Time:** ~1-2 hours

## Goal
Get comfortable with the full Java workflow, from source to bytecode to running, and write three tiny console programs that read input with `Scanner`.

## Concepts you'll practice
- `javac` produces `.class` bytecode, `java` runs it on the JVM
- File name must match the `public` class name
- The `main` signature and what each keyword means
- Console I/O with `System.out.println` and `Scanner`
- Integer division truncation

## Requirements
- [ ] `HelloWorld.java`: prints a greeting. Compile and run it **from the terminal**, not just the IDE.
- [ ] `SimpleCalculator.java`: reads two ints and prints their sum.
- [ ] `TipCalculator.java`: reads a bill amount and a tip percentage, prints tip and total.
- [ ] `AverageOfThree.java`: reads three ints and prints their average. It must show the correct decimal result.

## Milestones
1. Install the JDK and confirm `javac -version` and `java -version` both work.
2. Hello World from the terminal.
3. Break it on purpose: rename the file to the wrong case, and misspell `main`. Read the error messages.
4. The three calculators.

## Stretch goals
- Open the `.class` file with `javap -c HelloWorld` and look at the bytecode.
- Accept command-line arguments through `args` instead of `Scanner`.

## Done when
- [ ] All four programs compile and run from the terminal
- [ ] You can explain JDK vs JRE vs JVM in your own words (in `NOTES.md`)
- [ ] You know why `11 / 4` prints `2`, and how to get `2.75`

## Hints
- `Scanner in = new Scanner(System.in);` then `in.nextInt()` or `in.nextDouble()`
- For the average, think about *when* the division happens relative to the type.
