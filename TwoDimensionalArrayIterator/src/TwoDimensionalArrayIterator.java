import java.util.Iterator;
import java.util.NoSuchElementException;

public class TwoDimensionalArrayIterator<T> implements Iterator<T> {
    private final T[][] array;
    private int row = 0;
    private int col = 0;

    public TwoDimensionalArrayIterator(T[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return row < array.length && (row < array.length - 1 || col < array[row].length);
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        T element = array[row][col];
        col++;

        if (col >= array[row].length) {
            row++;
            col = 0;
        }

        return element;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        Integer[][] twoDArray = {
                {1, 2, 3},
                {4, 5},
                {6, 7, 8, 9}
        };

        TwoDimensionalArrayIterator<Integer> iterator = new TwoDimensionalArrayIterator<>(twoDArray);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
