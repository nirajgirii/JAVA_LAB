package JavaLabPractical.Set_B;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuestionFirst {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Factorial");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel enterNumberLabel = new JLabel("Enter a number:");
        enterNumberLabel.setBounds(50, 50, 120, 30);

        JTextField enterNumberTextField = new JTextField();
        enterNumberTextField.setBounds(180, 50, 100, 30);

        JLabel outputLabel = new JLabel();
        outputLabel.setBounds(50, 100, 300, 30);

        frame.add(enterNumberLabel);
        frame.add(enterNumberTextField);
        frame.add(outputLabel);

        outputLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int factorialValue = Integer.parseInt(enterNumberTextField.getText());
                outputLabel.setText(String.valueOf(findFactorial(factorialValue)));
            }

            public int findFactorial (int number) {
                if (number == 1 || number == 0) {
                    return 1;
                }
                else return findFactorial(number - 1) * number;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                int factorialValue = Integer.parseInt(enterNumberTextField.getText());
                outputLabel.setText(String.valueOf((factorialValue * factorialValue)));
            }
        });
        frame.setVisible(true);
    }
}
