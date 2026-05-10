import java.util.Scanner;

public class BinarySearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n]; // array of size n

        // Input sorted elements
        System.out.println("Enter " + n + " sorted elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input key to search
        System.out.print("Input the key to search: ");
        int key = sc.nextInt();

        // Binary search
        int low = 0, high = n - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (a[mid] == key) {
                System.out.println("Found at index " + mid);
                found = true;
                break;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }

        sc.close();
    }
}
