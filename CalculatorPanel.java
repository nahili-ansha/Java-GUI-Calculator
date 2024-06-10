import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorPanel extends JPanel implements ActionListener {
    private JTextField text, text2;
    private CalculatorOperations operations;

    public CalculatorPanel() {
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(); // Panel for text fields
        topPanel.setLayout(new GridLayout(2, 1));
        text = new JTextField();
        text.setHorizontalAlignment(JTextField.RIGHT);
        text.setEditable(false); // Make it non-editable
        text2 = new JTextField();
        text2.setHorizontalAlignment(JTextField.RIGHT);
        text2.setEditable(false); // Make it non-editable
        topPanel.add(text);
        topPanel.add(text2);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(); // Panel for number buttons
        centerPanel.setLayout(new GridLayout(4, 3, 3, 3));
        addButton(centerPanel, "7");
        addButton(centerPanel, "8");
        addButton(centerPanel, "9");
        addButton(centerPanel, "4");
        addButton(centerPanel, "5");
        addButton(centerPanel, "6");
        addButton(centerPanel, "1");
        addButton(centerPanel, "2");
        addButton(centerPanel, "3");
        addButton(centerPanel, "0");
        addButton(centerPanel, ".");
        addButton(centerPanel, "+/-");
        add(centerPanel, BorderLayout.CENTER);

        JPanel rightPanel = new JPanel(); // Panel for operator buttons
        rightPanel.setLayout(new GridLayout(0, 1, 5, 5));
        addButton(rightPanel, "/");
        addButton(rightPanel, "*");
        addButton(rightPanel, "-");
        addButton(rightPanel, "+");
        addButton(rightPanel, "=");
        addButton(rightPanel, "%");
        add(rightPanel, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(); // Panel for clear and back buttons
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        addButton(bottomPanel, "C");
        addButton(bottomPanel, "back");
        add(bottomPanel, BorderLayout.SOUTH);

        operations = new CalculatorOperations(text, text2);
    }

    private void addButton(Container panel, String text) {
        JButton button = new JButton(text);
        button.addActionListener(this);
        panel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        operations.handleCommand(command);
    }
}
