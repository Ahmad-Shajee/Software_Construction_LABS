import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class BinarySearchTest {
    @Test
    void testBinarySearchRecursiveInt() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(2, BinarySearch.binarySearchRecursive(array, 3, 0, array.length - 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(array, 6, 0, array.length - 1));
    }

    @Test
    void testBinarySearchRecursiveString() {
        String[] array = {"apple", "banana", "cherry"};
        assertEquals(1, BinarySearch.binarySearchRecursive(array, "banana", 0, array.length - 1));
        assertEquals(-1, BinarySearch.binarySearchRecursive(array, "date", 0, array.length - 1));
    }

    @Test
    void testBinarySearchAllIndices() {
        int[] array = {1, 2, 2, 2, 3};
        List<Integer> result = BinarySearch.binarySearchAllIndices(array, 2);
        assertEquals(List.of(1, 2, 3), result);

        result = BinarySearch.binarySearchAllIndices(array, 4);
        assertTrue(result.isEmpty());
    }

    @Test
    void testNullArray() {
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearchRecursive((int[]) null, 5, 0, 0));
        assertThrows(IllegalArgumentException.class, () -> BinarySearch.binarySearchRecursive((String[]) null, "test", 0, 0));
    }
}
