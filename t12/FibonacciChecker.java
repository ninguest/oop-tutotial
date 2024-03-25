import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FibonacciChecker {
    public static void main(String[] args) {
        checkFibonacciSequence("fibonacci.txt");
    }

    private static void checkFibonacciSequence(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            int totalNumbers = Integer.parseInt(line);
            long a = 0, b = 1;
            for (int i = 0; i < totalNumbers; i++) {
                line = reader.readLine();
                long num = Long.parseLong(line);
                if (num != a) {
                    System.out.println("Incorrect Fibonacci sequence detected!");
                    return;
                }
                long sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println("Fibonacci sequence is correct.");
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error occurred while reading file: " + e.getMessage());
        }
    }
}
