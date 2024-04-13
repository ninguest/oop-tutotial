
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class All {

    //====================================================================================================
    // Normal Calculation
    //====================================================================================================

    public class Calculation{

        public double addition(double a, double b){
            return a + b;
        }

        public double subtraction(double a, double b){
            return a - b;
        }

        public double multiplication(double a, double b){
            return a * b;
        }

        public double division(double a, double b){
            if(b != 0){
                return a / b;
            }else{
                return 0;
            }
        }

        public void printTestResult(){
            System.out.println("Test Result : ");
            System.out.println("Addition : " + String.format("%.2f", addition(6.66, 9.99)));
            System.out.println("Subtraction : " + String.format("%.2f", subtraction(6.66, 9.99)));
            System.out.println("Multiplication : " + String.format("%.2f", multiplication(6.66, 9.99)));
            System.out.println("Division : " + String.format("%.2f", division(6.66, 9.99)));
        }
    }

    //====================================================================================================
    // Personal Exception Handling
    //====================================================================================================

    public class PersonalExceptionHandling{
        public static void readFile(String fileName){
            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (FileNotFoundException e) {
                System.err.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
            }
        }

        public static int divideWithException(int numerator, int denominator){
            try {
                return numerator / denominator;
            } catch (ArithmeticException e) {
                System.err.println("Arithmetic Exception: " + e.getMessage());
                return 0;
            }
        }

        public static int readIntegerFromUser(){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter an integer: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Input Mismatch Exception: " + e.getMessage());
                return 0;
            }
        }

        public static void accessArrayElement(int[] array, int index){
            try {
                System.out.println("Array element at index " + index + ": " + array[index]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Array Index Out of Bounds Exception: " + e.getMessage());
            }
        }

        public static void throwException() throws Exception {
            throw new Exception("This is a custom exception message.");
        }

        public static void catchException() {
            try {
                throwException();
            } catch (Exception e) {
                System.err.println("Caught exception: " + e.getMessage());
            }
        }

        public static void nullPointerException() {
            String str = null;
            try {
                System.out.println(str.length());
            } catch (NullPointerException e) {
                System.err.println("Null Pointer Exception: " + e.getMessage());
            }
        }

        public void printTestResult(){
            System.out.println("Test Result : ");
            readFile("example.txt");
            System.out.println("Result of division: " + divideWithException(10, 0));
            int userInput = readIntegerFromUser();
            System.out.println("User input: " + userInput);
            int[] array = {1, 2, 3};
            accessArrayElement(array, 5);
            catchException();
            nullPointerException();
        }
    }

    //====================================================================================================
    // ATM Console Menu (threading)
    //====================================================================================================

    public class ATMConsoleMenu {

        private static final int WELCOME_SCREEN_WARNING = 10000; // 10 seconds in milliseconds
        private static final int WELCOME_SCREEN_TIMEOUT = 20000; // 20 seconds in milliseconds
        private static volatile boolean userInputReceived = false;
    
        public static void runATMMenu() {
            System.out.println("Welcome to the ATM!");
    
            Thread inputThread = new Thread(() -> getUserInput());
            inputThread.start();
    
            // Display the main menu
            displayMenu();
    
            // Wait for the input thread to finish or warning
            try {
                inputThread.join(WELCOME_SCREEN_WARNING);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            // If the user didn't input anything in 10 seconds, send a warning message
            if (!userInputReceived) {
                System.out.println("\nThe system will be exited after 20 seconds if no input is made.");
            }
    
            try {
                inputThread.join(WELCOME_SCREEN_TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    
            // If the user still didn't input anything in 20 seconds, exit program
            if (!userInputReceived) {
                System.out.println("\nExiting system...");
                System.exit(0);
            }
        }
    
        private static void displayMenu() {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
        }
    
        private static void getUserInput() {
            Scanner scanner = new Scanner(System.in);
            userInputReceived = false;
    
            System.out.print("\nEnter your choice: ");
            String userInput = scanner.nextLine();
    
            // Set the flag to indicate that user input has been received
            userInputReceived = true;
    
            // Process user input (you can add more logic here)
            switch (userInput) {
                case "1":
                    System.out.println("Checking Balance...");
                    break;
                case "2":
                    System.out.println("Withdrawing Money...");
                    break;
                case "3":
                    System.out.println("Depositing Money...");
                    break;
                case "4":
                    System.out.println("Exiting ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    //====================================================================================================
    // Calculator GUI
    //====================================================================================================

    public class Calculator extends JFrame {
        private JTextField textFieldA;
        private JTextField textFieldB;
        private JComboBox<String> operationComboBox;
        private JLabel resultLabel;
    
        public void CalculatorGUI() {
            setTitle("Calculator");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(5, 10, 5, 10); // Add insets for spacing
    
            // Text fields for input
            panel.add(new JLabel("Variable A:"), gbc);
            gbc.gridx = 1;
            textFieldA = new JTextField(10);
            panel.add(textFieldA, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 1;
            panel.add(new JLabel("Variable B:"), gbc);
            gbc.gridx = 1;
            textFieldB = new JTextField(10);
            panel.add(textFieldB, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 2;
            panel.add(new JLabel("Operation:"), gbc);
            gbc.gridx = 1;
            String[] operations = {"Addition", "Subtraction", "Multiplication", "Division"};
            operationComboBox = new JComboBox<>(operations);
            panel.add(operationComboBox, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2; // Span across two columns
            gbc.fill = GridBagConstraints.HORIZONTAL; // Expand horizontally
            gbc.anchor = GridBagConstraints.CENTER; // Center alignment
            JButton calculateButton = new JButton("Calculate");
            panel.add(calculateButton, gbc);
    
            gbc.gridx = 0;
            gbc.gridy = 4;
            panel.add(new JLabel("Result:"), gbc);
            gbc.gridx = 1;
            resultLabel = new JLabel();
            resultLabel.setBorder(BorderFactory.createEtchedBorder()); // Add border for style
            panel.add(resultLabel, gbc);
    
            // Add ActionListener for the calculateButton
            calculateButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    calculate();
                }
            });
    
            add(panel);
            setSize(400, 250); // Set the size of the window
            setLocationRelativeTo(null); // Center the window on the screen
            setVisible(true);
        }
    
        // Method to perform calculation and update the result label
        private void calculate() {
            try {
                double a = Double.parseDouble(textFieldA.getText());
                double b = Double.parseDouble(textFieldB.getText());
                String operation = (String) operationComboBox.getSelectedItem();
                double result = 0;
    
                switch (operation) {
                    case "Addition":
                        result = a + b;
                        break;
                    case "Subtraction":
                        result = a - b;
                        break;
                    case "Multiplication":
                        result = a * b;
                        break;
                    case "Division":
                        if (b != 0) {
                            result = a / b;
                        } else {
                            JOptionPane.showMessageDialog(this, "Division by zero is not allowed.");
                        }
                        break;
                }
    
                resultLabel.setText(String.format("%.2f", result)); // Display result with two decimal places
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.");
            }
        }
    
    }

    //====================================================================================================
    // Vehicle Class Hierarchy
    //====================================================================================================

    public class Vehicle{
        // Attributes
        private String make;
        private String model;
        private int year;
        private double price;

        // Constructor
        public Vehicle(String make, String model, int year, double price){
            this.make = make;
            this.model = model;
            this.year = year;
            this.price = price;
        }

        // Getters and Setters
        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    
    }

    public class Car extends Vehicle{
        // Attributes
        private int numDoors;
        private int numSeats;
        
        // Constructor
        public Car(String make, String model, int year, double price, int numDoors, int numSeats){
            super(make, model, year, price);
            this.numDoors = numDoors;
            this.numSeats = numSeats;
        }

        // Getters and Setters
        public int getNumDoors() {
            return numDoors;
        }

        public void setNumDoors(int numDoors) {
            this.numDoors = numDoors;
        }

        public int getNumSeats() {
            return numSeats;
        }

        public void setNumSeats(int numSeats) {
            this.numSeats = numSeats;
        }

    }

    public class Truck extends Vehicle{
        // Attributes
        private double loadCapacity;
        private int numWheels;
        
        // Constructor
        public Truck(String make, String model, int year, double price, double loadCapacity, int numWheels){
            super(make, model, year, price);
            this.loadCapacity = loadCapacity;
            this.numWheels = numWheels;
        }

        // Getters and Setters

        public double getLoadCapacity() {
            return loadCapacity;
        }

        public void setLoadCapacity(double loadCapacity) {
            this.loadCapacity = loadCapacity;
        }

        public int getNumWheels() {
            return numWheels;
        }

        public void setNumWheels(int numWheels) {
            this.numWheels = numWheels;
        }
    }

    public class Motorcycle extends Vehicle{
        // Attributes
        private String type;
        private int engineSize;

        // Constructor
        public Motorcycle(String make, String model, int year, double price, String type, int engineSize){
            super(make, model, year, price);
            this.type = type;
            this.engineSize = engineSize;
        }

        // Getters and Setters
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getEngineSize() {
            return engineSize;
        }

        public void setEngineSize(int engineSize) {
            this.engineSize = engineSize;
        }
    }

    //====================================================================================================
    // IO Method
    //====================================================================================================

    // CSV Cleaner for Bank Data
    public class DataCleaner{
        public void cleanNow(){
            String readPath = "./bank_data.csv";
            String writePath = "./output_bank_data.csv";
            String oneLine = "";

            // Q3: The total execution time required to complete the task
            long startTime = System.currentTimeMillis();

            try {
                // Initialize the BufferedReader and BufferedWriter object
                BufferedReader reader = new BufferedReader(new FileReader(readPath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(writePath));

                // Map to store month abbreviations and their corresponding numbers
                Map<String, String> monthMap = new HashMap<>();
                monthMap.put("-Jan-", "/01/");
                monthMap.put("-Feb-", "/02/");
                monthMap.put("-Mar-", "/03/");
                monthMap.put("-Apr-", "/04/");
                monthMap.put("-May-", "/05/");
                monthMap.put("-Jun-", "/06/");
                monthMap.put("-Jul-", "/07/");
                monthMap.put("-Aug-", "/08/");
                monthMap.put("-Sep-", "/09/");
                monthMap.put("-Oct-", "/10/");
                monthMap.put("-Nov-", "/11/");
                monthMap.put("-Dec-", "/12/");
                
                // First Line
                oneLine = reader.readLine();
                writer.write(oneLine);
                writer.newLine();

                while ((oneLine = reader.readLine()) != null){

                    // Replace multiple commas and single quotes with a single comma
                    oneLine = oneLine.replaceAll(",,", ",");
                    oneLine = oneLine.replaceAll("',", ",");

                    // Replace month abbreviations with their corresponding numbers
                    for (Map.Entry<String, String> entry : monthMap.entrySet()) {
                        oneLine = oneLine.replaceAll(entry.getKey(), entry.getValue());
                    }

                    // Split the string with "
                    String[] parts = oneLine.split("\"");

                    // Remove commas from the amount fields 
                    String target = parts[1];
                    String result = target.replaceAll(",", "");
                    oneLine = oneLine.replace(target, result);

                    if (parts.length > 3){
                        target = parts[3];
                        result = target.replaceAll(",", "");
                        oneLine = oneLine.replace(target, result);
                    }
                
                    writer.write(oneLine);
                    writer.newLine();
                }

                // Close the BufferedReader and BufferedWriter object
                reader.close();
                writer.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            // End timing
            long endTime = System.currentTimeMillis();

            // Calculate execution time
            long executionTime = endTime - startTime;
            System.out.println("Question 2 execution time: " + executionTime + " ms");
        }
    }
    
    //====================================================================================================
    // Inheritance and Polymorphism
    //====================================================================================================

    abstract class Shape {
        abstract double calculateArea();
    }
    
    class Circle extends Shape {
        private double radius;
        
        @Override
        double calculateArea() {
            return Math.PI * radius * radius;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }
    
    class Rectangle extends Shape {
        private double length;
        private double width;
        
        @Override
        double calculateArea() {
            return length * width;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

    }
    

    //====================================================================================================
    // Fibonacci Sequence
    //====================================================================================================

    public class FibonacciSequence {
        public static int fibonacci(int n) {
            if (n <= 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }

        // fibonacci sequence without recursion
        public static int fibonacciIterative(int n) {
            if (n <= 1) {
                return n;
            }
            int fib = 1;
            int prevFib = 1;
            for (int i = 2; i < n; i++) {
                int temp = fib;
                fib += prevFib;
                prevFib = temp;
            }
            return fib;
        }

        // generate Fibonacci sequence and store in file
        public void generateFibonacciSequence(int n, String fileName) {
            try (
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))
            ) {
                for (int i = 0; i < n; i++) {
                    writer.write(fibonacci(i) + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // read Fibonacci sequence from file and check if the sequence is correct
        public void readFibonacciSequence(String fileName) {
            try (
                BufferedReader reader = new BufferedReader(new FileReader(fileName))
            ) {
                int n = 0;
                String line;
                while ((line = reader.readLine()) != null) {
                    int fib = fibonacci(n);
                    if (Integer.parseInt(line) != fib) {
                        System.out.println("Error: Fibonacci sequence is incorrect.");
                        return;
                    }
                    n++;
                }
                System.out.println("Fibonacci sequence is correct.");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format in file.");
            }
        }

        // find the sum of the first n Fibonacci numbers
        public int sumFibonacci(int n) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += fibonacci(i);
            }
            return sum;
        }
    }

    public static void main(String[] args) {

        All all = new All();

        // Calculation
        Calculation calculation = all.new Calculation();
        calculation.printTestResult();

        // Personal Exception Handling
        PersonalExceptionHandling personalExceptionHandling = all.new PersonalExceptionHandling();
        personalExceptionHandling.printTestResult();

        // Data Cleaner (IO)
        // DataCleaner dataCleaner = all.new DataCleaner();
        // dataCleaner.cleanNow();

        // Inheritance and Polymorphism (Shape)
        Circle circle = all.new Circle();
        circle.setRadius(5);
        System.out.println("Circle Area: " + circle.calculateArea());

        Rectangle rectangle = all.new Rectangle();
        rectangle.setLength(5);
        rectangle.setWidth(10);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());


        // Show GUI
        //SwingUtilities.invokeLater(() -> all.new Calculator().CalculatorGUI());

        // Fibonacci Sequence
        FibonacciSequence fibonacciSequence = all.new FibonacciSequence();
        fibonacciSequence.generateFibonacciSequence(25, "fibonacci.txt");
        fibonacciSequence.readFibonacciSequence("fibonacci.txt");
        System.out.println("Sum of first 20 Fibonacci numbers: " + fibonacciSequence.sumFibonacci(20));
        System.out.println(FibonacciSequence.fibonacciIterative(20));
    }
    
}