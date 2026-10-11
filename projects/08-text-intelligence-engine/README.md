# Text Intelligence Engine (String Immutability and Methods)

**Unlocked by:** Week 3 (Methods, Strings) · **Difficulty:** 3/5 · **Time:** ~4 hours

## Goal
Analyse a block of text typed or pasted by the user: word counts, palindromes, character frequencies. Heavy practice with methods and the `String` API.

## Concepts you'll practice
- Writing small, single-purpose methods (parameters, return types, `static` helpers)
- Method overloading in practice
- `String` API: `length`, `charAt`, `substring`, `indexOf`, `split`, `toLowerCase`, `trim`, `equals` vs `==`
- Strings are immutable, and `StringBuilder` is the tool for building one

## Requirements
- [ ] `int countWords(String text)`
- [ ] `int countVowels(String text)`
- [ ] `boolean isPalindrome(String text)`, ignoring case and spaces
- [ ] `String reverseWords(String text)`
- [ ] `int[] letterFrequency(String text)`, a 26-slot array
- [ ] `String longestWord(String text)`
- [ ] Overload `countOccurrences` for `char` and for `String`
- [ ] Menu-driven `main` that reads a line and runs any analysis on it
- [ ] Each method does one thing, with no printing inside logic methods

## Milestones
1. Counting methods.
2. Palindrome and reverse.
3. Frequency table with a text bar chart.
4. Overloads.
5. Rewrite string-building loops with `StringBuilder`.

## Stretch goals
- Caesar cipher encrypt/decrypt.
- Anagram checker.
- Most common word.

## Done when
- [ ] You can explain why `s1 == s2` can be wrong for strings and what to use instead
- [ ] Every method can be tested from `main` with hard-coded input
- [ ] You can explain why `s.toUpperCase();` alone does nothing to `s`
