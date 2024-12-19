public class SingletonDemo {
    public static void main(String[] args) {
        // Получение единственного экземпляра Singleton
        Singleton singletonInstance = Singleton.getInstance();

        // Вызов метода экземпляра
        singletonInstance.showMessage();

        // Попробуем получить экземпляр ещё раз
        Singleton anotherInstance = Singleton.getInstance();

        // Проверим, что это один и тот же объект
        System.out.println("Это один и тот же объект? " + (singletonInstance == anotherInstance));
    }
}