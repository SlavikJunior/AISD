package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main4 {

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            input.add(random.nextInt(0, 31));
        }
        HeapSort heap = new HeapSort((i1, i2) -> Integer.compare(i1, i2), input);
        heap.createHeap();
        System.out.println(heap);
    }

}
