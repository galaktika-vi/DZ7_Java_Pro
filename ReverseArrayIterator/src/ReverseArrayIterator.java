import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReverseArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int currentIndex;

    public ReverseArrayIterator(T[] array) {
        this.array = array;
        this.currentIndex = array.length - 1;
    }

    @Override
    public boolean hasNext() {
        return currentIndex >= 0;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[currentIndex--];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        ReverseArrayIterator<Integer> iterator = new ReverseArrayIterator<>(numbers);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
