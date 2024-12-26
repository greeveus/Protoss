package Strategy;

public class RetreatStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing retreat strategy: Fall back to a safe position!");
    }
}