package t11;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JTextField textFieldA, textFieldB;
    private JComboBox<String> operationComboBox;
    private JButton calculateButton;
    private JLabel resultLabel;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        textFieldA = new JTextField(10);
        textFieldB = new JTextField(10);
        operationComboBox = new JComboBox<>(new String[]{"Addition", "Subtraction", "Multiplication", "Division"});
        calculateButton = new JButton("Calculate");
        resultLabel = new JLabel();

        // Set layout
        setLayout(new GridLayout(4, 2));

        // Add components to the frame
        add(new JLabel("a: "));
        add(textFieldA);
        add(new JLabel("b: "));
        add(textFieldB);
        add(new JLabel("Operation: "));
        add(operationComboBox);
        add(calculateButton);
        add(resultLabel);

        // Add action listener to the calculate button
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double a = Double.parseDouble(textFieldA.getText());
                    double b = Double.parseDouble(textFieldB.getText());
                    String operation = (String) operationComboBox.getSelectedItem();
                    double result = 0.0;

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
                            if (b == 0) {
                                throw new ArithmeticException("Division by zero");
                            }
                            result = a / b;
                            break;
                    }

                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Invalid input");
                } catch (ArithmeticException ex) {
                    resultLabel.setText("Error: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }
}
