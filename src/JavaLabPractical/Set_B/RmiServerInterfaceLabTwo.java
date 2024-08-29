package JavaLabPractical.Set_B;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiServerInterfaceLabTwo extends Remote {
    String addNumbers(int a, int b) throws RemoteException;
}
