public class Human extends Mammal {
    public Human(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.getName() + " is a human," + super.toString();
    }
}
