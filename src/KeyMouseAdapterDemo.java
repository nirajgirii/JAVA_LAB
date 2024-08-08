// WAP a java code for both Mouse and Key listener.
// 1. If a user enter the certain area print "Mouse Entered".
// 2. Perform all KeyListener functions.

// --NOTE-- Check Console for keyTyped, keyPressed, keyReleased.

import javax.swing.*;
import java.awt.event.*;

public class KeyMouseAdapterDemo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key and Mouse Adapter Demo");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(50, 50, 300, 100);

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

        JLabel label = new JLabel("Hover over me!");
        label.setBounds(50, 200, 200, 30);

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

        frame.getContentPane().add(textArea);
        frame.getContentPane().add(label);

        frame.setVisible(true);
    }
}
