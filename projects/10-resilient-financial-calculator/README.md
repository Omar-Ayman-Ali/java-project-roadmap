# Resilient Financial Calculator (Exception Handling and Javadoc)

**Unlocked by:** Week 5 (Exception Handling, JavaDocs) · **Difficulty:** 3/5 · **Time:** ~4 hours

## Goal
A calculator that never crashes. Bad input and bad math get handled with exceptions, and the whole API is documented with Javadoc.

## Concepts you'll practice
- `try / catch / finally`
- Checked vs unchecked exceptions
- Throwing with `throw`, declaring with `throws`
- Custom exception classes (inheritance from project 09 pays off here)
- Javadoc comments and generating HTML with the `javadoc` tool

## Requirements
- [ ] Operations: add, subtract, multiply, divide, modulo, square root, power.
- [ ] Divide by zero throws a custom `DivisionByZeroException` (or handles `ArithmeticException`, but pick on purpose).
- [ ] Square root of a negative throws `InvalidInputException`.
- [ ] Non-numeric input (`InputMismatchException`) is caught and the user re-prompted.
- [ ] A `finally` block that runs a "session summary" print.
- [ ] Expression history kept in an array or list, with an `undo` command.
- [ ] Every public class and method has Javadoc (`@param`, `@return`, `@throws`).
- [ ] Run `javadoc -d docs/api src/...` and commit the result or screenshot it.

## Milestones
1. Core operations with no error handling. Trigger every crash on purpose.
2. Catch built-in exceptions.
3. Custom exception classes.
4. Javadoc everything.
5. History and undo.

## Stretch goals
- Parse a full expression like `3 + 4 * 2`.
- Try-with-resources reading input from a file.

## Done when
- [ ] No input, however malformed, produces a stack trace
- [ ] You can explain checked vs unchecked and give one example of each
- [ ] You can explain when `finally` runs, including when `return` is in the `try`
