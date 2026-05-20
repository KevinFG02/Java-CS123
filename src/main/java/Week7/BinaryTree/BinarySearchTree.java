package Week7.BinaryTree;

public class BinarySearchTree {
    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public void add(int... elements) {
        for (int elem : elements) {
            add(elem);
        }
    }

    public void add(int element) {
        if (root == null) {
            root = new Node(element);
            size++;
        }
        else {
            add(element, root);
        }
    }

    private void add(int element, Node current) {
        if (current.data == element) {
            return;
        }
        else if (current.data > element)
        {
            if (current.left == null) {
                current.left = new Node(element);
                size++;
            }
            else {
                add(element, current.left);
            }
        }
        else {
            if (current.right == null) {
                current.right = new Node(element);
                size++;
            }
            else {
                add(element, current.right);
            }
        }
    }

    public boolean contains(int search){
        return contains(root, search);
    }

    private boolean contains(Node current, int search){
        if(current == null) return false;

        if(current.data == search){
            return true;
        } else if(current.data < search){
            return contains(current.right, search);
        } else {
            return contains(current.left, search);
        }
    }

    public boolean remove(){
        return false;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return false;
    }

    public int findMin(){
        return findMin(root);
    }

    private int findMin(Node current){
        if(current == null){
            return 0;
        }

        if(current.left != null){
            return findMin(current.left);
        } else {
            return current.data;
        }
    }

    public int findMax(){
        return findMax(root);
    }

    private int findMax(Node current){
        if(current == null){
            return 0;
        }

        if(current.right != null){
            return findMax(current.right);
        } else {
            return current.data;
        }
    }

    public int iterativeMin(){
        Node current = root;

        while(current.left != null){
            current = current.left;
        }

        return current.data;
    }

    public int iterativeMax(){
        Node current = root;

        while(current.right != null){
            current = current.right;
        }

        return current.data;
    }

    public boolean isRoot(int search){
        return root.data == search;
    }

    public boolean isLeaf(int search){
        if(contains(search)){
            return isLeaf(root, search);
        } else {
            return false;
        }
    }

    private boolean isLeaf(Node current, int search){
        if(current.data == search){
            if(current.left == null && current.right == null){
                return true;
            } else {
                return false;
            }
        } else {
            if(current.data > search){
                return isLeaf(current.left, search);
            } else {
                return isLeaf(current.right, search);
            }
        }
    }

    public boolean isInternal(int search){
        if(contains(search)){
            return isInternal(root, search);
        } else {
            return false;
        }
    }

    private boolean isInternal(Node current,int search){
        if(current.data == search){
            if(current.left == null && current.right == null){
                return false;
            } else {
                return true;
            }
        } else {
            if(current.data > search){
                return isInternal(current.left, search);
            } else {
                return isInternal(current.right, search);
            }
        }
    }

    public String toString() {
        return "Root: " + root + ", size: " + size;
    }

    public class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data){
            this.data = data;
        }

        public String toString() {
            return String.valueOf(data);
        }
    }
}
