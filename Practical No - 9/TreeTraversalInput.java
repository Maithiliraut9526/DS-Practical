import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}

public class TreeTraversalInput {
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

    // Inorder Traversal
    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }

    // Preorder Traversal
    void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    // Postorder Traversal
    void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeTraversalInput tree = new TreeTraversalInput();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " values:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            tree.root = tree.insert(tree.root, val);
        }

        System.out.println("\nInorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        sc.close();
    }
}
