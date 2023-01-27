import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements Adder {
    public Server() throws RemoteException {
        super();
    }

    public ArrayList<String> cipherPhrase(String phrase) {
        ArrayList<String> temp = new ArrayList<>();
        String[] splitPhrase = phrase.split("");
        
        for (int i = 0; i < splitPhrase.length; i++) {
            if (!vowels(splitPhrase[i])) {
                temp.add(splitPhrase[i]);
            }
        }
        
        return temp;
    }

    public static boolean vowels(String s){
        String word = s.toUpperCase();
        char[] words = word.toCharArray();
        
        for(int i = 0; i<words.length; i++){
            char z = words[i];
            if (z=='A'||z=='E'||z=='I'||z=='O'||z=='U') return true;
        }

        return false;
    }

    @Override
    public int add(int number1, int number2) throws RemoteException {
        return number1 + number2;
    }

    public static void main(String args[]) throws RemoteException {
        try {
            Registry reg = LocateRegistry.createRegistry(4444);
            reg.rebind("server_start", new Server());
            System.out.println("Server is working...");

        } catch (RemoteException e) {
            System.out.println("Exception" + e);
        }
    }
}
