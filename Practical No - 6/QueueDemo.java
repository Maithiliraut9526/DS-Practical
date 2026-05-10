import java.util.Scanner;

class Queue {
    private static final int SIZE = 5;
    private int[] arr = new int[SIZE];
    private int front, rear;  //pointers to track front and rear elemtns

    public Queue() {
        front = -1;
        rear = -1;
    }

    public void enqueue(int value) {
        if (rear == SIZE - 1) {
            System.out.println("Queue Overflow! Cannot insert " + value);
            return;
        }
        if (front == -1) front = 0;  // if the queue is empty set the front = 0
        rear++;
        arr[rear] = value;
        System.out.println("Inserted " + value + " at position " + rear);
    }

    public void dequeue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue Underflow! Nothing to delete.");
            return;
        }
        System.out.println("Deleted element " + arr[front] + " from position " + front);
        front++;

        if (front > rear) {  //if front goes beyound rear reset both to the -1
            front = -1;
            rear = -1;
        }
    }

    public void display() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.println("Queue elements (with positions):");
        for (int i = front; i <= rear; i++) {
            System.out.println("Index " + i + " -> " + arr[i]);
        }
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue q = new Queue();
        Scanner sc = new Scanner(System.in);
        int choice, value;  //store menu choice and input value

        do {
            System.out.println("\n--- Queue Menu ---");
            System.out.println("1. Enqueue (Insert)");
            System.out.println("2. Dequeue (Delete)");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            if(choice == 1) {
                System.out.print("Enter value to insert: ");
                value = sc.nextInt();
                q.enqueue(value);
            } else if (choice == 2) {
                q.dequeue();
            } else if (choice == 3) {
                q.display();
            } else if (choice == 4) {
                System.out.println("Exiting program...");
            } else {
                System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
