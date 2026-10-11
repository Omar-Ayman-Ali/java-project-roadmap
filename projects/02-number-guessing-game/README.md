# Number Guessing Game (Vault Cracker and Proximity Sonar)

**Live Demo:** Not deployed (local execution only)

An engaging command-line security vault breaker practicing nested loop control, input validation guards, and proximity feedback calculations.

![Language](https://img.shields.io/badge/Language-Java_21-orange?style=flat-square)
![Scope](https://img.shields.io/badge/Course-CIS_201_L02-blue?style=flat-square)
![Build](https://img.shields.io/badge/Build-javac_CLI-green?style=flat-square)

## Table of Contents
- [About](#about)
- [Architecture](#architecture)
- [Features](#features)
- [Detailed Project Explanation](#detailed-project-explanation)
- [Tech Stack](#tech-stack)
- [Run Locally](#run-locally)
- [Project Structure](#project-structure)
- [Hints](#hints)

## About
This project reinforces control flow principles from Lecture 2 by simulating an interactive digital security vault breach. Players assume the role of a cybersecurity technician attempting to identify a randomly generated passcode using dual-axis feedback (numerical direction and distance proximity). The implementation demonstrates loop lifecycles, guarded branching, and resilient input recovery without game crashes.

## Architecture
The application runs inside a two-tier nested loop structure:
- **Outer Session Loop (`do-while`)**: Governs overall game rounds, guaranteeing at least one full play session and handling replay confirmation.
- **Inner Mission Loop (`while`)**: Governs shield countdown (7 attempts) and handles guess verification.

```
+-------------------------------------------------------------+
| Outer Session Loop: do-while                                |
|                                                             |
|   1. Generate Secret Passcode: [1..100]                     |
|   2. Initialize Shield Units: 7                             |
|                                                             |
|   +-----------------------------------------------------+   |
|   | Inner Mission Loop: while (Shields > 0)             |   |
|   |                                                     |   |
|   |   Input Stream -> Token Inspection                  |   |
|   |     |-- Non-integer token      -> continue          |   |
|   |     |-- Out-of-bounds (1..100) -> continue          |   |
|   |     |-- Exact Match            -> break (Win)       |   |
|   |     |-- High / Low Distance    -> Feedback Dispatch |   |
|   +-----------------------------------------------------+   |
|                                                             |
|   Prompt Replay Mission (y/n)                               |
+-------------------------------------------------------------+
```

## Features
- **Target Passcode Generation**: Uses `java.util.Random` to produce a discrete pseudorandom integer between 1 and 100.
- **Shield Allocation Defense**: Enforces a strict 7-attempt limit per mission before triggering an alarm lockdown.
- **Dual-Axis Signal Feedback**: Emits directional cues ("Too HIGH" / "Too LOW") alongside absolute proximity alerts ("BOILING HOT", "WARM", "COLD").
- **Fault-Tolerant Input Stream**: Employs `continue` to intercept invalid characters and out-of-range inputs without penalizing attempt shields.
- **Replay Continuity**: Leverages a post-test `do-while` loop to cleanly restart or exit game sessions.

### Project Assignment: Make Project Vault Cracker Game
Make a project called `Cybersecurity Vault Cracker` where the player attempts to crack a secure 1-to-100 numerical vault passcode using bounded attempts and intelligent sensor clues.

Specifically, you need to build:
1. `NumberGuessingGame.java`: A complete game program with a console loop.
2. Random code generator: Configure `java.util.Random` to generate a secret integer uniformly between 1 and 100 inclusive.
3. Security shields: Give the user an initial budget of 7 shield attempts per round, decrementing by one only on valid guesses.
4. Input validation and recovery: Use `scanner.hasNextInt()` to check input. If the input is not a number, or if the number is outside 1 to 100, print a warning and use `continue` to skip the rest of the loop without subtracting a shield.
5. Win detection: If the guess matches the passcode, print a success message and use `break` to exit the loop immediately.
6. Proximity sonar clues: Calculate the absolute difference `Math.abs(guess - secretCode)`. Display "BOILING HOT" if distance is within 5, "WARM" if within 15, and "COLD" otherwise, alongside the directional "Too HIGH" or "Too LOW" hint.
7. Post-game replay prompt: After the round concludes (whether won or lost), ask the user "Play again? (y/n)" using a `do-while` loop.

### What You Need To Do
- [x] Configure pseudorandom passcode generation in the closed range [1, 100].
- [x] Initialize a shield counter to 7 units and decrement upon valid attempts.
- [x] Use `Math.abs(guess - secretCode)` to compute proximity distance and output helpful feedback.
- [x] Use `continue` when input is invalid or out-of-bounds to keep shields intact.
- [x] Use `break` to exit the mission loop immediately once the code is cracked.
- [x] Implement a `do-while` loop to prompt the player for session replays.

### Hands-On Practice Challenges
- Challenge 1: Add a mission difficulty selector before the game starts (Rookie: 1 to 50 with 10 shields; Agent: 1 to 100 with 7 shields; Specialist: 1 to 200 with 5 shields).
- Challenge 2: Implement a high score tracker that stores the lowest number of attempts used across multiple rounds within the same session.

## Detailed Project Explanation

### 1. Pre-Test While vs Post-Test Do-While Loops
Java provides multiple loop structures suited for distinct control flows:
- **`while` (Pre-test)**: Tests its condition before executing the loop body. If the condition is false initially, the body does not run at all. In this game, the inner guessing loop uses `while (shieldsRemaining > 0)` because once shields hit zero, guessing must stop immediately.
- **`do-while` (Post-test)**: Executes the body first, then tests the condition at the bottom. This guarantees the block executes at least once. It is the textbook choice for user replay prompts: the player must play one game before being asked if they want to play again.

### 2. Fine-Grained Loop Control with Break and Continue
- **`break`**: Immediately terminates the nearest enclosing loop and resumes execution at the statement following the loop block. Here, when the player guesses the exact code, `break` terminates the `while` loop instantly, avoiding unnecessary redundant guess prompts.
- **`continue`**: Skips the remaining statements in the current iteration and jumps directly to the loop condition evaluation. When the player enters non-numeric text or an out-of-range number (such as `150`), `continue` restarts the loop without running the decrement code (`shieldsRemaining--`), protecting the player from accidental penalties.

### 3. Absolute Mathematical Distance with Math.abs()
To provide distance-based sonar hints, you need the magnitude of the difference between the player's guess and the secret passcode:
- `guess - secretCode` can be negative when guessing low (e.g., `20 - 50 = -30`).
- Calling `Math.abs(guess - secretCode)` eliminates the negative sign, yielding a positive scalar distance (`30`).
- Branching on this distance (`<= 5`, `<= 15`) enables intuitive proximity alerts.

### 4. Input Stream Token Recovery
Calling `scanner.nextInt()` on non-integer input triggers an `InputMismatchException` that halts the program. By guarding input reading with `scanner.hasNextInt()`, you safely verify the upcoming token. If it is invalid, call `scanner.next()` to consume and discard the invalid text token so subsequent reads do not get stuck on the same bad input.

## Tech Stack
- **Language**: Java 21 (LTS)
- **Toolchain**: OpenJDK `javac` and `java`
- **Libraries**: `java.util.Random`, `java.util.Scanner`, `java.lang.Math`

## Run Locally

### Prerequisites
- OpenJDK 17 or 21:
  ```bash
  javac -version
  ```

### Installation
Clone the repository and enter the project folder:
```bash
git clone https://github.com/Omar-Ayman-Ali/java-project-roadmap.git
cd java-project-roadmap/projects/02-number-guessing-game
```

### Execution
Compile the game and launch the vault cracking simulation:
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
- `Random.nextInt(100)` produces values from 0 through 99. Add 1 (`random.nextInt(100) + 1`) to shift the interval to 1 through 100.
- Check `scanner.hasNextInt()` before calling `scanner.nextInt()` to prevent runtime `InputMismatchException` crashes when letters are typed.
- Remember that `continue` skips the remainder of the current loop iteration and immediately restarts loop condition testing.
- The `Math.abs(a - b)` method computes the absolute difference between two numbers regardless of which is larger.
- A `do-while` loop always executes at least once before testing its terminating condition, making it ideal for interactive game replays.
