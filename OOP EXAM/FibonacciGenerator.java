import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

public class FibonacciGenerator {
    private static final int NUMBERS_TO_GENERATE = 1000;

    public void generateFibonacciSequence(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            BigInteger a = BigInteger.ZERO;
            BigInteger b = BigInteger.ONE;

            // writer.write(NUMBERS_TO_GENERATE + "\n");

            for (int i = 0; i < NUMBERS_TO_GENERATE; i++) {
                writer.write(a.toString() + "\n");

                BigInteger temp = a;
                a = b;
                b = b.add(temp);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FibonacciGenerator generator = new FibonacciGenerator();
        generator.generateFibonacciSequence("fibonacci.txt");
    }
}