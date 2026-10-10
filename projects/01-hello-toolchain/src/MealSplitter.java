import java.util.Scanner;

public class MealSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("     Smart Group Dining Bill & Tip Splitter      ");
        System.out.println("=================================================");

        System.out.print("Enter total restaurant bill amount: $");
        double bill = scanner.nextDouble();

        System.out.print("Enter tip percentage (e.g., 10, 15, 20): ");
        double tipPercent = scanner.nextDouble();

        System.out.print("Enter number of people splitting the bill: ");
        int peopleCount = scanner.nextInt();

        if (bill <= 0 || peopleCount <= 0 || tipPercent < 0) {
            System.out.println("Error: Bill and people count must be greater than zero, tip cannot be negative.");
            scanner.close();
            return;
        }

        double tipAmount = bill * (tipPercent / 100.0);
        double totalWithTip = bill + tipAmount;
        
        // Notice: dividing double by int promotes the result to double (safe division)
        double perPersonCost = totalWithTip / peopleCount;

        System.out.println("\n--- Receipt Summary ---");
        System.out.printf("Subtotal           : $%.2f%n", bill);
        System.out.printf("Tip Amount (%.1f%%)  : $%.2f%n", tipPercent, tipAmount);
        System.out.printf("Grand Total        : $%.2f%n", totalWithTip);
        System.out.printf("Each Person Pays   : $%.2f (%d diners)%n", perPersonCost, peopleCount);

        // ==============================================================
        // TODO: Practice Challenge For You
        // 1. Add a tax percentage (e.g. 14% VAT) applied before tipping.
        // 2. Round each person's share up to the nearest dollar so cash payment is easy.
        // ==============================================================

        scanner.close();
    }
}
