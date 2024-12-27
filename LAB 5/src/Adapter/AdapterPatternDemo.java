package Adapter;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        // Адаптируемый объект
        Adaptee adaptee = new Adaptee();

        // Используем адаптер для взаимодействия с Adaptee через интерфейс Target
        Target target = new Adapter(adaptee);

        // Клиент вызывает метод через интерфейс Target
        System.out.println("Client: Making a request...");
        target.performRequest();
    }
}
