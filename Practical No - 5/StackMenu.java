import java.util.Scanner;

class Stack {
    private static final int MAX = 6;   // maximum size of stack
    private int[] arr = new int[MAX];   // stack array
    private int top;                    // index of top element

    // Constructor
    public Stack() {
        top = -1; // stack is empty initially
    }

    // Push operation
    public void push(int x) {
        if (top == MAX - 1) {
            System.out.println("Stack Overflow");
        } else {
            arr[++top] = x;
            System.out.println(x + " pushed into stack");
        }
    }

    // Pop operation
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(arr[top--] + " popped from stack");
        }
    }

    // Display stack elements
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

public class StackMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack s = new Stack();
        int choice, value;

        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    value = sc.nextInt();
                    s.push(value);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    s.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
