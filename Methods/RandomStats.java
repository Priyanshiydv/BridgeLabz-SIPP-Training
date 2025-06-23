import java.util.Arrays;

public class RandomStats {

    public static int[] generate4DigitRandomArray(int size) {
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = (int)(Math.random() * 9000) + 1000; // Range: 1000–9999
        }
        return numbers;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        double average = sum / (double) numbers.length;
        return new double[]{average, min, max};
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        System.out.println("Generated 4-digit numbers: " + Arrays.toString(randomNumbers));

        double[] results = findAverageMinMax(randomNumbers);
        System.out.printf("Average: %.2f\nMinimum: %.0f\nMaximum: %.0f\n", results[0], results[1], results[2]);
    }
}
