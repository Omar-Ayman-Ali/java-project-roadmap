import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===");
        System.out.print("Enter first integer: ");
        int first = scanner.nextInt();

        System.out.print("Enter second integer: ");
        int second = scanner.nextInt();

        int sum = first + second;
        int difference = first - second;
        int product = first * second;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);

        if (second != 0) {
            int quotient = first / second;
            int remainder = first % second;
            System.out.println("Integer division quotient: " + quotient);
            System.out.println("Remainder: " + remainder);
        } else {
            System.out.println("Division by zero is undefined.");
        }

        scanner.close();
    }
}
