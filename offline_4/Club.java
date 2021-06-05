public class Club {
    private int Id;
    private int point;
    private String clubName;

    public Club() {
        Id = 0;
        point = 0;
        clubName = "";
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setName(String clubName) {
        this.clubName = clubName;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return clubName;
    }
}
