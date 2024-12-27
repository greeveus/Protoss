package Bridge;

public class BridgePatternDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor(), 10);
        redCircle.draw();

        Shape blueSquare = new Square(new BlueColor(), 5);
        blueSquare.draw();
    }
}
