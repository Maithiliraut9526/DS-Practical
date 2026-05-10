import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root;

    // Insert into BST
    Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.data)
            root.left = insert(root.left, val);
        else if (val > root.data)
            root.right = insert(root.right, val);
        return root;
    }

    // Inorder Traversal (Left → Root → Right)
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Preorder Traversal (Root → Left → Right)
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder Traversal (Left → Right → Root)
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            bst.root = bst.insert(bst.root, val);
        }

        System.out.println("\nInorder Traversal:");
        bst.inorder(bst.root);

        System.out.println("\nPreorder Traversal:");
        bst.preorder(bst.root);

        System.out.println("\nPostorder Traversal:");
        bst.postorder(bst.root);

        sc.close();
    }
}
