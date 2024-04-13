import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FibonacciChecker {
    private List<BigInteger> sequence;

    public FibonacciChecker() {
        sequence = new ArrayList<>();
    }

    public void readFibonacciSequence(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sequence.add(new BigInteger(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in file: " + e.getMessage());
        }
    }

    public boolean checkFibonacciSequence() {

        if (sequence.isEmpty()) {
            return false;
        }

        if (sequence.size() < 3) {
            return false;
        }

        for (int i = 2; i < sequence.size(); i++) {
            if (!sequence.get(i).equals(sequence.get(i - 1).add(sequence.get(i - 2)))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        FibonacciChecker checker = new FibonacciChecker();
        checker.readFibonacciSequence("fibonacci.txt");

        if (checker.checkFibonacciSequence()) {
            System.out.println("The sequence is a valid Fibonacci sequence.");
        } else {
            System.out.println("The sequence is not a valid Fibonacci sequence.");
        }
    }
}