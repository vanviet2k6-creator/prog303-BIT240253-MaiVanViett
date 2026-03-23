package exfour;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private final JTextField display;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;
    private boolean isNewInput = true;
    
    public CalculatorGUI() {
        setTitle("Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.WHITE);
        add(display, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5));
        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "CE", "%", "√"
        };
        
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(this);
            buttonPanel.add(button);
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        try {
            if (command.matches("[0-9]")) {
                if (isNewInput) {
                    display.setText(command);
                    isNewInput = false;
                } else {
                    display.setText(display.getText() + command);
                }
            }
            else if (command.equals(".")) {
                if (!display.getText().contains(".")) {
                    display.setText(display.getText() + ".");
                }
            }
            else if (command.equals("C")) {
                display.setText("");
                num1 = num2 = result = 0;
                operator = '\0';
                isNewInput = true;
            }
            else if (command.equals("CE")) {
                display.setText("");
                isNewInput = true;
            }
            else if (command.equals("+") || command.equals("-") || 
                     command.equals("*") || command.equals("/")) {
                if (display.getText().isEmpty()) {
                    display.setText("0");
                }
                num1 = Double.parseDouble(display.getText());
                operator = command.charAt(0);
                isNewInput = true;
            }
            else if (command.equals("%")) {
                if (display.getText().isEmpty()) {
                    display.setText("0");
                }
                double current = Double.parseDouble(display.getText());
                result = current / 100;
                display.setText(String.valueOf(result));
                isNewInput = true;
            }
            else if (command.equals("√")) {
                if (display.getText().isEmpty()) {
                    display.setText("0");
                }
                double current = Double.parseDouble(display.getText());
                if (current >= 0) {
                    result = Math.sqrt(current);
                    if (result == (long) result) {
                        display.setText(String.valueOf((long) result));
                    } else {
                        display.setText(String.valueOf(result));
                    }
                    isNewInput = true;
                } else {
                    display.setText("Error");
                    isNewInput = true;
                }
            }
            else if (command.equals("=")) {
                if (display.getText().isEmpty()) {
                    display.setText("0");
                }
                num2 = Double.parseDouble(display.getText());
                
                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            display.setText("Error: Division by zero");
                            isNewInput = true;
                            return;
                        }
                        break;
                    default:
                        return;
                }
                
                if (result == (long) result) {
                    display.setText(String.valueOf((long) result));
                } else {
                    display.setText(String.valueOf(result));
                }
                isNewInput = true;
            }
        } catch (NumberFormatException ex) {
            display.setText("Error");
            isNewInput = true;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorGUI();
        });
    }
}