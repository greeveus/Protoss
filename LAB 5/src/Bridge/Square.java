package Bridge;

public class Square extends Shape {
    private int side;

    public Square(Color color, int side) {
        super(color);
        this.side = side;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Square with side " + side + " and color " + color.applyColor());
    }
}
