import java.util.Scanner;

public class OperationOnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a = new int[20]; // bigger size to allow insertion
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Traversal
        System.out.println("Traversal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // Insertion
        System.out.print("Enter position for insertion: ");
        int pos = sc.nextInt();
        System.out.print("Enter the value to insert: ");
        int value = sc.nextInt();

        for (int i = n; i > pos; i--) {
            a[i] = a[i - 1];
        } 
        a[pos] = value;
        n++;

        System.out.println("After insertion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // Deletion
        System.out.print("Enter position to delete: ");
        int delpos = sc.nextInt();
        for (int i = delpos; i < n - 1; i++) {
            a[i] = a[i + 1];
        }
        n--;

        //ehile performing the deletion opration if there is 4 elemet then 5 elements are created in the list or the array if we want to delete it use n--

        System.out.println("After deletion: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        // Searching
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (a[i] == key) {
                System.out.println("Found at position " + i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Not found");
        }

        // Updating
        System.out.print("Enter position to update: ");
        int upPos = sc.nextInt();
        System.out.print("Enter new value: ");
        int newValue = sc.nextInt();
        a[upPos] = newValue;

        System.out.println("After updating: ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        sc.close();
    }
}
