package main_code.java;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Numbers {

    public static int _min(int[] numbers) {
        return Arrays.stream(numbers).min().orElseThrow();
    }

    public static int _max(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow();
    }

    public static int _sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static long _mult(int[] numbers) {
        long result = 1;
        for (int number : numbers) {
            result *= number;
        }
        return result;
    }

    public static int[] getNums(String path) throws IOException {
        String a = new String(Files.readAllBytes(Paths.get(path)));
        return Arrays.stream(a.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) throws IOException {
        String path = "src/main_code/data/nums.txt";
        int[] nums = getNums(path);
        System.out.println("Min: " + _min(nums));
        System.out.println("Max: " + _max(nums));
        System.out.println("Summa: " + _sum(nums));
        System.out.println("Multiplication: " + _mult(nums));
    }
}
