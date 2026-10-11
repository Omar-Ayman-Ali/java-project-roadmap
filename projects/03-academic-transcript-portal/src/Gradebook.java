import java.util.Scanner;

public class Gradebook {
    private static final int MAX_COURSES = 30;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] grades = new double[MAX_COURSES];
        String[] courseNames = new String[MAX_COURSES];
        int count = 0;
        boolean running = true;

        System.out.println("=================================================");
        System.out.println("      Student Academic Transcript & Portal       ");
        System.out.println("=================================================");
        System.out.println("Welcome to the Semester Gradebook & Honors Portal.");

        // Pre-populate with two sample courses for instant exploration
        courseNames[count] = "Introduction to Programming";
        grades[count] = 92.5;
        count++;

        courseNames[count] = "Discrete Mathematics";
        grades[count] = 78.0;
        count++;

        while (running) {
            System.out.println("\n--- Portal Navigation Menu ---");
            System.out.println("1. Add Course Grade");
            System.out.println("2. Display Academic Transcript");
            System.out.println("3. Compute Performance Statistics (Average, Min, Max)");
            System.out.println("4. Generate Letter Grades & Honors Standing");
            System.out.println("5. Filter Passing Courses Only (Score >= 50.0)");
            System.out.println("0. Exit Portal");
            System.out.print("Please choose an option (0-5): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a menu number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline token

            switch (choice) {
                case 1:
                    if (count >= MAX_COURSES) {
                        System.out.println("Capacity full! You cannot record more than " + MAX_COURSES + " courses.");
                        break;
                    }
                    System.out.print("Enter course name (e.g. Object Oriented Programming): ");
                    String name = scanner.nextLine().trim();
                    if (name.isEmpty()) {
                        name = "Course #" + (count + 1);
                    }

                    System.out.print("Enter final numerical score (0.0 to 100.0): ");
                    if (!scanner.hasNextDouble()) {
                        System.out.println("Invalid score. Must be a numeric value.");
                        scanner.next();
                        break;
                    }
                    double score = scanner.nextDouble();

                    if (score < 0.0 || score > 100.0) {
                        System.out.println("Validation Error: Score must be between 0.0 and 100.0.");
                    } else {
                        courseNames[count] = name;
                        grades[count] = score;
                        count++;
                        System.out.println("Course added successfully! Total courses enrolled: " + count);
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No course grades on record yet.");
                    } else {
                        System.out.println("\n--- Academic Transcript (" + count + "/" + MAX_COURSES + ") ---");
                        // Indexed for loop when index numbering is needed
                        for (int i = 0; i < count; i++) {
                            System.out.printf("[%02d] %-32s : %6.2f%n", (i + 1), courseNames[i], grades[i]);
                        }
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("Cannot calculate statistics: Transcript is empty.");
                    } else {
                        double sum = 0.0;
                        double highest = grades[0];
                        double lowest = grades[0];
                        int passingCount = 0;

                        // Create an active slice array to demonstrate the enhanced for loop (foreach)
                        double[] activeGrades = new double[count];
                        for (int i = 0; i < count; i++) {
                            activeGrades[i] = grades[i];
                        }

                        for (double g : activeGrades) {
                            sum += g;
                            if (g > highest) {
                                highest = g;
                            }
                            if (g < lowest) {
                                lowest = g;
                            }
                            if (g >= 50.0) {
                                passingCount++;
                            }
                        }

                        double average = sum / count;
                        double passRate = ((double) passingCount / count) * 100.0;

                        System.out.println("\n--- Academic Performance Summary ---");
                        System.out.println("Total Courses Evaluated : " + count);
                        System.out.printf("Cumulative Average      : %6.2f%n", average);
                        System.out.printf("Highest Scoring Grade   : %6.2f%n", highest);
                        System.out.printf("Lowest Scoring Grade    : %6.2f%n", lowest);
                        System.out.printf("Passing Success Rate    : %6.1f%% (%d/%d courses)%n", passRate, passingCount, count);
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No courses on record to classify.");
                    } else {
                        System.out.println("\n--- Letter Grades & Academic Standing ---");
                        // Chained if-else if structure for score ranges
                        for (int i = 0; i < count; i++) {
                            double g = grades[i];
                            char letter;
                            String standing;

                            if (g >= 90.0) {
                                letter = 'A';
                                standing = "Excellent / High Honors";
                            } else if (g >= 80.0) {
                                letter = 'B';
                                standing = "Very Good / Honors";
                            } else if (g >= 70.0) {
                                letter = 'C';
                                standing = "Good Standing";
                            } else if (g >= 60.0) {
                                letter = 'D';
                                standing = "Satisfactory Pass";
                            } else {
                                letter = 'F';
                                standing = "Academic Review Needed";
                            }

                            System.out.printf("[%02d] %-28s : %6.2f -> [%c] (%s)%n",
                                    (i + 1), courseNames[i], g, letter, standing);
                        }
                    }
                    break;

                case 5:
                    if (count == 0) {
                        System.out.println("No courses on record to filter.");
                    } else {
                        System.out.println("\n--- Passed Courses Filter (Score >= 50.0) ---");
                        int passedCount = 0;
                        for (int i = 0; i < count; i++) {
                            if (grades[i] >= 50.0) {
                                System.out.printf("PASS: %-32s (%6.2f)%n", courseNames[i], grades[i]);
                                passedCount++;
                            }
                        }
                        System.out.println("Total passed courses: " + passedCount + " out of " + count);
                    }
                    break;

                case 0:
                    System.out.println("Thank you for using the Academic Portal. Have a great semester!");
                    running = false;
                    break;

                default:
                    System.out.println("Option out of range. Please choose between 0 and 5.");
                    break;
            }

            // ==============================================================
            // TODO: Practice Challenge For You
            // 1. Add credit hours support (e.g. 3 credits per course).
            // 2. Compute a real 4.0 GPA: A=4.0, B=3.0, C=2.0, D=1.0, F=0.0.
            // ==============================================================
        }

        scanner.close();
    }
}
