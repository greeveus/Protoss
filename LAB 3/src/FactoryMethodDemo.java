public class FactoryMethodDemo {
    public static void main(String[] args) {
        // Используем фабрику для создания продукта A
        ProductFactory creatorA = new ConcreteProductFactoryA();
        creatorA.someOperation();

        // Используем фабрику для создания продукта B
        ProductFactory creatorB = new ConcreteProductFactoryB();
        creatorB.someOperation();
    }
}
