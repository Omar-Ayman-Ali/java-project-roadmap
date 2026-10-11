import java.util.Scanner;

public class CurrencyConverter {
    // Exchange rates relative to USD (1 USD = X Currency)
    private static final double USD_TO_EGP = 48.50;
    private static final double USD_TO_EUR = 0.92;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================================");
        System.out.println("      Campus International Currency Converter   ");
        System.out.println("=================================================");
        System.out.println("1. Convert USD to Egyptian Pounds (EGP)");
        System.out.println("2. Convert EGP to US Dollars (USD)");
        System.out.println("3. Convert USD to Euros (EUR)");
        System.out.print("Choose an option (1-3): ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid number (1, 2, or 3).");
            scanner.close();
            return;
        }

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter amount in USD: $");
                double usdAmount = scanner.nextDouble();
                if (usdAmount < 0) {
                    System.out.println("Amount cannot be negative.");
                } else {
                    double egpResult = usdAmount * USD_TO_EGP;
                    System.out.printf("$%.2f USD = %.2f EGP%n", usdAmount, egpResult);
                }
                break;

            case 2:
                System.out.print("Enter amount in EGP: ");
                double egpAmount = scanner.nextDouble();
                if (egpAmount < 0) {
                    System.out.println("Amount cannot be negative.");
                } else {
                    double usdResult = egpAmount / USD_TO_EGP;
                    System.out.printf("%.2f EGP = $%.2f USD%n", egpAmount, usdResult);
                }
                break;

            case 3:
                System.out.print("Enter amount in USD: $");
                double usdToEur = scanner.nextDouble();
                if (usdToEur < 0) {
                    System.out.println("Amount cannot be negative.");
                } else {
                    double eurResult = usdToEur * USD_TO_EUR;
                    System.out.printf("$%.2f USD = %.2f EUR%n", usdToEur, eurResult);
                }
                break;

            default:
                System.out.println("Option out of range. Please choose 1, 2, or 3.");
                break;
        }

        // ==============================================================
        // TODO: Practice Challenge For You
        // 1. Add support for British Pounds (GBP) with rate 1 USD = 0.77 GBP.
        // 2. Add an exchange fee deduction (e.g., 1.5% commission fee).
        // ==============================================================

        scanner.close();
    }
}
