import java.util.Scanner;

public class AverageOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Average of Three Integers ===");
        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();

        System.out.print("Enter third integer: ");
        int c = scanner.nextInt();

        int sum = a + b + c;
        // Integer division truncation: sum / 3 drops the decimal part.
        // Explicit cast to double ensures floating-point division.
        double average = (double) sum / 3.0;

        System.out.println("Sum: " + sum);
        System.out.printf("Average (decimal): %.4f%n", average);

        scanner.close();
    }
}
