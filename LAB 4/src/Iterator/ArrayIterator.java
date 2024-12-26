package Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int currentIndex = 0;

    public ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");
        }
        return array[currentIndex++];
    }
}
