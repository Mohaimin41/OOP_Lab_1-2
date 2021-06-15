public class Dog extends Mammal {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.getName() + " is a dog," + super.toString();
    }
}
