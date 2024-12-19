public class Singleton {
    // Приватное статическое поле для хранения единственного экземпляра
    private static Singleton instance;

    // Приватный конструктор, чтобы предотвратить создание экземпляров извне
    private Singleton() {}

    // Статический метод для получения единственного экземпляра
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Это Singleton!");
    }
}
