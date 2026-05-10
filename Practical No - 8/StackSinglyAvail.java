import java.util.Scanner;

class StackSinglyAvail {
    static class Node {
        int data;
        Node next;
    }

    Node top = null, avail = null;

    Node getNode(int x) {
        Node temp;
        if (avail != null) {
            temp = avail;
            avail = avail.next;
        } else {
            temp = new Node();
        }
        temp.data = x;
        temp.next = null;
        return temp;
    }

    void freeNode(Node temp) {
        temp.next = avail;
        avail = temp;
    }

    void push(int x) {
        Node n = getNode(x);
        n.next = top;
        top = n;
    }

    int pop() {
        if (top == null) return -1;
        Node temp = top;
        int val = temp.data;
        top = top.next;
        freeNode(temp);
        return val;
    }

    void display() {
        Node t = top;
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackSinglyAvail s = new StackSinglyAvail();
        int ch, val;

        do {
            System.out.println("\n1.Push 2.Pop 3.Display 4.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1: val = sc.nextInt(); s.push(val); break;
                case 2: System.out.println(s.pop()); break;
                case 3: s.display(); break;
            }
        } while (ch != 4);
    }
}