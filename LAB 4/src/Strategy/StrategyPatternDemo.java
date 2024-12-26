package Strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new AttackStrategy());
        context.executeStrategy();

        context.setStrategy(new DefendStrategy());
        context.executeStrategy();

        context.setStrategy(new RetreatStrategy());
        context.executeStrategy();
    }
}
