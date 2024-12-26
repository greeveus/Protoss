package Strategy;

public class Context {
    private Strategy strategy; // Текущая стратегия

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        if (strategy != null) {
            strategy.execute();
        } else {
            System.out.println("No strategy set!");
        }
    }
}
