package JavaLabPractical.Set_B;


import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        try {

            RmiServerInterfaceLabTwo server = (RmiServerInterfaceLabTwo) Naming.lookup("rmi://localhost/Server");

            System.out.println("Enter First number : ");
            int firstNumber = input.nextInt();

            System.out.println("Enter Second number : ");
            int secondNumber = input.nextInt();



            System.out.println("Response from server: " + server.addNumbers(firstNumber, secondNumber));

        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}
