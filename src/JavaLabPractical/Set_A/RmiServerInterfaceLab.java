package JavaLabPractical.Set_A;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface RmiServerInterfaceLab extends Remote {
    String greetClient() throws RemoteException;
}
