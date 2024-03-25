import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FibonacciGenerator {
    public static void main(String[] args) {
        generateFibonacciSequence(1000);
    }

    private static void generateFibonacciSequence(int n) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("fibonacci.txt"))) {
            writer.write(String.valueOf(n) + "\n");
            long a = 0, b = 1;
            for (int i = 0; i < n; i++) {
                writer.write(a + "\n");
                long sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println("Fibonacci sequence generated successfully.");
        } catch (IOException e) {
            System.err.println("Error occurred while writing to file: " + e.getMessage());
        }
    }
}
