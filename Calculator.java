/**
 * Calculator Application
 * This program creates a calculator with a graphical user interface (GUI).
 * It can perform arithmetic operations such as addition, subtraction, multiplication, and division.
 * The calculator also includes functionality for handling decimal numbers, negative numbers, clearing the input,
 * and deleting the last character entered.
 */

 import javax.swing.*;

 public class Calculator {
     public static void main(String[] args) {
         SwingUtilities.invokeLater(() -> {
             JFrame frame = new JFrame("Calculator");
             frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
             frame.setSize(300, 400); // Set the size of the frame to make it narrower
 
             CalculatorPanel panel = new CalculatorPanel();
             frame.add(panel);
 
             frame.setVisible(true); // Make the frame visible
         });
     }
 }
 