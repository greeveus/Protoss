package Adapter;

public class Adapter implements Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void performRequest() {
        System.out.println("Adapter: Translating request to Adaptee...");
        adaptee.specificRequest(); // Делегирование вызова к Adaptee
    }
}
