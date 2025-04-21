package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main4 {

    public static void main(String[] args) {
        BinaryHeap heapSort = new BinaryHeap();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(0, 53));
        }
        System.out.println(list);
        list = heapSort.buildHeapFloyd(list);
        System.out.println(list);
    }
}
