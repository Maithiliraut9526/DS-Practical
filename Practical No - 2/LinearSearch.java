import java.util.Scanner;

public class LinearSearch{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] a = new int[n]; // array of size n

        // Input elements
        System.out.println("Enter " + n + " elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input key to search
        System.out.print("Input the key to search: ");
        int key = sc.nextInt();

        // Linear search
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                System.out.println("The key " + key + " is found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Not found");
        }

        sc.close();
    }
}
