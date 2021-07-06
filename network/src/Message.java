import java.io.Serializable;

public class Message implements Serializable {
    private String from;
    private String to;
    private String text;

    public Message(String From, String To, String  Text) {
        from = From;
        to = To;
        text = Text;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}