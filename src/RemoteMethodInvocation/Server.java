package RemoteMethodInvocation;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements RmiServerInterface {

    public Server() throws RemoteException {
        super();
    }

    @Override
    public String greetClientAndAdd(String name, int a, int b) throws RemoteException {
        return "Hi " + name + ". The Sum of numbers you entered is " + (a + b);
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
