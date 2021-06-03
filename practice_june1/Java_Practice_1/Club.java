public class Club {
    private int id;
    private String name;
    private Player[] players;
    // add your code here
    private int playerCount = 0;
	// you are not allowed to write any other constructor
    public Club() {
        this.players = new Player[11];
    }

	public double getSalary() {
        double total = 0;
        for (int i = 0; i < playerCount; i++) {
            total += players[i].getSalary();
        }
        return total;
    }
    // add your code here
	public void setName( String n ) {
        this.name = n;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void addPlayer( Player t ) {
        //players[playerCount] = new Player( t.getNumber(), t.getName() );
        //players[playerCount++].setSalary(t.getSalary());
        players[playerCount++] = t;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Player getMaxSalaryPlayer() {
        double maxSalary = 0;
        int pl = 0;
        for (int i = 0; i < playerCount; i++ ) {
            if ( players[i].getSalary() > maxSalary ) {
                maxSalary = players[i].getSalary();
                pl = i;
            }
        }
        return players[pl];
    }
}