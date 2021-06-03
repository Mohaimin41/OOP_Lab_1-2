public class Club {
    private int Id;
    private String clubName;

    public Club() {
        Id = 0;
        clubName = "";
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String clubName) {
        this.clubName = clubName;
    }

    public int getId() {
        return Id;
    }

    public String getClubName() {
        return clubName;
    }
}
