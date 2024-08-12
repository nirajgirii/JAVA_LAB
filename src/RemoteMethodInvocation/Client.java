package RemoteMethodInvocation;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        try {

            RmiServerInterface server = (RmiServerInterface) Naming.lookup("rmi://localhost/Server");

            System.out.println("Enter your name: ");
            name = input.nextLine();

            System.out.println("Enter First number : ");
            int firstNumber = input.nextInt();

            System.out.println("Enter Second number : ");
            int secondNumber = input.nextInt();

            String response = server.greetClientAndAdd(name, firstNumber, secondNumber);

            System.out.println("Response from server: " + response);

        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}
