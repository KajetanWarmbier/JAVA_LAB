import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Adder extends Remote
{
    public int add(int number1, int number2) throws RemoteException;
}
