public class Player {
    private int number;
    private String name;
    private double salary;

	// you are not allowed to write any other constructor
    public Player(int number, String name) {
        setNumber(number);
        setName(name);
    }

	public void setNumber( int n ) {
        this.number = n;
    }
    public void setName ( String s ) {
        this.name = s;
    }
    // add your code here

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getNumber() {
        return number;
    }
    public double getSalary(){
        return salary;
    }
}
