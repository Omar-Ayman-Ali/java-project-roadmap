import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        System.out.println("=========================================");
        System.out.println("       Number Guessing Game (L02)        ");
        System.out.println("=========================================");

        do {
            int targetNumber = random.nextInt(100) + 1; // 1 to 100 inclusive
            int attemptsLeft = 7;
            int attemptsUsed = 0;
            boolean hasWon = false;

            System.out.println("\nA secret number between 1 and 100 has been chosen.");
            System.out.println("You have 7 attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("\nEnter your guess (1-100): ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a valid whole number.");
                    scanner.next(); // discard non-integer token
                    continue; // do not penalize attempt
                }

                int guess = scanner.nextInt();

                // Bounds validation: out of range guesses do not consume an attempt
                if (guess < 1 || guess > 100) {
                    System.out.println("Out of bounds. Guess must be between 1 and 100.");
                    continue;
                }

                attemptsUsed++;
                attemptsLeft--;

                if (guess == targetNumber) {
                    System.out.println("Correct! You found the number in " + attemptsUsed + " attempt(s).");
                    hasWon = true;
                    break;
                } else if (guess > targetNumber) {
                    System.out.println("Too high. Attempts remaining: " + attemptsLeft);
                } else {
                    System.out.println("Too low. Attempts remaining: " + attemptsLeft);
                }
            }

            if (!hasWon) {
                System.out.println("\nGame over. You have exhausted all attempts.");
                System.out.println("The secret number was: " + targetNumber);
            }

            // Post-test loop validation for replaying the game
            System.out.print("\nPlay again? (y/n): ");
            String response = scanner.next().trim().toLowerCase();
            playAgain = response.isEmpty() ? 'n' : response.charAt(0);

        } while (playAgain == 'y');

        System.out.println("Thank you for playing. Program terminated.");
        scanner.close();
    }
}
