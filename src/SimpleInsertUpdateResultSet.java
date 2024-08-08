//A simple java code with insert and select operations using executeUpdate and resultSet to show the stored data's in database.

import javax.swing.*;
import java.sql.*;

public class SimpleInsertUpdateResultSet {
    public static void main(String[] args) {
        String URL = "jdbc:mysql://localhost:3306/ACCOUNTLIST";
        String selectQuery = "SELECT * FROM ACCOUNTS_DETAILS";
        String insertQuery = "INSERT INTO ACCOUNTS_DETAILS (ACCOUNT_NUMBER, ACCOUNT_NAME, ACCOUNT_AMOUNT) VALUES (210634, 'Pesal Rai', 100000);";

        JFrame mainFrame = new JFrame("Account History");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(700, 500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);

        JTextArea accountsTextArea = new JTextArea();
        accountsTextArea.setBounds(50, 20, 600, 200);
        accountsTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(accountsTextArea);
        scrollPane.setBounds(50, 20, 600, 200);

        mainFrame.add(scrollPane);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");

            try (Connection connection = DriverManager.getConnection(URL, "root", "He!!0w0rld0672");
                 Statement statement = connection.createStatement()) {

                int rowsInserted = statement.executeUpdate(insertQuery);
                if (rowsInserted > 0) {
                    System.out.println("A new account was inserted successfully!");
                }

                ResultSet resultSet = statement.executeQuery(selectQuery);

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

                resultSet.close();
                statement.close();
                connection.close();
                System.out.println();
                System.out.println("|------------------------------ Connection Closed ------------------------------|");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        mainFrame.setVisible(true);
    }
}
