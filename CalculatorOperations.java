import javax.swing.JTextField;

/**
 * CalculatorOperations
 * 
 * A class to handle arithmetic operations and other functionalities of the calculator.
 */
public class CalculatorOperations {
    private JTextField text, text2; // Text fields for displaying input and result
    private double s1 = 0, s2 = -1, result = 0; // Variables to hold the numbers and result
    private char op; // Variable to hold the current operation (+, -, *, /)

    public CalculatorOperations(JTextField text, JTextField text2) {
        this.text = text;
        this.text2 = text2;
    }

    // Handle different button actions
    public void handleCommand(String command) {
        switch (command) {
            case "0": case "1": case "2": case "3": case "4":
            case "5": case "6": case "7": case "8": case "9":
                appendToTextFields(command); // Append the number to both text fields
                break;
            case ".":
                if (!text.getText().contains(".")) appendToTextFields("."); // Append a decimal point if not already present
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                handleOperation(command.charAt(0)); // Handle the arithmetic operation
                break;
            case "=":
                text2.setText(text2.getText() + "="); // Append "=" to the second text field
                operate(); // Perform the calculation
                break;
            case "C":
                clearTextFields(); // Clear both text fields
                break;
            case "back":
                backspace(); // Perform backspace operation
                break;
            case "+/-":
                toggleSign(); // Toggle the sign of the number
                break;
            case "%": 
                percentage(); // Perform the percentage operation
                break;
        }
    }

    // Helper method to append text to both text fields
    private void appendToTextFields(String str) {
        text.setText(text.getText() + str);
        text2.setText(text2.getText() + str);
    }

    // Helper method to handle arithmetic operations
    private void handleOperation(char operation) {
        if (!text.getText().isEmpty()) { // Check if the text field is not empty
            if (s2 == -1) { // If s2 is not yet set
                s1 = Double.parseDouble(text.getText()); // Set s1 to the current number
                text.setText(""); // Clear the text field for the next input
                text2.setText(s1 + String.valueOf(operation)); // Display the operation in the second text field
            } else {
                operate(); // Perform the previous operation
            }
            op = operation; // Set the current operation
        }
    }

    // Helper method to toggle the sign of the current number
    private void toggleSign() {
        String currentText = text.getText();
        if (currentText.isEmpty()) return;
        if (currentText.startsWith("-")) {
            text.setText(currentText.substring(1)); // Remove the negative sign
        } else {
            text.setText("-" + currentText); // Add the negative sign
        }
    }

    // Helper method to perform the arithmetic operation
    private void operate() {
        if (text.getText().isEmpty()) {
            return; // Avoid NumberFormatException if text field is empty
        }

        s2 = Double.parseDouble(text.getText()); // Set s2 to the current number
        switch (op) {
            case '+' -> result = s1 + s2;
            case '-' -> result = s1 - s2;
            case '*' -> result = s1 * s2;
            case '/' -> result = s1 / s2;
        }
        text.setText(String.valueOf(result)); // Display the result in the text field
        s1 = result; // Set s1 to the result for future calculations
        s2 = -1; // Reset s2
    }

    // Helper method to clear both text fields
    private void clearTextFields() {
        text.setText("");
        text2.setText("");
        s1 = 0;
        s2 = -1;
        result = 0;
        op = '\0';
    }

    // Helper method to handle backspace operation
    private void backspace() {
        String currentText = text.getText();
        if (!currentText.isEmpty()) {
            text.setText(currentText.substring(0, currentText.length() - 1)); // Remove the last character
        }
    }
     // Helper method to perform the percentage operation
    private void percentage() {
        if (!text.getText().isEmpty()) {
            double value = Double.parseDouble(text.getText());
            value = value / 100;
            text.setText(String.valueOf(value));
        }
    }
}
