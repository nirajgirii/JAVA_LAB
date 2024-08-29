package JavaLabPractical.Set_B;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RmiServerInterfaceLabTwo {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public String addNumbers(int a, int b) {
        return "The answer is " + (a + b);
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry started.");
            Server server = new Server();
            Naming.rebind("rmi://localhost/Server", server);
            System.out.println("Server is ready.");

        } catch (Exception e) {
            System.err.println("Server exception: " + e);
            e.printStackTrace();
        }
    }


}
