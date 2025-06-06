package sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main4 {

    public static void main(String[] args) {
        BinaryHeap heapSort = new BinaryHeap();
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
//            list.add(random.nextInt(0, 53));
        }
        System.out.println("Исходный список: " + list);
        list = heapSort.sort(list);
        System.out.println("Отсортированный: " + list);
        heapSort.buildHeapFloyd(list);
        list = heapSort.insert(52);
        list = heapSort.insert(42);
        list = heapSort.insert(32);
        list = heapSort.sort(list);
        System.out.println("Вставил 52, 42 и 32 и сортнул: " + list);
    }
}
