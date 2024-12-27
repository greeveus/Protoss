package Proxy;

public class ProxyPatternDemo {
    public static void main(String[] args) {
        System.out.println("Creating proxy...");
        Service proxy = new ProxyService();

        System.out.println("\nCalling performOperation the first time:");
        proxy.performOperation();

        System.out.println("\nCalling performOperation the second time:");
        proxy.performOperation();
    }
}
