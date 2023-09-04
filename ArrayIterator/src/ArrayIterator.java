import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int currentIndex;

    public ArrayIterator(T[] array) {
        this.array = array;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < array.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return array[currentIndex++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Remove operation is not supported.");
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};
        ArrayIterator<Integer> iterator = new ArrayIterator<>(numbers);

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
