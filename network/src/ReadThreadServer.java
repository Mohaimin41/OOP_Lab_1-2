import util.NetworkUtil;

import java.io.EOFException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ReadThreadServer implements Runnable {
    private Thread thr;
    private NetworkUtil networkUtil;
    public HashMap<String, NetworkUtil> clientMap;


    public ReadThreadServer(HashMap<String, NetworkUtil> map, NetworkUtil networkUtil) {
        this.clientMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            while (true) {
                Object o = networkUtil.read();
                if (o != null) {
                    if (o instanceof Message) {
                        Message obj = (Message) o;
                        String to = obj.getTo();
                        NetworkUtil nu = clientMap.get(to);
                        if (nu != null) {
                            nu.write(obj);
                        }
                    } else if ( o instanceof BroadcastMessage) {
                        BroadcastMessage obj = (BroadcastMessage) o;
                        for (Entry mapElement : clientMap.entrySet()) {
                            NetworkUtil nu = clientMap.get(mapElement.getKey());
                            if  (nu != null) {
                                if (!(((String) mapElement.getKey()).equalsIgnoreCase(obj.getFrom()))) {
                                    nu.write(obj);
                                }
                            }
                        }
                    } else if (o instanceof getListRequest) {
                        getListRequest obj = (getListRequest) o;
                        NetworkUtil nu = clientMap.get(obj.getFrom());
                        if ( nu != null) {
                            nu.write(new clientList(clientMap));
                        }
                    }
                }
            }
        } catch (EOFException e) {
            System.out.println(" @ ReadThreadServer " +e);
        } catch (Exception e) {
            System.out.println(" @ ReadThreadServer " +e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}