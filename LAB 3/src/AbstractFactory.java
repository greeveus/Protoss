// Интерфейс для продукта A
interface Button {
    void paint();
}

// Конкретный продукт A1
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created a Windows button.");
    }
}

// Конкретный продукт A2
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("You have created a Mac button.");
    }
}

// Интерфейс для продукта B
interface Checkbox {
    void paint();
}

// Конкретный продукт B1
class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created a Windows checkbox.");
    }
}

// Конкретный продукт B2
class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("You have created a Mac checkbox.");
    }
}

// Интерфейс абстрактной фабрики
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Конкретная фабрика 1
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Конкретная фабрика 2
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Клиентский код
class Application {
    private Button button;
    private Checkbox checkbox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckbox();
    }

    public void paint() {
        button.paint();
        checkbox.paint();
    }
}

// Пример использования
public class AbstractFactory {
    public static void main(String[] args) {
        Application app1 = new Application(new WindowsFactory());
        app1.paint();

        Application app2 = new Application(new MacFactory());
        app2.paint();
    }
}