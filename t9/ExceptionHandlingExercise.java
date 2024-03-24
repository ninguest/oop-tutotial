// TODO: Import related library, including Exception handling

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingExercise {

    // TODO: Implement proper exception handling for the operations in this program
    public static void main(String[] args) {

        // Exercise 1: Handle File Operations
        // Call the readFile method with the appropriate file name
        readFile("example.txt");

        // Exercise 2: Handle Arithmetic Exception
        // Call the divide method with suitable values
        int result = divide(10, 0);
        System.out.println("Result: " + result);

        // Exercise 3: Handle Input Mismatch Exception
        // Call the readIntegerFromUser method
        int userInput = readIntegerFromUser();
        System.out.println("User input: " + userInput);

        // Exercise 4: Handle Array Index Out of Bounds Exception
        // Call the accessArrayElement method with suitable values
        int[] array = {1, 2, 3, 4, 5};
        accessArrayElement(array, 5);

        // Extra 1: Handle NullPointerException
        // Call the checkNull method with suitable values
        checkNull(null);

        // Extra 2: Handle ClassCastException
        // Call the castObject method with suitable values
        castObject(10);

        // Extra 3: Handle ArrayStoreException
        // Call the storeInArray method with suitable values
        Object[] objArray = new String[5];
        storeInArray(objArray);

        // Extra 4: Handle Throwable
        // Call the throwException method
        throwException();

        // Extra 5: Handle Exception
        // Call the throwCustomException method
        throwCustomException(); 
    }

    // Exercise 1: Implement a method to read from a file and handle potential exceptions
    // FileNotFoundException, IOException
    private static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    // Exercise 2: Implement a method to perform division and handle potential exceptions
    // ArithmeticException (Division by zero)
    private static int divide(int numerator, int denominator) {
        try {
            return numerator / denominator;

        } catch (ArithmeticException e) {
            System.err.println("Error: Division by zero");
            return 0; // Provide a default value or handle the error accordingly
        }
    }

    // Exercise 3: Example - Method to read an integer from user input and handle input mismatch exception
    // InputMismatchException (NumberFormatException)
    private static int readIntegerFromUser() {
        try (Scanner scanner = new Scanner(System.in);){
            System.out.print("Enter an integer: ");
            return scanner.nextInt(); // integer input
            // scanner.next() for String input
            // scanner.nextDouble() for double input
        } catch (InputMismatchException | NumberFormatException e) {
            System.err.println("Input mismatch: "+ e.getMessage());
            return 0; // Provide a default value or handle the error accordingly
        }
    }

    // Exercise 4: Example - Method to access an array element and handle index out of bounds exception
    // IndexOutOfBoundsException (ArrayIndexOutOfBoundsException)
    private static void accessArrayElement(int[] array, int index) {
        try {
            System.out.println("Array element at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Array index out of bounds" + e.getMessage());
        }
    }

    // Extra 1 : Handle NullPointerException 
    // NullPointerException   
    private static void checkNull(String str) {
        try {
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.err.println("Error: Null pointer exception");
        }
    }

    // Extra 2 : Handle ClassCastException
    // ClassCastException
    private static void castObject(Object obj) {
        try {
            String str = (String) obj;
            System.out.println(str);
        } catch (ClassCastException e) {
            System.err.println("Error: Class cast exception");
        }
    }

    // Extra 3 : Handle ArrayStoreException
    // ArrayStoreException
    private static void storeInArray(Object[] array) {
        try {
            array[0] = Integer.valueOf(10);
        } catch (ArrayStoreException e) {
            System.err.println("Error: Array store exception");
        }
    }

    // Extra 4 : Handle Throwable
    // Throwable
    private static void throwException() {
        try {
            throw new Throwable("Custom Throwable Exception");
        } catch (Throwable e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Extra 5 : Handle Exception
    // Exception
    private static void throwCustomException() {
        try {
            throw new Exception("Custom Exception");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
