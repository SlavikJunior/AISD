package sorting;

import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {

    private List<Integer> storage = new ArrayList<>();

    private int size = 0;

    public List<Integer> insert(Integer element) {
        storage.add(element);
        size++;
        shiftUp(storage);
       return new ArrayList<>(storage);
    }

    private Integer shiftUp(List<Integer> inputList) {
        Integer childId = size/2+1;
        for (int i = size/2-1; i >= 0; i--) {
            Integer current = inputList.get(i);
            childId = i*2+1;
            Integer maxChild = inputList.get(childId);

            if (((i*2+2) < size) && (maxChild < inputList.get(i*2+2))) {
                childId = i*2+2;
                maxChild = inputList.get(childId);
            }

            if (current < maxChild)
                swap(inputList, i, childId);
        }
        return childId;
    }

    public Integer extractMax() {
        Integer value = storage.get(0);
        storage.set(0, storage.get(size - 1));
        storage.remove(size - 1);
        size--;
        shiftDown(0, storage);
        return value;
    }

    private void shiftDown(Integer childId, List<Integer> inputList) {
        size = inputList.size();
        for (int i = childId; i < inputList.size()/2;) {
            Integer current = inputList.get(i);
            childId = i*2+1;
            Integer maxChild = inputList.get(childId);

            if (((i*2+2) < size) && maxChild < inputList.get(i*2+2)) {
                childId = i*2+2;
                maxChild = inputList.get(childId);
            }

            if (current < maxChild)
                swap(inputList, i, childId);
            i = childId;
        }
    }

    public List<Integer> buildHeapFloyd(List<Integer> inputList) {
        size = inputList.size();

        Integer childId = shiftUp(inputList);
        shiftDown(childId, inputList);

        storage = new ArrayList<>(inputList);
        return inputList;
    }

    private void swap(List<Integer> inputList, int id1, int id2) {
        Integer oldValue = inputList.get(id1);
        inputList.set(id1, inputList.get(id2));
        inputList.set(id2, oldValue);
    }

    public List<Integer> getHeap() {
        return new ArrayList<>(storage);
    }

    public List<Integer> sort(List<Integer> inputList) {
        inputList = buildHeapFloyd(inputList);
        int cnt = inputList.size();
        List<Integer> reverseSortedArray = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            Integer root = inputList.get(0);
            reverseSortedArray.add(root);
            inputList.set(0, inputList.get(size-1));
            inputList.remove(size - 1);
            shiftDown(0, inputList);
        }
        return reverseSortedArray;
    }
}
