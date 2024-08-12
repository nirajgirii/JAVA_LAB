package RemoteMethodInvocation;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServerInterface extends Remote {
    String greetClientAndAdd(String name, int a, int b) throws RemoteException;
}
