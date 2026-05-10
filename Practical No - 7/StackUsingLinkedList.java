import java.util.Scanner;

class StackUsingLinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top = null;

    void push(int value) {
        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;

        System.out.println(value + " pushed to stack");
    }

    void pop() {
        if (top == null) {
            System.out.println("Stack underflow");
            return;
        }

        System.out.println(top.data + " popped from stack");
        top = top.next;
    }

    void peek() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element is " + top.data);
        }
    }

    void display() {
        Node temp = top;

        if (temp == null) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackUsingLinkedList stack = new StackUsingLinkedList();

        int choice, value;

        do {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    value = sc.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    stack.peek();
                    break;

                case 4:
                    stack.display();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}