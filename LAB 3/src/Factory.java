// Абстрактный класс для продуктов
abstract class Product {
    public abstract void use();
}

// Конкретные реализации продуктов
class ConcreteProductA extends Product {
    @Override
    public void use() {
        System.out.println("Используется продукт A");
    }
}

class ConcreteProductB extends Product {
    @Override
    public void use() {
        System.out.println("Используется продукт B");
    }
}

// Абстрактный класс для фабрики
abstract class ProductFactory {
    // Фабричный метод для создания продукта
    public abstract Product createProduct();

    // Метод, который использует продукт
    public void someOperation() {
        Product product = createProduct(); // Создаём продукт
        product.use(); // Используем продукт
    }
}

// Конкретные фабрики для создания разных продуктов
class ConcreteProductFactoryA extends ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductA();
    }
}

class ConcreteProductFactoryB extends ProductFactory {
    @Override
    public Product createProduct() {
        return new ConcreteProductB();
    }
}
