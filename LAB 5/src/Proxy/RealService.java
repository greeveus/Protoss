package Proxy;

public class RealService implements Service {
    public RealService() {
        // Симуляция ресурсоемкой операции
        System.out.println("RealService: Performing heavy initialization...");
    }

    @Override
    public void performOperation() {
        System.out.println("RealService: Performing operation...");
    }
}
