import java.io.Serializable;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map.Entry;


import util.NetworkUtil;

public class clientList implements Serializable{
    List<String> clientNames;

    clientList (HashMap<String, NetworkUtil> ClientMap) {
        clientNames = new ArrayList<>();
        for (Entry mapElement : ClientMap.entrySet()) {
            clientNames.add((String) mapElement.getKey());
        }
    }

    List<String> getclientNames () {
        return clientNames;
    }
}
