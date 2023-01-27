import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
    public static void main( String args[]) throws RemoteException {
        Client c= new Client();
        c.connectRemote();
    }

    private void connectRemote() {
        try {
            Registry reg=LocateRegistry.getRegistry("localhost", 4444);
            Adder ad=(Adder) reg.lookup("server_start");
            
            System.out.println("Result " +ad.add(50,80));
            System.out.println(new Server().cipherPhrase("rekurencja"));
        } catch(NotBoundException|RemoteException e) {
            System.out.println(e);
        }
    }
}
