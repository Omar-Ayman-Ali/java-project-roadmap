import java.util.Scanner;

public class Gradebook {
    private static final int MAX_CAPACITY = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] marks = new double[MAX_CAPACITY];
        int count = 0;
        boolean running = true;

        System.out.println("=========================================");
        System.out.println("       Menu-Driven Gradebook (L02)       ");
        System.out.println("=========================================");

        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add Student Mark");
            System.out.println("2. List All Marks");
            System.out.println("3. Display Statistics (Average, Min, Max)");
            System.out.println("4. Display Letter Grades");
            System.out.println("0. Exit Application");
            System.out.print("Select an option (0-4): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid choice. Please input an integer option.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (count >= MAX_CAPACITY) {
                        System.out.println("Capacity reached. Cannot store more than " + MAX_CAPACITY + " marks.");
                    } else {
                        System.out.print("Enter mark (0.0 to 100.0): ");
                        if (!scanner.hasNextDouble()) {
                            System.out.println("Invalid numeric value.");
                            scanner.next();
                            break;
                        }
                        double mark = scanner.nextDouble();
                        if (mark < 0.0 || mark > 100.0) {
                            System.out.println("Validation error: Mark must be between 0.0 and 100.0.");
                        } else {
                            marks[count] = mark;
                            count++;
                            System.out.println("Mark recorded successfully. Total marks stored: " + count);
                        }
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No marks recorded yet.");
                    } else {
                        System.out.println("\n--- Recorded Marks (" + count + "/" + MAX_CAPACITY + ") ---");
                        // Indexed for loop when index numbering is needed for reporting
                        for (int i = 0; i < count; i++) {
                            System.out.printf("Student #%02d: %6.2f%n", (i + 1), marks[i]);
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("Cannot calculate statistics: Gradebook is empty.");
                    } else {
                        double sum = 0.0;
                        double highest = marks[0];
                        double lowest = marks[0];

                        // Foreach loop over recorded slice (copying active slice to showcase foreach)
                        double[] activeMarks = new double[count];
                        for (int i = 0; i < count; i++) {
                            activeMarks[i] = marks[i];
                        }

                        for (double m : activeMarks) {
                            sum += m;
                            if (m > highest) {
                                highest = m;
                            }
                            if (m < lowest) {
                                lowest = m;
                            }
                        }

                        double average = sum / count;

                        System.out.println("\n--- Gradebook Statistics ---");
                        System.out.println("Total Recorded Marks: " + count);
                        System.out.printf("Class Average: %6.2f%n", average);
                        System.out.printf("Highest Mark : %6.2f%n", highest);
                        System.out.printf("Lowest Mark  : %6.2f%n", lowest);
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No marks available to grade.");
                    } else {
                        System.out.println("\n--- Letter Grade Conversion ---");
                        // Chained if-else if for continuous numeric ranges
                        for (int i = 0; i < count; i++) {
                            double m = marks[i];
                            char letterGrade;

                            if (m >= 90.0) {
                                letterGrade = 'A';
                            } else if (m >= 80.0) {
                                letterGrade = 'B';
                            } else if (m >= 70.0) {
                                letterGrade = 'C';
                            } else if (m >= 60.0) {
                                letterGrade = 'D';
                            } else {
                                letterGrade = 'F';
                            }

                            System.out.printf("Student #%02d: %6.2f -> Grade %c%n", (i + 1), m, letterGrade);
                        }
                    }
                    break;

                case 0:
                    System.out.println("Exiting Gradebook system. Goodbye.");
                    running = false;
                    break;

                default:
                    System.out.println("Unrecognized menu option. Please select 0 through 4.");
                    break;
            }
        }

        scanner.close();
    }
}
