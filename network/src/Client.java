import util.NetworkUtil;

import java.io.IOException;
import java.util.Scanner;

public class Client {
    static final String serverAddress = "127.0.0.1";
    static final int serverPort = 33333;
    NetworkUtil networkUtil;
    String clientName;

    public Client(String serverAddress, int serverPort) {
        processMenu(menu());
    }

    public static int menu() {
        System.out.println("Enter an option:");
        System.out.println("1. Connect");
        System.out.println("2. GetList");
        System.out.println("3. SendOne");
        System.out.println("4. Broadcast");
        Scanner input = new Scanner(System.in);
        int res = input.nextInt();
        //input.nextLine();
        return res;
    }

    public void processMenu(int option) {
        if (option == 1) {
            System.out.print("Enter name of the client: ");
            Scanner scanner = new Scanner(System.in);
            clientName = scanner.nextLine();
            networkUtil = null;
            try {
                networkUtil = new NetworkUtil(serverAddress, serverPort);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                networkUtil.write(clientName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            new WriteThreadClient(networkUtil, clientName);
            new ReadThreadClient(networkUtil);

        } else {
            System.out.println("Not Connected To Server");
        }
    }

    public static void main(String[] args) {

        Client client = new Client(serverAddress, serverPort);
    }
}


