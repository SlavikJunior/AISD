package sorting;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {

    private List<Integer> storage = new ArrayList<>();
    private int size = 0;

    public List<Integer> insert(Integer element) {
        storage.add(element);
        size = storage.size();
        shiftUp(size - 1);
        return new ArrayList<>(storage);
    }

    private void shiftUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (storage.get(index) > storage.get(parentIndex)) {
                swap(storage, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    public Integer extractMax() {
        Integer max = storage.get(0);
        storage.set(0, storage.get(size - 1));
        storage.remove(size - 1);
        size--;
        if (size > 0) {
            shiftDown(0);
        }
        return max;
    }

    private void shiftDown(int index) {
        while (index < size / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && storage.get(leftChild) > storage.get(largest)) {
                largest = leftChild;
            }
            if (rightChild < size && storage.get(rightChild) > storage.get(largest)) {
                largest = rightChild;
            }

            if (largest != index) {
                swap(storage, index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    public List<Integer> buildHeapFloyd(List<Integer> inputList) {
        storage = new ArrayList<>(inputList);
        size = storage.size();
        for (int i = size / 2 - 1; i >= 0; i--) {
            shiftDown(i);
        }
        return new ArrayList<>(storage);
    }

    private void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public List<Integer> sort(List<Integer> inputList) {
        storage = new ArrayList<>(inputList);
        size = storage.size();
        buildHeapFloyd(storage);
        List<Integer> sortedList = new ArrayList<>();
        while (size > 0) {
            sortedList.add(extractMax());
        }
        return sortedList;
    }
}