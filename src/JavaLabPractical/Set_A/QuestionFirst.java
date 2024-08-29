package JavaLabPractical.Set_A;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QuestionFirst {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Divisible by Five");
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

        enterNumberTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'A' || e.getKeyChar() == 'a') {
                    try {
                        int number = Integer.parseInt(enterNumberTextField.getText());
                        if (number % 5 == 0) {
                            outputLabel.setText("Divisible by five");
                        } else {
                            outputLabel.setText("Not divisible by five");
                        }
                    } catch (NumberFormatException ex) {
                        outputLabel.setText("Invalid number");
                    }
                }
            }
        });
        frame.setVisible(true);
    }
}
