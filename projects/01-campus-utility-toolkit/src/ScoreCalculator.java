import java.util.Scanner;

public class ScoreCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("     Course Score & Grade Precision Evaluator    ");
        System.out.println("=================================================");

        System.out.print("Enter Quiz 1 score (integer, e.g. 17): ");
        int q1 = scanner.nextInt();

        System.out.print("Enter Quiz 2 score (integer, e.g. 19): ");
        int q2 = scanner.nextInt();

        System.out.print("Enter Quiz 3 score (integer, e.g. 18): ");
        int q3 = scanner.nextInt();

        int sum = q1 + q2 + q3;

        // Pitfall Demo: In Java, integer / integer truncates (discards decimals!)
        int truncatedAverage = sum / 3;

        // Correct Solution: Casting at least one operand to double guarantees real division
        double accurateAverage = (double) sum / 3.0;

        System.out.println("\n--- Evaluation Results ---");
        System.out.println("Total Points Earned  : " + sum + " / 60");
        System.out.println("Truncated Average    : " + truncatedAverage + " (incorrect integer division!)");
        System.out.printf("Accurate Average     : %.2f (proper floating-point casting)%n", accurateAverage);

        if (accurateAverage >= 15.0) {
            System.out.println("Performance Standing : Honors - Great Job!");
        } else if (accurateAverage >= 10.0) {
            System.out.println("Performance Standing : Good Standing - Passed.");
        } else {
            System.out.println("Performance Standing : Needs Review.");
        }

        // ==============================================================
        // TODO: Practice Challenge For You
        // 1. Add weights: Quiz 1 is 20%, Quiz 2 is 30%, Quiz 3 is 50%.
        // 2. Compute the weighted average: (q1 * 0.20) + (q2 * 0.30) + (q3 * 0.50).
        // ==============================================================

        scanner.close();
    }
}
