import java.util.Arrays;

public class ArrayToolkit {

    public static int max(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        int maximum = a[0];
        for (int value : a) {
            if (value > maximum) {
                maximum = value;
            }
        }
        return maximum;
    }

    public static int min(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        int minimum = a[0];
        for (int value : a) {
            if (value < minimum) {
                minimum = value;
            }
        }
        return minimum;
    }

    public static double average(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty.");
        }
        long sum = 0;
        for (int value : a) {
            sum += value;
        }
        return (double) sum / a.length;
    }

    public static int[] reverse(int[] a) {
        if (a == null) {
            return null;
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    public static int indexOf(int[] a, int target) {
        if (a == null) {
            return -1;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int[] copy(int[] a) {
        if (a == null) {
            return null;
        }
        int[] clone = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            clone[i] = a[i];
        }
        return clone;
    }

    public static void bubbleSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break; // array is sorted
            }
        }
    }

    public static void printArray(String label, int[] a) {
        System.out.println(label + ": " + Arrays.toString(a));
    }

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("         Array Toolkit Test Driver       ");
        System.out.println("=========================================");

        int[] sample = {42, 17, 89, 5, 23, 68, 12};
        printArray("Initial array", sample);

        System.out.println("Maximum: " + max(sample));
        System.out.println("Minimum: " + min(sample));
        System.out.printf("Average: %.2f%n", average(sample));
        System.out.println("Index of 23: " + indexOf(sample, 23));
        System.out.println("Index of 99: " + indexOf(sample, 99));

        int[] reversed = reverse(sample);
        printArray("Reversed (new array)", reversed);
        printArray("Original untouched", sample);

        // Reference semantics demonstration
        System.out.println("\n--- Reference Semantics vs Deep Copy ---");
        int[] alias = sample; // copies memory reference, not underlying array
        int[] cloned = copy(sample); // independent heap allocation

        alias[0] = 999;
        System.out.println("Mutated alias[0] to 999:");
        System.out.println("sample[0] after alias mutation : " + sample[0] + " (aliased)");
        System.out.println("cloned[0] after alias mutation : " + cloned[0] + " (isolated deep copy)");

        // Bubble sort demonstration
        System.out.println("\n--- Bubble Sort Demonstration ---");
        int[] numbersToSort = {64, 34, 25, 12, 22, 11, 90};
        printArray("Before sort", numbersToSort);
        bubbleSort(numbersToSort);
        printArray("After bubbleSort", numbersToSort);

        // Default values demonstration
        System.out.println("\n--- Array Default Values Demonstration ---");
        int[] defaultInts = new int[4];
        boolean[] defaultBools = new boolean[4];
        String[] defaultStrings = new String[5];

        System.out.println("Default int[]      : " + Arrays.toString(defaultInts));
        System.out.println("Default boolean[]  : " + Arrays.toString(defaultBools));
        System.out.println("Default String[]   : " + Arrays.toString(defaultStrings));
    }
}
