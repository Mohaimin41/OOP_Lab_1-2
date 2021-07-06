import util.NetworkUtil;

import java.io.EOFException;
import java.io.IOException;

public class ReadThreadClient implements Runnable {
    private final Thread thr;
    private final NetworkUtil networkUtil;

    public ReadThreadClient(NetworkUtil networkUtil) {
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                //System.out.println("read kore nai network util @ ReadThreadClient");
                Object o = networkUtil.read();
                //System.out.println("read korse network util @ ReadThreadClient");
                if (o != null) {
                    if (o instanceof Message) {
                        Message obj = (Message) o;
                        System.out.println("Message from: " + obj.getFrom() + ", to: " + obj.getTo() + ", Message: " + obj.getText());
                    } else if (o instanceof BroadcastMessage) {
                        BroadcastMessage obj = (BroadcastMessage) o;
                        System.out.println("Message from: " + obj.getFrom() + ", Message: " + obj.getText());
                    } else if (o instanceof clientList) {
                        clientList obj = (clientList) o;
                        int i = 0;
                        System.out.println("Client List:");
                        for (String name : obj.getclientNames()) {
                            System.out.println(++i + ". " + name);
                        }
                    }
                }
            }
        } catch (EOFException e) {
            System.out.println(" @ ReadThreadClient " + e);
        } catch (Exception e) {
            System.out.println(" @ ReadThreadClient " + e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}