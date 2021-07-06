import java.io.Serializable;

public class getListRequest implements Serializable {
    String From;
    public getListRequest(String from) {
        From = from;
    }

    String getFrom () { return From; }

}