public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Driver method to test the code
    public static void main(String[] args) {
        int[] data = {64, 25, 12, 22, 11};
        
        System.out.println("Before Sorting:");
        printArray(data);

        selectionSort(data);

        System.out.println("\nAfter Sorting:");
        printArray(data);
    }

    // Helper method to print the array
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}