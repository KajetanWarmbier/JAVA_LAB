import java.io.IOException;
import java.net.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Socket socket = null;
        String[] pages = {"www.wp.pl", "www.ug.edu.pl", "www.onet.pl", "www.interia.pl", "www.helion.pl"};

        Random random = new Random();
        int number = random.nextInt(pages.length);

        try {
            socket = new Socket(pages[number], 80);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (socket != null) {
            System.out.println(socket);
        }

        String localIpAddress = null;
        String localHostName = null;

        try {
          localIpAddress = InetAddress.getLocalHost().getHostAddress();
            localHostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e ) {
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("Local Address IP: " + localIpAddress);
        System.out.println("Local Host name: " + localHostName);

        String hostName;
        InetAddress[] hostIP;

        try {
            hostName = InetAddress.getLocalHost().getHostName();
            hostIP = InetAddress.getAllByName(hostName);

            for (InetAddress address : hostIP) {
                System.out.println(address.getHostAddress());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}