import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Tip Calculator ===");
        System.out.print("Enter bill amount: ");
        double billAmount = scanner.nextDouble();

        System.out.print("Enter tip percentage (e.g., 15 for 15%): ");
        double tipPercentage = scanner.nextDouble();

        double tipAmount = billAmount * (tipPercentage / 100.0);
        double totalBill = billAmount + tipAmount;

        System.out.printf("Calculated Tip: $%.2f%n", tipAmount);
        System.out.printf("Total Bill: $%.2f%n", totalBill);

        scanner.close();
    }
}
