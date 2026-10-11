import java.util.Arrays;

public class ArrayToolkit {

    public static int max(int[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Signal buffer must not be null or empty.");
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
            throw new IllegalArgumentException("Signal buffer must not be null or empty.");
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
            throw new IllegalArgumentException("Signal buffer must not be null or empty.");
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
                break; // already sorted
            }
        }
    }

    // Friendly ASCII audio bar visualizer
    public static void renderWaveform(String label, int[] samples) {
        System.out.println("\n--- " + label + " ---");
        if (samples == null || samples.length == 0) {
            System.out.println("Empty signal buffer.");
            return;
        }
        for (int i = 0; i < samples.length; i++) {
            int val = samples[i];
            int barsCount = Math.max(0, val / 10);
            StringBuilder bar = new StringBuilder();
            for (int b = 0; b < barsCount; b++) {
                bar.append("#");
            }
            System.out.printf("Sample [%02d] : %3d dB | %-10s%n", (i + 1), val, bar.toString());
        }
    }

    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("   Digital Audio & Sensor Waveform Analyzer      ");
        System.out.println("=================================================");

        // Simulated sound levels recorded in decibels (dB)
        int[] rawAudioSignal = {42, 17, 89, 5, 23, 68, 12};

        renderWaveform("Raw Audio Waveform Track", rawAudioSignal);

        System.out.println("\n--- Signal Analytics ---");
        System.out.println("Peak Amplitude (Max)   : " + max(rawAudioSignal) + " dB");
        System.out.println("Noise Floor (Min)      : " + min(rawAudioSignal) + " dB");
        System.out.printf("Mean Sound Level (Avg) : %.2f dB%n", average(rawAudioSignal));
        System.out.println("Frequency Target (23)  : Found at index " + indexOf(rawAudioSignal, 23));
        System.out.println("Frequency Target (99)  : " + (indexOf(rawAudioSignal, 99) == -1 ? "Not found (-1)" : "Found"));

        // Reverse audio effect (time inversion)
        int[] reversedSignal = reverse(rawAudioSignal);
        renderWaveform("Time-Inverted Audio Track (Reversed)", reversedSignal);

        // Reference Aliasing vs Deep Heap Copy Demonstration
        System.out.println("\n--- Memory Mechanics: Aliasing vs Deep Copy ---");
        int[] alias = rawAudioSignal; // only copies memory address pointer
        int[] cleanBackup = copy(rawAudioSignal); // allocates new array on the heap

        alias[0] = 999; // mutate via alias
        System.out.println("Mutating alias[0] to 999 dB:");
        System.out.println("Original rawAudioSignal[0] : " + rawAudioSignal[0] + " dB (corrupted by alias!)");
        System.out.println("Independent cleanBackup[0] : " + cleanBackup[0] + " dB (protected deep copy)");

        // Sort audio frequencies in ascending order
        System.out.println("\n--- Waveform Sorting ---");
        int[] sortedSpectrum = copy(cleanBackup);
        bubbleSort(sortedSpectrum);
        renderWaveform("Sorted Audio Spectrum", sortedSpectrum);

        // Default value demonstration
        System.out.println("\n--- Java Default Memory Initialization Audit ---");
        int[] uninitializedInts = new int[4];
        boolean[] uninitializedBools = new boolean[4];
        String[] uninitializedStrings = new String[5];

        System.out.println("Default int[]      : " + Arrays.toString(uninitializedInts) + " (zeroes)");
        System.out.println("Default boolean[]  : " + Arrays.toString(uninitializedBools) + " (false)");
        System.out.println("Default String[]   : " + Arrays.toString(uninitializedStrings) + " (null pointers)");

        // ==============================================================
        // TODO: Practice Challenge For You
        // 1. Implement normalize(int[] a, int maxLimit): scales all samples so peak equals maxLimit.
        // 2. Implement countPeaks(int[] a, int threshold): counts how many samples exceed a cutoff.
        // ==============================================================
    }
}
