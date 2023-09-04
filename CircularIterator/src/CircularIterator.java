import java.util.Iterator;
import java.util.List;

public class CircularIterator<T> implements Iterator<T> {
    private List<T> elements;
    private int currentIndex = -1;

    public CircularIterator(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        return !elements.isEmpty();
    }

    @Override
    public T next() {
        if (elements.isEmpty()) {
            throw new IllegalStateException("The list is empty.");
        }

        currentIndex = (currentIndex + 1) % elements.size();
        return elements.get(currentIndex);
    }

    public static void main(String[] args) {
        List<String> players = List.of("Player 1", "Player 2", "Player 3", "Player 4");
        CircularIterator<String> dealerIterator = new CircularIterator<>(players);

        int rounds = 10;
        for (int i = 0; i < rounds; i++) {
            System.out.println("Round " + (i + 1) + ": Dealer is " + dealerIterator.next());
        }
    }
}
