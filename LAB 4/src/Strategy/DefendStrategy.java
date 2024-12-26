package Strategy;

public class DefendStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println("Executing defense strategy: Hold the position!");
    }
}