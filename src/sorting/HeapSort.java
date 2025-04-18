package sorting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class HeapSort {

    private List<Integer> storage;
    private Comparator<Integer> comp;
    private int size;

    public HeapSort(Comparator<Integer> comp, Collection<Integer> input) {
        this.comp = comp;
        this.storage = new ArrayList<>(input);
        this.size = storage.size();
    }

    public void createHeap() {
        int oldIndex = -1;
        for(int i = size/2 - 1; i >= 0; i--) {
            Integer maxChild = storage.get(i*2+1);
            oldIndex = i*2+1;
            if (maxChild < storage.get(i*2+2)) {
                maxChild = storage.get(i * 2 + 2);
                oldIndex = i*2+2;
            }
            if (storage.get(i) < maxChild) {
                storage.set(oldIndex, storage.get(i));
                storage.set(i, maxChild);
            }
        }

        for (int i = oldIndex; i < size; i++) {
            Integer maxChild = storage.get(i*2+1);
            oldIndex = i*2+1;
            if (maxChild < storage.get(i*2+2)) {
                maxChild = storage.get(i*2+2);
                oldIndex = i*2+2;
            }
            if (storage.get(i) < maxChild) {
                storage.set(oldIndex, storage.get(i));
                storage.set(i, maxChild);
            }
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < size;
    }

    public int size() {
        return size;
    }

    public Integer get(int index) {
        if (isValidIndex(index)) {
            return storage.get(index);
        } return null;
    }

    public Integer set(int index, Integer element) {
        if (isValidIndex(index)) {
            Integer oldValue = storage.get(index);
            storage.set(index, element);
            return oldValue;
        } return null;
    }

    @Override
    public String toString() {
        return storage.toString();
    }
}
