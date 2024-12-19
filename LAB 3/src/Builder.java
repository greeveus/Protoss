// Продукт
class Pizza {
    private String dough;
    private String sauce;
    private String topping;
    private boolean isCheeseStuffed;

    public void setDough(String dough) {
        this.dough = dough;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public void setCheeseStuffed(boolean isCheeseStuffed) {
        this.isCheeseStuffed = isCheeseStuffed;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "dough='" + dough + '\'' +
                ", sauce='" + sauce + '\'' +
                ", topping='" + topping + '\'' +
                ", isCheeseStuffed=" + isCheeseStuffed +
                '}';
    }
}

// Интерфейс строителя
interface PizzaBuilder {
    void buildDough();
    void buildSauce();
    void buildTopping();
    void buildCheeseStuffed(); // Новый метод
    Pizza getResult();
}

// Конкретный строитель
class HawaiianPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public HawaiianPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("cross");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("mild");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("ham+pineapple");
    }

    @Override
    public void buildCheeseStuffed() {
        pizza.setCheeseStuffed(false); // Гавайская пицца без сыра в бортиках
    }

    @Override
    public Pizza getResult() {
        return pizza;
    }
}

// Новый строитель для мясной пиццы
class MeatLoversPizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public MeatLoversPizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void buildDough() {
        pizza.setDough("thick");
    }

    @Override
    public void buildSauce() {
        pizza.setSauce("spicy");
    }

    @Override
    public void buildTopping() {
        pizza.setTopping("pepperoni+sausage+bacon");
    }

    @Override
    public void buildCheeseStuffed() {
        pizza.setCheeseStuffed(true); // Сыр в бортиках
    }

    @Override
    public Pizza getResult() {
        return pizza;
    }
}

// Директор
class PizzaDirector {
    private PizzaBuilder builder;

    public void setBuilder(PizzaBuilder builder) {
        this.builder = builder;
    }

    public void constructPizza() {
        builder.buildDough();
        builder.buildSauce();
        builder.buildTopping();
        builder.buildCheeseStuffed();
    }
}

// Пример использования
public class Builder {
    public static void main(String[] args) {
        PizzaDirector director = new PizzaDirector();

        // Создание гавайской пиццы
        PizzaBuilder hawaiianBuilder = new HawaiianPizzaBuilder();
        director.setBuilder(hawaiianBuilder);
        director.constructPizza();
        Pizza hawaiianPizza = hawaiianBuilder.getResult();
        System.out.println(hawaiianPizza);

        // Создание мясной пиццы
        PizzaBuilder meatLoversBuilder = new MeatLoversPizzaBuilder();
        director.setBuilder(meatLoversBuilder);
        director.constructPizza();
        Pizza meatLoversPizza = meatLoversBuilder.getResult();
        System.out.println(meatLoversPizza);
    }
}
