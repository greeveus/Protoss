package Proxy;

public class ProxyService implements Service {
    private RealService realService;

    @Override
    public void performOperation() {
        if (realService == null) {
            realService = new RealService();
        }
        System.out.println("ProxyService: Delegating operation to RealService...");
        realService.performOperation();
    }
}
