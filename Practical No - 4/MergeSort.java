import java.util.Scanner;

public class MergeSort {

    // Merge two sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {
        int i = left;      
        int j = mid + 1;   
        int k = 0;         

        int[] temp = new int[right - left + 1]; 

        // Merge elements into temp[]
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // Copy remaining elements from left half
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // Copy remaining elements from right half
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy back to original array
        for (int x = 0; x < k; x++) {
            arr[left + x] = temp[x];
        }
    }

    // Recursive merge sort
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);       // sort left half
            mergeSort(arr, mid + 1, right);  // sort right half

            merge(arr, left, mid, right);    // merge halves
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Perform merge sort
        mergeSort(arr, 0, n - 1);

        // Print sorted array
        System.out.println("Sorted array: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
