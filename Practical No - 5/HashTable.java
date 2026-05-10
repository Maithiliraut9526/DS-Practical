import java.util.Scanner;

public class HashTable {
    static int size = 7;
    static int[] table = new int[size];

    // Hash function
    static int hash(int key) {
        return key % size;
    }

    // Insert
    static void insert(int key) {
        int i = hash(key);

        while (table[i] != -1 && table[i] != -2) {
            i = (i + 1) % size;
        }

        table[i] = key;
    }

    // Search
    static void search(int key) {
        int i = hash(key);
        int start = i;

        while (table[i] != -1) {
            if (table[i] == key) {
                System.out.println("Found at index " + i);
                return;
            }
            i = (i + 1) % size;
            if (i == start) break;
        }

        System.out.println("Not Found");
    }

    // Delete
    static void delete(int key) {
        int i = hash(key);
        int start = i;

        while (table[i] != -1) {
            if (table[i] == key) {
                table[i] = -2; // mark deleted
                System.out.println("Deleted");
                return;
            }
            i = (i + 1) % size;
            if (i == start) break;
        }

        System.out.println("Not Found");
    }

    // Display
    static void display() {
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize table
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }

        int choice;
        do {
            System.out.println("\n1.Insert 2.Search 3.Delete 4.Display 5.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    insert(sc.nextInt());
                    break;

                case 2:
                    System.out.print("Enter key: ");
                    search(sc.nextInt());
                    break;

                case 3:
                    System.out.print("Enter key: ");
                    delete(sc.nextInt());
                    break;

                case 4:
                    display();
                    break;
            }

        } while (choice != 5);

        sc.close();
    }
}