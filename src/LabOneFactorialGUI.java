//WAP a java code for button event listener to perform the following.
//->  When a user presses a button calculate factorial it needs to calculate factorial of a number.

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LabOneFactorialGUI {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Factorial Calculator");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        JLabel factorialLabel = new JLabel("Enter number:");
        factorialLabel.setBounds(50, 50, 100, 30);
        mainFrame.add(factorialLabel);

        JTextField factorialValue = new JTextField();
        factorialValue.setBounds(160, 50, 100, 30);
        mainFrame.add(factorialValue);

        JButton button = new JButton("Calculate");
        button.setBounds(270, 50, 100, 30);
        mainFrame.add(button);

        JLabel resultLabel = new JLabel("Factorial is:");
        resultLabel.setBounds(50, 100, 100, 30);
        mainFrame.add(resultLabel);

        JLabel factorialPrint = new JLabel("0");
        factorialPrint.setBounds(160, 100, 100, 30);
        mainFrame.add(factorialPrint);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(factorialValue.getText());
                    int result = findFactorial(number);
                    factorialPrint.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    factorialPrint.setText("Invalid input");
                }
            }

            public int findFactorial(int n) {
                if (n == 0 || n == 1) {
                    return 1;
                } else {
                    return n * findFactorial(n - 1);
                }
            }
        });

        mainFrame.setVisible(true);
    }
}
