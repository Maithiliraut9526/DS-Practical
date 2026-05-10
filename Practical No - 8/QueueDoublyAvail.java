import java.util.Scanner;

class QueueDoublyAvail {
    static class Node {
        int data;
        Node prev, next;
    }

    Node front = null, rear = null, avail = null;

    Node getNode(int x) {
        Node temp;
        if (avail != null) {
            temp = avail;
            avail = avail.next;
        } else {
            temp = new Node();
        }
        temp.data = x;
        temp.prev = temp.next = null;
        return temp;
    }

    void freeNode(Node temp) {
        temp.next = avail;
        avail = temp;
    }

    void enqueue(int x) {
        Node n = getNode(x);
        if (rear == null) front = rear = n;
        else {
            rear.next = n;
            n.prev = rear;
            rear = n;
        }
    }

    int dequeue() {
        if (front == null) return -1;
        Node temp = front;
        int val = temp.data;

        front = front.next;
        if (front != null) front.prev = null;
        else rear = null;

        freeNode(temp);
        return val;
    }

    void display() {
        Node t = front;
        while (t != null) {
            System.out.print(t.data + " -> ");
            t = t.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueDoublyAvail q = new QueueDoublyAvail();
        int ch, val;

        do {
            System.out.println("\n1.Enqueue 2.Dequeue 3.Display 4.Exit");
            ch = sc.nextInt();

            switch (ch) {
                case 1: val = sc.nextInt(); q.enqueue(val); break;
                case 2: System.out.println(q.dequeue()); break;
                case 3: q.display(); break;
            }
        } while (ch != 4);
    }
}