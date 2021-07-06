import util.NetworkUtil;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil networkUtil;
    String name;

    public WriteThreadClient(NetworkUtil networkUtil, String name) {
        this.networkUtil = networkUtil;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            do {
                int option = Client.menu();

                if (option == 3) {
                    boolean running = true;
                    Scanner input = new Scanner(System.in);
                    while (running) {
                        String from = name;
                        System.out.print("Enter name of the client to send: ");
                        String to = input.nextLine();
                        System.out.print("Enter the message: ");
                        String text = input.nextLine();
                        Message message = new Message(from, to, text);
                        networkUtil.write(message);
                        running = false;
                    }

                } else if (option == 2) {
                    //Scanner input = new Scanner(System.in);
                    getListRequest GetListRequest = new getListRequest(name);
                    networkUtil.write(GetListRequest);

                } else if (option == 1) {
                    System.out.println("This client is already connected");

                } else if (option == 4) {
                    boolean running = true;
                    Scanner input = new Scanner(System.in);
                    while (running) {
                        String from = name;
                        System.out.print("Enter the message: ");
                        String text = input.nextLine();
                        BroadcastMessage broadcastMessage = new BroadcastMessage(from, text);
                        networkUtil.write(broadcastMessage);
                        running = false;
                    }
                }
            } while (true);

        } catch (EOFException e) {
            System.out.println(" @ WriteThreadClient " + getClass().getMethods().toString() + e);
        } catch (Exception e) {
            System.out.println(" @ WriteThreadClient " +e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}