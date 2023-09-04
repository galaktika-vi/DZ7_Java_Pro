import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        // Заполнение списка случайными числами
        for (int i = 0; i < 10000000; i++) {
            list.add(random.nextInt());
        }

        // Замер времени для for-each
        long startTime = System.currentTimeMillis();
        int tempVal = 0;
        for (int val : list) {
            tempVal = val;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("for-each: " + (endTime - startTime) + " миллисекунд");

        // Замер времени для classic for
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            tempVal = list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("classic for: " + (endTime - startTime) + " миллисекунд");

        // Замер времени для classic for с перебором с конца
        startTime = System.currentTimeMillis();
        for (int i = list.size() - 1; i >= 0; i--) {
            tempVal = list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("classic for с перебором с конца: " + (endTime - startTime) + " миллисекунд");

        // Замер времени для Iterator
        startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            tempVal = iterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("Iterator: " + (endTime - startTime) + " миллисекунд");

        // Замер времени для ListIterator
        startTime = System.currentTimeMillis();
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            tempVal = listIterator.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("ListIterator: " + (endTime - startTime) + " миллисекунд");
    }
}
