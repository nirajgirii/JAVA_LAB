import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JAVA_LAB_ACCOUNTLIST {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/ACCOUNTLIST";
        String USER = "root";
        String PASSWORD = "He!!0w0rld0672";

        JFrame mainFrame = new JFrame("Account History");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 500); // Increased size to accommodate the text area
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        JLabel ACCOUNT_NUMBER_LABEL = new JLabel("Account Number:");
        ACCOUNT_NUMBER_LABEL.setBounds(50, 30, 120, 30);

        JLabel ACCOUNT_NAME_LABEL = new JLabel("Account Name:");
        ACCOUNT_NAME_LABEL.setBounds(50, 80, 120, 30);

        JLabel ACCOUNT_AMOUNT_LABEL = new JLabel("Amount in Account:");
        ACCOUNT_AMOUNT_LABEL.setBounds(50, 130, 150, 30);

        JTextField ACCOUNT_NUMBER = new JTextField(10);
        ACCOUNT_NUMBER.setBounds(200, 30, 200, 30);

        JTextField ACCOUNT_NAME = new JTextField(10);
        ACCOUNT_NAME.setBounds(200, 80, 200, 30);

        JTextField ACCOUNT_AMOUNT = new JTextField(10);
        ACCOUNT_AMOUNT.setBounds(200, 130, 200, 30);

        JButton INSERT_ACCOUNT_BUTTON = new JButton("INSERT");
        INSERT_ACCOUNT_BUTTON.setBounds(50, 180, 150, 30);

        JButton SHOW_ACCOUNTS_BUTTON = new JButton("SHOW ACCOUNTS");
        SHOW_ACCOUNTS_BUTTON.setBounds(250, 180, 150, 30);

        JTextArea accountsTextArea = new JTextArea();
        accountsTextArea.setBounds(50, 230, 400, 200);
        accountsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(accountsTextArea);
        scrollPane.setBounds(50, 230, 600, 200);

        mainFrame.add(ACCOUNT_NUMBER_LABEL);
        mainFrame.add(ACCOUNT_NUMBER);
        mainFrame.add(ACCOUNT_NAME_LABEL);
        mainFrame.add(ACCOUNT_NAME);
        mainFrame.add(ACCOUNT_AMOUNT_LABEL);
        mainFrame.add(ACCOUNT_AMOUNT);
        mainFrame.add(INSERT_ACCOUNT_BUTTON);
        mainFrame.add(SHOW_ACCOUNTS_BUTTON);
        mainFrame.add(scrollPane);

        mainFrame.setVisible(true);

        // Load and register MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Action listener for INSERT button
        INSERT_ACCOUNT_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = ACCOUNT_NUMBER.getText();
                String accountName = ACCOUNT_NAME.getText();
                String accountAmount = ACCOUNT_AMOUNT.getText();

                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    System.out.println("Connection established for insertion!");

                    String INSERT_QUERY = "INSERT INTO ACCOUNTS_DETAILS (ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_AMOUNT) VALUES (?, ?, ?)";
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
                    preparedStatement.setString(1, accountNumber);
                    preparedStatement.setString(2, accountName);
                    preparedStatement.setString(3, accountAmount);

                    int rowsInserted = preparedStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println("A new account was inserted successfully!");
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        // Action listener for SHOW ACCOUNTS button
        SHOW_ACCOUNTS_BUTTON.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
                    System.out.println("Connection established for showing accounts!");

                    String SELECT_QUERY = "SELECT * FROM ACCOUNTS_DETAILS";
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);
                    ResultSet resultSet = preparedStatement.executeQuery();

                    StringBuilder accountsDetails = new StringBuilder();
                    while (resultSet.next()) {
                        String accountNumber = resultSet.getString("ACCOUNT_NUMBER");
                        String accountName = resultSet.getString("ACCOUNT_NAME");
                        String accountAmount = resultSet.getString("ACCOUNT_AMOUNT");
                        accountsDetails.append("Account Number: ").append(accountNumber)
                                .append(", Account Name: ").append(accountName)
                                .append(", Amount: ").append(accountAmount)
                                .append("\n");
                    }

                    accountsTextArea.setText(accountsDetails.toString());

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
