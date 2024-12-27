package Bridge;

public class Circle extends Shape {
    private int radius;

    public Circle(Color color, int radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius " + radius + " and color " + color.applyColor());
    }
}
