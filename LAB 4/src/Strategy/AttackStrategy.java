package Strategy;

public class AttackStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing attack strategy: Attack the enemy!");
    }
}