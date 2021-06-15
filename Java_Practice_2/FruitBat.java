public class FruitBat extends Mammal {

    public FruitBat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return super.getName() + " is a FruitBat," + super.toString();
    }
}
