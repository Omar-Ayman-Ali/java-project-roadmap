# 02 · Number Guessing Game

**Unlocked by:** L02 (branching, loops, loop control) · **Difficulty:** ★☆☆☆☆ · **Time:** ~2 hours

## Goal
A console game where the computer picks a secret number and the player guesses it, getting "higher" or "lower" hints.

## Concepts you'll practice
- `if / else if / else` chains, with braces always
- `while` (pre-test) vs `do-while` (post-test, note the trailing `;`)
- `break` and `continue`, at most one of each per loop
- `java.util.Random` and `Scanner`

## Requirements
- [ ] Computer picks a random number from 1 to 100.
- [ ] Player has a maximum of 7 attempts.
- [ ] After each guess print "Too high", "Too low" or "Correct".
- [ ] Print the number of attempts used at the end.
- [ ] Ask "Play again? (y/n)" after each game, using a `do-while`.
- [ ] Invalid input (a guess outside 1-100) is skipped with `continue` and doesn't cost an attempt.

## Milestones
1. One game, unlimited attempts.
2. Add the attempt limit.
3. Add input validation with `continue`.
4. Add the play-again loop.
5. Track best score (fewest attempts) across games.

## Stretch goals
- Difficulty levels (easy 1-50, hard 1-1000) chosen with a menu.
- Reverse the game: you think of a number and the computer guesses it by binary search.

## Done when
- [ ] You can trace by hand the output of your loop for a sample input sequence
- [ ] You used `break` or `continue` no more than once per loop
- [ ] You can explain when `do-while` runs the body zero times (trick question)

## Hints
- `new Random().nextInt(100)` gives 0-99. Adjust it.
- A `boolean won` flag keeps the loop condition readable.
