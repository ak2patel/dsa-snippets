package DataStructure.BinarySearchTree;

import DataStructure.BinarySearchTree.binary_search_tree.Node;

/**
 * Validates if a binary tree is a valid Binary Search Tree (BST)
 */
public class ValidateBST {

    /**
     * Check if the tree is a valid BST
     * 
     * @param root - root of the tree
     * @return true if valid BST, false otherwise
     */
    public boolean isValidBST(Node root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper method - checks if node value is within valid range
     * 
     * @param node - current node
     * @param min  - minimum allowed value
     * @param max  - maximum allowed value
     */
    public boolean helper(Node node, long min, long max) {
        // Empty tree is valid
        if (node == null)
            return true;

        // Check if current node violates BST rule
        if (node.key <= min || node.key >= max)
            return false;

        // Check left subtree (values < current) and right subtree (values > current)
        return helper(node.left, min, node.key) && helper(node.right, node.key, max);
    }
}