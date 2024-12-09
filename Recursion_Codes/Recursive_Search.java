import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    /**
     * Performs a recursive binary search on a sorted array of integers.
     *
     * @param arr   The sorted array of integers.
     * @param target The target value to search for.
     * @param low   The starting index of the search range.
     * @param high  The ending index of the search range.
     * @return The index of the target value if found, or -1 if the target is not in the array.
     */
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        // Error handling for null or empty array
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        // Base case: range is invalid
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high);
        }
    }

    /**
     * Performs a binary search on a sorted array of strings.
     *
     * @param arr    The sorted array of strings.
     * @param target The target value to search for.
     * @param low    The starting index of the search range.
     * @param high   The ending index of the search range.
     * @return The index of the target value if found, or -1 if the target is not in the array.
     */
    public static int binarySearchRecursive(String[] arr, String target, int low, int high) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        int comparison = target.compareTo(arr[mid]);

        if (comparison == 0) {
            return mid;
        } else if (comparison < 0) {
            return binarySearchRecursive(arr, target, low, mid - 1);
        } else {
            return binarySearchRecursive(arr, target, mid + 1, high);
        }
    }

    /**
     * Finds all indices of the target value in a sorted array.
     *
     * @param arr    The sorted array of integers.
     * @param target The target value to search for.
     * @return A list of indices where the target value appears, or an empty list if not found.
     */
    public static List<Integer> binarySearchAllIndices(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();

        int index = binarySearchRecursive(arr, target, 0, arr.length - 1);
        if (index == -1) {
            return result; // Target not found
        }

        // Find all occurrences to the left
        int left = index;
        while (left >= 0 && arr[left] == target) {
            result.add(left);
            left--;
        }

        // Find all occurrences to the right
        int right = index + 1;
        while (right < arr.length && arr[right] == target) {
            result.add(right);
            right++;
        }

        result.sort(Integer::compareTo); // Ensure indices are sorted
        return result;
    }

    public static void main(String[] args) {
        // Integer binary search
        int[] intArray = {1, 2, 2, 2, 3, 4, 5};
        System.out.println(binarySearchRecursive(intArray, 2, 0, intArray.length - 1)); // Output: Index of 2 (varies)

        // String binary search
        String[] stringArray = {"apple", "banana", "cherry", "date", "fig", "grape"};
        System.out.println(binarySearchRecursive(stringArray, "cherry", 0, stringArray.length - 1)); // Output: 2

        // Find all indices
        System.out.println(binarySearchAllIndices(intArray, 2)); // Output: [1, 2, 3]
    }
}
