import javax.swing.*;
import java.awt.event.*;

public class KeyMouseAdapterDemo {
    public static void main(String[] args) {
        // Create a new frame
        JFrame frame = new JFrame("Key and Mouse Adapter Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Create a text area
        JTextArea textArea = new JTextArea();
        textArea.setBounds(50, 50, 300, 100);

        // Add a key listener to the text area
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char keyChar = e.getKeyChar();
                System.out.println("Key Typed: " + keyChar);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                System.out.println("Key Pressed: " + KeyEvent.getKeyText(keyCode));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                System.out.println("Key Released: " + KeyEvent.getKeyText(keyCode));
            }
        });

        // Create a label
        JLabel label = new JLabel("Hover over me!");
        label.setBounds(50, 200, 200, 30);

        // Add a mouse listener to the label
        label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked at: " + e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label.setText("Hover over me!");
            }
        });

        // Add components to the frame
        frame.getContentPane().add(textArea);
        frame.getContentPane().add(label);

        // Set the frame visibility to true
        frame.setVisible(true);
    }
}
