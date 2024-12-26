package Iterator;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        String[] items = {"Item 1", "Item 2", "Item 3"};

        Iterator<String> iterator = new ArrayIterator<>(items);

        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("Iterated item: " + item);
        }
    }
}
