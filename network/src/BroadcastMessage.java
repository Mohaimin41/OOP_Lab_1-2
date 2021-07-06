import java.io.Serializable;

public class BroadcastMessage implements Serializable {
    private String from;
    private String text;

    public BroadcastMessage (String From, String Text) {
        from = From;
        text = Text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}