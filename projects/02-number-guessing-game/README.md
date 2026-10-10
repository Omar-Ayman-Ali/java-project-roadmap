# Number Guessing Game (Console Loop Flow)

**Live Demo:** Not deployed (local execution only)

An interactive terminal guessing game practicing conditional branching, bounded loops, and loop control statements.

![Language](https://img.shields.io/badge/Language-Java_21-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Course-CIS_201_L02-blue?style=flat-square)
![Build](https://img.shields.io/badge/Build-javac_CLI-green?style=flat-square)

## Table of Contents
- [About](#about)
- [Architecture](#architecture)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Run Locally](#run-locally)
- [Project Structure](#project-structure)
- [Hints](#hints)

## About
This project implements a console game designed to reinforce Java control structures introduced in Lecture 2. The program coordinates pre-test loop evaluation, post-test replay loops, and guarded branching logic. It demonstrates clean user input handling without premature loop termination or state corruption.

## Architecture
The application executes within a two-tier nested loop structure:
- **Outer Loop (`do-while`)**: Controls session replay state, guaranteeing at least one full game round before evaluating termination criteria.
- **Inner Loop (`while`)**: Governs attempt countdown and guess evaluation against the generated target.

```
+-------------------------------------------------------+
| Outer Loop: do-while (Session Lifecycle)              |
|                                                       |
|  [ Generate Target: 1..100 ]                          |
|  [ Initialize Attempts = 7 ]                          |
|                                                       |
|  +-------------------------------------------------+  |
|  | Inner Loop: while (Attempts Remaining > 0)      |  |
|  |                                                 |  |
|  |   [ Read Input ]                                |  |
|  |     |-- Invalid / Out-of-bounds -> continue     |  |
|  |     |-- Equals Target           -> break (Win)  |  |
|  |     |-- Greater / Smaller       -> Feedback     |  |
|  +-------------------------------------------------+  |
|                                                       |
|  [ Prompt Play Again (y/n) ]                          |
+-------------------------------------------------------+
```

## Features
- **Pseudorandom Target Generation**: Produces uniform random integers within the closed interval [1, 100].
- **Bounded Guess Allocation**: Restricts the player to a strict maximum of 7 guessing attempts per round.
- **Feedback Dispatch**: Emits relative distance indicators ("Too high" or "Too low") after each valid attempt.
- **Input Sanitization**: Skips invalid tokens and out-of-range integers via `continue` without depleting player attempts.
- **Session Continuity**: Leverages post-test `do-while` validation to prompt and execute optional game replays.

### What You Need To Do
- [x] Configure `java.util.Random` to generate a random integer between 1 and 100.
- [x] Maintain a countdown counter starting at 7 remaining attempts.
- [x] Provide real-time directional feedback ("Too high", "Too low", or "Correct") on every valid guess.
- [x] Employ `continue` to filter out non-numeric tokens and values outside the 1 to 100 range without penalizing the player.
- [x] Use a `do-while` structure to query whether the player wishes to restart after round completion.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` and `java`
- **Libraries**: `java.util.Random`, `java.util.Scanner`

## Run Locally

### Prerequisites
- OpenJDK 17 or 21:
  ```bash
  javac -version
  ```

### Installation
Clone the repository and enter the project directory:
```bash
git clone https://github.com/Omar-Ayman-Ali/java-project-roadmap.git
cd java-project-roadmap/projects/02-number-guessing-game
```

### Execution
Compile the source file into a `bin` directory and launch the game:
```bash
mkdir -p bin
javac -d bin src/NumberGuessingGame.java
java -cp bin NumberGuessingGame
```

## Project Structure
```
02-number-guessing-game/
├── README.md
└── src/
    └── NumberGuessingGame.java
```

## Hints
- `Random.nextInt(100)` returns values from 0 to 99, so append 1 (`random.nextInt(100) + 1`) to shift the interval to 1 through 100.
- Use `scanner.hasNextInt()` prior to invoking `scanner.nextInt()` to prevent `InputMismatchException` crashes when non-numeric input is supplied.
- Remember that `do-while` statements evaluate the condition at the end of the block and require a terminating semicolon: `do { ... } while (condition);`.
- `continue` skips the remaining statements in the current loop iteration and proceeds immediately to the next loop evaluation.
- `break` exits the nearest enclosing loop immediately.
