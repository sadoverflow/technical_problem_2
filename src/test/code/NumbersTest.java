package test.code;
import main_code.java.Numbers;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class NumbersTest {

    @Test
    public void testMin() {
        int[] nums = {1, 4, 2, 3};
        assertEquals(1, Numbers._min(nums));
    }

    @Test
    public void testMax() {
        int[] nums = {1, 4, 2, 3};
        assertEquals(4, Numbers._max(nums));
    }

    @Test
    public void testSum() {
        int[] nums = {1, 4, 2, 3};
        assertEquals(10, Numbers._sum(nums));
    }

    @Test
    public void testMult() {
        int[] nums = {1, 4, 2, 3};
        assertEquals(24, Numbers._mult(nums));
    }

    @Test
    public void testReadNumbers() throws IOException {
        int[] expNums = {1, 2, 3, 4, 5};
        String path = "src/main_code/data/test.txt";
        Files.write(Paths.get(path), "1 2 3 4 5".getBytes());

        int[] actNums = Numbers.getNums(path);
        assertArrayEquals(expNums, actNums);
    }

    @Test
    public void testPerformance() throws IOException {
        int[] nums = Numbers.getNums("src/main_code/data/nums.txt");

        long st = System.nanoTime();
        Numbers._min(nums);
        long et = System.nanoTime();
        System.out.println("Min: " + (et - st) + " ns");

        st = System.nanoTime();
        Numbers._max(nums);
        et = System.nanoTime();
        System.out.println("Max: " + (et - st) + " ns");

        st = System.nanoTime();
        Numbers._sum(nums);
        et = System.nanoTime();
        System.out.println("Sum: " + (et - st) + " ns");

        st = System.nanoTime();
        Numbers._mult(nums);
        et = System.nanoTime();
        System.out.println("Mult: " + (et - st) + " ns");
    }
}
