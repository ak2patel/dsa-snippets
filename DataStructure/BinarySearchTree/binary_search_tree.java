package DataStructure.BinarySearchTree;

/**
 * Binary Search Tree (BST) Implementation
 *
 * Supports insert, search, delete, and inorder traversal operations.
 *
 * Time Complexity:
 * - Insert: O(h)
 * - Search: O(h)
 * - Delete: O(h)
 * - Traversal: O(n)
 * where h is the height of the tree and n is the number of nodes.
 *
 * Space Complexity: O(h) due to recursion stack.
 */
public class binary_search_tree {
    // Node structure
    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // Constructor - initialize empty tree
    public binary_search_tree() {
        root = null;
    }

    // Insert a key into BST
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive helper for insert
    private Node insertRec(Node root, int key) {
        // Base case: create new node
        if (root == null) {
            root = new Node(key);
            return root;
        }
        // Go left if key is smaller
        if (key < root.key)
            root.left = insertRec(root.left, key);
        // Go right if key is larger
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    // Search for a key in BST
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // Recursive helper for search
    private boolean searchRec(Node root, int key) {
        // Base case: not found
        if (root == null)
            return false;
        // Found the key
        if (root.key == key)
            return true;
        // Search left or right based on key value
        return key < root.key ? searchRec(root.left, key) : searchRec(root.right, key);
    }

    // Delete a key from BST
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive helper for delete
    private Node deleteRec(Node root, int key) {
        // Base case: key not found
        if (root == null)
            return root;

        // Find the node to delete
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
        else {
            // Node found - handle deletion cases
            // Case 1: Node has only right child or no child
            if (root.left == null)
                return root.right;
            // Case 2: Node has only left child
            else if (root.right == null)
                return root.left;

            // Case 3: Node has two children
            // Replace with inorder successor (smallest in right subtree)
            root.key = minValue(root.right);
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Find minimum value in subtree (leftmost node)
    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Find maximum value in subtree (rightmost node)
    private int maxValue(Node root) {
        int maxv = root.key;
        while (root.right != null) {
            maxv = root.right.key;
            root = root.right;
        }
        return maxv;
    }

    // Inorder traversal (Left -> Root -> Right) - gives sorted order
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Visit left subtree
            System.out.print(root.key + " "); // Visit root
            inorderRec(root.right); // Visit right subtree
        }
    }

    // Preorder traversal (Root -> Left -> Right)
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " "); // Visit root
            preorderRec(root.left); // Visit left subtree
            preorderRec(root.right); // Visit right subtree
        }
    }

    // Postorder traversal (Left -> Right -> Root)
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left); // Visit left subtree
            postorderRec(root.right); // Visit right subtree
            System.out.print(root.key + " "); // Visit root
        }
    }

    // Example usage and testing
    public static void main(String[] args) {
        binary_search_tree bst = new binary_search_tree();

        // Insert nodes to create BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        // Display different traversals
        System.out.println("Inorder traversal of BST:");
        bst.inorder();

        System.out.println("Preorder traversal of BST:");
        bst.preorder();

        System.out.println("Postorder traversal of BST:");
        bst.postorder();

        // Test search functionality
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 25: " + bst.search(25));

        // Find min and max values
        System.out.println("Minimum value in BST: " + bst.minValue(bst.root));
        System.out.println("Maximum value in BST: " + bst.maxValue(bst.root));

        // Test delete functionality
        System.out.println("Delete 20");
        bst.delete(20);
        bst.inorder();
    }
}
