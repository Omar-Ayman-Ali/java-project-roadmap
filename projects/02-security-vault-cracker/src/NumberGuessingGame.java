import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char playAgain;

        System.out.println("=================================================");
        System.out.println("    Cybersecurity Vault Cracker & Sonar Game     ");
        System.out.println("=================================================");
        System.out.println("Welcome, Agent! Your mission is to crack the digital");
        System.out.println("security vault code before the intrusion alarm triggers.");

        do {
            // Secret passcode between 1 and 100 inclusive
            int secretCode = random.nextInt(100) + 1;
            int shieldsRemaining = 7;
            int attemptsUsed = 0;
            boolean vaultUnlocked = false;

            System.out.println("\n[ALERT] Vault passcode locked between 1 and 100.");
            System.out.println("[STATUS] Security shields: 7 attempt units available.");

            while (shieldsRemaining > 0) {
                System.out.print("\nEnter breach code attempt (1-100): ");

                // Input validation: guard against non-numeric entries
                if (!scanner.hasNextInt()) {
                    System.out.println("[WARNING] Invalid signal! Input numbers only. Shield preserved.");
                    scanner.next(); // clear bad token
                    continue; // do not penalize player
                }

                int guess = scanner.nextInt();

                // Range validation: guard against out-of-bounds values
                if (guess < 1 || guess > 100) {
                    System.out.println("[WARNING] Out of sensor range (1-100). Shield preserved.");
                    continue;
                }

                attemptsUsed++;
                shieldsRemaining--;

                if (guess == secretCode) {
                    System.out.println("\n>>> ACCESS GRANTED! <<<");
                    System.out.println("Vault cracked successfully in " + attemptsUsed + " attempt(s)!");
                    vaultUnlocked = true;
                    break;
                }

                // Proximity feedback logic based on mathematical absolute distance
                int distance = Math.abs(guess - secretCode);
                String proximityNotice;
                if (distance <= 5) {
                    proximityNotice = "BOILING HOT! You are right next to the code!";
                } else if (distance <= 15) {
                    proximityNotice = "WARM: Close range signal detected.";
                } else {
                    proximityNotice = "COLD: Signal is far away.";
                }

                // Directional hint
                String directionNotice = (guess > secretCode) ? "Too HIGH (dial down)" : "Too LOW (dial up)";

                System.out.printf("[FEEDBACK] %s | %s%n", directionNotice, proximityNotice);
                System.out.println("[SHIELDS] Units remaining: " + shieldsRemaining);
            }

            if (!vaultUnlocked) {
                System.out.println("\n>>> LOCKDOWN ACTIVATED! <<<");
                System.out.println("Intrusion shields depleted. The passcode was: " + secretCode);
            }

            // Post-test loop validation for another session
            System.out.print("\nInitiate another breach mission? (y/n): ");
            String reply = scanner.next().trim().toLowerCase();
            playAgain = reply.isEmpty() ? 'n' : reply.charAt(0);

            // ==============================================================
            // TODO: Practice Challenge For You
            // 1. Add difficulty modes: Rookie (1-50, 10 shields), Expert (1-100, 7 shields).
            // 2. Track high score: record the lowest number of attempts used across rounds.
            // ==============================================================

        } while (playAgain == 'y');

        System.out.println("\nTerminal session closed. Agent signed off.");
        scanner.close();
    }
}
