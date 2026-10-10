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
