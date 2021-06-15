public class Albatross extends Bird {
    public Albatross(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.getName() + " is an Albatross," + super.toString();
    }
}
