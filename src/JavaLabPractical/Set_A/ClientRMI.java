package JavaLabPractical.Set_A;

import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) {

        try {
            RmiServerInterfaceLab server = (RmiServerInterfaceLab) Naming.lookup("rmi://localhost/Server");

            System.out.println(server.greetClient());

        } catch (Exception e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }

}
