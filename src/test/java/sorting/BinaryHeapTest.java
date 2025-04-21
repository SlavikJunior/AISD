package sorting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class BinaryHeapTest {

    private BinaryHeap heap;

    @BeforeEach
    public void setUp() {
        heap = new BinaryHeap();
    }

    @Test
    public void testInsert_SingleElement() {
        List<Integer> result = heap.insert(10);
        assertEquals(List.of(10), result);
        assertEquals(1, heap.getHeap().size());
    }

    @Test
    public void testInsert_MultipleElements() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        assertEquals(List.of(20, 10, 5), heap.getHeap());
    }

    @Test
    public void testInsert_DuplicateElements() {
        heap.insert(10);
        heap.insert(10);
        heap.insert(5);
        assertEquals(List.of(10, 10, 5), heap.getHeap());
    }

    @Test
    public void testExtractMax_FromEmptyHeap() {
        assertThrows(IndexOutOfBoundsException.class, () -> heap.extractMax());
    }

    @Test
    public void testExtractMax_SingleElement() {
        heap.insert(10);
        int max = heap.extractMax();
        assertEquals(10, max);
        assertTrue(heap.getHeap().isEmpty());
    }

    @Test
    public void testExtractMax_MultipleElements() {
        heap.insert(10);
        heap.insert(20);
        heap.insert(5);
        assertEquals(20, heap.extractMax());
        assertEquals(List.of(10, 5), heap.getHeap());
    }

    @Test
    public void testBuildHeapFloyd_EmptyList() {
        List<Integer> result = heap.buildHeapFloyd(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testBuildHeapFloyd_SingleElement() {
        List<Integer> result = heap.buildHeapFloyd(List.of(10));
        assertEquals(List.of(10), result);
    }

    @Test
    public void testBuildHeapFloyd_MultipleElements() {
        List<Integer> result = heap.buildHeapFloyd(List.of(3, 1, 4, 1, 5));
        assertEquals(List.of(5, 3, 4, 1, 1), result);
    }

    @Test
    public void testSort_EmptyList() {
        List<Integer> result = heap.sort(List.of());
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSort_SingleElement() {
        List<Integer> result = heap.sort(List.of(10));
        assertEquals(List.of(10), result);
    }

    @Test
    public void testSort_MultipleElements() {
        List<Integer> result = heap.sort(List.of(3, 1, 4, 1, 5, 9, 2));
        assertEquals(List.of(9, 5, 4, 3, 2, 1, 1), result);
    }

    @Test
    public void testSort_AlreadySorted() {
        List<Integer> result = heap.sort(List.of(9, 5, 4, 3, 2, 1));
        assertEquals(List.of(9, 5, 4, 3, 2, 1), result);
    }

    @Test
    public void testSort_ReverseSorted() {
        List<Integer> result = heap.sort(List.of(1, 2, 3, 4, 5));
        assertEquals(List.of(5, 4, 3, 2, 1), result);
    }
}