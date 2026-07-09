package Week11.Final.bst;

public class BST {

    private TreeNode root;

    public BST() {
        //do nothing...
        root = null;
    }

    public void add(int value) {
        root = addRec(root, value);
    }

    private TreeNode addRec(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);
        if (value < node.data)
            node.left  = addRec(node.left,  value);
        else if (value > node.data)
            node.right = addRec(node.right, value);
        // duplicate values are ignored
        return node;
    }

    // toString() / printSideways() — provided, do not modify
    public void printSideways() {
        if (root == null) {
            System.out.println("Empty Tree");
        } else {
            System.out.println(root.toString());
        }
    }

    // -------------------------------------------------------
    // YOUR CODE BELOW — implement all three methods
    // -------------------------------------------------------

    /**
     * Returns the total number of nodes in the tree.
     *
     * REQUIREMENT: you must solve this recursively using a
     * private helper method.  Do NOT add a size field to the
     * class and increment/decrement it in add().
     *
     * Hint: size = (size of left subtree) + (size of right subtree) + 1
     */
    public int size() {
        // TODO
        if(root == null){
            return 0;
        }

        return sizeRec(root, 1);
    }

    private int sizeRec(TreeNode node, int counter){
        if(node == null){
            return counter;
        } else {
            counter++;
            counter = sizeRec(node.left, counter);
            counter = sizeRec(node.right, counter);
        }

        return counter;
    }

    /**
     * Iterative search.
     * Returns true if value exists in the BST, false otherwise.
     *
     * Use a local variable (e.g. "current") to walk the tree.
     * Do NOT modify the root field.
     */
    public boolean contains(int value) {
        // TODO
        TreeNode current = root;

        while(current != null){

            if(current.data == value){
                return true;
            } else if(current.data > value){
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    /**
     * Recursive search.
     * Returns true if value exists in the BST, false otherwise.
     *
     * Implement a private helper method containsRec(TreeNode node, int value)
     * and call it from here.
     */
    public boolean containsRec(int value) {
        // TODO
        if(root == null){
            return false;
        }

        return containsRec(root, value);
    }

    private boolean containsRec(TreeNode node, int value){
        if(node == null) return false;

        if(node.data == value){
            return true;
        } else if(node.data > value){
            return containsRec(node.left, value);
        } else {
            return containsRec(node.right, value);
        }
    }

    // -------------------------------------------------------
    // TreeNode (provided — do not modify)
    // -------------------------------------------------------
    private class TreeNode {
        private int data;
        private TreeNode left, right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
            if(right!=null) {
                right.toString(new StringBuilder().append(prefix).append(isTail ? "│   " : "    "), false, sb);
            }
            sb.append(prefix).append(isTail ? "└── " : "┌── ").append(data).append("\n");
            if(left!=null) {
                left.toString(new StringBuilder().append(prefix).append(isTail ? "    " : "│   "), true, sb);
            }
            return sb;
        }

        public String toString() {
            return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
        }
    }
}