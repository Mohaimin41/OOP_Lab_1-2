public class GreatWhiteShark extends Fish {
    public GreatWhiteShark(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.getName() + " is a GreatWhiteShark," + super.toString();
    }
}
